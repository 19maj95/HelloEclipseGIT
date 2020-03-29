import java.io.*; // Vkljuèimo paket za delo z V/I io napravamo
import java.util.*; // paket za delo s pripomoèki
import javax.swing.*; // Uvozimo paket za okna
import java.awt.event.*; // Uvozimo paket z delo z dogotki
import javax.swing.table.*; // Uvozimo paket za delo s tabelami

// Deklariramo javni razred, enako kot ime datoteke
public class Pohistvo implements ActionListener {
	
	// Avtor: Maj Tešar
	// Ime datoteke: Pohistvo.java
	// Opis: od Vaja 27 naprej
	
	// Deklariramo okno
	private JFrame okno;
	// Deklariramo površino
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
		// Ustvarimo poršino v okni
		povrsina = new JPanel();
		// Ustvarimo besedilno okence
		besedilo = new JLabel("Vnesi omaro.");
		kapacitetaOmare = new JLabel("Vnesi kapaciteto omare");
		// ustvarimo gumb
		gumb = new JButton("Dodaj!");
		// Gumbu doloèimo poslušalca dogotkov
		gumb.addActionListener(this);
		// Ustvrimo vnosno polje, številka doloèi dolžino besedila
		vnosnoPolje = new JTextField(45);
		// Ustvrimo vnosno polje, številka doloèi dolžino besedila
		kapacitetaPolje = new JTextField(15);
		// Ustvarimo model tabele
		modelTabele = new DefaultTableModel();
		// Modelu tabele dodamo stolpec
		modelTabele.addColumn("Ime omare");
		// UStvarimo tabelona podlagi modela ki smo ga ustvarili zgoraj
		tabela = new JTable(modelTabele);
		
		// Dodamo besedilo na površino
		povrsina.add(besedilo);
		// dodamo vnosno polje na površino
		povrsina.add(vnosnoPolje);
		// Dodamo novo besedilo na površino
		povrsina.add(kapacitetaOmare);
		// dodamo vnosno polje na površino
		povrsina.add(kapacitetaPolje);
		// Dodamo gumb na površino
		povrsina.add(gumb);
		// Dodamo tabelo na površino
		povrsina.add(tabela);
		
		// Dodamo površino na okno
		okno.add(povrsina);
		
		// Prikažemo okno
		okno.setVisible(true);
		
		// doloèimo velikost okna
		okno.setSize(600, 600);
		
		// Konèamo dogajanje ob zaprtju
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
		
		// Poèistimo vnosno polje
		vnosnoPolje.setText("");
		kapacitetaPolje.setText("");
	}

	// deklariramo statièno lastnost za vnos iz konzole
	private static BufferedReader in;
	
	// Deklariramo statièen seznam omar
	private static ArrayList<Omara> omare;
	
	// Definiramo glavno metodo
	public static void main(String[] args) {
		
		if(args.length > 0) {
			System.out.println("1. argument je: " + args[0]);
			
			// objekt Miza
			Pohistvo m = new Pohistvo(args[0]);
		
			// Izpišemo vajo na zaslon
			System.out.println("Ustvarimo pohištvo za sledeèe omare.");
			// -------------------------------------------------- prvi del
			
			// inicializiramo lastnosti konzole
			in = new BufferedReader(new InputStreamReader(System.in)); //System.in iz konzole
			omare = new ArrayList<Omara>();
			
			// Deklariramo in inicializiramo lokalno spremenljivko
			String vnos = "Napaèen vnos.";
			
			while(true) {
				
				// Poskušamo vprašati po vnosu
				try {
					System.out.print("Vnesiti ime omare: ");
					vnos = in.readLine();
					if(vnos.length() == 0) {
						break;
					}
				}
				
				// èe bi bila sporoèena izjema
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
			
			{ // Izpišemo koliko je oblek v omari, izpišemo lastnoti. za spalnico
				System.out.print("V omari v spalnici je " + spalnica.getSteviloOblek() + " oblek.");
			// konec izpisa za obleke -----------------------------------
			
			// Izpišemo višino omare
				System.out.print(" Omara v spalnici je visoka " + spalnica.getVisina() + " centimetrov.");
			// Konec izpisa za višino -----------------------------------
			
			// Izpišemo širino omare
				System.out.println(" In široka " + spalnica.getSirina() + " centimetrov.");
			} // Konec izpisa višine --------------------------
			
			{ // Izpišemo koliko je oblek v omari, izpišemo lastnoti. za otroskaSoba
				System.out.print("V omari v otroški sobi je " + otroskaSoba.getSteviloOblek() + " oblek.");
			// konec izpisa za obleke -----------------------------------
			
			// Izpišemo višino omare
				System.out.print(" Omara v otroški sobi je visoka " + otroskaSoba.getVisina() + " centimetrov.");
			// Konec izpisa za višino -----------------------------------
			
			// Izpišemo širino omare
				System.out.println(" In široka " + otroskaSoba.getSirina() + " centimetrov.");
			} // Konec izpisa višine --------------------------
			
			{ // Odpremo omaro v spalnici
			spalnica.odpri();
			
			try {// Uzamemo obleke iz omare
				spalnica.izprazni(4);
				
				// izpišemo novo kolièino, za omaro v spalnici
					System.out.print("Po jutru je v omari v spalnici, ko se oblèemo je še ");
					System.out.print(spalnica.getSteviloOblek());
					System.out.println(" oblek.");
			} catch(Exception e) {System.err.println("Napaka: " + e);}
				
			// Zapremo omaro
			spalnica.zapri();
			
			} // omara v spalnici
			
			{ // odpremo omaro v otroški sobi		
			try {// Uzamemo ven brisaèe
				otroskaSoba.izprazni(7);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			// Izpišemo novo kolièino, za omaro v kopalnici
			System.out.println("V otroški sobi v omari je še " + otroskaSoba.getSteviloOblek() + " oblek.");
			
			// Zapremo omaro
			otroskaSoba.zapri();
			}
			
			// ustvarimo kuhinjsko omaro
			KuhinjaOmara kuhinja = new KuhinjaOmara ("Viseèa", 37, 15, 22);
			System.out.println("V kuhinskji omari je " + kuhinja.getKrozniki() + " krožnikov in " + kuhinja.getKozarci() + " kozarcov. Skupaj kapacitete je " + kuhinja.getKapaciteta());
			
			// Poskušamo vzeti 20 krožnikov
			kuhinja.odpri();
			try {
				kuhinja.izprazniKroznike(20);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			System.out.println("Po odprtju je v kuhinjski omari je še " + kuhinja.getKrozniki() + " krožnikov in " + kuhinja.getKozarci() + " kozarcev");
			
			//ustvarimo kopalniško omaro
			KopalnicaOmara kopalnica = new KopalnicaOmara(20, 14, 6, 3);
			System.out.println("V kopalniški omari je " + kopalnica.getBrisace() + " brisaè in " + kopalnica.getMila() + " mil. Skupaj kapacitete je " + kopalnica.getKapaciteta() + " in ima " + kopalnica.getStopnjaAlkohola() + " nevarna èistila.");
			
			try {
				kopalnica.izprazniMila(1);
			} catch(Exception e) {System.err.println("Napaka: " + e);}
			System.out.println("Vzamemo milo iz kopalniške omare, mil po vzetju je še " + kopalnica.getMila() + " in " + kopalnica.getBrisace() + " brisaè.");
			
			//izpišemo vsebino vnosa
			for(int c=0; c<omare.size(); c++) {
				System.out.println("Vpisali ste: " + c + ". omaro. " + omare.get(c).getVrstaVsebine());
			}
		}
		
		else {
			System.out.println("Program je bil zagnan brez argumentov.");
		}
	}
	
}