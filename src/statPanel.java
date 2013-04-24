import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Title: statPanel.java Description: statPanel is at the foot of the frame used
 * to display users' state and statistics.
 * 
 * @author Weicheng Zhu
 * @data 2013. 4. 22. PM 9:48:11
 * @version 0.001
 */
class statPanel extends JPanel {
	int headShotNum = 0;
	int bodyShotNum = 0;
	JLabel headShotLbl = new JLabel("Bodyshot: " + bodyShotNum);
	JLabel bodyShotLbl = new JLabel("Headshot: " + headShotNum);
	
	public statPanel(JLabel whoseLbl) {		
		this.setLayout(new GridLayout(1, 3));
		this.add(whoseLbl);
		this.add(headShotLbl);
		this.add(bodyShotLbl);
	}
	
	void update(){
		headShotLbl.setText("Bodyshot: " + headShotNum);
		bodyShotLbl.setText("Bodyshot: " + bodyShotNum);
	}
}

class statPanel2 extends JPanel {
	public statPanel2() {
		JLabel myLbl = new JLabel("My plane");
		JLabel yourLbl = new JLabel("Your plane");
		statPanel myStatPanel = new statPanel(myLbl);
		statPanel yourStatPanel = new statPanel(yourLbl);
		this.setLayout(new GridLayout(1, 2));
		this.add(myStatPanel);
		this.add(yourStatPanel);
	}
}