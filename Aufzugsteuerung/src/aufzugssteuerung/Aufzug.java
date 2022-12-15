package aufzugssteuerung;

/**
 * Diese "Aufzug"-Klasse gibt an welche Attribute einem Aufzug zur verfügung
 * stehen. Das ganze kann dann durch Getter -und Setter-Methoden abgerufen
 * werden.
 * 
 * @author Cedric Beyer
 */

public class Aufzug {

	/**
	 * Legt eine Nummer für einen Aufzug fest.
	 */

	private int nummer;

	/**
	 * Die Art des Aufzugs.
	 */

	private String aufzugsart;

	/**
	 * Die Anzahl an Personen die transportiert werden dürfen.
	 */

	private int personenzahl;

	/**
	 * Das maximal Gewicht das ein Aufzug transportieren kann.
	 */

	private float zulaessigesGesamtgewicht;

	/**
	 * Weitere spezial Eigenschaften, die bei jedem Aufzug unterschiedlich sein
	 * können.
	 */

	private String weitereEigenschaften;

	/**
	 * Das Stockwerk auf dem sich der Aufzug befindet.
	 */

	private int stockwerk = 0;

	/**
	 * Der Lastenzähler ist die Gesamtanzahl, der jemals an Personen oder Gewicht
	 * transportierten Mengen.
	 */

	private float lastzaehler = 0;

	/**
	 * Der Aufzug bekommt alle seine Werte, mit denen er sich als Aufzug beschreiben
	 * soll.
	 * 
	 * @param nummer                   ; ist die Aufzugsnummer die der Aufzug
	 *                                 erhält.
	 * @param aufzugsart               ; beschreibt um welche Art von Aufzug es sich
	 *                                 handelt.
	 * @param personenzahl             ; die Menge an Personen, die maximal
	 *                                 transportiert werden dürfen.
	 * @param zulaessigesGesamtgewicht ; das maximal Gewicht das transportiert
	 *                                 werden darf.
	 * @param weitereEigenschaften     ; die zusätzlichen Besonderheiten jedes
	 *                                 Aufzuges.
	 */

	public Aufzug(int nummer, String aufzugsart, int personenzahl, float zulaessigesGesamtgewicht,
			String weitereEigenschaften) {
		this.nummer = nummer;
		this.aufzugsart = aufzugsart;
		this.personenzahl = personenzahl;
		this.zulaessigesGesamtgewicht = zulaessigesGesamtgewicht;
		this.weitereEigenschaften = weitereEigenschaften;
	}

	/**
	 * Der Aufzug bewegt sich durch die Stockwerke und verändert somit seinen
	 * Standort.
	 * 
	 * @param last      ; wie viele Personen oder Gewicht transportiert werden muss.
	 * @param stockwerk ; das neue Stockwerk auf dem sich der Aufzug befinden soll.
	 */

	public void fahren(float last, int stockwerk) {
		this.stockwerk = stockwerk;
		this.lastzaehler = this.lastzaehler + last;
	}

	/**
	 * Hier werden alle Getter- und Setter Methoden deklariert, damit das Programm
	 * auf diese zugreifen kann. Damit können Änderungen und Abfragen aufgerufen
	 * werden.
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

	public float getZulaessigesGesamtgewicht() {
		return zulaessigesGesamtgewicht;
	}

	public void setZulaessigesGesamtgewicht(float zuslaesigesGesamtgewicht) {
		this.zulaessigesGesamtgewicht = zuslaesigesGesamtgewicht;
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