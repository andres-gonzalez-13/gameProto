
package views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Constants;

public class BtnStandar extends JButton {

	private String word;
	private String linkIcon;
	private ImageIcon imageFace;
	private int width, heigth, size;
        
        /**
         * 
         * @param word palabra a colocar en el boton
         * @param linkIcon link de imagen a colocar el el boton
         */

	public BtnStandar(String word, String linkIcon) {
		this.word = word;
		this.linkIcon = linkIcon;
                size = 60;
		setForeground(Color.GRAY);
                setFont(Constants.titleMiddle);
                setName(word);
		setFocusable(false);
		setText("" + word);
		setOpaque(true);
		loadImage(linkIcon);
                setBorder(Constants.bordetiny);
		setIcon(imageFace);
	}
        
        /**
         * 
         * @param linkImage link de imagen a colocar
         */

	public void loadImage(String linkImage) {
		if (linkImage == null) {
			imageFace = null;
		} else {

			ImageIcon tmpIcon = new ImageIcon(getClass().getResource(linkImage));
			if (tmpIcon.getIconWidth() > size) {

				imageFace = new ImageIcon(tmpIcon.getImage().getScaledInstance(60, -1, Image.SCALE_DEFAULT));
			} else {
				imageFace = tmpIcon;
			}
		}
	}
        
        /**
         * 
         * @param size ancho de imagen
         */
        
        public void setSize(int size){
            this.size = size;
            loadImage(linkIcon);
            repaint();
        }
        
        public String getWord(){
            return word;
        }

}
