# Exercício de Herança e Polimorfismo em Java

Este projeto é um exercício prático de Programação Orientada a Objetos em Java, focado em herança, polimorfismo, upcasting e downcasting.

## Objetivo

O objetivo do exercício é praticar como diferentes tipos de contas bancárias podem herdar comportamentos de uma classe base e, ao mesmo tempo, possuir comportamentos específicos.

## Conceitos praticados

* Classes e objetos
* Herança
* `super`
* `protected`
* Polimorfismo
* Upcasting
* Downcasting
* `instanceof`
* Lista de objetos usando a superclasse
* Sobrescrita e reutilização de métodos

## Estrutura do projeto

O projeto possui uma classe base chamada `Account`, que representa uma conta bancária comum.

Também foram criadas duas subclasses:

* `BusinessAccount`: representa uma conta empresarial, com limite para empréstimo.
* `SavingsAccount`: representa uma conta poupança, com atualização de saldo baseada em juros.

## Funcionamento

No programa principal, foi criada uma `List<Account>` para armazenar diferentes tipos de conta:

* Conta comum
* Conta empresarial
* Conta poupança

Mesmo sendo objetos de classes diferentes, todos podem ser armazenados na mesma lista porque `BusinessAccount` e `SavingsAccount` herdam de `Account`.

Depois, o programa percorre a lista e aplica operações comuns a todas as contas, como depósito e saque.

Em seguida, utiliza `instanceof` para verificar o tipo real de cada objeto e fazer downcasting quando necessário, permitindo chamar métodos específicos das subclasses, como:

* `loan()` para `BusinessAccount`
* `updateBalance()` para `SavingsAccount`

## Aprendizado

Esse exercício ajudou a entender melhor como o Java trabalha com herança e polimorfismo na prática, principalmente ao armazenar subclasses em uma lista da superclasse e acessar comportamentos específicos por meio de downcasting.
