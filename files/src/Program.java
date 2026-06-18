import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        File file = new File("c:\\teste\\file.txt");
        Scanner sc = null;
        try{
           sc = new Scanner(file);
           while(sc.hasNextLine()) {
               System.out.println(sc.nextLine());
           }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            assert sc != null;
            sc.close();
        }
    }
}
