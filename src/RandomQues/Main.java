package RandomQues;

import java.util.*;

public class Main {
    static int N;
    static double[][] vertices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        vertices = new double[N][2];
        for (int i = 0; i < N; i++) {
            vertices[i][0] = sc.nextDouble();
            vertices[i][1] = sc.nextDouble();
        }

        double maxPossibleH = computeMaxPossibleH(vertices);

        double answer = 0.0;
        for (double H = 0.1; H <= maxPossibleH + 1e-8; H += 0.1) {
            double[][] shrinked = offsetPolygon(vertices, H);
            if (shrinked == null) continue;
            if (!isValidPolygon(shrinked)) continue;
            double area = polygonArea(shrinked);
            if (area < 1e-8) continue;
            double vol = area * H;
            if (vol > answer) answer = vol;
        }
        System.out.printf("%.2f", answer);
    }

    static double computeMaxPossibleH(double[][] poly) {
        int n = poly.length;
        double maxH = 1e9;
        for (int i = 0; i < n; i++) {
            int j = (i+1)%n;
            double x1 = poly[i][0], y1 = poly[i][1];
            double x2 = poly[j][0], y2 = poly[j][1];
            double len = Math.hypot(x2-x1, y2-y1);
            maxH = Math.min(maxH, (len-0.1)/2.0);
        }
        return Math.max(maxH, 0.0);
    }

    static double[][] offsetPolygon(double[][] poly, double H) {
        int n = poly.length;
        double[][] offs = new double[n][2];
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;
            int curr = i;
            int next = (i + 1) % n;
            double[] A = poly[prev], B = poly[curr], C = poly[next];

            // Edge AB
            double vx1 = B[0] - A[0], vy1 = B[1] - A[1];
            double len1 = Math.hypot(vx1, vy1); vx1 /= len1; vy1 /= len1;
            // Edge BC
            double vx2 = C[0] - B[0], vy2 = C[1] - B[1];
            double len2 = Math.hypot(vx2, vy2); vx2 /= len2; vy2 /= len2;

            // Outward normals (for CCW polygon, normal left of edge)
            double nx1 = -vy1, ny1 = vx1;
            double nx2 = -vy2, ny2 = vx2;

            // Bisector
            double bisx = nx1 + nx2, bisy = ny1 + ny2;
            double bisLen = Math.hypot(bisx, bisy);
            if (bisLen < 1e-8) return null; // Parallel edges, degenerate
            bisx /= bisLen; bisy /= bisLen;

            // Internal angle
            double angle = Math.acos(Math.max(-1.0, Math.min(1.0, vx1 * vx2 + vy1 * vy2)));
            if (Math.abs(angle) < 1e-8) return null; // zero angle, collapse
            // Distance to move vertex along bisector
            double move = H / Math.sin(angle/2.0);
            offs[i][0] = B[0] + bisx * move;
            offs[i][1] = B[1] + bisy * move;
        }
        return offs;
    }

    static double polygonArea(double[][] poly) {
        double area = 0.0;
        int n = poly.length;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += poly[i][0] * poly[j][1] - poly[j][0] * poly[i][1];
        }
        return Math.abs(area) / 2.0;
    }

    static boolean isValidPolygon(double[][] poly) {
        int n = poly.length;
        for (int i = 0; i < n; i++) {
            int j = (i+1)%n;
            double dx = poly[i][0] - poly[j][0];
            double dy = poly[i][1] - poly[j][1];
            if (Math.hypot(dx, dy) < 0.1 - 1e-8) return false;
        }
        return true;
    }
}

