package abstract_atividade.application;

import abstract_atividade.entites.Circle;
import abstract_atividade.entites.Enum.Color;
import abstract_atividade.entites.Rectangule;
import abstract_atividade.entites.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter the number of shape: ");
        int n = sc.nextInt();
        sc.nextLine();
        char response;

        for (int i = 0; i < n; i++) {
            System.out.printf("Shape #%d data: %n", i + 1);
            System.out.print("Rectangule or cirle (r/c)?");
            response = sc.nextLine().charAt(0);
            System.out.print("Color (BLACK / BLUE / RED): ");
            String color = sc.nextLine();

            if(response == 'r') {
                System.out.print("Width: ");
                Double width = sc.nextDouble();

                System.out.print("Height: ");
                Double height = sc.nextDouble();
                sc.nextLine();

                Shape rectangule = new Rectangule(Color.valueOf(color.toUpperCase()), width, height);
                shapeList.add(rectangule);
            } else if(response == 'c') {
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();
                sc.nextLine();

                Shape circle = new Circle(Color.valueOf(color.toUpperCase()), radius);
                shapeList.add(circle);
            }
        }

        System.out.println("SHAPES AREAS:");
        for (Shape sh : shapeList) {
            System.out.println(sh.area());
        }

        sc.close();
    }
}
