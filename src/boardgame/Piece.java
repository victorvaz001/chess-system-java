package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() { /* Somente classes dentro do mesmo pacote e subclasses vão poder acessar o tabuleiro */
		return board;
	}	
}
