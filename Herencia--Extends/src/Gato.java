
/**
 * @(#)Ubicacion.java
 *
 *
 * @author Julio C. Moreira
 * @version 1.00 2012/9/3
 */



public class Gato extends Animal {

        String color ;



	public Gato(String pnombre, String pcolor){
		super("Gato");
                setColor(pcolor);
                }

    public  void  setColor(String pcolor) {color=pcolor;}


    public  String getColor () {return color;  }
    
    public String emitirSonido (){
    		
    	String sonido="Miau Miau!";
    		
    		
    		return sonido;
    }


    public String toString(){

    

        String result=super.toString();
      	result += "Color: " + getColor() +  "\n";
      	result += "El animal hace: " + emitirSonido() +"\n";

    	return result;

    }



}