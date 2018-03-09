package 计算器;
//科学计算器的类
import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Scientificcalculator {
	//计算的主要方法
	public String javaScript(String answer){
		 ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
		String s1="";
		String s2="";
		 String str=answer.replaceAll("sin","Math.sin");
		   str=str.replaceAll("cos","Math.cos");
		   str=str.replaceAll("=","");
		   str=str.replaceAll("tan","Math.tan");
		   str=str.replaceAll("×","*");
		   str=str.replaceAll("÷","/");
		   
		   int bracket=0;
		   
		   for (int i = str.length();--i>=0;){   //开方
			   if(str.charAt(i)=='√'&&i!=0){
				   if(Character.isDigit(str.charAt(i-1))||str.charAt(i-1)==')'||str.charAt(i-1)=='e'||str.charAt(i-1)=='π'){
					   str=replaceIndex(i,str,"*Math.sqrt(");
				   }
				   else
					   str=replaceIndex(i,str,"Math.sqrt(");
				   i=str.length()-1;
			   }
			   else if(str.charAt(i)=='√'&&i==0){
				   str=str.replaceAll("√","Math.sqrt(");
				   i=str.length()-1;
			   }
		   }
		   for (int i = str.length();--i>=0;){
			   
			   if (str.charAt(i)==')'){
				   if((i+1)<str.length()){
					   if(Character.isDigit(str.charAt(i+1))){
						   str=replaceIndex(i,str,")*");
					   }
				   }
				   
				   bracket++;
			   }
			   if(str.charAt(i)=='('){
				   if(i>0){
					   if(Character.isDigit(str.charAt(i-1))){
						   str=replaceIndex(i,str,"*(");
					   }
				   }
				   bracket--;
			   }
			   
			   
			   
			  }
//		   str=str.replaceAll("log","Math.log10");
		   
		   String s=str;
		   if(bracket<0){
			   int t=Math.abs(bracket);
			   for(int i=0;i<t;i++){
				   str=str+")";
				   bracket++;
			   }
		   }
		   else if (bracket>0){
			   for (int i = str.length();--i>=0;){   
				   if (str.charAt(i)==')'){
					   s="("+s;
//					   s=s.substring(0, i)+s.substring(i+1);
					   bracket--;
				   }
				   if(bracket==0){
					   break;
				   }
			   }
			str=s;
		   }
		   for (int i = str.length();--i>=0;){   
			   if(str.charAt(i)=='e'&&i!=0){
				   if(Character.isDigit(str.charAt(i-1))||str.charAt(i-1)==')'){
					   str=str.replaceAll("e","*Math.E");
				   }
				   else
					   str=str.replaceAll("e","Math.E");
			   }
			   if(str.charAt(i)=='π'&&i!=0){
				   if(Character.isDigit(str.charAt(i-1))||str.charAt(i-1)==')'){
					   str=str.replaceAll("π","*Math.PI");
				   }
				   else
					   str=str.replaceAll("π","Math.PI");
			   }
			   
		   }
		   str=str.replaceAll("√","Math.sqrt(");
		   str=str.replaceAll("e","Math.E");
		   str=str.replaceAll("π","Math.PI");
		   //********************************
		   for (int i = str.length();--i>=0;){//阶乘
		   if(str.charAt(i)=='!'){
			   for(int j = i;--j>=0;){
				   if (str.charAt(j)==')'){
					   bracket++;
				   }
				   if (str.charAt(j)=='('){
					   bracket--;
				   }
				   if(bracket==0&&j-1>=0){
                      if((!(Character.isDigit(str.charAt(j-1))||str.charAt(j-1)=='.'||str.charAt(j-1)=='e'||str.charAt(j-1)=='π'))){
                   	   s1=str.substring(j,i);
						  str=str.substring(0,j)+str.substring(i);
						  i=i-(i-j);
						   break;
                      }}
				   else if(((Character.isDigit(str.charAt(0))||str.charAt(0)=='.'||str.charAt(0)=='e'||str.charAt(0)=='π'))&&j==0){
                   	   s1=str.substring(0,i);
 						  str=str.substring(0,j)+str.substring(i);
 						  i=i-(i-j);
 						   break;
                      }
				   
			   }
			   boolean isNum = s1.matches("[0-9]+");
			   if(isNum==true){
				   str=replaceIndex(i,str,factorial(Integer.parseInt(s1)).toString());
				   i = str.length();
			   }
			   
		   }
		   }
		   bracket=0;
		   //*******************************************
		   for (int i = str.length();--i>=0;){   //次方
			   
			   if (str.charAt(i)=='^'){
				   for(int j = i;--j>=0;){
					   if (str.charAt(j)==')'){
						   bracket++;
					   }
					   if (str.charAt(j)=='('){
						   bracket--;
					   }
					   if(bracket<=0&&j-1>=0){
                          if((!(Character.isDigit(str.charAt(j-1))||str.charAt(j-1)=='.'||str.charAt(j-1)=='E'||str.charAt(j-1)=='P'))){
                       	   s1=str.substring(j,i);
    						  str=str.substring(0,j)+str.substring(i);
    						  i=i-(i-j);
    						   break;
                          }
					   else if (str.charAt(j)=='E'){
						   j=j-5;
						   s1=str.substring(j,i);
 						  str=str.substring(0,j)+str.substring(i);
 						  i=i-(i-j);
 						   break;  
					   }
					   else if (str.charAt(j)=='I'){
						   j=j-6;
						   s1=str.substring(j,i);
 						  str=str.substring(0,j)+str.substring(i);
 						  i=i-(i-j);
 						   break;  
					   }}
					   else if(((Character.isDigit(str.charAt(0))||str.charAt(0)=='.'||str.charAt(0)=='e'||str.charAt(0)=='π'||str.charAt(0)=='('))&&j==0){
                       	   s1=str.substring(0,i);
     						  str=str.substring(0,j)+str.substring(i);
     						  i=i-(i-j);
     						   break;
                          }
						  
					   
				   }
c:				   for(int j = i;++j<str.length();){
					   if (str.charAt(j)==')'){
						   bracket++;
					   }
					   if (str.charAt(j)=='('){
						   bracket--;
					   }
					   if(bracket>=0&&j<str.length()){
						   if(((str.charAt(j)==')'||str.charAt(j)=='+'||str.charAt(j)=='-'||str.charAt(j)=='*'||str.charAt(j)=='/'))){
								   s2=str.substring(i+1,j);
								   str=str.substring(0,i+1)+str.substring(j);
								   break ;
							   
							   
						   }
						   if(((Character.isDigit(str.charAt(j))||str.charAt(j)=='.'||str.charAt(j)=='E'||str.charAt(j)=='I'))&&j==str.length()-1){
                       	   s2=str.substring(i+1);
                       	   str=str.substring(0,i+1);
     						   break;
                          }
					   }
				   }
				   try {
					   String q="Math.pow("+s1+","+s2+")";
					   bracket=0;
					   for (int n = q.length();--n>=0;){
						   
						   if (q.charAt(n)==')'){
							   bracket++;
						   }
						   if(q.charAt(n)=='('){
							   bracket--;
						   }
						  }
					   for (int i1 = q.length();--i1>=0;){   
						   if(bracket<0){
							   int t=Math.abs(bracket);
							   for(int i11=0;i11<t;i11++){
								   q=q+")";
								   bracket++;
							   }
						   }
						   else if (bracket>0){
							   for (int i11 = q.length();--i11>=0;){   
								   if (q.charAt(i11)==')'){
									   q="("+q;
//									   s=s.substring(0, i)+s.substring(i+1);
									   bracket--;
								   }
								   if(bracket==0){
									   break;
								   }
							   }
						   }
					   }
					s1=se.eval(q).toString();
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   str=replaceIndex(i,str,s1);
				   i = str.length();
			   }
		   }

		   for (int i = str.length();--i>=0;){   //对数
			   if (str.charAt(i)=='g'){
		   for(int j = i;++j<str.length();){
			   if (str.charAt(j)==')'){
				   bracket++;
			   }
			   if (str.charAt(j)=='('){
				   bracket--;
			   }
			   if(bracket==0){
				   s2=str.substring(i+1,j+1);
				   if(!s2.equals("")){
					   try {
						   s1=Math.log10(Double.parseDouble(se.eval(s2).toString()))+"";
						   s2="log"+s2;
						   str=str.replace(s2, s1);
							System.out.println(" "+s2+" "+str+" "+s1);
							i=str.length()-1;
							j=i+1;
						} catch (ScriptException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				   }
			   }
		     }
			   }
		   }
		   System.out.println(s2);
		   
		   
		   str=str.replaceAll("ln","Math.log");
		   String q=str;
		   bracket=0;
		   for (int n = q.length();--n>=0;){
			   
			   if (q.charAt(n)==')'){
				   bracket++;
			   }
			   if(q.charAt(n)=='('){
				   bracket--;
			   }
			  }
		   for (int i1 = q.length();--i1>=0;){   
			   if(bracket<0){
				   int t=Math.abs(bracket);
				   for(int i11=0;i11<t;i11++){
					   q=q+")";
					   bracket++;
				   }
			   }
			   else if (bracket>0){
				   for (int i11 = q.length();--i11>=0;){   
					   if (q.charAt(i11)==')'){
						   q="("+q;
//						   s=s.substring(0, i)+s.substring(i+1);
						   bracket--;
					   }
					   if(bracket==0){
						   break;
					   }
				   }
			   }
		   }
		   str=q;
		   System.out.println(s1+" "+s2+" "+str);
		   String d1="出错";
		   try {
			d1=se.eval(str).toString();
		} catch (ScriptException e) {
			e.printStackTrace();
		}catch(Exception e1){
			d1="出错";
		}
		d1=d1.replaceAll("Infinity", "∞");
		if(d1.equals("0.0")){
			d1=" 0";
		}
		for(int i=0;i<d1.length();i++){
			if(d1.charAt(i)=='.'){
				for(int j=i+1;j<d1.length();j++){
					if(d1.charAt(j)!='0'){
						break;
					}
					if(j==d1.length()-1){
						d1=d1.substring(0,i);
					}
				}
			}
		}
		
		if(d1.contains("E-")){
			d1=" 0";
		}
		else if(d1.contains("E16")){
			d1="∞";
		}
		else if(d1.contains("E2")){
			d1="∞";
		}
		   return d1;
	}
	//阶乘
	public BigDecimal factorial(int n){   
        BigDecimal result = new BigDecimal(1);  
        BigDecimal a;  
        for(int i = 2; i <= n; i++){  
            a = new BigDecimal(i);//将i转换为BigDecimal类型  
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>  
        }  
        return result;  
    }  
	//代替
	public String replaceIndex(int index,String res,String str){
		return res.substring(0, index)+str+res.substring(index+1);
	}
	//对数
	public double log(double value) {
		return Math.log(value) / Math.log(10);}
}
