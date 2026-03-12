public class StringExample {

    public String concatenate(String str1, String str2) {
        return str1 + " " + str2;
    }

    public static void main(String[] args) {

        StringExample obj = new StringExample();
        String result = obj.concatenate("Hello", "World");

        System.out.println(result);
    }
}