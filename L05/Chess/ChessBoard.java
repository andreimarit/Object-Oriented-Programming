import java.awt.Color; 
import java.util.*;


import java.awt.Font;
import enigma.console.*; 
import enigma.core.Enigma;
import enigma.console.java2d.Java2DTextWindow;
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    public static final int ROW_MIN = 0;
    public static final int ROW_MAX = 7;
    public static final int COL_MIN = 0;
    public static final int COL_MAX = 7;
    TextAttributes attrs;
    public static final TextAttributes whiteOnBlack = new TextAttributes(Color.WHITE, Color.BLACK);
    private static final Console s_console; //Declare the Console
    static
    {
        s_console = Enigma.getConsole("Chess Game"); //Sets the console to the Enigma console, named "Hellow World!"
        if (s_console.isTextWindowAvailable())
        {
            Java2DTextWindow txtW = (Java2DTextWindow) s_console.getTextWindow();
            txtW.setFont(new Font("Courier new", Font.PLAIN, 60));
        }
    } 
    // instance variables - replace the example below with your own
    private ChessPiece[][] board;

    /**
     * Constructor for objects of class ChessBoard
     */
    public ChessBoard()
    {
        // initialise instance variables
        board = new ChessPiece[ROW_MAX+1][COL_MAX+1];
        setBoard();
        printBoard();
    }
    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            s_console.setTextAttributes(whiteOnBlack);
            System.out.print(new Integer(8-i).toString());
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] != null) 
                    board[i][j].print(attrs, 
                    (((i + j) % 2 == 0)? Color.LIGHT_GRAY: Color.DARK_GRAY) );
                else
                {
                        attrs= new TextAttributes(
                        ((i + j) % 2 == 0)? Color.LIGHT_GRAY: Color.DARK_GRAY,
                        ((i + j) % 2 == 0)? Color.LIGHT_GRAY: Color.DARK_GRAY);
                        s_console.setTextAttributes(attrs); //Sets the colors to the console
                        System.out.print(" "); //Default system println
                }
            }
            System.out.println();
        }
        s_console.setTextAttributes(whiteOnBlack);
        System.out.println(" abcdefgh");
    }
    public static void main(String[] args)
    {
    	ChessBoard cb = new ChessBoard();
        Scanner in = new Scanner(System.in);
        int prevRow;
        char prevCol;
        int row;
        char col;
        int turn = 0;
        
        System.out.println("input the coordinates of the piece you want to move, and the coordinates where you want to move it (ex: 1 a 2 a): ");
        
        while(!cb.kingDies()) {
        	if(turn % 2 == 0) {
        		System.out.print("white's turn:");
        	}
        	else {
        		System.out.print("black's turn:");
        	}
        	prevRow = in.nextInt();
            prevCol = in.next().charAt(0);
            row = in.nextInt();
            col = in.next().charAt(0);

            if(cb.checkTurn(retRow(prevRow), retCol(prevCol), turn)) {
            	 boolean ok = cb.board[retRow(prevRow)][retCol(prevCol)].move(retRow(row), retCol(col));
                // System.out.println(""+ok);
                 if(ok) {
                 	cb.printBoard();
                 	turn++;
                 }
                 else {
                	System.out.println("\tyou can not move this piece in that place");
                 }
            }
            else {
            	System.out.println("\tyou can not move this piece");
            }
           
        }
        in.close();
    }
    
    /**
     * setBoard places initially pieces on board
     * 
     */
    private void setBoard()
    {
        // set whites
        board[7][0] = new Rook(s_console, 7, 0, 'R', Color.white, this); // rook
        board[7][1] = new Knight(s_console, 7, 1, 'N', Color.white, this); // knight
        board[7][2] = new Bishop(s_console, 7, 2, 'B', Color.white, this); // bishop
        board[7][3] = new Queen(s_console, 7, 3, 'Q', Color.white, this); // queen
        board[7][4] = new King(s_console, 7, 4, 'K', Color.white, this); // king
        board[7][5] = new Bishop(s_console, 7, 5, 'B', Color.white, this); 
        board[7][6] = new Knight(s_console, 7, 6, 'N', Color.white, this); 
        board[7][7] = new Rook(s_console, 7, 7, 'R', Color.white, this);
        for (int j = 0; j < board[6].length; j++)
            board[6][j] = new Pawn(s_console, 6, j, 'P', Color.white, this); //pawn
        // set blacks
        for (int j = 0; j < board[6].length; j++)
            board[1][j] = new Pawn(s_console, 1, j, 'P', Color.black, this);
        board[0][0] = new Rook(s_console, 0, 0, 'R', Color.black, this); 
        board[0][1] = new Knight(s_console, 0, 1, 'N', Color.black, this); 
        board[0][2] = new Bishop(s_console, 0, 2, 'B', Color.black, this); 
        board[0][3] = new Queen(s_console, 0, 3, 'Q', Color.black, this);         
        board[0][4] = new King(s_console, 0, 4, 'K', Color.black, this);
        board[0][5] = new Bishop(s_console, 0, 5, 'B', Color.black, this); 
        board[0][6] = new Knight(s_console, 0, 6, 'N', Color.black, this); 
        board[0][7] = new Rook(s_console, 0, 7, 'R', Color.black, this);    
    }
    
    public void setBoardEntry(ChessPiece piece, int i, int j) {
    	board[i][j] = piece;
    }
    
    public  ChessBoard getBoard() {
    	return this;
    }
    
    public ChessPiece getPiece(int i, int j) {
    	return this.board[i][j];
    }
    
    static public int retCol(char c) {
    	int col;
    	
    	switch(c) {
    	case 'a': 
    		col = 0;
    		break;
    	case 'b':
    		col = 1;
    		break;
    	case 'c':
    		col = 2;
    		break;
    	case 'd':
    		col = 3;
    		break;
    	case 'e': 
    		col = 4;
    		break;
    	case 'f':
    		col = 5;
    		break;
    	case 'g':
    		col = 6;
    		break;
    	case 'h':
    		col = 7;
    		break;
    	default:
    		col = COL_MAX + 1;
    		break;
    	}
    	return col;
    }
    
    static public int retRow(int r) {
    	return 8 - r;
    }
    
     public boolean kingDies() {
    	int cnt = 0;
    	Color c = Color.blue;
    	for(int i = ROW_MIN; i <= ROW_MAX; i++ ) {
    		for(int j = COL_MIN; j <= COL_MAX; j++) {
    			if(this.board[i][j] != null && this.board[i][j].getSymbol() == 'K') {
    				cnt++;
    				c = this.board[i][j].getColor();
    			}
    		}
    	}
    	
    	if(cnt == 2) {
    		return false;
    	}
    	else {
    		if(c.equals(Color.white)) {
    			System.out.println("\t!!!WHITE WINS!!!");
    		}
    		else {
    			System.out.println("\t!!!BLACK WINS!!!");
    		}
    		return true;
    	}
    	
    }
     
     public boolean checkTurn(int i, int j, int turn) {
    	 if(this.board[i][j] != null) {
    		 if(turn % 2 == 0) {
    			 if(this.board[i][j].getColor().equals(Color.WHITE)) {
    				 return true;
    			 }
    			 else {
    				 return false;
    			 }
    		 }
    		 else {
    			 if(this.board[i][j].getColor().equals(Color.BLACK)) {
    				 return true;
    			 }
    			 else {
    				 return false;
    			 }
    		 }
    	 }
    	 return false;
     }
}
    
