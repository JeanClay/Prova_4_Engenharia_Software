package DAO;

import Factory.ConnectionFactory;

import java.sql.*;

public class BibliotecaDAO {
    private Connection connection = new ConnectionFactory().getConnection();

    public void criaTabelaBiblioteca(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS biblioteca_id_seq;";
        sql += "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "biblioteca_id BIGINT PRIMARY KEY DEFAULT nextval('biblioteca_id_seq')," +
                "nome TEXT);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void insereBiblioteca(String biblioteca){
        String sql = "INSERT INTO bibliotecas " +
                "(nome)" +
                "VALUES(?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,biblioteca);
            statement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
