# Challenges - Lógica de Programação (lacunas)

## Challenge 1: Processar contrato em parcelas

### Objetivo
Completar as lacunas em `Challenge1_ContractService.java` para calcular, para cada parcela:
- **juros** (interest)
- **taxa/fee** (paymentFee)
- **total pago** no período
- **due date** (data de vencimento) da parcela

### Referência (projeto original)
Use como referência o comportamento já implementado em:
- `src/project_contract/model/service/ContractService.java`
- `src/project_contract/model/service/PaypalService.java`
- `src/project_contract/model/entities/Installment.java`

### Especificação do cálculo (regra)
Para cada parcela `i` (começando em `0` e indo até `months - 1`):
1. `valorBase = totalValue / months`
2. `juros = onlineService.interest(valorBase, i + 1)`
3. `taxa = onlineService.paymentFee(valorBase + juros)`
4. `totalParcela = valorBase + taxa + juros`
5. `dueDate = contract.getDate().plusMonths(i + 1)`
6. Criar a parcela com o construtor:
   `Installment(number, date, totalValue, onlineService, dueDate, amount)`

### O que você precisa fazer
- Preencher as lacunas `____________` do arquivo `Challenge1_ContractService.java` com a lógica correta.