
/**
 * @(#)Ubicacion.java
 *
 *
 * @author Julio C. Moreira
 * @version 1.00 2012/9/3
 */

public class Perro extends Animal {

        String color ;



	public Perro (String pnombre, String pcolor){
		super("Pastor alemán");
                setColor(pcolor);
                }

    public  void  setColor(String pcolor) {color=pcolor;}



    public  String getColor () {return color;  }
    
    public String emitirSonido (){
		
    	String sonido="Rof Rof!";
    		
    		
    		return sonido;
    }

    


    public String toString(){

    	

        String result=super.toString();
      	result += "Color: " + getColor() +  "\n";

    	return result;

    }



}