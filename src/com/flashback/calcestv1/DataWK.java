package com.flashback.calcestv1;

public class DataWK {

	public static DataWK dWK = new DataWK();

	private int ArbeitsTage;
	private double EntfernungsKMWA;
	private double SpendenGezahlt;
	private double ArbeitsMittelGezahlt;
	private double TelefonKostenGezahlt;

	
	public int getArbeitsTage() {
		return ArbeitsTage;
	}

	public void setArbeitsTage(int arbeitsTage) {
		ArbeitsTage = arbeitsTage;
	}

	public double getEntfernungsKMWA() {
		return EntfernungsKMWA;
	}

	public void setEntfernungsKMWA(double entfernungsKMWA) {
		EntfernungsKMWA = entfernungsKMWA;
	}

	public double getSpendenGezahlt() {
		return SpendenGezahlt;
	}

	public void setSpendenGezahlt(double spendenGezahlt) {
		SpendenGezahlt = spendenGezahlt;
	}

	public double getArbeitsMittelGezahlt() {
		return ArbeitsMittelGezahlt;
	}

	public void setArbeitsMittelGezahlt(double arbeitsMittelGezahlt) {
		ArbeitsMittelGezahlt = arbeitsMittelGezahlt;
	}

	public double getTelefonKostenGezahlt() {
		return TelefonKostenGezahlt;
	}

	public void setTelefonKostenGezahlt(double telefonKostenGezahlt) {
		TelefonKostenGezahlt = telefonKostenGezahlt;
	}


}
