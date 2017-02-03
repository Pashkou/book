package customexceptions;

public class InvalidOperationException extends RuntimeException {
		
	private static final long serialVersionUID = 454292503375329854L;
	private String message;
	
	public InvalidOperationException(String message){
		this.message = message;
	}
	
}
