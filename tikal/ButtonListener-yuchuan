package tikal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ButtonListener implements ActionListener{
	
	private int num;
	private ArrayList<ArrayList<JPanel>> tile;

	public ButtonListener(int n, ArrayList<ArrayList<JPanel>> jpTile){
		
		num = n;
		tile = jpTile;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		int row = num / 6;
		int col = num % 6;
		tile.get(row).get(col).setVisible(true);
	}
	
	
}
