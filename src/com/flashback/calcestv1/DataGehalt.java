package com.flashback.calcestv1;

public class DataGehalt {
	public static DataGehalt dg = new DataGehalt();

	private double bruttoGehalt;
	private double lohnSteuer;
	private double soliZuschlag;
	private double krankenVers;
	private double pflegeVers;
	private double arbeitslosenVers;
	private double rentenVers;

	/*
	 * Jahreswert ausgeben
	 */
	public double getBruttoGehaltJahr() {
		return bruttoGehalt * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setBruttoGehalt(double bruttoGehalt) {
		this.bruttoGehalt = bruttoGehalt;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getLohnSteuerJahr() {
		return lohnSteuer * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setLohnSteuer(double lohnSteuer) {
		this.lohnSteuer = lohnSteuer;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getSoliZuschlagJahr() {
		return soliZuschlag * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setSoliZuschlag(double soliZuschlag) {
		this.soliZuschlag = soliZuschlag;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getKrankenVersJahr() {
		return krankenVers * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setKrankenVers(double krankenVers) {
		this.krankenVers = krankenVers;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getPflegeVersJahr() {
		return pflegeVers * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setPflegeVers(double pflegeVers) {
		this.pflegeVers = pflegeVers;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getArbeitslosenVersJahr() {
		return arbeitslosenVers * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setArbeitslosenVers(double arbeitslosenVers) {
		this.arbeitslosenVers = arbeitslosenVers;
	}

	/*
	 * Jahreswert ausgeben
	 */
	public double getRentenVersJahr() {
		return rentenVers * 12;
	}

	/*
	 * Monatswert einlesen
	 */
	public void setRentenVers(double rentenVers) {
		this.rentenVers = rentenVers;
	}

}
