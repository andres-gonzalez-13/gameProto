package controller;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.text.Position;
import models.Constants;
import models.DimensionsEntity;
import models.EntityMoving;
import models.EntityManager;
import models.EntityStatic;
import models.GroupSoldier;
import models.LevelManager;
import models.PointPosition;
import views.FrameVideoGame;

/**
 *
 * @author Andreck san
 */
public class Control extends MouseAdapter implements ActionListener{

    private FrameVideoGame frameVideo;
    private MouseListener mouseradapt;
    private boolean addingArcher;
    private Timer timerPlaying; 
    private LevelManager levelManager;
    
    public Control() {
        initMouseAdapter();
        levelManager = new LevelManager();
        addingArcher = false;
        frameVideo = new FrameVideoGame(mouseradapt, this);
        
        frameVideo.goToMainMenu();        
    }
    
    public void createTimerPlaying(){
        timerPlaying = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelManager.getActualSeconds() < levelManager.getActuallevel().getSecondEndLevel()){
                    levelManager.spendaSecond();
                    frameVideo.getPanelInforound().setTime("0:" + levelManager.getActualSeconds());
                    
                    if(levelManager.getActuallevel().getActualWave() != null){
                        ArrayList<EntityMoving>listmoving = new ArrayList<>();                        
                        listmoving = levelManager.getActuallevel().getActualWave().getListEnemys();
                        
//                        for (EntityMoving ing : listmoving) {
//                            System.out.println("antes de dibujar " + ing.getActualPos().getX() + " - " + ing.getActualPos().getY());
//                        }
                        frameVideo.addEntities(listmoving);
                        
                    }
                    
                    
                }else{
                    levelManager.setActualSeconds(0);
                    
                    
                    timerPlaying.stop();
                }
            }
        });
    }
    
    private void initMouseAdapter(){
        mouseradapt = new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println(e.getX() + " - " + e.getY());
                //checkClickedEntity(e.getX(), e.getY());
            }                        

            @Override
            public void mouseEntered(MouseEvent me) {
                
                //checkClickedEntity(me.getX(), me.getY());
//                Rectangle rect = new Rectangle(jPanelDrawArea.getSize());
//                if (rect.contains(me.getPoint())) {
//                        //jPanelDrawArea.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
//                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!addingArcher){
                    checkClickedEntity(e.getX(), e.getY());   
                }else{
                    addArcherInPosition(e.getX(), e.getY());
                }       
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(!addingArcher){
                    checkClickedEntity(e.getX(), e.getY());   
                }else{
                    addArcherInPosition(e.getX(), e.getY());
                }                            
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //checkClickedEntity(e.getX(), e.getY());                
            }                        
        };
    }
    
    private void addArcherInPosition(int x, int y) {
        //System.out.println("archerrrrr");
        Image image = new ImageIcon(getClass().getResource(Constants.GROUP_SOLDIER)).getImage();
        int width = 80;
        int height = 65;
        double shotPerSecond = 1;
        //Image image = new ImageIcon(getClass().getResource(Constants.GROUP_SOLDIER)).getImage();
        GroupSoldier soldier = new GroupSoldier(200, 3, shotPerSecond,image, new PointPosition(x-width/2, y-height/2), 10, 80, 65);
        frameVideo.getPanelDraw().addArcher(soldier);
        addingArcher = false;
    }
    
    public void notifyMousePosition(int xmouse, int ymouse){
        
        
    }
    
//    public void playSound(final String path){
//    //http://www.soundsboom.com/
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//            try {
//                Clip clip = AudioSystem.getClip();
//                AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
//                clip.open(inputStream);
//                clip.start();
//            } catch (LineUnavailableException |UnsupportedAudioFileException | IOException e) {
//                e.printStackTrace();
//            }
//
//            }
//        }).start();
//    }
    
    private void checkClickedEntity(int x, int y) {
        ArrayList<EntityMoving> listenti = frameVideo.getPanelDraw().getListEntitiesMoving();            
        for (EntityMoving entity : listenti) {
            if(entity.ckeckClicked(x, y)){
                
                Image image = new ImageIcon(getClass().getResource(Constants.COIN_SPRITE)).getImage();
                EntityStatic coin = new EntityStatic(image, new PointPosition(x, y), 2, 50, 50);
                
                
                frameVideo.getPanelDraw().addCoinToShow(coin);
            }
        }        
        for (EntityStatic entity : frameVideo.getPanelDraw().getListCoins()) {
            
            if(entity.ckeckClicked(x, y) && entity.isIsAlive()){
                entity.doDamageHealth(1);    
                if(!entity.isIsAlive()){
                    frameVideo.getPanelInforound().addPointsToShow(10);
                }                    
            }
        }                
    }      

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(Events.valueOf(e.getActionCommand())){
            case START_GAME:
                createTimerPlaying();
                timerPlaying.start();
                //corregir
                
                frameVideo.getPanelDraw().Startlevel();
                frameVideo.startGame();
                break;
            case ADD_GROUP_ARCHER:    
                addingArcher = true;
                break;
            case CONTINUE_GAME:
                
                break;
        }
    }
    
}
