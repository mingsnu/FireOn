import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Title: toolBar.java
 * Description: tooBar class is used to customize the Tool Bar.
 * @author Weicheng Zhu
 * @version 2013. 4. 27. 오전 11:38:59
 */

public class toolBar extends JToolBar {
	// ToolBar buttons declaration
	static JButton userBtn = new JButton(new ImageIcon("./img/user.png"));
	static JButton newBtn = new JButton(new ImageIcon("./img/new.png"));
	static JButton saveBtn = new JButton(new ImageIcon("./img/save.png"));
	static JButton readyBtn = new JButton("Ready"); 

	static JToggleButton upPlaneBtn = new JToggleButton(new ImageIcon(
			"./img/upPlane.png"));
	static JToggleButton rightPlaneBtn = new JToggleButton(new ImageIcon(
			"./img/rightPlane.png"));
	static JToggleButton downPlaneBtn = new JToggleButton(new ImageIcon(
			"./img/downPlane.png"));
	static JToggleButton leftPlaneBtn = new JToggleButton(new ImageIcon(
			"./img/leftPlane.png"));
	static ButtonGroup planeGroup = new ButtonGroup();
	
	loginDlg logindlg;
	
	static MainFrame mf;
	
	public toolBar(String string, int horizontal, MainFrame mf) {
		this.mf = mf;
		// Button styles
		userBtn.setBorderPainted(false);
		newBtn.setBorderPainted(false);
		saveBtn.setBorderPainted(false);
		upPlaneBtn.setBorderPainted(false);
		rightPlaneBtn.setBorderPainted(false);
		downPlaneBtn.setBorderPainted(false);
		leftPlaneBtn.setBorderPainted(false);

		// Dialog window for userBtn
		logindlg = new loginDlg(this.mf);
		logindlg.pack();
		
		// Button action listener
		userBtn.addActionListener(userBtnActionListener);
		newBtn.addActionListener(newBtnActionListener);
		saveBtn.addActionListener(saveBtnActionListener);
		readyBtn.addActionListener(new readyBtnActionListener(this.mf));

		// Add buttons to group
		planeGroup.add(upPlaneBtn);
		planeGroup.add(rightPlaneBtn);
		planeGroup.add(downPlaneBtn);
		planeGroup.add(leftPlaneBtn);

		// Add buttons
		this.add(userBtn);
		this.add(newBtn);
		this.add(saveBtn);
		this.add(upPlaneBtn);
		this.add(rightPlaneBtn);
		this.add(downPlaneBtn);
		this.add(leftPlaneBtn);
		this.add(readyBtn);
	}

	// Define userBtnActionListener
	ActionListener userBtnActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractBtn = (AbstractButton) e.getSource();
			logindlg.setVisible(true);
			System.out.println("User account button is pressed");
		}
	};
	
	//Define newBtnActionListener
	ActionListener newBtnActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractBtn = (AbstractButton) e.getSource();
			System.out.println("New button is pressed");
		}
	};
	
	//Define saveBtnActionListener
	ActionListener saveBtnActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractBtn = (AbstractButton) e.getSource();
			System.out.println("Save button is pressed");
		}
	};
}


class readyBtnActionListener implements ActionListener {
	private MainFrame mf;
	
	readyBtnActionListener(MainFrame mf){
		this.mf = mf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mf.skypanel.yourPanel.gameStarted = true;
		mf.skypanel.myPanel.locked();
		mf.startFire();
	}
}