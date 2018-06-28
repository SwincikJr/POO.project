package POO.project;

import java.io.*;

public class Encrypt {
	public static void main(String args[]) {
		//User needs write directory of file as argument on prompt
		if(args.length == 0) throw new RuntimeException("Argumento não inserido ou argumento inválido.");
		try { 
			//Open the file indicated as argument on prompt
			DataInputStream doc = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
			Fila f = new Fila(8); //The queue will be used to invert the bits
			int b;
			while(doc.available() > 0) { //Reads byte by byte the file while is available
				b = doc.read(); //b is the next byte of file
				System.out.printf("%d ", b); //Temporary command, just for test. Print the byte
				while(b > 0) { //Queue the bits readed
					f.enfileira(b%2);
					b = b/2;
				}
				while(!f.vaziaf()) { //Invert bits
					b = b*2 + f.desenfileira();
				}
				System.out.println(b); //Print inverted byte. Command for test
			}
			doc.close(); //Closes the file to free the resources
		} catch(IOException exc) { //Print in any IO error
			System.out.println("Erro de IO.");
			exc.printStackTrace();
		}
	}
}


