class Solution {
    class State{
        int x;
        int y;
        public State(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y==target||x==target||y==target) return true;
        if(x+y<target) return false;

        HashSet<String> visited=new HashSet<>();
        Queue<State> q=new LinkedList<>();
        q.add(new State(0,0));

        while(!q.isEmpty()){
           int n=q.size();
           State curr=q.poll();
           if(curr.x+curr.y==target) return true;

           visited.add(curr.x+","+curr.y);
           int newx;
           int newy;
           //x->y
           newx=curr.x-Math.min(curr.x,y-curr.y);
           newy=curr.y+Math.min(curr.x,y-curr.y);
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
           //y-x
           newx=curr.x+Math.min(curr.y,x-curr.x);
           newy=curr.y-Math.min(curr.y,x-curr.x);
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
           //empty x
           newx=0;
           newy=curr.y;
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
           //empty y
           newx=curr.x;
           newy=0;
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
           //fill max x
           newx=x;
           newy=curr.y;
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
           //fill max y
           newx=curr.x;
           newy=y;
           if(!visited.contains(newx+","+newy)){
              q.add(new State(newx,newy));
           }
        } 
        return false;
    }
}