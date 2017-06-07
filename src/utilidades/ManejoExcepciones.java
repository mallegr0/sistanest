package utilidades;

public class ManejoExcepciones extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ManejoExcepciones(){
		super();
	}
	
	public ManejoExcepciones(String message){
		super(message);
	}
	
	
	public ManejoExcepciones(String message, Throwable cause){
		super(message,cause);
		//SuperLogger.logger.log(Level.ERROR, message, cause);
		
	}

}