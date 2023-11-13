package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewFrame extends JFrame {

	public ViewFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Boulder Dash");
		setResizable(false);
		ViewPanel viewPanel = new ViewPanel();
		add(viewPanel);
		pack();
		viewPanel.startGameThread();
		setLocationRelativeTo(null);
	}
	public void showWindow(){
		setVisible(true);
	}


}
