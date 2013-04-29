import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Title: cell.java Description: cell class is used to control the button's
 * attributes.
 * 
 * @author Weicheng Zhu
 * @data 2013. 4. 27. 오전 11:43:59
 * @version 0.001
 */

public class cell extends JButton {
	public int id; // plane id, available values: 0, 1, 2, 3
	public int x, y; // cell axes
	public Color bgColor;
	public boolean isClicked;
	Font buttonFont = new Font("Serif", Font.PLAIN, 20);

	public cell(int x, int y) {
		this.id = 0;
		this.x = x;
		this.y = y;
		this.bgColor = pallet.skyBlue;
		this.isClicked = false;
		this.setBackground(this.bgColor);
		this.setForeground(Color.black);
		this.setFont(buttonFont);
		// this.setForeground(Color.blue);
	}

	// cell initialization
	public void init() {
		this.id = 0;
		this.bgColor = pallet.skyBlue;
		this.isClicked = false;
		this.setBackground(this.bgColor);
		this.setForeground(Color.white);
	}

	public boolean isHead() {
		if (id == 11 || id == 22 || id == 33)
			return true;
		else
			return false;
	}

	public boolean isNull() {
		if (id == 0)
			return true;
		else
			return false;
	}

	public boolean isBody() {
		if(id == 1 || id == 2 || id ==3)
			return true;
		else
		return false;
	}
}