

import java.io.*;
import java.util.ArrayList;


public class IUCarretera{
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;
 
    
    public static int cantTramos = 0;
    public static ArrayList<Tramo> lista= new ArrayList<Tramo>();
    public static Tramo unTramo;
    public static Tramo otroTramo;
    public static boolean  primero=true;
   
    
    
   	
	public static void main(String [] args) throws java.io.IOException{
		

	    
		
		boolean noSalir=true;
		int opc;

		out.println("Aplicacion Carretera  \n");

		do{
			mostrarMenu();
			opc=leerOpcion();
			noSalir=ejecutarAccion(opc);

		}while(noSalir);
	}

        private static void mostrarMenu(){
        	
        	out.println("*****************************");
        	out.println("     MENU DE LA CARRETERA     ");
        	out.println("*****************************");
        	
			out.println("1. Agregar Tramo");
			out.println("2. Ver estado de la carretera");
			out.println("3. Salir");
	
			
			out.println();
	}


	private static int leerOpcion()throws java.io.IOException{
		int opcion;
		out.print("Seleccione su opcion: ");
		opcion=Integer.parseInt(in.readLine());
		out.println();
		return opcion;
	}
	

	private static boolean ejecutarAccion(int opcion)throws java.io.IOException{
		
		
		boolean noSalir = true;
		float  x1,x2,y1,y2;
		float difNivel;
		float anchoTramo;
				
		switch(opcion){
			case 1:
				
				if (primero==true) {
					
				
				 
				unTramo= new Tramo();				
				
			
				out.print(" Digite las coordenadas iniciales:\nx1: ");
				x1 = Float.parseFloat(in.readLine());
				unTramo.setX1(x1);
						
				out.print("y1: ");
				y1 = Float.parseFloat(in.readLine());
				unTramo.setY1(y1);
				
				out.print("\nDigite las coordenadas finales:\nx2: ");
				x2 = Float.parseFloat(in.readLine());
				unTramo.setX2(x2);
				
				out.print("y2: ");
				y2 = Float.parseFloat(in.readLine());
				unTramo.setY2(y2);
				
			
									
				if(mostrarMateriales()==true){
				
					out.print("\n");
				return noSalir;
				
				}
				
				
				out.print("Ingrese diferencia de nivel \n");
				difNivel = Float.parseFloat(in.readLine());
				unTramo.setDifNivel(difNivel);
				
				
				 if(unTramo.procesar()==false){
					
				out.print("\n");
				return noSalir;
				
				}		
				
				
				out.print("Ingrese ancho de tramo \n");
				anchoTramo = Float.parseFloat(in.readLine());
				unTramo.setAnchoTramo(anchoTramo);
				
				primero=false;
				lista.add(unTramo); //agregamos tramo a la lista
				
				}else{
				
					
			
				
				unTramo= new Tramo();
				
			
				
				unTramo.setX1(unTramo.getX2());
						
				unTramo.setY1(unTramo.getY2());
				
				out.print("\nDigite las coordenadas finales:\nx2: ");
				x2 = Integer.parseInt(in.readLine());
				unTramo.setX2(x2);
				
				out.print("y2: ");
				y2 = Integer.parseInt(in.readLine());
				unTramo.setY2(y2);
				
				
				if(mostrarMateriales()==true){
			
				out.print("\n");
				return noSalir;
			
				}
				
				out.print("Ingrese diferencia de nivel \n");
				difNivel = Float.parseFloat(in.readLine());
				unTramo.setDifNivel(difNivel);
				
				
				 if(unTramo.procesar()==false){
					
				out.print("\n");
				return noSalir;
				
				}		
				
				
				out.print("Ingrese ancho de tramo \n");
				anchoTramo = Float.parseFloat(in.readLine());
				unTramo.setAnchoTramo(anchoTramo);
				
				unTramo.setMaterial(unTramo.getMaterial());
				lista.add(unTramo);
							
					
				}
				break;
				
							
			case 2:
				
			
				out.println(lista.toString());
				
				float tramoMayor=0;
				int idTramoMayor=0;
				float tramoMenor=0;
				int idTramoMenor=0;
				float TotalCarretera=0;
				float TotalCosto=0;
				
				for(int i=0;i<lista.size();i++){
					
					Tramo tramoRevisado;	
					
					tramoRevisado = (Tramo)lista.get(i); //
									
					if(tramoRevisado.calcularLongitud()>tramoMayor){//
					   tramoMayor= tramoRevisado.calcularLongitud();
					   idTramoMayor=tramoRevisado.getId();
					}
				
					
				 if(tramoMenor < tramoRevisado.calcularLongitud() || 0 > tramoRevisado.calcularLongitud() ){
						
						idTramoMenor=tramoRevisado.getId();
						tramoMenor= tramoRevisado.calcularLongitud();	
						
					}
					
					TotalCarretera=TotalCarretera + tramoRevisado.calcularLongitud();
					TotalCosto=TotalCosto + tramoRevisado.calcularCostoTramo();	
				
								
					
				}
								
				
				out.println("El tramo numero "+idTramoMayor + "  es el mayor con "+ tramoMayor + "KM");
				out.println("El tramo menor es "+ idTramoMenor + "  es el menor con "+ tramoMenor + "KM");
				out.println("El costo total es "+ TotalCarretera+ " ");
				out.println("La longitud total de la carretera  es "+ TotalCosto + "KM");
			
				break;
				
			case 3:
				noSalir = false;
				out.println("Gracias");
				break;
				
						
			default:
				out.println("Opcion invalida");
				
				break;
		}

		out.println();
		return noSalir;
	}

	public static boolean mostrarMateriales() throws IOException{
	boolean invalido=false;	
	
	out.print("  \n");
	out.println("Escoja el material del tramo\n");
	
	
	out.println("Valor #1.  Material Adoquin\n");
	out.println("Valor #2.  Material Asfalto\n");
	out.println("Valor #3.  Material Selecto\n");
	
	
	int opcion2 = leerOpcion();{
		
		
						switch(opcion2){
								
							case 1:
								
								
								unTramo.setMaterial(opcion2);
								out.println("Se construira con Adoquin\n");
								break;
							
							case 2:
								
								unTramo.setMaterial(opcion2);
								out.println("Se construira con Asfalto\n");
								break;
							
							case 3:
								
								unTramo.setMaterial(opcion2);
								out.println("Se construira con Material Selecto\n");
								break;
								
							
														
							default:
								
								invalido=true;
								out.println("Opcion invalida, el tramo no sera procesado");
							
	
						 }
		}
		return invalido;
		
	}

}
