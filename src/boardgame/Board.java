package boardgame;

public class Board {

	// classe tabuleiro

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		//retorna a peça pela posição
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePice(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

}
