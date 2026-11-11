
import co.edu.unilibre.dto.Animal;
import co.edu.unilibre.implOperaciones.GestorConexion;
import co.edu.unilibre.implOperaciones.ImplOperacionesBD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class impBDTest {

    GestorConexion gestorConexion;
    ImplOperacionesBD impOperacionesBD;
    Connection connection;
    @BeforeEach
    public void setUp(){
        gestorConexion = new GestorConexion();
        impOperacionesBD = new ImplOperacionesBD();
        connection = gestorConexion.getConnection();
        gestorConexion.init();
    }
    @Test
    public void createOk(){
        Animal Animal = new Animal(10,"pan",false,"hembra",45.6);
        boolean retornado = impOperacionesBD.create(Animal);
        assertTrue(retornado);
    }
    @Test
    public void createAnimalNull(){
        boolean retornado = impOperacionesBD.create(null);
        assertFalse(retornado);
    }
    @Test
    public void getTodosOk(){
        List<Animal> AnimalsAntes = impOperacionesBD.getTodos();
        Animal Animal = new Animal(12,"pan 2",false,"macho",35.6);
        impOperacionesBD.create(Animal);
        List<Animal> AnimalsDespues = impOperacionesBD.getTodos();
        assertEquals(AnimalsAntes.size()+1,AnimalsDespues.size());
    }


}
