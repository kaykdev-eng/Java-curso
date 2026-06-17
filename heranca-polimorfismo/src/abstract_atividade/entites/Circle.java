package abstract_atividade.entites;

import abstract_atividade.entites.Enum.Color;

public class Circle extends Shape {
    private Double radius;
    private final Double PI = 3.14;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public Double area() {
        return this.PI * Math.pow(this.radius, 2);
    }
}
