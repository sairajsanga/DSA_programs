package harry_programs;

public class practice_set_arrays {
    public static void main(String[] args) {


        //Question 1 printing sum of array
//        float[] marks ={1.2f,1.3f,1.4f,1.5f,1.6f};
//        float sum=0;
//        for(int i=0;i<marks.length;i++){
//            sum+=marks[i];
//        }
//        System.out.println(sum);

        //Question 2   to find whether an element is in array or not

       /*
       float[] marks ={1.2f,1.3f,1.4f,1.5f,1.6f};
        float num=1.3f;
        boolean isarray=false;
        for(int i=0;i<marks.length;i++){
            if(num==1.3f) {
                isarray = true;
                break;
            }
        }
        if(isarray) {
            System.out.println("Element is in array:");
        }
        else{
            System.out.println("Element is not in array:");
      }
        */

        //Question 3  matrix addition (usage of 2D arrays)

/*
        int [][] mat1={{1,2,3},{4,5,6}};
        int [][] mat2={{6,7,8},{9,10,11}};
        int [][] result={{0,0,0},{0,0,0}};

        for(int i=0;i<mat1.length;i++){
           for(int j=0;j<mat1[i].length;j++){
               result[i][j]=mat1[i][j]+mat2[i][j];
               System.out.print(result[i][j]);
               System.out.print(" ");
           }
            System.out.println(" ");
        }

*/
        //question 4 reversing an array

        /* int [] arr1={1,2,3,4,5};
        System.out.println("reversed array");
        int temp;
        int l=arr1.length;
        int n=Math.floorDiv(l,2);
        for(int i=0;i<n;i++){
        temp=arr1[i];
        arr1[i]=arr1[l-1-i];
        arr1[l-1-i]=temp;
        }
        for(int i=0;i<l;i++) {
            System.out.print(arr1[i]+" ");
        }
        */

        // Question 5 finding max and min in array
       /* int [] arr={1,2,3,70,48};
        int max=Integer.MIN_VALUE;
        int l=arr.length;
        for(int i=0;i<l;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);


        int [] arr1={1,2,3,70,48};
        int min=Integer.MAX_VALUE;
        int l1=arr1.length;
        for(int i=0;i<l1;i++){
            if(arr1[i]<min){
                min=arr1[i];
            }
        }
        System.out.println(min);*/



        // no of multiples logic::
       /* Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int x=n/2;
        int y=n/5;
        int z=n/10;
        int count=x+y-z;
        System.out.println(count);*/



        //Question 6 to printing sorted array

/*

        int[] arr = {1, 200, 50, 5, 70};
        int l = arr.length - 1;
        int temp = 0;

        for (int j = 0; j < l; j++) {
            for (int i = 0; i < l - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap elements if they are in the wrong order
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i <= l; i++) {
            System.out.println(arr[i]);
        }
*/


        //sum of array elements

      /*
      int [] a={1,2,3,4};
      int sum=0;
      for(int i=0;i<a.length;i++){
          sum+=a[i];
      }
        System.out.println(sum);

    */
    // variable arguments

     /* static int sum(int ...arr){
          int result=0;
          for(int a: arr){
              result+=a;
          }
          return result;
        }*/



    }

}
