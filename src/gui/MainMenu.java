package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MainMenu extends JPanel{
	private JButton start;
	private JLabel infoLabel;
	private JTextField numberArea;
	private JCheckBox mistakesBox;
	
	
	public MainMenu(Window window) {
		start = new JButton("Start");
		infoLabel = new JLabel("Enter number of filled squares (17-80)");
		numberArea = new JTextField();
		mistakesBox = new JCheckBox("Show mistakes");
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int number = getNumber();
				if (number > 0) {
					window.switchToBoard(number, mistakesBox.isSelected());
				}
			}
		});
		
		numberArea.setPreferredSize(new Dimension(100, 20));
		
		
		placeElements();
		
		
	}
	
	private void placeElements() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(infoLabel, gbc);
		gbc.gridy = 1;
		this.add(numberArea, gbc);
		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.gridy = 4;
		this.add(mistakesBox, gbc);
		gbc.gridy = 5;
		this.add(start, gbc);
		
	}
	
	private int getNumber() {
		String text = numberArea.getText();
		if (! text.isEmpty()) {
			try {
				int number = Integer.parseInt(text);
				if (number >= 17 && number <= 80) {
					return number;
				}
			} catch (Exception ex) {
				return 0;
			}
		}
		return 0;
	}
	
}
