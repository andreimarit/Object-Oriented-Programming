import java.awt.Color;

import enigma.console.Console;

public class Rook extends ChessPiece {
	
	public Rook(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	
	public boolean move(int row, int col) {
		
		if (row < ChessBoard.ROW_MIN || row > ChessBoard.ROW_MAX ||
	            col < ChessBoard.COL_MIN || col > ChessBoard.COL_MAX) {
			return false;
		}
			else {
				if(super.getCol() == col){  						//the rook goes on the same column
					if(super.getRow() < row) {
						for(int i = super.getRow() + 1; i < row; i++) {      //if it meets another piece in the way, it can't make the move
							if(super.getBoard(i, col) != null) {
								return false;
							}
						}	
					}
					else {
						for(int i = super.getRow() - 1; i > row; i--) {      //if it meets another piece in the way, it can't make the move
							if(super.getBoard(i, col) != null) {
								return false;
							}
						}	
					}
				}
				else if(super.getRow() == row) {
					if(super.getCol() < col) {
						for(int i = super.getCol() + 1; i < col; i++) {
							if(super.getBoard(row, i) != null) {
								return false;
							}
						}
					}
					else {
						for(int i = super.getCol() - 1; i > col; i--) {
							if(super.getBoard(row, i) != null) {
								return false;
							}
						}
					}
				}
				//if at the end there is no piece, or a piece of opposite colour, it's ok
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
				
			
				
	 return false;
			}
	}

}
