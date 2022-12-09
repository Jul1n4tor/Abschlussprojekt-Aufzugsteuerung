package aufzugssteuerung;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Speicher {

	private static String aufzugToString(Aufzug aufzug) {
		return String.valueOf(aufzug.getNummer()) + "°" + aufzug.getAufzugsart() + "°"
				+ String.valueOf(aufzug.getPersonenzahl()) + "°" + String.valueOf(aufzug.getZulaesigesGesamtGewicht())
				+ "°" + aufzug.getWeitereEigenschaften() + "°" + String.valueOf(aufzug.getStockwerk()) + "°"
				+ String.valueOf(aufzug.getLastzaehler());
	}

	private static Aufzug stringToAufzug(String aufzugsstring) {
		String[] aufzugswerte = aufzugsstring.split("°");
		Aufzug aufzug = new Aufzug(Integer.parseInt(aufzugswerte[0]), aufzugswerte[1],
				Integer.parseInt(aufzugswerte[2]), Float.parseFloat(aufzugswerte[3]), aufzugswerte[4]);
		aufzug.setStockwerk(Integer.parseInt(aufzugswerte[5]));
		aufzug.setLastzaeler(Float.parseFloat(aufzugswerte[6]));
		return aufzug;
	}

	public static void AlsDateiSpeichern(Aufzug[] aufzuege) {
		try {
			File speicherdatei = new File("Aufzuge.cfg");
			speicherdatei.createNewFile();
			String Dateiinhalt = "";
			for (Aufzug aufzug : aufzuege) {
				Dateiinhalt = Dateiinhalt + aufzugToString(aufzug) + "\n";
			}
			FileWriter Dateischreiber = new FileWriter(speicherdatei, false);
			Dateischreiber.write(Dateiinhalt);
			Dateischreiber.close();
		} catch (Exception e) {

		}
	}

	public static Aufzug[] aufzugsdateiladen() {
		try {
			File speicherdatei = new File("Aufzuge.cfg");
			if (speicherdatei.exists()) {
				Scanner scanner = new Scanner(speicherdatei);
				Aufzug[] aufzugsListe = new Aufzug[50];
				int i = 0;
				while (scanner.hasNextLine()) {
					String Zeile = scanner.nextLine();
					if (Zeile != "") {
						String[] besserzeile = Zeile.split("\n");
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
