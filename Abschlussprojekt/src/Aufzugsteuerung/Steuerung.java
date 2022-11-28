package Aufzugsteuerung;
import java.util.Scanner;
/*
 * Das ist die Methode zum Steuern des Aufzugs. Hier habe ich versucht ein Programm Aufzuzuiehen, 
 * dass Inputs lesen und die richtigen Ausgaben dazu machen kann. 
 * Leider bin ich daran gescheitert, dass: 1.Das Programm nichtmehr mit der Eingangsnachricht startet und 2.das Programm nach der ersten Eingabe beendet wird.
 * Das Konstrukt ist noch sehr Primitiv und es existieren noch keine Variablen. Beides muss noch später eingearbeitet werden.
 * 
 * Die Auskommentierten Argumente am Ende waren versuche mit ergebnissen aus dem Web das Problem zu lösen.
 * 
 * @author Julius Marquardt
 * */

public class Steuerung {
	public static void main (String[]args) {
		Scanner eingabe = new Scanner(System.in);
		String s = eingabe.next();
		System.out.println("Guten Tag! Bitte wählen sie ihren Aufzug: ");
		
		  if (s.equals("1")) {
			System.out.println ("Sie haben den Personen Aufzug ausgewählt. Wieviele Personen möchten sie befördern?");
			if (s.equals("2")) {
				System.out.println ("Zwei Person wurde ausgwählt. Von welchem Stockwerk starten sie?");

			}
//			   int a = eingabe.nextInt();
//			   System.out.println("Enter number.");
//			   int b = eingabe.nextInt();
//			   System.out.println("Enter number.");
//			   int c = eingabe.nextInt();

		  }
	}
}
