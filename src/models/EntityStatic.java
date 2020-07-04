/*
 * 
 */
package models;

import java.awt.Image;

/**
 *
 * @author Andreck san
 */
public class EntityStatic extends DimensionsEntity{
    
    private Image imageEntity;
    protected PointPosition actualPos;
    boolean isAlive;
    private int health;

    public EntityStatic(Image imageEntity, PointPosition actualPos, int health, int height, int width) {
        super(height, width);
        this.imageEntity = imageEntity;
        this.actualPos = actualPos;
        this.health = health;
        isAlive = true;
    }

    public Image getImageEntity() {
        return imageEntity;
    }

    public PointPosition getActualPos() {
        return actualPos;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public int getHealth() {
        return health;
    }

    public void doDamageHealth(int damage) {
        health -= damage;
        if(health <= 0){
            isAlive = false;
        }
    }
    
    public void setAlive(boolean live){
        isAlive = live;
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
    
    
}
