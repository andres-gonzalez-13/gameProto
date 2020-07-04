
package views;

import controller.Control;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.EntityMoving;

/**
 *
 * @author Andreck san
 */
public class FrameVideoGame extends JFrame{
    
    
    private JPanel mainPanel;
    private PanelDrawArea panelDraw;
    private PanleInfoRound panelInforound;
    
    private StartPanelMenu startmenu;
    public static final String ICON_IMAGE = "/images/iconfinder_gamecontroller_1055053.png";
    public static final String TITLE_FRAME = "prototype game";
    
    public FrameVideoGame(MouseListener mouseradapter, ActionListener action ) {
        setTitle("prototype game");
        setLayout(new BorderLayout());
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setExtendedState(MAXIMIZED_BOTH);
        setSize(1200, 700);
        setIconImage(new ImageIcon(getClass().getResource(ICON_IMAGE)).getImage());
        setResizable(false);
        mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
        
        add(mainPanel, BorderLayout.CENTER);
        
        
        
        panelDraw = new PanelDrawArea(mouseradapter);               
        
        panelInforound = new PanleInfoRound(action);
            panelInforound.setLevel(1);
            panelInforound.setPointsToShow(0);
            panelInforound.setTime("2:00");        
        
        startmenu = new StartPanelMenu(action);
        
        
        setVisible(true);
    }

    
    public void goToMainMenu(){
        mainPanel.removeAll();
        mainPanel.add(startmenu, BorderLayout.CENTER);
        repaint();
        revalidate();
    }
    
    //colocar prametor de comienzo
    public void startGame(){
        mainPanel.removeAll();
        panelDraw.Startlevel();
        mainPanel.add(panelDraw, BorderLayout.CENTER);
        mainPanel.add(panelInforound, BorderLayout.WEST);
        
        repaint();
        revalidate();
    }
    
    public void addEntities(ArrayList<EntityMoving>listEntity){
        panelDraw.AddNewToDrawtEntities(listEntity);        
    }

    public PanelDrawArea getPanelDraw() {
        return panelDraw;
    }

    public PanleInfoRound getPanelInforound() {
        return panelInforound;
    }
        
    
}
