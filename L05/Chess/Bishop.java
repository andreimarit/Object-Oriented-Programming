import java.awt.Color;

import enigma.console.Console;

public class Bishop extends ChessPiece {

	public Bishop(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	
	public boolean move(int row, int col) {
		
		if (row < ChessBoard.ROW_MIN || row > ChessBoard.ROW_MAX ||
	            col < ChessBoard.COL_MIN || col > ChessBoard.COL_MAX) {
			return false;
		}	
		else {
			if(super.getBoard(row, col) != null && super.getBoard(row, col).getColor().equals(super.getColor()) ) {
				return false;
			}
			else {
				if(row > super.getRow()) {
					if(col > super.getCol()) {
						for(int i = 1; i < Math.abs(col - super.getCol()); i++) {
							if(super.getBoard(super.getRow() + i, super.getCol() + i) != null) {
								return false;
							}
						}
					}
					else {
						for(int i = 1; i < Math.abs(col - super.getCol()); i++) {
							if(super.getBoard(super.getRow() + i, super.getCol() - i) != null) {
								return false;
							}
						}
					}
				}
				else {
					if(col > super.getCol()) {
						for(int i = 1; i < Math.abs(col - super.getCol()); i++) {
							if(super.getBoard(super.getRow() - i, super.getCol() + i) != null) {
								return false;
							}
						}
					}
					else {
						for(int i = 1; i < Math.abs(col - super.getCol()); i++) {
							if(super.getBoard(super.getRow() - i, super.getCol() - i) != null) {
								return false;
							}
						}
					}
				}
			}
			
			}
		
		super.changeBoard(row, col);
		super.setCol(col);                    		
		super.setRow(row);
		return true;
	}
	

}