package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetak;
    private boolean kraj;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetak, boolean kraj) {
        if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("Pocetna tacka veca od krajnje.");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pocetak = false;
        this.kraj = false;
    }


    public boolean isIn(double v) {
        if(pocetak == true && kraj == true && pocetnaTacka <= v && krajnjaTacka >= v)   return true;
        if(pocetak == true && kraj == false && pocetnaTacka <= v && krajnjaTacka > v)   return true;
        if(pocetak == false && kraj == true && pocetnaTacka < v && krajnjaTacka >= v)   return true;
        if(pocetak == false && kraj == false && pocetnaTacka < v && krajnjaTacka > v)   return true;
        return false;
    }

    public boolean isNull() {
        if(pocetak == false && kraj == false && pocetnaTacka == 0 && krajnjaTacka == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        if(this.isNull()){
            return "()";
        }
        String vratiti = new String();
        if(pocetak == true) vratiti += "[";
        else    vratiti += "(";
        vratiti += pocetnaTacka + "," + krajnjaTacka;
        if(kraj == true) vratiti += "]";
        else    vratiti += ")";
        return vratiti;
    }
}
