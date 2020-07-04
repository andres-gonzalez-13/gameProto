/*
 * 
 */
package models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author Andreck san
 */
public class EntityMoving extends DimensionsEntity{    

    private Image imageEntity;
    private ArrayList<PointPosition>listroute;
    private PointPosition actualPos;
    private PointPosition nextPosition;
    private int SpeedPixels;
    private boolean inTheMap;
    private boolean isAlive;
    private int health;

    public EntityMoving(int height, int width, Image imageEntity, int SpeedPixels) {
        super(height, width);
        this.imageEntity = imageEntity;
        this.SpeedPixels = SpeedPixels;
        health = 1;
        isAlive = true;
        inTheMap = true;
        listroute = new ArrayList<>();        
    }
    
    public void setActualStart(){
        actualPos = listroute.get(0);
        nextPosition = listroute.get(1);
        
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void doDamageHealth(int damage) {
        health -= damage;
        if(health <= 0){
            isAlive = false;
        }
    }    
    
    public void setRoute(ArrayList<PointPosition>listRoute){
        listroute = listRoute;
        actualPos = listroute.get(0);
        nextPosition = listroute.get(1);
    }
    
    public void setAlive(boolean live){
        isAlive = live;
    }

    public boolean isIsAlive() {
        return isAlive;
    }        

    public Image getImageEntity() {
        return imageEntity;
    }

    public int getSpeedPixels() {
        return SpeedPixels;
    }

    public ArrayList<PointPosition> getListroute() {
        return listroute;
    }    
    
    public PointPosition getlastPoint(){
        return listroute.get(listroute.size() -1);
    }
    
    public void moveStep(){
        if(inTheMap){                  
            if(actualPos.x == nextPosition.x && actualPos.y == nextPosition.y){
                nextPosition = getNextPointToMove();
                moveStep();
            }else{
                checkCloseX();
                checkCloseY();
            }                
        }
    }
    
    public void checkCloseX(){
        if(actualPos.x >= nextPosition.x){
            if(!closerTen(actualPos.x , nextPosition.x)){
                actualPos.x = actualPos.x-SpeedPixels;
            }else{
                actualPos.x = nextPosition.x;
            }
        }else{
            if(!closerTen(nextPosition.x, actualPos.x)){
                actualPos.x = actualPos.x+SpeedPixels;
            }else{
                actualPos.x = nextPosition.x;
            }
        }
    }
    
    public void checkCloseY(){
        if(actualPos.y >= nextPosition.y){
            if(!closerTen(actualPos.y , nextPosition.y)){
                actualPos.y = actualPos.y-SpeedPixels;
            }else{
                actualPos.y = nextPosition.y;
            }
        }else{
            if(!closerTen(nextPosition.y, actualPos.y)){
                actualPos.y = actualPos.y+SpeedPixels;
            }else{
                actualPos.y = nextPosition.y;
            }
        }
    }
    
    public boolean closerTen(int x1, int x2){
        return (x1-x2)< SpeedPixels;        
    }
    
    public boolean ckeckClicked(int xclic, int yclicc){
        boolean clicked = false;
        if(xclic >= actualPos.x && xclic <= (actualPos.x+getWidth())){
            if(yclicc >= actualPos.y && yclicc <= (actualPos.y+getHeight())){
                clicked = true;
            }
        }
        return clicked;
    }
    

    public PointPosition getNextPointToMove(){
        boolean seeking = false;
        PointPosition nextpos = nextPosition;
        for (PointPosition point : listroute) {            
            if(seeking){
                nextpos = point;
                seeking = false;                
            }
            if(point.x == actualPos.x && point.y == actualPos.y){
                seeking = true;
            }
        }      
        if(checkSamePoint(actualPos, getlastPoint())){
            //nextpos = listroute.get(listroute.size()-1);
            inTheMap = false;
            //setActualStart();
        }
        return nextpos;
    }
    
    public boolean checkSamePoint(PointPosition p1, PointPosition p2){
        return p1.x == p2.x && p1.y == p2.y;
    }

    public PointPosition getActualPos() {
        return actualPos;
    }

    public void setActualPos(PointPosition actualPos) {
        this.actualPos = actualPos;
    }

    public boolean isInTheMap() {
        return inTheMap;
    }
    
    public Shape getShape(){
        Rectangle2D rec = new Rectangle();
        rec.setFrame(actualPos.x, actualPos.y, getWidth(), getHeight());
        
        return rec;
    }
        
    
    
}
