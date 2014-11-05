package tikal;

public class Game {

	/*
	 * Tile and Board classes handle these
	 */
/*	private int _tileCount = 0;
	Tile[] tilePositions = new Tile[33]; //array of tiles, with indices as positions
	int[] p1ExplorerPositions = new int[33]; //array of player 1 explorer counts and positions
	int[] p2ExplorerPositions = new int[33]; //same for p2
	int[] pyramidPositions = new int[33]; //array of pyramid positions and values
*/
	private board;
	
	public Game() {
		board = new Board;
	}
	
	public int[] placeExplorer(int tile) { //placing an explorer, at the tile position used as a parameter
		if (Player.enoughAP()) {//checks for enough AP
			if (Player.getPlayer() == "Player1") {
				p1ExplorerPositions[tile]++; //place a p1 explorer
				Player.reduceAP(); //reduce AP
			} else if (Player.getPlayer() == "Player2") {
				p2ExplorerPositions[tile]++; //same for p2
				Player.reduceAP();
			}
		}
	if (Player.getPlayer() == "Player1") {
		return p1ExplorerPositions;
        	}
        else{
            return p2ExplorerPositions;
        	}
	}

	public int[] placePyramid(int tile) {
		if (Player.enoughAP()) {
			if (Tile.hasPyramid(tile)) { //check if tiles has at least a base pyramid
				pyramidPositions[tile]++; //add pyramid level
				Player.reduceAP();
			}
		}
		return pyramidPositions;
	}

	public void moveExplorer(int startTile, int endTile) { //moving from start tile (current) to end tile
		// check if move is legal
		if (Player.enoughAP()) {
			if (Player.getPlayer() == "Player1") {
				p1ExplorerPositions[startTile]--; //decrement explorer count on starting tile
				p1ExplorerPositions[endTile]++; //increment explorer count on end tile
				Player.reduceAP();
			} else if (Player.getPlayer() == "Player2") {
				p2ExplorerPositions[startTile]--;
				p2ExplorerPositions[endTile]++;
				Player.reduceAP();
			}
		}
	}

	public void endTurn() { //should be triggered by a button click
		Player.switchPlayer();
		Player.resetAP();
	}

	/*
	 * addTile method moved to Board class
	 */
/*	public void addTile() {
		_tileCount++;
		if (_tileCount == 33) { //board is full
			scoreP1(p1ExplorerPositions, p2ExplorerPositions, pyramidPositions);
			scoreP2(p1ExplorerPositions, p2ExplorerPositions, pyramidPositions);
			endGame();
		}
	} */

	private void endGame() {
		//prevnts more moves from ebing made, displays message

	}

	private int scoreP1(int[] ep1, int[] ep2, int[] pp) {
		int p1Score = 0;
		for (int i = 0; i < 33; i++) {
			if (pp[i] != 0) {
				if (ep1[i] > ep2[i]) { // 1 point for every pyramid level on spaces where p1 has more explorers than p2
					p1Score = p1Score + pp[i];
				}
			}
			else {
				for (int i = 0; i < 33; i++) {
					if (ep1[i] > ep2[i]) {
					p1Score++; //1 point for tiles where p1 have more explorers than p2, but there is no pyramid
					}
				}
			}
		}

		return p1Score;
	}

	private int scoreP2(int[] ep1, int[] ep2, int[] pp) {
		int p2Score = 0;
		for (int i = 0; i < 33; i++) {
			if (pp[i] != 0) {
				if (ep1[i] < ep2[i]) {
					p2Score = p2Score + pp[i];
				}
			}
			else{
				for (int i = 0; i < 33; i++) {
					if (ep1[i] < ep2[i]) {
					p2Score++;
					}
				}
			}
		}
		return p2Score;
	}

}
