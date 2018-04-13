package clean.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GroupByApmac {
	
	public static void splitfile() throws Exception {
		//File file = new File("/home/hadoop/wifidata/bigdata/get/clean.csv");
		File file = new File("../get/clean.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		String line = null;
		int b = 0;
		int c=0;
		int x = 0;
		while((line=br.readLine())!=null){
			String[] split = line.split(",");
			String string = split[1];
			String string2 = split[2];
			x++;
			if (hashMap.get(string+","+string2)==null) {
				c++;
			}else{
				b++;
			}
			hashMap.put(string+","+string2, "");
		}
		br.close();
		System.out.println("总数为"+x);
		System.out.println("去重后"+c);
		System.out.println("重复的条数为"+b);
		//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/hadoop/wifidata/bigdata/get/split.csv")));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../get/split.csv")));
		
		HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		
		int a = 0;
		Iterator<Entry<String, String>> iterator = hashMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			String key = next.getKey();
			String[] split = key.split(",");
			String apmac = split[0];
			ArrayList<String> arrayList = map.get(apmac);
			if (arrayList==null) {
				arrayList=new ArrayList<String>();
			}
			arrayList.add(split[1]);
			map.put(apmac, arrayList);
			a++;
		}
		System.out.println("=======================================");
		System.out.println("总条数为"+a);
		
		Iterator<Entry<String, ArrayList<String>>> iterator2 = map.entrySet().iterator();
		
		while(iterator2.hasNext()){
			Entry<String, ArrayList<String>> next = iterator2.next();
			String key = next.getKey();
			ArrayList<String> value = next.getValue();
			for (String string : value) {
				bw.write(key+","+string);
				bw.newLine();
			}
			bw.flush();
		}
		bw.close();
	}
}
