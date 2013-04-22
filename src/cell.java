import java.awt.Color;
import javax.swing.JButton;

/**
 * Title: cell.java
 * Description: cell class is used to control the button's attributes.
 * @author Weicheng Zhu
 * @data 2013. 4. 22. PM 9:36:56
 * @version 0.001
 */
public class cell extends JButton{
	public int id; //plane id, available values: 0, 1, 2, 3
	public int x, y; // cell axes
	public Color bgColor;
	public boolean isNull;
	public boolean isHead;
	public boolean isBody;
	public boolean isClicked;	
	
	public cell(int x, int y){
		this.id=0;
		this.x = x;
		this.y = y;
		this.bgColor = pallet.skyBlue;
		this.isNull = true;
		this.isHead = false;
		this.isBody = false;
		this.isClicked = false;
		this.setBackground(this.bgColor);
		this.setForeground(Color.white);
		//this.setForeground(Color.blue);
	}

	// cell initialization
	public void init() {
		this.id=0;
		this.bgColor = pallet.skyBlue;
		this.isNull = true;
		this.isHead = false;
		this.isBody = false;
		this.isClicked = false;
		this.setBackground(this.bgColor);
		this.setForeground(Color.white);
	}
}