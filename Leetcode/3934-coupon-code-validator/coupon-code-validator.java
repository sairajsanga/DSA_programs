class Solution {
    class Pair {
        String bus;
        String c;

        public Pair(String bus, String c) {
            this.bus = bus;
            this.c = c;
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String coupon = code[i];
            String business = businessLine[i];
            boolean active = isActive[i];
            if (active && isvalid(business, coupon)) {
                list.add(new Pair(business, coupon));
            }
        }

        Map<String, Integer> priority = Map.of(
                "electronics", 0,
                "grocery", 1,
                "pharmacy", 2,
                "restaurant", 3);

        Collections.sort(list, (a, b) -> {
            int p1 = priority.get(a.bus);
            int p2 = priority.get(b.bus);
            if (p1 != p2)
                return p1 - p2;
            return a.c.compareTo(b.c);
        });
        List<String> res = new ArrayList<>();
        for (Pair p : list) {
            String coup = p.c;
            String b = p.bus;

            res.add(coup);
        }
        
        return res;
    }

    public boolean isvalid(String business, String coupon) {
        if (business.equals("restaurant") || business.equals("grocery") || business.equals("electronics")
                || business.equals("pharmacy")) {
            if (coupon != null && coupon.matches("^[a-zA-Z0-9_]+$")) {
                return true;
            }
        }
        return false;
    }

}