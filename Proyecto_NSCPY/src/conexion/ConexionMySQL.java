package conexion;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.slf4j.LoggerFactory;

/**
 * Driver que controla la conexion con la Base de Datos MySql
 * Implementando facilidades en la insercion, modificacion y eliminacion de registros en la Base de Datos
 * Implementa Funciones para mostrar las consultas y vistas en Jtables y JcomboBox entre otros swing's
 * @version 1.0
 * @author Christian
 */
public class ConexionMySQL {
    private Connection conexion;
    private PreparedStatement preStatement;
    private ResultSet result;
    private DatabaseMetaData metaData;
    
    private final String usuario;
    private final String password;
    private final String dataBase;
    private final String server;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConexionMySQL.class);
    
    /**
     * Crea la conexion con la Base de datos, de acuerdo a los parametros ingresados
     * @param user      Usuario de la Base de Datos
     * @param pwd       Contraseña del usuario para la Base de Datos
     * @param DB        Base de Datos en la que se esta trabajando
     * @param server    Server donde se aloja la base de datos
     */
    public ConexionMySQL(String user, String pwd, String DB, String server) {
        this.usuario = user;
        this.password = pwd;
        this.dataBase = DB;
        this.server = server;
    }
    
    /**
     * Crea la conexion con la Base de datos, de acuerdo a los parametros ingresados
     * EL server se establece por defecto server="localhost"
     * @param user  Usuario de la Base de Datos
     * @param pwd   Contraseña del usuario para la Base de Datos
     * @param DB    Base de Datos en la que se esta trabajando
     */
    public ConexionMySQL(String user, String pwd, String DB) {
        this.usuario = user;
        this.password = pwd;
        this.dataBase = DB;
        this.server = "localhost";
    }
    
    /**
     * Inicia la conexion con la Base de Datos, este es un paso obligatorio para realizar cualquier otra operacion
     * @return Devuelve "true" si inicia correctamente y "false" en caso contrario
     */
    public boolean start(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+"/"+dataBase,usuario,password);
            return true;
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error start: " + dataBase + ", Usuario: " + usuario +", pwd: " + password );
            return false;
        }
        catch (ClassNotFoundException ex) {
            return false;
        } 
    }
    
    /**
     * Cierra la Conexion con la Base de Datos
     * La conexion debe estar iniciada "start()" antes de ejecutar esta instruccion
     * @return Devuelve "true" si cierra correctamente y "false" en caso contrario
     */       
    public boolean close(){
        try {
            conexion.close();
            return true;
        } catch (SQLException ex) {
            LOGGER.debug("Error al Cerrar la Base de Datos: " + dataBase);
            return false;
        }
    }
    
    /**
     * Metodo accesor a Usuario
     * @return Atributo usuario
     */
    public String getUsuario(){
        return usuario;
    }
    
    /**
     * Metodo accesor a Password
     * @return Atributo password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Metodo accesor a la Base de Datos
     * @return Atributo dataBase
     */
    public String getDataBase(){
        return dataBase;
    }
    
    /**
     * Metodo accesor al servidor
     * @return atributo server
     */
    public String getServer(){
        return server;
    }
    
    /**
     * Devuelve todas las Bases de Datos que tiene acceso esta coneccion
     * @return ArrayList con los nombres de las Bases de Datos accesibles
     */
    public ArrayList<String> getAllDataBases(){
        ArrayList<String> dataBases = new ArrayList<>();
        try {
            this.preStatement = conexion.prepareStatement("show databases");
            result = this.preStatement.executeQuery();
            while(result.next()){
                dataBases.add(result.getString(1));
            }
        } catch (SQLException ex) {
            LOGGER.debug("Error getAllDataBases: " + usuario + ", " +dataBase+ ", " + server);
            
        }
        return dataBases;
    }
    
    /**
     * Devuelve todas las Tablas que tiene la base de datos consultada
     * @return ArrayList con los nombres de las Tablas de la base de Datos
     */
    public ArrayList<String> getAllTables(){
        ArrayList<String> columns = new ArrayList<>(); 
        try {
            metaData = conexion.getMetaData(); 
            result = metaData.getTables(null, null, "%",new String[]{"TABLE"});
            while(result.next()){
                columns.add(result.getString("TABLE_NAME"));
            }       
        } catch (SQLException ex) {
            LOGGER.debug("Error getAllTables dataBase: "+  dataBase );
        }
        return columns;
    }
    
    /**
     * Devuelve todas los atributos que tienen la Tabla consultada
     * @param tableName Nombre de la tabla que se esta consultando
     * @return          ArrayList con los nombres de los atributos de la Tabla consultada
     */
    public ArrayList<String> getAllStats(String tableName){
        ArrayList<String> columns = new ArrayList<>(); 
        try {
            metaData = conexion.getMetaData(); 
            result = metaData.getColumns(null, null, tableName, null);
            while(result.next()){
                columns.add(result.getString("COLUMN_NAME"));
            }            
        } catch (SQLException ex) {
            LOGGER.debug("Error getAllStats BD: " +  dataBase + " Tabla: " + tableName);
        }
        return columns;
    }
    
    /**
     * Funciones especializada para realizar las siguientes operaciones en la Base de Datos
     * Insercion    INSERT INTO ...(...) VALUES(...);
     * Eliminacion  DELETE FROM ... WHERE ...;
     * Modificacion UPDATE ... SET ... WHERE ...;
     * Se debe asegurar que la operacion esta correctamente escrita de lo contrario no se ejecutara
     * @param statement Operacion que se va a desplegar
     * @return          Devuelve "true" si la operacion se despliega correctamente y "false" en caso contrario
     */
    public boolean UpdateSQL(String statement){
        try {
            this.preStatement = conexion.prepareStatement(statement);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.debug("Error  UpdateSQL: "+ statement + "\"");
            return false;
        }
        
    }
    
    /**
     * Limpia una Jtable de la interfaz de java, cabecera y datos
     * @param table Nombre del objeto Jtable a limpiar
     */
    private void cleanJtable(JTable table){
        table.getTableHeader().setReorderingAllowed(false) ;
        table.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    
    /**
     * Limpia una Jtable de la interfaz de java, cabecera y datos y coloca una nueva cabecera
     * @param table     Nombre del objeto Jtable a limpiar
     * @param columns   Array de la cabecera de la tabla a insertar
     */
    private void cleanJtable(JTable table, String[] columns){
        table.getTableHeader().setReorderingAllowed(false) ;
        table.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    
    /**
     * Limpia una Jtable de la interfaz de java, cabecera y datos y coloca una nueva cabecera
     * @param table     Nombre del objeto Jtable a limpiar
     * @param columns   ArrayList de la cabecera de la tabla a insertar
     */
    private void cleanJtable(JTable table, ArrayList<String> columns){
        int size = columns.size();
        String[] values = new String[size];
        for(int i =0;i< size;i++){
            values[i] = columns.get(i);
        }
        table.getTableHeader().setReorderingAllowed(false) ;
        table.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},values){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    
    /**
     * Inserta el contenido de un tablas MySQL a una tabla Jtable
     * @param table     Contendedor Jtable
     * @param nameTable Nombre de la Tabla MySQL
     * @return          Retorna true si la operacion es exitosa y false en caso contrario
     */
    public boolean putJTable(JTable table,String nameTable){
        ArrayList<String> stats =  new ArrayList<>();
        DefaultTableModel DTM;
        try {
            stats.addAll(getAllStats(nameTable));
            cleanJtable(table,stats);
            DTM = (DefaultTableModel) table.getModel();
            preStatement = conexion.prepareStatement("SELECT * FROM " + nameTable);
            result = preStatement.executeQuery();
            Object [] registro = new Object[stats.size()];
            while(result.next()){
                for(int i =1; i <= stats.size(); i++){
                    registro[i-1] = result.getObject(i);
                }
                DTM.addRow(registro); 
            }
            return true; 
        } catch (SQLException ex) {
            LOGGER.debug("Error putJTable-> JTable: "+table.getName()+", MySQLTable: "+nameTable);
            return false;
        }       
    }
    
    /**
     * Inserta el contenido de un tablas MySQL a una tabla Jtable
     * Los registros deben cumplir la condicion para poder ser ingresados en el Jtable
     * La condicion usa la misma sintaxis de MySQL "atr = val and ..."
     * @param table     Contendedor Jtable
     * @param nameTable Nombre de la Tabla MySQL
     * @param condicion Condicion que deben cumplir los registros para mostrarse en la Jtable
     * @return          Retorna true si la operacion es exitosa y false en caso contrario
     */
    public boolean putJTable(JTable table, String nameTable, String condicion){
        ArrayList<String> stats =  new ArrayList<>();
        DefaultTableModel DTM;
        String statement ="SELECT * FROM "+nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }
        try {
            stats.addAll(getAllStats(nameTable));
            cleanJtable(table,stats);
            DTM = (DefaultTableModel) table.getModel();
            this.preStatement = conexion.prepareStatement(statement);
            result = this.preStatement.executeQuery();
            Object [] registro = new Object[stats.size()];
            while(result.next()){
                for(int i =1; i <= stats.size(); i++){
                    registro[i-1] = result.getObject(i);
                }
                DTM.addRow(registro); 
            }
            return true;
            
        } catch (SQLException ex) {
            LOGGER.debug("Error putJTable-> JTable: "+table.getName()+", MySQLTable: "+nameTable + ", Condicion: " + condicion);
            return false;
        }       
    }
    
    /**
     * Inserta el contenido de un tablas MySQL a una tabla Jtable
     * Adicionalmente coloca el nombre de cada columna independientemente de su contenido
     * EL numero de columnas de nombres debe coincidir con el numero de columnas de la SQLtable
     * @param table         Contendedor Jtable
     * @param nameTable     Nombre de la Tabla MySQL
     * @param nameColumns   Nombre de las columnas de la Jtable
     * @return              Retorna true si la operacion es exitosa y false en caso contrario
     */
    public boolean putJTable(JTable table,String nameTable, String[] nameColumns){
        DefaultTableModel DTM;
        int size = nameColumns.length;
        try {
            cleanJtable(table,nameColumns);
            DTM = (DefaultTableModel) table.getModel();
            preStatement = conexion.prepareStatement("SELECT * FROM " + nameTable);
            result = preStatement.executeQuery();
            Object [] registro = new Object[size];
            while(result.next()){
                for(int i =1; i <= size; i++){
                    registro[i-1] = result.getObject(i);
                }
                DTM.addRow(registro); 
            }
            return true; 
        } catch (SQLException ex) {
            LOGGER.debug("Error putJTable-> JTable: "+table.getName()+", MySQLTable: "+nameTable);
            return false;
        }       
    }
    
    /**
     * Inserta el contenido de un tablas MySQL a una tabla Jtable
     * Adicionalmente coloca el nombre de cada columna independientemente de su contenido
     * EL numero de columnas de nombres debe coincidir con el numero de columnas de la SQLtable
     * @param table         Contendedor Jtable
     * @param nameTable     Nombre de la Tabla MySQL
     * @param nameColumns   Nombres de las columnas de la Jtable
     * @return              Retorna true si la operacion es exitosa y false en caso contrario
     */
    public boolean putJTable(JTable table,String nameTable, ArrayList<String> nameColumns){
        DefaultTableModel DTM;
        int size = nameColumns.size();
        try {
            cleanJtable(table,nameColumns);
            DTM = (DefaultTableModel) table.getModel();
            preStatement = conexion.prepareStatement("SELECT * FROM " + nameTable);
            result = preStatement.executeQuery();
            Object [] registro = new Object[size];
            while(result.next()){
                for(int i =1; i <= size; i++){
                    registro[i-1] = result.getObject(i);
                }
                DTM.addRow(registro); 
            }
            return true; 
        } catch (SQLException ex) {
            LOGGER.debug("Error putJTable-> JTable: "+table.getName()+", MySQLTable: "+nameTable);
            return false;
        }       
    }
    
    /**
     * Calcula la cantidad de columnas que tiene la Tabla de MySQL mensianada
     * @param nameTable Nombre de la Tabla MySQL
     * @return          Retorna un entero con la cantidad de columnas, en caso de que la consulta falle retorna -1
     */
    private int getSizeTable(String nameTable){
        try {
            String size;
            preStatement = conexion.prepareStatement("SELECT COUNT(*) FROM information_schema.columns WHERE table_name = '"+nameTable+"'");
            result = preStatement.executeQuery();
            result.next();
            size = result.getString(1);
            if(size == null || !Character.isDigit(size.charAt(0))){
                LOGGER.debug("Error  getSizeTable SqlTable: "+ nameTable);
                return -1;
            }
            return Integer.parseInt(size);
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error  getSizeTable SqlTable: "+ nameTable);
            return -1;
        }
    }
    
    /**
     * Funcion que facilita la Insercion en tablas MySQL
     * Solo se ingresa los datos de datesToInsert
     * INSERT INTO SqlTable (atr1,atr2,atr3) values (datesToInsert);
     * @param nameTable     Nombre de la Tabla MySQL
     * @param datesToInsert Datos del registro a ingresar
     * @return              Retorna true si la operacion es exitosa, false en caso contrario
     */
    public boolean insertMySQL(String nameTable, String datesToInsert){
        String statement = "INSERT INTO "+ dataBase +"."+ nameTable + " ( ";
        String dates = "";
        ArrayList<String> stats = new ArrayList<>();
        stats.addAll(getAllStats(nameTable));
        for (String stat : stats) {
            dates += stat + ",";
        }
        if(dates.length() >0){
            dates = dates.substring(0, dates.length()-1) + " ) ";
        }
        statement += dates + " values " + "( " + datesToInsert + " )";
        
        try {
            preStatement = conexion.prepareStatement(statement);
            preStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.debug("Error  insertMySQL: "+statement);
            return false;
        }
    }
    
    /**
     * Devuelve el resultado de una consulta a un Arraylist con una cantidad de parametros determinado
     * @param statement consulta en MySQL
     * @param cantParams cantidad de parametros a consultar
     * @return retorna una ArrayList de String[] con la consulta
     */
    
    public ArrayList<String[]> queryMySQL( String statement, int cantParams){
        ArrayList<String[]> rpt = new ArrayList<>();
        String[] obj = new String[cantParams];
        try {
            preStatement = conexion.prepareStatement(statement);
            result = preStatement.executeQuery();
            while(result.next()){
                for (int i = 0; i < cantParams; i++) {
                    obj[i] = result.getString(i+1);
                }
                rpt.add(clone(obj));
            }
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error queryMySQL: "+ statement);
        }
        return rpt;
    }
    
    /**
     * Devuelve el resultado de una consulta a un Arraylist
     * @param nameTable Nombre de la tabla MySQL
     * @param stat      Atributo Consultado
     * @param condicion Condicion que deben cumplir los registros para ser eliminados
     * @return          ArrayList respuesta
     */
    public ArrayList<String> queryMySQL( String nameTable ,String stat, String condicion){
        ArrayList<String> rpt = new ArrayList<>();
        String statement = "SELECT " + stat + " FROM " + nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }  
        try {
            preStatement = conexion.prepareStatement(statement);
            result = preStatement.executeQuery();
            while(result.next()){  
                rpt.add(result.getString(1));
            }
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error queryMySQL: "+ statement);
        }
        return rpt;
    }
    
    /**
     * Devuelve el primer elemento de una consulta
     * @param nameTable Nombre de la tabla MySQL
     * @param stat      Atributo Consultado
     * @param condicion Condicion que deben cumplir los registros para ser eliminados
     * @return          ArrayList respuesta
     */
    public String queryOneEleMySQL( String nameTable ,String stat, String condicion){
        String rpt="";
        String statement = "SELECT " + stat + " FROM " + nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }  
        try {
            preStatement = conexion.prepareStatement(statement);
            result = preStatement.executeQuery(); 
            result.next();
            rpt = result.getString(1);
            
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error queryOneEleMySQL: "+ statement);
        }
        return rpt;
    }
    
    /**
     * Funcion que facilita la Eliminacion de Registros
     * Solo se ingresan los datos de la condicion
     * DELETE FROM tableSQL WHERE condicion;
     * @param nameTable Nombre de la Table MySQL
     * @param condicion Condicion que deben cumplir los registros para ser eliminados
     * @return          Retorna true si la operacion es exitosa, false en caso contrario
     */
    public boolean deleteMySQL(String nameTable, String condicion){
        String statement = "DELETE FROM "+ dataBase +"."+ nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }
        try {
            preStatement = conexion.prepareStatement(statement);
            preStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.debug("Error deleteMySQL: "+statement);
            return false;
        }
    }
    
    /**
     * Funcion que facilita la Actualizacion de Registros
     * Solo se ingresan los datos a modificar y la condicion
     * UPDATE tableSQL SET values WHERE condicion;
     * @param nameTable Nombre de la Table MySQL
     * @param values    Valores a modificar atr1 = val1, ...
     * @param condicion Condicion que deben cumplir los registros para ser modificados
     * @return          Retorna true si la operacion es exitosa, false en caso contrario
     */
    public boolean updateMySQL(String nameTable,String values, String condicion){
        String statement = "UPDATE " + dataBase + "." + nameTable + " SET " + values;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }
        try {
            preStatement = conexion.prepareStatement(statement);
            preStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.debug("Error updateMySQL: "+statement);
            return false;
        }
        
    }
    
    /**
     * Ingresa a un JComboBox los valores de un ArrayList
     * @param jComboBox Nombre del JComboBox
     * @param values objeto ArrayList con los valores a ingresar
     */
    public static void putJComboBox(JComboBox jComboBox,ArrayList<String> values){
        jComboBox.removeAllItems();
        for (String value : values) {
            jComboBox.addItem(value);
        }
    }
    
    /**
     * Retorna una Fila en forma de String[] de un Jtable
     * @param table nombre de la JTable
     * @param numRow numero de fila
     * @return un String[] con los valores de la fila consultada
     */
    public static String[] getRow(JTable table,int numRow){
        int columns = table.getColumnCount();
        String [] row = new String[columns];
        for(int i = 0; i < columns ;i++){
            row[i] = table.getValueAt(numRow, i).toString();
        }
        return row;
    }
    
    /**
     * Ingresa el resultado de una consulta en un JComboBox
     * La consulta debera ser de una sola columna para su correcta ejecucion
     * SELECT column FROM SQLTable WHERE condicion
     * @param jComboBox Nombre del JComboBox
     * @param nameTable Nombre de la Table MySQL
     * @param column    Columna a ingresar en el JComboBox del SQLTable
     * @param condicion Condicion que deben cumplir los registros para ser considerados
     * @return          Retorna true si la operacion fue exitosa y false en caso contrario
     */
    public boolean putJComboBox(JComboBox jComboBox, String nameTable, String column, String condicion){
        jComboBox.removeAllItems();
        String statement = "SELECT " + column + " FROM " + nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }
        try {
            preStatement = conexion.prepareStatement(statement);
            result = preStatement.executeQuery();
            while(result.next()){   
                jComboBox.addItem(result.getString(1)); 
            }
            return true;
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error putJComboBox: "+ statement);
            return false;
        }  
    }
    
     // Muestra en un comboBox  la fila 1 de la tabla sqlTable
     // y almacena en un arrayList la fila 2
     // condicion puedes estar vacio y si no lo esta debera ser escrita en lenguaje sql "WHERE ..."
    /**
     * Ingresa el resultado de una consulta en un JComboBox
     * La consulta debera ser de la clave y de una columna que se desea mostrar para su seleccion
     * SELECT key, row FROM tableSQL WHERE condicion
     * @param jComboBox Nombre del JComboBox
     * @param nameTable Nombre de la tabla SQL
     * @param key       Llave que se desea almacenar en el ArrayList
     * @param row       Datos que se desean mostrar en el jComboBox
     * @param listKeys  ArrayList que almacena las llaves
     * @param condicion Condicion que deben cumplir los registros para ser considerados
     * @return          Retorna true si la operacion fue exitosa y false en caso contrario
     */
    public boolean putJComboBox(JComboBox jComboBox, String nameTable ,String key, String row, ArrayList<String> listKeys, String condicion){
        jComboBox.removeAllItems();
        String statement = "SELECT " + key + " , " + row +" FROM " + nameTable;
        if(condicion.trim().length() != 0){
            statement+=" WHERE " + condicion;
        }  
        try {
            preStatement = conexion.prepareStatement(statement);
            result = preStatement.executeQuery();
            while(result.next()){  
                listKeys.add(result.getString(1));
                jComboBox.addItem(result.getString(2));
            }
            return true;
        } 
        catch (SQLException ex) {
            LOGGER.debug("Error putJComboBox: "+ statement);
            return false;
        }  
    }
    
    public String[] clone (String[] obj){
        String[] temp = new String[obj.length];
        System.arraycopy(obj, 0, temp, 0, temp.length);
        return temp;
    }
}
