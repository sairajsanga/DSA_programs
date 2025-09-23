class Solution {
    class Pair{
        Character str;
        int freq;
        public Pair(Character str,int freq){
            this.str=str;
            this.freq=freq;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.freq-a.freq);
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            q.add(new Pair(entry.getKey(),entry.getValue()));
        }

        if(q.peek().freq>(s.length()+1)/2) return "";
        Pair prev=null;
        while(!q.isEmpty()){
            Pair p=q.poll();
            str.append(p.str);
            p.freq--;
            if(prev!=null&&prev.freq>0){
                q.add(prev);
            }
            prev=p;
        }
        

        return str.toString();


    }
}