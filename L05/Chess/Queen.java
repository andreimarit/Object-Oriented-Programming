import java.awt.Color;

import enigma.console.Console;

public class Queen extends ChessPiece {
	
	public Queen(Console s_console, int row, int col, char symbol, Color color, ChessBoard board) {
		super(s_console, row, col, symbol, color, board);
	}
	
	public boolean move(int row, int col) {
		Bishop Part1 = new Bishop(super.getS_console(), super.getRow(), super.getCol(), 'B', super.getColor(), super.getAllBoard());
		Rook Part2 = new Rook(super.getS_console(), super.getRow(), super.getCol(), 'R', super.getColor(), super.getAllBoard());
		
		if(row == super.getRow() || col == super.getCol()) {
			if(Part1.move(row, col)) {
			//	super.changeBoard(row, col);
				super.setCol(col);                    		
				super.setRow(row);
				return true;
			}
			else {
				return false;
			}
		}
		else if(Math.abs(row - super.getRow()) == Math.abs(col - super.getCol())) {
			if(Part2.move(row, col)) {
			//	super.changeBoard(row, col);
				super.setCol(col);                    		
				super.setRow(row);
				return true;
			}
			else {
				return false;
			}
		}
		else
			return false;
	}

}
