package com.flashback.calcestv1;

public class DataAGB {

	public static DataAGB agB = new DataAGB();
	
	private double KrankheitsKostenGezahlt;
	private double HnDlKraftMitAN;
	private double HnDlKraftOhneAN;
	private double HandwerkerLeistung;
	
	public double getKrankheitsKostenGezahlt() {
		return KrankheitsKostenGezahlt;
	}

	public void setKrankheitsKostenGezahlt(double krankheitsKostenGezahlt) {
		KrankheitsKostenGezahlt = krankheitsKostenGezahlt;
	}

	public double getHnDlKraftMitAN() {
		return HnDlKraftMitAN;
	}

	public void setHnDlKraftMitAN(double hnDlKraftMitAN) {
		HnDlKraftMitAN = hnDlKraftMitAN;
	}

	public double getHnDlKraftOhneAN() {
		return HnDlKraftOhneAN;
	}

	public void setHnDlKraftOhneAN(double hnDlKraftOhneAN) {
		HnDlKraftOhneAN = hnDlKraftOhneAN;
	}

	public double getHandwerkerLeistung() {
		return HandwerkerLeistung;
	}

	public void setHandwerkerLeistung(double handwerkerLeistung) {
		HandwerkerLeistung = handwerkerLeistung;
	}

	
}
