package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	// classe partida de xadrez, aqui esterá as regras do jogo

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); // dimensão do tabuleiro
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		// retorna uma matriz de peça de xadrez correspondente a partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat; // retorna a matriz de peça da partida de xadrez
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece =board.removePiece(target);
		board.placePice(p, target);
		return capturedPiece;
	}
	
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPice(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) { //testa se tem algum movimento possivel
			throw new ChessException("The is no possible moves fo the chose piece");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePice(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		// inicia a partida de xadrez, colocando as peças no tabuleiro

		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));

	}

}
