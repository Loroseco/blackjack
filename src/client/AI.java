package client;

/**
 * Class for AI
 * @author Loroseco
 *
 */
public class AI extends Player {
	
	@Override
	public String getMove(Object obj) {
		int score = (int) obj;
		if (score < 17) {
			return "H";
		} else {
			return "S";
		}
	}
}
