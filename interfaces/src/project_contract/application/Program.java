package project_contract.application;

import project_contract.model.entities.Contract;
import project_contract.model.service.ContractService;
import project_contract.model.service.OnlinePaymentService;
import project_contract.model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        Integer number = sc.nextInt();
        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dateFmt  = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        Double totalAmount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Entre com o numero de parcelas: ");
        Integer months = sc.nextInt();

        Contract contract = new Contract(number, dateFmt, totalAmount, new PaypalService());
        ContractService service = new ContractService(contract, new PaypalService());
        service.processContract(contract, months);

        System.out.println("Parcelas:");
        System.out.println(contract);

        sc.close();
    }
}
