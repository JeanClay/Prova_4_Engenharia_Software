package Controllers;

import DAO.LivroDAO;
import Models.Biblioteca;
import Models.Genero;
import Models.Livro;

import java.util.List;

public class LivroController {
    LivroDAO dao = new LivroDAO();
    public void cadastraLivro(String nome, int genero, int biblioteca) {
        Livro novoLivro = new Livro();
        Genero novogenero = new Genero();
        Biblioteca novaBiblioteca = new Biblioteca();

        novoLivro.setNome(nome);
        novogenero.setId((long)genero);
        novaBiblioteca.setId((long) biblioteca);
        novoLivro.setGenero(novogenero);
        novoLivro.setBiblioteca(novaBiblioteca);

        dao.cadastraLivro(novoLivro);
    }

    public Livro mostraPorId(int escolha) {
        return dao.getById(escolha);
    }

    public List<Livro> mostraPorGenero(int escolha) {
        Genero genero = new Genero();
        genero.setId((long) escolha);

        return dao.getByGenero(genero);
    }

    public List<Livro> mostraPorBiblioteca(int escolha) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId((long) escolha);

        return dao.getByBiblioteca(biblioteca);
    }
}
