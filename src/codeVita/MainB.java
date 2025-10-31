package codeVita;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainB {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Point[] vertices;

    private static double calculateVolume(double h) {
        Point[] newVertices = new Point[N];

        for (int i = 0; i < N; i++) {
            Point p_curr = vertices[i];
            Point p_prev = vertices[(i + N - 1) % N];
            Point p_next = vertices[(i + 1) % N];

            double final_x = 0, final_y = 0;

            if (p_prev.x == p_curr.x) {
                if (p_curr.y > p_prev.y) {
                    final_x = p_curr.x - h;
                } else {
                    final_x = p_curr.x + h;
                }
            } else {
                if (p_curr.x > p_prev.x) {
                    final_y = p_curr.y + h;
                } else {
                    final_y = p_curr.y - h;
                }
            }

            if (p_curr.x == p_next.x) {
                if (p_next.y > p_curr.y) {
                    final_x = p_curr.x - h;
                } else {
                    final_x = p_curr.x + h;
                }
            } else {
                if (p_next.x > p_curr.x) {
                    final_y = p_curr.y + h;
                } else {
                    final_y = p_curr.y - h;
                }
            }

            newVertices[i] = new Point(final_x, final_y);
        }

        double area = 0.0;
        for (int i = 0; i < N; i++) {
            Point p1 = newVertices[i];
            Point p2 = newVertices[(i + 1) % N];
            area += (p1.x * p2.y) - (p2.x * p1.y);
        }
        area = 0.5 * Math.abs(area);

        return area * h;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vertices = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vertices[i] = new Point(x, y);
        }

        double minLength = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Point p1 = vertices[i];
            Point p2 = vertices[(i + 1) % N];

            double len = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
            minLength = Math.min(minLength, len);
        }

        double maxH = (minLength - 0.1) / 2.0;

        double maxVolume = 0.0;

        for (int k = 1; ; k++) {
            double h = k * 0.1;

            if (h > maxH + 1e-9) {
                break;
            }

            double currentVolume = calculateVolume(h);
            maxVolume = Math.max(maxVolume, currentVolume);
        }

        System.out.printf("%.2f", maxVolume);
    }
}
