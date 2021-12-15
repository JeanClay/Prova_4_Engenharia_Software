package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
