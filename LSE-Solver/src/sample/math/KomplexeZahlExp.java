package sample.math;

public class KomplexeZahlExp {

	private double betrag;
	private double arg;

	public KomplexeZahlExp(){
		betrag = 0.0;
		arg = 0.0;
	}

	public KomplexeZahlExp(double betrag, double arg){
		this.betrag = betrag;
		this.arg = arg;
	}

	public void ExpAusgabe(KomplexeZahlExp exp){
		System.out.print("" + exp.betrag + " < " + exp.arg);
	}

    public String ExpAusgabeString(KomplexeZahlExp exp){
        return "" + exp.betrag + " < " + exp.arg;
    }

	public KomplexeZahlKartesisch UmwandelnExpAbi(KomplexeZahlExp a){
		double UImag = Math.sin(a.arg) * a.betrag;
		double UReal = Math.cos(a.arg) * a.betrag;

		KomplexeZahlKartesisch UKomplexeZahlKartesisch = new KomplexeZahlKartesisch(UReal, UImag);

		return UKomplexeZahlKartesisch;

	}

	public KomplexeZahlExp ExpAddieren(KomplexeZahlExp a, KomplexeZahlExp b){

		KomplexeZahlKartesisch a1 = new KomplexeZahlKartesisch();
		KomplexeZahlKartesisch b1 = new KomplexeZahlKartesisch();
		KomplexeZahlKartesisch c1 = new KomplexeZahlKartesisch();

		a1 = a.UmwandelnExpAbi(a);
		b1 = b.UmwandelnExpAbi(b);

		c1 = a1.AbiAddieren(a1, b1);

		KomplexeZahlExp c = new KomplexeZahlExp();

		c = c1.UmwandelnAbiExp(c1);

		return c;
	}

	public KomplexeZahlExp ExpSubtrahieren(KomplexeZahlExp a, KomplexeZahlExp b){

		KomplexeZahlKartesisch a1 = new KomplexeZahlKartesisch();
		KomplexeZahlKartesisch b1 = new KomplexeZahlKartesisch();
		KomplexeZahlKartesisch c1 = new KomplexeZahlKartesisch();

		a1 = a.UmwandelnExpAbi(a);
		b1 = b.UmwandelnExpAbi(b);

		c1 = a1.AbiSubtrahieren(a1, b1);

		KomplexeZahlExp c = new KomplexeZahlExp();

		c = c1.UmwandelnAbiExp(c1);

		return c;
	}

	public KomplexeZahlExp ExpMultiplizieren(KomplexeZahlExp a, KomplexeZahlExp b){

		double MBetrag = (a.betrag * b.betrag);
		double MArg = (a.arg + b.arg);

		KomplexeZahlExp MKomplexeZahlExp = new KomplexeZahlExp(MBetrag, MArg);

		return MKomplexeZahlExp;
	}

	public KomplexeZahlExp ExpDividieren(KomplexeZahlExp a, KomplexeZahlExp b){

		double DBetrag = (a.betrag / b.betrag);
		double DArg = (a.arg - b.arg);

		KomplexeZahlExp DKomplexeZahlExp = new KomplexeZahlExp(DBetrag, DArg);

		return DKomplexeZahlExp;
	}

	public KomplexeZahlExp ExpKonjugieren(KomplexeZahlExp a){

		double KBetrag = a.betrag;
		double KArg = a.arg * (-1);

		KomplexeZahlExp b = new KomplexeZahlExp(KBetrag, KArg);

		return b;
	}

}
