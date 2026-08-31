//package RandomQues;

import java.util.*;

public class Practice {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int arr[]={1,1,1,11,2,3,4,4,5,5,5,5,5,9,2,1};

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i< arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
       for(int ele: map.keySet()){
           if(map.get(ele)%2!=0){
               odd.add(ele);
           }else{
               even.add(ele);
           }
       }
       Collections.sort(odd);
       if(odd.size()>3) {
           System.out.println(odd);
       }

        









    }


}