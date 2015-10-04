package Aplicacion;
import Interface.Entrada.*;
import de.javasoft.plaf.synthetica.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class StartAplication {
    public static void main(String args[]) {
        
        /* Modo de vista de Diseño : Windows */
        //<editor-fold defaultstate="collapsed" desc=" Codigo de Diseño de Vista (opcional) ">
        try {    
            UIManager.setLookAndFeel(SyntheticaAluOxideLookAndFeel.class.getName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
        
        //</editor-fold> 
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IntEnt001_Login().setVisible(true);
            }
        });
    }
}
