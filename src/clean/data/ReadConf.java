package clean.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadConf {

	public static ArrayList<String> Readmac() throws IOException {
		//File macs = new File("/home/hadoop/wifidata/bigdata/conf/APmac.txt");
		File macs = new File("../conf/APmac.txt");
		BufferedReader bra = new BufferedReader(new FileReader(macs));
		String linef = null;
		ArrayList<String> list = new ArrayList<String>();
		while((linef=bra.readLine()) != null){
			String replaceAll = linef.replaceAll(":", "");
			String lowerCase = replaceAll.toLowerCase();
			list.add(lowerCase);
		}
		bra.close();
		return list;
	}
	
	public static ArrayList<String> Realmac() throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		//BufferedReader br=new BufferedReader(new FileReader(new File("/home/hadoop/wifidata/bigdata/conf/filtermac")));
		BufferedReader br=new BufferedReader(new FileReader(new File("../conf/filtermac")));
		String line = null;
		while((line=br.readLine()) != null){
			String replaceAll = line.replaceAll(":", "");
			String lowerCase = replaceAll.toLowerCase();
			list.add(lowerCase);
		}
		br.close();
		return list;
	}
	
	public static int ReadRssi() {
		//File macs = new File("/home/hadoop/wifidata/bigdata/conf/rssi.txt");
		File macs = new File("../conf/rssi.txt");
		BufferedReader bra;
		try {
			bra = new BufferedReader(new FileReader(macs));
			String linef = null;
			int parseInt=100;
			while((linef=bra.readLine()) != null){
				parseInt = Integer.parseInt(linef.trim());
			}
			bra.close();
			return parseInt;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 100;
	}
}