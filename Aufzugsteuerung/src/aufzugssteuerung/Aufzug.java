package aufzugssteuerung;

public class Aufzug {

	private int nummer;
	private String aufzugsart;
	private int personenzahl;
	private float zuslaesigesGesamtgewicht;
	private String weitereEigenschaften;
	private int stockwerk = 0;
	private float lastzaehler = 0;
	
	public Aufzug(int nummer, String aufzugsart, int personenzahl, float zuslaesigesGesamtgewicht, String weitereEigenscahften) {
		this.nummer = nummer;
		this.aufzugsart = aufzugsart;
		this.personenzahl = personenzahl;
		this.zuslaesigesGesamtgewicht = zuslaesigesGesamtgewicht;
		this.weitereEigenschaften = weitereEigenscahften;
	}
	
	public void fahren (float last, int stockwerk) {
		this.stockwerk = stockwerk;
		this.lastzaehler = this.lastzaehler + last;
	}
	
	
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	
	public String getAufzugsart() {
		return aufzugsart;
	}
	public void setAufzugsart(String aufzugsart) {
		this.aufzugsart = aufzugsart;
	}
	
	public int getPersonenzahl() {
		return personenzahl;
	}
	public void setPersonenzahl(int personenzahl) {
		this.personenzahl = personenzahl;
	}
	
	public float getZulaesigesGesamtGewicht() {
		return zuslaesigesGesamtgewicht;
	}
	public void setZuslaesigesGesamtgewicht(float zuslaesigesGesamtgewicht) {
		this.zuslaesigesGesamtgewicht = zuslaesigesGesamtgewicht;
	}
	
	public String getWeitereEigenschaften() {
		return weitereEigenschaften;
	}
	public void setWeitereEigenschaften(String weitereEigenscahften) {
		this.weitereEigenschaften = weitereEigenscahften;
	}
	
	public int getStockwerk() {
		return stockwerk;
	}
	public void setStockwerk(int stockwerk) {
		this.stockwerk = stockwerk;
	}

	public float getLastzaehler() {
		return lastzaehler;
	}
	public void setLastzaeler(float lastzaehler) {
		this.lastzaehler = lastzaehler;
	}
	
	
}