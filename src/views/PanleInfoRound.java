/*
 * 
 */
package views;

import controller.Events;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Constants;
import models.GroupSoldier;
import models.PointPosition;

/**
 *
 * @author Andreck san
 */
public class PanleInfoRound extends JPanel{
    
    private lableCustom lbllevel;
    private lableCustom lblpoints;
    private lableCustom lblTime;
    private BtnCardSoldier cardSoldier;
    private int points;

    public PanleInfoRound(ActionListener action) {
        points = 0;
        setLayout(new GridLayout(10, 1));
        
        lbllevel = new lableCustom();
            
        add(lbllevel);
        
        lblpoints = new lableCustom();
        
        add(lblpoints);
        
        lblTime = new lableCustom();
        
        add(lblTime);
        
        Image image = new ImageIcon(getClass().getResource(Constants.GROUP_SOLDIER)).getImage();
        GroupSoldier soldier = new GroupSoldier(200, 3, 1,image, new PointPosition(0, 0), 10, 60, 60);
        
        cardSoldier = new BtnCardSoldier(soldier, "", Constants.GROUP_SOLDIER);
            cardSoldier.addActionListener(action);
            cardSoldier.setActionCommand(Events.ADD_GROUP_ARCHER.toString());
        add(cardSoldier);
    }
    
    public void setLevel(int level){
        lbllevel.setText("Level: " + level);
    }
    
    public void setPointsToShow(int newpoints){
        points = newpoints;
        lblpoints.setText("Points: " + points);
    }
    
    public void addPointsToShow(int addingpoints){
        points += addingpoints;
        lblpoints.setText("Points: " + points);
    }
    
    public void setTime(String timetext){
        lblTime.setText("time: " + timetext);
    }
    
}
