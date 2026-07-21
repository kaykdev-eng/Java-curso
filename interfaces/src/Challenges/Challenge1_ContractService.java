package Challenges;

import java.time.LocalDate;

import project_contract.model.entities.Contract;
import project_contract.model.entities.Installment;
import project_contract.model.service.OnlinePaymentService;

/**
 * Desafio: completar a lógica de processar um contrato em parcelas.
 *
 * Requisitos (espelhando o projeto atual):
 * - Dividir o valor total por meses para obter o valor base de cada parcela.
 * - Para cada parcela (i de 0 até months-1):
 *   - Calcular juros usando o serviço: interest(valorBase, i + 1)
 *   - Calcular taxa (fee) em cima de (valorBase + juros)
 *   - Somar: valorBase + taxa + juros (na ordem correta)
 *   - Criar um Installment com dueDate = dataContrato.plusMonths(i + 1)
 *   - Adicionar a parcela ao contrato
 */
public class Challenge1_ContractService {

    private final OnlinePaymentService onlineService;

    public Challenge1_ContractService(OnlinePaymentService onlineService) {
        this.onlineService = onlineService;
    }

    public void processContract(Contract contract, Integer months) {
        // LACUNA 1: compute o valor base de cada parcela (totalValue / months)
        Double totalAmount = contract.getTotalValue() / months;

        // LACUNA 2: iterar meses vezes (do primeiro ao último)
        for (int i = 0; i < months; i++) {

            // Valor dos juros para o período (i + 1) (primeira parcela = 1 mês)
            // LACUNA 3: interest(valorBase, i + 1)
            Double interest = onlineService.interest(totalAmount, months);

            // LACUNA 4: paymentFee(valorBase + juros)
            Double totalPerInstallment = onlineService.paymentFee(totalAmount + interest);

            // LACUNA 5: total = valorBase + taxa + juros
            Double total = totalAmount + interest + totalPerInstallment;

            LocalDate date = contract.getDate();

            // LACUNA 6: criar a parcela com os argumentos na ordem esperada
            // Installment(number, date, totalValue, onlinePaymentService, dueDate, amount)
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