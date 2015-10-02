import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class StreamBytes {

	public StreamBytes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copiaBytes();
	}
	
	public void abrirFichero(){
		
	}
	
	public static void copiaBytes(){
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try {
			fi = new FileInputStream("lena.jpg");
			fo = new FileOutputStream("lena1Copia.jpg");
			
			byte [] buffer = new byte[1024*1024];
			int cadena;
			
			while ((cadena = fi.read(buffer)) > 0) {
				fo.write(buffer, 0, cadena);
				cadena++;
			}
			System.out.println("Se han copiado: "+cadena+" bytes.");
		}
		catch (FileNotFoundException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println("Error al encontrar los ficheros.");
		}
		catch (IOException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println("Error al realizar la lectura y la escritura.");
		}
		finally{
			try {
				fi.close();
				fo.close();
			}
			catch (IOException error) {
				// TODO Auto-generated catch block
				error.printStackTrace();
				System.err.println("Error al cerrar los Streams.");
			}
		}		
		
	}

}
