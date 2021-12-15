package View;

import Controllers.BibliotecaController;

import java.util.Scanner;

public class BibliotecaView {
    BibliotecaController controller = new BibliotecaController();

    public void menuInicial(){
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Cadastra biblioteca");

        int escolha = input.nextInt();
        switch (escolha){
            case 1:
                insereBiblioteca();
        }
    }

    private void insereBiblioteca() {
        Scanner input = new Scanner(System.in);
        System.out.println("nome da biblioteca");
        String nome = input.nextLine();
        controller.insereBiblioteca(nome);
    }
}
