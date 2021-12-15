package DAO;

import Factory.ConnectionFactory;
import Models.Livro;

import java.sql.*;

public class LivroDAO {
    private Connection connection = new ConnectionFactory().getConnection();

    public void criaTabelaLivros(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS livros_id_seq";
        sql += "CREATE TABLE IF NOT EXISTS livros (" +
                "livro_id BIGINT PRIMARY KEY DEFAULT nextval('livros_id_seq')," +
                "nome TEXT," +
                "genero BIGINT " +
                "CONSTRAINT fk_genero_livro "+
                    "FOREING KEY (genero) " +
                    "REFERENCES generos(genero_id)" +
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
                "(nome, ,genero) "+
                "VALUES (? , ?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, livro.getNome());
            statement.setLong(2,livro.getGenero().getId());
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
        String sql = "SELECT FROM livros WHERE livro_id = ?";

        Livro livro = null;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                livro.setId(resultSet.getLong("livro_id"));
                livro.setNome(resultSet.getString("nome"));
                livro.getGenero().setId(resultSet.getLong("genero"));
            }
            return livro;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
