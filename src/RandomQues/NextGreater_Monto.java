package RandomQues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater_Monto {
    public static void main(String[] args) {
        int arr[]={4,5,2,25};
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        Arrays.fill(res,-1);
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[i]>=arr[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
