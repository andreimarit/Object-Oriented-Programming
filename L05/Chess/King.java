import java.awt.Color;

import enigma.console.Console;

public class King extends ChessPiece {

	public King(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	
	public boolean move(int row, int col) {
		
		if (row < ChessBoard.ROW_MIN || row > ChessBoard.ROW_MAX ||
	            col < ChessBoard.COL_MIN || col > ChessBoard.COL_MAX || (super.getCol() == col && super.getRow() == row)) {
			return false;
		}	
		else {
			if((row == super.getRow() + 1 || row == super.getRow() - 1 || row == super.getRow()) && 
					(col == super.getCol() + 1 || col == super.getCol() - 1 || col == super.getCol())) {
				
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
