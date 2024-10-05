package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
	
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	
	private MainMenu menu;
	private GameOver finishScreen;
	private Board board;
	
	public Window() {
		setTitle("Sudoku");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		setVisible(true);
		
		menu = new MainMenu(this);
		
		board = new Board();
		
		finishScreen = new GameOver();
		
		add(menu);
	}
	
	public void switchToBoard() {
		remove(menu);
		add(board);
	}
	
	public void switchToFinish() {
		remove(board);
		//add(finishScreen);
	}
}
