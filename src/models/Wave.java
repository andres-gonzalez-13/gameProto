package models;

import java.util.ArrayList;

/**
 *
 * @author Andreck san
 */
public class Wave {
    private ArrayList<EntityMoving>listEnemys;
    private int timeToApear;

    public Wave(ArrayList<EntityMoving> listEnemys, int timeToApear) {
        this.listEnemys = listEnemys;
        this.timeToApear = timeToApear;
    }

    public ArrayList<EntityMoving> getListEnemys() {
//        for (EntityMoving ing : listEnemys) {
//            
//            System.out.println("antes de dibujar " + ing.getActualPos().getX() + " - " + ing.getActualPos().getY());
//        }
        
        
        return listEnemys;
    }

    public int getTimeToApear() {
        return timeToApear;
    }        
        
}
