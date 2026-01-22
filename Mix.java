public class Mix{
    public static void main(String[] args) {
        System.out.println("Static method-1");
        Mix obj = new Mix();
        obj.nonStaticMethod();
        display();
    }

    public void nonStaticMethod(){
        System.out.println("Non static method-1");
    }

    public static void display(){
        System.out.println("Static method-2");
    }
}