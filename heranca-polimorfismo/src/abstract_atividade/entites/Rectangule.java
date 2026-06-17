package abstract_atividade.entites;

import abstract_atividade.entites.Enum.Color;

public class Rectangule extends Shape {
    private Double width;
    private Double height;

    public Rectangule(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public Double area() {
        return this.width * this.height;
    }
}
