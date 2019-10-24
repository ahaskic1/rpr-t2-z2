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
}
