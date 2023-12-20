public class Rektascensja {
    public String rektascensja;
    public int godziny;
    public int minuty;

    public int sekundy;

    public Rektascensja (int godziny, int minuty, int sekundy) {
        this.godziny = Godziny(godziny);
        this.minuty = Minuty(minuty);
        this.sekundy = Sekundy(sekundy);
        this.rektascensja = Rektascensja();
    }
    public String Rektascensja() {
        return godziny + " godzin "+ minuty + " minut " + sekundy + " sekund";
    }
    public int Godziny(int godziny) {
        if (godziny >= 0 && godziny <24) {
            return godziny;
        }
        else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }
    public int Minuty(int minuty) {
        if (minuty >= 0 && minuty < 60) {
            return minuty;
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }
    public int Sekundy(int sekundy) {
        if (sekundy >= 0 && sekundy < 60) {
            return sekundy;
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }
}
