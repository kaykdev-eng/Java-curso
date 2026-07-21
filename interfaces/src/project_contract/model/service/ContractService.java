package project_contract.model.service;

import project_contract.model.entities.Contract;
import project_contract.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    Contract contract;
    PaypalService onlineService;

    public ContractService(Contract contract, PaypalService onlineService) {
        this.contract = contract;
        this.onlineService = onlineService;
    }

    public void processContract(Contract contract, Integer months) {
        Double totalAmount = contract.getTotalValue() / months;
        for(int i = 0; i < months; i++) {
            Double interest = onlineService.interest(totalAmount, i + 1);
            Double totalPerInstallment = onlineService.paymentFee(totalAmount + interest);
            Double total = totalAmount + totalPerInstallment + interest;
            LocalDate date = contract.getDate();
            Installment installment = new Installment(
                    contract.getNumber(),
                    contract.getDate(),
                    contract.getTotalValue(),
                    onlineService,
                    date.plusMonths(i + 1),
                    total
            );
            contract.addInstallment(installment);
        }
    }
}
