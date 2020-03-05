package chess;

import boardgame.Board;

public class ChessMatch {
	//classe partida de xadrez, aqui esterá as regras do jogo
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8); // dimensão do tabuleiro
	}
	
	public ChessPiece[][] getPieces(){
		//retorna uma matriz de peça de xadrez correspondente a partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);
			}
		}
		return mat; //retorna a matriz de peça da partida de xadrez
	}
	

}
