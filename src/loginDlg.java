import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

//import javax.swing.JPasswordField;

/**
 * Title: loginDlg.java
 * Description: Login dialog
 * @author Weicheng Zhu
 * @version 2013. 4. 27. 오전 11:40:49
 */
public class loginDlg extends JDialog {

	// private JPasswordField passTxt;
	private JLabel idLbl;
	private JLabel ipLbl;
	private JLabel portLbl;
	private JTextField idTxt;
	private JTextField ipTxt;
	private JTextField portTxt;
	private JButton okBtn;
	private JButton cancelBtn;
	private JRadioButton robotBtn;
	private JRadioButton serverBtn;
	private JRadioButton clientBtn;
	private ButtonGroup optionGroup;
	private boolean succeeded;
	private GridBagLayout gBag = new GridBagLayout();
	
	final String robotCmd = "robot";
	final String serverCmd = "server";
	final String clientCmd = "client";

	loginDlg(MainFrame mf) {
		super(mf, "Login", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		// Layout
		Border padding = BorderFactory.createEmptyBorder(20, 20, 5, 20);
		panel1.setBorder(padding);

		panel1.setLayout(gBag);
		GridBagConstraints gbConstraint = new GridBagConstraints();
		gbConstraint.fill = GridBagConstraints.HORIZONTAL;

		idLbl = new JLabel("ID ");
		ipLbl = new JLabel("IP ");
		portLbl = new JLabel("Port ");
		idTxt = new JTextField(10);
		ipTxt = new JTextField(10);		
		portTxt = new JTextField(4);		
		robotBtn = new JRadioButton("Play with Robot");
		serverBtn = new JRadioButton("Build a server");
		clientBtn = new JRadioButton("Connect to a server");
		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		
		// add buttons to optionGroup
		optionGroup = new ButtonGroup();
		optionGroup.add(robotBtn);
		optionGroup.add(serverBtn);
		optionGroup.add(clientBtn);
		clientBtn.setSelected(true);
		
		// set button command		
		robotBtn.setActionCommand(robotCmd);
		serverBtn.setActionCommand(serverCmd);
		clientBtn.setActionCommand(clientCmd);
		
		// buttons action
		robotBtn.addActionListener(robotActionListener);
		serverBtn.addActionListener(serverActionListener);
		clientBtn.addActionListener(clientActionListener);
		okBtn.addActionListener(okActionListener);
		cancelBtn.addActionListener(cancelActionListener);



		gbConstraint.gridx = 0;
		gbConstraint.gridy = 0;
		gbConstraint.gridwidth = 1;
		panel1.add(idLbl, gbConstraint);

		gbConstraint.gridx = 1;
		gbConstraint.gridy = 0;
		gbConstraint.gridwidth = 2;
		panel1.add(idTxt, gbConstraint);

		gbConstraint.gridx = 0;
		gbConstraint.gridy = 1;
		gbConstraint.gridwidth = 3;
		panel1.add(robotBtn, gbConstraint);

		gbConstraint.gridx = 0;
		gbConstraint.gridy = 2;
		gbConstraint.gridwidth = 3;
		panel1.add(serverBtn, gbConstraint);

		gbConstraint.gridx = 0;
		gbConstraint.gridy = 3;
		gbConstraint.gridwidth = 3;
		panel1.add(clientBtn, gbConstraint);

		gbConstraint.gridx = 0;
		gbConstraint.gridy = 4;
		gbConstraint.gridwidth = 1;
		panel1.add(ipLbl, gbConstraint);

		gbConstraint.gridx = 1;
		gbConstraint.gridy = 4;
		gbConstraint.gridwidth = 2;
		panel1.add(ipTxt, gbConstraint);

		gbConstraint.gridx = 0;
		gbConstraint.gridy = 5;
		gbConstraint.gridwidth = 1;
		panel1.add(portLbl, gbConstraint);

		gbConstraint.gridx = 1;
		gbConstraint.gridy = 5;
		gbConstraint.gridwidth = 1;
		panel1.add(portTxt, gbConstraint);

		// Panel two
		panel2.add(okBtn);
		panel2.add(cancelBtn);



		// setContentPane(contentPanel);
		JPanel contentPanel = (JPanel) getContentPane();
		contentPanel.add(panel1, BorderLayout.CENTER);
		contentPanel.add(panel2, BorderLayout.PAGE_END);
		// this.add(contentPanel);
		pack();
		setResizable(false);
	}
	
	// ActionListeners should be defined outside of the constructor function
	ActionListener robotActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ipTxt.setEditable(false);
			portTxt.setEditable(false);
		}
	};

	ActionListener serverActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ipTxt.setEditable(false);
			portTxt.setEditable(false);
		}
	};

	ActionListener clientActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ipTxt.setEditable(true);
			portTxt.setEditable(true);			
		}
	};

	ActionListener okActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = optionGroup.getSelection().getActionCommand();
			
			//robot is selected
			if(command == robotCmd) {
				System.out.println("Play with Robot...");
				// server is selected
			}else if(command == serverCmd) {
				System.out.println("Building server....");
				// client is selected
			}else {
				System.out.println("Connecting to the server...");
			}
			setVisible(false);
		}
	};

	ActionListener cancelActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
	};

}