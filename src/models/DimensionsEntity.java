/*
 * 
 */
package models;

/**
 *
 * @author Andreck san
 */
public class DimensionsEntity {

    private int height;
    private int width;

    public DimensionsEntity(int height, int width) {
        this.height = height;
        this.width = width;
    }    

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }        
    
}
