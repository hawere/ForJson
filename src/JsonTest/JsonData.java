package JsonTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;



public class JsonData {	
	
	public static void main(String args[]) throws Exception{
		
		Date d = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	String now = sdf.format(d);
		
			BufferedReader br = null;
			BufferedWriter bw = null;
			 	  
	        StringBuffer sb = new StringBuffer(); 
	        
	        try {  
	        	br = new BufferedReader(new InputStreamReader(new FileInputStream("/data/dfs/wifidata/data1/gunzip/"+now+"")));
	        	//br = new BufferedReader(new InputStreamReader(new FileInputStream("../gunzip/"+now+"")));
	            String str = null;  
	            while((str = br.readLine()) != null) {  
	                sb.append(str);  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                br.close(); 
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }     
	        }  
	       
	          
	        String jsdata = new String(sb);	        
	        //System.out.println(jsdata);	        
	        JSONObject job = new JSONObject(jsdata);
	        
	        	String wifidata = job.getString("wifidata");       
	        	JSONObject wd = new JSONObject(wifidata);	               
	        	String apmac = wd.getString("apmac");
	        	String tssend = wd.getString("tssend");
	        	SimpleDateFormat sf =  new SimpleDateFormat("yyyyMMddHHmmssSSS");  
	            Long lg=new Long(tssend);  
	            String time = sf.format(lg);
	            String hours = time.substring(8, 10);
	            String minutes = time.substring(10, 12);
	        	
	            
	            
	        		JSONArray wtl = wd.getJSONArray("wifitalist");	
	        		for (int i=0;i<wtl.length();i++){
	        			String mac = wtl.getJSONObject(i).getString("mac");
	        			String rssi = wtl.getJSONObject(i).getString("rssi");
	        			String [] sprssi = rssi.split(";");
	        			String str = apmac+"\t"+hours+":"+minutes+"\t"+mac+"\t"+sprssi[0];
	        			//System.out.println(str);
	        			
	        			try {
	     					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/data/dfs/wifidata/data1/log/"+time+".log",true)));
	     					//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../log/"+time+".log",true)));
	     				} catch (FileNotFoundException e) {

	     					e.printStackTrace();
	     				}
	        			
	        			try {
							bw.write(str+"\r\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
	        			
	        			try {
	        				bw.close();
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			}
	        		}
	              
	        		
		      
		      
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
 	}

}
