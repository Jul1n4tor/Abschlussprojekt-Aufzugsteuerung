package Aufzugsteuerung;

import java.util.Scanner;

class ElevatorSelector {
	private Scanner scanner = new Scanner(System.in);

	public int getElevator() {
		System.out.println("Guten Tag! Bitte wählen sie ihren Aufzug: ");
		return scanner.nextInt();
	}

}

public class Main {
	public static void main(String[] args) {
		ElevatorSelector selector = new ElevatorSelector();

		final Scanner scannerE = new Scanner(System.in);

		int aufzugsNummer = 0;
		while (aufzugsNummer == 0) {
			aufzugsNummer = selector.getElevator();
		}
		if (aufzugsNummer == 1) {
			System.out.println("Sie haben den Personenaufzug ausgewählt.");
		}
		/*
		 * Die unten gennante Methode versucht ein Grundnetz an Befehlen und
		 * Möglichkeiten für unser Programm aufzubauen. Diese Argumente können später
		 * auch auf die anderen Aufzüge angewendet werden.
		 * 
		 * Ein Problem sehe ich noch in der if methode. Die Ergebnisse und eingaben
		 * spielen sich momentan noch lediglich in diesem Argument ab und geben nur aus
		 * was der user eingibt. Es geschieht keine intelligente verarbeitung der Inputs
		 * oder eine Abspeicherung
		 */

		if (aufzugsNummer == 2) {
			System.out.println("Sie haben den Lastenaufzug ausgewählt. Wie viel Kg Lasten möchten sie Bewegen?");
			int Kg = scannerE.nextInt();
			System.out.println("Sie möchten " + Kg + " Kg Bewegen. Von welchem Stockwerk soll der Aufzug losfahren?");
			int stockwerk = scannerE.nextInt();
			if (stockwerk < 100) {
				System.out.println("Der Aufzug wird vom " + stockwerk
						+ ". Stockwerk losfahren. Zu welchem Stockwerk soll der Aufzug fahren?");
			} else {
				System.out.println("Das ist kein Stockwerk in diesem Haus!");
			}
			int zielstockwerk = scannerE.nextInt();
			if (stockwerk < 100) {
				System.out.println(
						"Sie haben den " + zielstockwerk + ". als Ziel-Stockwerk ausgewählt. Der Fahrstuhl wird vom "
								+ stockwerk + ". zum " + zielstockwerk + ". fahren. Gute Fahrt!");
			} else {
				System.out.println("Das ist kein Stockwerk in diesem Haus!");
			}
		}
		if (aufzugsNummer == 3) {
			System.out.println("Sie haben den VIP-Aufzug ausgewählt.");
		}
	}
}
