package codeVita;

import java.util.*;

public class MainF {

    private static final double EPS = 1e-9;

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        static Point create(double x, double y) {
            double roundedX = Math.round(x * 100.0) / 100.0;
            double roundedY = Math.round(y * 100.0) / 100.0;
            return new Point(roundedX, roundedY);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return Math.abs(point.x - x) < EPS && Math.abs(point.y - y) < EPS;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(x) * 31 + Double.hashCode(y);
        }
    }

    static class Stick {
        Point p1, p2;

        Stick(int x1, int y1, int x2, int y2) {
            this.p1 = new Point(x1, y1);
            this.p2 = new Point(x2, y2);
        }

        double length() {
            return distance(p1, p2);
        }
    }

    static List<Stick> sticks;
    static Map<Integer, List<Integer>> adj;
    static Map<Integer, List<Point>> stickIntersections;
    static List<Integer> polygonStickIndices = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sticks = new ArrayList<>();
        adj = new HashMap<>();
        stickIntersections = new HashMap<>();

        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
            stickIntersections.put(i, new ArrayList<>());
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            sticks.add(new Stick(x1, y1, x2, y2));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Point p = getIntersection(sticks.get(i), sticks.get(j));
                if (p != null) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                    stickIntersections.get(i).add(p);
                    stickIntersections.get(j).add(p);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, new Stack<>(), visited)) {
                    break;
                }
            }
        }

        if (polygonStickIndices == null) {
            System.out.print("Abandoned");
            return;
        }

        List<Point> polygonVertices = getPolygonVertices();
        double areaKalyan = shoelaceArea(polygonVertices);

        double lengthComputer = 0;
        Set<Integer> polygonSet = new HashSet<>(polygonStickIndices);

        Map<Integer, List<Point>> verticesOnStick = new HashMap<>();
        for(int idx : polygonSet) verticesOnStick.put(idx, new ArrayList<>());

        for(Point v : polygonVertices) {
            for(int stickIdx : polygonSet) {
                if(pointIsOnStick(v, sticks.get(stickIdx))) {
                    verticesOnStick.get(stickIdx).add(v);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Stick s = sticks.get(i);
            double L_total = s.length();
            if (!polygonSet.contains(i)) {
                lengthComputer += L_total;
            } else {
                List<Point> verts = verticesOnStick.get(i);
                if (verts.size() >= 2) {
                    Point v1 = verts.get(0);
                    Point v2 = verts.get(1);
                    double L_kalyan = distance(v1, v2);
                    lengthComputer += (L_total - L_kalyan);
                }
            }
        }

        double areaComputer = (lengthComputer * lengthComputer) / (4 * Math.PI);

        if (areaKalyan > areaComputer + EPS) {
            System.out.print("Kalyan");
        } else {
            System.out.print("Computer");
        }

        sc.close();
    }

    private static boolean dfs(int u, int parent, Stack<Integer> pathStack, Set<Integer> visited) {
        pathStack.push(u);
        visited.add(u);

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (pathStack.contains(v)) {
                polygonStickIndices = new ArrayList<>();
                polygonStickIndices.add(v);
                Stack<Integer> tempStack = new Stack<>();
                while (pathStack.peek() != v) {
                    tempStack.push(pathStack.pop());
                }
                while (!tempStack.isEmpty()) {
                    polygonStickIndices.add(tempStack.pop());
                }
                return true;
            }
            if (!visited.contains(v)) {
                if (dfs(v, u, pathStack, visited)) {
                    return true;
                }
            }
        }
        pathStack.pop();
        return false;
    }

    private static List<Point> getPolygonVertices() {
        Set<Point> uniqueVertices = new HashSet<>();

        for (int stickIdx : polygonStickIndices) {
            for(Point p : stickIntersections.get(stickIdx)) {
                for (int otherIdx : polygonStickIndices) {
                    if (stickIdx == otherIdx) continue;
                    if (pointIsOnStick(p, sticks.get(otherIdx))) {
                        uniqueVertices.add(p);
                    }
                }
            }
        }

        List<Point> orderedVertices = new ArrayList<>(uniqueVertices);
        if (orderedVertices.isEmpty()) {
            return orderedVertices;
        }

        Point start = orderedVertices.get(0);
        List<Point> finalVertices = new ArrayList<>();
        finalVertices.add(start);

        Point current = start;
        Set<Point> added = new HashSet<>();
        added.add(start);

        while (finalVertices.size() < uniqueVertices.size()) {
            Point next = null;
            for(Point candidate : orderedVertices) {
                if (added.contains(candidate)) continue;

                for (int stickIdx : polygonStickIndices) {
                    if (pointIsOnStick(current, sticks.get(stickIdx)) &&
                            pointIsOnStick(candidate, sticks.get(stickIdx))) {
                        next = candidate;
                        break;
                    }
                }
                if (next != null) break;
            }
            if (next != null) {
                finalVertices.add(next);
                added.add(next);
                current = next;
            } else {
                break;
            }
        }

        return finalVertices;
    }

    private static double shoelaceArea(List<Point> vertices) {
        double area = 0.0;
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % n);
            area += (p1.x * p2.y) - (p2.x * p1.y);
        }
        return 0.5 * Math.abs(area);
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private static boolean pointIsOnStick(Point p, Stick s) {
        double d1 = distance(s.p1, p);
        double d2 = distance(p, s.p2);
        double totalLen = s.length();
        return Math.abs((d1 + d2) - totalLen) < EPS;
    }

    private static Point getIntersection(Stick s1, Stick s2) {
        double a1 = s1.p2.y - s1.p1.y;
        double b1 = s1.p1.x - s1.p2.x;
        double c1 = a1 * s1.p1.x + b1 * s1.p1.y;

        double a2 = s2.p2.y - s2.p1.y;
        double b2 = s2.p1.x - s2.p2.x;
        double c2 = a2 * s2.p1.x + b2 * s2.p1.y;

        double det = a1 * b2 - a2 * b1;

        if (Math.abs(det) < EPS) {
            return null;
        }

        double x = (b2 * c1 - b1 * c2) / det;
        double y = (a1 * c2 - a2 * c1) / det;

        Point p = Point.create(x, y);

        if (pointIsOnStick(p, s1) && pointIsOnStick(p, s2)) {
            return p;
        }

        return null;
    }
}
