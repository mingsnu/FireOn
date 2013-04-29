import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Title: toolBar.java Description: tooBar class is used to customize the Tool
 * Bar.
 * 
 * @author Weicheng Zhu
 * @version 2013. 4. 30. 오전 01:25:59
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

		readyBtn.setEnabled(false);

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

	// Define newBtnActionListener
	ActionListener newBtnActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractBtn = (AbstractButton) e.getSource();
			System.out.println("New button is pressed");
		}
	};

	// Define saveBtnActionListener
	ActionListener saveBtnActionListener = new ActionListener() {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// AbstractButton abstractBtn = (AbstractButton) e.getSource();
			System.out.println("Save button is pressed");

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");

			int userSelection = fileChooser.showSaveDialog(mf);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();

				try {
					FileOutputStream out = new FileOutputStream(fileToSave);
					ObjectOutputStream oout = new ObjectOutputStream(out);

					// write the idMat to the file
					oout.writeObject(mf.skypanel.myPanel.getIdMatrix());
					// close the stream
					oout.close();
					
/*					// Test the save object.
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToSave));
					// read and print the idMat
					int[][] x = (int[][]) ois.readObject();
					for (int j = 9; j >= 0; j--) {
						for (int i = 0; i < 10; i++) {
							System.out.print(x[i][j] + " ");
						}
						System.out.println();
					}*/
			         
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Save as file: "
						+ fileToSave.getAbsolutePath());
			}
		}
	};
}

class readyBtnActionListener implements ActionListener {
	private MainFrame mf;

	readyBtnActionListener(MainFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AbstractButton abstractBtn = (AbstractButton) e.getSource();
		mf.skypanel.yourPanel.gameStarted = true;
		mf.skypanel.myPanel.locked();
		mf.startFire();
		// readyBtn is disabled
		abstractBtn.setEnabled(false);
	}
}