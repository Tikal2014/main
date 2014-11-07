/* Author: Kevin Duggan
 * File: Tile.java
 * Purpose: Provide a common class for the game tiles that occupy the game board spaces.
 */

package tikal;

public class Tile {
	
    static int PYRAMIDMAX;      /* Magic number: max height of pyramid */

	private int x, y;           /* X-Y Coords of this tile*/
	private int pyramid;        /* Pyramid level. 0 = no base, 1 = base, >1 = levels */
	private int exp_p1;         /* Player 1 explorers */
	private int exp_p2;
//	private Player player;      /* Reference to player one Player object */
	private boolean[] connect;  /* Array of path markers */
	
	
/*****************************************************************************
				Constructors
*****************************/
	public Tile(int xpos, int ypos, Player ply) {
        /** This option: Pass the tile its x and y positions, and references to each player.
            Explorers and pyramid levels are initialized at zero. */
		x = xpos;
		y = ypos;
        player = ply;
		pyramid = 1;    /* Default is for tile to have a pyramid base. */
		exp_p1 = 0;
		exp_p2 = 0;
		PYRAMIDMAX = 4;
		connect = new boolean[6];
		for (int i = 0; i < 6; i++)
			connect[i] = true;
	}
	
	public Tile(int xpos, int ypos, Player ply, int init_pyramid) {
        /** This option: same as above, plus set pyramid number on instantiation. */
		x = xpos;
		y = ypos;
		player = ply;
		pyramid = init_pyramid;
		exp_p1 = 0;
		exp_p2 = 0;
		PYRAMIDMAX = 4;
		connect = new boolean[6];
		for (int i = 0; i < 6; i++)
			connect[i] = true;
	}
	
	public Tile(int xpos, int ypos, Player ply, int init_pyramid, int p1exp, int p2exp) {
        /** This option: same as above, but also set explorers for each player. */
		x = xpos;
		y = ypos;
		player = ply;
		pyramid = init_pyramid;
		exp_p1 = p1exp;
		exp_p2 = p2exp;
		PYRAMIDMAX = 4;
		connect = new boolean[6];
		for (int i = 0; i < 6; i++)
			connect[i] = true;
	}
	
/*****************************************************************************
				Status Queries
*****************************/
	public boolean hasPyramidBase() {
		/**This method returns true if there is a pyramid base present, false otherwise. */
		return pyramid > 1;
	}

    public boolean hasPyramidBaseOnly() {
        //*This method retursn true if there a pyramid base with no levels added, false otherwise. */
        return pyramid == 1;
    }
	
	public boolean hasPyramid() {
		/**This method returns true if there is a pyramid, and false if there is none. */
		return pyramid > 2; /* A pyramid level of 2 represents a pyr base, + 1 level. */
	}

    public boolean canAddPyramidLevel() {
        /**This method returns true if there is room for another pyramid level, false otherwise*/
        return (pyramid < PYRAMIDMAX);
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
        if (pyramid = 0) // No base means no levels
                return 0;
        return pyramid - 1;
    }

    public int getExplorers(String p) {
    /**This method returns the number of explorers for the specified player.*/
        if (p.equals("Player1")
                return p1_exp;
        return p2_exp;
    }
	
    public String getPlayerWithMostExplorers() {
		/**This method returns whichever player has a greater number of explorers on
		 * the tile, or Null if there is a tie.
		 */
		if (exp_p1 > exp_p2)
			return "Player1";
		if (exp_p1 < exp_p2)
			return "Player2";
		return null;
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
        /**If the pyramid level is not at the maximum, add a level and return true.
            If the pyramid level is maxed out, add nothing, return false. */
        if (pyramid == PYRAMIDMAX)
                return false;
        ++pyramid;
        return true;
    }

    public boolean removePyramidLevel() {
        /**This method removes 1 level and returns true if there is at least 1 level on top of
        the base. It changes nothing and returns false otherwise.*/
        if (pyramid > 1) {
                --pyramid;
                return true;
        }
        return false;
    }
    
    public void addExplorer(String p) {
        /**This method adds an explorer for the player specified.*/
        if (p.getPlayer().equals("Player1") {
                ++p1_exp;
                return null;
        }
        ++p2_exp;
    }

    public boolean removeExplorer(String p) {
        /**As long as player "p" has at least 1 explorer on the tile, this method removes 1 exp.
        and returns true. Otherwise it removes nothing and returns false.*/
        if (p.equals("Player1")
                if (p1_exp > 0) {
                        --p1_exp;
                        return true;
                }
        if (p2_exp > 0) {
                --p2_exp;
                return true;
        }
        return false;
    }


    
}
