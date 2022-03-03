package it.unipv.so.cifrario.decodifica;

public class StringaDaDecodificare implements Runnable {

	private String string;
	private String decrypted;

	public StringaDaDecodificare(String string) {
		this.string = string;
	}

	@Override
	public void run() {		//algoritmo di decifratura
		String c = "";
		for (int i = 0; i < string.length(); i++) {
			int n = (int) string.charAt(i) - 3;
			if (n < 97) {
				if (n > 93) {
					n += 26;
				}
			}
			c += (char) n;
		}
		c = c.replace('æ', ' ');
		decrypted = c;
	} 

	public void stampaTestoDecodificato() {
		for (int i = 0; i < 1; i++) {
			System.out.println(decrypted);	
	//con println ad ogni ciclo si avrà l'andata a capo
		}
	}
}
