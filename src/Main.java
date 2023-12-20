// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;


public class Main {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void SerializacjaDoXML(){

    }
    public static void main(String[] args) {

        ArrayList<Gwiazdozbior> gwiazdozbiory = new ArrayList<Gwiazdozbior>();
        boolean czyKontynuowac = true;
        while (czyKontynuowac == true) {
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Wyświetl gwiazdozbiory");
            System.out.println("2. Dodaj gwiazdozbiór");
            System.out.println("3. Usuń gwiazdozbiór");
            System.out.println("4. Pokaż gwiazdy w gwiazdozbiorze");
            System.out.println("5. Dodaj gwiazdę do gwiazdozbioru");
            Scanner scanner = new Scanner(System.in);
            String wybranaOpcja = scanner.nextLine();

            switch (wybranaOpcja) {
                case "1":
                    clearConsole();
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                        }
                    }

                case "2":
                    clearConsole();
                    String nazwaGwiazdozbioru = scanner.nextLine();
                    gwiazdozbiory.add(new Gwiazdozbior(nazwaGwiazdozbioru));
                    break;
                case "3":
                    clearConsole();
                    System.out.println("Usuń gwiazdozbiór");
                    break;
                case "4":
                    clearConsole();
                    System.out.println(gwiazdozbiory.get(0).nazwaGwiazdozbioru);
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                    }
                    System.out.println("Wybierz gwiazdozbiór");
                    wybranaOpcja = scanner.nextLine();
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            if (gwiazdozbiory.get(i).nazwaGwiazdozbioru.equals(wybranaOpcja)) {
                                for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                                    System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                                }
                            }
                        }
                    }
                    break;
                case "5":
                    clearConsole();
                    System.out.println("Wybierz gwiazdozbiór");
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                        }
                    }
                    wybranaOpcja = scanner.nextLine();
                    String czyDodac = "t";
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                            if (gwiazdozbiory.get(i) != null) {
                                if (gwiazdozbiory.get(i).nazwaGwiazdozbioru.equals(wybranaOpcja)) {
                                    System.out.println("Podaj nazwę gwiazdy");
                                    String nazwaGwiazdy = scanner.nextLine();
                                    System.out.println("Podaj deklinację");
                                    int stopnie = scanner.nextInt();
                                    int minuty = scanner.nextInt();
                                    double sekundy = scanner.nextDouble();
                                    Deklinacja deklinacja = new Deklinacja(stopnie, minuty, sekundy);
                                    System.out.println("Podaj rektascensję");
                                    int godziny = scanner.nextInt();
                                    minuty = scanner.nextInt();
                                    int sekundy2 = scanner.nextInt();
                                    Rektascensja rektascensja = new Rektascensja(godziny, minuty, sekundy2);
                                    System.out.println("Podaj wielkość gwiazdową");
                                    double wielkoscGwiazdowa = scanner.nextDouble();
                                    System.out.println("Podaj odległość");
                                    double odleglosc = scanner.nextDouble();
                                    System.out.println("Podaj temperaturę");
                                    double temperatura = scanner.nextDouble();
                                    System.out.println("Podaj masę");
                                    double masa = scanner.nextDouble();
                                    gwiazdozbiory.get(i).gwiazdy.add(new Gwiazda(nazwaGwiazdy, deklinacja, rektascensja, wielkoscGwiazdowa, odleglosc, temperatura, masa));
                                    System.out.println("Czy chcesz dodać kolejną gwiazdę? (t/n)");

                                }
                        }

                    }

                    break;
                default:
                    System.out.println("Niepoprawna opcja");
                    break;
            }
        }
    }



}