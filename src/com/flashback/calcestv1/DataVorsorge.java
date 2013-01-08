package com.flashback.calcestv1;

public class DataVorsorge {

	public static DataVorsorge dvs = new DataVorsorge();
	
	private int steuerJahr;
	private double RuerupVers;
	private double RiesterVers;
	private double BerufUnfaehigsVers;
	private double UnfallVers;
	private double HaftpflichtVers;
	private double LebensVersMitKap;
	private double LebensVersOhneKap;
	
	
	public int getSteuerJahr() {
		return steuerJahr;
	}

	public void setSteuerJahr(int steuerJahr) {
		this.steuerJahr = steuerJahr;
	}
	
	public double getRuerupVers() {
		return RuerupVers;
	}

	public void setRuerupVers(double ruerupVers) {
		RuerupVers = ruerupVers;
	}

	public double getRiesterVers() {
		return RiesterVers;
	}

	public void setRiesterVers(double riesterVers) {
		RiesterVers = riesterVers;
	}

	public double getBerufUnfaehigsVers() {
		return BerufUnfaehigsVers;
	}

	public void setBerufUnfaehigsVers(double berufUnfaehigsVers) {
		BerufUnfaehigsVers = berufUnfaehigsVers;
	}

	public double getUnfallVers() {
		return UnfallVers;
	}

	public void setUnfallVers(double unfallVers) {
		UnfallVers = unfallVers;
	}

	public double getHaftpflichtVers() {
		return HaftpflichtVers;
	}

	public void setHaftpflichtVers(double haftpflichtVers) {
		HaftpflichtVers = haftpflichtVers;
	}

	public double getLebensVersMitKap() {
		return LebensVersMitKap;
	}

	public void setLebensVersMitKap(double lebensVersMitKap) {
		LebensVersMitKap = lebensVersMitKap;
	}

	public double getLebensVersOhneKap() {
		return LebensVersOhneKap;
	}

	public void setLebensVersOhneKap(double lebensVersOhneKap) {
		LebensVersOhneKap = lebensVersOhneKap;
	}

}
