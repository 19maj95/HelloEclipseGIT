// definiramo razred, ki razširi omaro
public class KuhinjaOmara extends Omara {
	
	// Vse lastnosti deklarirene v nadrazredu se prenašajo
	// Deklariramo še nove lastnosti
	private String lega; // Viseèa/talna
	private int krozniki;
	private int kozarci;
	
	// deklariramo konstruktor enako kot pri nadrazredu
	// Vhod: serveti, krozniki, kozarci, pribor
	public KuhinjaOmara(String l, int k, int kr, int ko) {
		
		// Poklièemo konstruktor nadrazredu
		super(k, 53, 40, "Viseèa");
		
		// doloèimo ostale lastnosti
		lega = l;
		krozniki = kr;
		kozarci = ko;
	} // konec 1. konstruktorja
	
	public int getKrozniki() {
		return krozniki;
	}
	
	// Metoda za odvzem kožnikov
	// Vhod: kolièina ki jo želimo izprazniti
	// Izhod: koliko je še krožnikov v omari.
	public int izprazniKroznike(int odvzem) throws Exception { // odvzem = ki-lpèicina izprazni
		
		// Preverimo èe je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			krozniki -= odvzem;
			
			// preverimo ali je prazna omara, kolièina negativna
			if(krozniki < 0) {
				
				// postavimo kolièino na niè
				krozniki = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj krožnikov.");
			} // if
		} // if
		
		// èe omara ni odprta
		else {
			
			// Èe je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return krozniki;
			
	} // izprazni
	
	public int getKozarci() {
		return kozarci;
	}
	
	// Metoda za odvzem kozarcev
	// Vhod: kolièina ki jo želimo izprazniti
	// Izhod: koliko je še kozarcev v omari.
	public int izprazniKozarce(int odvzem) throws Exception { // odvzem = ki-lpèicina izprazni
		
		// Preverimo èe je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			kozarci -= odvzem;
			
			// preverimo ali je prazna omara, kolièina negativna
			if(kozarci < 0) {
				
				// postavimo kolièino na niè
				kozarci = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj kozarcev.");
			} // if
		} // if
		
		// èe omara ni odprta
		else {
			
			// Èe je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return kozarci;
			
	} // izprazni
}