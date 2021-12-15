package Controllers;

import DAO.GeneroDAO;
import Models.Genero;

public class GeneroController {
    GeneroDAO dao = new GeneroDAO();

    public void insereGenero(String nome) {
        Genero novoGenero = new Genero();
        novoGenero.setNome(nome);

        novoGenero = dao.insereGenero(novoGenero);
    }

    public void editaGenero(String nome) {
        Genero genero = new Genero();

        genero.setNome(nome);

        dao.editaGenero(genero);
    }
}
