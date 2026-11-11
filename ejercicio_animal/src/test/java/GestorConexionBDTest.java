
import co.edu.unilibre.implOperaciones.GestorConexion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestorConexionBDTest {

    GestorConexion gestorConexion;
    @BeforeEach
    public void setUp(){
        gestorConexion = new GestorConexion();
    }
    @Test
    public void conexionOk(){
        assertNotNull(gestorConexion.getConnection());
    }
    @Test
    public void initTest(){
        assertTrue(gestorConexion.init());
    }
}

