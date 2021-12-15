package DAO;

import Factory.ConnectionFactory;
import Models.Biblioteca;
import Models.Genero;
import Models.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection connection = new ConnectionFactory().getConnection();

    public void criaTabelaLivros(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS livros_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS livros (" +
                "livro_id BIGINT PRIMARY KEY DEFAULT nextval('livros_id_seq')," +
                "nome TEXT," +
                "genero BIGINT, " +
                "biblioteca BIGINT, "+
                "CONSTRAINT fk_genero_livro "+
                    "FOREIGN KEY (genero) " +
                    "REFERENCES generos(genero_id)" +
                    "ON DELETE CASCADE, "+
                "CONSTRAINT fk_biblioteca_livro "+
                    "FOREIGN KEY (biblioteca)"+
                    "REFERENCES bibliotecas(biblioteca_id)" +
                    "ON DELETE CASCADE"+
                ");";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro cadastraLivro(Livro livro){
        String sql = "INSERT INTO livros "+
                "(nome, genero, biblioteca) "+
                "VALUES (? , ?, ?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, livro.getNome());
            statement.setLong(2,livro.getGenero().getId());
            statement.setLong(3,livro.getBiblioteca().getId());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                livro.setId(resultSet.getLong("livro_id"));
            }
            return livro;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro getById(long id){
        String sql = "SELECT * FROM livros WHERE livro_id = ?";

        Livro livro = null;
        Genero genero ;
        Biblioteca biblioteca ;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                livro = new Livro();
                genero = new Genero();
                biblioteca = new Biblioteca();
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));
                genero.setId(resultSet.getLong("genero"));
                livro.setGenero(genero);
                biblioteca.setId(resultSet.getLong("biblioteca"));
                livro.setBiblioteca(biblioteca);
            }
            return livro;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Livro> getByGenero(Genero genero){
        String sql = "SELECT * FROM livros WHERE genero = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,genero.getId());
            ResultSet resultSet = statement.executeQuery();

            List<Livro> livroList = new ArrayList<>();
            Livro livro ;

            Biblioteca biblioteca ;

            while (resultSet.next()){
                livro = new Livro();
                biblioteca = new Biblioteca();
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));
                livro.setGenero(genero);
                biblioteca.setId(resultSet.getLong("biblioteca"));
                livro.setBiblioteca(biblioteca);
                livroList.add(livro);
            }
            return livroList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Livro> getByBiblioteca(Biblioteca biblioteca){
        String sql = "SELECT * FROM livros WHERE biblioteca = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1,biblioteca.getId());
            ResultSet resultSet = statement.executeQuery();

            List<Livro> livroList = new ArrayList<>();
            Livro livro;
            Genero genero ;


            while (resultSet.next()){
                livro = new Livro();
                genero = new Genero();

                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));
                genero.setId(resultSet.getLong("genero"));
                livro.setGenero(genero);
                livro.setBiblioteca(biblioteca);
                livroList.add(livro);
            }
            return livroList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
