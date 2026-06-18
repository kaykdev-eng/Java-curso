package FileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    static void main(String[] args) {
        String[] names = new String[] {"Kayk, Eduarda, Luciano, Izadora"};
        String path = "c:\\teste\\file2.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for(String line : names) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
