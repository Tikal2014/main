/* Author: Kevin Duggan
 * File: Tile.java
 * Purpose: Provide a common class for the game tiles that occupy the game board spaces.
 */

package tikal;

public class Tile {
	
	private int pyramid;
	private int exp_p1;
	private int exp_p2;
	private Player p1;
	private player p2;
	
	public Tile(Player one, Player two) {
		p1 = one;
		p2 = two;
		pyramid = 0;
		exp_p1 = 0;
		exp_p2 = 0;
	}
	
	public Tile(Player one, Player two, int init_pyramid) {
		p1 = one;
		p2 = two;
		pyramid = init_pyramid;
		exp_p1 = 0;
		exp_p2 = 0;
	}
	
	public Tile(Player one, Player two, int init_pyramid, int p1exp, int p2exp) {
		p1 = one;
		p2 = two;
		pyramid = init_pyramid;
		exp_p1 = p1exp;
		exp_p2 = p2exp;
	}
	
}