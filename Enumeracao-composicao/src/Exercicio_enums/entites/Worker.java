package Exercicio_enums.entites;

import Exercicio_enums.entites.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){}

    public Worker(String name, Double baseSalary, WorkerLevel level, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    public void addContract(HourContract contract) {
       contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
       double sum = baseSalary;
       for(HourContract c : contracts) {
           int c_year = c.getDate().getYear();
           int c_month = c.getDate().getMonthValue();
           if(year == c_year && month == c_month) {
               sum += c.totalValue();
           }
       }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
}
