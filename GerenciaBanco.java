package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {
    // Classe interna para dados pessoais e operações bancárias
    private static class Cliente {
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        public Cliente(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public void retirar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Retirada de R$ " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        }

        public void consultarSaldo() {
            System.out.println("Saldo atual: R$ " + saldo);
        }

        public void exibirDadosPessoais() {
            System.out.println("Nome: " + nome + " " + sobrenome);
            System.out.println("CPF: " + cpf);
        }
    }

    // Método para exibir o menu e gerenciar as operações
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de gerenciamento bancário.");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        int opcao;
        do {
            System.out.println("\nMenu de Operações:");
            System.out.println("1. Exibir Dados Pessoais");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente.exibirDadosPessoais();
                    break;
                case 2:
                    cliente.consultarSaldo();
                    break;
                case 3:
                    System.out.print("Digite o valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    cliente.depositar(deposito);
                    break;
                case 4:
                    System.out.print("Digite o valor para retirada: ");
                    double retirada = scanner.nextDouble();
                    cliente.retirar(retirada);
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema de gerenciamento bancário. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
