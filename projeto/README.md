Work Order Management System

Projeto desenvolvido em Java com foco em Programação Orientada a Objetos e organização em camadas, simulando uma estrutura próxima ao que é utilizado em aplicações com Spring Boot.

Sobre o projeto

Este projeto representa um sistema simples de cadastro e gerenciamento de ordens de serviço. Cada ordem possui dados como ID, cliente, horas trabalhadas, valor por hora e tipo de serviço.

Existem três tipos de ordens de serviço:

* Manutenção comum
* Instalação
* Serviço emergencial

Cada tipo possui uma regra diferente para calcular o valor total do serviço.

Conceitos praticados

Neste projeto foram aplicados conceitos importantes de Java e POO:

* Classes e objetos
* Encapsulamento
* Herança
* Classe abstrata
* Método abstrato
* Sobrescrita de métodos
* Polimorfismo
* Uso de super
* Enum
* Tratamento de exceções
* Exceção personalizada
* Collections com Map e List
* Organização em camadas
* Repository simulando banco de dados em memória
* Service concentrando regras de negócio

Estrutura do projeto

O projeto foi organizado separando responsabilidades:

* entities: classes principais do domínio, como WorkOrder, MaintenanceOrder, InstallationOrder e EmergencyOrder.
* enums: enumeração dos tipos de serviço.
* exceptions: exceção personalizada usada para tratar regras de negócio.
* repositories: camada responsável por armazenar e buscar as ordens de serviço em memória.
* services: camada responsável pelas regras de negócio, como cadastro, busca, cálculo de receita total e identificação da ordem mais cara.
* application: classe principal responsável pela entrada de dados e execução do programa.

Regras de negócio

O sistema valida algumas regras antes de cadastrar ou consultar ordens de serviço:

* O ID da ordem é obrigatório.
* O ID não pode ser repetido.
* O nome do cliente é obrigatório.
* O nome do cliente não pode conter apenas números.
* As horas trabalhadas devem ser maiores que zero.
* O valor por hora deve ser maior que zero.
* Taxas e custos adicionais não podem ser negativos.
* Não é possível buscar uma ordem inexistente.
* Não é possível gerar relatórios sem ordens cadastradas.

Cálculo dos serviços

Manutenção comum

O valor total é calculado com base nas horas trabalhadas e no valor por hora.

Instalação

O valor total é calculado com base nas horas trabalhadas, valor por hora e custo de material.

Serviço emergencial

O valor total é calculado com base nas horas trabalhadas, valor por hora, taxa de emergência e um adicional percentual sobre o valor base.

Objetivo

O objetivo principal deste projeto foi praticar a criação de uma aplicação Java mais organizada, separando responsabilidades entre entidade, repositório e serviço, além de reforçar conceitos de POO, exceções personalizadas e estrutura de código mais próxima de projetos reais.