package boardgame;

public class Board {

	// classe tabuleiro

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		//cria um tabuleiro
		
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 coloumn");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		//retorna a peça pela posição
		if(!positionExists(position)) { // testa se posição existe
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePice(Piece piece, Position position) {
		//coloca uma peça na posição
		
		if(thereIsAPice(position)) {
			throw new BoardException("There is alread a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPice(Position position) {
		//testa se tem uma peça na position informada
		if(!positionExists(position)) { // testa se a posição existe
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	

}
