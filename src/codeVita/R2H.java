package codeVita;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class R2H {
    static class Planet {
        String name;
        String parentName;
        int radius;
        Planet parent;

        public Planet(String name, String parentName, int radius) {
            this.name = name;
            this.parentName = parentName;
            this.radius = radius;
        }
    }

    static Map<String, Planet> planetMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String sec = sc.next();
                String pri = sc.next();
                int rad = sc.nextInt();

                Planet p = planetMap.getOrDefault(sec, new Planet(sec, pri, rad));
                p.parentName = pri;
                p.radius = rad;
                planetMap.put(sec, p);

                Planet parent = planetMap.getOrDefault(pri, new Planet(pri, null, 0));
                planetMap.put(pri, parent);

                p.parent = parent;
            }

            String srcName = sc.next();
            String destName = sc.next();

            for (int time = 0; time <= 200; time++) {
                if (canReach(srcName, destName, time)) {
                    System.out.print(time);
                    return;
                }
            }
        }
    }

    private static boolean canReach(String src, String dest, int arrivalTime) {
        int[] destPos = getGlobalPos(dest, arrivalTime);

        for (int t = 0; t <= arrivalTime; t++) {
            int[] srcPos = getGlobalPos(src, t);
            int dist = Math.abs(srcPos[0] - destPos[0]) + Math.abs(srcPos[1] - destPos[1]);
            if (dist <= (arrivalTime - t)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getGlobalPos(String planetName, int time) {
        int x = 0;
        int y = 0;
        Planet current = planetMap.get(planetName);

        while (current != null && current.parentName != null) {
            int d = current.radius - 1;
            if (d > 0) {
                int perimeter = 8 * d;
                int effectiveTime = time % perimeter;

                int relX = 0, relY = 0;

                if (effectiveTime <= d) {
                    relX = d;
                    relY = effectiveTime;
                } else if (effectiveTime <= 3 * d) {
                    relX = d - (effectiveTime - d);
                    relY = d;
                } else if (effectiveTime <= 5 * d) {
                    relX = -d;
                    relY = d - (effectiveTime - 3 * d);
                } else if (effectiveTime <= 7 * d) {
                    relX = -d + (effectiveTime - 5 * d);
                    relY = -d;
                } else {
                    relX = d;
                    relY = -d + (effectiveTime - 7 * d);
                }
                x += relX;
                y += relY;
            }
            current = current.parent;
        }
        return new int[]{x, y};
    }
}