package com.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import android.widget.Toast;

import com.Kernel.Core;

public class SocketSender extends Thread {

	private String command;

	public void run() {
		InetSocketAddress isa = new InetSocketAddress(
				Core.ipAddress.toString(), 8765);
		Socket client = new Socket();
		try {
			client.connect(isa, 3500);
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(command + "\n");
			bw.flush();

			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String responceMsg = br.readLine();
			if (responceMsg.equals("Error01"))
				Toast.makeText(Core.context, "請開啟電腦端KKBOX", Toast.LENGTH_LONG).show();
			client.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(Core.context,
					"1.請檢查網路是否開啟.\n2.請確定手機與電腦在同一個區網\n3.PC端程式是否開啟\n4.請確定字串輸入正確",
					Toast.LENGTH_LONG).show();
		}
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
