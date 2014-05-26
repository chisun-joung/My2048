import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class My2048 {

	private static final int X_SIZE = 4;
	private static final int MAX_CELL = 16;
	private int[] board;
	private List<Integer> emptyCellList = new ArrayList<Integer>();

	public My2048(int[] board) {
		this.board = board;
	}

	public void moveUp() {
		for (int i = 0; i < MAX_CELL; i++) {
			moveUpToEnd(i);
		}
	}

	private void moveUpToEnd(int index) {
		if (index < X_SIZE)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int c = y; c > 0; c--)
			packCell(x, x, c - 1, c);
	}

	public void addAfterMoveUp() {
		for (int i = 0; i < MAX_CELL; i++) {
			AddUpToEnd(i);
		}
	}

	private void AddUpToEnd(int index) {
		if (index < X_SIZE)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int c = y; c > 0; c--)
			addPackedCell(x, x, c - 1, c);

	}

	public void moveDown() {
		for (int i = MAX_CELL - 1; i >= 0; i--) {
			moveDownToEnd(i);
		}
	}

	private void moveDownToEnd(int index) {
		if (index > MAX_CELL - X_SIZE - 1)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int c = y; c >= 0; c--)
			packCell(x, x, c + 1, c);
	}

	public void addAfterMoveDown() {
		for (int i = MAX_CELL - 1; i >= 0; i--) {
			AddDownToEnd(i);
		}
	}

	private void AddDownToEnd(int index) {
		if (index > MAX_CELL - X_SIZE - 1)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int c = y; c >= 0; c--)
			addPackedCell(x, x, c + 1, c);
	}

	public void moveLeft() {
		for (int i = 0; i < MAX_CELL; i++) {
			moveLeftEnd(i);
		}
	}

	private void moveLeftEnd(int index) {
		if (index % X_SIZE == 0)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int r = x; r > 0; r--) {
			packCell(r - 1, r, y, y);
		}
	}

	public void addAfterMoveLeft() {
		for (int i = 0; i < MAX_CELL; i++) {
			AddLeftToEnd(i);
		}
	}

	private void AddLeftToEnd(int index) {
		if (index % X_SIZE == 0)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int r = x; r > 0; r--) {
			addPackedCell(r - 1, r, y, y);
		}
	}

	public void moveRight() {
		for (int i = MAX_CELL - 1; i >= 0; i--) {
			moveRightEnd(i);
		}
	}

	private void moveRightEnd(int index) {
		if (index % X_SIZE == 3)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int r = x; r < 3; r++) {
			packCell(r + 1, r, y, y);
		}
	}

	public void addAfterMoveRight() {
		for (int i = MAX_CELL - 1; i >= 0; i--) {
			AddRightEnd(i);
		}
	}

	private void AddRightEnd(int index) {
		if (index % X_SIZE == 3)
			return;

		int x = index % X_SIZE;
		int y = index / X_SIZE;
		for (int r = x; r < 3; r++) {
			addPackedCell(r + 1, r, y, y);
		}
	}

	private void packCell(int nX, int cX, int nY, int cY) {
		if (board[nX + nY * X_SIZE] == 0) {
			board[nX + nY * X_SIZE] = board[cX + cY * X_SIZE];
			board[cX + cY * X_SIZE] = 0;
		}
	}

	private void addPackedCell(int nX, int cX, int nY, int cY) {
		if (board[nX + (nY) * X_SIZE] == board[cX + (cY) * X_SIZE]) {
			board[nX + (nY) * X_SIZE] += board[cX + (cY) * X_SIZE];
			board[cX + (cY) * X_SIZE] = 0;
		}
	}

	public void printBoard() {
		int index = 0;
		System.out.println();
		for (int i : board) {
			System.out.print("[" + i + "]");
			index++;
			if (index % X_SIZE == 0)
				System.out.println();

		}
	}

	public int getValue(int i) {
		return board[i];
	}

	public void actionUp() {
		moveUp();
		addAfterMoveUp();
		moveUp();
	}

	public void actionDown() {
		moveDown();
		addAfterMoveDown();
		moveDown();
	}

	public void actionLeft() {
		moveLeft();
		addAfterMoveLeft();
		moveLeft();
	}

	public void actionRight() {
		moveRight();
		addAfterMoveRight();
		moveRight();
	}

	public void findEmptyCell() {
		emptyCellList.clear();
		for(int index = 0 ; index < board.length ; index++ ) {
			if(board[index] == 0) {
				emptyCellList.add(index);
			}
		}
	}

	public int countEmptyCell() {
		return emptyCellList.size();
	}

	public void putValueCell() {
		Collections.shuffle(emptyCellList);
		int index = emptyCellList.remove(0);
		board[index] = (int)(Math.random()*10)< 8 ? 2 : 4 ;
		
	}

	public void reStart() {
		for(int i = 0; i < board.length; i++){
			board[i] = 0;
		}
		findEmptyCell();
		putValueCell();
		findEmptyCell();
		putValueCell();
	}
}
