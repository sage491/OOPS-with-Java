import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("file.txt");

            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}