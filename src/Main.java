import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Main {


   public static void wyszukajGwiazdy(String opcja, ArrayList<Gwiazdozbior> gwiazdozbiory){
       Scanner scanner = new Scanner(System.in);
       switch (opcja){
           case "parsek":
               System.out.println("Podaj odległość w parsekach");

               double podanaOdleglosc = scanner.nextDouble();
               for (int i = 0; i < gwiazdozbiory.size(); i++) {
                   for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                       if (gwiazdozbiory.get(i).gwiazdy.get(j).getParsek() <= podanaOdleglosc) {
                          System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                       }
                   }
               }
                break;
           // Wyszukiwanie gwiazd w podanym zakresie temperatury
           case "temperatura":
                System.out.println("Podaj zakres  temperatury");
                System.out.print("Od: ");
                double podanaTemperaturaOd = scanner.nextDouble();
                System.out.println("Do: ");
                double podanaTemperaturaDo = scanner.nextDouble();
                for (int i = 0; i < gwiazdozbiory.size(); i++) {
                     for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                          if (gwiazdozbiory.get(i).gwiazdy.get(j).temperatura >= podanaTemperaturaOd &&
                                  gwiazdozbiory.get(i).gwiazdy.get(j).temperatura <= podanaTemperaturaDo) {
                            System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                          }
                     }
                }
                break;
           // Wyszukiwanie gwiazd w podanym zakresie wielkości gwiazdowej
              case "wielkoscGwiazdowa":
                System.out.println("Podaj zakres wielkości gwiazdowej");
                System.out.print("Od: ");
                double podanaWielkoscGwiazdowaOd = scanner.nextDouble();
                System.out.println("Do: ");
                double podanaWielkoscGwiazdowaDo = scanner.nextDouble();
                for (int i = 0; i < gwiazdozbiory.size(); i++) {
                     for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                          if (gwiazdozbiory.get(i).gwiazdy.get(j).magnitudo >= podanaWielkoscGwiazdowaOd &&
                                  gwiazdozbiory.get(i).gwiazdy.get(j).magnitudo <= podanaWielkoscGwiazdowaDo) {
                            System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                          }
                     }
                }
                break;
           case "polkula":
                System.out.println("Podaj numer opcji");
                System.out.println("1. Północna");
                System.out.println("2. Południowa");
                int wybranaOpcja = scanner.nextInt();
               // Przeszukiwanie gwiazd w gwiazdozbiorze zgodnie z wybraną półkulą
                switch (wybranaOpcja){
                    case 1:
                        for (int i = 0; i < gwiazdozbiory.size(); i++) {
                            for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                                if (gwiazdozbiory.get(i).gwiazdy.get(j).polkola.equals("północne")) {
                                    System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < gwiazdozbiory.size(); i++) {
                            for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                                if (gwiazdozbiory.get(i).gwiazdy.get(j).polkola.equals("południowe")) {
                                    System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Niepoprawna opcja");
                        break;
                }
                break;
           // Wyszukiwanie potencjalnych supernowych
           case "supernowa":
               System.out.println("Potencjalne supernowe: ");
                for (int i = 0; i < gwiazdozbiory.size(); i++) {
                     for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
                          if (gwiazdozbiory.get(i).gwiazdy.get(j).masa >1.44) {
                              System.out.println(gwiazdozbiory.get(i).gwiazdy.get(j).nazwa);
                          }
                     }
                }
                 break;
           default:
                System.out.println("Niepoprawna opcja");
                break;






       }
   }

   public static void usunGwiazde(String nazwaGwiazdy, ArrayList<Gwiazdozbior> gwiazdozbiory) {
       for (int i = 0; i < gwiazdozbiory.size(); i++) {
           for (int j = 0; j < gwiazdozbiory.get(i).gwiazdy.size(); j++) {
               if (gwiazdozbiory.get(i).gwiazdy.get(j).nazwa.equals(nazwaGwiazdy)) {
                   gwiazdozbiory.get(i).gwiazdy.remove(j);
               }
           }
       }
    }
    // Funkcja do serializacji danych do pliku JSON
   public static void Serializacja(ArrayList<Gwiazdozbior> gwiazdozbiory) {
       try {
           FileWriter fileWriter = new FileWriter("gwiazdozbiory.json");
           Gson gson = new Gson();
           gson.toJson(gwiazdozbiory, fileWriter);
           fileWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
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
            System.out.println("6. Wyszukaj gwiazdy");

            Scanner scanner = new Scanner(System.in);
            int wybranaOpcja = scanner.nextInt();

            switch (wybranaOpcja) {
                case 1:
                    //Wyswietlenie gwiazdozbiorów
                    clearConsole();
                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        if (gwiazdozbiory.get(i) != null) {
                            System.out.println(gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                        }
                    }
                    break;

                case 2:
                    //Dodanie gwiazdozbioru
                    clearConsole();
                    String nazwaGwiazdozbioru = scanner.next();
                    gwiazdozbiory.add(new Gwiazdozbior(nazwaGwiazdozbioru));
                    break;

                case 3:
                    //Usunięcie gwiazdozbioru
                    clearConsole();

                    for (int i = 0; i < gwiazdozbiory.size(); i++) {
                        System.out.println(i + 1 + ". " + gwiazdozbiory.get(i).nazwaGwiazdozbioru);
                    }
                    System.out.println("Usuń gwiazdozbiór");
                    int numer = scanner.nextInt();
                    gwiazdozbiory.remove(numer-1);

                    break;

                case 4:
                    //Wyświetlenie gwiazd w gwiazdozbiorze
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
                    //Dodanie gwiazdy do gwiazdozbioru
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
                case 6:
                    //Wyszukiwanie gwiazd
                    clearConsole();
                    System.out.println("Wybierz opcję");
                    System.out.println("1. Wyszukaj gwiazdy w podanym gwiazdozbiorze");
                    System.out.println("2. Wyszukaj gwiazdy w podanym zakresie temperatury");
                    System.out.println("3. Wyszukaj gwiazdy w podanym zakresie wielkości gwiazdowej");
                    System.out.println("4. Wyszukaj gwiazdy w podanym zakresie parseków");
                    System.out.println("5. Wyszukaj gwiazdy w podanej półkuli");
                    System.out.println("6. Wyszukaj potencjalne supernowe");
                    String wybranaOpcjaWyszukiwania = scanner.next();
                    wyszukajGwiazdy(wybranaOpcjaWyszukiwania, gwiazdozbiory);
                    break;
                case 7:
                    //Usuwanie gwiazdy
                    clearConsole();
                    System.out.println("Podaj nazwę gwiazdy");
                    String nazwaGwiazdy = scanner.next();
                    usunGwiazde(nazwaGwiazdy, gwiazdozbiory);
                    break;

                default:
                    System.out.println("Niepoprawna opcja");
                    break;
            }


            System.out.println("Czy chcesz kontynuować? (Tak/Nie)");
            String odpowiedz = scanner.next().toLowerCase();
            czyKontynuowac = odpowiedz.equals("tak") || odpowiedz.equals("t");
            Serializacja(gwiazdozbiory);
        }

    }
}
