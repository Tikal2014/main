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
			for (int i = 0; i < 6; i++)
				grid.add(new ArrayList<Tile>);
			int j;
			for (int i = 1; i < 6; i += 2) {
				j = 5;
				while (j--)
						grid.get(i).add(null);
			}
			for (i = 6; i >= 0; i -= 2) { /* Fill in six-high columns */
				j = 6;
				while (j--)
					grid.get(i).add(null);
			}
		}
		
		public boolean hasTile(int x, int y) {
			/**This method returns True if there is a tile at the given X and Y, and returns False otherwise. */
			if (grid.get(x).get(y) != NULL)
				return True;
			return False;
		}
		
		public Tile getTile(int x, int y) {
			/**This method returns the Tile object stored at the given X and Y, or could return null.
			 * You should check that a tile exists at the space with hasTile.*/
			return (grid.get(x).get(y);
		}
		
		public boolean isFull() {
			/**This method returns True if all spaces contain a tile, and False otherwise. */
}
