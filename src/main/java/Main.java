import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;
import View.BibliotecaView;
import View.GeneroView;
import View.LivroView;

import java.util.Scanner;

public class Main {
    public static void comecaTabelas(){
        new BibliotecaDAO().criaTabelaBiblioteca();
        new GeneroDAO().criaTabelaGeneno();
        new LivroDAO().criaTabelaLivros();
    }

    public static void main(String[] args) {
        comecaTabelas();

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("1 - Menu Biblioteca");
            System.out.println("2 - Menu Categoria");
            System.out.println("3 - Menu Livro");
            System.out.println("0 - sair");

            int escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    new BibliotecaView().menuInicial();
                    break;
                case 2:
                    new GeneroView().inicial();
                    break;
                case 3:
                    new LivroView().inicial();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}
