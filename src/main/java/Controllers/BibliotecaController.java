package Controllers;

import DAO.BibliotecaDAO;

public class BibliotecaController {
    BibliotecaDAO dao = new BibliotecaDAO();

    public void insereBiblioteca(String nome) {
        dao.insereBiblioteca(nome);
    }
}
