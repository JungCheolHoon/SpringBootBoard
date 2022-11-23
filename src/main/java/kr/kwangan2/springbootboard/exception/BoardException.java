package kr.kwangan2.springbootboard.exception;

public class BoardException extends RuntimeException{

	private static final long serialVersionUID = 31454625476345L;
	
	public BoardException(String message) {
		super(message);
	}
	
}
