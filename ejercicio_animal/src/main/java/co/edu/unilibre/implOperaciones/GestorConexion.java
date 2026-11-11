package co.edu.unilibre.implOperaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GestorConexion {

    private String user = "neondb_owner";
    private String password = "npg_wp2MQaU0xiLb";
    private String host="ep-morning-glade-bdmsch7b-pooler.c-8.us-east-2.aws.neon.tech";
    private String bd="neondb";
    private String url="jdbc:postgresql://" + host + "/" +bd;

    public Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
    public boolean init(){
        String sql = "create table if not exists animales(" +
                "id serial not null," +
                "nombre varchar(30) not null," +
                "edad integer not null,"+
                "vuela boolean not null,"+
                "genero varchar(30) not null,"+
                "peso numeric(3,1) not null)";


        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }




}
