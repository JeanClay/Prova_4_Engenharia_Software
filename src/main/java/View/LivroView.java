package View;

import Controllers.LivroController;
import Models.Livro;

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
                break;
            case 4:
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

        controller.cadastraLivro(nome,genero);
    }

    public void mostraPorId(){
        Scanner input = new Scanner(System.in);

        //lista livros
        System.out.println("escolha o livro");
        int escolha = input.nextInt();

        Livro livro = controller.mostraPorId(escolha);
    }
}
