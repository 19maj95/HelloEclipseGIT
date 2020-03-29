// definiramo razred, ki raz�iri omaro
public class KuhinjaOmara extends Omara {
	
	// Vse lastnosti deklarirene v nadrazredu se prena�ajo
	// Deklariramo �e nove lastnosti
	private String lega; // Vise�a/talna
	private int krozniki;
	private int kozarci;
	
	// deklariramo konstruktor enako kot pri nadrazredu
	// Vhod: serveti, krozniki, kozarci, pribor
	public KuhinjaOmara(String l, int k, int kr, int ko) {
		
		// Pokli�emo konstruktor nadrazredu
		super(k, 53, 40, "Vise�a");
		
		// dolo�imo ostale lastnosti
		lega = l;
		krozniki = kr;
		kozarci = ko;
	} // konec 1. konstruktorja
	
	public int getKrozniki() {
		return krozniki;
	}
	
	// Metoda za odvzem ko�nikov
	// Vhod: koli�ina ki jo �elimo izprazniti
	// Izhod: koliko je �e kro�nikov v omari.
	public int izprazniKroznike(int odvzem) throws Exception { // odvzem = ki-lp�icina izprazni
		
		// Preverimo �e je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			krozniki -= odvzem;
			
			// preverimo ali je prazna omara, koli�ina negativna
			if(krozniki < 0) {
				
				// postavimo koli�ino na ni�
				krozniki = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj kro�nikov.");
			} // if
		} // if
		
		// �e omara ni odprta
		else {
			
			// �e je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return krozniki;
			
	} // izprazni
	
	public int getKozarci() {
		return kozarci;
	}
	
	// Metoda za odvzem kozarcev
	// Vhod: koli�ina ki jo �elimo izprazniti
	// Izhod: koliko je �e kozarcev v omari.
	public int izprazniKozarce(int odvzem) throws Exception { // odvzem = ki-lp�icina izprazni
		
		// Preverimo �e je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			kozarci -= odvzem;
			
			// preverimo ali je prazna omara, koli�ina negativna
			if(kozarci < 0) {
				
				// postavimo koli�ino na ni�
				kozarci = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj kozarcev.");
			} // if
		} // if
		
		// �e omara ni odprta
		else {
			
			// �e je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return kozarci;
			
	} // izprazni
}