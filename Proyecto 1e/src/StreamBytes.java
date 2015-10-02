import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class StreamBytes {
	
	//CREACIÓN DE ATRIBUTOS DE LA CLASE E INICIALIZADOS A NULL
	private static FileInputStream fi=null;
	private static FileOutputStream fo=null;
	
	public StreamBytes() {
		// TODO Auto-generated constructor stub
		//CONSTRUCTOR DE LA CLASE
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJECUCION DE METODOS EN MAIN
		
		//SI abrirFichero==true SE EJECUTARÁ EL MÉTODO copiaBytes
		if(abrirFichero("lena.jpg","copiaLena.jpg")){
			copiaBytes();
			System.out.println("Fichero binario copiado correctamente.");
		}
	}
	
	/*Funcionalidad de "abrirFichero": Este método recibe dos parámetros que son el nombre del fichero origen y el nombre del fichero destino.
	  Se generan dos objetos File con los nombres recibidos por parámetro y a continuación se comprueba que el fichero origen del cual queremos leer existe, si este existe,
	  declaramos los atributos de la clase y retornamos TRUE, de lo contrario, retornamos FALSE.*/
	
	//Se capturan todas las excepciones con el encapsulado try/catch
	
	public static boolean abrirFichero(String nombreOrigen, String nombreDestino){
		
		File origen = new File(nombreOrigen);
		File destino = new File(nombreDestino);
		
		try{
			if(origen.exists()){
				//FileInputStream: Clase de Java para realizar lectura de bytes (Archivos binarios)
				//FileOutputStream: Clase de Java para realizar escritura de bytes (Archivos binarios)
				fi = new FileInputStream(origen);
				fo = new FileOutputStream(destino);
				return true;
			}
			else{
				System.err.println("No existe el fichero binario espicificado.");
			}
		}
		catch(SecurityException noExiste){
			noExiste.printStackTrace();
		}
		catch (FileNotFoundException noExiste) {
			noExiste.printStackTrace();
		}
		return false;
				
	}
	
	public static void copiaBytes(){
		
		byte[] buffer = new byte[1024*1024];
		int cadena;
		
		try {
			while ((cadena = fi.read(buffer)) > 0) {
				fo.write(buffer, 0, cadena);
			}
		}
		catch (IOException errorEscritura) {
			// TODO Auto-generated catch block
			errorEscritura.printStackTrace();
		}
		finally{
			try {
				fi.close();
				fo.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
