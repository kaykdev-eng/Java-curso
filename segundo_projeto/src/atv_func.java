import java.util.Scanner;

public class atv_func {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String nameEmployee;
        double salary;
        int yearsCompany;

        System.out.print("Nome do funcionario: ");
        nameEmployee = sc.nextLine();

        System.out.print("Salario: ");
        salary = sc.nextDouble();

        System.out.println("Tempo de empresa: ");
        yearsCompany = sc.nextInt();

        double valueBonus = bonus(yearsCompany, salary);
        showResult(nameEmployee, salary, valueBonus);


        sc.close();
    }

    public static double bonus(int x, double s) {
        double bonus;

        if(x < 2) {
            return bonus = s * 0.05;
        } else if(x <= 5){
            return bonus = s * 0.10;
        }else {
            return bonus = s * 0.15;
        }

    }

    public static void showResult(String name, double sal, double bonus) {
        double finalSalary = sal + bonus;
        System.out.printf("Nome: %s%nSalario: %.2f%nValor do bonus:%.2f%nSalario Final:%.2f%n", name.toUpperCase(), sal, bonus, finalSalary);
    }

}
