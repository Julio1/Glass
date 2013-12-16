
public class Caballo implements Animal {

	
	private String nombre;
	private	String tipo;
	
	
	public Caballo (String pnombre, String ptipo) {
	
		setTipo(ptipo);
		setNombre(pnombre);	
	} 
	

	public void setTipo(String pnombre) {
		nombre=pnombre;
		
	}
	
	public void setNombre(String ptipo) {
		tipo=ptipo;
		
	}
	

	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	
	   public String toString(){

	    	String result;
	    	
	    	result = "*****Informacion del Animal****** " +  "\n";
	    	result += "Nombre #: " + getNombre() +  "\n";
	    	result += "Tipo: " + getTipo() +  "\n";

	    return result;

	    }
	
}
