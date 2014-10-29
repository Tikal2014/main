package code;

public class Player {

	private static int AP = 8;
	private static String _currentPlayer = "Player1";

	// If we assume AP isn't carried over, don't need to worry about which
	// player has which AP
	public static void reduceAP() {
		AP--;
	}

	public static int getAP() {
		return AP;
	}

	public void resetAP() {
		AP = 8;
	}

	public static boolean enoughAP(){
		return AP>0;
	}
	public static void switchPlayer() {
		if (_currentPlayer == "Player1") {
			_currentPlayer = "Player2";
		} else if (_currentPlayer == "Player2") {
			_currentPlayer = "Player1";
		}
	}

	public static String getPlayer() {
		return _currentPlayer;
	}

}