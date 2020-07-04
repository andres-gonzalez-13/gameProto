/*
 * 
 */
package models;

import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Andreck san
 */
public class GroupSoldier extends EntityStatic{
    
    private int rangeShoot;
    private int damage;
    private double shotsPerSecond;
    private boolean shooting;
    private Timer timer;

    public GroupSoldier(int rangeShoot, int damage,double shotsPerSecond,Image imageEntity, PointPosition actualPos, int health, int height, int width) {
        super(imageEntity, actualPos, health, height, width);
        this.rangeShoot = rangeShoot;
        this.damage = damage;
        this.shotsPerSecond = shotsPerSecond;
        isAlive = true;
        shooting = true;
        
        timer = new Timer((int) (1000/shotsPerSecond), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                shooting = true;
                timer.stop();
            }
        }){
            
        };
    } 
    
    
    
    public void reloading(){
        shooting = false;
        
        timer.start();
        
    }

    public boolean isShooting() {
        return shooting;
    }
    
    

    public int getDamage() {
        return damage;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public int getRangeShoot() {
        return rangeShoot;
    }

    
    
    
    
    public PointPosition getCenterGroup(){
        return new PointPosition( actualPos.x + (getWidth()/2), actualPos.y + (getHeight()/2));
    }
    
    public PointPosition getStartOfCircle(){
        return new PointPosition(getCenterGroup().x-rangeShoot/2, getCenterGroup().y-rangeShoot/2);
    }
    
    public Shape getShape(){
        
        Ellipse2D elip = new Ellipse2D() {
            @Override
            public double getX() {
                return getStartOfCircle().x;
            }

            @Override
            public double getY() {
                return getStartOfCircle().y;
            }

            @Override
            public double getWidth() {
                return rangeShoot;
            }

            @Override
            public double getHeight() {
                return rangeShoot;
            }

            @Override
            public boolean isEmpty() {
                return true;
            }

            @Override
            public void setFrame(double x, double y, double w, double h) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Rectangle2D getBounds2D() {
                return getBounds();
            }
        };
                
        return elip;
    }
    
}
