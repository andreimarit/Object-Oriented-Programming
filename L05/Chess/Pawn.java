import java.awt.Color; 
import enigma.console.*; 

public class Pawn extends ChessPiece{
	
	public Pawn(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	/*
	 * row and col are destination
	 */
	public boolean move(int row, int col) { 
		
		if (row < ChessBoard.ROW_MIN || row > ChessBoard.ROW_MAX ||
	            col < ChessBoard.COL_MIN || col > ChessBoard.COL_MAX) {
			return false;
		}
		else {
			if(super.getCol() == col && super.getBoard(row, col) == null) {  //if it moves one square ahead, and the square is empty
				if(super.getColor().equals(Color.white)) {                   //if it is white, the future row must be current row - 1
					if(super.getRow() - 1 == row ) {
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
				}
				else               //color is black here
					if(super.getRow() + 1 == row ) {                          //if black, future row must be current row + 1
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
			}
			else if((super.getCol() == col + 1 || super.getCol() == col - 1)) {      //if the column isn't the same, it means it captures a piece, and goes one 
				if(super.getColor().equals(Color.white)) {															//square on diagonal
					if((super.getRow()- 1 == row) && super.getBoard(row, col).getColor().equals(Color.black) ) {
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
				}
				else                  //color is black
					if((super.getRow() + 1 == row) && super.getBoard(row, col).getColor().equals(Color.white)) {
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
			}
		}

		return false;
	}

}
