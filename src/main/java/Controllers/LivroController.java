package Controllers;

import DAO.LivroDAO;
import Models.Livro;

public class LivroController {
    LivroDAO dao = new LivroDAO();
    public void cadastraLivro(String nome, int genero) {
        Livro novoLivro = new Livro();

        novoLivro.setNome(nome);
        novoLivro.getGenero().setId((long)genero);

        dao.cadastraLivro(novoLivro);
    }
}
