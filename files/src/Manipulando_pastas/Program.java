package Manipulando_pastas;

import java.io.File;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a folder path: ");
        String strFolder = sc.nextLine();
        File path = new File(strFolder);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("Folders: ");
        for(File folder : folders) {
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);
        System.out.println("Files: ");
        for (File file : files) {
            System.out.println(file);
        }

        boolean sucess = new File(strFolder + "\\newPasta").mkdir();
        System.out.println(sucess);

        sc.close();
    }
}
