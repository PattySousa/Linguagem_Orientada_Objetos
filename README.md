# Linguagem_Orientada_Objetos
Trabalho de Linguagem Orientada a Objetos - Unopar

=> Desenvolvimento de uma aplicação em Java simulando um sistema Bancário




DESENVOLVIMENTO

O procedimento seguido na instalação das ferramentas NetBeans, Java e  precisava seguir os seguintes passos recomentados:
1.Instalação o NetBeans, conforme link abaixo: https://dlcdn.apache.org/netbeans/netbeans/15/netbeans-15-bin.zip.
2.Download do JDK - JAVA: https://jdk.java.net/archive/ , ele fornece as bibliotecas essenciais para a execução de aplicativos JAVA, foi devidamente configurado e funcionou corretamente.
3.Depois de todos os arquivos baixados e instalado o NetBeans, foi criado um novo Projeto do Tipo Java Application em Java with Maven na IDE Netbeans chamado “gerenciaBanco”, onde desenvolvi o código descrito abaixo, na linguagem de programação JAVA, conforme os requisitos pedidos para este projeto, detalhados no tópico 4, a seguir.
4.Utilizando os principais conceitos do paradigma de Orientação a Objetos, crie uma pequena aplicação de gerenciamento bancário que possibilite ao usuário informar seu nome, sobrenome e CPF. Além disso, a aplicação deverá possibilitar ao usuário consultar saldo, realizar depósitos e saques. Esses procedimentos devem se repetir até que o usuário escolha encerrar o uso da aplicação. Procedimentos para a realização das atividades. Precisei seguir estas configurações abaixo
 A - Vá ao menu File e em seguida clique sobre New Project. Na sequência, deve-se escolher a categoriaJava with Maven > Java Application.
B - Em seguida, deve-se avançar e, na tela seguinte, dar o nome ao projeto. Como já mencionado, sugere utilizar o nome gerenciaBanco. 
C - Construa a aplicação em um único arquivo do tipo Java main Class. Isso porque o método principal, que é chamado pela máquina virtual, deve estar nesse mesmo arquivo. 
D - No seu código você deverá construir, basicamente: 
a) a classe principal 
b) classe para dados pessoais e operações bancárias 
c) método para exibição do menu. 
E - Para a exibição do menu, será necessário utilizar uma estrutura de decisão para tratamento das escolhas do usuário. Sugere-se utilizar a estrutura do...while e switch..case.


Resultado obtido após rodar o código, que funcionou corretamente, pedindo  
(Digite seu nome) imput do nome, digitei o meu => Patrícia


Depois, pediu o sobrenome, digitei o meu => Sousa 


Em seguida, a entrada para adicionar o CPF, digitei um número aleatório, com a mesma quantidade de dígitos do CPF (11 dígitos) – digitei 01234567891, destacado em laranja.





Mostra as opções no Menu de Operações: 
1.	Exibir Dados Pessoais
2.	Consultar Saldo
3.	Depositar
4.	Retirar
5.	Sair 
6.	Mandei rodar o exemplo e confirmou sucesso nas configurações e atividades propostas, conforme imagens a seguir:

Escolha uma opção, então, escolhi a opção 3 (Depositar) e digitei 10, para (simular um Depósito de R$10,00), conforme print da figura a seguir.

Confirmou que o depósito de R$10,00 foi realizado com sucesso.


E depois, escolhi a opção 4 (Retirar) e digitei 5, para simular uma retirada de R$5,00, conforme print da imagem anterior. Apareceu (print acima), retirada de R$5,00 realizada com sucesso


                                                                                                                                                 Escolhi a opção 2, para Consultar Saldo, retornando, Saldo atual: R$5,00, conforme print acima.








Finalizando, na opção 5 (sair) aparece a mensagem Obrigado por usar o gerenciamento bancário. Até logo!


A Seguir, colei o código que desenvolvi em Java para este projeto:


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





					CONCLUSÃO


	Após  utilizar o Netbeans e a linguagem Java, com as configurações necessárias, foi possível simular um sistema bancário, com dados pessoais do cliente (Nome, Sobrenome, CPF) para cadastro, depósito, saque, saldo e sair do sistema, onde acrescentei uma mensagem de agradecimento e despedida. 
	Finalizando os passos necessários para a elaboração deste projeto, descrito neste Pórtfólio.




                                                                           
