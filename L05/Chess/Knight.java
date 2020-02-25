import java.awt.Color;

import enigma.console.Console;

public class Knight extends ChessPiece {

	public Knight(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	
	public boolean move(int row, int col) {
		
		if (row < ChessBoard.ROW_MIN || row > ChessBoard.ROW_MAX ||
	            col < ChessBoard.COL_MIN || col > ChessBoard.COL_MAX) {
			return false;
		}	
		else {
			//if the knight does one of the 4 allowed moves where the row increases/decreases by 2, and the square is empty or has an adversary piece, the move is valid
			if((row == super.getRow() + 2 || row == super.getRow() - 2) && (col == super.getCol() - 1 || col == super.getCol() + 1)) {
				if(super.getBoard(row, col) != null) {
					if(super.getBoard(row, col).getColor().equals(super.getOppositeColor())){
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
				}
				else {
					super.changeBoard(row, col);
					super.setCol(col);                    		
					super.setRow(row);
					return true;
				}
			}
			//if the knight does one of the 4 allowed moves where the row increases/decreases by 1, and the square is empty or has an adversary piece, the move is valid
			if((row == super.getRow() + 1 || row == super.getRow() - 1) && (col == super.getCol() - 2 || col == super.getCol() + 2)) {
				if(super.getBoard(row, col) != null) {
					if(super.getBoard(row, col).getColor().equals(super.getOppositeColor())){
						super.changeBoard(row, col);
						super.setCol(col);                    		
						super.setRow(row);
						return true;
					}
				}
				else {
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

