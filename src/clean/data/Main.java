package clean.data;

import java.io.File;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<String> readmac = ReadConf.Readmac(); //读入APmac.txt文件数据到list中赋予readmac
		CleanByApmac.clean(readmac); //清洗APmac.txt数据写入到/get/clean.txt文件中
		
		ArrayList<String> realmac = ReadConf.Realmac(); //读入filtermac文件数据到list中赋予realmac
		CleanByApmac.givefiled(realmac); //将根据filtermac规则清洗数据写出到/get/clean.csv文件中
		
		GroupByApmac.splitfile(); //将APmac和mac分割出来
		//File file = new File("/home/hadoop/wifidata/bigdata/get/clean.txt");
		File file = new File("../get/clean.txt");
		if (file.exists()) {
			file.delete(); //删除/get/clean.txt文件
		}
		System.out.println("【执行成功】");
		Thread.sleep(5000);
		
	}
}

