package com.lfelipe.alura.music;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int opcao;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1 - Cadastrar Artista");
            System.out.println("2 - Cadastrar Música");
            System.out.println("3 - Listar Músicas");
            System.out.println("4 - Buscar Músicas por Artista");
            System.out.println("5 - Informações sobre um Artista");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Artista selecionado.");
                    break;
                case 2:
                    System.out.println("Cadastrar Música selecionado.");

                    break;
                case 3:
                    System.out.println("Listar Músicas selecionado.");
                    break;
                case 4:
                    System.out.println("Buscar Músicas por Artista selecionado.");
                    break;
                case 5:
                    System.out.println("Informações sobre um Artista selecionado.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
