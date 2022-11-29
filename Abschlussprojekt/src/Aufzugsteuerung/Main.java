package Aufzugsteuerung;
import java.util.Scanner;

class ElevatorSelector {
    private Scanner scanner = new Scanner(System.in);

    public int getElevator()
    {
        System.out.println("Guten Tag! Bitte wählen sie ihren Aufzug: ");
        return scanner.nextInt();
    }

}
public class Main{
    public static void main(String[] args){
        ElevatorSelector selector = new ElevatorSelector();

        final Scanner scannerE = new Scanner (System.in);
        
        int aufzugsNummer=0;
        while(aufzugsNummer==0)
        {
            aufzugsNummer = selector.getElevator();
        }
        if (aufzugsNummer==1) {
            System.out.println("Sie haben den Personenaufzug ausgewählt.");
        }
        if (aufzugsNummer==2) {
            System.out.println("Sie haben den Lastenaufzug ausgewählt.");
            if (scannerE.nextInt()== 1) {
                System.out.println("Sie möchten 1 KG Bewegen.");
            }
        }
        if (aufzugsNummer==3) {
            System.out.println("Sie haben den VIP-Aufzug ausgewählt.");
        }
    }
}