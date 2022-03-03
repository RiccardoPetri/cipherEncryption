package it.unipv.so.cifrario.codifica;

public class StringaDaCodificare implements Runnable {
	private String string;
	private String encrypted;

	public StringaDaCodificare(String string) {
		this.string = string;
	}

	@Override
	public void run() {		//algoritmo di cifratura
		String c = "";
		for (int i = 0; i < string.length(); i++) {
			int n = (int) string.charAt(i) + 3;
			if (n > 122) {
				if (n < 126) {
					n -= 26;
				}
			}
			c += (char) n;
		}
		c = c.replace('#', 'é');
		encrypted = c;
	}

	public void stampaTesto() {
		for (int i = 0; i < 1; i++) {
			System.out.println(encrypted);
		}
	}
	
	public void stampaSuRiga() {
		for (int i = 0; i < 1; i++) {
			System.out.print(encrypted);
		}
	}
}
