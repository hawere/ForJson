package clean.data;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import com.talkingdata.analytics.wifi.collector.databean.TaEvent;
import com.talkingdata.analytics.wifi.collector.databean.WiFiDataEntity;
import com.talkingdata.analytics.wifi.collector.databean.WifiData;
import com.talkingdata.analytics.wifi.collector.databean.WifiTa;

import net.sf.json.JSONObject;

public class Lixian {
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Class> classMap = new HashMap<String, Class>();
	
	static {
		classMap.put("wifitalist", WifiTa.class);
		classMap.put("taevent", TaEvent.class);
	}
	public static void main(String[] args) throws Exception {
		//File file = new File("/home/hadoop/wifidata/bigdata/offlinedata");
		File file = new File("../offlinedata");
		File[] listFiles = file.listFiles();
		//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/hadoop/wifidata/bigdata/get/clean.txt")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../get/clean.txt")));
		for (File line : listFiles) {
			System.out.println(line.getName());
			GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(line));
			BufferedInputStream bufferedInputStream = new BufferedInputStream(gzipInputStream);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];  
            int n;
			while ((n = bufferedInputStream.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
			bufferedInputStream.close();
			bos.close();
			WiFiDataEntity wiFiDataEntity=null;
			byte[] byteArray = bos.toByteArray();
			
			String jsonString = new String(byteArray,"utf8");
			JSONObject fromObject = JSONObject.fromObject(jsonString);
			wiFiDataEntity = (WiFiDataEntity) JSONObject.toBean(fromObject, WiFiDataEntity.class, classMap);
			WifiData wifidata = wiFiDataEntity.getWifidata();
			long tssend = wifidata.getTssend();
			String apmac = wifidata.getApmac();
			List<WifiTa> wifitalist = wifidata.getWifitalist();
			for (WifiTa wifiTa : wifitalist) {
				String mac = wifiTa.getMac();
				String rssi = wifiTa.getRssi();
				boolean rssiok = CleanByApmac.rssiok(rssi);
				if (rssiok) {
					bw.write(tssend+","+apmac+","+mac+","+rssi);
					//bw.write(tssend+"\t"+apmac+"\t"+mac+"\t"+rssi);
					bw.newLine();
				}
			}
			bw.flush();
			
		}
		bw.close();
		
		ArrayList<String> realmac = ReadConf.Realmac();
		CleanByApmac.givefiled(realmac);
		GroupByApmac.splitfile();
		//File filesf = new File("/home/hadoop/wifidata/bigdata/get/clean.txt");
		File filesf = new File("../get/clean.txt");
		if (filesf.exists()) {
			filesf.delete();
		}
		System.out.println("【执行成功】");
		Thread.sleep(5000);
	}  
}
