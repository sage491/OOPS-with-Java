class Calculatearea
{
    int area=0;
    public void area(int l,int b)
    {
        area=l*b;
        System.out.println("Area of rectangle "+area);
    }
    public void area(int a)
    {
        area=a*a;
        System.out.println("Area of square "+area);
    }
    public static void main(String[]args)
    {
        Calculatearea cal=new Calculatearea();
        cal.area(2,3);
        cal.area(2);
    }
}