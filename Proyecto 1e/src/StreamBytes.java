import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class StreamBytes {
	
	private static FileInputStream fi=null;
	private static FileOutputStream fo=null;
	
	public StreamBytes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(abrirFichero("lena.jpg","copiaLena.jpg")){
			copiaBytes();
			System.out.println("Fichero binario copiado correctamente.");
		}
	}
	
	public static boolean abrirFichero(String nombreOrigen, String nombreDestino){
		
		File origen = new File(nombreOrigen);
		File destino = new File(nombreDestino);
		
		try{
			if(origen.exists()){
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
