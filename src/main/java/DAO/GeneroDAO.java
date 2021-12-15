package DAO;

import Factory.ConnectionFactory;
import Models.Genero;

import java.sql.*;

public class GeneroDAO {
    private Connection connection = new ConnectionFactory().getConnection();

    public void criaTabelaGeneno(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS genero_id_seq;";
        sql += "CREATE TABLE IF NOT EXISTS generos (" +
                "genero_id BIGINT PRIMARY KEY DEFAULT nextval('genero_id_seq'),"+
                "nome TEXT);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Genero insereGenero(Genero genero){
        String sql = "INSERT INTO generos "+
                "(nome)" +
                "VALUES (?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,genero.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                genero.setId(resultSet.getLong("genero_id"));
            }
            return genero;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editaGenero(long escolha, Genero genero) {
        String sql = "UPDATE generos SET nome = ? WHERE genero_id = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,genero.getNome());
            statement.setLong(2,escolha);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
