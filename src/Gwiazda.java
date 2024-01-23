import java.util.regex.Pattern;

public class Gwiazda extends Gwiazdozbior {
    public String nazwa;
    public String nazwaKatalogowa;
    public String deklinacja;
    public String rektascensja;
    public String polkola;
    public double magnitudo;

    public double odleglosc;
    public double masa;

    public double absolutnaWielkoscGwiazdowa;
    public double temperatura;

    private String[] AlfabetGrecki = {"Alfa", "Beta", "Gamma", "Delta", "Epsilon", "Dzeta", "Eta", "Theta", "Jota", "Kappa", "Lambda", "My", "Ny", "Ksi", "Omicron", "Pi", "Rho", "Sigma", "Tau", "Ypsilon", "Fi", "Chi", "Psi", "Omega"};
    private Pattern pattern = Pattern.compile("^[A-Z]{3}\\d{4}$");

    public Gwiazda(String nazwa, Deklinacja deklinacja, Rektascensja rektascensja, double magnitudo, double odleglosc, double temperatura, double masa) {
        super("Wolarz");
        this.nazwa = Nazwa(nazwa);
        this.i = i + 1;
        this.nazwaKatalogowa = NazwaKatalogowa(nazwa);
        gwiazdy.add(this);
        this.deklinacja = deklinacja.deklinacja;
        this.polkola = deklinacja.polkola;
        this.rektascensja = rektascensja.rektascensja;
        this.magnitudo = Magnitudo(magnitudo);
        this.odleglosc = odleglosc;
        this.absolutnaWielkoscGwiazdowa = AbsolutnaWielkoscGwiazdowa(magnitudo, odleglosc);
        this.temperatura = Temperatura(temperatura);
        this.masa = Masa(masa);
    }

    public String Nazwa(String nazwa) {
        if (pattern.matcher(nazwa).matches()) {
            return nazwa;
        } else {
            return "Niepoprawna nazwa";
        }
    }

    public double AbsolutnaWielkoscGwiazdowa(double magnitudo, double odleglosc) {
        return magnitudo - 5 * Math.log10(odleglosc) + 5;
    }

    public double Masa(double masa) {
        if (masa >= 0.1 && masa <= 50) {
            return masa;
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }

    public double Temperatura(double value) {
        if (value <= 2000) {
            return value;
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }

    public double Magnitudo(double magnitudo) {
        if (magnitudo >= -26.74 && magnitudo <= 15.00) {
            return magnitudo;
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }

    public String NazwaKatalogowa(String nazwa) {
        return AlfabetGrecki[i - 1] + " " + nazwaGwiazdozbioru;
    }
    //zmiana jednostek na parseki
    public double getParsek() {
        return odleglosc / 3.26156;
    }

    public double getAWG() {
        return magnitudo - 5 * Math.log10(getParsek()) + 5;
    }
}





































//
//
//
//
//
//        zliczanie("/content/drive/MyDrive/test")
//
//
//
//
//
//        def swapp(dir_name, word:str, new_word:str):
//        l=[]
//        after_swapp=''
//        with open(dir_name,'r+') as f:
//        txt = f.read()
//
//        l=txt.split()
//        for el in range(len(l)):
//        if l[el].lower()==word.lower():
//        if l[el].islower():
//        l[el] =new_word.lower()
//        elif l[el].isupper() :
//        l[el] =new_word.upper()
//        elif l[el] ==word.capitalize():
//        l[el] =new_word.capitalize()
//
//        after_swapp ="".join([el for el in l])
//
//
//        with open(dir_name, "w") as wr:
//        wr.write(after_swapp)
//
//        #f.write(after_swapp)
//
//
//
//
//
//
//
//        swapp("/content/drive/MyDrive/test/biologia/swapp",'ala', 'Damian')
