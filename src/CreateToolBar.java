import javax.swing.*;
import java.awt.*;

public class CreateToolBar{
  public static void main(String[] args) {
  JFrame frame = new JFrame("Create a toolbar Which have three buttons Such as: Cut, Copy, Paste");
  JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
  JButton cutbutton = new JButton(new ImageIcon("./img/document.png"));
  toolbar.add(cutbutton);
  JButton copybutton = new JButton(new ImageIcon("./img/user.png"));
  toolbar.add(copybutton);
  frame.getContentPane().add(toolbar,BorderLayout.NORTH);
  frame.setUndecorated(true);
  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(500,400);
  frame.setVisible(true);
  }
}