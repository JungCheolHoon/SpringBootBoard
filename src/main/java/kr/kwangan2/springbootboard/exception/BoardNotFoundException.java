package kr.kwangan2.springbootboard.exception;

public class BoardNotFoundException extends BoardException{

	private static final long serialVersionUID = 113452435214L;

	public BoardNotFoundException(String message) {
		super(message);
	}
	
}
