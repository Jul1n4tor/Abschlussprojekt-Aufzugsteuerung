package aufzugssteuerung;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Hier befinden wir uns in der "Speicher"-Klasse. Hier werden unse Daten aus
 * der Aufzugs-Arraylist abgespeicht und in einer separaten Text-Datei im
 * Programmordner abgelegt.
 * 
 * @author Cedric Beyer
 */

public class Speicher {

	/**
	 * Der Aufzug wird mitsamt seiner ganzen Attribute zu einem großen String
	 * "zusammengeklebt". Mit dem Sonderzeichen ' ° ' werden die verschiedenen Werte
	 * leserlich voneinander getrennt.
	 * 
	 * @param aufzug ; der Aufzug, der gerade zu einem String zusammengeschrieben
	 *               wird.
	 * 
	 * @return der Aufzug wird als ein String zusammengesetzt.
	 */

	private static String aufzugToString(Aufzug aufzug) {
		return String.valueOf(aufzug.getNummer()) + "°" + aufzug.getAufzugsart() + "°"
				+ String.valueOf(aufzug.getPersonenzahl()) + "°" + String.valueOf(aufzug.getZulaessigesGesamtgewicht())
				+ "°" + aufzug.getWeitereEigenschaften() + "°" + String.valueOf(aufzug.getStockwerk()) + "°"
				+ String.valueOf(aufzug.getLastzaehler());
	}

	/**
	 * Der große Aufzugs String wird nun wieder in aufgesplittet. An jeder stelle wo
	 * sich das Sonderzeichen ° befindet, wird der String zerteilt. Um wieder alle
	 * Atribute ihren eigentlichen Variabeln zuzuweisen.
	 * 
	 * @param aufzugsstring ; der entstandene String wird wieder abgerufen.
	 * 
	 * @return Aufzug erhält wieder all seinen Attribute mit den entsprechenden
	 *         Variablen.
	 */

	private static Aufzug stringToAufzug(String aufzugsstring) {
		String[] aufzugswerte = aufzugsstring.split("°");
		Aufzug aufzug = new Aufzug(Integer.parseInt(aufzugswerte[0]), aufzugswerte[1],
				Integer.parseInt(aufzugswerte[2]), Float.parseFloat(aufzugswerte[3]), aufzugswerte[4]);
		aufzug.setStockwerk(Integer.parseInt(aufzugswerte[5]));
		aufzug.setLastzaeler(Float.parseFloat(aufzugswerte[6]));
		return aufzug;
	}

	/**
	 * Hier wird die Aufzugs-Arraylist in einer separaten Text-Datei gespeichert.
	 * Wenn es noch keine vorherige Speicher-Datei gibt, wird eine Neue erstellt.
	 * Sollte schon eine Speicher-Datei vorhanden sein, wird diese nach Abschluss
	 * des Programms überschrieben.
	 * 
	 * @param aufzuege ist das Array, in dem sich alle erstellten Strings der
	 *                 Aufzüge befinden.
	 */

	public static void alsDateiSpeichern(Aufzug[] aufzuege) {
		try {
			File speicherdatei = new File("Aufzuge.txt");
			speicherdatei.createNewFile();
			String dateiInhalt = "";
			for (Aufzug aufzug : aufzuege) {
				dateiInhalt = dateiInhalt + aufzugToString(aufzug) + "\n";
			}
			FileWriter dateischreiber = new FileWriter(speicherdatei, false);
			dateischreiber.write(dateiInhalt);
			dateischreiber.close();
		} catch (Exception e) {

		}
	}

	/**
	 * Hier wird im Programmordner nachgeschaut, ob eine Speicher-Datei vorliegt.
	 * Sollte dies der Fall sein, wird diese geladen und alle Aufzüge bekommen die
	 * Attribute aus der Speicher-Datei zugewiesen.
	 * 
	 * @return Die bestehende Arraylist wird durch unsere Speicher-Datei
	 *         überschrieben.
	 */

	public static Aufzug[] aufzugsdateiladen() {
		try {
			File speicherdatei = new File("Aufzuge.txt");
			if (speicherdatei.exists()) {
				Scanner scanner = new Scanner(speicherdatei);
				Aufzug[] aufzugsListe = new Aufzug[50];
				int i = 0;
				while (scanner.hasNextLine()) {
					String zeile = scanner.nextLine();
					if (zeile != "") {
						String[] besserzeile = zeile.split("\n");
						aufzugsListe[i] = stringToAufzug(besserzeile[0]);
						i++;
					}
				}
				scanner.close();
				return aufzugsListe;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Aufzug[50];
	}
}
