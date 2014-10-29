package code;

public class Game {

	private int _tileCount = 0;
	Tile[] tilePositions = new Tile[33];
	Integer[] p1ExplorerPositions = new Integer[33];
	Integer[] p2ExplorerPositions = new Integer[33];
	Integer[] pyramidPositions = new Integer[33];

	public void placeExplorer(int tile) {
		if (Player.enoughAP()) {
			if (Player.getPlayer() == "Player1") {
				p1ExplorerPositions[tile]++;
				Player.reduceAP();
			} else if (Player.getPlayer() == "Player2") {
				p2ExplorerPositions[tile]++;
				Player.reduceAP();
			}
		}
	}

	public void placePyramid(int tile) {
		if (Player.enoughAP()) {
			if (Tile.hasPyramid(tile)) {
				pyramidPositions[tile]++;
				Player.reduceAP();
			}
		}
	}

	public void moveExplorer(int startTile, int endTile) {
		// check if move is legal
		if (Player.enoughAP()) {
			if (Player.getPlayer() == "Player1") {
				p1ExplorerPositions[startTile]--;
				p1ExplorerPositions[endTile]++;
				Player.reduceAP();
			} else if (Player.getPlayer() == "Player2") {
				p2ExplorerPositions[startTile]--;
				p2ExplorerPositions[endTile]++;
				Player.reduceAP();
			}
		}
	}

	public void endTurn() {
		Player.switchPlayer();
	}

	public void addTile() {
		_tileCount++;
		if (_tileCount == 33) {
			scoreP1(p1ExplorerPositions, p2ExplorerPositions, pyramidPositions);
			scoreP2(p1ExplorerPositions, p2ExplorerPositions, pyramidPositions);
			endGame();
		}

	}

	private void endGame() {
		// TODO Auto-generated method stub

	}

	private int scoreP1(Integer[] ep1, Integer[] ep2, Integer[] pp) {
		int p1Score = 0;
		for (int i = 0; i < 33; i++) {
			if (pp[i] != null) {
				if (ep1[i] > ep2[i]) {
					p1Score = p1Score + pp[i];
				}

			}
		}
		for (int i = 0; i < 33; i++) {
			if (ep1[i] > ep2[i]) {
				p1Score++;
			}
		}
		return p1Score;
	}

	private int scoreP2(Integer[] ep1, Integer[] ep2, Integer[] pp) {
		int p2Score = 0;
		for (int i = 0; i < 33; i++) {
			if (pp[i] != null) {
				if (ep1[i] < ep2[i]) {
					p2Score = p2Score + pp[i];
				}

			}
		}
		for (int i = 0; i < 33; i++) {
			if (ep1[i] < ep2[i]) {
				p2Score++;
			}
		}
		return p2Score;

	}

}
