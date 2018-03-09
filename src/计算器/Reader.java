package 计算器;

//存储类
//写入文档及取出 、获得集合

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Reader {
	private ArrayList<Double> data =new ArrayList<Double>();
	private ArrayList<String> sign =new ArrayList<String>();
	public ArrayList<Double> getData() {
		return data;
	}
	public ArrayList<String> getSign() {
		return sign;
	}
	public void save(ArrayList<String> sign,ArrayList<Double> data){
		PrintWriter p,t;
			try {
				p = new PrintWriter(new FileOutputStream("data.txt"));
				for (int i = 0; i < data.size(); i++) {   
			         p.println(data.get(i));   
			     }   
			      p.close();
			      t = new PrintWriter(new FileOutputStream("sign.txt"));
					for (int i = 0; i < sign.size(); i++) {   
				         t.println(sign.get(i));   
				     }   
				      t.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public  int read()
			throws FileNotFoundException,
				IOException,
				NoSuchElementException,
				NumberFormatException  {
		        BufferedReader a = new BufferedReader(new FileReader("data.txt")); 
		        BufferedReader b = new BufferedReader(new FileReader("sign.txt")); 
		        String line =a.readLine();  
		        String line1 =b.readLine();   
		        int i=0;
		        while (line != null) {   
		            data.add(i,Double.valueOf(line));
		            line = a.readLine();
		            i++;
		        }   
		        a.close(); 
		        i=0;
		        while (line1 != null) {     
		            sign.add(i,line1);
		            line1 = b.readLine();
		            i++;
		        }   
		        
		        b.close(); 
		        return i;
	}
}
