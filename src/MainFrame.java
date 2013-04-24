import javax.swing.*;
import java.awt.*;

/**
 * Title: MainFrame.java
 * Description: MainFrame class
 * @author Weicheng Zhu
 * @data 2013. 4. 22. PM 9:44:46
 * @version 0.001
 */
public class MainFrame extends JFrame {

	// ToolBar
	toolBar toolbar = new toolBar("ToolBar", JToolBar.HORIZONTAL, this);

	// skyPanels
	skyPanel2 skypanel = new skyPanel2();
	
	// statPanels
	statPanel2 statpanel = new statPanel2();
	
	// Constructor of the MainFrame
	public MainFrame() {
		try {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(1200, 700);
			this.setResizable(false);
			
			this.setLayout(new BorderLayout());
			this.add("North", toolbar);
			this.add("Center", skypanel);
			this.add("South", statpanel);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void startFire() {
		
		System.out.println("Game Started!");
	}
}
