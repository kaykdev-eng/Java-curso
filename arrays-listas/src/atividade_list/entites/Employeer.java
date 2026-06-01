package atividade_list.entites;

public class Employeer {
    private Integer id;
    private String name;
    private double salary;

    public Employeer(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void bonusPercentage(int increase) {
        double increaseSalary = this.salary * increase / 100;
        this.salary += increaseSalary;
    }

    public String toString() {
        return getId() + ", " + getName() + ", " + String.format("%.2f", getSalary());
    }
}
