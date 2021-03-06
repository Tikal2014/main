package tikal;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
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

     ArrayList<ArrayList<JPanel>> jpButt = new ArrayList<ArrayList<JPanel>>();
     ArrayList<ArrayList<JPanel>> jpTile = new ArrayList<ArrayList<JPanel>>();
     
     
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
        		
        //*************** add jpanels to the container
        tileRefresh();
        buttonRefresh();
        lpane.add(backPanel, new Integer(0), 0);      
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
				if(i%2==0){
				jpTile.get(i).get(j).setBounds(200+i*125,92+92*j, 120,135);
				}
				else{
				jpTile.get(i).get(j).setBounds(200+i*125,50+92*j, 120,135);
				}
				
				//***************** odd&even end
				
				jpTile.get(i).get(j).setVisible(false);
			}
		}
	}
    
	public void buttonRefresh() {
    	
		JButton[] b = new JButton[36];
		int n = 0;
			
		for (int i = 0; i < 6; i++) { // add button
			for (int j = 0; j < 6; j++){
				String temp="x:"+i+" y:"+j;
				b[n] = new JButton(temp);
				jpButt.get(i).get(j).add(b[n]);
				lpane.add(jpButt.get(i).get(j), new Integer(2), 0);
				jpButt.get(i).get(j).setBackground(new Color(0,0,0,0));
				//***************** set different positon for odd and even
				if(i%2==0){
					jpButt.get(i).get(j).setBounds(200+i*125,102+92*j, 160,40);
				}
				else{
					jpButt.get(i).get(j).setBounds(200+i*125,60+92*j, 160,40);
				}
				
				b[n].addActionListener(new ButtonListener(n, jpTile));
				n++;
			}
		}
	}

	public void setButtonText(int i, int j, String arg0){   //reset the text in button
		JButton b = new JButton(arg0);
		jpButt.get(i).get(j).removeAll();
		jpButt.get(i).get(j).add(b);
	}
	
	public void setTileOnBoard(int i, int j){
		
		
		
	}
	
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GUI();
    }

}
