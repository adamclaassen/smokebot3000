package comm;

import java.util.ArrayList;

public class ErrorHandler {
	
	private ArrayList<Exception> errors;
	
	public ErrorHandler(){}
	
	public void addError(Exception e){
		this.errors.add(e);
	}
	
	public ArrayList<Exception> getErrors(){
		return this.errors;
	}
	
	protected void clearErrors(){
		this.errors.clear();
	}
	
}
