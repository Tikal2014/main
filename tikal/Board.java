/* Author: Kevin Duggan
 * File: Board.java
 * Purpose: Provide a class of which one instance represents the playable game area.
 * 			Provide useful methods thereon.
 */

package tikal;

import java.util.*;

public class Board {
		ArrayList<ArrayList<Tile>> grid;
		
		public Board() {
			grid = new ArrayList<ArrayList<Tile>>;
		}
		
		public boolean hasTile(int x, int y) {
			/**This method returns True if there is a tile at the given X and Y, and returns False otherwise. */
			if (grid[x][y] != NULL)
				return True;
			return False;
		}
		
		public Tile getTile(int x, int y) {
			if (grid[x][y] != NULL)
				return grid[x][y];
			throw new NoSuchElementException;
		}
}
