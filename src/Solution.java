import java.util.List;

public class Solution {

	Pair currentLocation;
	int coinsCollected;

	/*
	 * representation of map: 
	 * 0 - location with coin 
	 * 1 - location without coin
	 * 2 - wall location
	 */
	int[][] map = null;

	private void buildMap(Pair initial_position, List<Pair> walls) {
		int m = this.map.length;
		int n = this.map[0].length;
		
		// mark initial_position
		if (initial_position.x >= 0 && initial_position.x < m 
				&& initial_position.y >= 0 && initial_position.y < n) {
			this.map[initial_position.x][initial_position.y] = 1;
		}
		
		// mark wall locations
		for (Pair wallLocation: walls) {
//			TODO
		}
	}
	
	public Solution(
			Pair board_dimension, 
			Pair initial_position, 
			List<Character> movements, 
			List<Pair> walls
	) {
		if (board_dimension.x > 0 && board_dimension.y > 0) {
			
			// initialize variables
			this.currentLocation = initial_position;
			this.coinsCollected = 0;
			
			// build the map
			this.map = new int[board_dimension.x][board_dimension.y];
			this.buildMap(initial_position, walls);
			
			// make the movement and collect coins
			this.applyMovements(movements);
		}
	}

	private void applyMovements(List<Character> movements) {
		// TODO
	}

	public Pair getFinalLocation() {
		return this.currentLocation;
	}

	public int totalCoinsCollected() {
		return this.coinsCollected;
	}
}

class Pair {
	int x, y;
}
