class Shape{
    int l;
    int r;
    int b;
    int area;
    void calculate_area(){
        this.l =10;
        area=l*l;
    }
    void display(){
        System.out.println("Area of square is: "+area);
    }
}
class Circle extends Shape{
    void calculate_area(){
        this.r=10;
        area=(int)(3.14*r*r);
    }
    void display(){
        System.out.println("Area of circle is: "+area);
    }
}
class Rectangle extends Shape{
    void calculate_area(){
        this.l=10;
        this.b=20;
        area=l*b;
    }
    void display(){
        System.out.println("Area of rectangle is: "+area);
    }
}
public class fina_pracs{
public static void main(String[] args) {
    Shape s1=new Shape();
    s1.calculate_area();
    s1.display();

    Circle c1=new Circle();
    c1.calculate_area();
    c1.display();

    Rectangle r1=new Rectangle();
    r1.calculate_area();
    r1.display();
}
}