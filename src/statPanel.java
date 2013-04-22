import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

class statPanel extends JPanel {
	public statPanel(JLabel whoseLbl) {
		int headShotNum = 0;
		int bodyShotNum = 0;
		JLabel headShotLbl = new JLabel("Bodyshot: " + bodyShotNum);
		JLabel bodyShotLbl = new JLabel("Headshot: " + headShotNum);
		this.setLayout(new GridLayout(1, 3));
		this.add(whoseLbl);
		this.add(headShotLbl);
		this.add(bodyShotLbl);
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