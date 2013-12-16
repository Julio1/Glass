
public class Tramo {
	
	
	private float x1;
	private float x2;
	private float y1;
	private float y2;
	private float anchoTramo;
	private float material;
	private float difNivel;
	private String tipoMaterial;
	private int precioTramo;
	private int id;
	static float costoTotalCarretera=0;
	static float longTotalCarretera=0;
	static float tramoCorto;
	static float tramoLargo;
	static int cantTramo=0;
	static int idTramoCorto=0;
	static int idtramoLargo=0;

public Tramo (float px1,float px2,float py1, float py2, float panchotramo, float pdifNivel, float pmaterial ){
	
	setX1(px1);
	setX2(px2);
	setY1(py1);
	setY2(py2);
	setAnchoTramo(panchotramo);
	setDifNivel(pdifNivel);
	setMaterial(pmaterial);
	setId();
	

}


public Tramo ( ){
	
	this(1,1,1,1,1,1,1);
}

public Tramo (float pmaterial ){
	
	this(1,1,1,1,1,1,pmaterial);
}


public void setId(){
	cantTramo++;
	id=cantTramo;
}


public int getId(){return id;}


public void setX1(float px1) {x1=px1;}

public void setY1(float py1) {y1=py1;}

public void setX2(float px2) {x2=px2;}

public void setY2(float py2) {y2=py2;}



public void setMaterial(float pmaterial) {
			
	material=pmaterial; 
	
	if (material==3.0) {
		tipoMaterial="Material Selecto";
		precioTramo=4000;
	} 
	
	    if (material==2.0){ 
			 tipoMaterial="Asfalto";
			 precioTramo=17000;
		}
		 	if(material==1.0){
			   tipoMaterial="Adoquin";
			   precioTramo=6000;
			}
	
	
}

public void setDifNivel(float pdifNivel) { difNivel=pdifNivel; }
public void setAnchoTramo(float panchotramo) { anchoTramo=panchotramo;}
public float getX1 () { return x1;}
public float getX2 (){ return x2;}
public float getY1 (){ return y1;}
public float getY2 (){ return y2;}

public float getMaterial() { return	material; }
public float getDifNivel() { return difNivel; }
public float getAnchoTramo() { return anchoTramo;}
public String getTipoMaterial(){return tipoMaterial;}
public int    getPrecioTramo() {return precioTramo;}

//////////////////////////////////////////////////////////////


public  float calcularLongitud (){
	
	double longi;
	float longitud;
	longi=(Math.sqrt(Math.pow ((x2-x1),2)+ Math.pow ((y2-y1),2)) )*1000;
	longitud=Double.valueOf (longi).floatValue();

	return longitud;
}


public float  calcularInclinacion(){
	float relacInclinacion;
		relacInclinacion=getDifNivel()/calcularLongitud ();
	
	return relacInclinacion;
}
	



public boolean procesar(){
	boolean Procesar;

		if (calcularInclinacion()>=0  & calcularInclinacion()<=30) {
			Procesar=true;
		}else{                                               
			Procesar=false;
		}
	
	return Procesar;
}


public String clasificarRelacInc(){
	
	String clasificacion = "";
	
	
	if (procesar()==true) {
		
		if (calcularInclinacion()<5) {
			clasificacion="Suave";
		}		
			if (calcularInclinacion()>=20) {
				clasificacion="Moderada";		
			}
				if (calcularInclinacion()<=30 & calcularLongitud ()<=1000  ) {
					clasificacion="Levemente Fuerte";
				}
				
	}
	return clasificacion;
}


public float calcularArea(){ 
	
	float area;
	area=calcularLongitud ()*getAnchoTramo();

	return area;
}

public float calcularCostoTramo(){
	
	float costoTramo;
		
	costoTramo=calcularArea()*precioTramo;	
	
	
	return costoTramo;
}




//////////////////////////////////////////////////////////////
	
 public String toString(){
	 
	 String  resul=" \n";
	resul+="*********************************************\n";
	resul+="Tramo: "+getId()+" \n";
	resul+="-Longitud: "+ calcularLongitud ()+" \n";
	resul+="-tipo material: "+ getTipoMaterial() +" \n";
	resul+="-clasificacion: "+  clasificarRelacInc() +" \n";
	resul+="*precio tramo: "+ calcularCostoTramo() +" \n";
	resul+="*********************************************\n";
	return resul;
}
	
}
