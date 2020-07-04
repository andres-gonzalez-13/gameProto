/*
 * 
 */
package views;

import controller.Events;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Constants;

/**
 *
 * @author Andreck san
 */
public class StartPanelMenu extends JPanel{

    private JLabel lblvoid1;
    private JLabel lblvoid2;
    
    private JPanel panelMenu;
    private Image imageBackgound;
    private BtnStandar btnStart;
    private BtnStandar btnContinue;
    private JPanel panelFake;
    private boolean thereIsData;
    private Font fontstart;
    
    public StartPanelMenu(ActionListener action){
        setLayout(new GridLayout(1,3));
        //setBackground(Color.red);
        String path = "/fonts/Plain Germanica.ttf";
        URL url = getClass().getResource(path);
        
            try {
                fontstart = Font.createFont(Font.PLAIN, new File(url.toURI()));
                
            } catch (FontFormatException ex) {
                Logger.getLogger(StartPanelMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StartPanelMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex){
                
            }
       
        thereIsData = false;
        imageBackgound = new ImageIcon(getClass().getResource("/images/C4TkyIrWYAADSyy.png")).getImage();
        lblvoid1 = new JLabel();
        add(lblvoid1);
        
        panelMenu = new JPanel();            
            panelMenu.setLayout(new GridLayout(7, 1));
            panelMenu.setOpaque(false);
            
            panelFake = new JPanel();
            panelFake.setOpaque(false);
            
            Font newFontBtn = fontstart.deriveFont(fontstart.getSize() * 43F);
            
            btnContinue = new BtnStandar("Continue", "");
                btnContinue.addActionListener(action);
                btnContinue.setActionCommand(Events.CONTINUE_GAME.toString());
                btnContinue.setFont(newFontBtn);
                btnContinue.setBackground(Color.decode(Constants.WOOD_COLOR));
                btnContinue.setForeground(Color.WHITE);
            btnStart = new BtnStandar("Start", "");            
                btnStart.addActionListener(action);
                btnStart.setActionCommand(Events.START_GAME.toString());
                btnStart.setFont(newFontBtn);
                btnStart.setBorder(Constants.bordeButton);
                btnStart.setBackground(Color.decode(Constants.WOOD_COLOR));
                btnStart.setForeground(Color.WHITE);
        add(panelMenu);
        
        
        lblvoid2 = new JLabel();
        add(lblvoid2);
        
        repaintButtons();
    }

    public void setThereIsData(boolean thereIsData) {
        this.thereIsData = thereIsData;
    }
    
    
    
    public void repaintButtons(){
        panelMenu.removeAll();
        panelMenu.add(panelFake);
        
        if(thereIsData){
            panelMenu.add(btnContinue);
        }
        
        panelMenu.add(btnStart);
        
    }
    //panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));

    @Override
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setPreferredSize(getParent().getSize());
            g.drawImage(
            new ImageIcon(imageBackgound.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)).getImage(),
            0, 0, this);
            if(fontstart != null){
                g.setColor(Color.WHITE);
                Font newFont2 = fontstart.deriveFont(fontstart.getSize() * 83F);
                g.setFont(newFont2);
                g.setFont(newFont2);
                g.drawString("Asault in the forest", 285, 500);
                Font newFont = fontstart.deriveFont(fontstart.getSize() * 80F);
                g.setColor(Color.BLACK);
                g.setFont(newFont);
                g.setFont(newFont);
                g.drawString("Asault in the forest", 300, 504);
                
            }
            
    }
    
    
    
}
