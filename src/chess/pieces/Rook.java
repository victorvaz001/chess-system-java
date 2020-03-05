package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
	//classe torre

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	

}
