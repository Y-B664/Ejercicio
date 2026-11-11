package co.edu.unilibre.implOperaciones;

import co.edu.unilibre.dto.Animal;
import co.edu.unilibre.operacionesBD.GenericDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplOperacionesBD implements GenericDAO<Animal> {

    GestorConexion gestorConexion = new GestorConexion();
    Connection connection;

    public ImplOperacionesBD() {
        connection = gestorConexion.getConnection();
    }

    @Override
    public boolean create(Animal objeto) {
        if(objeto ==  null){
            return false;
        }
        String sql = "insert into animales (nombre,edad,genero,vuela,peso)values(?,?,?,?,?)";
        if(connection != null){
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, objeto.getNombre());
                preparedStatement.setInt(2,objeto.getEdad());
                preparedStatement.setString(3,objeto.getGenero());
                preparedStatement.setBoolean(4,objeto.isVuela());
                preparedStatement.setDouble(5,objeto.getPeso());
                int retorno = preparedStatement.executeUpdate();
                if(retorno > 0){
                    return true;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Animal> getTodos() {
        List<Animal> animales = new ArrayList<>();
        if(connection != null){
            String sql = "Select * from animales";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Animal animal = new Animal();
                    animal.setId(resultSet.getInt(1));
                    animal.setNombre(resultSet.getString(2));
                    animal.setEdad(resultSet.getInt(3));
                    animal.setVuela(resultSet.getBoolean(4));
                    animal.setGenero(resultSet.getString(5));
                    animal.setPeso(resultSet.getDouble(6));
                    animales.add(animal);
                }
                return animales;
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
