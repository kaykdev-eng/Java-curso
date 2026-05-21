package exercicio2.entities;

public class Produto {
    public String nameProduct;
    public double priceProduct;
    public int quantityProduct;

    public void addProduct(int x){
        this.quantityProduct += x;
    }

    public void removeProduct(int x){
        this.quantityProduct -= x;
    }

    public void view (String x, double y, int z) {
        System.out.printf(" Nome produto: %s%n Preço produto: %.2f%n Quantidade de produtos: %d%n", x, y, z);
    }

}
