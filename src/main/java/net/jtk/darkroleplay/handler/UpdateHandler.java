package net.jtk.darkroleplay.handler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.jtk.darkroleplay.main.loadConfig;

public class UpdateHandler {

	public static String VersionInfo = null;
	
	public static String Version = null;
	
	public static void init(){
		if(loadConfig.UpdateCheck == true){
			getNewewstVersion();
			if(Version != null){
				System.out.println(Version);
				VersionInfo = "There is a newer mod version";
			}
		}
	}
	
	private static void getNewewstVersion(){
		try{
			URL url = new URL("http://jtk222.bplaced.net/Version.txt");	
			Scanner s = new Scanner(url.openStream());
			Version = s.next();
			s.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
			System.out.println("Couldn't check for Updates");
		}
	}
	
}
