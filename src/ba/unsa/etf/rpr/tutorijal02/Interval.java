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

    public static Interval intersect(Interval i, Interval i2) {
        return i.intersect(i2);
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

    public Interval intersect(Interval interval) {
        Interval vrati = new Interval();
        if(interval.pocetnaTacka >= this.pocetnaTacka && interval.pocetnaTacka <= this.krajnjaTacka && interval.krajnjaTacka >= this.krajnjaTacka){
            vrati.pocetnaTacka = interval.pocetnaTacka;
            vrati.krajnjaTacka = this.krajnjaTacka;
            if(interval.pocetak)    vrati.pocetak = true;
            else    vrati.pocetak = false;
            if(this.kraj)   vrati.kraj = true;
            else    vrati.kraj = false;
        }
        if(interval.pocetnaTacka <= this.pocetnaTacka && interval.krajnjaTacka >= this.pocetnaTacka && interval.krajnjaTacka <= this.krajnjaTacka){
            vrati.pocetnaTacka = this.pocetnaTacka;
            vrati.krajnjaTacka = interval.krajnjaTacka;
            if(this.pocetak)    vrati.pocetak = true;
            else    vrati.pocetak = false;
            if(interval.kraj)   vrati.kraj = true;
            else    vrati.kraj = false;
        }
        if(this.pocetnaTacka < interval.pocetnaTacka && interval.krajnjaTacka > this.krajnjaTacka && this.krajnjaTacka == interval.pocetnaTacka && (this.kraj == true || interval.pocetak == true)){
            vrati.pocetnaTacka = this.krajnjaTacka;
            vrati.krajnjaTacka = interval.pocetnaTacka;
            if(this.kraj)   vrati.pocetak = true;
            else if(interval.pocetak)   vrati.kraj = true;
            else vrati.pocetak = true;
        }
        if(this.pocetnaTacka > interval.pocetnaTacka && interval.krajnjaTacka < this.krajnjaTacka && this.krajnjaTacka == interval.pocetnaTacka && (this.kraj == true || interval.pocetak == true)){
            vrati.pocetnaTacka = interval.krajnjaTacka;
            vrati.krajnjaTacka = this.pocetnaTacka;
            if(this.pocetak)   vrati.kraj = true;
            else if(interval.kraj)   vrati.pocetak = true;
            else vrati.pocetak = true;
        }
        if(interval.pocetnaTacka >= this.pocetnaTacka && interval.krajnjaTacka <= this.krajnjaTacka) {
            return interval;
        }
        return vrati;
    }
}
