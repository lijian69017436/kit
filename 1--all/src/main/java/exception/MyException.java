package exception;

public class MyException extends Exception{
    private String message;
	public MyException(){}
	public MyException(String message){
		super(message);
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
