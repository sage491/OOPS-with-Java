class Student {

    int roll; 
    String name;

    Student() {
        roll = 1;
        name = "Harshit";
    }

    Student(Integer r, String n) {
        roll = r;
        name = n;
    }

    void display() {
        System.out.println(roll + " " + name);
    }

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student(20, "Harshit");

        s1.display();
        s2.display();
    }
}