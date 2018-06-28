package POO.project;

import java.io.*;

public class Encrypt {
	public static void main(String args[]) {
		//User needs write directory of file as argument on prompt
		if(args.length == 0) throw new RuntimeException("Argumento não inserido ou argumento inválido.");
		try { 
			//Open the file indicated as argument on prompt
			DataInputStream doc = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0]))); 
			while(doc.available() > 0) { //Reads byte by byte the file while is available
				System.out.println(doc.read()); //Temporary command, just for test;
			}
			doc.close(); //Closes the file to free the resources
		} catch(IOException exc) { //Print in any IO error
			System.out.println("Erro de IO.");
			exc.printStackTrace();
		}
	}
}


