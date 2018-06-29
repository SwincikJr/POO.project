package POO.project;

import java.io.*;
import java.lang.Math;

public class Encrypt {
	public static void main(String args[]) {
		//User needs write directory of file to encrypt and directory/name of encrypted file as arguments on prompt
		if(args.length < 2) throw new RuntimeException("Argumento não inserido ou insuficiente.");
		try { 
			//Open the file indicated as argument on prompt
			DataInputStream doc = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
			//Creates a new file that will have encrypted content
			DataOutputStream out = new DataOutputStream(new FileOutputStream(args[1]));
			Fila f = new Fila(8); //The queue will be used to invert the bits
			int b;
			while(doc.available() > 0) { //Reads byte by byte the file while is available
				b = doc.read(); //b is the next byte of file
				while(b > 0) { //Puts the bits readed on queue
					f.enfileira(b%2);
					b = b/2;
				}
				while(!f.cheiaf()) f.enfileira(0); //Complete the queue with 0's;
				int exp;
				for(exp = 7; exp >= 0; exp--) { //Invert bits
					b = (int) (b + f.desenfileira()*Math.pow(2, exp));
				}
				out.write(b); //Write inverted byte on encrypted file
			}
			doc.close(); //Closes files to free the resources
			out.close();
		} catch(IOException exc) { //Print in any IO error
			System.out.println("Erro de IO.");
			exc.printStackTrace();
		}
	}
}


