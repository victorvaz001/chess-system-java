package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		
		if(column < 'a' || column > 'h' || row < 1 || row > 8 ) {
			throw new ChessException("Error instantitiag ChessPosition. Valid avalues are afrom a1 to h8");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');  //achando as posiçoes do xadrez
	}
	
	protected static ChessPosition fromPosition(Position position) {
		//convertendo para uma posição do xadrez/ obs: falar coluna depois a linha no xadrez
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return " " + column + row; //imprimi a1, a2, a3 ....
	}
	
	
	
}
