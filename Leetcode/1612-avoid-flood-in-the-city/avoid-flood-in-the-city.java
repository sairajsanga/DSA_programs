class Solution {
    public int[] avoidFlood(int[] rains) {
        int zerocount = 0;
        int lakecount = 0;
        int res[] = new int[rains.length];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (lastRain.containsKey(rains[i])) {
                    Integer dryDay = dryDays.higher(lastRain.get(rains[i]));
                    if (dryDay == null)
                        return new int[0]; // flood
                    res[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                lastRain.put(rains[i], i);
                res[i] = -1;
            } else {
                dryDays.add(i);
                res[i] = 1; // placeholder, will update later
            }
        }
        return res;
    }
}