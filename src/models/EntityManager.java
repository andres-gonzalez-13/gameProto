/*
 * 
 */
package models;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Andreck san
 */
public class EntityManager {
    
    private ArrayList<PointPosition>listroute1A;
    private ArrayList<PointPosition>listroute1B;
    
    private ArrayList<PointPosition>listroute2A;
    private ArrayList<PointPosition>listroute2B;
    
    private ArrayList<PointPosition>listroute3A;
    private ArrayList<PointPosition>listroute3B;
    
    
    private ArrayList<EntityMoving> listEntityLevel1;
    //private ArrayList<EntityStatic> list

    public EntityManager() {
        listEntityLevel1 = new ArrayList<>();
        createRoutesLevel_1();
        
        createLevel_1_Entities();
    }
    
    public void createRoutesLevel_1(){
        listroute1A = new ArrayList<>();        
        listroute1A.add(new PointPosition(570,607));
        listroute1A.add(new PointPosition(656,445));
        listroute1A.add(new PointPosition(761,348));
        listroute1A.add(new PointPosition(794,234));    
        listroute1A.add(new PointPosition(796,137));  
        
        listroute1B = new ArrayList<>();
        listroute1B.add(new PointPosition(587,2));
        listroute1B.add(new PointPosition(599,202));
        listroute1B.add(new PointPosition(441,290));
        listroute1B.add(new PointPosition(188,285));
        listroute1B.add(new PointPosition(132,501));  
        listroute1B.add(new PointPosition(266,738));  
    }
    
    public void createLevel_1_Entities(){
        Image image1 = new ImageIcon(getClass().getResource(Constants.PIG_UP_SPRITE)).getImage();
        Image image2 = new ImageIcon(getClass().getResource(Constants.PIG_DOWN_SPRITE)).getImage();
        
        EntityMoving enti1 = new EntityMoving(50, 75, image1, 2);
        enti1.setRoute(listroute1A);                
        EntityMoving enti2 = new EntityMoving(50, 75, image2, 2);        
        enti2.setRoute(listroute1B);        
        listEntityLevel1.add(enti1);
        listEntityLevel1.add(enti2);        
    }

    public ArrayList<PointPosition> getListroute1A() {
        return listroute1A;
    }

    public ArrayList<EntityMoving> getListEntityLevel1() {
        return listEntityLevel1;
    }                
        
}
