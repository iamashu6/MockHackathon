package mockHackthon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MyClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\Ashutosh Ranjan\\Downloads\\CPU.txt")));
		DecimalFormat df=new DecimalFormat("0.00");
		JSONObject obj=new JSONObject();
		 List list=new ArrayList();
		String s;
		int count=1,j=0;
		double sum=0.0;
	
		while((s=br.readLine())!=null)
		{
		     if(s.isEmpty() || s.trim().equals("") || s.trim().equals("\n")){
		            continue;
		        }else{
		            
		            String[] data = s.split("\\s+");
	
		            double st=Double.parseDouble(data[8]);
		            
		          //System.out.println(df.format(st));
		          
		           double d=Double.parseDouble(df.format(st));
		           
		            list.add(d);
	
		        
		          
		          obj.put(count+"s",df.format(st));
		          
		           count++; 
		          
		        j++;
		         sum+=Double.parseDouble(data[8]);  
		        }
		    
		}
		
		//System.out.println(j);
		
		//System.out.println(df.format(sum));
		Comparator<Double> cmp=(i1,i2)->i1.compareTo(i2);
		Double maximum=(Double) list.stream().max(cmp).get();
		//System.out.println("Maximum: "+df.format(maximum));
		Double minimum=(Double) list.stream().min(cmp).get();
	//	System.out.println("Minimum: "+df.format(minimum));
		double average=sum/j;
		//System.out.println("Average: "+df.format(average));
		JSONObject obj2=new JSONObject();
		obj2.put("values",obj);
		JSONObject obj3=new JSONObject();
		obj2.put("maximum",df.format(maximum));
		obj2.put("minimum",df.format(minimum));
		obj2.put("Average",df.format(average));
		obj3.put("sampletransaction",obj2);
		JSONArray ja=new JSONArray();
		ja.add(obj3);
		 System.out.println("Json File Created"+ja);
		try
		{
			FileWriter fw=new FileWriter("C:\\Users\\Ashutosh Ranjan\\Downloads\\output.json");
			fw.write(ja.toJSONString());
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		 
	}


}
