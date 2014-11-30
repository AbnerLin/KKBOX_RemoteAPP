package com.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Kernel.Core;

public class SettingPage extends Activity {

	private Button ipSetOk;
	private EditText ipInputBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_page);

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		Core.setUpInstance();

		findViews();
		setListeners();

		File file = new File("/sdcard/data/RemoteKKBOX", "ipCatch.txt");
		if (file.exists()) {
			try {
				StringBuilder text = new StringBuilder();
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
					text.append(line);
				}
				 ipInputBox.setText(text);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				new File("/sdcard/data/RemoteKKBOX").mkdirs();
				new File("/sdcard/data/RemoteKKBOX/ipCatch.txt")
						.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}

		findViews();
		setListeners();

	}

	private FileInputStream FileInputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private void findViews() {
		ipSetOk = (Button) findViewById(R.id.startBtn);
		ipInputBox = (EditText) findViewById(R.id.ipInputBox);
	}

	private void setListeners() {
		ipSetOk.setOnClickListener(checkIP);
	}

	private Button.OnClickListener checkIP = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (!ipInputBox.getText().toString().trim().equals("")) {
				Core.ipAddress = stringToIp(ipInputBox.getText().toString());
				Intent intent = new Intent();
				intent.setClass(SettingPage.this, Main.class);

				try {
					FileWriter fw = new FileWriter(
							"/sdcard/data/RemoteKKBOX/ipCatch.txt", false);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(ipInputBox.getText().toString());
					bw.newLine();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				startActivity(intent);
				SettingPage.this.finish();
			} else
				Toast.makeText(SettingPage.this, "請輸入PC端產生的號碼",
						Toast.LENGTH_LONG).show();
		}
	};

	private String stringToIp(String str) {
		String ipAddr = new String();
		BigInteger number = new BigInteger(str);
		ipAddr = number.divide(new BigInteger("16777216")).toString();
		ipAddr += ".";
		ipAddr += number.remainder(new BigInteger("16777216"))
				.divide(new BigInteger("65536")).toString();
		ipAddr += ".";
		ipAddr += number.remainder(new BigInteger("16777216"))
				.remainder(new BigInteger("65536"))
				.divide(new BigInteger("256")).toString();
		ipAddr += ".";
		ipAddr += number.remainder(new BigInteger("16777216"))
				.remainder(new BigInteger("65536"))
				.remainder(new BigInteger("256")).toString();
		return ipAddr;
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.setting_page, menu);
	// return true;
	// }
}
