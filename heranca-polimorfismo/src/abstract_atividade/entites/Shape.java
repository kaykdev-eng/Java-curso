package abstract_atividade.entites;

import abstract_atividade.entites.Enum.Color;

public abstract class Shape {
    private Color color;

    public Shape (Color color) {
        this.color = color;
    }

    public abstract Double area();

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
