/* Author: Kevin Duggan
 * File: Tile.java
 * Purpose: Provide a common class for the game tiles that occupy the game board spaces.
 */

package tikal;

public class Tile {
	
	private int x, y;
	private int pyramid;
	private int exp_p1;
	private int exp_p2;
	private Player p1;
	private Player p2;
	private boolean[] connect;
	
	
/*****************************************************************************
				Constructors
*****************************/
	public Tile(int xpos, int ypos, Player one, Player two) {
		x = xpos;
		y = ypos;
		p1 = one;
		p2 = two;
		pyramid = 0;
		exp_p1 = 0;
		exp_p2 = 0;
		
		connect = new boolean[6];
		for (int i = 0; i < 6; i++)
			connect[i] = true;
	}
	
	public Tile(int xpos, int ypos, Player one, Player two, int init_pyramid) {
		x = xpos;
		y = ypos;
		p1 = one;
		p2 = two;
		pyramid = init_pyramid;
		exp_p1 = 0;
		exp_p2 = 0;
	}
	
	public Tile(int xpos, int ypos, Player one, Player two, int init_pyramid, int p1exp, int p2exp) {
		x = xpos;
		y = ypos;
		p1 = one;
		p2 = two;
		pyramid = init_pyramid;
		exp_p1 = p1exp;
		exp_p2 = p2exp;
	}
	
/*****************************************************************************
				Status Queries
*****************************/
	public boolean hasPyramid() {
		/**This method returns true if there is a pyramid, and false if there is none. */
		return pyramid > 1;
	}

	public boolean hasPyramidBase() {
		/**This method returns true if there is a pyramid base only, false otherwise. */
		return pyramid == 1;
	}
	

    /* Currently, we assume that all tile boundaries are crossable in both directions.
        Path limitation will be implemented in the next release. */
	public boolean connectsTo(int xpos, int ypos) {
		/**If the tile at xpos, ypos can be reached from this tile, returns true.
		 * Otherwise returns false.
		 */
		if (xpos == x + 1) {
			if (ypos == y || ypos == y + 1)
				return true;
		}
		if (xpos == x - 1) {
			if (ypos == y || ypos == y - 1)
				return true;
		}
		
		return false;
			
	}
/*****************************************************************************
				Getters
*****************************/
	public Player getWinningPlayer() {
		/**This method returns whichever player has a greater number of explorers on
		 * the tile, or Null if there is a tie.
		 */
		if (exp_p1 > exp_p2)
			return p1;
		if (exp_p1 < exp_p2)
			return p2;
		return null;
	}
	public boolean[] getConnectionArray() {
		/**This method returns an array of boolean values, representing which directions
		 * the tile connects to. Position 0 is the top; numbering proceeds clockwise
		 * around the hexagon.
		 */
		return connect;
	}

/*****************************************************************************
				Setters
*****************************/
    public 


}
