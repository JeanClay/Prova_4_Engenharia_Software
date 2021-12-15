package View;

import Controllers.LivroController;
import Models.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroView {
    LivroController controller = new LivroController();

    public void inicial(){
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Cadastra livro");
        System.out.println("2 - Encontrar por ID");
        System.out.println("3 - Encontrar por Biblioteca");
        System.out.println("4 - Encontrar por genero");

        int escolha = input.nextInt();
        switch (escolha){
            case 1:
                cadastraLivro();
                break;
            case 2:
                mostraPorId();
                break;
            case 3:
                mostraPorBiblioteca();
                break;
            case 4:
                mostraPorGenero();
                break;
            default:
                break;
        }

    }

    public void cadastraLivro() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite nome do livro");
        String nome = input.nextLine();
        System.out.println("Escolha seu genero");
        //listar generos via generoview
        int genero = input.nextInt();
        System.out.println("Escolha a biblioteca");
        int biblioteca = input.nextInt();

        controller.cadastraLivro(nome,genero,biblioteca );
    }

    public void mostraPorId(){
        Scanner input = new Scanner(System.in);

        //lista livros
        System.out.println("escolha o livro");
        int escolha = input.nextInt();

        Livro livro = controller.mostraPorId(escolha);

        System.out.println(livro);
    }

    private void mostraPorBiblioteca() {
        Scanner input = new Scanner(System.in);
        //lista biblioteca
        System.out.println("Escolha a biblioteca");
        int escolha = input.nextInt();

        System.out.println(controller.mostraPorBiblioteca(escolha));

    }

    public void mostraPorGenero(){
        Scanner input = new Scanner(System.in);

        //lista generos
        System.out.println("escolha o genero");
        int escolha = input.nextInt();

        System.out.println(controller.mostraPorGenero(escolha));
    }
}
