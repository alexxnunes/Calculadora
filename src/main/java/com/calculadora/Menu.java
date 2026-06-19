package com.calculadora;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private int opcao = 0;

    void exibirMenu() {
        while (opcao != 5) {
            System.out.println("Escolha a operação");
            System.out.println("1. Somar | 2. Subtrair | 3. Multiplicar | 4. Dividir | 0. Sair");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Operação finalizada!");
                break;
            }

            processarEscolha(opcao);
        }
        scanner.close();
    }

    private void processarEscolha(int opcao) {

        if (opcao < 1 || opcao > 4) {
            System.out.println("Opção inválida!");
            return;
        }

        System.out.print("Digite o primeiro valor: ");
        double v1 = scanner.nextDouble();
        System.out.print("Digite o segundo valor: ");
        double v2 = scanner.nextDouble();

        Operacao operacao = switch (opcao) {
            case 1 -> new Soma();
            case 2 -> new Subtracao();
            case 3 -> new Multiplicar();
            case 4 -> new Dividir();
            default -> null;
        };

        System.out.println("Resultado: " + operacao.calcular(v1, v2));
    }
}
