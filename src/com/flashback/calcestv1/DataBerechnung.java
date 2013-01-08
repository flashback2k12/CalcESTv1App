package com.flashback.calcestv1;

public class DataBerechnung {

	public static DataBerechnung db = new DataBerechnung();
	
	private double JahresBruttoGehalt;
	private double WerbungsKosten;
	private double SummeEinkunft;
	private double GesamtBetragEinkunft;
	private double SpendenAbzug;
	private double agBelastungAbzug;
	private double vorsorgeAufwandAbzug;
	private double zuVerstEinkommen;
	private double einkommenSteuer;
	private double ergebnisBerechnung;
	

	public double getJahresBruttoGehalt() {
		return JahresBruttoGehalt;
	}

	public void setJahresBruttoGehalt(double jahresBruttoGehalt) {
		JahresBruttoGehalt = jahresBruttoGehalt;
	}

	public double getWerbungsKosten() {
		return WerbungsKosten;
	}

	public void setWerbungsKosten(double werbungsKosten) {
		WerbungsKosten = werbungsKosten;
	}

	public double getSummeEinkunft() {
		return SummeEinkunft;
	}

	public void setSummeEinkunft(double summeEinkunft) {
		SummeEinkunft = summeEinkunft;
	}
	
	public double getGesamtBetragEinkunft() {
		return GesamtBetragEinkunft;
	}

	public void setGesamtBetragEinkunft(double gesamtBetragEinkunft) {
		GesamtBetragEinkunft = gesamtBetragEinkunft;
	}

	public double getSpendenAbzug() {
		return SpendenAbzug;
	}

	public void setSpendenAbzug(double spendenAbzug) {
		SpendenAbzug = spendenAbzug;
	}

	public double getAgBelastungAbzug() {
		return agBelastungAbzug;
	}

	public void setAgBelastungAbzug(double agBelastungAbzug) {
		this.agBelastungAbzug = agBelastungAbzug;
	}

	public double getVorsorgeAufwandAbzug() {
		return vorsorgeAufwandAbzug;
	}

	public void setVorsorgeAufwandAbzug(double vorsorgeAufwandAbzug) {
		this.vorsorgeAufwandAbzug = vorsorgeAufwandAbzug;
	}

	public double getZuVerstEinkommen() {
		return zuVerstEinkommen;
	}

	public void setZuVerstEinkommen(double zuVerstEinkommen) {
		this.zuVerstEinkommen = zuVerstEinkommen;
	}

	public double getEinkommenSteuer() {
		return einkommenSteuer;
	}

	public void setEinkommenSteuer(double einkommenSteuer) {
		this.einkommenSteuer = einkommenSteuer;
	}

	public double getErgebnisBerechnung() {
		return ergebnisBerechnung;
	}

	public void setErgebnisBerechnung(double ergebnisBerechnung) {
		this.ergebnisBerechnung = ergebnisBerechnung;
	}

	
}
