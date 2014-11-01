package code;

public class Player {

	private static int AP = 8;
	private static String _currentPlayer = "Player1";

	// If we assume AP isn't carried over each turn, don't need to worry about which
	// player has which AP
	public static void reduceAP() {
		AP--; //decrement AP
	}

	public static int getAP() {
		return AP; 
	}

	public void resetAP() {
		AP = 8; //at end of turn, sets AP back to 8 for next player
	}

	public static boolean enoughAP(){
		return AP>0; //check if AP>0, only 1 AP required for any action
	}
	public static void switchPlayer() {
		if (_currentPlayer == "Player1") {
			_currentPlayer = "Player2";
		} else if (_currentPlayer == "Player2") {
			_currentPlayer = "Player1"; //changes from p1 to p2
		}
	}

	public static String getPlayer() {
		return _currentPlayer;
	}

}
