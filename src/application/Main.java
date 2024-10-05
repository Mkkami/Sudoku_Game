package application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.Window;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new Window();
            frame.setVisible(true);
        });
    }
}
