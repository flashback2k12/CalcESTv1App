package com.flashback.calcestv1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
/*
	EditText f_line1;
	EditText f_line2;
	EditText f_line3;
	EditText f_line4;
	EditText f_line5;
	EditText f_line6;
	EditText f_line7;
	EditText f_line8;
	EditText f_line9;
	EditText f_line10;
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		f_line1 = (EditText)findViewById(R.id.etLine1);
//		f_line2 = (EditText)findViewById(R.id.etLine2);
//		f_line3 = (EditText)findViewById(R.id.etLine3);
//		f_line4 = (EditText)findViewById(R.id.etLine4);
//		f_line5 = (EditText)findViewById(R.id.etLine5);
//		f_line6 = (EditText)findViewById(R.id.etLine6);
//		f_line7 = (EditText)findViewById(R.id.etLine7);
//		f_line8 = (EditText)findViewById(R.id.etLine8);
//		f_line9 = (EditText)findViewById(R.id.etLine9);
//		f_line10 = (EditText)findViewById(R.id.etLine10);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
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
		
		try{
		/*
		 * uebergabe AGB
		 */
		DataAGB.agB.setKrankheitsKostenGezahlt(Double.parseDouble(F_KrankheitskostenGezahlt.getText().toString()));
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
		TextView F_JahresBrutto = (TextView)findViewById(R.id.textView2);
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
		
		TextView F_Werbungskosten = (TextView)findViewById(R.id.textView3);
		F_Werbungskosten.setText("Werbungskosten: " +Math.round(mWerbungskosten*100.00)/100.00);
//		DataBerechnung.db.setWerbungsKosten(Double.parseDouble(F_Werbungskosten.getText().toString()));
		/*
		 * berechnung summe einkuenfte
		 */
		double mSummeEinkunft = 0.0;
		double mBruttoJahresGehalt = DataGehalt.dg.getBruttoGehaltJahr();
		
		mSummeEinkunft = Berechne.SummeEinkunft(mBruttoJahresGehalt, mWerbungskosten);
	
		TextView F_SummeEinkunft = (TextView)findViewById(R.id.textView4);
		F_SummeEinkunft.setText("Summe Einkuenfte: " +Math.round(mSummeEinkunft*100.00)/100.00);
//		DataBerechnung.db.setSummeEinkunft(Double.parseDouble(F_SummeEinkunft.getText().toString()));
		/*
		 * berechnung gesamtbetrag einkuenfte
		 */
		double mGesamtBetragEinkunft = 0.0;
		
		mGesamtBetragEinkunft = Berechne.GesamtbetragEinkunft(mSummeEinkunft);
		
		TextView F_GesamtBetragEinkunft = (TextView)findViewById(R.id.textView5);
		F_GesamtBetragEinkunft.setText("Gesamtbetrag Einkuenfte: " + Math.round(mGesamtBetragEinkunft*100.00)/100.00);
//		DataBerechnung.db.setGesamtBetragEinkunft(Double.parseDouble(F_GesamtBetragEinkunft.getText().toString()));
		/*
		 * berechnung spenden
		 */
		double mSpendenGezahlt = DataWK.dWK.getSpendenGezahlt();
		double mSpendenAbzug = 0.0;
		
		mSpendenAbzug = Berechne.SpendenAbzug(mGesamtBetragEinkunft, mSpendenGezahlt);
		
		TextView F_SpendenAbzug = (TextView)findViewById(R.id.textView6);
		F_SpendenAbzug.setText("Spendenabzug: " +Math.round(mSpendenAbzug*100.00)/100.00);
//		DataBerechnung.db.setSpendenAbzug(Double.parseDouble(F_SpendenAbzug.getText().toString()));
		/*
		 * berechnung aussergewoehnliche belastung
		 */
		double mKrankheitskostenGezahlt = DataAGB.agB.getKrankheitsKostenGezahlt();
		double mAgBelastungAbzug = 0.0;
		
		mAgBelastungAbzug = Berechne.agBelastungAbzug(mGesamtBetragEinkunft, mKrankheitskostenGezahlt);
		
		TextView F_agBelastungAbzug = (TextView)findViewById(R.id.textView7);
		F_agBelastungAbzug.setText("außergewöhnliche Belastung: " +Math.round(mAgBelastungAbzug*100.00)/100.00);
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
		
		TextView F_vorsorgeAufwand = (TextView)findViewById(R.id.textView8); 
		F_vorsorgeAufwand.setText("Vorsorgeaufwand: " +Math.round(mVorsorgeAufwand*100.00)/100.00);	
//		DataBerechnung.db.setVorsorgeAufwandAbzug(Double.parseDouble(F_vorsorgeAufwand.getText().toString()));
		/*
		 * berechnung zuversteuerndes Einkommen
		 */
		double mZuVerstEinkommen = 0.0;
		
		mZuVerstEinkommen = Berechne.zuVerstEinkommen(mGesamtBetragEinkunft, mVorsorgeAufwand, mSpendenAbzug, mAgBelastungAbzug);
		
		TextView F_zuVerstEinkommen = (TextView)findViewById(R.id.textView10);
		F_zuVerstEinkommen.setText("zu versteuerndes Einkommen: " +Math.round(mZuVerstEinkommen*100.00)/100.00);
//		DataBerechnung.db.setZuVerstEinkommen(Double.parseDouble(F_zuVerstEinkommen.getText().toString()));
		/*
		 * berechnung einkommensteuer
		 */
		double mEinkommensteuer = 0.0;
		
		mEinkommensteuer = Berechne.einkommenSteuer(mZuVerstEinkommen);
		
		TextView F_einkommenSteuer = (TextView)findViewById(R.id.textView11);
		F_einkommenSteuer.setText("Einkommensteuer: " +Math.round(mEinkommensteuer*100.00)/100.00);
//		DataBerechnung.db.setEinkommenSteuer(Double.parseDouble(F_einkommenSteuer.getText().toString()));
		/*
		 * berechnung nachzahlung / erstattung
		 */
		double mlohnSteuerJahr = DataGehalt.dg.getLohnSteuerJahr();
		double mErgebnisBerechnung = 0.0;
				
		mErgebnisBerechnung = Berechne.ergebnisSteuer(mEinkommensteuer, mlohnSteuerJahr);
		
		TextView F_ergebnisSteuer = (TextView)findViewById(R.id.textView12);
		F_ergebnisSteuer.setText("Ergebnis: " +Math.round(mErgebnisBerechnung*100.00)/100.00);
//		DataBerechnung.db.setErgebnisBerechnung(Double.parseDouble(F_ergebnisSteuer.getText().toString()));
	}
	
	public void OpenFileCreator (View view){
		
		TextView F_JahresBrutto = (TextView)findViewById(R.id.textView2);
		TextView F_Werbungskosten = (TextView)findViewById(R.id.textView3);
		TextView F_SummeEinkunft = (TextView)findViewById(R.id.textView4);
		TextView F_GesamtBetragEinkunft = (TextView)findViewById(R.id.textView5);
		TextView F_SpendenAbzug = (TextView)findViewById(R.id.textView6);
		TextView F_agBelastungAbzug = (TextView)findViewById(R.id.textView7);
		TextView F_vorsorgeAufwand = (TextView)findViewById(R.id.textView8);
		TextView F_zuVerstEinkommen = (TextView)findViewById(R.id.textView10);
		TextView F_einkommenSteuer = (TextView)findViewById(R.id.textView11);
		TextView F_ergebnisSteuer = (TextView)findViewById(R.id.textView12);
		
		DataBerechnung.db.setJahresBruttoGehalt(Double.parseDouble(F_JahresBrutto.getText().toString()));
		DataBerechnung.db.setWerbungsKosten(Double.parseDouble(F_Werbungskosten.getText().toString()));
		DataBerechnung.db.setSummeEinkunft(Double.parseDouble(F_SummeEinkunft.getText().toString()));
		DataBerechnung.db.setGesamtBetragEinkunft(Double.parseDouble(F_GesamtBetragEinkunft.getText().toString()));
		DataBerechnung.db.setSpendenAbzug(Double.parseDouble(F_SpendenAbzug.getText().toString()));
		DataBerechnung.db.setAgBelastungAbzug(Double.parseDouble(F_agBelastungAbzug.getText().toString()));
		DataBerechnung.db.setVorsorgeAufwandAbzug(Double.parseDouble(F_vorsorgeAufwand.getText().toString()));
		DataBerechnung.db.setZuVerstEinkommen(Double.parseDouble(F_zuVerstEinkommen.getText().toString()));
		DataBerechnung.db.setEinkommenSteuer(Double.parseDouble(F_einkommenSteuer.getText().toString()));
		DataBerechnung.db.setErgebnisBerechnung(Double.parseDouble(F_ergebnisSteuer.getText().toString()));
		
		/*
		 * oeffne naechste activity
		 */
		setContentView(R.layout.filecreator);
	}
	
	public void HoleDaten (View view){
		/*
		 * hole daten zur file creator activity
		 */
//		f_line1.setText(""+DataBerechnung.db.getJahresBruttoGehalt());
//		f_line2.setText(""+DataBerechnung.db.getWerbungsKosten());
		
	}
	
	public void btnCreateFolder (View view){
		
		
	}
	
	public void btnCreateFile (View view){
		
		
	}
	
	/*
	public void CreateFolder (View view){
		
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
	}*/
	/*
	public void CreateFile (View view){
		
		EditText testLine1 = (EditText)findViewById(R.id.editText1);
		testLine1.setText("Jahresbrutto: "+DataGehalt.dg.getBruttoGehaltJahr());
		EditText testLine2 = (EditText)findViewById(R.id.editText2);
		testLine2.setText("JahresLST: " +DataGehalt.dg.getLohnSteuerJahr());
		EditText testLine3 = (EditText)findViewById(R.id.editText3);
		testLine3.setText("JahresSolZ: " +DataGehalt.dg.getSoliZuschlagJahr());
		
		
		String FeldtxtFileDir = txtFileDir.getText().toString(); 
		
		String F_line1 = testLine1.getText().toString();
		String F_line2 = testLine2.getText().toString();
		String F_line3 = testLine3.getText().toString();
		
		try {
			File myFile = new File(FeldtxtFileDir);
			myFile.createNewFile();
			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			myOutWriter.append(F_line1);
			myOutWriter.append("\n");
			myOutWriter.append(F_line2);
			myOutWriter.append("\n");
			myOutWriter.append(F_line3);
			myOutWriter.append("\n"); 
			myOutWriter.close();
			fOut.close();
			Toast.makeText(getBaseContext(),"Done writing SD ",Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
		}
	}
	*/
}
