import java.util.Scanner;

public class AtividadeModulo {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idProduct;
        String nameProduct = "";
        int priceProduct;
        int quantity;
        int total = 0;
        double totalDiscount = 0;
        double discount = 0.00;

        System.out.printf("Escolha o produto:%n1 = Hambúrguer%n2 = Pizza%n3 = Refrigerante%n4 = Sorvete%n");
        idProduct = sc.nextInt();

        System.out.print("Quantidade:");
        quantity = sc.nextInt();


        switch (idProduct){
            case 1:
                nameProduct = "Hamburguer";
                priceProduct = 25;
                total += priceProduct * quantity;
                discount = (total > 50) ? total * 0.10 : total;
                totalDiscount = total - discount;
            break;
            case 2:
                nameProduct = "Pizza";
                priceProduct = 40;
                total += priceProduct * quantity;
                discount = (total > 50) ? total * 0.10 : total;
                totalDiscount = total - discount;

            break;
            case 3:
                nameProduct = "Refrigerante";
                priceProduct = 8;
                total += priceProduct * quantity;
                discount = (total > 50) ? total * 0.10 : total;
                totalDiscount = total - discount;
            break;
            case 4:
                 nameProduct = "Sorvete";
                 priceProduct = 12;
                 total += priceProduct * quantity;
                 discount = (total > 50) ? total * 0.10 : total;
                 totalDiscount = total - discount;
            break;
            default:
                System.out.println("Por gentiliza, seleciona o numero do pedido!");
            break;
        }

        System.out.printf("Produto: %s%nQuantidade: %d%nTotal: R$ %d%nDesconto: %.2f%nValorFinal: R$ %.2f%n", nameProduct, quantity, total, discount, totalDiscount);



        sc.close();
    }
}
