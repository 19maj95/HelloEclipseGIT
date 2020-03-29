// definiramo razred, ki razširi omaro
public class KopalnicaOmara extends Omara implements Cistila {
	
	// Vse lastnosti deklarirene v nadrazredu se prenašajo
	// Deklariramo še nove lastnosti
	private int brisace;
	private int mila;
	private int cistila;
	
	// deklariramo konstruktor enako kot pri nadrazredu
	// Vhod: brisaèe, mila
	public KopalnicaOmara(int k, int b, int m, int c) {
		
		// Poklièemo konstruktor nadrazredu
		super(k, 20, 6, "Viseèa");
		
		// doloèimo ostale lastnosti
		brisace = b;
		mila = m;
		cistila = c;
	} // konec 1. konstruktorja
	
	public int getBrisace() {
		return brisace;
	}
	
	// Metoda za odvzem brisaè
	// Vhod: kolièina ki jo želimo izprazniti
	// Izhod: koliko je še brisaè v omari.
	public int izprazniBrisace(int odvzem) throws Exception { // odvzem = ki-lpèicina izprazni
		
		// Preverimo èe je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			brisace -= odvzem;
			
			// preverimo ali je prazna omara, kolièina negativna
			if(brisace < 0) {
				
				// postavimo kolièino na niè
				brisace = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj brisaè.");
			} // if
		} // if
		
		// èe omara ni odprta
		else {
			
			// Èe je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return brisace;
			
	} // izprazni
	
	public int getMila() {
		return mila;
	}
	
	// Metoda za odvzem mila
	// Vhod: kolièina ki jo želimo izprazniti
	// Izhod: koliko je še mil v omari.
	public int izprazniMila(int odvzem) throws Exception { // odvzem = ki-lpèicina izprazni
		
		// Preverimo èe je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			mila -= odvzem;
			
			// preverimo ali je prazna omara, kolièina negativna
			if(mila < 0) {
				
				// postavimo kolièino na niè
				mila = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj mil.");
			} // if
		} // if
		
		// èe omara ni odprta
		else {
			
			// Èe je omara zaprta vrne izjemo
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