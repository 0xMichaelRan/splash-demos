import java.util.List;

public class Solution {

	/*
	 * representation of map: 0 - wall 1 -
	 */
	int[][] map = null;
	int coinsCollected = 0;

	public Solution(
			Pair board_dimension, 
			Pair initial_position, 
			List<Character> movements, 
			List<Pair> walls
	) {
		map = new int[board_dimension.x][board_dimension.y];
		this.buildMap(initial_position, walls);
		this.applyMovements(movements);
	}

	private void buildMap(Pair initial_position, List<Pair> walls) {
		// TODO
	}

	private void applyMovements(List<Character> movements) {
		// TODO
	}

	public Pair getFinalLocation() {
		// TODO
		return null;
	}

	public int totalCoinsCollected() {
		return coinsCollected;
	}
}

class Pair {
	int x, y;
}
