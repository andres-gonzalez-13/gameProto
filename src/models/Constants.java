
package models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

public class Constants {
    
    public static final Font linkButons = new Font("",Font.BOLD,20);
    public static final Font titleMiddle = new Font("", Font.BOLD,23);
    public static final Font tinyfont = new Font("",Font.BOLD,16);
    
    
    public static final String PALE_YELLOW = "#F7F8E0";
    public static final String GRAY_UPTC = "#999999";
    public static final String USER_PHOTO = "src/images/user_uptc.png";
    public static final String BACK_GROUND = "/sprites/Map_16.png";
    public static final String WOOD_COLOR = "#5C312B";
    
    
    public static final String GOOD_STAR = "/images/full_star.png";
    public static final String VOID_STAR = "/images/void_star.png";
    public static final String SIGE_UPTC = "/images/Escudo_UPTC.svg.png";
    public static final String COIN_SPRITE = "/sprites/coin_pix.png";
    public static final String TANK_UP_SPRITE = "/sprites/tank_up.png";
    public static final String PIG_UP_SPRITE = "/sprites/pig_up.png";
    public static final String PIG_DOWN_SPRITE = "/sprites/pig_down.png";
    public static final String GROUP_SOLDIER = "/sprites/group.png";
    //public static final Font linkButons = new Font("",Font.BOLD,20);

    
    public static final MatteBorder bordeButton = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode(Constants.GRAY_UPTC));
    public static final MatteBorder whiteBorder = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE);
    public static final MatteBorder BlackBorder = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK);
    public static final MatteBorder bordetiny = BorderFactory.createMatteBorder(6, 6, 6, 6, Color.WHITE);
    
    public static final MatteBorder bordet1 = BorderFactory.createMatteBorder(0, 6, 0, 0, Color.WHITE);
    
     public static final String YELLOW_UPTC = "#e4a900";
     public static final String NOT_BLACK = "#232220";
     public static final String NOT_WHITE = "#e2e0e0";
    
    
    
    public static void launchwarnigFormatMessage(){
        JOptionPane.showMessageDialog(null, "formato invalido" + "\n" + "seleccione un archivo mp3" );
    }
    
    public static void launchwarnigLogInMessage(){
        JOptionPane.showMessageDialog(null, "No disponilbe" + "\n" + "Ingrese como usuario para permitir" );
    }
    
    public static void launchwarnigNotNumbertMessage(){
        JOptionPane.showMessageDialog(null, "formato invalido" + "\n" + "seleccione un codigo valido" );
    }
    
    public static void launchwarnigVoidSpaceMessage(){
        JOptionPane.showMessageDialog(null, "formato invalido" + "\n" + "seleccione un archivo mp3" );
    }

    public static void launchWaningLogWrong() {
        JOptionPane.showMessageDialog(null, "Ususario no encotrado" + "\n" + "por favor verifique los datos" );
    }

    public static void laucngNoRateInThisSong() {
        JOptionPane.showMessageDialog(null, "Calificacion ya hecha" + "\n" + "el usuario ya ha calificado esta canción" );
    }

    public static void launchWarnigChagedDates() {
        JOptionPane.showMessageDialog(null, "Datos cambiados" + "\n" + "el codigo de la universidad no ha cambiado" );
    }
    
}
