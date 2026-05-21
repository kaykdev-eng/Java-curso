import java.util.Locale;

public class Main {
    static void main(String[] args) {
        Locale.setDefault(Locale.US); // seta o teclado americado para ter " . " ao inves de " , "
        int x = 23;
        double y = 1.63456;

        System.out.println(x);
        System.out.println(y);
        System.out.printf("%.2f%n", y); // formatar numero double com duas casas decimais
        System.out.printf("%.4f%n", y);

        System.out.println("Ele quer que eu junte isso: " + x + ",com isso: " + y);
        System.out.printf("Ele quer que eu junte isso: %.2f%n ", y);

        String name = "Maria";
        int age = 32;
        double money  = 42.500;

        System.out.printf("%s tem %d e tem no Banco o total de %.2f no banco%n", name,age,money);
    }
}
