package com.Kernel;

import android.content.Context;

import com.Service.SocketSender;

public class Core {

	public static Core _instance;
	public static String ipAddress = null;
	public static SocketSender socketObj;
	public static Context context;
	
	public Core(){
		socketObj = new SocketSender();
	}
	
	public static void setUpInstance(){
		_instance = new Core();
	}
	
}
