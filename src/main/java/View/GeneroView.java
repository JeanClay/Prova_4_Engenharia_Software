package View;

import Controllers.GeneroController;

import java.util.Scanner;

public class GeneroView {
    GeneroController controller = new GeneroController();

    public void inicial(){
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Cadastrar Genero");
        System.out.println("2 - Editar Genero");
        int escolha = input.nextInt();

        switch (escolha){
            case 1:
                insereGenero();
                break;
            case 2:
                editaGenero();
                break;
            default:
                break;
        }
    }

    private void editaGenero() {
        Scanner input = new Scanner(System.in);

//        lista generos
//        escolhe qual genero mudar
//        int escolha = input.nextInt();
        System.out.println("digite novo nome");
        String nome = input.nextLine();
//        controller.editaGenero(escolha, nome);
        controller.editaGenero(nome);
    }

    private void insereGenero() {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do Genero");
        String nome = input.nextLine();

        controller.insereGenero(nome);
    }
}
