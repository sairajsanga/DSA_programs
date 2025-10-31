package codeVita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class MainD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<String, Integer> nameToIndex = new HashMap<>();
        int[] skills = new int[N];


        String[] tempNames = new String[N];
        for (int i = 0; i < N; i++) {
            tempNames[i] = sc.next();
        }


        for (int i = 0; i < N; i++) {
            String name = tempNames[i];
            int skill = sc.nextInt();
            nameToIndex.put(name, i);
            skills[i] = skill;
        }

        Set<Integer> specialIndices = new HashSet<>();

        int N1 = sc.nextInt();
        int[][] friendPairs = new int[N1][2];
        for (int i = 0; i < N1; i++) {
            // Read friend names token by token
            String name1 = sc.next();
            String name2 = sc.next();
            int p1 = nameToIndex.get(name1);
            int p2 = nameToIndex.get(name2);
            friendPairs[i][0] = p1;
            friendPairs[i][1] = p2;
            specialIndices.add(p1);
            specialIndices.add(p2);
        }

        int N2 = sc.nextInt();
        int[][] rivalPairs = new int[N2][2];
        for (int i = 0; i < N2; i++) {

            String name1 = sc.next();
            String name2 = sc.next();
            int p1 = nameToIndex.get(name1);
            int p2 = nameToIndex.get(name2);
            rivalPairs[i][0] = p1;
            rivalPairs[i][1] = p2;
            specialIndices.add(p1);
            specialIndices.add(p2);
        }

        int limit = sc.nextInt();


        sc.close();

        List<Integer> specialPlayerList = new ArrayList<>(specialIndices);
        List<Integer> normalPlayerSkills = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!specialIndices.contains(i)) {
                normalPlayerSkills.add(skills[i]);
            }
        }

        Collections.sort(normalPlayerSkills);

        int maxTotalCount = 0;
        int numSpecial = specialPlayerList.size();

        for (int mask = 0; mask < (1 << numSpecial); mask++) {

            Set<Integer> currentSpecialSet = new HashSet<>();
            int specialSkill = 0;
            int specialCount = 0;
            boolean valid = true;

            for (int i = 0; i < numSpecial; i++) {
                if ((mask & (1 << i)) != 0) {
                    int playerIndex = specialPlayerList.get(i);
                    currentSpecialSet.add(playerIndex);
                    specialSkill += skills[playerIndex];
                    specialCount++;
                }
            }

            if (specialSkill > limit) {
                continue;
            }

            for (int[] pair : friendPairs) {
                boolean p0_in = currentSpecialSet.contains(pair[0]);
                boolean p1_in = currentSpecialSet.contains(pair[1]);
                if (p0_in != p1_in) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            for (int[] pair : rivalPairs) {
                boolean p0_in = currentSpecialSet.contains(pair[0]);
                boolean p1_in = currentSpecialSet.contains(pair[1]);
                if (p0_in && p1_in) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            int remainingLimit = limit - specialSkill;
            int normalCount = 0;
            int currentNormalSkill = 0;

            for (int normalSkill : normalPlayerSkills) {
                if (currentNormalSkill + normalSkill <= remainingLimit) {
                    currentNormalSkill += normalSkill;
                    normalCount++;
                } else {
                    break;
                }
            }

            maxTotalCount = Math.max(maxTotalCount, specialCount + normalCount);
        }

        System.out.print(maxTotalCount);
    }
}
