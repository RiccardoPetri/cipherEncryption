package it.unipv.so.cifrario.codifica;
import java.util.Scanner;

//A – B – C – D – E – F – G – H – I – J – K – L – M – N – O – P – Q – R – S – T – U – V – W – X – Y – Z
//D – E – F – G – H – I – J – K – L – M – N – O – P – Q – R – S – T – U – V – W – X – Y – Z - A – B – C

public class Cifratura {

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		String str = "";
//		str = scan.nextLine();
//		
		String text = "Onde che si comportano come particelle, particelle che oltrepassano le barriere come fantasmi o che comunicano tra loro in modo come telepatico."
				+ "È questo lo strano mondo che gli scienziati si sono trovati di fronte quando hanno scoperto la meccanica quantistica."
				+ "Una delle caratteristiche principali di questa teoria è la quantizzazione, cioè il fatto che, nel mondo microscopico, le quantità fisiche come l’energia non possono essere scambiate in modo continuo, come un flusso d’acqua del rubinetto che si può dosare a piacere, ma attraverso pacchetti detti quanti, come acqua contenuta in bicchieri o bottiglie dal volume prefissato."
				+ "Il Signor Schrödinger, altro pioniere della meccanica quantistica e premio Nobel, è lui che ha ideato e promosso l’esempio del gatto vivo e morto allo stesso tempo, ha coniato il termine entanglement, ovvero interlacciamento, per descrivere un particolare collegamento tra sistemi quantistici."
				+ "Quando due sistemi entrano in interazione fisica temporanea a causa di nota forza tra loro, e quando dopo un tempo di influenza reciproca dei sistemi questi vengono nuovamente separati, non possono più essere descritti nello stesso modo di prima."
				+ "Dall’interazione i due sistemi sono diventati aggrovigliati, interlacciati."
				+ "L’entanglement si manifesta quindi come una correlazione in qualche modo sconcertante  tra le parti che una volta entrate in contatto, mantengono il loro contatto anche se lontane per miglia."
				+ "Il sentimento più vicino che mi viene in mente è quello di amare."
				+ "Pensate ad una madre e a suo figlio, o a due amanti che hanno condiviso un’emozione intensa e che vivono ai lati opposti del mondo."
				+ "Si sentono l’un l’altro, percepiscono la felicità o la tristezza del partner lontano, e sono influenzati da questo profondo legame."
				+ "Nella nostra metafora, nessuno dei due amanti è completo da solo, ma solo nel loro insieme, si completano a vicenda."
				+ "Essi sono metà non separabili della medesima entità del tutto interlacciata.";
		
		/* I due caratteri . e \ sono speciali, per utilizzarli come parametri passati a split()
		 * andrà anteposto ?<= serve per inserire il carattere . come ultimo carattere nella prima stringa 
		 */		
		String[] parts = text.split("(?<=\\.)");
		
		int n = parts.length;
		StringaDaCodificare[] testo = new StringaDaCodificare[n];
		Thread[] thread = new Thread[n];

		// per ogni porzione di frase delimitata da un . viene creata un oggetto StringaDaCodificare
		for (int i = 0; i < n; i++) {
			StringaDaCodificare r = new StringaDaCodificare(parts[i]);
			testo[i] = new StringaDaCodificare(parts[i]);
		}

		// ad ogni stringa corrisponderà un thread
		for (int i = 0; i < n; i++) {
			thread[i] = new Thread(testo[i]);
		}

		for (int i = 0; i < n; i++) {
			thread[i].start(); // start() permetterà l'avvio del metodo run() di ogni thread
		}

		for (int i = 0; i < n; i++) {

				try {
					thread[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}

		System.out.println("\nTESTO CRIPTATO: ");
		for (int i = 0; i < n; i++) {
			testo[i].stampaTesto();
		}
		
		System.out.println("\nTESTO CRIPTATO SU UNA RIGA: ");
		
		for (int i = 0; i < n; i++) {
			testo[i].stampaSuRiga();
		}
	}
}
