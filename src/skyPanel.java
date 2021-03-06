import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

import javax.swing.*;

/**
 * Title: skyPanel.java 
 * Description: skyPanel is used to build single panel.
 * 
 * @author Weicheng Zhu
 * @version 2013. 4. 27. 오전 11:42:07
 */
class skyPanel extends JPanel {
	public static final int NROW = 10;
	public static final int NCOL = 10;
	public int planeNum = 0;
	boolean locked = false;
	boolean gameStarted = false;
	public Stack<Integer> idStack = new Stack<Integer>();
	Color[] planeColor = { pallet.papayaWhip, pallet.grassGreen,
			pallet.lightPurple };
	cell[][] cellBtn = new cell[10][10];

	public skyPanel(Color bgcolor) {
		idStack.push(3);
		idStack.push(2);
		idStack.push(1);
		this.setBackground(bgcolor);
		this.setLayout(new GridLayout(10, 10));
		for (int j = NCOL - 1; j >= 0; j--) {
			for (int i = 0; i < NROW; i++) {
				cellBtn[i][j] = new cell(i, j);
				cellBtn[i][j].addMouseListener(

				new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						locatePlaneIn(e);
					}

					public void mouseExited(MouseEvent e) {
						locatePlaneOut(e);
					}

					public void mouseClicked(MouseEvent e) {
						rightClick(e);
					}
				}

				);
				cellBtn[i][j].addActionListener(actionlistener);
				this.add(cellBtn[i][j]);
			}
		}
	}

	protected void rightClick(MouseEvent e) {
		// Right click to cancel the current deploy of the plane
		toolBar.planeGroup.clearSelection();
		for (int j = NCOL - 1; j >= 0; j--) {
			for (int i = 0; i < NROW; i++) {
				cellBtn[i][j].setBackground(cellBtn[i][j].bgColor);
			}
		}
	}

	// Define ActionListener
	ActionListener actionlistener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int x, y;
			cell cellbtn = (cell) e.getSource();
			x = cellbtn.x;
			y = cellbtn.y;
			ButtonModel b = toolBar.planeGroup.getSelection();
			if (b != null) {
				if (toolBar.upPlaneBtn.isSelected()) {
					if (x > 1 && x < 8 && y > 1 && y < 9) {
						// Button array for the 'head up' plane
						cell[] cellbtnArray = { cellBtn[x][y + 1],
								cellBtn[x - 2][y], cellBtn[x - 1][y],
								cellBtn[x][y], cellBtn[x + 1][y],
								cellBtn[x + 2][y], cellBtn[x][y - 1],
								cellBtn[x - 1][y - 2], cellBtn[x][y - 2],
								cellBtn[x + 1][y - 2] };
						int id = idStack.pop();
						for (int i = 0; i < cellbtnArray.length; i++) {
							// Set each button's attributes
							cellbtnArray[i].id = id;
							cellbtnArray[i].bgColor = planeColor[id - 1];
							cellbtnArray[i]
									.setBackground(cellbtnArray[i].bgColor);
						}
						cellbtnArray[0].id = id*11;
						planeNum++;
					}
				}

				if (toolBar.rightPlaneBtn.isSelected()) {
					if (x > 1 && x < 9 && y > 1 && y < 8) {
						cell[] cellbtnArray = { cellBtn[x + 1][y],
								cellBtn[x][y + 2], cellBtn[x][y + 1],
								cellBtn[x][y], cellBtn[x][y - 1],
								cellBtn[x][y - 2], cellBtn[x - 1][y],
								cellBtn[x - 2][y + 1], cellBtn[x - 2][y],
								cellBtn[x - 2][y - 1] };
						int id = idStack.pop();
						for (int i = 0; i < cellbtnArray.length; i++) {
							cellbtnArray[i].id = id;
							cellbtnArray[i].bgColor = planeColor[id - 1];
							cellbtnArray[i]
									.setBackground(cellbtnArray[i].bgColor);
						}
						cellbtnArray[0].id = id*11;
						planeNum++;
					}
				}

				if (toolBar.downPlaneBtn.isSelected()) {
					if (x > 1 && x < 8 && y > 0 && y < 8) {
						cell[] cellbtnArray = { cellBtn[x][y - 1],
								cellBtn[x - 2][y], cellBtn[x - 1][y],
								cellBtn[x][y], cellBtn[x + 1][y],
								cellBtn[x + 2][y], cellBtn[x][y + 1],
								cellBtn[x - 1][y + 2], cellBtn[x][y + 2],
								cellBtn[x + 1][y + 2] };
						int id = idStack.pop();
						for (int i = 0; i < cellbtnArray.length; i++) {
							cellbtnArray[i].id = id;
							cellbtnArray[i].bgColor = planeColor[id - 1];
							cellbtnArray[i]
									.setBackground(cellbtnArray[i].bgColor);
						}
						cellbtnArray[0].id = id*11;
						planeNum++;
					}
				}

				if (toolBar.leftPlaneBtn.isSelected()) {
					if (x > 0 && x < 8 && y > 1 && y < 8) {
						cell[] cellbtnArray = { cellBtn[x - 1][y],
								cellBtn[x][y + 2], cellBtn[x][y + 1],
								cellBtn[x][y], cellBtn[x][y - 1],
								cellBtn[x][y - 2], cellBtn[x + 1][y],
								cellBtn[x + 2][y + 1], cellBtn[x + 2][y],
								cellBtn[x + 2][y - 1] };
						int id = idStack.pop();
						for (int i = 0; i < cellbtnArray.length; i++) {
							cellbtnArray[i].id = id;
							cellbtnArray[i].bgColor = planeColor[id - 1];
							cellbtnArray[i]
									.setBackground(cellbtnArray[i].bgColor);
						}
						cellbtnArray[0].id = id*11;
						planeNum++;
					}
				}

				toolBar.planeGroup.clearSelection();
				if(planeNum == 3) {
					toolBar.readyBtn.setEnabled(true);
				}
			} else {
				if (gameStarted) {
					if (cellbtn.isNull())
						cellbtn.setText("X");
					if (cellbtn.isHead())
						cellbtn.setText("H");
					if (cellbtn.isBody())
						cellbtn.setText("B");
				}
			}
		}
	};

	// When the mouse hover the button, display the current plane location
	// according to the direction of the plane
	public void locatePlaneIn(MouseEvent e) {
		int x, y;
		cell cellbtn = (cell) e.getSource();
		x = cellbtn.x;
		y = cellbtn.y;

		if (toolBar.upPlaneBtn.isSelected()) {
			if (x > 1 && x < 8 && y > 1 && y < 9) {
				cell[] cellbtnArray = { cellBtn[x][y + 1], cellBtn[x - 2][y],
						cellBtn[x - 1][y], cellBtn[x][y], cellBtn[x + 1][y],
						cellBtn[x + 2][y], cellBtn[x][y - 1],
						cellBtn[x - 1][y - 2], cellBtn[x][y - 2],
						cellBtn[x + 1][y - 2] };
				for (int i = 0; i < cellbtnArray.length; i++) {
					if (cellbtnArray[i].id == 0) {
						cellbtnArray[i].setBackground(Color.green);
					} else {
						cellbtnArray[i].setBackground(Color.red);
						// If there is an overlap between planes, set the button
						// can't be pressed
						if (cellbtn.isEnabled())
							cellbtn.setEnabled(false);
					}
				}
			}
		}

		if (toolBar.rightPlaneBtn.isSelected()) {
			if (x > 1 && x < 9 && y > 1 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x + 1][y], cellBtn[x][y + 2],
						cellBtn[x][y + 1], cellBtn[x][y], cellBtn[x][y - 1],
						cellBtn[x][y - 2], cellBtn[x - 1][y],
						cellBtn[x - 2][y + 1], cellBtn[x - 2][y],
						cellBtn[x - 2][y - 1] };

				for (int i = 0; i < cellbtnArray.length; i++) {
					if (cellbtnArray[i].id == 0) {
						cellbtnArray[i].setBackground(Color.green);
					} else {
						cellbtnArray[i].setBackground(Color.red);
						if (cellbtn.isEnabled())
							cellbtn.setEnabled(false);
					}
				}
			}
		}

		if (toolBar.downPlaneBtn.isSelected()) {
			if (x > 1 && x < 8 && y > 0 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x][y - 1], cellBtn[x - 2][y],
						cellBtn[x - 1][y], cellBtn[x][y], cellBtn[x + 1][y],
						cellBtn[x + 2][y], cellBtn[x][y + 1],
						cellBtn[x - 1][y + 2], cellBtn[x][y + 2],
						cellBtn[x + 1][y + 2] };
				for (int i = 0; i < cellbtnArray.length; i++) {
					if (cellbtnArray[i].id == 0) {
						cellbtnArray[i].setBackground(Color.green);
					} else {
						cellbtnArray[i].setBackground(Color.red);
						if (cellbtn.isEnabled())
							cellbtn.setEnabled(false);
					}
				}
			}
		}

		if (toolBar.leftPlaneBtn.isSelected()) {
			if (x > 0 && x < 8 && y > 1 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x - 1][y], cellBtn[x][y + 2],
						cellBtn[x][y + 1], cellBtn[x][y], cellBtn[x][y - 1],
						cellBtn[x][y - 2], cellBtn[x + 1][y],
						cellBtn[x + 2][y + 1], cellBtn[x + 2][y],
						cellBtn[x + 2][y - 1] };

				for (int i = 0; i < cellbtnArray.length; i++) {
					if (cellbtnArray[i].id == 0) {
						cellbtnArray[i].setBackground(Color.green);
					} else {
						cellbtnArray[i].setBackground(Color.red);
						if (cellbtn.isEnabled())
							cellbtn.setEnabled(false);
					}
				}
			}
		}

		// cellbtn.setBackground(Color.green);
		// cellbtn.setText(x + ", " + y);
		// cellbtn.setText(cellbtn.id + "");

	}

	public void locatePlaneOut(MouseEvent e) {
		int x, y;
		cell cellbtn = (cell) e.getSource();
		x = cellbtn.x;
		y = cellbtn.y;

		if (toolBar.upPlaneBtn.isSelected()) {
			if (x > 1 && x < 8 && y > 1 && y < 9) {

				cell[] cellbtnArray = { cellBtn[x][y + 1], cellBtn[x - 2][y],
						cellBtn[x - 1][y], cellBtn[x][y], cellBtn[x + 1][y],
						cellBtn[x + 2][y], cellBtn[x][y - 1],
						cellBtn[x - 1][y - 2], cellBtn[x][y - 2],
						cellBtn[x + 1][y - 2] };

				for (int i = 0; i < cellbtnArray.length; i++) {
					// When the mouse exits the button, set back to the original
					// background color
					cellbtnArray[i].setBackground(cellbtnArray[i].bgColor);
				}
				// If this skyPanel is not locked (readyBtn is not clicked yet),
				// enable click action
				if (!locked)
					cellbtn.setEnabled(true);
			}
		}

		if (toolBar.rightPlaneBtn.isSelected()) {
			if (x > 1 && x < 9 && y > 1 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x + 1][y], cellBtn[x][y + 2],
						cellBtn[x][y + 1], cellBtn[x][y], cellBtn[x][y - 1],
						cellBtn[x][y - 2], cellBtn[x - 1][y],
						cellBtn[x - 2][y + 1], cellBtn[x - 2][y],
						cellBtn[x - 2][y - 1] };
				for (int i = 0; i < cellbtnArray.length; i++) {
					cellbtnArray[i].setBackground(cellbtnArray[i].bgColor);
				}
				if (!locked)
					cellbtn.setEnabled(true);
			}
		}

		if (toolBar.downPlaneBtn.isSelected()) {
			if (x > 1 && x < 8 && y > 0 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x][y - 1], cellBtn[x - 2][y],
						cellBtn[x - 1][y], cellBtn[x][y], cellBtn[x + 1][y],
						cellBtn[x + 2][y], cellBtn[x][y + 1],
						cellBtn[x - 1][y + 2], cellBtn[x][y + 2],
						cellBtn[x + 1][y + 2] };
				for (int i = 0; i < cellbtnArray.length; i++) {
					cellbtnArray[i].setBackground(cellbtnArray[i].bgColor);
				}
				if (!locked)
					cellbtn.setEnabled(true);
			}
		}

		if (toolBar.leftPlaneBtn.isSelected()) {
			if (x > 0 && x < 8 && y > 1 && y < 8) {
				cell[] cellbtnArray = { cellBtn[x - 1][y], cellBtn[x][y + 2],
						cellBtn[x][y + 1], cellBtn[x][y], cellBtn[x][y - 1],
						cellBtn[x][y - 2], cellBtn[x + 1][y],
						cellBtn[x + 2][y + 1], cellBtn[x + 2][y],
						cellBtn[x + 2][y - 1] };

				for (int i = 0; i < cellbtnArray.length; i++) {
					cellbtnArray[i].setBackground(cellbtnArray[i].bgColor);
				}
				if (!locked)
					cellbtn.setEnabled(true);
			}
		}
		// cellbtn.setBackground(Color.white);
		// cellbtn.setText("");
	}
	
	// Get the id matrix for this panel
	public int[][] getIdMatrix() {
		int[][] idMat = new int[10][10];
		for (int i = 0; i < NROW; i++) {
			for (int j = 0; j < NCOL; j++) {
				idMat[i][j] = cellBtn[i][j].id;
			}			
		}
		return idMat;
	}
	
	// Lock the panel, which makes all buttons not clickable
	public void locked() {
		this.locked = true;
		for (int j = NCOL - 1; j >= 0; j--) {
			for (int i = 0; i < NROW; i++) {
				cellBtn[i][j].setEnabled(false);
			}
		}
	}
	
	// Deploy from file
	public void deploy() {
		
	}
	
}

// Two user panel side by side
class skyPanel2 extends JPanel {
	skyPanel myPanel = new skyPanel(pallet.ivory);
	skyPanel yourPanel = new skyPanel(pallet.ivory);

	public skyPanel2() {
		this.setLayout(new GridLayout(1, 2));
		this.add(myPanel);
		this.add(yourPanel);
	}
}