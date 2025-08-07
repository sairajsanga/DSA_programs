package Kunal_programs;

public class Main {
    public static void main(String[] args) {
        LL list =new LL();
        list.Insertfirst(3);
        list.Insertfirst(5);
        list.Insertfirst(12);
        list.Insertfirst(4);
        list.Insertfirst(6);
        int a[]={6,5,3};

         list.delete_comm(a,list.head);
          list.Display();


//        list.insert(50,3);
//        System.out.println(list.removefirst());
//        list.Display();
//        System.out.println();
//        System.out.println(list.removelast());
//        list.Display();
//        LinkedList<Integer> list1=new LinkedList<>();
//        list1.add(3);
//        list1.add(5);
//        list1.add(12);
//        list1.add(4);
//        list1.add(6);
//
//        System.out.print(list1);



    }

}
