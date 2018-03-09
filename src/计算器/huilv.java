package 计算器;

//实时获得网络汇率的类
import java.io.*;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;

import org.htmlparser.util.NodeList;


  //利用htmlparser提取网页纯文本

public class huilv {
	public  String  ouyuan ="" ;
	   public String  meiyuan ="" ;
	  public String  hanyuan ="" ;
	  public String  riyuan ="" ;
	  public String  jiayuan ="" ;
	 public void quzhi() throws IOException{
		huilv ac = new huilv();
		try {
			String sCurrentLine;
			String sTotalString;
			sCurrentLine = "";
			sTotalString = "";
//			File f = new File(File.separator + "url.txt");
			File f = new File( "url.txt");
			f.createNewFile();

			java.io.InputStream l_urlStream;
			java.net.URL l_url = new java.net.URL("http://hl.anseo.cn/");
			java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url.openConnection();
			l_connection.connect();
			l_urlStream = l_connection.getInputStream();
			java.io.BufferedReader l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(l_urlStream));
			sCurrentLine = l_reader.readLine();
			OutputStream out = null;
			out = new FileOutputStream(f);

			while ((sCurrentLine = l_reader.readLine()) != null) {

				sTotalString += sCurrentLine + "\n";

			}
			String testText = extractText(sTotalString);
			testText = ac.toUTF_8(testText); // 调用编码格式方式

			byte b[] = testText.getBytes();
			for (int i = 0; i < b.length; i++) {
				out.write(b[i]);
			}
			out.close();
			// System.out.println( testText );

		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileName = "url.txt";
		String line;
		String string = "";

		int i = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			line = in.readLine();
			while (line != null) {

				char c[] = line.toCharArray();
				for (int i1 = 0; i1 < c.length; i1++) {
					if (c.length < 50 && c.length > 20) {
						if (c[i1] == '美' || c[i1] == '日' || c[i1] == '韩' || c[i1] == '欧') {

							string += line + "\r\n";
							// System.out.println(line);
						} else if (c[i1] == '加' && c[i1 + 1] == '拿' && c[i1 + 2] == '大') {

							string += line + "\r\n";
							// System.out.println(line);

						}

					}

					i++;

				}
				line = in.readLine();

			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		OutputStream out = null;
		out = new FileOutputStream(fileName);

		byte b[] = string.getBytes();
		for (int i2 = 0; i2 < b.length; i2++) {
			out.write(b[i2]);
		}
		out.close();

		// 获取汇率值
		try {
			
			FileReader reader = new FileReader("url.txt"); // 读取文本中内容
			BufferedReader br = new BufferedReader(reader);
		  
		   int j=0;
//			while (br.readLine()!=null) {
		   while (j<10) {
				String str = br.readLine();
				
				String s[] = str.split(" ");
				for (int i1 = 0; i1 < s.length; i1++) {

					System.out.println(s[i1]);//欧元 美元 韩元   日元 加元
					if(i1==3){
						String a = s[i1];
						System.out.println(a);
					}
						
				}
            				
				System.out.println(s[3]);
				if(j==1)      //欧元 美元 韩元   日元 加元
				      ouyuan=s[3];
				else if(j==3)
				      meiyuan=s[3];
				else if(j==5)
				      hanyuan=s[3];
				else if(j==7)
					  riyuan=s[3];
				else if(j==9)
					  jiayuan=s[3];
				
				j++;
			}
			
			
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
        
		
	}
	 public static String extractText(String inputHtml) throws Exception {
			StringBuffer text = new StringBuffer();
			Parser parser = Parser.createParser(new String(inputHtml.getBytes(), "GBK"), "GBK");
			// 遍历所有的节点
			NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {
				public boolean accept(Node node) {
					return true;
				}
			});

			for (int i = 0; i < nodes.size(); i++) {
				Node nodet = nodes.elementAt(i);
				text.append(new String(nodet.toPlainTextString().getBytes("GBK")) + "\n");
			}
			return text.toString();
		}

		public static void test5(String resource) throws Exception {
			Parser myParser = new Parser(resource);
			myParser.setEncoding("GBK");

		}

		/**
		 * 字符串编码转换的实现方法
		 */
		public static final String UTF_8 = "UTF-8";

		public String toUTF_8(String str) throws UnsupportedEncodingException {
			return this.changeCharset(str, UTF_8);
		}

		public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
			if (str != null) {
				// 用默认字符编码解码字符串。
				byte[] bs = str.getBytes();
				// 用新的字符编码生成字符串
				return new String(bs, newCharset);
			}
			return null;
		}
		
		//主函数
	public static void main(String[] args) throws IOException{
		huilv v=new huilv();
		v.quzhi();
	}

	

}
