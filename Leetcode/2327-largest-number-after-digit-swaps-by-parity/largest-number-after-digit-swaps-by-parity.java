class Solution {
    public int largestInteger(int num) {
      PriorityQueue<Integer> oq=new PriorityQueue<>();
      PriorityQueue<Integer> eq=new PriorityQueue<>();

      int temp=num;
      while(temp!=0){
        int ele=temp%10;
        if(ele%2==0){
            eq.add(ele);
        }
        else{
            oq.add(ele);
        }
        temp/=10;
      }
      StringBuilder str=new StringBuilder();
      while(num>0){
        int ele=num%10;
        if(ele%2!=0){
           str.insert(0,oq.poll()); 
        }
        else{
            str.insert(0,eq.poll());
        }
        num/=10;
      }
      return Integer.parseInt(str.toString());
    }
}