import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Main {
    public static void zapiszDoPliku(ArrayList<Gwiazdozbior> gwiazdozbiory) {
        try (FileWriter writer = new FileWriter("baza.json")) {
            Gson gson = new Gson();
            gson.toJson(gwiazdozbiory, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Gwiazdozbior> wczytajZPliku() {
        try (FileReader reader = new FileReader("baza.json")) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Gwiazdozbior>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        ArrayList<Gwiazdozbior> gwiazdozbiory = new ArrayList<Gwiazdozbior>();
        boolean czyKontynuowac = true;

        while (czyKontynuowac) {
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Wyświetl gwiazdozbiory");
            System.out.println("2. Dodaj gwiazdozbiór");
            System.out.println("3. Usuń gwiazdozbiór");
            System.out.println("4. Pokaż gwiazdy w gwiazdozbiorze");
            System.out.println("5. Dodaj gwiazdę do gwiazdozbioru");

            Scanner scanner = new Scanner(System.in);
            int wybranaOpcja = scanner.nextInt();

            switch (wybranaOpcja) {
                case 1:
                    clearConsole();
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                        }
                    }
                    break;

                case 2:
                    clearConsole();
                    String nazwaGwiazdozbioru = scanner.next();
                    gwiazdozbiory.add(new Gwiazdozbior(nazwaGwiazdozbioru));
                    break;

                case 3:
                    clearConsole();

                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        System.out.println(i + 1 + ". " + gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                    }
                    System.out.println("Usuń gwiazdozbiór");
                    int numer = scanner.nextInt();
                    gwiazdozbiory.remove(numer-1);

                    break;

                case 4:
                    clearConsole();
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        System.out.println(i + 1 + ". " + gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                    }
                    System.out.println("Wybierz gwiazdozbiór po numerze");
                    int numerGwiazdozbioru = scanner.nextInt();

                    for (int j = 0; j < gwiazdozbiory.get(numerGwiazdozbioru - 1).gwiazdy.size(); j++) {
                        System.out.println(gwiazdozbiory.get(numerGwiazdozbioru - 1).gwiazdy.get(j).nazwa);
                    }
                    break;

                case 5:
                    clearConsole();
                    System.out.println("Wybierz gwiazdozbiór");
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                        }
                    }
                    String wybranaNazwaGwiazdozbioru = scanner.next();

                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null && gwiazdozbiory.get(i).nazwaGwiazdozbioru.equals(wybranaNazwaGwiazdozbioru)) {
                            System.out.println("Podaj nazwę gwiazdy");
                            String nazwaGwiazdy = scanner.next();
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
                            scanner.nextLine();
                        }
                    }
                    break;

                default:
                    System.out.println("Niepoprawna opcja");
                    break;
            }

            // Ask the user if they want to continue
            System.out.println("Czy chcesz kontynuować? (Tak/Nie)");
            String odpowiedz = scanner.next().toLowerCase();
            czyKontynuowac = odpowiedz.equals("tak") || odpowiedz.equals("t");
        }
    }
}
