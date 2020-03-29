// definiramo razred, ki raz�iri omaro
public class KopalnicaOmara extends Omara implements Cistila {
	
	// Vse lastnosti deklarirene v nadrazredu se prena�ajo
	// Deklariramo �e nove lastnosti
	private int brisace;
	private int mila;
	private int cistila;
	
	// deklariramo konstruktor enako kot pri nadrazredu
	// Vhod: brisa�e, mila
	public KopalnicaOmara(int k, int b, int m, int c) {
		
		// Pokli�emo konstruktor nadrazredu
		super(k, 20, 6, "Vise�a");
		
		// dolo�imo ostale lastnosti
		brisace = b;
		mila = m;
		cistila = c;
	} // konec 1. konstruktorja
	
	public int getBrisace() {
		return brisace;
	}
	
	// Metoda za odvzem brisa�
	// Vhod: koli�ina ki jo �elimo izprazniti
	// Izhod: koliko je �e brisa� v omari.
	public int izprazniBrisace(int odvzem) throws Exception { // odvzem = ki-lp�icina izprazni
		
		// Preverimo �e je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			brisace -= odvzem;
			
			// preverimo ali je prazna omara, koli�ina negativna
			if(brisace < 0) {
				
				// postavimo koli�ino na ni�
				brisace = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj brisa�.");
			} // if
		} // if
		
		// �e omara ni odprta
		else {
			
			// �e je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return brisace;
			
	} // izprazni
	
	public int getMila() {
		return mila;
	}
	
	// Metoda za odvzem mila
	// Vhod: koli�ina ki jo �elimo izprazniti
	// Izhod: koliko je �e mil v omari.
	public int izprazniMila(int odvzem) throws Exception { // odvzem = ki-lp�icina izprazni
		
		// Preverimo �e je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			mila -= odvzem;
			
			// preverimo ali je prazna omara, koli�ina negativna
			if(mila < 0) {
				
				// postavimo koli�ino na ni�
				mila = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj mil.");
			} // if
		} // if
		
		// �e omara ni odprta
		else {
			
			// �e je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return mila;
			
	} // izprazni
	
	// Implementiramo metodo Cistila, ki jo pripiruje vmesnik Cistila
	public int getStopnjaAlkohola() {
		return cistila;
	}
}