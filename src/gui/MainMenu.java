package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel{
	private JButton start;
	private JTextField numberArea;
	private JCheckBox mistakesBox;
	

	
	public MainMenu(Window window) {
		start = new JButton("Start");
		numberArea = new JTextField();
		mistakesBox = new JCheckBox("Show mistakes");

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.switchToBoard();	
			}
		});
		
		
		
		add(start);
		add(numberArea);
		add(mistakesBox);
	}
	
}
