/* Author: Kevin Duggan 
 * File: Board.java
 * Purpose: Provide a class of which one instance represents the playable game area.
 * 			Provide useful methods thereon.
 */

package tikal;
import java.util.*;

public class Board {
		ArrayList<ArrayList<Tile>> grid;
		int tilecount;
		Player player;
		
		public Board(Player ply) {
            /**This class needs references to each Player object when it is instantiated.*/
			player = ply;
			grid = new ArrayList<ArrayList<Tile>>();
			for (int i = 0; i < 6; i++)
				grid.add(new ArrayList<Tile>());
			int j;
			for (int i = 1; i < 6; i += 2) { /* Fill five-high columns with null*/
				j = 5;
				while (j-- > 0)
						grid.get(i).add(null);
			}
			for (int i = 6; i >= 0; i -= 2) { /* Fill in six-high columns */
				j = 6;
				while (j-- > 0)
					grid.get(i).add(null);
			}
		}
		
/*****************************************************************************
				Status Query Methods
*****************************/
		public boolean hasTile(int x, int y) {
			/**This method returns true if there is a tile at the given X and Y, and returns False otherwise.
			 */
			if (grid.get(x).get(y) != null)
				return true;
			return false;
		}
		
		public boolean isFull() {
			/**This method returns true if all spaces contain a tile, and False otherwise. */
			return tilecount < 33;
		}
		
/*****************************************************************************
				Getters
*****************************/
		public Tile getTile(int x, int y) {
			/**This method returns the Tile object stored at the given X and Y, or could return null.
			 * You should check that a tile exists at the space with hasTile.
			 * */
			return (grid.get(x).get(y));
		}
		
		public int getNumberOfTiles() {
			return tilecount;
		}
	
/*****************************************************************************
				Setters and Adders
*****************************/
		public boolean placeDefaultTile(int x, int y) {
		/**If X and Y point to an available space, this method adds a new Tile object with default settings
		 * at the X and Y and returns true. If the space is not free, it does not place anything and returns False.
		 * You might want placeTile or placeNewTile, instead of this method. 
		 */
				if (grid.get(x).get(y) != null)
					return false;
				grid.get(x).set(y, new Tile(p1, p2));
				return true;
		}
		
		public boolean placeTile(int x, int y, Tile t) {
		/**If X and Y point to an available space, this method adds the Tile object it is called 
		 * with and returns true. If (X,Y) is not free, it adds nothing and returns false.
		 */
				if (grid.get(x).get(y) != null)
					return false;
				grid.get(x).set(y, t);
				return true;
		}
		
		public boolean placeNewTile(int x, int y, int pyramid, int p1_exp, int p2_exp) {
		/**If X and Y point to an available space, this method adds a Tile object with
		 * the properties specified, and returns true. If (X,Y) is not free, it adds
		 * nothing and return False.;
		 */
				if (grid.get(x).get(y) != null)
					return false;
				grid.get(x).set(y, new Tile(p1, p2, pyramid, p1_exp, p2_exp));
				return true;
		}
}
