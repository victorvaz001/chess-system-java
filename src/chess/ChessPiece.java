package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	/*Verifica se existe uma peça adversaria na 'position'*/
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position); //pegando a peça da posição
		return p != null && p.getColor() != color; // se a cor da peça da posição e a cor diferente da cor da minha peça
	}
}
