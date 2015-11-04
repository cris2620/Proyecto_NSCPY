import conexion.ConexionMySQL;
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
    conexion.ConexionMySQL conect;
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
    public void TStart(){
        assertTrue(conect.start());
        assertTrue(conect.close()); 
    }
    
    /**
     * Pruebas de consultas
     */
    @Test
    public void TStats(){
        conect.start();  //inicializacion  

        // Nombre de base de datos
        assertEquals("SI_NSCPY", conect.getDataBase());
        assertNotSame("other", conect.getDataBase());
        
        //atributos de las tablas
        
        //array de error 2 
        array2.clear();
        array2.add("other");
        array2.add("otherExample");
        
        //ciclo
        array1.clear();
        array1.add("CilCod");
        array1.add("CilNom");
        assertEquals(array1, conect.getAllStats("ciclo"));
        assertNotSame(array2, conect.getAllStats("ciclo"));
        
        //grado
        array1.clear();
        array1.add("GraCod");
        array1.add("GraNom");
        assertEquals(array1, conect.getAllStats("grado"));
        assertNotSame(array2, conect.getAllStats("grado"));
        
        //alergia
        array1.clear();
        array1.add("AleCod");
        array1.add("AleNom");
        assertEquals(array1, conect.getAllStats("alergia"));
        assertNotSame(array2, conect.getAllStats("alergia"));
        
        //discapacidad
        array1.clear();
        array1.add("DisCod");
        array1.add("DisNom");
        assertEquals(array1, conect.getAllStats("discapacidad"));
        assertNotSame(array2, conect.getAllStats("discapacidad"));
        
        //sistema
        array1.clear();
        array1.add("SisCod");
        array1.add("SisNom");
        assertEquals(array1, conect.getAllStats("sistema"));
        assertNotSame(array2, conect.getAllStats("sistema"));
       
        //institucion
        array1.clear();
        array1.add("InsCod");
        array1.add("InsNom");
        array1.add("InsNum");
        assertEquals(array1, conect.getAllStats("institucion"));
        assertNotSame(array2, conect.getAllStats("institucion"));
        
        //institucion_tipo
        array1.clear();
        array1.add("DocTipCod");
        array1.add("DocTipNom");
        assertEquals(array1, conect.getAllStats("documento_tipo"));
        assertNotSame(array2, conect.getAllStats("documento_tipo"));
        
        //institucion
        array1.clear();
        array1.add("DocTipCod");
        array1.add("DocTipNom");
        assertEquals(array1, conect.getAllStats("documento_tipo"));
        assertNotSame(array2, conect.getAllStats("documento_tipo"));
        
        //documento
        array1.clear();
        array1.add("DocCod");
        array1.add("DocNom");
        array1.add("DocFec");
        array1.add("DocTipCod");
        array1.add("DocURL");
        assertEquals(array1, conect.getAllStats("documento"));
        assertNotSame(array2, conect.getAllStats("documento"));
        
        //usuario
        array1.clear();
        array1.add("UsuLog");
        array1.add("UsuPwd");
        array1.add("UsuTipCod");
        assertEquals(array1, conect.getAllStats("usuario"));
        assertNotSame(array2, conect.getAllStats("usuario"));
        
        //profesor
        array1.clear();
        array1.add("ProfCod");
        array1.add("ProResMag");
        array1.add("ProGraEns");
        array1.add("ProCanHor");
        array1.add("PerCod");
        array1.add("ConCod");
        array1.add("EstCod");
        array1.add("UsuLog");
        assertEquals(array1, conect.getAllStats("profesor"));
        assertNotSame(array2, conect.getAllStats("profesor"));
        
        //director
        array1.clear();
        array1.add("DirCod");
        array1.add("DirResMag");
        array1.add("PerCod");
        array1.add("ConCod");
        array1.add("EstCod");
        array1.add("UsuLog");
        assertEquals(array1, conect.getAllStats("director"));
        assertNotSame(array2, conect.getAllStats("director"));
        
        //alumno
        array1.clear();
        array1.add("AluCod");
        array1.add("AluObs");
        array1.add("GraCod");
        array1.add("UsuLog");
        array1.add("PerCod");
        assertEquals(array1, conect.getAllStats("alumno"));
        assertNotSame(array2, conect.getAllStats("alumno"));
        
        //padre
        array1.clear();
        array1.add("PadCod");
        array1.add("OcuCod");
        array1.add("PerCod");
        assertEquals(array1, conect.getAllStats("padre"));
        assertNotSame(array2, conect.getAllStats("padre"));
        
        //persona
        array1.clear();
        array1.add("PerCod");
        array1.add("PerApePat");
        array1.add("PerApeMat");
        array1.add("PerNom");
        array1.add("PerDNI");
        array1.add("PerFecNac");
        array1.add("PerDir");
        array1.add("SexCod");
        array1.add("RelCod");
        array1.add("NacCod");
        array1.add("LenMatCod");
        array1.add("GraInsCod");
        assertEquals(array1, conect.getAllStats("persona"));
        assertNotSame(array2, conect.getAllStats("persona"));
        
        //libreta
        array1.clear();
        array1.add("LibCod");
        array1.add("LibAño");
        array1.add("CilCod");
        array1.add("TriCod");
        array1.add("GraCod");
        array1.add("AluCod");
        array1.add("ProfCod");
        array1.add("LibURL");
        assertEquals(array1, conect.getAllStats("libreta"));
        assertNotSame(array2, conect.getAllStats("libreta"));
        
        //registro
        array1.clear();
        array1.add("RegCod");
        array1.add("RegAño");
        array1.add("CilCod");
        array1.add("TriCod");
        array1.add("GraCod");
        array1.add("ProfCod");
        array1.add("RegURL");
        assertEquals(array1, conect.getAllStats("registro"));
        assertNotSame(array2, conect.getAllStats("registro"));
        
        conect.close(); //cerrar conexion
    }
    
    /**
     * Pruebas de Tablas
     */
    @Test
    public void TTables(){
        conect.start();  //inicializacion  

        // Nombre de base de datos
        assertEquals("SI_NSCPY", conect.getDataBase());
        assertNotSame("other", conect.getDataBase());
        
        //atributos de las tablas
        
        //array de error 2 
        array2.clear();
        array2.add("other");
        array2.add("otherExample");
        
        //Tablas de la Base de Datos
        array1.clear();
        array1.add("alergia");
        array1.add("alumno");
        array1.add("alumno_padres");
        array1.add("ciclo");
        array1.add("contrato");
        array1.add("director");
        array1.add("discapacidad");    
        array1.add("documento");
        array1.add("documento_tipo");
        array1.add("estado");
        array1.add("grado");
        array1.add("grado_instruccion");
        array1.add("institucion");
        array1.add("institucion_documentos");    
        array1.add("lengua_materna");
        array1.add("libreta");
        array1.add("libreta_registros");
        array1.add("nacionalidad");
        array1.add("ocupacion");
        array1.add("padre");
        array1.add("parentesco");
        array1.add("persona");     
        array1.add("persona_alergias");
        array1.add("persona_discapacidades");
        array1.add("persona_documentos");
        array1.add("profesor");
        array1.add("registro");
        array1.add("religion");
        array1.add("sexo");   
        array1.add("sistema");
        array1.add("sistema_instituciones");
        array1.add("sistema_usuarios");
        array1.add("trimestre");
        array1.add("usuario");
        array1.add("usuario_tipo");

        assertEquals(array1, conect.getAllTables());
        assertNotSame(array2, conect.getAllTables());
        
        conect.close(); //cerrar conexion
    }
    
    /**
     * Insercion modificacion y eliminacion de registros
     * Estas pruebas estan ligadas muy fuertemente a la BD del programa, no modificar si no conoce con seguridad lo que esta haciendo
     */
    @Test
    public void TDml(){
        conect.start();  //inicializacion
        
        //creamos un registro y lo eliminamos
        assertTrue(conect.UpdateSQL("INSERT INTO alergia (AleCod, AleNom) VALUES ('1','Penicilina');"));
        assertTrue(conect.UpdateSQL("DELETE FROM alergia WHERE AleCod='1';"));
        
        //creamos un registro
        assertTrue(conect.UpdateSQL("INSERT INTO alergia (AleCod, AleNom) VALUES ('1','cloroformo');"));
        
        //modificamos un registro
        assertTrue(conect.UpdateSQL("UPDATE alergia SET AleNom='Dioxido de Carbono' WHERE AleCod='1';"));
        
        //eliminacion del registro creado anteriormente
        assertTrue(conect.UpdateSQL("DELETE FROM alergia WHERE AleCod='1';"));
        
        conect.close(); //cerrar conexion
    }
   
}
