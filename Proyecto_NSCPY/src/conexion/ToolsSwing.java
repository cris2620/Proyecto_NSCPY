package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import org.slf4j.LoggerFactory;

/**
 * Funcion que maneja los ficheros de una aplicacion
 * @author Christian
 */
public class ToolsSwing {
    private static final transient org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConexionMySQL.class);    
    
    /**
     * Funcion que retorna el contenido de un archivo seleccionado
     * @return una cadena de caracteres del contenido del archivo
     */
    public static String getOpenFile(){
        final StringBuffer StrBuff = new StringBuffer("");
        final JFileChooser JFChooser = new JFileChooser();
        String temp;
        File fileSelected;
        FileReader fileRead;
        BufferedReader BuffReader;
        
        JFChooser.showOpenDialog(JFChooser);
        fileSelected = JFChooser.getSelectedFile();
        if(fileSelected!=null){
            try {
                fileRead = new FileReader(fileSelected);
                BuffReader = new BufferedReader(fileRead);
                temp = BuffReader.readLine();
                while(temp!=null){
                    StrBuff.append(temp);
                    temp = BuffReader.readLine();
                    
                }
                BuffReader.close();
            } 
            catch (FileNotFoundException ex) {
                LOGGER.debug("Error  openFile()");
            } 
            catch (IOException ex) {
                LOGGER.debug("Error  openFile()");
            }
        }
        return StrBuff.toString();
    }
    
    /**
     * Funcion que retorna la URL del Archivo Seleccionado
     * @return una cadena de caracteres de la URL
     */
    public static String getUrlFile(){
        final JFileChooser window = new JFileChooser();
        File fileSelected;
        String url = "";
        try {
            window.showOpenDialog(window);
            fileSelected = window.getSelectedFile();
            url = fileSelected.getAbsolutePath();
        } 
        catch (Exception e) {
        }
        return url;    
    }
    
    /**
     * Funcion que retorna el nombre del archivo seleccionado
     * @return una cadena de caracteres del nombre del archivo
     */
    public static String getNameFile(){
        final JFileChooser window = new JFileChooser();
        File fileSelected;
        String name;
        window.showOpenDialog(window);
        fileSelected = window.getSelectedFile();
        name = fileSelected.getName();
        return name;    
    }
    
    /**
     * Retorna todos los elementos de una JList en un ArrayList
     * @param list lista seleccionada
     * @return ArrayList con los elementos de la JList
     */
    public static ArrayList<String> jlistToArray (JList list){
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0;i < list.getModel().getSize();i++){
            temp.add(String.valueOf(list.getModel().getElementAt(i)));
        }
        return temp;
    }
    
    /**
     * Genera un DefaultListModel apartir de un ArrayList
     * @param arrayList ArrayList base para generar la DefaultListModel 
     * @return DefaultListModel generada
     */
    public static DefaultListModel arrListToDefListModel(ArrayList<String> arrayList){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String list1 : arrayList) {
            model.addElement(list1);
        }
        return model;
    }
    
    /**
     * Agrega un elemento al JList seleccionado
     * @param list      JList contenedor
     * @param element   Elemento a agregar
     */
    public static void addElementJlist(JList list, String element){
        ArrayList<String> arrayEle = new ArrayList<>();
        arrayEle.addAll(jlistToArray(list));
        arrayEle.add(element);
        list.setModel(arrListToDefListModel(arrayEle));
    }
    
    /**
     * Remueve un Elemento del JList
     * @param list      JList contenedor
     * @param element   Elemento a agregar
     */
    public static void delElementJlist(JList list, String element){
        ArrayList<String> arrayEle = new ArrayList<>();
        arrayEle.addAll(jlistToArray(list));
        arrayEle.remove(element);
        list.setModel(arrListToDefListModel(arrayEle));
    }
    
    /**
     * Verifica si todos los caracteres de un String son numeros
     * @param sentence  Sentencia a evaluar
     * @return          Retorna true si Es un numero entero y false en caso contrario
     */
    public static boolean isNumber(String sentence){
        if(sentence.length() == 0) 
            return false;
        for(int i=0;i<sentence.length();i++){
            if(!Character.isDigit(sentence.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica si todos los caracteres de un String son letras Mayusculas o Minusculas ademas de considerar el espacio en blanco
     * @param sentence  Sentencia a evaluar
     * @return          Retorna true si Es un cadena de letras y false en caso contrario
     */
    public static boolean isLetter(String sentence){
        for(int i=0;i<sentence.length();i++){
            if(!Character.isLetter(sentence.charAt(i)) && sentence.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica si todos los caracteres de un String son numeros y ademas solamente un punto "punto decimal"
     * @param sentence  Sentencia a evaluar
     * @return          Retorna true si Es un numero decimal o entero y false en caso contrario
     */
    public static boolean isDecimalNumber(String sentence){
        if(sentence.length() == 0){
            return false;
        }
        boolean point = false;
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i) =='.'){
                if(point){
                    return false;
                }
                else{
                    point = true;
                    continue;
                }
            }
            if(!Character.isDigit(sentence.charAt(i))){
                return false;
            }
        }
        if(point){
            if(sentence.charAt(0) == '.' || sentence.charAt(sentence.length()-1) == '.'){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica se un caracter esta contenido en el arrays de caracteres (Fuerza Bruta)
     * @param filter    Array donde se encuentran los valores validos
     * @param character Caracter a evaluar
     * @return          Retorna true si el caracter se encuentra en el filtro, false en caso contrario
     */
    private static boolean contains(char[] filter, char character){
       for(int i =0;i<filter.length;i++){
           if(character == filter[i]){
               return true;
           }
       }
       return false;
    }
    
    /**
     * Agrupa dos arrays en el orden c=a+b
     * @param a primer array
     * @param b segundo array
     * @return  retorna un array con todos los elementos de a y b
     */
    public static char[] Agrupar(char[] a, char[] b){
        char[] fusion = new char[a.length + b.length];
        System.arraycopy(a, 0, fusion, 0, a.length);
        System.arraycopy(b, 0, fusion, a.length, b.length);
        return fusion;
    }
    
    /**
     * Verifica si una cadena cumple que todos sus elementos se encuentran en las restricciones
     * @param contrains Restricciones de caracteres almacenados en un char[]
     * @param sentence  Sentencia a evaluar
     * @return          Retorna true si la sentencia se encuentra en el filtro, false en caso contrario
     */
    public static boolean limitCharacters(char[] contrains, String sentence){
        for(int i =0;i<sentence.length();i++){
            if(!contains(contrains, sentence.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    //Arrays tipo char que almacenan grupos de caracteres con un criterio en comun
    public static final char[] LETTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ñ',
                                            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ñ'};
    public static final char[] LETTERS_MINUS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ñ'};
    public static final char[] LETTERS_MAYUS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ñ'};
    public static final char[] NUMBERS = {'0','1','2','3','4','5','6','7','8','9'};
    public static final char[] LETTERS_NUMBERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ñ',
                                                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ñ',
                                                        '0','1','2','3','4','5','6','7','8','9'};
    public static final char[] SIMBOLS = {'!','\"','#','$','%','&','/','(',')','=','\'','?','\\','¿','¡','´','¨','+','*','~','{','[','^','}',']','`',',',';','.',':','-','_','@','°','|','¬','<','>'};
}
