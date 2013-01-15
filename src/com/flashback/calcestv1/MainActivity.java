/**
 * Credits:
 * make folder / file: http://www.java-samples.com/showtutorial.php?tutorialid=1523
 * send feedback: http://stackoverflow.com/questions/11320685/how-to-implement-send-feedback-feature-in-android
 * textview hyperlink: http://stackoverflow.com/questions/9852184/android-textview-hyperlink
 * open url with button click: http://stackoverflow.com/questions/4930228/open-a-url-on-click-of-ok-button-in-android
 */

package com.flashback.calcestv1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
	    MenuInflater hardwaremenu = getMenuInflater();
	    hardwaremenu.inflate(R.menu.activity_main, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
	    switch (item.getItemId()){
	    case R.id.sendEmail:
	        Intent Email = new Intent(Intent.ACTION_SEND);
	        Email.setType("text/email");
	        Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "feedbackcalcest@gmail.com" });
	        Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
	        Email.putExtra(Intent.EXTRA_TEXT, "Vielen Dank für das testen meiner ersten App! Bitte sende mir deine Meinung! Angaben: Telefon/Android-OS/Pro/Kon/Anregungen! Danke! :-)");
	        startActivity(Intent.createChooser(Email, "Send Feedback:"));
	        return true;
	    case R.id.credits:
	    	setContentView(R.layout.credits);
	    	TextView tv = (TextView)findViewById(R.id.tvHPgoogle);
	    	tv.setText(Html.fromHtml("<a href=https://github.com/flashback2k12/CalcESTv1App> GITHUB "));
	        tv.setMovementMethod(LinkMovementMethod.getInstance());
	    	return true; 
	    }
		return false;
	}
		
	public void OpenGehaltsscheinActivity (View view){
		/*
		 * initialisierung Steuerjahr
		 */
		EditText F_SteuerJahr = (EditText)findViewById(R.id.etSteuerJahr);
		
		try{
		/*
		 * uebergabe Steuerjahr
		 */
		DataVorsorge.dvs.setSteuerJahr(Integer.parseInt(F_SteuerJahr.getText().toString()));
		/*
		 * oeffne naechte activity
		 */
		setContentView(R.layout.gehaltsschein);
		}
		catch (Exception e){
			Toast.makeText(getApplicationContext(), "integer wert verwenden", Toast.LENGTH_LONG).show();
		}
	}
	
	public void OpenWerbungsKostenActivity (View view){
		/*
		 * initialisierung gehaltsdaten
		 */
		EditText F_BruttoGehalt = (EditText)findViewById(R.id.etBruttoGehalt);
		EditText F_LohnSteuer = (EditText)findViewById(R.id.etLohnSteuer);
		EditText F_SolZ = (EditText)findViewById(R.id.etSolZ);
		EditText F_KV = (EditText)findViewById(R.id.etKV);
		EditText F_PV = (EditText)findViewById(R.id.etPV);
		EditText F_RV = (EditText)findViewById(R.id.etRV);
		EditText F_AV = (EditText)findViewById(R.id.etAV);
		
		try{
		/*
		 * uebergabe gehaltsdaten
		 */
		DataGehalt.dg.setBruttoGehalt(Double.parseDouble(F_BruttoGehalt.getText().toString())); 
		DataGehalt.dg.setLohnSteuer(Double.parseDouble(F_LohnSteuer.getText().toString()));
		DataGehalt.dg.setSoliZuschlag(Double.parseDouble(F_SolZ.getText().toString())); 
		DataGehalt.dg.setKrankenVers(Double.parseDouble(F_KV.getText().toString()));
		DataGehalt.dg.setPflegeVers(Double.parseDouble(F_PV.getText().toString()));
		DataGehalt.dg.setRentenVers(Double.parseDouble(F_RV.getText().toString()));
		DataGehalt.dg.setArbeitslosenVers(Double.parseDouble(F_AV.getText().toString()));
		/*
		 * oeffne naechte activity
		 */
		setContentView(R.layout.werbungskosten);
		} 
		catch (Exception e) {
			Toast.makeText(getApplicationContext(), "double wert verwenden", Toast.LENGTH_LONG).show();
		}
	}
	
	public void OpenVorsorgeActivity (View view){
		/*
		 * initialisierung werbungskosten
		 */
		EditText F_EntfernungWA = (EditText)findViewById(R.id.etEntfernungWA);
		EditText F_Arbeitstage = (EditText)findViewById(R.id.etArbeitstage);
		EditText F_SpendenGezahlt = (EditText)findViewById(R.id.etSpendenGezahlt);
		EditText F_ArbeitsmittelGezahlt = (EditText)findViewById(R.id.etArbeitsmittelGezahlt);
		EditText F_TelefonkostenGezahlt = (EditText)findViewById(R.id.etTelefonkostenGezahlt);
		
		try {
		/*
		 * uebergabe werbungskosten
		 */
		DataWK.dWK.setArbeitsTage(Integer.parseInt(F_Arbeitstage.getText().toString()));
		} 
		catch (Exception e1) {
			Toast.makeText(getApplicationContext(), "integer wert verwenden", Toast.LENGTH_LONG).show();
		}
		
		try{
		/*
		 * uebergabe werbungskosten
		 */
		DataWK.dWK.setEntfernungsKMWA(Double.parseDouble(F_EntfernungWA.getText().toString()));
		DataWK.dWK.setSpendenGezahlt(Double.parseDouble(F_SpendenGezahlt.getText().toString()));
		DataWK.dWK.setArbeitsMittelGezahlt(Double.parseDouble(F_ArbeitsmittelGezahlt.getText().toString()));
		DataWK.dWK.setTelefonKostenGezahlt(Double.parseDouble(F_TelefonkostenGezahlt.getText().toString())); 
		/*
		 * oeffne naechste activity
		 */
		setContentView(R.layout.vorsorge); 
		}
		catch (Exception e){
			Toast.makeText(getApplicationContext(), "double wert verwenden", Toast.LENGTH_LONG).show();
		}
	}
	
	public void OpenBrowserMaps (View view){
		/*
		 * oeffne browser zur berechnung der entfernungskilometer wohnung arbeit
		 */
		Uri uri = Uri.parse("https://maps.google.de/maps?hl=de&tab=wl");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
	
	public void OpenBrowserWK_ABC (View view){
		/*
		 * oeffne browser fuer tips fuer abzugsfähige werbungskosten
		 */
		Uri uri = Uri.parse("http://www.steuernsparen.de/steuerwiki/index.php/Werbungskosten");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
	
	public void OpenAgBelastungActivity (View view){
		/*
		 * initialisierung vorsorgeaufwand
		 */
		EditText F_HaftpflichtVers = (EditText)findViewById(R.id.etHaftpflicht);
		EditText F_UnfallVers = (EditText)findViewById(R.id.etUnfall); 
		EditText F_BuVers = (EditText)findViewById(R.id.etBU);
		EditText F_RuerupVers = (EditText)findViewById(R.id.etRuerup);
		EditText F_RiesterVers = (EditText)findViewById(R.id.etRiester);
		EditText F_LVmitKap = (EditText)findViewById(R.id.etLvMitKap);
		EditText F_LVohneKap = (EditText)findViewById(R.id.etLvOhneKap);
		
		try{
		/*
		 * uebergabe vorsorgeaufwand
		 */
		DataVorsorge.dvs.setHaftpflichtVers(Double.parseDouble(F_HaftpflichtVers.getText().toString())); 
		DataVorsorge.dvs.setUnfallVers(Double.parseDouble(F_UnfallVers.getText().toString()));
		DataVorsorge.dvs.setBerufUnfaehigsVers(Double.parseDouble(F_BuVers.getText().toString())); 
		DataVorsorge.dvs.setRuerupVers(Double.parseDouble(F_RuerupVers.getText().toString()));
		DataVorsorge.dvs.setRiesterVers(Double.parseDouble(F_RiesterVers.getText().toString()));
		DataVorsorge.dvs.setLebensVersMitKap(Double.parseDouble(F_LVmitKap.getText().toString()));
		DataVorsorge.dvs.setLebensVersOhneKap(Double.parseDouble(F_LVohneKap.getText().toString()));
		/*
		 * oeffne naechste activity
		 */
		setContentView(R.layout.agbelastung);
		}
		catch (Exception e){
			Toast.makeText(getApplicationContext(), "double wert verwenden", Toast.LENGTH_LONG).show();
		}
	}
	
	public void OpenAuswertungsActivity (View view) {
		/*
		 * initialisierung aussergewoehnliche belastungen
		 */
		EditText F_KrankheitskostenGezahlt = (EditText)findViewById(R.id.etKrankheitskostenGezahlt);
		/*
		 * initialisierung haushaltsnahe Dienstleistungen
		 */
		EditText F_HnDlMitAN = (EditText)findViewById(R.id.etHnDlMitAn);
		EditText F_HnDlOhneAN = (EditText)findViewById(R.id.etHnDlOhneAn);
		EditText F_HandwerkerLeistung = (EditText)findViewById(R.id.etHnDlHandwerker);
		
		try{
		/*
		 * uebergabe AGB
		 */
		DataAGB.agB.setKrankheitsKostenGezahlt(Double.parseDouble(F_KrankheitskostenGezahlt.getText().toString()));
		/*
		 * uebergabe hnDL
		 */
		DataAGB.agB.setHnDlKraftMitAN(Double.parseDouble(F_HnDlMitAN.getText().toString()));
		DataAGB.agB.setHnDlKraftOhneAN(Double.parseDouble(F_HnDlOhneAN.getText().toString()));
		DataAGB.agB.setHandwerkerLeistung(Double.parseDouble(F_HandwerkerLeistung.getText().toString()));
		/*
		 * oeffne naechste activity
		 */
		setContentView(R.layout.auswertung);
		}
		catch (Exception e){
			Toast.makeText(getApplicationContext(), "double wert verwenden", Toast.LENGTH_LONG).show();
		}
	}
	
	public void BerechneAuswertung (View view){
		/*
		 * ausgabe jahresbruttogehalt
		 */
		EditText F_JahresBrutto = (EditText)findViewById(R.id.etLine1);
		F_JahresBrutto.setText("JahresBrutto: "+DataGehalt.dg.getBruttoGehaltJahr());
//		DataBerechnung.db.setJahresBruttoGehalt(Double.parseDouble(F_JahresBrutto.getText().toString()));
		/*
		 * berechnung werbungskosten
		 */
		double mWerbungskosten = 0.0;
		int mArbeitstage = DataWK.dWK.getArbeitsTage();
		double mEntfernungWA = DataWK.dWK.getEntfernungsKMWA();
		double mArbeitsmittelGezahlt = DataWK.dWK.getArbeitsMittelGezahlt();
		double mTelefonkostenGezahlt = DataWK.dWK.getTelefonKostenGezahlt();
		
		mWerbungskosten = Berechne.WerbungsKosten(mArbeitstage, mEntfernungWA, mArbeitsmittelGezahlt, mTelefonkostenGezahlt);
		
		EditText F_Werbungskosten = (EditText)findViewById(R.id.etLine2);
		F_Werbungskosten.setText("Werbungskosten: " +Math.round(mWerbungskosten*100.00)/100.00);
//		DataBerechnung.db.setWerbungsKosten(Double.parseDouble(F_Werbungskosten.getText().toString()));
		/*
		 * berechnung summe einkuenfte
		 */
		double mSummeEinkunft = 0.0;
		double mBruttoJahresGehalt = DataGehalt.dg.getBruttoGehaltJahr();
		
		mSummeEinkunft = Berechne.SummeEinkunft(mBruttoJahresGehalt, mWerbungskosten);
	
		EditText F_SummeEinkunft = (EditText)findViewById(R.id.etLine3);
		F_SummeEinkunft.setText("Summe Einkuenfte: " +Math.round(mSummeEinkunft*100.00)/100.00);
//		DataBerechnung.db.setSummeEinkunft(Double.parseDouble(F_SummeEinkunft.getText().toString()));
		/*
		 * berechnung gesamtbetrag einkuenfte
		 */
		double mGesamtBetragEinkunft = 0.0;
		
		mGesamtBetragEinkunft = Berechne.GesamtbetragEinkunft(mSummeEinkunft);
		
		EditText F_GesamtBetragEinkunft = (EditText)findViewById(R.id.etLine4);
		F_GesamtBetragEinkunft.setText("Gesamtbetrag Einkuenfte: " + Math.round(mGesamtBetragEinkunft*100.00)/100.00);
//		DataBerechnung.db.setGesamtBetragEinkunft(Double.parseDouble(F_GesamtBetragEinkunft.getText().toString()));
		/*
		 * berechnung spenden
		 */
		double mSpendenGezahlt = DataWK.dWK.getSpendenGezahlt();
		double mSpendenAbzug = 0.0;
		
		mSpendenAbzug = Berechne.SpendenAbzug(mGesamtBetragEinkunft, mSpendenGezahlt);
		
		EditText F_SpendenAbzug = (EditText)findViewById(R.id.etLine5);
		F_SpendenAbzug.setText("Spendenabzug: " +Math.round(mSpendenAbzug*100.00)/100.00);
//		DataBerechnung.db.setSpendenAbzug(Double.parseDouble(F_SpendenAbzug.getText().toString()));
		/*
		 * berechnung aussergewoehnliche belastung
		 */
		double mKrankheitskostenGezahlt = DataAGB.agB.getKrankheitsKostenGezahlt();
		double mAgBelastungAbzug = 0.0;
		
		mAgBelastungAbzug = Berechne.agBelastungAbzug(mGesamtBetragEinkunft, mKrankheitskostenGezahlt);
		
		EditText F_agBelastungAbzug = (EditText)findViewById(R.id.etLine6);
		F_agBelastungAbzug.setText("aussergewoehnliche Belastung: " +Math.round(mAgBelastungAbzug*100.00)/100.00);
//		DataBerechnung.db.setAgBelastungAbzug(Double.parseDouble(F_agBelastungAbzug.getText().toString()));
		/*
		 * berechnung vorsorgeaufwendung
		 */
		int mSteuerJahr = DataVorsorge.dvs.getSteuerJahr(); 
		double mRVJahr = DataGehalt.dg.getRentenVersJahr();
		double mKVJahr = DataGehalt.dg.getKrankenVersJahr();
		double mPVJahr = DataGehalt.dg.getPflegeVersJahr();
		double mAVJahr = DataGehalt.dg.getArbeitslosenVersJahr();
		double mHV = DataVorsorge.dvs.getHaftpflichtVers();
		double mUV = DataVorsorge.dvs.getUnfallVers();
		double mBU = DataVorsorge.dvs.getBerufUnfaehigsVers();
		double mRuerup = DataVorsorge.dvs.getRuerupVers();
		double mLVmitKap = DataVorsorge.dvs.getLebensVersMitKap();
		double mLVohneKap = DataVorsorge.dvs.getLebensVersOhneKap();
		double mVorsorgeAufwand = 0.0;
		
		mVorsorgeAufwand = Berechne.vorsorgeAufwand(mSteuerJahr, mRVJahr, mKVJahr, mPVJahr, mAVJahr, mHV, mUV, mBU, mRuerup, mLVmitKap, mLVohneKap);
		
		EditText F_vorsorgeAufwand = (EditText)findViewById(R.id.etLine7); 
		F_vorsorgeAufwand.setText("Vorsorgeaufwand: " +Math.round(mVorsorgeAufwand*100.00)/100.00);	
//		DataBerechnung.db.setVorsorgeAufwandAbzug(Double.parseDouble(F_vorsorgeAufwand.getText().toString()));
		/*
		 * berechnung zuversteuerndes Einkommen
		 */
		double mZuVerstEinkommen = 0.0;
		
		mZuVerstEinkommen = Berechne.zuVerstEinkommen(mGesamtBetragEinkunft, mVorsorgeAufwand, mSpendenAbzug, mAgBelastungAbzug);
		
		EditText F_zuVerstEinkommen = (EditText)findViewById(R.id.etLine8);
		F_zuVerstEinkommen.setText("zu versteuerndes Einkommen: " +Math.round(mZuVerstEinkommen*100.00)/100.00);
//		DataBerechnung.db.setZuVerstEinkommen(Double.parseDouble(F_zuVerstEinkommen.getText().toString()));
		/*
		 * berechnung einkommensteuer
		 */
		double mEinkommensteuer = 0.0;
		
		mEinkommensteuer = Berechne.einkommenSteuer(mZuVerstEinkommen);
		
		EditText F_einkommenSteuer = (EditText)findViewById(R.id.etLine9);
		F_einkommenSteuer.setText("Einkommensteuer: " +Math.round(mEinkommensteuer*100.00)/100.00);
//		DataBerechnung.db.setEinkommenSteuer(Double.parseDouble(F_einkommenSteuer.getText().toString()));
		/*
		 * hole JahresLohnsteuerDaten
		 */
		EditText F_JahresLohnSteuer = (EditText)findViewById(R.id.etLine10);
		F_JahresLohnSteuer.setText("vorausbezahlte Steuer: "+DataGehalt.dg.getLohnSteuerJahr());
		/*
		 * berechne soliZuschlag
		 */
		double mSoliZuschlag = 0.0;
		double mKapitalSteuer = 0.0;
		
		mSoliZuschlag = Berechne.soliZuschlag(mZuVerstEinkommen, mKapitalSteuer, mEinkommensteuer); 
		
		EditText F_soliZuschlag = (EditText)findViewById(R.id.etLine11);
		F_soliZuschlag.setText("SoliZuschlag: " +Math.round(mSoliZuschlag*100.00)/100.00);
		/*
		 * hole JahresSoliZuschlag
		 */
		EditText F_JahresSoliZuschlag = (EditText)findViewById(R.id.etLine12);
		F_JahresSoliZuschlag.setText("vorausbezahlter Soli: "+DataGehalt.dg.getSoliZuschlagJahr());
		/*
		 * berechne haushaltsnahe dienstleistungsabzug 
		 */
		double mHnDlMitAN = DataAGB.agB.getHnDlKraftMitAN();
		double mHnDlOhneAN = DataAGB.agB.getHnDlKraftOhneAN();
		double mHandwerkerL = DataAGB.agB.getHandwerkerLeistung();
		double mHnDlAbzug = 0.0;
		
		mHnDlAbzug = Berechne.hnDlAbzug(mHnDlMitAN, mHnDlOhneAN, mHandwerkerL);
		
		EditText F_hnDlAbzug = (EditText)findViewById(R.id.etLine13);
		F_hnDlAbzug.setText("Abzug gemäß §35a EStG: " +Math.round(mHnDlAbzug*100.00)/100.00);
		/*
		 * berechnung nachzahlung / erstattung
		 */
		double mlohnSteuerJahr = DataGehalt.dg.getLohnSteuerJahr();
		double mSoliZuschlagJahr = DataGehalt.dg.getSoliZuschlagJahr();
		double mErgebnisBerechnung = 0.0;
				
		mErgebnisBerechnung = Berechne.ergebnisSteuer(mEinkommensteuer, mSoliZuschlag, mlohnSteuerJahr, mSoliZuschlagJahr, mHnDlAbzug);
		
		EditText F_ergebnisSteuer = (EditText)findViewById(R.id.etLine14);
		F_ergebnisSteuer.setText("Ergebnis: " +Math.round(mErgebnisBerechnung*100.00)/100.00);
//		DataBerechnung.db.setErgebnisBerechnung(Double.parseDouble(F_ergebnisSteuer.getText().toString()));
	}
	
		
	public void btnCreateFolder (View view){
		EditText txtCreateFolder = (EditText)findViewById(R.id.txtCreateFolder);
		String FeldtxtCreateFolder = txtCreateFolder.getText().toString();
		
		try {
			File newDir = new File(FeldtxtCreateFolder);
			if (!newDir.exists())
			{
				newDir.mkdir();
			}
			Toast.makeText(getBaseContext(),"Done creating folder",Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "No Folder created", Toast.LENGTH_LONG).show();
		}
		
	}
	
	public void btnCreateFile (View view){
		EditText txtFileDir = (EditText)findViewById(R.id.txtFileDir);
		EditText F_line1 = (EditText)findViewById(R.id.etLine1);
		EditText F_line2 = (EditText)findViewById(R.id.etLine2);
		EditText F_line3 = (EditText)findViewById(R.id.etLine3);
		EditText F_line4 = (EditText)findViewById(R.id.etLine4);
		EditText F_line5 = (EditText)findViewById(R.id.etLine5);
		EditText F_line6 = (EditText)findViewById(R.id.etLine6);
		EditText F_line7 = (EditText)findViewById(R.id.etLine7);
		EditText F_line8 = (EditText)findViewById(R.id.etLine8);
		EditText F_line9 = (EditText)findViewById(R.id.etLine9);
		EditText F_line10 = (EditText)findViewById(R.id.etLine10);
		EditText F_line11 = (EditText)findViewById(R.id.etLine11);
		EditText F_line12 = (EditText)findViewById(R.id.etLine12);
		EditText F_line13 = (EditText)findViewById(R.id.etLine13);
		EditText F_line14 = (EditText)findViewById(R.id.etLine14);
				
		String FeldtxtFileDir = txtFileDir.getText().toString(); 
		String line1 = F_line1.getText().toString();
		String line2 = F_line2.getText().toString();
		String line3 = F_line3.getText().toString();
		String line4 = F_line4.getText().toString();
		String line5 = F_line5.getText().toString();
		String line6 = F_line6.getText().toString();
		String line7 = F_line7.getText().toString();
		String line8 = F_line8.getText().toString();
		String line9 = F_line9.getText().toString();
		String line10 = F_line10.getText().toString();
		String line11 = F_line11.getText().toString();
		String line12 = F_line12.getText().toString();
		String line13 = F_line13.getText().toString();
		String line14 = F_line14.getText().toString();
				
		try {
			File myFile = new File(FeldtxtFileDir);
			myFile.createNewFile();
			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append("Auswertung");
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line1);
			myOutWriter.append("\n");
			myOutWriter.append(line2);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line3);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line4);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line5);
			myOutWriter.append("\n");
			myOutWriter.append(line6);
			myOutWriter.append("\n");
			myOutWriter.append(line7);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line8);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line9);
			myOutWriter.append("\n");
			myOutWriter.append(line10);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line11);
			myOutWriter.append("\n");
			myOutWriter.append(line12);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line13);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.append("\n");
			myOutWriter.append(line14);
			myOutWriter.append("\n");
			myOutWriter.append("--------------------------------------------");
			myOutWriter.close();
			fOut.close();
			Toast.makeText(getBaseContext(),"Done writing SD ",Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
		}
	}
	
	public void btnBack (View view){
		setContentView(R.layout.activity_main);
	}
}
