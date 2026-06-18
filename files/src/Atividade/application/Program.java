package Atividade.application;

import Atividade.entites.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String[] fileContents = new String[] {""};
        List<Product> products = new ArrayList<>();

        System.out.println("Enter a input path: ");
        String strPath = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();
            while (line != null) {
                fileContents = line.split(",");
                String productName = fileContents[0];
                Double productPrice = Double.parseDouble(fileContents[1]);
                Integer productQuantity = Integer.parseInt(fileContents[2]);

                Product product = new Product(productName, productPrice, productQuantity);
                products.add(product);
                line = br.readLine();
            }
            boolean sucess = new File("c:\\teste" + "\\out").mkdir();
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }

        String newPath = "c:\\teste\\out\\summary.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(newPath))){
            for(Product p : products) {
                bw.write(p.toString());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
