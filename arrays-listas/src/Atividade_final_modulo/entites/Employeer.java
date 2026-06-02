package Atividade_final_modulo.entites;

public class Employeer {
    private final int ID;
    private String NAME;
    private double SALARY;

    public Employeer(int ID, String NAME, double SALARY) {
        this.ID = ID;
        this.NAME = NAME;
        this.SALARY = SALARY;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getSALARY() {
        return SALARY;
    }

    public void increaseSalary(int value) {
        this.SALARY += this.SALARY * value / 100;
    }

    public String toString() {
        return "ID: " + getID() + "\n" +
                "Name: " + getNAME() + "\n" +
                "Salary: " + String.format("%.2f%n", getSALARY());
    }
}
