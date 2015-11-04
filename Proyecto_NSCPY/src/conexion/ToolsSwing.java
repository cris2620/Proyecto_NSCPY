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
        String url;
        window.showOpenDialog(window);
        fileSelected = window.getSelectedFile();
        url = fileSelected.getAbsolutePath();
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
}
