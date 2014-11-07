/* Author: Kevin Duggan
 * File: Tile.java
 * Purpose: Provide a common class for the game tiles that occupy the game board spaces.
 */

package tikal;

public class Tile {
	
	private int x, y;           /* X-Y Coords of this tile*/
	private int pyramid;        /* Pyramid level. 0 = no base, 1 = base, >1 = levels */
	private int exp_p1;         /* Player 1 explorers */
	private int exp_p2;
	private Player p1;          /* Reference to player one Player object */
	private Player p2;
	private boolean[] connect;  /* Array of path markers */
	
	
/*****************************************************************************
				Constructors
*****************************/
	public Tile(int xpos, int ypos, Player one, Player two) {
        /** This option: Pass the tile its x and y positions, and references to each player.
            Explorers and pyramid levels are initialized at zero. */
		x = xpos;
		y = ypos;
		p1 = one;
		p2 = two;
		pyramid = 1;
		exp_p1 = 0;
		exp_p2 = 0;
		
		connect = new boolean[6];
		for (int i = 0; i < 6; i++)
			connect[i] = true;
	}
	
	public Tile(int xpos, int ypos, Player one, Player two, int init_pyramid) {
        /** This option: same as above, plus set pyramid number on instantiation. */
		x = xpos;
		y = ypos;
		p1 = one;
		p2 = two;
		pyramid = init_pyramid;
		exp_p1 = 0;
		exp_p2 = 0;
	}
	
	public Tile(int xpos, int ypos, Player one, Player two, int init_pyramid, int p1exp, int p2exp) {
        /** This option: same as above, but also set explorers for each player. */
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
		return pyramid > 2; /* A pyramid level of 2 represents a pyr base, + 1 level. */
	}

	public boolean hasPyramidBase() {
		/**This method returns true if there is a pyramid base present, false otherwise. */
		return pyramid > 1;
	}

    public boolean hasPyramidBaseOnly() {
        //*This method retursn true if there a pyramid base with no levels added, false otherwise. */
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
	public Player getPlayerWithMostExplorers() {
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

    public int getPyramidTotal() {
        /**This method returns the pyramid height. 1 = empty base, 2 = 1 level on base,etc.*/
        return pyramid;
    }

    public int getPyramidLevels() {
        /**This method returns the height of the pyramid, not counting the base.*/
        return pyramid - 1;
    }

/*****************************************************************************
				Setters
*****************************/
    public void setPyramid(int i) {
        /** This method sets the pyramid number to whatever int is supplied. */
        pyramid = i;
    }

    public void increasePyramid() {
        /** This method increments the pyramid number by 1, no sanity checking */
        ++pyramid;
    }
    
    public boolean addPyramidLevel() {
        /**If the pyramid level is not at the maximum, it 


}
