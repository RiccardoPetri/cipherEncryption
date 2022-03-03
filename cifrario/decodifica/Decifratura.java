package it.unipv.so.cifrario.decodifica;

import java.util.Scanner;

import it.unipv.so.cifrario.codifica.StringaDaCodificare;

//A – B – C – D – E – F – G – H – I – J – K – L – M – N – O – P – Q – R – S – T – U – V – W – X – Y – Z
//D – E – F – G – H – I – J – K – L – M – N – O – P – Q – R – S – T – U – V – W – X – Y – Z - A – B – C

public class Decifratura {
	
	public static void main(String[] args) {
		
		System.out.println("INSERIRE IL TESTO CRIPTATO");
		Scanner scan = new Scanner(System.in);
		String str = "";
		str = scan.nextLine();

		//l'1 corrispende al . ovvero il parametro per splittare la stringa
		String[] parts = str.split("(?<=1)");
		int n=parts.length;
		StringaDaDecodificare[] testo=new StringaDaDecodificare[n];
		Thread[] thread=new Thread[n]; //
		
		//per ogni porzione di frase delimitata da . 
		//viene creata una StringaCodificata.
		for(int i=0;i<n;i++) {
			StringaDaDecodificare r=new StringaDaDecodificare(parts[i]);
			testo[i]=r;
		}	
		// ad ogni stringa corrisponderà un thread
		for(int i=0;i<n;i++) {
			thread[i]=new Thread(testo[i]);
		}

		for(int i=0;i<n;i++) {
			thread[i].start();
		}
		
		for(int i=0;i<n;i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.getMessage();
			}		
		}
		
		System.out.println("\nTESTO DECRIPTATO: ");		
		for(int i=0;i<n;i++) {
			testo[i].stampaTestoDecodificato();
		}
	}
}



