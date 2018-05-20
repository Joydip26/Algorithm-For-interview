package com.dynamicprogramming;

class Pair {
	int first, second;
}

public class OptimalStrategyGamePick {

	public Pair[][] findmovesDynamic(int pots[]) {

		Pair[][] moves = new Pair[pots.length][pots.length];

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				moves[i][j] = new Pair();
			}
		}

		for (int i = 0; i < pots.length; i++) {
			moves[i][i].first = pots[i];
		}

		for (int l = 2; l <= pots.length; l++) {
			for (int i = 0; i <= pots.length - l; i++) {
				int j = i + l - 1;
				if (pots[i] + moves[i + 1][j].second > moves[i][j - 1].second + pots[j]) {
					moves[i][j].first = pots[i] + moves[i + 1][j].second;
					moves[i][j].second = moves[i + 1][j].first;
				} else {
					moves[i][j].first = pots[j] + moves[i][j - 1].second;
					moves[i][j].second = moves[i][j - 1].first;
				}
			}
		}
		return moves;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimalStrategyGamePick osgp = new OptimalStrategyGamePick();
		int pots[] = { 3, 9, 1, 2 };
		Pair[][] moves = osgp.findmovesDynamic(pots);
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				System.out.print(moves[i][j].first + "-" + moves[i][j].second + " ");
			}
			System.out.print("\n");
		}

	}

}
