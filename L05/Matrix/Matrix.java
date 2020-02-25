import java.util.*;

public class Matrix {
	
	private int[][] mat;
	private int lines;
	private int collumns;
	
	public Matrix(int l, int c) {
		this.lines = l;
		this.collumns = c;
		mat = new int[l][c];
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < c; j++) {
				mat[i][j] = 0;
			}
		}
	}
	
	public Matrix() {
		Scanner in = new Scanner(System.in);
		System.out.print("Input the number of lines: ");
		this.lines = in.nextInt();
		System.out.println("Input the number of collumns: ");
		this.collumns = in.nextInt();
		mat = new int[this.lines][this.collumns];
		
		for(int i = 0; i < this.lines; i++) {
			for(int j = 0; j < this.collumns; j++) {
				System.out.println("[" + i + "][" + j + "] = ");
				this.mat[i][j] = in.nextInt();
			}
		}
	//	in.close();                 //I can't figure out how to use multiple scanners without never closing them
	}
	
	public Matrix add(Matrix x){
		
		if(x.getLines() != this.lines || x.getCollumn() != this.collumns) {
			System.out.println("can not add 2 matrix of different dimensions");
			return null;
		}
		
		Matrix a = new Matrix(this.lines, this.collumns);
		
		for(int i = 0; i < this.lines; i++) {
			for(int j = 0; j < this.collumns; j++) {
				int val = x.getValue(i, j) + this.mat[i][j];
				a.setValue(i, j, val);
			}
		}
		return a;
	}
	
	public Matrix substract(Matrix x){
		
		if(x.getLines() != this.lines || x.getCollumn() != this.collumns) {
			System.out.println("can not substract 2 matrix of different dimensions");
			return null;
		}
		
		Matrix s = new Matrix(this.lines, this.collumns);
		
		for(int i = 0; i < this.lines; i++) {
			for(int j = 0; j < this.collumns; j++) {
				int val = this.mat[i][j] - x.getValue(i, j);
				s.setValue(i, j, val);
			}
		}
		
		return s;
	}
	
	public Matrix divide(int value){
		Matrix d = new Matrix(this.lines, this.collumns);
		
		for(int i = 0; i < this.lines; i++) {
			for(int j = 0; j < this.collumns; j++) {
				int val = this.mat[i][j]/value;
				d.setValue(i, j, val);
			}
		}
		
		return d;
	}
	
	public Matrix multiply(Matrix x){
		
		if(this.lines != x.getCollumn() || this.collumns != x.getLines()) {
			System.out.println("the dimensions of the 2 matrices are not compatible!");
			return null;
		}
		
		Matrix m = new Matrix(this.lines, x.getCollumn());
		
		for(int i = 0; i < this.lines; i++) {
			for(int k = 0; k < x.getCollumn(); k++) {
				int value = 0;
				for(int j = 0; j < x.getLines(); j++) {
					value += this.mat[i][j] * x.getValue(j, k);
				}
			m.setValue(i, k, value);
			}
		}
		
		return m;
	}
	
	public int getValue(int i, int j) {
		return this.mat[i][j];
	}
	
	public int getLines() {
		return this.lines;
	}
	
	public int getCollumn() {
		return this.collumns;
	}
	
	public void printMat() {
		for(int i = 0; i < this.lines; i++) {
			for(int j = 0; j < this.collumns; j++) {
				System.out.print(this.mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void setValue(int i, int j, int val) {
		this.mat[i][j] = val;
	}
	
	public void start() {

		Scanner keyboard = new Scanner (System.in);
		boolean cont = true;
		
		while(cont) {
			System.out.println("Input the operation you want to performe: ");
			System.out.println("1. Matrix addition");
			System.out.println("2. Matrix substraction");
			System.out.println("3. Matrix division by value");
			System.out.println("4. Matrix multiplication");
			int i = keyboard.nextInt();
			switch(i) {
			case 1 :
				System.out.println("Construct the matrix you want to add: ");
				Matrix B = new Matrix();
				Matrix C = this.add(B);
				System.out.println("the result matrix of the add operation is:");
				this.printMat();
				System.out.print("+\n");
				B.printMat();
				System.out.print("=\n");
				C.printMat();
				break;
			case 2:
				System.out.println("Construct the matrix you want to substract: ");
				Matrix D = new Matrix();
				Matrix E = this.substract(D);
				System.out.println("the result matrix of the substract operation is:");
				this.printMat();
				System.out.print("-\n");
				D.printMat();
				System.out.print("=\n");
				E.printMat();
				break;
			case 3:
				System.out.println("Input the value you want to divide: ");
				int x = keyboard.nextInt();
				Matrix F = this.divide(x);
				System.out.println("the result matrix of the division is:");
				this.printMat();
				System.out.print("/ " + x + "=\n");
				F.printMat();
				break;
			case 4:
				System.out.println("Construct the matrix you want to multiply: ");
				Matrix G = new Matrix();
				Matrix H = this.multiply(G);
				System.out.println("the result matrix of the multiplication operation is:");
				this.printMat();
				System.out.print("*\n");
				G.printMat();
				System.out.print("=\n");
				H.printMat();
				break;
			default:
				System.out.println("input a valid index!");
				break;		
			}
			System.out.println("continue the operations on the matrix A?\n1.yes\n2.no");
			int j = keyboard.nextInt();
			if(j == 2)
				cont = false;
		}
		keyboard.close();
	}

	public static void main(String[] args) {
		System.out.println("Construct your matrix ");
		Matrix A = new Matrix();
		A.start();
	}

}
