import Conexion.ConexionMySQL;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas Unitarias para la Clase TConexion
 * Conexion con la Base de Datos
 * @author Christian
 */
public class TConexionSQL {
    Conexion.ConexionMySQL conect;
    ArrayList<String> array1;
    ArrayList<String> array2;
    public TConexionSQL() {
        conect = new ConexionMySQL("admin", "admin", "SI_NSCPY");
        array1 = new ArrayList<>();
        array2 = new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Pruebas unitarias de Acceso
     */
    @Test
    public void Test1(){
        assertTrue(conect.start());
        assertTrue(conect.close()); 
    }
    
    /**
     * Pruebas de consultas sin parametros
     */
    @Test
    public void Test2(){
        //Inicialicion de variables
        array1.clear();
        array1.add("CilCod");
        array1.add("CilNom");
        
        array2.clear();
        array2.add("CilOther");
        array2.add("otherExample");
        //finalicacion de inicializacion
        
        conect.start();
        assertEquals("SI_NSCPY", conect.getDataBase());
        assertNotSame("other", conect.getDataBase());
        assertEquals(array1, conect.getAllStats("ciclo"));
        assertNotSame(array2, conect.getAllStats("ciclo"));
        conect.close();
    }
}
