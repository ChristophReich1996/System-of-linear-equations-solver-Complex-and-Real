package sample.math;

public class KomplexeZahlKartesisch {

    private double real;
    private double imag;

    public KomplexeZahlKartesisch() {
        real = 0.0;
        imag = 0.0;
    }

    public KomplexeZahlKartesisch(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getRe(){
        return this.real;
    }

    public double getIm(){
        return this.imag;
    }

    public void setReal(double Re){
        this.real = Re;
    }

    public void setImag(double Im){
        this.imag = Im;
    }

    public void AbiAusgabe(KomplexeZahlKartesisch abi) {
        if (abi.imag < 0) {
            double a = abi.imag * (-1);
            System.out.print("" + abi.real + "-i*" + a);
        } else {
            System.out.print("" + abi.real + "+i*" + abi.imag);
        }
    }

    public String AbiAusgabeString(KomplexeZahlKartesisch abi) {

        String output = "";

        if (abi.imag < 0) {
            double a = abi.imag * (-1);
            output = ("" + abi.real + "-i*" + a);
        } else {
            output = ("" + abi.real + "+i*" + abi.imag);
        }
        return output;
    }

    public KomplexeZahlExp UmwandelnAbiExp(KomplexeZahlKartesisch a) {

        double UBetrag;
        double UArg;

        if ((a.imag == 0) && (a.real > 0)) {
            UBetrag = a.real;
            UArg = 0;
        }

        if ((a.imag == 0) && (a.real < 0)) {
            UBetrag = Math.abs(a.real);
            UArg = Math.PI;
        }

        if ((a.real == 0) && (a.imag > 0)) {
            UBetrag = a.imag;
            UArg = Math.PI / 2;
        }

        if ((a.real == 0) && (a.imag < 0)) {
            UBetrag = Math.abs(a.imag);
            UArg = Math.PI / 2;
        }

        if ((a.real == 0) && (a.imag == 0)) {
            UBetrag = 0;
            UArg = 0;
        } else {
            UBetrag = Math.sqrt(Math.pow(a.real, 2) + Math.pow(a.imag, 2));
            UArg = Math.atan(((a.imag) / (a.real)));

            if ((a.real < 0) && (a.imag > 0)) {
                UArg = Math.PI + UArg;
            }

            if ((a.real < 0) && (a.imag < 0)) {
                UArg = Math.PI + UArg;
            }

            if ((a.real > 0) && (a.imag < 0)) {
                UArg = (2 * Math.PI) + UArg;
            }
        }


        KomplexeZahlExp UKomplexeZahlExp = new KomplexeZahlExp(UBetrag, UArg);

        return UKomplexeZahlExp;
    }

    public KomplexeZahlKartesisch AbiAddieren(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b) {

        double AReal = (a.real + b.real);
        double AImag = (a.imag + b.imag);

        KomplexeZahlKartesisch AKomplexeZahlKartesisch = new KomplexeZahlKartesisch(AReal, AImag);

        return AKomplexeZahlKartesisch;
    }

    public KomplexeZahlKartesisch AbiAddieren3(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b, KomplexeZahlKartesisch c) {

        double AReal = (a.real + b.real + c.real);
        double AImag = (a.imag + b.imag + c.imag);

        KomplexeZahlKartesisch AKomplexeZahlKartesisch = new KomplexeZahlKartesisch(AReal, AImag);

        return AKomplexeZahlKartesisch;
    }

    public KomplexeZahlKartesisch AbiSubtrahieren(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b) {

        double AReal = (a.real - b.real);
        double AImag = (a.imag - b.imag);

        KomplexeZahlKartesisch AKomplexeZahlKartesisch = new KomplexeZahlKartesisch(AReal, AImag);

        return AKomplexeZahlKartesisch;
    }

    public KomplexeZahlKartesisch AbiSubtrahieren3(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b, KomplexeZahlKartesisch c) {

        double AReal = (a.real - b.real - c.real);
        double AImag = (a.imag - b.imag - c.imag);

        KomplexeZahlKartesisch AKomplexeZahlKartesisch = new KomplexeZahlKartesisch(AReal, AImag);

        return AKomplexeZahlKartesisch;
    }

    public KomplexeZahlKartesisch AbiMultiplizieren(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b) {

        double MReal = ((a.real * b.real) - (a.imag * b.imag));
        double MImag = ((a.real * b.imag) + (a.imag * b.real));

        KomplexeZahlKartesisch MKomplexeZahlKartesisch = new KomplexeZahlKartesisch(MReal, MImag);

        return MKomplexeZahlKartesisch;
    }

    public KomplexeZahlKartesisch AbiDividieren(KomplexeZahlKartesisch a, KomplexeZahlKartesisch b) {

        double DReal = (a.real * b.real + a.imag * b.imag) / (b.real * b.real + b.imag * b.imag);
        double DImag = (b.real * a.imag - a.real * b.imag) / (b.real * b.real + b.imag * b.imag);

        KomplexeZahlKartesisch c = new KomplexeZahlKartesisch(DReal, DImag);

        return c;
		
		/*KomplexeZahlExp a1 = new KomplexeZahlExp();
		KomplexeZahlExp b1 = new KomplexeZahlExp();
		KomplexeZahlExp c1 = new KomplexeZahlExp();
		
		a1 = a.UmwandelnAbiExp(a);
		b1 = b.UmwandelnAbiExp(b);
		
		c1 = a1.ExpDividieren(a1, b1);
		
		KomplexeZahlKartesisch d = new KomplexeZahlKartesisch();
		
		d = c1.UmwandelnExpAbi(c1);
		
		return d;
		*/
    }

    public KomplexeZahlKartesisch AbiKonjugieren(KomplexeZahlKartesisch a) {

        double KReal = a.real;
        double KImag = a.imag * (-1);

        KomplexeZahlKartesisch b = new KomplexeZahlKartesisch(KReal, KImag);

        return b;
    }
}






