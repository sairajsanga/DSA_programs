package harry_programs;



     class employee1{
         String name;
         int sal;
         public employee1(int x){
             sal=x;
             System.out.println("employee salary:"+sal);
         }
         public employee1(String a,int b){
             name=a;
             sal=b;
             System.out.println("employee name:"+name);
             System.out.println("employee salary:"+sal);
         }
     }
     class employee{
         private int id;
        private String name;
        private int salary;
         public void printdetails(){
             System.out.println("my name is:"+name);
             System.out.println("my id is:"+id);
         }
         public int getsalary(){

             System.out.println(salary);
             return salary;
         }
     }
     class circle{
         private int r;
         public double getarea(){
             return 3.14*r*r;
         }
         public void setarea(int n){
             r=n;
         }
         public double getperimeter(){
             return 2*3.14*r;
         }
         public void setperimeter(int x){
             r=x;
         }
     }


  public class Object_oriented_program {
    public static void main(String[] args) {
       /*
        employee nikhil=new employee();
         employee sai=new employee();
        sai.id=51;
        sai.name="sairaj";
        sai.salary=50000;

        nikhil.id=50;
        nikhil.name="kodi";
        nikhil.salary=40000;

         sai.printdetails();
        nikhil.printdetails();

        sai.getsalary();
        nikhil.getsalary();*/
      /*  System.out.println(sai.getsalary());
        System.out.println(nikhil.getsalary());*/
       /* circle c1=new circle();
        c1.setarea(4);
        c1.setperimeter(5);
        System.out.println(c1.getarea());
        System.out.println(c1.getperimeter());*/

        employee1 emp=new employee1(10000);
        employee1 emp1=new employee1("sairaj",10000);


    }
}
