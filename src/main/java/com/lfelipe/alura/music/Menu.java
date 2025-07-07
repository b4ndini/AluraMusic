package com.lfelipe.alura.music;

import com.lfelipe.alura.music.controller.GroqController;
import com.lfelipe.alura.music.model.Artista;
import com.lfelipe.alura.music.model.Genero;
import com.lfelipe.alura.music.model.Musica;
import com.lfelipe.alura.music.model.TipoArtista;
import com.lfelipe.alura.music.repository.ArtistaRepository;
import com.lfelipe.alura.music.repository.MusicaRepository;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ArtistaRepository artistaRepository;
    private final MusicaRepository musicaRepository;
    private final GroqController groqController;

    public Menu(ArtistaRepository artistaRepository, MusicaRepository musicaRepository, GroqController groqController) {
        this.musicaRepository = musicaRepository;
        this.artistaRepository = artistaRepository;
        this.groqController = groqController;
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
                    cadastrarMusica();
                    break;
                case 3:
                    System.out.println("Listar Músicas selecionado.");
                    break;
                case 4:
                    System.out.println("Buscar Músicas por Artista selecionado.");
                    break;
                case 5:
                    mostrarInformacoesArtistaPesquisado();
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

    private void mostrarInformacoesArtistaPesquisado() {
        System.out.println("Digite o nome do artista/banda a ser pesquisado:");
        String artista = scanner.nextLine();
        String busca = "Pesquise em pt-br a banda/artista " + artista;
        groqController.getQrogAnswer(busca);
    }

    private void cadastrarMusica() {
        System.out.println("=== Cadastro de Musica ===");
        System.out.println("Nome da Música:");
        String nomeMusica = scanner.nextLine();
        System.out.println("Duração da música:");
        String duracao = scanner.nextLine();
        Artista artista = getArtista();
        System.out.println("Tipo");
        System.out.println("Selecione um gênero para a música:");
        mostrarSelecionadorEnums(Genero.class);
        int generoSelecionado = scanner.nextInt();

        try {
            musicaRepository.save(new Musica(nomeMusica, duracao, Genero.values()[generoSelecionado - 1], artista));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opção inválida!!");
        } catch (Exception e) {
            System.out.println("Não foi possível salvar a música.\n" + e.getLocalizedMessage());
        }
    }

    private Artista getArtista() {
            do {
                System.out.println("Digite o nome do artista:");
                String nomeArtista = scanner.nextLine();
                Optional<Artista> artistaDoBanco = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
                if (artistaDoBanco.isPresent()) {
                    return artistaDoBanco.get();
                } else {
                    System.out.println("Artista não encontrado!");
                }
            } while(true);
        }


    private void cadastrarArtista(){
        System.out.println("=== Cadastro de Artista ===");
        System.out.println("Digite o nome do(s) artista(s)/banda:");
        String nome = scanner.nextLine();
        System.out.println("Digite o tipo de artista(s):(Solo, Dupla ou Banda)");
        mostrarSelecionadorEnums(TipoArtista.class);
        int opcaoTipoArtista = scanner.nextInt();

        try{
            artistaRepository.save(new Artista(nome, TipoArtista.values()[opcaoTipoArtista-1]));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Opção inválida!!");
        }catch (Exception e){
            System.out.println("Não foi possível cadastrar o artista.\n" + e.getLocalizedMessage());
        }
    }

    private <T extends Enum<T>> void mostrarSelecionadorEnums(Class<T> enumClass) {
        T[] valores = enumClass.getEnumConstants();
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + " - " + valores[i]);
        }
    }
}
