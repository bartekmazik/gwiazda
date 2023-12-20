public class Deklinacja {
    public String deklinacja;
    public int stopnie;
    public int minuty;

    public String polkola;

    public double sekundy;

    public Deklinacja (int stopnie, int minuty, double sekundy) {
        this.stopnie = Stopnie(stopnie);
        this.minuty = Minuty(minuty);
        this.sekundy = Sekundy(sekundy);
        this.deklinacja = Deklinacja();
    }

    public String Deklinacja() {
        return stopnie + " stopni "+ minuty + " minut " + sekundy + " sekund";
    }
    public int Stopnie(int stopnie) {
        if (stopnie >= -90 && stopnie <= 0) {
            polkola = "południowe";
            return stopnie;
        } else if (stopnie >= 0 && stopnie <= 90) {
            polkola = "północne";
            return stopnie;
        }
        else {
            throw new IllegalArgumentException("Niepoprawna wartość");
        }
    }
    public int Minuty(int minuty) {
        if (minuty >= 0 && minuty <= 60) {
            return minuty;
        } else {
            return 0;
        }
    }
    public double Sekundy(double sekundy) {
        if (sekundy >= 0.0 && sekundy <= 60.0) {
            return sekundy;
        } else {
            return 0;
        }
    }
}
