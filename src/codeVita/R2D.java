package codeVita;

import java.util.*;

public class R2D {

    static class Face {
        char id;
        String content;
        // Stores the 3D corner ID (0-7) for the 4 positions:
        // 0:TopLeft, 1:TopRight, 2:BottomLeft, 3:BottomRight
        int[] corners = new int[4];
        int r, c;

        public Face(char id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] grid = new char[4][4];
        List<Face> faces = new ArrayList<>();

        // 1. Read Grid and Identify Faces
        for (int i = 0; i < 4; i++) {
            String line = sc.next();
            for (int j = 0; j < 4; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] != '.') {
                    faces.add(new Face(grid[i][j], i, j));
                }
            }
        }

        // 2. Read Character String and Assign to Faces
        // The string is ordered by the scan order (which faces list preserves)
        String allChars = sc.next();
        for (int i = 0; i < faces.size(); i++) {
            faces.get(i).content = allChars.substring(i * 4, i * 4 + 4);
        }

        // 3. Read Query
        String query = sc.next();

        // Map for quick lookup
        Map<Character, Face> faceMap = new HashMap<>();
        for (Face f : faces) faceMap.put(f.id, f);

        // 4. BFS to Map 2D Faces to 3D Corners
        // We use an 8-corner system (0-7 bitmask logic: x,y,z).
        // Start with the first face found in scan order.
        Face start = faces.get(0);

        // Arbitrarily map the start face to the "Front" face position
        // TL=4(100), TR=5(101), BL=6(110), BR=7(111)
        start.corners[0] = 4;
        start.corners[1] = 5;
        start.corners[2] = 6;
        start.corners[3] = 7;

        Queue<Face> q = new LinkedList<>();
        q.add(start);
        Set<Character> visited = new HashSet<>();
        visited.add(start.id);

        // Directions: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Face curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            // Current face corners
            int u = curr.corners[0]; // TL
            int v = curr.corners[1]; // TR
            int x = curr.corners[2]; // BL
            int y = curr.corners[3]; // BR

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && grid[nr][nc] != '.') {
                    char neighborId = grid[nr][nc];
                    if (!visited.contains(neighborId)) {
                        visited.add(neighborId);
                        Face next = faceMap.get(neighborId);

                        // Logic to fold/zip edges based on direction
                        if (k == 0) { // UP
                            // Neighbor is above. Shared edge: Curr Top (u, v) -> Next Bottom
                            next.corners[2] = u; // Next BL
                            next.corners[3] = v; // Next BR
                            // Find Next TL: neighbor of u, not x (curr BL), not v (curr TR/Next BR)
                            next.corners[0] = getOpposite(u, x, v);
                            // Find Next TR: neighbor of v, not y (curr BR), not u (curr TL/Next BL)
                            next.corners[1] = getOpposite(v, y, u);
                        } else if (k == 1) { // DOWN
                            // Neighbor is below. Shared edge: Curr Bottom (x, y) -> Next Top
                            next.corners[0] = x; // Next TL
                            next.corners[1] = y; // Next TR
                            next.corners[2] = getOpposite(x, u, y); // Next BL
                            next.corners[3] = getOpposite(y, v, x); // Next BR
                        } else if (k == 2) { // LEFT
                            // Neighbor is left. Shared edge: Curr Left (u, x) -> Next Right
                            next.corners[1] = u; // Next TR
                            next.corners[3] = x; // Next BR
                            next.corners[0] = getOpposite(u, v, x); // Next TL
                            next.corners[2] = getOpposite(x, y, u); // Next BL
                        } else if (k == 3) { // RIGHT
                            // Neighbor is right. Shared edge: Curr Right (v, y) -> Next Left
                            next.corners[0] = v; // Next TL
                            next.corners[2] = y; // Next BL
                            next.corners[1] = getOpposite(v, u, y); // Next TR
                            next.corners[3] = getOpposite(y, x, v); // Next BR
                        }
                        q.add(next);
                    }
                }
            }
        }

        // 5. Process Query
        StringBuilder result = new StringBuilder();
        Face f1 = faceMap.get(query.charAt(0));
        Face f2 = faceMap.get(query.charAt(1));
        Face f3 = faceMap.get(query.charAt(2));

        // Find the single corner ID shared by all three faces
        int commonCornerId = -1;
        outerLoop:
        for (int c1 : f1.corners) {
            for (int c2 : f2.corners) {
                if (c1 == c2) {
                    for (int c3 : f3.corners) {
                        if (c1 == c3) {
                            commonCornerId = c1;
                            break outerLoop;
                        }
                    }
                }
            }
        }

        // Extract characters associated with that corner ID
        result.append(getCharAtCorner(f1, commonCornerId));
        result.append(getCharAtCorner(f2, commonCornerId));
        result.append(getCharAtCorner(f3, commonCornerId));

        System.out.print(result.toString());
    }

    // Helper to find the 3rd neighbor of a corner on a cube
    // A corner has 3 neighbors (differing by 1 bit).
    // Given a corner and 2 known neighbors, return the 3rd.
    static int getOpposite(int corner, int n1, int n2) {
        for (int i = 0; i < 8; i++) {
            // Check if 'i' is adjacent to 'corner' (1 bit difference)
            if (Integer.bitCount(corner ^ i) == 1) {
                if (i != n1 && i != n2) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Helper to get the character from the face that corresponds to the specific corner ID
    static char getCharAtCorner(Face f, int cornerId) {
        for (int i = 0; i < 4; i++) {
            if (f.corners[i] == cornerId) {
                return f.content.charAt(i);
            }
        }
        return '?';
    }
}