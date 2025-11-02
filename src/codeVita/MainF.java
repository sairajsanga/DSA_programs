package codeVita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class MainF {

    private static final double EPS = 1e-9;

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = round(x);
            this.y = round(y);
        }

        private double round(double val) {
            return Math.round(val * 100.0) / 100.0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Math.abs(point.x - x) < EPS && Math.abs(point.y - y) < EPS;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Stick {
        Point p1, p2;
        double length;
        double x1, y1, x2, y2;

        Stick(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.p1 = new Point(x1, y1);
            this.p2 = new Point(x2, y2);
            this.length = dist(p1, p2);
        }
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static boolean isOnSegment(Point p, Stick s) {
        double minX = Math.min(s.x1, s.x2) - EPS;
        double maxX = Math.max(s.x1, s.x2) + EPS;
        double minY = Math.min(s.y1, s.y2) - EPS;
        double maxY = Math.max(s.y1, s.y2) + EPS;

        return p.x >= minX && p.x <= maxX && p.y >= minY && p.y <= maxY;
    }

    static Point getIntersection(Stick s1, Stick s2) {
        double a1 = s1.y2 - s1.y1;
        double b1 = s1.x1 - s1.x2;
        double c1 = a1 * s1.x1 + b1 * s1.y1;

        double a2 = s2.y2 - s2.y1;
        double b2 = s2.x1 - s2.x2;
        double c2 = a2 * s2.x1 + b2 * s2.y1;

        double det = a1 * b2 - a2 * b1;

        if (Math.abs(det) < EPS) {
            return null;
        }

        double x = (b2 * c1 - b1 * c2) / det;
        double y = (a1 * c2 - a2 * c1) / det;

        Point p = new Point(x, y);

        if (isOnSegment(p, s1) && isOnSegment(p, s2)) {
            return p;
        }

        return null;
    }

    static double getShoelaceArea(List<Point> vertices) {
        double area = 0.0;
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % n);
            area += (p1.x * p2.y) - (p2.x * p1.y);
        }
        return Math.abs(area) / 2.0;
    }

    static double getPerimeter(List<Point> vertices) {
        double perimeter = 0.0;
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % n);
            perimeter += dist(p1, p2);
        }
        return perimeter;
    }

    static boolean dfs(int u, int p, List<List<Integer>> adj, int[] parent,
                       boolean[] visited, boolean[] inStack, List<Integer> cycleSticks) {
        visited[u] = true;
        inStack[u] = true;
        parent[u] = p;

        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }
            if (inStack[v]) {
                int curr = u;
                while (curr != v) {
                    cycleSticks.add(curr);
                    curr = parent[curr];
                }
                cycleSticks.add(v);
                return true;
            }
            if (!visited[v]) {
                if (dfs(v, u, adj, parent, visited, inStack, cycleSticks)) {
                    return true;
                }
            }
        }
        inStack[u] = false;
        return false;
    }

    private static long getKey(int i, int j) {
        return i < j ? (long)i << 32 | j : (long)j << 32 | i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Stick> sticks = new ArrayList<>();
        double totalLength = 0;

        for (int i = 0; i < n; i++) {
            Stick s = new Stick(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            sticks.add(s);
            totalLength += s.length;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        Map<Long, Point> intersectionMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point p = getIntersection(sticks.get(i), sticks.get(j));
                if (p != null) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                    intersectionMap.put(getKey(i, j), p);
                }
            }
        }

        List<Integer> cycleSticks = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        int[] parent = new int[n];
        boolean cycleFound = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, parent, visited, inStack, cycleSticks)) {
                    cycleFound = true;
                    break;
                }
            }
        }

        if (!cycleFound) {
            System.out.print("Abandoned");
            return;
        }

        List<Point> cycleVertices = new ArrayList<>();
        int k = cycleSticks.size();
        for (int i = 0; i < k; i++) {
            int u = cycleSticks.get(i);
            int v = cycleSticks.get((i + 1) % k);
            cycleVertices.add(intersectionMap.get(getKey(u, v)));
        }

        double kalyanArea = getShoelaceArea(cycleVertices);
        double kalyanPerimeter = getPerimeter(cycleVertices);
        double computerLength = totalLength - kalyanPerimeter;
        double computerArea = (computerLength * computerLength) / (4.0 * Math.PI);

        if (kalyanArea > computerArea) {
            System.out.print("Kalyan");
        } else {
            System.out.print("Computer");
        }

        sc.close();
    }
}