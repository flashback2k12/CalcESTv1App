package com.flashback.calcestv1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.w3c.dom.Text;

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

//	EditText steuerJahr;
//	EditText txtFileDir;
//	EditText txtCreateFolder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		steuerJahr = (EditText)findViewById(R.id.etSteuerJahr);
//		txtFileDir = (EditText)findViewById(R.id.txtFileDir);
//		txtFileDir.setHint("e.g.:/sdcard/Steuerberechnung/");
//		txtCreateFolder = (EditText)findViewById(R.id.txtCreateFolder);
//		txtCreateFolder.setHint("e.g.:/sdcard/Steuerberechnung/Auswertung.txt");
		
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
		DataWK.dWK.setSteuerJahr(Integer.parseInt(F_SteuerJahr.getText().toString()));
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
		
		/*
		 * uebergabe vorsorgeaufwand
		 */
		
		/*
		 * oeffne naechste activity
		 */
		setContentView(R.layout.agbelastung);
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
		/*
		 * berechnung summe einkuenfte
		 */
		double mSummeEinkunft = 0.0;
		double mBruttoJahresGehalt = DataGehalt.dg.getBruttoGehaltJahr();
		
		mSummeEinkunft = Berechne.SummeEinkunft(mBruttoJahresGehalt, mWerbungskosten);
	
		TextView F_SummeEinkunft = (TextView)findViewById(R.id.textView4);
		F_SummeEinkunft.setText("Summe Einkuenfte: " +Math.round(mSummeEinkunft*100.00)/100.00);
		/*
		 * berechnung gesamtbetrag einkuenfte
		 */
		double mGesamtBetragEinkunft = 0.0;
		
		mGesamtBetragEinkunft = Berechne.GesamtbetragEinkunft(mSummeEinkunft);
		
		TextView F_GesamtBetragEinkunft = (TextView)findViewById(R.id.textView5);
		F_GesamtBetragEinkunft.setText("Gesamtbetrag Einkuenfte: " + Math.round(mGesamtBetragEinkunft*100.00)/100.00);
		/*
		 * berechnung spenden
		 */
		double mSpendenGezahlt = DataWK.dWK.getSpendenGezahlt();
		double mSpendenAbzug = 0.0;
		
		mSpendenAbzug = Berechne.SpendenAbzug(mGesamtBetragEinkunft, mSpendenGezahlt);
		
		TextView F_SpendenAbzug = (TextView)findViewById(R.id.textView6);
		F_SpendenAbzug.setText("Spendenabzug: " +Math.round(mSpendenAbzug*100.00)/100.00);
		/*
		 * berechnung aussergewoehnliche belastung
		 */
		double mKrankheitskostenGezahlt = DataAGB.agB.getKrankheitsKostenGezahlt();
		double mAgBelastungAbzug = 0.0;
		
		mAgBelastungAbzug = Berechne.agBelastungAbzug(mGesamtBetragEinkunft, mKrankheitskostenGezahlt);
		
		TextView F_agBelastungAbzug = (TextView)findViewById(R.id.textView7);
		F_agBelastungAbzug.setText("außergewöhnliche Belastung: " +Math.round(mAgBelastungAbzug*100.00)/100.00);
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
