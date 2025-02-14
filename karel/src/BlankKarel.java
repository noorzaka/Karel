import stanford.karel.SuperKarel;

import static java.lang.Math.max;

public class BlankKarel extends SuperKarel {
	private int cols;
	private int rows;
	private int moves;

	private void moveToEnd() {
		while (frontIsClear()) {
			move();
			moves++;
		}
	}

	private void moveStepAndPutBeeper() {
		if (frontIsClear()) {
			move();
			moves++;
			putBeeper();
		}
	}

	public void findKarelWorldDimensions() {
		cols = 1;
		rows = 1;
		moves = 0;
		while (frontIsClear()) {
			move();
			cols++;
		}
		turnLeft();
		while (frontIsClear()) {
			move();
			rows++;
		}
		turnLeft();
		moveToEnd();
		turnLeft();
		moveToEnd();
		turnLeft();
	}

	public void moveDiagonally() {
		while (frontIsClear() && leftIsClear()) {
			putBeeper();
			move();
			turnLeft();
			move();
			turnRight();
			moves += 2;
		}
		putBeeper();
		turnAround();
		moveToEnd();
		turnAround();
	}

	public void drawTheOtherDiagonal() {
		while (noBeepersPresent() && frontIsClear()) {
			putBeeper();
			move();
			turnRight();
			move();
			turnLeft();
			moves += 2;
		}
		putBeeper();
		returnToStartPoint();
	}

	public void returnToStartPoint() {
		turnAround();
		moveToEnd();
		turnAround();
	}

	public void moveAsPlusSign() {
		int columnsHalf = cols / 2;
		int rowsHalf = rows / 2;

		moveAndPutBeeper(columnsHalf);
		turnLeft();
		moveToEndAndPutBeepers();
		turnRight();
		moveToEnd();
		turnRight();
		moveAndPutBeeper(columnsHalf);
		turnRight();
		moveToEndAndPutBeepers();
		turnLeft();
		moveToEnd();
		turnLeft();
	}

	private void moveAndPutBeeper(int steps) {
		for (int i = 0; i < steps; i++) {
			move();
			moves++;
		}
		putBeeper();
	}

	private void moveToEndAndPutBeepers() {
		while (frontIsClear()) {
			move();
			putBeeper();
			moves++;
		}
	}

	public void moveDuplicate() {
		moveAndPutBeeper((cols / 2) - 1);
		turnLeft();
		moveToEndAndPutBeepers();
		turnRight();
		putBeeper();
		move();
		moves++;
		turnRight();
		moveToEndAndPutBeepers();
		turnLeft();
		moveToEnd();
		turnLeft();
		moveAndPutBeeper((rows / 2) - 1);
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				moves++;
			} else {
				putBeeper();
				move();
				moves++;
			}
		}
		putBeeper();
		turnRight();
		move();
		moves++;
		turnRight();
		moveToEndAndPutBeepers();
		turnRight();
		moveToEnd();
		turnLeft();
		turnAround();
		moveToEnd();
		turnAround();
	}

	public void duplicateRows() {
		turnLeft();
		moveAndPutBeeper((rows / 2) - 1);
		turnRight();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				moves++;
			} else {
				putBeeper();
				move();
				moves++;
			}
		}
		putBeeper();
		turnLeft();
		move();
		moves++;
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				moves++;
			} else {
				putBeeper();
				move();
				moves++;
			}
		}
		putBeeper();
		turnLeft();
		moveToEnd();
		turnLeft();
		moveAndPutBeeper(cols / 2);
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				moves++;
			} else {
				putBeeper();
				move();
				moves++;
			}
		}
		putBeeper();
		turnLeft();
		moveToEnd();
		turnLeft();
		moveToEnd();
		turnLeft();
	}

	public void duplicateColumns() {
		moveAndPutBeeper((cols / 2) - 1);
		turnLeft();
		putBeeper();
		moveToEndAndPutBeepers();
		turnRight();
		move();
		moves++;
		turnRight();
		putBeeper();
		moveToEndAndPutBeepers();
		turnLeft();
		moveToEnd();
		turnLeft();
		moveAndPutBeeper(rows / 2);
		turnLeft();
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
				moves++;
			} else {
				putBeeper();
				move();
				moves++;
			}
		}
		putBeeper();
		turnLeft();
		moveToEnd();
		turnLeft();
	}

	public int noOfNodesPerChamber() {
		int m = Math.max(rows, cols);
		int noOfNode = m / 4;
		if ((m - (noOfNode * 4)) >= 3) {
			return noOfNode;
		}
		while (noOfNode > 0) {
			noOfNode--;
			if (m - (noOfNode * 4) >= 3) {
				return noOfNode;
			}
		}
		return 0;
	}

	public void divideAsPatterns() {
		int noOfNodes = noOfNodesPerChamber();
		int fourChambers = 4;
		int m = Math.max(rows, cols);

		while (frontIsClear()) {
			for (int j = 0; j < noOfNodes && fourChambers > 0; j++) {
				move();
				moves++;
			}
			fourChambers--;
			putBeeper();
			if (frontIsClear()) {
				move();
				moves++;
			}
		}
		turnAround();
		for (int i = 0; i < m - (noOfNodes * 4) - 3 && noBeepersPresent(); i++) {
			putBeeper();
			move();
			moves++;
		}
		if (noBeepersPresent() && (m > 7)) {
			putBeeper();
		}
	}

	public void twoOrThreeChambers() {
		int m = max(rows, cols);
		for (int i = 0; i < m / 2; i++) {
			if (frontIsClear()) {
				move();
				moves++;
				putBeeper();
				if (frontIsClear()) {
					move();
					moves++;
				}
			}
		}
	}

	public void karelIsMoving() {
		if (cols == 2 && rows == 2) {
			moveDiagonally();
		} else if (cols % 2 == 0 && rows % 2 == 0 && rows == cols) {
			moveDiagonally();
			drawTheOtherDiagonal();
		} else if (cols % 2 != 0 && rows % 2 != 0 && rows == cols && (rows > 2 && cols > 2)) {
			moveAsPlusSign();
		} else if (cols % 2 == 0 && rows % 2 == 0 && (rows > 2 && cols > 2)) {
			moveDuplicate();
		} else if (rows % 2 == 0 && cols % 2 != 0 && (rows > 2 && cols > 2)) {
			duplicateRows();
		} else if (rows % 2 != 0 && cols % 2 == 0 && (rows > 2 && cols > 2)) {
			duplicateColumns();
		} else if (rows >= 7 && cols == 1) {
			turnLeft();
			divideAsPatterns();
		} else if (cols >= 7 && rows == 1) {
			divideAsPatterns();
		} else if (rows == 2 && cols >= 7) {
			divideAsPatterns();
			turnRight();
			move();
			moves++;
			turnLeft();
			moveToEnd();
			turnAround();
			divideAsPatterns();
		} else if (cols == 2 && rows >= 7) {
			turnLeft();
			divideAsPatterns();
			moveToEnd();
			turnLeft();
			move();
			moves++;
			turnLeft();
			divideAsPatterns();
		} else if (rows == 1 && cols <= 6) {
			twoOrThreeChambers();
		} else if (cols == 1 && rows <= 6) {
			turnLeft();
			twoOrThreeChambers();
		} else if (rows == 2 && (cols <= 6 && cols != 2)) {
			twoOrThreeChambers();
			turnLeft();
			move();
			moves++;
			turnLeft();
			moveToEnd();
			turnAround();
			twoOrThreeChambers();
		} else if (cols == 2 && (rows <= 6 && rows != 2)) {
			turnLeft();
			twoOrThreeChambers();
			turnRight();
			move();
			moves++;
			turnLeft();
			turnAround();
			moveToEnd();
			turnAround();
			twoOrThreeChambers();
		}
	}

	public void run() {
		setBeepersInBag(100);
		findKarelWorldDimensions();
		karelIsMoving();
	}
}
