import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	// Constructor of the MainFrame
	public MainFrame() {
		try {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(1200, 700);
			this.setResizable(false);
			MainFrameInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// MainFrame initialization
	private void MainFrameInit() {
		// ToolBar
		toolBar toolbar = new toolBar("ToolBar", JToolBar.HORIZONTAL);

		// skyPanels
		skyPanel2 skypanel = new skyPanel2();
		
		// statPanels
		statPanel2 statpanel = new statPanel2();
		
		this.setLayout(new BorderLayout());
		this.add("North", toolbar);
		this.add("Center", skypanel);
		this.add("South", statpanel);
		
	}
}