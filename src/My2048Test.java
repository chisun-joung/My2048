import static org.junit.Assert.*;

import org.junit.Test;


public class My2048Test {

	
	public int [] board  = { 0,2,0,2,
									   0,2,0,0,
									   2,2,0,2,
									   0,2,4,2,
	};
	
	@Test
	public void testMoveUp() {
		My2048 myboard = new My2048(board);
		myboard.moveUp();
		myboard.printBoard();
		assertEquals(4,myboard.getValue(2));
	}
	
	@Test
	public void testMoveDown() {
		My2048 myboard = new My2048(board);
		myboard.moveDown();
		myboard.printBoard();
		assertEquals(2,myboard.getValue(7));
	}
	
	@Test
	public void testMoveUpandAdd() {
		My2048 myboard = new My2048(board);
		myboard.moveUp();
		myboard.addAfterMoveUp();
		myboard.moveUp();
		myboard.printBoard();
		assertEquals(4,myboard.getValue(1));
	}
	
	@Test
	public void testMoveUpandAdd2() {
		My2048 myboard = new My2048(board);
		myboard.moveUp();
		myboard.addAfterMoveUp();
		myboard.moveUp();
		
		myboard.moveUp();
		myboard.addAfterMoveUp();
		myboard.moveUp();
		
		myboard.printBoard();
		assertEquals(8,myboard.getValue(1));
	}
	
	
	@Test
	public void testMoveDownAdd() {
		My2048 myboard = new My2048(board);
		myboard.moveDown();
		myboard.addAfterMoveDown();
		myboard.moveDown();
		myboard.printBoard();
		assertEquals(4,myboard.getValue(13));
	}
	
	@Test
	public void testMoveDownAdd2() {
		My2048 myboard = new My2048(board);
		
		myboard.moveDown();
		myboard.addAfterMoveDown();
		myboard.moveDown();
		
		myboard.moveDown();
		myboard.addAfterMoveDown();
		myboard.moveDown();
		
		myboard.printBoard();
		assertEquals(8,myboard.getValue(13));
	}

}
