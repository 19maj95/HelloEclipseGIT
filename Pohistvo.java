import java.io.*; // Vklju�imo paket za delo z V/I io napravamo
import java.util.*; // paket za delo s pripomo�ki
import javax.swing.*; // Uvozimo paket za okna
import java.awt.event.*; // Uvozimo paket z delo z dogotki
import javax.swing.table.*; // Uvozimo paket za delo s tabelami

// Deklariramo javni razred, enako kot ime datoteke
public class Pohistvo implements ActionListener {
	
	// Avtor: Maj Te�ar
	// Ime datoteke: Pohistvo.java
	// Opis: od Vaja 27 naprej
	
	// Deklariramo okno
	private JFrame okno;
	// Deklariramo povr�ino
	private JPanel povrsina;
	// Ustvarimo besedilo
	private JLabel besedilo;
	// Ustvarimo drugo besedilo
	private JLabel kapacitetaOmare;
	// Dodamo gumb
	private JButton gumb;
	// Ustvarimo besedilo polje
	private JTextField vnosnoPolje;
	// Ustvarimo drugo besedilno polje
	private JTextField kapacitetaPolje;
	// Ustvarimo tabelo
	private JTable tabela;
	// Abstraktni razred tabele
	private DefaultTableModel modelTabele;
	
	// Konstruktor
	public Pohistvo(String naslov) {
		
		// Inicializiramo novo okno
		okno = new JFrame(naslov);
		// Ustvarimo por�ino v okni
		povrsina = new JPanel();
		// Ustvarimo besedilno okence
		besedilo = new JLabel("Vnesi omaro.");
		kapacitetaOmare = new JLabel("Vnesi kapaciteto omare");
		// ustvarimo gumb
		gumb = new JButton("Dodaj!");
		// Gumbu dolo�imo poslu�alca dogotkov
		gumb.addActionListener(this);
		// Ustvrimo vnosno polje, �tevilka dolo�i dol�ino besedila
		vnosnoPolje = new JTextField(45);
		// Ustvrimo vnosno polje, �tevilka dolo�i dol�ino besedila
		kapacitetaPolje = new JTextField(15);
		// Ustvarimo model tabele
		modelTabele = new DefaultTableModel();
		// Modelu tabele dodamo stolpec
		modelTabele.addColumn("Ime omare");
		// UStvarimo tabelona podlagi modela ki smo ga ustvarili zgoraj
		tabela = new JTable(modelTabele);
		
		// Dodamo besedilo na povr�ino
		povrsina.add(besedilo);
		// dodamo vnosno polje na povr�ino
		povrsina.add(vnosnoPolje);
		// Dodamo novo besedilo na povr�ino
		povrsina.add(kapacitetaOmare);
		// dodamo vnosno polje na povr�ino
		povrsina.add(kapacitetaPolje);
		// Dodamo gumb na povr�ino
		povrsina.add(gumb);
		// Dodamo tabelo na povr�ino
		povrsina.add(tabela);
		
		// Dodamo povr�ino na okno
		okno.add(povrsina);
		
		// Prika�emo okno
		okno.setVisible(true);
		
		// dolo�imo velikost okna
		okno.setSize(600, 600);
		
		// Kon�amo dogajanje ob zaprtju
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Implementiramo metodo, ki jo predpisuje vmesnik
	public void actionPerformed(ActionEvent e) {
		// System.out.println("dogodek: " + e.toString());
		System.out.println("Ime omare: " + vnosnoPolje.getText());
		System.out.println("kapaciteta omare: " + kapacitetaPolje.getText());
		
		// Pripravimo seznam objektov za vnos vrstice
		Object[] vrstica = new Object[] {vnosnoPolje.getText()};
		Object[] vrsticaDve = new Object[] {kapacitetaPolje.getText()};
		
		// dodamo vrstico v model tabele
		modelTabele.addRow(vrstica);
		modelTabele.addRow(vrsticaDve);
		
		// Po�istimo vnosno polje
		vnosnoPolje.setText("");
		kapacitetaPolje.setText("");
	}

	// deklariramo stati�no lastnost za vnos iz konzole
	private static BufferedReader in;
	
	// Deklariramo stati�en seznam omar
	private static ArrayList<Omara> omare;
	
	// Definiramo glavno metodo
	public static void main(String[] args) {
		
		if(args.length > 0) {
			System.out.println("1. argument je: " + args[0]);
			
			// objekt Miza
			Pohistvo m = new Pohistvo(args[0]);
		
			// Izpi�emo vajo na zaslon
			System.out.println("Ustvarimo pohi�tvo za slede�e omare.");
			// -------------------------------------------------- prvi del
			
			// inicializiramo lastnosti konzole
			in = new BufferedReader(new InputStreamReader(System.in)); //System.in iz konzole
			omare = new ArrayList<Omara>();
			
			// Deklariramo in inicializiramo lokalno spremenljivko
			String vnos = "Napa�en vnos.";
			
			while(true) {
				
				// Posku�amo vpra�ati po vnosu
				try {
					System.out.print("Vnesiti ime omare: ");
					vnos = in.readLine();
					if(vnos.length() == 0) {
						break;
					}
				}
				
				// �e bi bila sporo�ena izjema
				catch(Exception e) {
					System.err.println("Napaka: " + e);
				}
				
				// Dodamo novo omaro v seznam omar
				omare.add(new Omara(100, 100, 100, vnos));
				
			} // while
			
			// Za vnos
			Omara novVnos = new Omara(0, 0, 0, vnos);
			System.out.println("Vnesli ste omaro na/v " + vnos + ".");
			
			// Deklariramo in inicializiramo nove objekte tipa Omara
			Omara spalnica = new Omara(80, 175, 80, "spalna omara");
			Omara otroskaSoba = new Omara(115, 100, 100, "otroska soba");
			
			{ // Izpi�emo koliko je oblek v omari, izpi�emo lastnoti. za spalnico
				System.out.print("V omari v spalnici je " + spalnica.getSteviloOblek() + " oblek.");
			// konec izpisa za obleke -----------------------------------
			
			// Izpi�emo vi�ino omare
				System.out.print(" Omara v spalnici je visoka " + spalnica.getVisina() + " centimetrov.");
			// Konec izpisa za vi�ino -----------------------------------
			
			// Izpi�emo �irino omare
				System.out.println(" In �iroka " + spalnica.getSirina() + " centimetrov.");
			} // Konec izpisa vi�ine --------------------------
			
			{ // Izpi�emo koliko je oblek v omari, izpi�emo lastnoti. za otroskaSoba
				System.out.print("V omari v otro�ki sobi je " + otroskaSoba.getSteviloOblek() + " oblek.");
			// konec izpisa za obleke -----------------------------------
			
			// Izpi�emo vi�ino omare
				System.out.print(" Omara v otro�ki sobi je visoka " + otroskaSoba.getVisina() + " centimetrov.");
			// Konec izpisa za vi�ino -----------------------------------
			
			// Izpi�emo �irino omare
				System.out.println(" In �iroka " + otroskaSoba.getSirina() + " centimetrov.");
			} // Konec izpisa vi�ine --------------------------
			
			{ // Odpremo omaro v spalnici
			spalnica.odpri();
			
			try {// Uzamemo obleke iz omare
				spalnica.izprazni(4);
				
				// izpi�emo novo koli�ino, za omaro v spalnici
					System.out.print("Po jutru je v omari v spalnici, ko se obl�emo je �e ");
					System.out.print(spalnica.getSteviloOblek());
					System.out.println(" oblek.");
			} catch(Exception e) {System.err.println("Napaka: " + e);}
				
			// Zapremo omaro
			spalnica.zapri();
			
			} // omara v spalnici
			
			{ // odpremo omaro v otro�ki sobi		
			try {// Uzamemo ven brisa�e
				otroskaSoba.izprazni(7);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			// Izpi�emo novo koli�ino, za omaro v kopalnici
			System.out.println("V otro�ki sobi v omari je �e " + otroskaSoba.getSteviloOblek() + " oblek.");
			
			// Zapremo omaro
			otroskaSoba.zapri();
			}
			
			// ustvarimo kuhinjsko omaro
			KuhinjaOmara kuhinja = new KuhinjaOmara ("Vise�a", 37, 15, 22);
			System.out.println("V kuhinskji omari je " + kuhinja.getKrozniki() + " kro�nikov in " + kuhinja.getKozarci() + " kozarcov. Skupaj kapacitete je " + kuhinja.getKapaciteta());
			
			// Posku�amo vzeti 20 kro�nikov
			kuhinja.odpri();
			try {
				kuhinja.izprazniKroznike(20);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			System.out.println("Po odprtju je v kuhinjski omari je �e " + kuhinja.getKrozniki() + " kro�nikov in " + kuhinja.getKozarci() + " kozarcev");
			
			//ustvarimo kopalni�ko omaro
			KopalnicaOmara kopalnica = new KopalnicaOmara(20, 14, 6, 3);
			System.out.println("V kopalni�ki omari je " + kopalnica.getBrisace() + " brisa� in " + kopalnica.getMila() + " mil. Skupaj kapacitete je " + kopalnica.getKapaciteta() + " in ima " + kopalnica.getStopnjaAlkohola() + " nevarna �istila.");
			
			try {
				kopalnica.izprazniMila(1);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			System.out.println("Vzamemo milo iz kopalni�ke omare, mil po vzetju je �e " + kopalnica.getMila() + " in " + kopalnica.getBrisace() + " brisa�.");
			
			//izpi�emo vsebino vnosa
			for(int c=0; c<omare.size(); c++) {
				System.out.println("Vpisali ste: " + c + ". omaro. " + omare.get(c).getVrstaVsebine());
			}
		}
		
		else {
			System.out.println("Program je bil zagnan brez argumentov.");
		}
	}
	
}