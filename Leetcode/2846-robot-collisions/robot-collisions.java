class Solution {

 
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        Integer[] indices=new Integer[n];
        List<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();


        for(int i=0;i<n;i++){
            indices[i]=i;
        }

        Arrays.sort(indices,(a,b)->Integer.compare(positions[a],positions[b]));


        for(int currIndex:indices){
           
            if(directions.charAt(currIndex)=='R'){
                stack.push(currIndex);
            }
            else{
                while(!stack.isEmpty()&&healths[currIndex]>0){
                   int topIndex=stack.pop();
                   if(healths[topIndex]>healths[currIndex]){
                      healths[topIndex]-=1;
                      healths[currIndex]=0;
                      stack.push(topIndex);
                   }
                   else if(healths[topIndex]<healths[currIndex]){
                     healths[currIndex]-=1;
                     healths[topIndex]=0;
                   }
                   else{
                     healths[currIndex]=0;
                     healths[topIndex]=0;
                   }
                }      
            }
        }
       
        
        
        for(int i=0;i<n;i++){
           if(healths[i]>0) res.add(healths[i]);
        }
        return res;
    }
}