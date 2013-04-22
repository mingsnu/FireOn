import java.awt.Color;
import javax.swing.JButton;

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
}