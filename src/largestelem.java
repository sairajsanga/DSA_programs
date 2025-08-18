public class largestelem {
        public static int second_Largest(int a[]){
            int max1,max2;
            max1=max2=a[0];
            //loop
            for(int i=0;i<a.length;i++){
                if(max1<a[i]){
                    max2=max1;
                    max1=a[i];
                }else if(max2<a[i]&&a[i]!=max1){
                    max2=a[i];
                }
            }
            return max2;
        }

        public static void main(String args[]){
            int a[]={1,2,3,4,5,6,6};
            System.out.println("second largest element was : "+ second_Largest(a));
        }
}

