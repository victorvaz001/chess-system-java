package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() { /*
									 * Somente classes dentro do mesmo pacote e subclasses vão poder acessar o
									 * tabuleiro
									 */
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) { /* Hook methods -> gancho com a subclasse */
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	/*Implementação de um metodo concreto, que depende de um abstrato*/
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
