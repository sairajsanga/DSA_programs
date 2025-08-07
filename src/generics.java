import java.util.Arrays;

public abstract  class generics<T> {

    private static int size;
    final int capapcity=10;
    Object []data;

    abstract int sum(int a,int b);
    public generics() {
        this.data=new Object[capapcity];
    }
    private void add(T num){
        if(isfull()){
            resize();
        }
       data[size++]=num;
    }

    private boolean isfull() {
        return size==data.length;
    }

    private void resize() {
        Object []temp= new Object[2* data.length];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }
    private T remove(int index){
        T removed=(T)(data[index]);
        return removed;
    }
    public String toString(){
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        generics<Integer> g= new generics<>() {
            @Override
            int sum(int a, int b) {
                return a+b;
            }
        };
        generics<String> s=new generics<String>() {
            @Override
            int sum(int a, int b) {
                return 0;
            }
        };
        for(int i=0;i<10;i++){
            g.add(2*i);
        }
        System.out.println(s);
//        System.out.println(g.remove(5));
//        g.remove(5);
//        System.out.println(g);
        System.out.println(s.sum(5,4));
        System.out.println(s.sum(1,2));
    }
}

