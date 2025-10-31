package codeVita;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MainE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        char[][][] initialState = new char[6][N][N];
        for (int f = 0; f < 6; f++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    initialState[f][r][c] = sc.next().charAt(0);
                }
            }
        }

        sc.nextLine();
        String[] instructions = new String[K];
        for (int i = 0; i < K; i++) {
            instructions[i] = sc.nextLine();
        }

        String foundInstruction = null;
        boolean isFaulty = false;

        for (int j = 0; j < K; j++) {
            String instructionToSkip = instructions[j];

            Cube cube = new Cube(initialState, N);
            for (int i = 0; i < K; i++) {
                if (i == j) continue;
                cube.apply(instructions[i]);
            }

            if (cube.isAnyFaceSolved()) {
                foundInstruction = instructionToSkip;
                isFaulty = false;
                break;
            }

            if (cube.isAnyFaceAlmostSolved()) {
                foundInstruction = instructionToSkip;
                isFaulty = true;
                break;
            }
        }

        if (foundInstruction != null) {
            if (isFaulty) {
                System.out.println("Faulty");
            }
            System.out.println(foundInstruction);
        } else {
            System.out.println("Not Possible");
        }

        sc.close();
    }
}

class Cube {
    int N;
    char[][][] faces;

    public Cube(char[][][] initialState, int N) {
        this.N = N;
        this.faces = new char[6][N][N];
        for (int f = 0; f < 6; f++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    this.faces[f][r][c] = initialState[f][r][c];
                }
            }
        }
    }

    public void apply(String instruction) {
        String[] parts = instruction.split(" ");

        if (parts.length == 2) {
            handleWholeCubeRotation(parts[0], parts[1]);
        } else if (parts.length == 3) {
            handleSliceMove(parts[0], Integer.parseInt(parts[1]) - 1, parts[2]);
        }
    }

    private void handleWholeCubeRotation(String type, String dir) {
        if (type.equals("turn")) {
            if (dir.equals("left")) {
                char[][] temp = faces[3];
                faces[3] = faces[5];
                faces[5] = faces[1];
                faces[1] = faces[4];
                faces[4] = temp;
                rotateFace(2, true);
                rotateFace(0, false);
            } else {
                char[][] temp = faces[3];
                faces[3] = faces[4];
                faces[4] = faces[1];
                faces[1] = faces[5];
                faces[5] = temp;
                rotateFace(2, false);
                rotateFace(0, true);
            }
        } else if (type.equals("rotate")) {
            if (dir.equals("front")) {
                char[][] temp = faces[3];
                faces[3] = faces[2];
                faces[2] = faces[1];
                faces[1] = faces[0];
                faces[0] = temp;
                rotateFace(4, true);
                rotateFace(5, false);
            } else if (dir.equals("back")) {
                char[][] temp = faces[3];
                faces[3] = faces[0];
                faces[0] = faces[1];
                faces[1] = faces[2];
                faces[2] = temp;
                rotateFace(4, false);
                rotateFace(5, true);
            } else if (dir.equals("left")) {
                char[][] temp = faces[2];
                faces[2] = faces[5];
                faces[5] = faces[0];
                faces[0] = faces[4];
                faces[4] = temp;
                rotateFace(3, false);
                rotateFace(1, true);
            } else {
                char[][] temp = faces[2];
                faces[2] = faces[4];
                faces[4] = faces[0];
                faces[0] = faces[5];
                faces[5] = temp;
                rotateFace(3, true);
                rotateFace(1, false);
            }
        }
    }

    private void handleSliceMove(String faceName, int num, String dir) {
        char[] temp = new char[N];
        char[] temp2 = new char[N];

        if (faceName.equals("top") || faceName.equals("base")) {
            if (dir.equals("left") || dir.equals("right")) {
                int R = num;
                for (int c = 0; c < N; c++) temp[c] = faces[3][R][c];
                if (dir.equals("left")) {
                    for (int c = 0; c < N; c++) faces[3][R][c] = faces[5][R][c];
                    for (int c = 0; c < N; c++) faces[5][R][c] = faces[1][R][c];
                    for (int c = 0; c < N; c++) faces[1][R][c] = faces[4][R][c];
                    for (int c = 0; c < N; c++) faces[4][R][c] = temp[c];
                } else {
                    for (int c = 0; c < N; c++) faces[3][R][c] = faces[4][R][c];
                    for (int c = 0; c < N; c++) faces[4][R][c] = faces[1][R][c];
                    for (int c = 0; c < N; c++) faces[1][R][c] = faces[5][R][c];
                    for (int c = 0; c < N; c++) faces[5][R][c] = temp[c];
                }
            } else {
                int C = num;
                for (int r = 0; r < N; r++) temp[r] = faces[2][r][C];
                if (dir.equals("down")) {
                    for (int r = 0; r < N; r++) faces[2][r][C] = faces[1][N-1-r][N-1-C];
                    for (int r = 0; r < N; r++) faces[1][N-1-r][N-1-C] = faces[0][r][C];
                    for (int r = 0; r < N; r++) faces[0][r][C] = faces[3][r][C];
                    for (int r = 0; r < N; r++) faces[3][r][C] = temp[r];
                } else {
                    for (int r = 0; r < N; r++) faces[2][r][C] = faces[3][r][C];
                    for (int r = 0; r < N; r++) faces[3][r][C] = faces[0][r][C];
                    for (int r = 0; r < N; r++) faces[0][r][C] = faces[1][N-1-r][N-1-C];
                    for (int r = 0; r < N; r++) faces[1][N-1-r][N-1-C] = temp[r];
                }
            }
        } else if (faceName.equals("front") || faceName.equals("back")) {
            if (dir.equals("left") || dir.equals("right")) {
                int R = num;
                for (int i = 0; i < N; i++) temp[i] = faces[2][N-1-R][i];
                if (dir.equals("left")) {
                    for (int i = 0; i < N; i++) faces[2][N-1-R][i] = faces[5][i][R];
                    for (int i = 0; i < N; i++) faces[5][i][R] = faces[0][R][N-1-i];
                    for (int i = 0; i < N; i++) faces[0][R][N-1-i] = faces[4][N-1-i][N-1-R];
                    for (int i = 0; i < N; i++) faces[4][N-1-i][N-1-R] = temp[i];
                } else {
                    for (int i = 0; i < N; i++) temp[i] = faces[2][N-1-R][i];
                    for (int i = 0; i < N; i++) faces[2][N-1-R][i] = faces[4][N-1-i][N-1-R];
                    for (int i = 0; i < N; i++) faces[4][N-1-i][N-1-R] = faces[0][R][N-1-i];
                    for (int i = 0; i < N; i++) faces[0][R][N-1-i] = faces[5][i][R];
                    for (int i = 0; i < N; i++) faces[5][i][R] = temp[i];
                }
            } else {
                int C = num;
                for (int r = 0; r < N; r++) temp[r] = faces[2][r][C];
                if (dir.equals("down")) {
                    for (int r = 0; r < N; r++) faces[2][r][C] = faces[1][N-1-r][N-1-C];
                    for (int r = 0; r < N; r++) faces[1][N-1-r][N-1-C] = faces[0][r][C];
                    for (int r = 0; r < N; r++) faces[0][r][C] = faces[3][r][C];
                    for (int r = 0; r < N; r++) faces[3][r][C] = temp[r];
                } else {
                    for (int r = 0; r < N; r++) faces[2][r][C] = faces[3][r][C];
                    for (int r = 0; r < N; r++) faces[3][r][C] = faces[0][r][C];
                    for (int r = 0; r < N; r++) faces[0][r][C] = faces[1][N-1-r][N-1-C];
                    for (int r = 0; r < N; r++) faces[1][N-1-r][N-1-C] = temp[r];
                }
            }
        } else if (faceName.equals("left") || faceName.equals("right")) {
            if (dir.equals("up") || dir.equals("down")) {
                int C = num;
                int R = faceName.equals("left") ? (N-1-C) : C;

                String newDir = dir.equals("up") ? "right" : "left";
                if(faceName.equals("right")) {
                    newDir = dir.equals("up") ? "left" : "right";
                }

                handleSliceMove("front", R, newDir);

            } else {
                int R = num;
                handleSliceMove("top", R, dir);
            }
        }
    }

    private void rotateFace(int faceIndex, boolean clockwise) {
        char[][] original = faces[faceIndex];
        char[][] rotated = new char[N][N];
        if (clockwise) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    rotated[r][c] = original[N - 1 - c][r];
                }
            }
        } else {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    rotated[r][c] = original[c][N - 1 - r];
                }
            }
        }
        faces[faceIndex] = rotated;
    }

    public boolean isAnyFaceSolved() {
        for (int f = 0; f < 6; f++) {
            char color = faces[f][0][0];
            boolean solved = true;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (faces[f][r][c] != color) {
                        solved = false;
                        break;
                    }
                }
                if (!solved) break;
            }
            if (solved) return true;
        }
        return false;
    }

    public boolean isAnyFaceAlmostSolved() {
        for (int f = 0; f < 6; f++) {
            Map<Character, Integer> counts = new HashMap<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    char color = faces[f][r][c];
                    counts.put(color, counts.getOrDefault(color, 0) + 1);
                }
            }

            if (counts.size() == 2) {
                boolean hasOne = false;
                boolean hasAlmostAll = false;
                for (int count : counts.values()) {
                    if (count == 1) hasOne = true;
                    if (count == N * N - 1) hasAlmostAll = true;
                }
                if (hasOne && hasAlmostAll) return true;
            }
        }
        return false;
    }
}
