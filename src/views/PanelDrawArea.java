
package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.Constants;

import models.EntityMoving;
import models.EntityStatic;
import models.GroupSoldier;
import models.LevelInfo;
import models.PointPosition;

/**
 *
 * @author Andreck san
 */
public class PanelDrawArea extends JPanel{
    
    //private CustomThread graphThread;
    private ArrayList<EntityMoving>listEntitiesMoving;
    private ArrayList<EntityStatic>listCoins;
    private ArrayList<GroupSoldier>listSoldiers;
    
    private Image imageBackgound;
    private Timer gameLoop;
    private BufferedImage imageback;
    
    public static final int FPS = 30;
    public static final long FPMS = TimeUnit.SECONDS.toMillis(1) / FPS;
    
    private volatile long startTime;
    private volatile long lastTime;
    private volatile long fps;
    private volatile long fpsCount;
    
    private int xMouse;
    private int yMouse;

    public PanelDrawArea(MouseListener mouseadapter) {
        addMouseListener(mouseadapter);
	//addMouseMotionLr(mouseadapter);
        xMouse = 0;
        yMouse = 0;
        
        imageBackgound = new ImageIcon(getClass().getResource("/sprites/Map_16.png")).getImage();
        //imageback = new BufferedImage();
        listEntitiesMoving = new ArrayList<>();
        listCoins = new ArrayList<>();
        listSoldiers = new ArrayList<>();
        
        gameLoop = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startTime = System.nanoTime();
                moveEachenemy();
                repaint();
                Toolkit.getDefaultToolkit().sync();
                long delta = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
                int delay = (int)(FPMS - delta) < 0 ? 1 : (int)(FPMS - delta) ;
                gameLoop.setDelay(delay);
                fpsCount++;
                if(System.nanoTime() - lastTime >= TimeUnit.SECONDS.toNanos(1)){
                    fps = fpsCount;
                    fpsCount = 0;
                    lastTime = System.nanoTime();
                }
            }
        });
        //initThread();
    }     
    
    public void Startlevel(){
        gameLoop.start();
        lastTime = System.nanoTime();
    }

    public void paint(Graphics g){
    	super.paint(g);
        
    	//initThread();
        //moveEachenemy();
        //dibujar fondo
        //imageback.
        g.drawImage(imageBackgound, 0, 0, getWidth(), getHeight(), this);
        //dibujar objetos animados
        checkCollisions();
        drawEntities(g);
        drawSoldiers(g);
        drawCoins(g);
    }
    
    
     
    public void moveEachenemy(){

        for (EntityMoving listEntity : listEntitiesMoving) {
            if(listEntity.isInTheMap()){
                listEntity.moveStep();
            }
            
        }
    }
    
    public void checkCollisions(){
        for (EntityMoving entity : listEntitiesMoving) {
            
            for (GroupSoldier soldier : listSoldiers) {
                if(soldier.getShape().getBounds2D().intersects(entity.getShape().getBounds2D())){
                    if(soldier.isShooting()){
                        Image image = new ImageIcon(getClass().getResource(Constants.COIN_SPRITE)).getImage();                 
                        EntityStatic coin = new EntityStatic(image, 
                                new PointPosition(entity.getActualPos().getX(), entity.getActualPos().getY()),
                                3, 50, 50);
                        addCoinToShow(coin);
                        soldier.reloading();
                    }
                        
                }
            }
        }    
    }
    
    private void drawEntities(Graphics g) {
        int count = 0;
        for (EntityMoving actual : listEntitiesMoving) {
            if(actual.isInTheMap()){
                count++;
                
                //System.out.println(count + " - " + actual.getActualPos().getX());
                g.drawImage(actual.getImageEntity(), (int)actual.getActualPos().getX(),
                    (int)actual.getActualPos().getY(), actual.getHeight(),
                    actual.getWidth(), this);
            }
            
       }
    }
    
    private void drawSoldiers(Graphics g){
        for(GroupSoldier soldier: listSoldiers){
            if(soldier.isIsAlive()){
                g.drawImage(soldier.getImageEntity(), (int)soldier.getActualPos().getX(),
                    (int)soldier.getActualPos().getY(), soldier.getHeight(),
                    soldier.getWidth(), this);
                g.setColor(Color.WHITE);
                g.drawOval(soldier.getStartOfCircle().getX(), soldier.getStartOfCircle().getY(),
                        soldier.getRangeShoot(), soldier.getRangeShoot());
            }
        }
    }

    public void AddNewToDrawtEntities(ArrayList<EntityMoving> listEntities) {
        listEntitiesMoving = new ArrayList<>();
        for (EntityMoving entity : listEntities) {
            
            entity.setActualStart();
            
            listEntitiesMoving.add(entity);                        
        }

    }
    
    
    
    public void resetEntities(){
        listEntitiesMoving = new ArrayList<>();
        listCoins = new ArrayList<>();
        listSoldiers = new ArrayList<>();
    }

    private void drawCoins(Graphics g) {
        for (EntityStatic actual : listCoins) {
            if (actual.isIsAlive()) {
                    //drawLife((Graphics2D)g, actual);	
                    g.drawImage(actual.getImageEntity(), (int)actual.getActualPos().getX(),
                (int)actual.getActualPos().getY(), actual.getHeight(),
                actual.getWidth(), this);
            }                        
       }
    }

    public ArrayList<EntityMoving> getListEntitiesMoving() {
        return listEntitiesMoving;
    }

    public ArrayList<EntityStatic> getListCoins() {
        return listCoins;
    }
    
    public void addCoinToShow(EntityStatic enti){
        boolean addNewcoin = true;
//        for (EntityInfo listCoin : listCoins) {
//            if(enti.getActualPos().getX() == listCoin.getActualPos().getX()){
//                if(enti.getActualPos().getY() == listCoin.getActualPos().getY()){
//                    addNewcoin = false;
//                }
//            }
//        }
        listCoins.add(enti);
    }

    public void addArcher(GroupSoldier soldier) {      
        
        listSoldiers.add(soldier);
    }
            
}
