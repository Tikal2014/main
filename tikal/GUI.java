package tikal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
//***************************************************
// I use layeredPane to utilize the graph part of our project.
// For example, the background lies in the bottom layer, the 1st layer is the tiles, and the top layer is buytton.s
// Thus, we could press the buttons and see everything changing at lower layer.
// Also, we could add more layers if needed, there is a hundred level limit for layer numbers so no need to worry about the lack of layers.
//***************************************************







import tikal.ButtonListener;


public class GUI {			// I define everything here
	
	 tikal.Game _g;
     JFrame frame = new JFrame();
     JLayeredPane lpane = new JLayeredPane();
     JPanel backPanel=new JPanel();
     JPanel panel2=new JPanel();
     JPanel panel3=new JPanel();  // this JPanel will be the control pad place
     JButton _exButt = new JButton("ADD EXPLORER");
     JButton _endTurnButt = new JButton("END TURN");
     int _player=1; // set default turn is player #1

     ArrayList<ArrayList<JPanel>> jpButt=new ArrayList<ArrayList<JPanel>>();
     ArrayList<ArrayList<JPanel>> jpTile=new ArrayList<ArrayList<JPanel>>();
     
     
    public GUI() //this is the constructor
    		//I define GUI in a simplier way compare to our previous work, there is no run() and we can directly 
    		// create the oject(a window popup) by running GUI. (It works through last method you see in this file)
    {
    	for(int i=0;i<6;i++){
    		
    		jpButt.add(new ArrayList<JPanel>());
			jpTile.add(new ArrayList<JPanel>());
    		for(int j=0;j<6;j++){	
    			jpButt.get(i).add(new JPanel());
    			jpTile.get(i).add(new JPanel()); 	
    			jpButt.get(i).get(j).setLayout(new BorderLayout());
    		}

    	}
    	
    	JLabel aa = new JLabel();   
    	ImageIcon im = new ImageIcon("images/tikalmap1.jpg"); //background
		
        frame.setPreferredSize(new Dimension(1280, 768)); // create frame size
        frame.setLayout(new BorderLayout());   // using borderlayout, basically I just want to put everyhing in the middle
        frame.add(lpane, BorderLayout.CENTER);  // you can see I select the center
        lpane.setBounds(0, 0, 1024, 768); 	// this is different from frame size, and it is sort of setting 
        					// the container size inside the frame
        
        
        //***************iamgeIcons set Icon(image)
        aa.setIcon(im);

        //*************** add imageIcons to Jpanels
        backPanel.add(aa);
        //*************** Jpenels' settings
        backPanel.setBounds(0, 0, 1024, 768);
        backPanel.setOpaque(true);
        		
        //************** Contro pad Jpanel
        panel3.setBounds(1000, 300, 300, 300);
        panel3.setOpaque(true);
        _exButt.addActionListener(new ButtonListener(this,1,1,_g)); //maybe need a separate listener
        _endTurnButt.addActionListener(new ButtonListener(this,1,1,_g)); //maybe need a separate listener
        panel3.add(_exButt);
        panel3.add(_endTurnButt);
        //*************** add jpanels to the container
        tileRefresh();
        buttonRefresh();
        lpane.add(backPanel, new Integer(0), 0);    
        lpane.add(panel3, new Integer(5), 0); 
        frame.pack();
        frame.setVisible(true);
    }
    public void tileRefresh() { 
    	
       
		for (int i = 0; i < 6; i++) { // add tile
			for (int j = 0; j < 6; j++){
			ImageIcon tt = new ImageIcon("images/rect2.png");
			JLabel tempLabel = new JLabel();
			tempLabel.setIcon(tt);
			jpTile.get(i).get(j).add(tempLabel);
			lpane.add(jpTile.get(i).get(j), new Integer(1), 0);
			jpTile.get(i).get(j).setBackground(new Color(0,0,0,0));
			//***************** set different positon for odd and even
			if(i%2==0){ //even
			jpTile.get(i).get(j).setBounds(200+i*125,92+92*j, 160,160);
			}
			else{
			jpTile.get(i).get(j).setBounds(200+i*125,50+92*j, 160,160);
			}
			
			//***************** odd&even end
			
			jpTile.get(i).get(j).setVisible(true);
			explorerAdd(i,j,1);
			jpTile.get(0).get(5).setVisible(false);// to make 5,6,5,6,5,6 game board
			jpTile.get(2).get(5).setVisible(false);
			jpTile.get(4).get(5).setVisible(false);
		}
		}
	}
    
	public void buttonRefresh() {
    	
		for (int i = 0; i < 6; i++) { // add button
			for (int j = 0; j < 6; j++){
			String temp="x:"+i+" y:"+j;
			JButton b = new JButton(temp);
			b.addActionListener(new ButtonListener(this,i,j,_g));
			jpButt.get(i).get(j).add(b, BorderLayout.CENTER);
			lpane.add(jpButt.get(i).get(j), new Integer(2), 0);
			jpButt.get(i).get(j).setBackground(new Color(0,0,0,0));
			

			//***************** set different positon for odd and even
			if(i%2==0){//even
			jpButt.get(i).get(j).setBounds(235+i*125,102+92*j, 80,40);
			
			}
			else{
			jpButt.get(i).get(j).setBounds(235+i*125,60+92*j, 80,40);
			}
			
			//***************** odd&even end
//			jpButt.get(i).get(j).setBounds(200+i*125,60+92*j, 160,40);
			}
			jpButt.get(0).get(5).setVisible(false);// to make 5,6,5,6,5,6 game board
			jpButt.get(2).get(5).setVisible(false);
			jpButt.get(4).get(5).setVisible(false);
		}
		
	}

	public void setButtonText(int i, int j, String arg0){   //reset the text in button
		JButton b = new JButton(arg0);
		jpButt.get(i).get(j).removeAll();
		jpButt.get(i).get(j).add(b, BorderLayout.CENTER);
	}
	
	public void addTile(int i,int j,int player){
		_player=player;  //*** for later use
		jpTile.get(i).get(j).setVisible(true);
		
	}
	public void explorerAdd(int i, int j, int player){
		
		JLabel jlabel = new JLabel("Jerk#1");
	    jlabel.setFont(new Font("Verdana",1,10));
		jpButt.get(i).get(j).add(jlabel, BorderLayout.NORTH);
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GUI();
    }

}
