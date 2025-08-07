package harry_programs;

class rect {
    rect() {
        System.out.println("Iam the construtor");
    }

    rect(int a) {
        System.out.println("Iam the constructor with an argument");
    }
}
    class sub extends rect{
        sub(){
            super();
            System.out.println("Iam a constructor with no arguments");
        }
         sub(int a){
             super(a);
             System.out.println("the value of a is:"+a);
         }
    }


public class Inheritance {
    public static void main(String[] args) {
        sub s=new sub(10);
//        sub s1=new sub();
    }
}
