public class My2048 {

	private int[] board;

	public My2048(int[] board) {
		this.board = board;
	}

	public void moveUp() {
		for (int i = 0; i < 16; i++) {
			moveUpToEnd(i);
		}
	}

	private void moveUpToEnd(int index) {
		if (index < 4)
			return;
		
		int x = index % 4;
		int y = index / 4;
		for (int c = y; c > 0; c--)
			if (board[x + (c - 1) * 4] == 0) {
				board[x + (c - 1) * 4] = board[x + (c) * 4];
				board[x + (c ) * 4] = 0;
			}
	}
	public void moveDown() {
		for (int i = 15 ; i >= 0; i--) {
			moveDownToEnd(i);
		}
	}

	private void moveDownToEnd(int index) {
		if (index > 11)
			return;
		
		int x = index % 4;
		int y = index / 4;
		for (int c = y; c >=0; c--)
			if (board[x + (c + 1) * 4] == 0) {
				board[x + (c + 1) * 4] = board[x + (c) * 4];
				board[x + (c ) * 4] = 0;
			}
		
	}


	public int getValue(int i) {
		return board[i];
	}
	
	public void printBoard() {
		int index = 0;
		System.out.println();
		for(int i : board) {
			System.out.print("[" + i + "]" );
		    index++;
		    if(index % 4 ==0) System.out.println();
		    
		}
	}

	public void addAfterMoveUp() {
		for (int i = 0; i < 16; i++) {
			AddUpToEnd(i);
		}
	}

	private void AddUpToEnd(int index) {
		if (index < 4)
			return;
		
		int x = index % 4;
		int y = index / 4;
		for (int c = y; c > 0; c--)
			if (board[x + (c - 1) * 4] == board[x + (c) * 4]) {
				board[x + (c - 1) * 4] += board[x + (c) * 4];
				board[x + (c ) * 4] = 0;
			}
		
	}

	public void addAfterMoveDown() {
		for (int i = 15; i >=0; i--) {
			AddDownToEnd(i);
		}
	}

	private void AddDownToEnd(int index) {
	
		if (index > 11)
			return;
		
		int x = index % 4;
		int y = index / 4;
		for (int c = y; c >=0; c--)
			if (board[x + (c + 1) * 4] == board[x + (c) * 4]) {
				board[x + (c + 1) * 4] += board[x + (c) * 4];
				board[x + (c ) * 4] = 0;
			}
		
	}
		
	}



