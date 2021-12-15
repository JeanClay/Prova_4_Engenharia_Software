import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;

public class Main {
    public static void comecaTabelas(){
        new GeneroDAO().criaTabelaGeneno();
        new BibliotecaDAO().criaTabelaBiblioteca();
        new LivroDAO().criaTabelaLivros();
    }

    public static void main(String[] args) {
        comecaTabelas();
    }
}
