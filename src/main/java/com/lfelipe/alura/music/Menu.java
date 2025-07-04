package com.lfelipe.alura.music;

import com.lfelipe.alura.music.model.Artista;
import com.lfelipe.alura.music.model.TipoArtista;
import com.lfelipe.alura.music.repository.ArtistaRepository;
import com.lfelipe.alura.music.repository.MusicaRepository;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ArtistaRepository artistaRepository;
    private final MusicaRepository musicaRepository;

    public Menu(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.musicaRepository =  musicaRepository;
        this.artistaRepository = artistaRepository;
    }

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
                    cadastrarArtista();
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

    private void cadastrarArtista(){
        System.out.println("=== Cadastro de Artista ===");
        System.out.println("Digite o nome do(s) artista(s)/banda:");
        String nome = scanner.nextLine();
        System.out.println("Digite o tipo de artista(s):(Solo, Dupla ou Banda)");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i+ " - " + TipoArtista.values()[i-1]);
        }
        int opcaoTipoArtista = scanner.nextInt();

        try{
            artistaRepository.save(new Artista(nome, TipoArtista.values()[opcaoTipoArtista-1]));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Opção inválida!!");
        }catch (Exception e){
            System.out.println("Não foi possível cadastrar o artista.\n" + e.getLocalizedMessage());
        }
    }
}
