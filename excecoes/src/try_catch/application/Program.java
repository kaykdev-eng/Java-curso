package try_catch.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println("Invalid positon");
        } catch(InputMismatchException e ) {
            System.out.println("Enter a number of position");
        }

        sc.close();
    }
}
