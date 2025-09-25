class Solution {
    class Pair{
        Character str;
        int freq;
        Pair(Character str,int freq){
            this.str=str;
            this.freq=freq;
        }
    }
    public String frequencySort(String s) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            q.add(new Pair(entry.getKey(),entry.getValue()));
        }

        while(!q.isEmpty()){
            int k=q.peek().freq;
            char ch=q.poll().str;
            for(int i=0;i<k;i++){
                str.append(ch);
            }
        }
        return str.toString();  
    }
}