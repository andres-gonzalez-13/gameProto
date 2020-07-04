/*
 * 
 */
package views;

import java.awt.Color;
import javax.swing.JLabel;
import models.Constants;

/**
 *
 * @author Andreck san
 */
public class lableCustom extends JLabel{

    public lableCustom() {
        setOpaque(true);
        setBorder(Constants.BlackBorder);
        setFont(Constants.titleMiddle);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        
    }
    
    
    
}
