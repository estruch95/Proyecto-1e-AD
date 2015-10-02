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

	}
	
	public void abrirFichero(){
		
	}
	
	public void copiaBytes(){
		
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
		try {
			fi = new FileInputStream("entrada");
			fo = new FileOutputStream("salida");
			
			byte [] buffer = new byte[1024];
			fi.read(buffer);
			fo.write(buffer);
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			intentarCerrar(fi, fo);
		}
		
	}
	
	public void intentarCerrar(FileInputStream fi, FileOutputStream fo){
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
