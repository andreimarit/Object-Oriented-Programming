import java.awt.Color; 
import enigma.console.*; 
/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessPiece
{
    // instance variables - replace the example below with your own
    private int row;
    private int col;
    private char symbol;
    private Color color;
    private Console s_console;
    private ChessBoard board;
    /**
     * Constructor for objects of class ChessPiece
     */
    protected ChessPiece(Console s_console, int row, int col, char symbol, Color color, ChessBoard board)
    {
        // initialise instance variables
        this.row = row;
        this.col = col;
        this.symbol = symbol;
        this.color = color;
        this.s_console = s_console;
        this.board = board;
    }

    public boolean move(int row, int col) {
    	return false;
    }
    
    public void print(TextAttributes attrs, Color back)
    {
        attrs = new TextAttributes(this.color, back);//Changes the color
        s_console.setTextAttributes(attrs);
        System.out.print(symbol);
    }
    
    public void changeBoard(int i, int j) {
    	board.setBoardEntry(board.getPiece(this.row, this.col), i, j);
    	board.setBoardEntry(null, this.row, this.col);
    }

	public ChessBoard getBoard() {
		return board;
	}

	public void setBoard(ChessBoard board) {
		this.board = board;
	}
	
	public void setPiece(ChessPiece piece, int i, int j) {
//		this.board[i][j] = piece;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Color getColor() {
		return color;
	}
	
	public Color getOppositeColor() {
		if(this.color.equals(Color.white))
			return Color.black;
		else
			return Color.white;			
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Console getS_console() {
		return s_console;
	}

	public void setS_console(Console s_console) {
		this.s_console = s_console;
	}
    
    public ChessPiece getBoard(int i, int j) {
		return board.getPiece(i, j);
	}
    
    public ChessBoard getAllBoard(){
    	return board;
    }
    
}
