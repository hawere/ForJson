package clean.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CleanByApmac {

	public static void clean(ArrayList<String> list) throws Exception {
		//File file = new File("/home/hadoop/wifidata/bigdata/data");
		File file = new File("../data");
		File[] listFiles = file.listFiles();
		
		//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/hadoop/wifidata/bigdata/get/clean.txt")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../get/clean.txt")));
		for (File file2 : listFiles) {
			File[] listFiles2 = file2.listFiles();
			for (File file3 : listFiles2) {
				System.out.println(file3.getName());
				BufferedReader br = new BufferedReader(new FileReader(file3));
				
				String line=null;
				while((line=br.readLine())!=null){
					String[] split = line.split(",");
					if (list.contains(split[4])) {
						if (rssiok(split[10])) {
							bw.write(split[2]+","+split[4]+","+split[11]+","+split[10]);
							bw.newLine();
						}
					}
				}
				br.close();
			}
			bw.flush();
		}
		bw.close();
	}
	
	
	public static int readRssi = ReadConf.ReadRssi();
	public static boolean rssiok(String string) throws Exception {
		String[] split = string.split(";");
		if (split.length>0) {
			for (String rssi : split) {
				try{
					int parseInt = Integer.parseInt(rssi);
					if (parseInt<=readRssi) {
						return true;
					}
				}catch(Exception exception){
					return false;
				}
			}
		}
		return false;
	}

	public static void givefiled(ArrayList<String> arrayList) throws Exception{
	
	//File file = new File("/home/hadoop/wifidata/bigdata/get/clean.txt");
	File file = new File("../get/clean.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/hadoop/wifidata/bigdata/get/clean.csv")));
	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../get/clean.csv")));
	
	String line = null;
	while((line=br.readLine())!=null){
		
		String[] split = line.split(",");
		if (split.length!=4) {
			continue;
		}
		String apmac = split[1];
		String mac = split[2];
		
		
		String substring = mac.substring(0, 6);
		if (arrayList.contains(substring)) {
			
			String addmac = addmac(apmac);
			String addmac2 = addmac(mac);
			bw.write(split[0]+","+addmac+","+addmac2+","+split[3]);
			bw.newLine();
		}
	}
	br.close();
	bw.flush();
	bw.close();
	}

public static StringBuffer sb = new StringBuffer();
public static String addmac(String mac){
	for (int i = 0; i < 12; i+=2) {
		String substring = mac.substring(i, i+2);
		sb.append(substring);
		if (i!=10) {
			sb.append(":");
		}
	}
	String newmac = sb.toString();
	sb.delete(0, sb.length());
	return newmac;
}
}
