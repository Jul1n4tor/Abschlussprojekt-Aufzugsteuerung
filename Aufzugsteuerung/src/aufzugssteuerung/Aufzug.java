package aufzugssteuerung;

/**
 * Diese "Aufzugs"-Klasse gibt ann welche Atribute einem Aufzug zur verffügung stehen.
 * Das ganze kann, dann durch getter -und setter Methoden abgerufen werden.
 * 
 * @author Cedric Beyer 
 * 
 */
public class Aufzug {

	/**
	 * Legt einen Nummer für den Aufzug fest.
	 */
	private int nummer;
	/**
	 * Die Aufzugsart wird beschrieben
	 */
	private String aufzugsart;
	/**
	 * Die anzahl an Personen die Transportiert werden dürfen.
	 */
	private int personenzahl;
	/**
	 * Das maximal Gewicht, dass ein Aufzug transportieren kann.
	 */
	private float zuslaesigesGesamtgewicht;
	/**
	 * Weiter speciell Eigenschafen die bei jedem Aufzug unterschiedlich sein können.
	 */
	private String weitereEigenschaften;
	/**
	 * Das Stockwerk auf dem sich der Aufzug befindet.
	 */
	private int stockwerk = 0;
	/**
	 * Der Lastenzähler ist die Gesamtanzahl die jemals an Personen oder Gewicht transportiert wurde.
	 */
	private float lastzaehler = 0;
	
	/**
	 * Der Aufzug bekommt alle seine Werte, mit denen er sich als Aufzug beschreiben darf.
	 * 
	 * @param nummer ist die Aufzugsnummer die der Aufzug erhält.
	 * @param aufzugsart ist die um welchen Aufzug es sich handelt.
	 * @param personenzahl die menge an Personen die maximal transportiert werden dürfen.
	 * @param zuslaesigesGesamtgewicht das maximal Gewicht, dass transportiert werden darf.
	 * @param weitereEigenscahften die zussätzklichen besonderheiten jedes Aufzuges.
	 */
	public Aufzug(int nummer, String aufzugsart, int personenzahl, float zuslaesigesGesamtgewicht, String weitereEigenscahften) {
		this.nummer = nummer;
		this.aufzugsart = aufzugsart;
		this.personenzahl = personenzahl;
		this.zuslaesigesGesamtgewicht = zuslaesigesGesamtgewicht;
		this.weitereEigenschaften = weitereEigenscahften;
	}
	
	/**
	 * Der Aufzug bewget sich durch die Stockwerke und veränder somit seinen Standort.
	 * 
	 * @param last wie viele Personen oder Gewicht transportiert werden muss.
	 * @param stockwerk das neue Stockwerk auf dem sich der Aufzug befinden soll.
	 */
	public void fahren (float last, int stockwerk) {
		this.stockwerk = stockwerk;
		this.lastzaehler = this.lastzaehler + last;
	}
	

	/**
	 * Hier werden alle getter und setter Methoden declariet, damit das Programm auf diese zugreifen kann.
	 * Damit können Änderungen und Abfragen aufgerufen werden.
	 * 
	 */
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