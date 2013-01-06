package com.flashback.calcestv1;


public class Berechne {

	public static double WerbungsKosten(int ArbeitsTage, double EntfernungWA,
			double ArbeitsMittelGezahlt, double TelefonKostenGezahlt) {

		double ENTFERNUNGSPAUSCHALE = 0.3;
		double KONTOFUEHRUNG = 16.0;
		double WerbungsKostenAbzug = 0.0;
		double ArbeitsMittelAbzug = 0.0;
		double TelefonKostenAbzug = 0.0;
		double WerbungsKostenGezahlt = 0.0;

		if (ArbeitsMittelGezahlt <= 110.0) 
		{
			ArbeitsMittelAbzug = 110.0;
		} 
		else {
			ArbeitsMittelAbzug = Math.round(ArbeitsMittelGezahlt * 100.00) / 100.00;
		}

		if (TelefonKostenGezahlt <= 240.0) {
			TelefonKostenAbzug = 240.0;
		} else {
			TelefonKostenAbzug = Math.round(TelefonKostenGezahlt * 100.00) / 100.00;
		}

		WerbungsKostenGezahlt = Math.round(((ArbeitsTage * EntfernungWA * ENTFERNUNGSPAUSCHALE) + KONTOFUEHRUNG
						+ ArbeitsMittelAbzug + TelefonKostenAbzug) * 100.00) / 100.00;

		if (WerbungsKostenGezahlt <= 1000.0) {
			WerbungsKostenAbzug = 1000.0;
		} else {
			WerbungsKostenAbzug = Math.round(WerbungsKostenGezahlt * 100.00) / 100.00;
		}
		return Math.round(WerbungsKostenAbzug * 100.00) / 100.00;
	}

	public static double SummeEinkunft(double JahresBruttoLohn,	double WerbungsKosten) {
		double SummeEinkunft = JahresBruttoLohn - WerbungsKosten;
		return Math.round(SummeEinkunft * 100.00) / 100.00;
	}
	
	public static double GesamtbetragEinkunft(double SummeEinkunft){
		double GesamtbetragEinkunft = SummeEinkunft;
		return Math.round(GesamtbetragEinkunft*100.00)/100.00;
	}
	
	public static double GesamtbetragEinkunftErweitert(double SummeEinkunft,double AlleinerziehendeFB, double AltersFB, double LandwirteFB){
		double GesamtbetragEinkunft = SummeEinkunft - AlleinerziehendeFB - AltersFB - LandwirteFB;
		return Math.round(GesamtbetragEinkunft*100.00)/100.00;
	}
	
	public static double SpendenAbzug (double GesamtBetragEinkunft, double SpendenGezahlt){
		
		double maxSpenden = GesamtBetragEinkunft*20/100;
		double spendenAbzug;
		
		if ((SpendenGezahlt >= 36) & (SpendenGezahlt <= maxSpenden))
		{
		spendenAbzug = SpendenGezahlt;
		return spendenAbzug; 
		}
		else if ((SpendenGezahlt >= 36) & (SpendenGezahlt >= maxSpenden))
		{
		spendenAbzug = maxSpenden;
		return spendenAbzug;
		}
		else
		{
		return spendenAbzug = 36;
		}
	}
	
	public static double agBelastungAbzug (double GesamtBetragEinkunft, double KrankheitskostenGezahlt){

		double zumutbareBelastung = 0.0;
		
		if ((GesamtBetragEinkunft == 0) & (GesamtBetragEinkunft <= 15340))
		{
		zumutbareBelastung = 0.05;
		}
		else if ((GesamtBetragEinkunft >= 15340) & (GesamtBetragEinkunft <= 51130))
		{
		zumutbareBelastung = 0.06;
		}
		else
		{
		zumutbareBelastung = 0.07;
		}
		
		double agB = (int) (Math.round((KrankheitskostenGezahlt - (GesamtBetragEinkunft * zumutbareBelastung))*100)/100.00);
		
		if (agB <= 0)
		{
		return 0.0;
		}
		else
		{
		return agB;
		}
	
	}
}
