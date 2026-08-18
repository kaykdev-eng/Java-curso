public class Program {
    static void main(String[] args) {
        Client c1 = new Client("Kayk", "kayk@gmail.com");
        Client c2 = new Client("Kayk", "kayk1@gmail.com");
        Client c3 = new Client("Kayk", "kayk1@gmail.com");


        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c1.hashCode());


    }
}
