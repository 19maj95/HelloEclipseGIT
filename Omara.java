//Deklariramo javni razred.
public class Omara {
	
	// Avtor: Maj Tešar
	// Ime datoteke: Pohistvo.java
	// Opis: od Vaja 27 naprej
	
	// Deklariramo lastnosti, spreminjamo jih samo z uporabo metod
	private String vrstaVsebine;
	private int kapaciteta;
	private int steviloOblek; // kolicinaVsebine
	private int visina;
	private int sirina;
	public boolean jeOdprta;
	
	// Deklariramo konstruktor
	// Vhod: kapaciteta in vsebina
	// Vrne: nov objekt razreda omara
	public Omara(int k, int h, int w, String v) {
		
		//inicializiramo latnosti
		vrstaVsebine = v;
		kapaciteta = k;
		steviloOblek = k; // kolicinaVsebine
		visina = h; // height - višina
		sirina = w; // width - širina
		jeOdprta = false;
	} // konec kontruktorja
	
	// Metoda ki določi kapaciteto
	// Vhod: /
	// Izhod: kapaciteta omare
	public int getKapaciteta() {
		
		// Vrne kapaciteto
		return kapaciteta;
	}
	
	// Metoda, ki vrne količino vsebine
	// vhod: /
	// izhod: vrsta vsebine
	public String getVrstaVsebine() {
		
		// vrne vrednosti lastnosti kolicinaVsebine
		return vrstaVsebine;
	}
	
	// Metoda, ki vrne količino vsebine
	// Vhod: /
	// Izhod: število oblek v omari in višina omare in širina omare
	public int getSteviloOblek() {
		
		// vrne število oblek
		return steviloOblek;
	} // ------------------------------------- steviloOblek
	
	// Metoda, ki vrne višino
	public int getVisina() {
		
		// vrne višino omare
		return visina;
		
	} // ------------------------------------- visina
	
	// Metoda, ki vrne širino
	public int getSirina() {
		
		// Vrne širino omare
		return sirina;
		
	} // -------------------------------------- sirina
	
	// Metoda za odvzem oblek, brisač
	// Vhod: količina ki jo želimo izprazniti
	// Izhod: koliko je še ostalo oblek, brisač v omari
	public int izprazni(int odvzem) throws Exception { // odvzem = ki-lpčicina izprazni
		
		// Preverimo če je omara odprta
		if(jeOdprta) {
			
			//Izbrazni vsebino
			steviloOblek -= odvzem;
			
			// preverimo ali je prazna omara, količina negativna
			if(steviloOblek < 0) {
				
				// postavimo količino na nič
				steviloOblek = 0;
				
				// Vrne izjemo
				throw new Exception("V omari ni dovolj oblek.");
			} // if
		} // if
		
		// če omara ni odprta
		else {
			
			// Če je omara zaprta vrne izjemo
			throw new Exception("Omara je zaprta.");
			
		} // else
			
		// vrne vsebino
		return steviloOblek;
			
	} // izprazni

	// Metoda za odprtje omare
	// vhod: /
	// izhod: vrne odprto omaro
	public boolean odpri() {
		
		// Spremenimo vrednost lastnosti na odprto
		jeOdprta = true;
		
		// V vsakem primeru vrne true
		return true;
		
	} // boolean za odpiranje
	
	// Metoda za zaprtje omare
	// vhod: /
	// izhod: zapre omaro
	public boolean zapri() {
		
		// če je omara že zaprta
		if(!jeOdprta) {
			
			// neuspešno zapiranje
			return false;
		}
		
		else {
			// Spremenimo vrednost lastnosti na zaprto
			jeOdprta = false;
			
			// V vsakem primeru vrne true
			return true;
		}
	} // boolean za zapri omaro
	
	// Metoda napolni omaro
	// Vhod: količina, ki jo vrniti
	// izhod: nova količina vsebine
	// public int napolni(int odvzem)
}