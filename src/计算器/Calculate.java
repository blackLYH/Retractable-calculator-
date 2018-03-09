package 计算器;
/** 
* class <code>{Calculate}</code>{} 
* 
* @author   liangyuhang mengdejun luoyuchen
* @version  2016/6/
* @see      
* @since    JDK{jdk version} */

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.script.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
/**
 * import java.awt package
 * import java.io package
 * import java.math package
 * import java.text package
 * import java.util package
 * import javax.script package
 * import javax.swing package
 * 
 */


/** 
* {继承JFrame 接入ActionListener, KeyListener} 
* @param       {}    {}       
* @return       {}    {} 
* @exception{说明在某情况下,将发生什么异常}
**/
public class Calculate extends  JFrame implements ActionListener, KeyListener {
    private ArrayList<Double> data=new ArrayList<Double>();
    private ArrayList<String> sign= new ArrayList<String>();
    private Animation a=new Animation();
    private int step=-1;
    
    //定义全局变量
    private int choose1=0;
    private int choose2=5;
    private boolean isusal=true;
    private boolean isFix=false;
    private boolean islock=false;
    private double meiyuan=0.0;
    private double riyuan=0.0;
    private double hanyuan=0.0;
    private double jiayuan=0.0;
    private double ouyuan=0.0;
    private double renminbi=0.0;
    private double  meiyuanhuilv=0.0;
    private double  renminbiyuanhuilv=1.0;
	private double  riyuanhuilv=0.0;
	private double  ouyuanhuilv=0.0;
	private double  hanyuanhuilv=0.0;
	private double  jiayuanhuilv=0.0;
	private double sheshidu=0.0;
	private double speed=0.0;
	
	//定义框体
	JFrame frame = new JFrame("计算器");
	JFrame frame2 = new JFrame("请选择功能：");
	JFrame frame3 = new JFrame("大小写转换");
	JFrame frame4 = new JFrame("汇率转换");
	JFrame frame5 = new JFrame("时间转换");
	JFrame frame6 = new JFrame("面积转换");
	JFrame frame7 = new JFrame("体积转换");
	JFrame frame8 = new JFrame("温度转换");
	JFrame frame9 = new JFrame("速度转换");
	JFrame frame10 = new JFrame("");
	JFrame frame11 = new JFrame("");
	
	//容器
	Container contentPane = frame.getContentPane();  //容器  
	Container contentPane2 = frame2.getContentPane();
	Container contentPane3 = frame3.getContentPane();
	Container contentPane4 = frame4.getContentPane();
	Container contentPane5 = frame5.getContentPane();
	Container contentPane6 = frame6.getContentPane();
	Container contentPane7 = frame7.getContentPane();
	Container contentPane8 = frame8.getContentPane();
	Container contentPane9 = frame9.getContentPane();
	Container buttonArea2 = frame.getContentPane();
	Container contentPane10 = frame10.getContentPane();
	Container contentPane11 = frame11.getContentPane();

	//添加国旗图片
	ImageIcon A1 = new ImageIcon("picture/china.png");
	ImageIcon A2 = new ImageIcon("picture/USA.png");
	ImageIcon A3 = new ImageIcon("picture/EUR.png");
	ImageIcon A4 = new ImageIcon("picture/CAD.png");
	ImageIcon A5 = new ImageIcon("picture/KRW.png");
	ImageIcon A6 = new ImageIcon("picture/JPY.png");
	
	//添加图片至JLabel
	JLabel pictureBackGround = new JLabel(new ImageIcon("picture/上面的背景.png"));
	JLabel pictureBackGround2 = new JLabel(new ImageIcon("picture/上面的背景2.png"));
	JLabel trans = new JLabel(new ImageIcon("picture/转换.png"));
	JLabel trans2 = new JLabel(new ImageIcon("picture/转换2.png"));
	JLabel sjt = new JLabel(new ImageIcon("picture/上箭头.png"));
	JLabel sjt1 = new JLabel(new ImageIcon("picture/上箭头（按）.png"));
	JLabel xjt = new JLabel(new ImageIcon("picture/下箭头.png"));
	JLabel xjt1 = new JLabel(new ImageIcon("picture/下箭头（按）.png"));
	JLabel gongNeng = new JLabel(new ImageIcon("picture/功能2.png"));
	JLabel gongNeng2 = new JLabel(new ImageIcon("picture/功能.png"));
	
	//国旗图片
	JLabel L1 = new JLabel( A1);
	JLabel L2 = new JLabel(A2);
	JLabel L3 = new JLabel(A3);
	JLabel L4 = new JLabel(A4);
	JLabel L5 = new JLabel(A5);
	JLabel L6 = new JLabel(A6);
	JLabel L7 = new JLabel(A6);

	//科学计算器的panel
	Panel buttonArea = new Panel();
//	JPanel buttonArea2 = new JPanel();
	
	//添加图片
	ImageIcon pictureC = new ImageIcon("picture/c.png");
	ImageIcon pictureDelete = new ImageIcon("picture/delete.png");
	ImageIcon picture7 = new ImageIcon("picture/7.png");
	ImageIcon picture8 = new ImageIcon("picture/8.png");
	ImageIcon picture9 = new ImageIcon("picture/9.png");
	ImageIcon picture6 = new ImageIcon("picture/6.png");
	ImageIcon picture5 = new ImageIcon("picture/5.png");
	ImageIcon picture4 = new ImageIcon("picture/4.png");
	ImageIcon picture3 = new ImageIcon("picture/3.png");
	ImageIcon picture2 = new ImageIcon("picture/2.png");
	ImageIcon picture1 = new ImageIcon("picture/1.png");
	ImageIcon picture0 = new ImageIcon("picture/0.png");
	ImageIcon pictureAdd = new ImageIcon("picture/+.png");
	ImageIcon pictureSub = new ImageIcon("picture/-.png");
	ImageIcon pictureEqual = new ImageIcon("picture/=.png");
	ImageIcon picturePoint = new ImageIcon("picture/。.png");
	ImageIcon pictureMultiply = new ImageIcon("picture/乘.png");
	ImageIcon pictureDiv = new ImageIcon("picture/除.png");
	ImageIcon pictureC2 = new ImageIcon("picture/c2.png");//
	ImageIcon pictureEqual2 = new ImageIcon("picture/=2.png");
	ImageIcon pictureLog = new ImageIcon("picture/log.png");
	ImageIcon pictureLn = new ImageIcon("picture/ln.png");
	ImageIcon pictureTan = new ImageIcon("picture/tan.png");
	ImageIcon pictureCos = new ImageIcon("picture/cos.png");
	ImageIcon pictureE = new ImageIcon("picture/e.png");
	ImageIcon pictureLeftKH = new ImageIcon("picture/(.png");
	ImageIcon pictureRightKH = new ImageIcon("picture/).png");
	ImageIcon pictureSin = new ImageIcon("picture/sin.png");
	ImageIcon picturePai = new ImageIcon("picture/拍.png");
	ImageIcon pictureGen = new ImageIcon("picture/根号.png");
	ImageIcon pictureCiFang = new ImageIcon("picture/次方.png");
	ImageIcon pictureGanTan = new ImageIcon("picture/!.png");
	ImageIcon picture02 = new ImageIcon("picture/02.png");
	
	
	//添加文字
	JLabel answer = new JLabel("0",JLabel.RIGHT);
	JLabel answerUp = new JLabel("",JLabel.RIGHT);
	JLabel answerMiddle = new JLabel("",JLabel.RIGHT);
	JLabel answerMiddle2 = new JLabel("",JLabel.RIGHT);
	JLabel answerMiddle3 = new JLabel("",JLabel.RIGHT);
	JLabel answerMiddle4 = new JLabel("",JLabel.RIGHT);
	JLabel top = new JLabel("");
	JLabel huilv1 = new JLabel("1",JLabel.RIGHT);
	JLabel huilv2 = new JLabel("人民币",JLabel.RIGHT);
	JLabel huilv3 = new JLabel("0.15",JLabel.RIGHT);
	JLabel huilv4 = new JLabel("美元",JLabel.RIGHT);
	JLabel huilv5 = new JLabel("0.13",JLabel.RIGHT);
	JLabel huilv6 = new JLabel("欧元",JLabel.RIGHT);
	JLabel frame6up = new JLabel("0",JLabel.RIGHT);
	JLabel frame6down = new JLabel("零",JLabel.RIGHT);
	JLabel time = new JLabel("");
	JLabel kai = new JLabel("开尔文/K ◀▶");	
	JLabel up = new JLabel("");
	JLabel down = new JLabel("");
	JLabel upNum = new JLabel("",JLabel.RIGHT);
	JLabel downNum = new JLabel("",JLabel.RIGHT);
	JLabel label1 = new JLabel("",JLabel.RIGHT);
	JLabel label2 = new JLabel("",JLabel.RIGHT);
	JLabel label3 = new JLabel("",JLabel.RIGHT);
	
	//添加含图片按钮
	JButton c = new JButton("",pictureC);
	JButton delete = new JButton("",pictureDelete);
	JButton seven = new JButton("",picture7);
	JButton eight = new JButton("",picture8);
	JButton nine = new JButton("",picture9);
	JButton six = new JButton("",picture6);
	JButton five = new JButton("",picture5);
	JButton four = new JButton("",picture4);
	JButton three = new JButton("",picture3);
	JButton two = new JButton("",picture2);
	JButton one = new JButton("",picture1);
	JButton zero = new JButton("",picture0);
	JButton zero1 = new JButton("",picture0);//
	JButton add = new JButton("",pictureAdd);
	JButton sub = new JButton("",pictureSub);
	JButton equal = new JButton("",pictureEqual);
	JButton point = new JButton("",picturePoint);
	JButton mul = new JButton("",pictureMultiply);
	JButton div = new JButton("",pictureDiv);
	JButton c2 = new JButton("",pictureC2);//
	JButton equal2 = new JButton("",pictureEqual2);
	JButton log = new JButton("",pictureLog);
	JButton ln = new JButton("",pictureLn);
	JButton tan = new JButton("",pictureTan);
	JButton cos = new JButton("",pictureCos);
	JButton e = new JButton("",pictureE);
	JButton leftKH = new JButton("",pictureLeftKH);
	JButton rightKH = new JButton("",pictureRightKH);
	JButton sin = new JButton("",pictureSin);
	JButton pai = new JButton("",picturePai);
	JButton gen = new JButton("",pictureGen);
	JButton ciFang = new JButton("",pictureCiFang);
	JButton ganTan = new JButton("",pictureGanTan);
	JButton zero2 = new JButton("",picture02);
	JButton x1 = new JButton("", new ImageIcon("picture/汇率转换.png"));
	JButton x2 = new JButton("", new ImageIcon("picture/温度转换.png"));
	JButton x3 = new JButton("", new ImageIcon("picture/速度转换.png"));
	JButton x4 = new JButton("", new ImageIcon("picture/大写数字.png"));
	JButton x5 = new JButton("", new ImageIcon("picture/计算器.png"));
	JButton x6 = new JButton("", new ImageIcon("picture/科学计算器.png"));
	JButton x7 = new JButton("", new ImageIcon("picture/面积转换.png"));
	JButton x8 = new JButton("", new ImageIcon("picture/长度转换.png"));
	JButton x9 = new JButton("", new ImageIcon("picture/体积转换.png"));
	JButton gC = new JButton("", new ImageIcon("picture/功能C.png"));
	JButton gD = new JButton("", new ImageIcon("picture/功能delete.png"));
	//构造函数
	public Calculate(){
		
		try {
//			读取类读取文档
			Reader r =new Reader();
			step=r.read();
			sign=r.getSign();
			data=r.getData();
//			显示
			display();
		} catch (NumberFormatException | NoSuchElementException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	   
	//          主函数
	public static void main(String[] args) {  //主函数
		// TODO Auto-generated method stub
		Calculate e1=new Calculate();//图像界面的运行
		
			e1.run();//图形界面的运行
	}
	
	/** 
	* {继承JFrame 接入ActionListener, KeyListener} 
	* @param       {引入参数名}    {引入参数说明}       
	* @return       {返回参数名}    {返回参数说明} 
	* @exception{说明在某情况下,将发生什么异常}
	**/	
	//           图形界面的运行
	private void run() {
		// TODO Auto-generated method stub
/**
 * 设置主要界面
 * 
 * 添加监听器
 * 		
 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setSize(390,683);
		Image imageIcon = Toolkit.getDefaultToolkit().getImage("picture/图标.png");
		frame.setIconImage(imageIcon);
		frame2.setIconImage(imageIcon);
		frame3.setIconImage(imageIcon);
		frame4.setIconImage(imageIcon);
		frame5.setIconImage(imageIcon);
		frame6.setIconImage(imageIcon);
		frame7.setIconImage(imageIcon);
		frame8.setIconImage(imageIcon);
		frame9.setIconImage(imageIcon);
		frame10.setIconImage(imageIcon);
		frame11.setIconImage(imageIcon);
		
		frame.setVisible(true);
		contentPane.setLayout(null);
		up.setFont(new Font("Adobe 楷体 Std", Font.PLAIN, 20));
		down.setFont(new Font("Adobe 楷体 Std", Font.PLAIN, 20));
		top.setFont(new Font("Dialog", Font.PLAIN, 25));
		label1.setFont(new Font("Adobe 楷体 Std", Font.PLAIN, 18));
		label2.setFont(new Font("Adobe 楷体 Std", Font.PLAIN, 18));
		label3.setFont(new Font("Adobe 楷体 Std", Font.PLAIN, 18));
		
		frame.setResizable(false);
		frame2.setResizable(false);
		frame3.setResizable(false);
		frame4.setResizable(false);
		frame5.setResizable(false);
		frame6.setResizable(false);
		frame7.setResizable(false);
		frame8.setResizable(false);
		frame9.setResizable(false);
		frame10.setResizable(false);
		frame11.setResizable(false);
		
		
		topArea(contentPane);
		
		L1.setText("人民币");
		L2.setText("美元");
		L3.setText("欧元");
		L4.setText("加元");
		L5.setText("韩元");
		L6.setText("日元");

		
		
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		time.setText("更新时间:"+sdf.format(date));
		c.addActionListener(this);
		delete.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		sub.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		add.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		equal.addActionListener(this);
		zero.addActionListener(this);
		zero1.addActionListener(this);
		x1.addActionListener(this);
		x2.addActionListener(this);
		x3.addActionListener(this);
		x4.addActionListener(this);
		x5.addActionListener(this);
		x6.addActionListener(this);
		x7.addActionListener(this);
		x8.addActionListener(this);
		x9.addActionListener(this);
		point.addActionListener(this);
		equal2.addActionListener(this);
		ganTan.addActionListener(this);
		ciFang.addActionListener(this);
		gen.addActionListener(this);
		c2.addActionListener(this);
		sin.addActionListener(this);
		tan.addActionListener(this);
		ln.addActionListener(this);
		log.addActionListener(this);
		leftKH.addActionListener(this);
		rightKH.addActionListener(this);
		e.addActionListener(this);
		pai.addActionListener(this);
		cos.addActionListener(this);
		zero2.addActionListener(this);
		gC.addActionListener(this);
		gD.addActionListener(this);
		
		frame.addKeyListener(this);
		answer.addMouseListener(new MouseAdapter(){ //双击复制
			public void mouseClicked(MouseEvent e){ 
			if(e.getClickCount() == 2){ 
				copy(answer.getText());
			} 
			} 
			}); 
		frame6down.addMouseListener(new MouseAdapter(){ //双击复制
			public void mouseClicked(MouseEvent e){ 
			if(e.getClickCount() == 2){ 
				copy(frame6down.getText());
			} 
			} 
			}); 
		up.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(choose2==2){
					String k=kai.getText();
					kai.setText(up.getText());
					up.setText(k);
				}
				else{
					choose1 = 1;	                   
					frame13();
				}
				
				solve();
			}
		});
		
		down.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(choose2==2){
					String k=kai.getText();
					kai.setText(down.getText());
					down.setText(k);
				}else{
					choose1 = 2;
					frame13();
				}
				
				solve();
			}
		});
		
		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change2(up, label1);
			
				}
				if (choose1 == 2) {
					change2(down, label1);
			
				}
				solve();
			}
		});
		
		label2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change2(up, label2);
			
				}
				if (choose1 == 2) {
					change2(down, label2);
			
				}
				solve();
			}
		});
		
		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change2(up, label3);
			
				}
				if (choose1 == 2) {
					change2(down, label3);
			
				}
				solve();
			}
		});
		
		L1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choose1 = 1;
				frame12();
				solve();
			}
		});

		L2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choose1 = 2;
				frame12();
				solve();
			}
		});

		L3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choose1 = 3;
				frame12();
				solve();
			}
		});

		L4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change(L1, L4);
			
				}
				if (choose1 == 2) {
					change(L2, L4);
			
				}
				if (choose1 == 3) {
					change(L3, L4);
				}
				solve();
			}
		});

		L5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change(L1, L5);
				}
				if (choose1 == 2) {
					change(L2, L5);
				}
				if (choose1 == 3) {
					change(L3, L5);
				}
				solve();
			}
		});

		L6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (choose1 == 1) {
					change(L1, L6);
				}
				if (choose1 == 2) {
					change(L2, L6);
				}
				if (choose1 == 3) {
					change(L3, L6);
				}
				solve();
			}
		});
		
		sjt.addMouseListener(new MouseAdapter(){
		    public void mousePressed(MouseEvent e){
		    	if(step>0){
		    		sjt.setVisible(false);
			    	sjt1.setVisible(true);
		    	}
		    	
		    }
    
		    public void mouseReleased(MouseEvent e){
		    	if(step>0){
		    		sjt.setVisible(true);
			    	sjt1.setVisible(false);
		    	}
		    }
		    public void mouseClicked(MouseEvent e){
		    	step--;
		    	if(step<=-1){
		    		if(!answerUp.getText().equals("0")){
		    			answer.setText(answerUp.getText());
		    		}
		    		answerUp.setText("0");
		    		step=-1;
		    	}
		    	else if(step>=0){
		    		a.animationDown(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
			    	if(step>=1&&step!=data.size()){
				    	answerUp.setText(sign.get(step-1)+data.get(step));
				    	
			    	}
			    	else if(step==0){
			    		answerUp.setText(""+data.get(step));
			    		
			    	}
			    	else
			    		answerUp.setText("0");
		    	}
		    	
		    }
		    	
		    
		});
		xjt.addMouseListener(new MouseAdapter(){
		    public void mousePressed(MouseEvent e){
		    	xjt.setVisible(false);
		    	xjt1.setVisible(true);
		    }
    
		    public void mouseReleased(MouseEvent e){
		    	xjt.setVisible(true);
		    	xjt1.setVisible(false);
		    }
		    public void mouseClicked(MouseEvent e){
		    	step++;
		    	
		    	if(step<=data.size()-2){
		    		a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
		    		answer.setText(sign.get(step)+data.get(step+1));
		    		
		    	}
		    	else if(step>=data.size()-1){
		    	    step=data.size()-2;
		    	    answerUp.setText(sign.get(step)+data.get(step+1));
			    	answer.setText(sign.get(step+1)+compute());
			    	step=data.size()-1;
		    		
		    	}
		    	else{
		    		
		    	}

		    }
		});
		trans.addMouseListener(new MouseAdapter(){
			
			  
		    public void mousePressed(MouseEvent e){
		    	trans.setVisible(false);
		    	trans2.setVisible(true);
		    }
    
		    public void mouseReleased(MouseEvent e){
		    	trans.setVisible(true);
		    	trans2.setVisible(false);

		    }
		    public void mouseClicked(MouseEvent e){
		    	if(isusal==true){
		    		frame2();
		    	}
		    	else if(isusal==false){
		    		frame3();
		    	}

		    }
		    
				});
		gongNeng.addMouseListener(new MouseAdapter(){
			
			  
		    public void mousePressed(MouseEvent e){
		    	gongNeng.setVisible(false);
		    	gongNeng2.setVisible(true);
		    }
    
		    public void mouseReleased(MouseEvent e){
		    	gongNeng.setVisible(true);
		    	gongNeng2.setVisible(false);

		    }
		    public void mouseClicked(MouseEvent e){
		    	frame.dispose();
		    	frame.dispose();
		    	frame2.dispose();
		    	frame3.dispose();
		    	frame4.dispose();
		    	frame5.dispose();
		    	frame6.dispose();
		    	frame7.dispose();
		    	frame8.dispose();
		    	frame9.dispose();
		    	frame10.dispose();
		    	frame4();
		    	answer.setText("");
		    }
		   });

		frame.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent we){
				   if(data.size()>0){
					   Reader r=new Reader();
					   r.save(sign,data);
				   }
					System.exit(0);	
			   }
			  });
	}
	
//	启动显示
	private void display() {
		step=data.size()-2;
	    answerUp.setText(sign.get(step)+data.get(step+1));
	    if(!answerUp.getText().equals("")){
	    	answerUp.setVisible(true);
	    }
	    answerUp.setVisible(true);
    	answer.setText(sign.get(step+1)+compute());
    	step=data.size()-1;
		
	}
	
//判断并设置文本信息	
	public void judge2(){
		if(choose2==3){
        	label1.setText("千米/小时(km/h)▼");
        	label2.setText("厘米/秒(cm/s)▼");
        	label3.setText("分米/秒(dm/s)▼");
        }
        else if(choose2==7){
        	label1.setText("公顷▼");
        	label2.setText("平方分米/cm²▼");
        	label3.setText("亩▼");
        }
        else if(choose2==8){
        	label1.setText("时/h▼");
        	label2.setText("天/d▼");
        	label3.setText("毫秒/ms▼");
        }
        else if(choose2==9){
        	label1.setText("毫升/mL▼");
        	label2.setText("立方米/m³▼");
        	label3.setText("升/L▼");
        }
	}
//交换文本内容的方法	
	public void change2(JLabel up, JLabel label1)  {
		String s = up.getText();
		up.setText(label1.getText());
		label1.setText(s);
		frame11.dispose();
		
	}
//交换国旗图片与文本的方法	
	public void change(JLabel L5, JLabel L4)  {
		String s = L5.getText();
		L5.setText(L4.getText());
		L4.setText(s);
		L7.setIcon(L4.getIcon());
		L4.setIcon(L5.getIcon());
		L5.setIcon(L7.getIcon());
		frame10.dispose();
		judge(L1.getText(),L2.getText(),L3.getText());
		
	}
//获取汇率
	public void getHuilv(){
		huilv v =new huilv();
		try {
			v.quzhi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meiyuanhuilv=Double.parseDouble(v.meiyuan);
		ouyuanhuilv=Double.parseDouble(v.ouyuan);
		riyuanhuilv=Double.parseDouble(v.riyuan);
		jiayuanhuilv=Double.parseDouble(v.jiayuan);
		hanyuanhuilv=Double.parseDouble(v.hanyuan);
	}
//显示汇率		
	private void judge(String s1,String s2,String s3) {
			huilv2.setText(s1);
			huilv4.setText(s2);
			huilv6.setText(s3);
			huilv1.setText(money(s1));
			huilv3.setText(money(s2));
			huilv5.setText(money(s3));
	}
//判断币种信息		
	private String money(String s){
			if(s.equals("人民币")){
				return ""+renminbi;
			}
			else if(s.equals("美元")){
				return ""+meiyuan;
			}
			else if(s.equals("欧元")){
				return ""+ouyuan;
			}
			else if(s.equals("加元")){
				return ""+jiayuan;
			}
			else if(s.equals("韩元")){
				return ""+hanyuan;
			}
			else if(s.equals("日元")){
				return ""+riyuan;
			}
			return "";
		}
//双击复制方法
	public void copy(String text){  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //得到系统剪贴板  
        StringSelection selection = new StringSelection(text);  
        clipboard.setContents(selection, null);  
    }  
//统一的上部界面	
	private void topArea(Container contentPane) {
		// TODO Auto-generated method stub
	    gongNeng.setBounds(5, 5, 45, 45);
		contentPane.add(gongNeng);
		gongNeng.setVisible(true);
		
		gongNeng2.setBounds(5, 5, 45, 45);
		contentPane.add(gongNeng2);
		gongNeng2.setVisible(false);
		
		sjt1.setBounds(10, 170, 25, 12);
		contentPane.add(sjt1);
		sjt1.setVisible(false);
		
		sjt.setBounds(10, 170, 25, 12);
		contentPane.add(sjt);
		
		xjt1.setBounds(10, 182, 25, 12);
		contentPane.add(xjt1);
		xjt1.setVisible(false);
		
		xjt.setBounds(10, 182, 25, 12);
		contentPane.add(xjt);
		
		
		answerUp.setBounds(0, 70, 370, 40);
		answerUp.setFont(new java.awt.Font("Dialog", 1, 30));
		answerUp.setForeground(Color.lightGray);
		contentPane.add(answerUp);
		answerUp.setVisible(true);
		
		answerMiddle.setBounds(0, 90, 370, 40);
		answerMiddle.setFont(new java.awt.Font("Dialog", 1, 45));
		answerMiddle.setForeground(Color.lightGray);
		contentPane.add(answerMiddle);
		answerMiddle.setVisible(false);
		
		answerMiddle2.setBounds(0, 110, 370, 40);
		answerMiddle2.setFont(new java.awt.Font("Dialog", 1, 55));
		answerMiddle2.setForeground(Color.lightGray);
		contentPane.add(answerMiddle2);
		answerMiddle2.setVisible(false);
		
		answerMiddle3.setBounds(0, 125, 370, 40);
		answerMiddle3.setFont(new java.awt.Font("Dialog", 1, 65));
		answerMiddle3.setForeground(Color.DARK_GRAY);
		contentPane.add(answerMiddle3);
		answerMiddle3.setVisible(false);
		
		answerMiddle4.setBounds(0, 135, 370, 80);
		answerMiddle4.setFont(new java.awt.Font("Dialog", 1, 73));
		answerMiddle4.setForeground(Color.DARK_GRAY);
		contentPane.add(answerMiddle4);
		answerMiddle4.setVisible(false);
		
		
		answer.setBounds(0, 140, 370, 80);
		answer.setFont(new java.awt.Font("Dialog", 1, 80));
		answer.setForeground(Color.black);
		contentPane.add(answer);
		
		trans2.setBounds(320, 0, 55, 55);
		contentPane.add(trans2);
		trans2.setVisible(false);
		
		trans.setBounds(320, 0, 55, 55);
		contentPane.add(trans);
		
		
		pictureBackGround.setBounds(-6, 0, 400, 230);
		contentPane.add(pictureBackGround);
		c.setBounds(0, 230, 96, 85);
		contentPane.add(c);
		
		

		
		delete.setBounds(96, 230, 96, 85);
		contentPane.add(delete);
		
		
		mul.setBounds(192, 230, 96, 85);
		contentPane.add(mul);
		
		
		div.setBounds(288, 230, 96, 85);
		contentPane.add(div);
		
		
		
		seven.setBounds(0, 315,96, 85);
		contentPane.add(seven);
		
		
		eight.setBounds(96, 315,96, 85);
		contentPane.add(eight);
		
		
		nine.setBounds(192, 315,96, 85);
		contentPane.add(nine);
		
		
		sub.setBounds(288, 315,96, 85);
		contentPane.add(sub);
		
		
		four.setBounds(0, 400,96, 85);
		contentPane.add(four);
		
		
		five.setBounds(96, 400,96, 85);
		contentPane.add(five);
		
		
		six.setBounds(192, 400,96, 85);
		contentPane.add(six);
		
		
		add.setBounds(288, 400,96, 85);
		contentPane.add(add);
		
		
		one.setBounds(0, 485,96, 85);
		contentPane.add(one);
		
		
		two.setBounds(96, 485,96, 85);
		contentPane.add(two);
		
		
		three.setBounds(192, 485,96, 85);
		contentPane.add(three);
		
		
		equal.setBounds(288, 485,96, 170);
		contentPane.add(equal);
		
		
		zero.setBounds(0, 570,192, 85);
		contentPane.add(zero);
		
		
		point.setBounds(192, 570,96, 85);
		contentPane.add(point);
   }
//判断是否为数字
	public boolean isNumeric(String str){
		   for (int i = str.length() ; --i>=0 ; ){   
		    if (!Character.isDigit(str.charAt ( i ) )&&(str.charAt(i))!='e'&&(str.charAt(i))!='π'){
		     return false;
		    }
		   }
		   return true;
		}

//分析并筛选出有效数字	
   public String parse(String s){
	   String str = s;
	   if(isusal==true){
		   for (int i = s.length();--i>=0;){   
			   if (!Character.isDigit(s.charAt(i))&&s.charAt(i)!='.'){
				   str=s.substring(i+1);
				   break;
			   }
			   }
	   }
		   return str;
	
	   
   }
//处理文本信息并存入集合  
   public void toArrayList(String s){
	   if(isusal==true){
		   if(isFix==false){
			   char c=answer.getText().charAt(answer.getText().length()-1);
			   if(c!='+'&&c!='-'&&c!='×'&&c!='÷'){
				   step++;
				   if(!(answer.getText().equals("0")||answer.getText().equals("")))
				   data.add(step, Double.parseDouble(parse(answer.getText())));
				   sign.add(step,s);
				   a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
				   answer.setText("");
			   }
			   else{
				   answer.setText(answer.getText().substring(0, answer.getText().length()-1));
			   }
		   }
		   else{
			   if(step==sign.size()){
				   sign.add(step, s);
			   }
			   else
			   sign.set(step, s);
			   isFix=false;
		   }
	   }
	   else{
		   
	   }
	   
   }
//计算方法
   public double compute(){
	   double base=data.get(0);
	   for(int i=1;i<data.size();i++){
		   if(data.get(i)==null&&sign.get(i-1)==null){
			   break;
		   }
		   else{
			   if(sign.get(i-1).equals("+")){
				   base=base+data.get(i);
			   }
			   else if(sign.get(i-1).equals("-")){
				   base=base-data.get(i);
			   }
			   else if(sign.get(i-1).equals("÷")){
				   base=base/data.get(i);
			   }
			   else if(sign.get(i-1).equals("×")){
				   base=base*data.get(i);
			   }
			   else if(sign.get(i-1).equals("=")){
//				   base=data.get(i);
			   }
		   }
	   }
	return base;
   }
 //鼠标监听方法	@Override	
public void actionPerformed(ActionEvent e) {
		 frame.requestFocus();
		if(e.getSource()==c||e.getSource()==c2||e.getSource()==gC){
			clear();
			answer.setText("0");
			answerUp.setText("0");
			if(isusal==true){
				data=new ArrayList<Double>();
				sign=new ArrayList<String>();
				step=-1;
			}
			solve();
		}
		else if (e.getSource()==add){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("+");
					toArrayList("+");
					isFix=false;
				}
				else{
					toArrayList("+");
					answer.setText(answer.getText()+"+");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='×'||c=='-'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"+");
			}
			
		}
		else if (e.getSource()==div){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("÷");
					toArrayList("÷");
					isFix=false;
				}
				else{
					toArrayList("÷");
					answer.setText(answer.getText()+"÷");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='-'||c=='×'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"÷");
			}
		}
		else if (e.getSource()==sub){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("-");
					toArrayList("-");
					isFix=false;
				}
				else{
					toArrayList("-");
					answer.setText(answer.getText()+"-");
				}
			}
			else{
				answer.setText(answer.getText()+"-");
			}
			
		}
		else if (e.getSource()==mul){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("×");
					toArrayList("×");
					isFix=false;
				}
				else{
					toArrayList("×");
					answer.setText(answer.getText()+"×");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='-'||c=='×'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"×");
			}
			
		}
		else if (e.getSource()==equal||e.getSource()==equal2){
			clear();
			if(!answer.getText().equals("")){
				fix();
				
				if(isusal==true){
					if(isFix==true){
						data.set(step+1, Double.parseDouble(parse(answer.getText())));
						isFix=false;
						step=data.size()-1;
						answerUp.setText(sign.get(step-1)+data.get(step));
					}
					else{
						toArrayList("=");
						
					}
					answer.setText(answer.getText());
					answer.setVisible(true);
					
					answer.setText("="+compute()+"");
				}
				
				else{
					answer.setText(answer.getText()+"=");
					a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
					Scientificcalculator c=new Scientificcalculator();
					String s=c.javaScript(answer.getText());
				   answer.setText(s);
				   clear();
				   islock=true;
				}
			}
		}
		else if (e.getSource()==point){
			clear();
			if(!answer.getText().contains(".")&&isusal==true){
				answer.setText(answer.getText()+".");
			}
			else if(isusal==false){
				String str=answer.getText();
				if( str.matches("[0-9]+")){
					   answer.setText(answer.getText()+".");
				   }
				for (int i = str.length();--i>=0;){   //次方
					   if (str.charAt(i)=='.'){
						   break;
					   }
					   if(!(Character.isDigit(str.charAt(i))||str.charAt(i)=='e'||str.charAt(i)=='π')){
						   answer.setText(answer.getText()+".");
						   break;
					   }
					   
					   
			}
			}
				 
			solve();
		}
		else if (e.getSource()==delete||e.getSource()==gD){
			clear();
			if(answer.getText().length()>=1){
				if(answer.getText().endsWith("×")||answer.getText().endsWith("÷")
						||answer.getText().endsWith("+")||answer.getText().endsWith("-")
						||answer.getText().endsWith("=")){
					if(isusal==true){
						sign.remove(step);
						isFix=true;
					}
					
				}
				answer.setText(answer.getText().substring(0, answer.getText().length()-1));	
			}
			
			else 
				answer.setText("0");
			
			if(islock==true){
				answer.setText("0");
			}
			solve();
		}
		else if(e.getSource()==one){
			clear();
			answer.setText(answer.getText()+"1");
			solve();
		}
		else if(e.getSource()==two){
			clear();
			answer.setText(answer.getText()+"2");
			solve();
		}
		else if(e.getSource()==three){
			clear();
			answer.setText(answer.getText()+"3");
			solve();
		}
		else if(e.getSource()==four){
			clear();
			answer.setText(answer.getText()+"4");
			solve();
		}
		else if(e.getSource()==five){
			clear();
			answer.setText(answer.getText()+"5");
			solve();
		}
		else if(e.getSource()==six){
			clear();
			answer.setText(answer.getText()+"6");
			solve();
		}
		else if(e.getSource()==seven){
			clear();
			answer.setText(answer.getText()+"7");
			solve();
		}
		else if(e.getSource()==eight){
			clear();
			answer.setText(answer.getText()+"8");
			solve();
		}
		else if(e.getSource()==nine){
			clear();
			answer.setText(answer.getText()+"9");
			solve();
		}
		else if(e.getSource()==zero||e.getSource()==zero2||e.getSource()==zero1){
			clear();
			answer.setText(answer.getText()+"0");
			solve();
		}
		else if(e.getSource()==sin){
			clear();
			answer.setText(answer.getText()+"sin(");
		}
		else if(e.getSource()==leftKH){
			clear();
			answer.setText(""+answer.getText()+"(");
		}
		else if(e.getSource()==rightKH){
			clear();
			answer.setText(""+answer.getText()+")");
		}
		else if(e.getSource()==cos){
			clear();
			answer.setText(answer.getText()+"cos(");
		}
		else if(e.getSource()==tan){
			clear();
			answer.setText(answer.getText()+"tan(");
		}
		else if(e.getSource()==log){
			clear();
			answer.setText(""+answer.getText()+"log(");
		}
		else if(e.getSource()==ln){
			clear();
			answer.setText(answer.getText()+"ln(");
		}
		else if(e.getSource()==ganTan){
			clear();
            if(answer.getText().equals("")){
				answer.setText("0");
			}
			answer.setText(""+answer.getText()+"!");
		}
		else if(e.getSource()==this.e){
			clear();
			
			answer.setText(""+answer.getText()+"e");
		}
		else if(e.getSource()==pai){
			clear();
			answer.setText(""+answer.getText()+"π");
		}
		else if(e.getSource()==gen){
			clear();
			answer.setText(""+answer.getText()+"√");
		}
		else if(e.getSource()==ciFang){
			clear();
			answer.setText(""+answer.getText()+"^");
		}
		else if(e.getSource()==x1){
			choose2=1;
			
			getHuilv();
			frame2.dispose();
			frame5();
			huilv1.setText("1");
			answer.setText("1");
			solve();
			}
		else if(e.getSource()==x2){
			choose2=2;
			judge2();
			frame2.dispose();
			frame10();
		}
		else if(e.getSource()==x3){
			choose2=3;
			judge2();
			frame2.dispose();
			frame11();
		}
		else if(e.getSource()==x4){
			choose2=4;
			answer.setText("");
			frame6up.setText("0");
			frame6down.setText("零");
			frame2.dispose();
			frame6();
		}
		else if(e.getSource()==x5){
			choose2=5;
			frame2.dispose();
			frame3();
		}
		else if(e.getSource()==x6){
			choose2=6;
			frame2.dispose();
			frame2();
		}
		else if(e.getSource()==x7){
			choose2=7;
			judge2();
			frame2.dispose();
			frame8();
		}
		else if(e.getSource()==x8){
			choose2=8;
			judge2();
			frame2.dispose();
			frame7();
		}
		else if(e.getSource()==x9){
			choose2=9;
			judge2();
			frame2.dispose();
			frame9();
		}
	}

//处理文本变换更改信息
	private void solve() {
		if(choose2==4){
			String s=answer.getText();
			frame6up.setText(s);
			Change v=new Change();
			frame6down.setText(v.numtochinese(answer.getText()));
		}
		if(choose2==1){
			
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			huilv1.setText(s);
			if(L1.getText().equals("人民币")){
				renminbi=Double.parseDouble(huilv1.getText());
				meiyuan=meiyuanhuilv*Double.parseDouble(huilv1.getText());
				ouyuan=ouyuanhuilv*Double.parseDouble(huilv1.getText());
				riyuan=riyuanhuilv*Double.parseDouble(huilv1.getText());
				hanyuan=hanyuanhuilv*Double.parseDouble(huilv1.getText());
				jiayuan=jiayuanhuilv*Double.parseDouble(huilv1.getText());
			}
			else{
				if(L1.getText().equals("美元")){
					meiyuan=Double.parseDouble(huilv1.getText());
					renminbi=1.0/meiyuanhuilv*meiyuan;
					jiayuan=jiayuanhuilv*renminbi;
					ouyuan=ouyuanhuilv*renminbi;
					riyuan=riyuanhuilv*renminbi;
					hanyuan=hanyuanhuilv*renminbi;
				}
				else if(L1.getText().equals("加元")){
					jiayuan=Double.parseDouble(huilv1.getText());
					renminbi=1.0/jiayuanhuilv*jiayuan;
					meiyuan=meiyuanhuilv*renminbi;
					ouyuan=ouyuanhuilv*renminbi;
					riyuan=riyuanhuilv*renminbi;
					hanyuan=hanyuanhuilv*renminbi;
				}
				else if(L1.getText().equals("欧元")){
					ouyuan=Double.parseDouble(huilv1.getText());
					renminbi=1.0/ouyuanhuilv*ouyuan;
					meiyuan=meiyuanhuilv*renminbi;
					jiayuan=jiayuanhuilv*renminbi;
					riyuan=riyuanhuilv*renminbi;
					hanyuan=hanyuanhuilv*renminbi;
				}
				else if(L1.getText().equals("日元")){
					riyuan=Double.parseDouble(huilv1.getText());
					renminbi=1.0/riyuanhuilv*riyuan;
					meiyuan=meiyuanhuilv*renminbi;
					ouyuan=ouyuanhuilv*renminbi;
					jiayuan=jiayuanhuilv*renminbi;
					hanyuan=hanyuanhuilv*renminbi;
				}
				else if(L1.getText().equals("韩元")){
					hanyuan=Double.parseDouble(huilv1.getText());
					renminbi=1.0/hanyuanhuilv*hanyuan;
					meiyuan=meiyuanhuilv*renminbi;
					ouyuan=ouyuanhuilv*renminbi;
					jiayuan=jiayuanhuilv*renminbi;
					riyuan=riyuanhuilv*renminbi;
				}
			} 
            meiyuan=rounding(meiyuan);
            renminbi=rounding(renminbi);
            jiayuan=rounding(jiayuan);
            ouyuan=rounding(ouyuan);
            riyuan=rounding(riyuan);
            hanyuan=rounding(hanyuan);
			huilv1.setText(String.format("%.2f", Double.parseDouble(money(L1.getText()))));
			huilv3.setText(String.format("%.2f", Double.parseDouble(money(L2.getText()))));
			huilv5.setText(String.format("%.2f", Double.parseDouble(money(L3.getText()))));
		}
		else if(choose2==2){
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			upNum.setText(s);
			if(up.getText().contains("摄氏度")){
				sheshidu=Double.parseDouble(s);
			}
			else if(up.getText().contains("华氏度")){
				sheshidu=(Double.parseDouble(s)-32)/1.8;
			}
			else if(up.getText().contains("开尔文")){
				sheshidu=(Double.parseDouble(s))-273.15;
			}
			if(down.getText().contains(("摄氏度"))){
				downNum.setText(String.format("%.2f",sheshidu));
			}
			else if(down.getText().contains(("华氏度"))){
				downNum.setText(String.format("%.2f",(sheshidu*1.8+32)));
			}
			else if(down.getText().contains(("开尔文"))){
				downNum.setText(String.format("%.2f",(sheshidu+273.15)));
			}
		}
		else if(choose2==3){
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			upNum.setText(s);
			if(up.getText().contains("m/s")){
				speed=Double.parseDouble(s);
			}
			else if(up.getText().contains("km/s")){
				speed=Double.parseDouble(s)/1000;
			}
			else if(up.getText().contains("cm/s")){
				speed=Double.parseDouble(s)*100;
			}
			else if(up.getText().contains("dm/s")){
				speed=Double.parseDouble(s)*10;
			}
			else if(up.getText().contains("km/h")){
				speed=Double.parseDouble(s)/3.6;
			}
			if(down.getText().contains(("(m/s)"))){
				downNum.setText(String.format("%.3f",speed));
			}
			else if(down.getText().contains(("km/s"))){
				downNum.setText(String.format("%.3f",speed/1000));
			}
			else if(down.getText().contains(("cm/s"))){
				downNum.setText(String.format("%.2f",speed*100));
			}
			else if(down.getText().contains(("dm/s"))){
				downNum.setText(String.format("%.2f",speed*10));
			}
			else if(down.getText().contains(("km/h"))){
				downNum.setText(String.format("%.2f",speed*3.6));
			}
		}
		else if(choose2==7){
			double d=0.0;
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			upNum.setText(s);
			if(up.getText().contains("平方米")){
				d=Double.parseDouble(s);
			}
			else if(up.getText().contains("平方厘米")){
				d=Double.parseDouble(s)/10000;
			}
			else if(up.getText().contains("平方分米")){
				d=Double.parseDouble(s)/100;
			}
			else if(up.getText().contains("亩")){
				d=Double.parseDouble(s)/0.0015;
			}
			else if(up.getText().contains("顷")){
				d=Double.parseDouble(s)*10000;
			}
			if(down.getText().contains(("平方米"))){
				downNum.setText(String.format("%.3f",d));
			}
			else if(down.getText().contains(("平方厘米"))){
				downNum.setText(String.format("%.2f",d*10000));
			}
			else if(down.getText().contains(("平方分米"))){
				downNum.setText(String.format("%.2f",d*100));
			}
			else if(down.getText().contains(("亩"))){
				downNum.setText(String.format("%.3f",d*0.0015));
			}
			else if(down.getText().contains(("顷"))){
				downNum.setText(String.format("%.3f",d/10000));
			}
		}
		else if(choose2==8){
			double d=0.0;
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			upNum.setText(s);
			if(up.getText().contains("秒/s")){
				d=Double.parseDouble(s);
			}
			else if(up.getText().contains("分")){
				d=Double.parseDouble(s)*60;
			}
			else if(up.getText().contains("时")){
				d=Double.parseDouble(s)*3600;
			}
			else if(up.getText().contains("天")){
				d=Double.parseDouble(s)*3600*24;
			}
			else if(up.getText().contains("毫秒")){
				d=Double.parseDouble(s)/1000;
			}
			if(down.getText().contains(("秒/s"))){
				downNum.setText(String.format("%.3f",d));
			}
			else if(down.getText().contains(("分"))){
				downNum.setText(String.format("%.2f",d/60));
			}
			else if(down.getText().contains(("时"))){
				downNum.setText(String.format("%.2f",d/3600));
			}
			else if(down.getText().contains(("天"))){
				downNum.setText(String.format("%.3f",d/3600/24));
			}
			else if(down.getText().contains(("毫秒"))){
				downNum.setText(String.format("%.3f",d*1000));
			}
		}
		else if(choose2==9){
			double d=0.0;
			String s=answer.getText();
			if(answer.getText().equals("")){
				s="0";
			}
			upNum.setText(s);
			if(up.getText().contains("立方厘米")){
				d=Double.parseDouble(s);
			}
			else if(up.getText().contains("立方米")){
				d=Double.parseDouble(s)*1000000;
			}
			else if(up.getText().contains("立方分米")){
				d=Double.parseDouble(s)*1000;
			}
			else if(up.getText().contains("毫升")){
				d=Double.parseDouble(s);
			}
			else if(up.getText().contains("升")){
				d=Double.parseDouble(s)*1000;
			}
			if(down.getText().contains(("立方厘米"))){
				downNum.setText(String.format("%.2f",d));
			}
			else if(down.getText().contains(("立方米"))){
				downNum.setText(String.format("%.6f",d/1000000));
			}
			else if(down.getText().contains(("立方分米"))){
				downNum.setText(String.format("%.3f",d/1000));
			}
			else if(down.getText().contains(("毫升"))){
				downNum.setText(String.format("%.2f",d));
			}
			else if(down.getText().contains(("升"))){
				downNum.setText(String.format("%.6f",d/1000));
			}
		}
		downNum.setText(detelepoint(downNum.getText()));
		upNum.setText(upNum.getText());
		huilv1.setText(detelepoint(huilv1.getText()));
		huilv3.setText(detelepoint(huilv3.getText()));
		huilv5.setText(detelepoint(huilv5.getText()));
	}
//删除无用的小数点及小数点之后的无效数字
	public String detelepoint(String d1){
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
	return d1;
}
//四舍五入并保留俩位小数的方法
	public double rounding (double f){
	BigDecimal   b   =   new   BigDecimal(f);  
	return b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
    }
	
//判断是否为修改步骤
public void fix(){
	if(step<sign.size()-1){
		isFix=true;
	}
	char c=answer.getText().charAt(answer.getText().length()-1);
	if(c=='+'||c=='×'||c=='-'||c=='÷'){
		answer.setText(answer.getText().substring(0, answer.getText().length()-1));
		isFix=true;
	}
}
//处理输入前的方法
public void clear(){
	if(answer.getText().equals("0")){
		  answer.setText("");
	  }
	if(answer.getText().length()>6&&answer.getText().length()<12){
		answer.setFont(new java.awt.Font("Dialog", 1, 50));
	}
	else if(answer.getText().length()>=12&&answer.getText().length()<18){
		answer.setFont(new java.awt.Font("Dialog", 1, 30));
	}
	else if(answer.getText().length()>=18){
		answer.setFont(new java.awt.Font("Dialog", 1, 25));
	}
	else{
		answer.setFont(new java.awt.Font("Dialog", 1, 80));
	}
	if(frame6down.getText().length()>5&&frame6down.getText().length()<9){
		frame6down.setFont(new java.awt.Font("Dialog", 1, 30));
	}
	else if(frame6down.getText().length()>=9&&frame6down.getText().length()<13){
		frame6down.setFont(new java.awt.Font("Dialog", 1, 20));
	}
	else if(frame6down.getText().length()>=13){
		frame6down.setFont(new java.awt.Font("Dialog", 1, 14));
	}
	else{
		frame6down.setFont(new java.awt.Font("Dialog", 1, 50));
	}
	if(isusal==false&&islock==true){
		if(answerUp.getText().contains("=")){
			answer.setText("");
		}
		islock=false;
	}
	
}
//键盘监听器及快捷键
@Override
	
	public void keyTyped(KeyEvent evt) {
		char e=evt.getKeyChar();
		if (e=='+'){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("+");
					toArrayList("+");
					isFix=false;
				}
				else{
					toArrayList("+");
					answer.setText(answer.getText()+"+");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='×'||c=='-'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"+");
			}
		}
		else if (e=='/'){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("÷");
					toArrayList("÷");
					isFix=false;
				}
				else{
					toArrayList("÷");
					answer.setText(answer.getText()+"÷");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='-'||c=='×'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"÷");
			}
		}
		else if (e=='*'){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("×");
					toArrayList("×");
					isFix=false;
				}
				else{
					toArrayList("×");
					answer.setText(answer.getText()+"×");
				}
			}
			else{
				char c=answer.getText().charAt(answer.getText().length()-1);
				if(c=='+'||c=='-'||c=='×'||c=='÷'){
					answer.setText(answer.getText().substring(0, answer.getText().length()-1));
				}
				answer.setText(answer.getText()+"×");
			}
		}
		else if (e=='-'){
			clear();
			if(isusal==true){
				fix();
				if(isFix==true){
					answer.setText("-");
					toArrayList("-");
					isFix=false;
				}
				else{
					toArrayList("-");
					answer.setText(answer.getText()+"-");
				}
			}
			else{
				answer.setText(answer.getText()+"-");
			}
		}
		else if (e == KeyEvent.VK_ENTER){
			clear();
			if(!answer.getText().equals("")){
				fix();
				
				if(isusal==true){
					if(isFix==true){
						data.set(step+1, Double.parseDouble(parse(answer.getText())));
						isFix=false;
						step=data.size()-1;
						answerUp.setText(sign.get(step-1)+data.get(step));
					}
					else{
						toArrayList("=");
					}
					answer.setText(answer.getText());
					answer.setVisible(true);
					answer.setText("="+compute()+"");
				}
				else{
					answer.setText(answer.getText()+"=");
					a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
					Scientificcalculator c=new Scientificcalculator();
					String s=c.javaScript(answer.getText());
				   answer.setText(s);
				   clear();
				   islock=true;
				}
			}
		}
		else if (e=='.'){
			clear();
			if(!answer.getText().contains(".")&&isusal==true){
				answer.setText(answer.getText()+".");
			}
			else if(isusal==false){
				String str=answer.getText();
				if( str.matches("[0-9]+")){
					   answer.setText(answer.getText()+".");
				   }
				for (int i = str.length();--i>=0;){
					   if (str.charAt(i)=='.'){
						   break;
					   }
					   if(!(Character.isDigit(str.charAt(i))||str.charAt(i)=='e'||str.charAt(i)=='π')){
						   answer.setText(answer.getText()+".");
						   break;
					   }
			}
			}	 
			solve();
		}
		else if(evt.getKeyCode()==KeyEvent.VK_UP){
			if(step>0){
	    		a.animationDown(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
		    	if(step>=2&&step!=data.size()){
			    	answerUp.setText(sign.get(step-2)+data.get(step-1));
			    	step=step-1;
		    	}
		    	else if(step>2&&step==data.size()){
			    	answerUp.setText(sign.get(step-3)+data.get(step-2));
			    	step=step-2;
		    	}
		    	else if(step>0){
		    		answerUp.setText(""+data.get(step-1));
		    		step=step-1;
		    	}
		    		
		    	else
		    		answerUp.setText("0");
	    	}
	    	else if(!answerUp.getText().equals("0")){
	    		a.animationDown(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
	    		answerUp.setText("0");
	    	}
		}
		else if(e==KeyEvent.VK_DOWN){
			if(step<data.size()-1){
	    		a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
	    		answer.setText(sign.get(step)+data.get(step+1));
	    		step++;
	    	}
	    	else if(step==data.size()-1&&!answerUp.getText().equals(sign.get(step-1)+data.get(step))){
	    	    a.animationUp(answer,answerMiddle,answerMiddle2,answerMiddle3,answerMiddle4,answerUp);
		    	answer.setText(sign.get(step)+compute());
	    		
	    	}
	    	else{
	    		
	    	}
		}
		else if (e==KeyEvent.VK_BACK_SPACE){
			clear();
			if(answer.getText().length()>1){
				if(answer.getText().endsWith("×")||answer.getText().endsWith("÷")
						||answer.getText().endsWith("+")||answer.getText().endsWith("-")
						||answer.getText().endsWith("=")){
					if(isusal==true){
						sign.remove(step);
						isFix=true;
					}
					
				}
				answer.setText(answer.getText().substring(0, answer.getText().length()-1));	
			}
			
			else 
				answer.setText("0");
			
			if(islock==true){
				answer.setText("0");
			}
			solve();
		}
		
		else if(e=='1'){
			clear();
			answer.setText(answer.getText()+"1");
			solve();
		}
		else if(e=='2'){
			clear();
			answer.setText(answer.getText()+"2");
			solve();
		}
		else if(e=='3'){
			clear();
			answer.setText(answer.getText()+"3");
			solve();
		}
		else if(e=='4'){
			clear();
			answer.setText(answer.getText()+"4");
			solve();
		}
		else if(e=='5'){
			clear();
			answer.setText(answer.getText()+"5");
			solve();
		}
		else if(e=='6'){
			clear();
			answer.setText(answer.getText()+"6");
			solve();
		}
		else if(e=='7'){
			clear();
			answer.setText(answer.getText()+"7");
			solve();
		}
		else if(e=='8'){
			clear();
			answer.setText(answer.getText()+"8");
			solve();
		}
		else if(e=='9'){
			clear();
			answer.setText(answer.getText()+"9");
			solve();
		}
		else if(e=='0'){
			clear();
			answer.setText(answer.getText()+"0");
			solve();
		}
		else if(e=='s'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"sin(");
			}
		}
		else if(e=='('){
			clear();
			answer.setText(answer.getText()+"(");
		}
		else if(e=='c'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"cos(");
			}
		}
		else if(e=='t'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"tan(");
			}
		}
		else if(e=='l'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"log(");
			}
		}
		else if(e=='n'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"ln(");
			}
		}
		else if(e=='e'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"e");
			}
		}
		else if(e=='p'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"π");
			}
		}
		else if(e=='f'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"^");
			}
		}
		else if(e=='g'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"√");
			}
		}
		else if(e=='j'){
			if(isusal==false){
				clear();
				answer.setText(answer.getText()+"!");
			}
		}
		else if(e=='q'){
			clear();
			answer.setText("0");
			answerUp.setText("0");
			if(isusal==true){
				data=new ArrayList<Double>();
				sign=new ArrayList<String>();
				step=-1;
			}
			solve();
		}
		else if(e=='a'){
			clear();
			answer.setText(""+answer.getText()+"(");
		}
		else if(e=='d'){
			clear();
			answer.setText(""+answer.getText()+")");
		}
		else{
			evt.consume();
		}
		
	}
//科学计算器的界面
private void frame2() {
		
		if(choose2!=5){
			frame.setLocation(frame2.getX(), frame2.getY());
		}
		choose2=6;
		isusal=false;
		sjt.setEnabled(false);
		xjt.setEnabled(false);
		sjt.setVisible(false);
		xjt.setVisible(false);
		// TODO Auto-generated method stub
		c.setVisible(false);
		frame.setVisible(true);
		
		equal.setVisible(false);
		zero.setVisible(false);
		answer.setText("0");
		buttonArea2.removeAll();
		buttonArea2.setLayout(null);
		topArea(buttonArea2);
		contentPane.remove(buttonArea2);
		 buttonArea.setLayout(new GridLayout(6,5));
		    buttonArea.add(ganTan);
		    buttonArea.add(ciFang);
		    buttonArea.add(gen);
		    buttonArea.add(pai);
		    buttonArea.add(c2);
		    buttonArea.add(sin);
		    buttonArea.add(leftKH);
		    buttonArea.add(rightKH);
		    buttonArea.add(e);
		    buttonArea.add(delete);
		    buttonArea.add(cos);
		    buttonArea.add(seven);
		    buttonArea.add(eight);
		    buttonArea.add(nine);
		    buttonArea.add(div);
		    buttonArea.add(tan);
		    buttonArea.add(four);
		    buttonArea.add(five);
		    buttonArea.add(six);
		    buttonArea.add(mul);
		    buttonArea.add(ln);
		    buttonArea.add(one);
		    buttonArea.add(two);
		    buttonArea.add(three);
		    buttonArea.add(sub);
		    buttonArea.add(log);
		    buttonArea.add(zero2);
		    buttonArea.add(point);
		    buttonArea.add(equal2);
		    buttonArea.add(add);
		    contentPane.add(buttonArea);
		    buttonArea.setBounds(0, 230, 385, 425);
		    
			
	}
	private void frame3() {//普通计算
		if(choose2!=6){
			frame.setLocation(frame2.getX(), frame2.getY());
		}
		choose2=5;
		sjt.setEnabled(true);
		xjt.setEnabled(true);
		sjt.setVisible(true);
		xjt.setVisible(true);
		isusal=true;
		contentPane.remove(buttonArea);
		frame.setVisible(true);
		c.setVisible(true);
		equal.setVisible(true);
		zero.setVisible(true);
		answer.setText("0");

		buttonArea2.removeAll();
		buttonArea2.setLayout(null);
		topArea(buttonArea2);
//		
	}
	private void frame4() {//功能界面
		if(choose2==1){
			frame2.setLocation(frame4.getX(),frame4.getY());
		}
		else if(choose2==2){
			frame2.setLocation(frame8.getX(),frame8.getY());
		}
		else if(choose2==3){
			frame2.setLocation(frame9.getX(),frame9.getY());
		}
		else if(choose2==4){
			frame2.setLocation(frame3.getX(),frame3.getY());
		}
		else if(choose2==5||choose2==6){
			frame2.setLocation(frame.getX(),frame.getY());
		}
		else if(choose2==7){
			frame2.setLocation(frame6.getX(),frame6.getY());
		}
		else if(choose2==8){
			frame2.setLocation(frame5.getX(),frame5.getY());
		}
		else if(choose2==9){
			frame2.setLocation(frame7.getX(),frame7.getY());
		}
		frame.dispose();		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame2.setSize(390,683);
		frame2.setVisible(true);
		contentPane2.removeAll();
		contentPane2.setLayout(new GridLayout(3,3));
		contentPane2.add(x1);
		contentPane2.add(x2);
		contentPane2.add(x3);
		contentPane2.add(x4);
		contentPane2.add(x5);
		contentPane2.add(x6);
		contentPane2.add(x7);
		contentPane2.add(x8);
		contentPane2.add(x9);
		

		
	}
	private void frame5() {//汇率转换
		// TODO Auto-generated method stub
		frame.dispose();
		frame4.setLocation(frame2.getX(), frame2.getY());
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame4.setSize(390,683);
		frame4.setVisible(true);
		contentPane4.removeAll();
		contentPane4.setLayout(null);
		
		gongNeng.setBounds(5, 5, 45, 45);
		contentPane4.add(gongNeng);
		
		gongNeng2.setBounds(5, 5, 45, 45);
		contentPane4.add(gongNeng2);
		gongNeng2.setVisible(false);
		
		top.setBounds(165, 15, 105, 25);
		top.setText("汇率转换");
		contentPane4.add(top);
		
		L1.setBounds(10, 60,180, 63);
		contentPane4.add(L1);
		
		huilv1.setBounds(200, 60,180, 35);
		huilv1.setFont(new java.awt.Font("Dialog", 1, 35));
		huilv1.setForeground(new Color(236,113,43));
		contentPane4.add(huilv1);
		
		huilv2.setBounds(200, 95,180, 35);
		huilv2.setFont(new java.awt.Font("Dialog", 1, 15));
		contentPane4.add(huilv2);
		
		L2.setBounds(10, 140,180, 63);
		contentPane4.add(L2);
		
		huilv3.setBounds(200, 140,180, 35);
		huilv3.setFont(new java.awt.Font("Dialog", 1, 35));
		contentPane4.add(huilv3);
		
		huilv4.setBounds(200, 179,180, 35);
		huilv4.setFont(new java.awt.Font("Dialog", 1, 15));
		contentPane4.add(huilv4);
		
		
		L3.setBounds(10, 220,180, 63);
		contentPane4.add(L3);
		
		huilv5.setBounds(200, 230,180, 35);
		huilv5.setFont(new java.awt.Font("Dialog", 1, 35));
		contentPane4.add(huilv5);
		
		huilv6.setBounds(200, 275,180, 15);
		huilv6.setFont(new java.awt.Font("Dialog", 1, 15));
		contentPane4.add(huilv6);
		
		time.setBounds(100, 280,180, 35);
		contentPane4.add(time);
		
		downArea(contentPane4);
		
	
		
	}

	private void frame6() {//大写转换
		
		
		frame.dispose();
		frame3.setLocation(frame2.getX(), frame2.getY());
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame3.setSize(390,683);
		frame3.setVisible(true);
		contentPane3.removeAll();
		contentPane3.setLayout(null);
		gongNeng.setBounds(5, 5, 45, 45);
		contentPane3.add(gongNeng);
		
		gongNeng2.setBounds(5, 5, 45, 45);
		contentPane3.add(gongNeng2);
		gongNeng2.setVisible(false);
		
		top.setBounds(165, 15, 105, 25);
		top.setText("大写数字");
		contentPane3.add(top);
		
		frame6up.setBounds(0, 100, 385, 40);
		frame6up.setFont(new java.awt.Font("Dialog", 1, 35));
		frame6up.setForeground(new Color(236,113,43));
		contentPane3.add(frame6up);
		
		frame6down.setBounds(0, 260, 385, 40);
		frame6down.setFont(new java.awt.Font("Dialog", 1, 35));
		contentPane3.add(frame6down);
		
		downArea(contentPane3);
		
		
	}

	private void frame7() {//时间转换
		up.setText("秒/s▼");
		down.setText("分/min▼");
		upNum.setText("1");
		downNum.setText("0.02");
		
		
		frame.dispose();
		frame5.setLocation(frame2.getX(), frame2.getY());
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame5.setSize(390,683);
		frame5.setVisible(true);	
		contentPane5.removeAll();
		contentPane5.setLayout(null);
		

		top.setText("时间单位换算");
		upArea(contentPane5);
		
		downArea(contentPane5);
	}
	
	private void frame8() {//面积转换
		
		up.setText("平方米/m²▼");
		down.setText("平方厘米/cm²▼");
		upNum.setText("1");
		downNum.setText("10000");

		
		frame.dispose();
		frame6.setLocation(frame2.getX(), frame2.getY());
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame6.setSize(390,683);
		frame6.setVisible(true);	
		contentPane6.removeAll();
		contentPane6.setLayout(null);
		
		top.setText("面积单位换算");
		upArea(contentPane6);
		
		downArea(contentPane6);
	}
	
	private void frame9() {//体积转换

		
		up.setText("立方厘米/cm³▼");
		down.setText("立方分米/dm³▼");
		upNum.setText("1");
		downNum.setText("0.001");
		
		frame.dispose();
		frame7.setLocation(frame2.getX(), frame2.getY());
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame7.setSize(390,683);
		frame7.setVisible(true);	
		contentPane7.removeAll();
		contentPane7.setLayout(null);
		
		top.setText("体积单位换算");

		upArea(contentPane7);
		
		downArea(contentPane7);
	}
	
	private void frame10() {//温度转换

		
		up.setText("摄氏度(℃) ◀▶");
		down.setText("华氏度(°F) ◀▶");
		upNum.setText("1");
		downNum.setText("33.8");
		
		frame.dispose();
		frame8.setLocation(frame2.getX(), frame2.getY());
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame8.setSize(390,683);
		frame8.setVisible(true);
		contentPane8.removeAll();
		contentPane8.setLayout(null);
		
		top.setText("温度单位换算");
		upArea(contentPane8);
		downArea(contentPane8);
	}
	
	private void frame11() {//速度转换
		
		up.setText("米/秒(m/s)▼");
		down.setText("千米/秒(km/s)▼");
		upNum.setText("1");
		downNum.setText("0.001");
		
		frame.dispose();
		frame9.setLocation(frame2.getX(), frame2.getY());
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame9.setSize(390,683);
		frame9.setVisible(true);
		contentPane9.removeAll();
		contentPane9.setLayout(null);
		

		top.setText("速度单位换算");
		upArea(contentPane9);
		
		downArea(contentPane9);
	}
	private void frame12() {//汇率的小窗口
		frame.dispose();
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame10.setSize(190,230);
		frame10.setVisible(true);	
		frame10.setLocation(frame4.getLocation().x+100, frame4.getLocation().y+200);
		frame10.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane10.removeAll();
		contentPane10.setLayout(null);
		
		L4.setBounds(5, 0, 180, 65);
		contentPane10.add(L4);
		
		L5.setBounds(5, 65, 180, 65);
		contentPane10.add(L5);
		
		L6.setBounds(5, 130, 180, 65);
		contentPane10.add(L6);
	}
	
	private void frame13() {//其他小窗口
		frame.dispose();
		
		
		
		 
		if(choose2==3){
			frame11.setLocation(frame9.getX()+100,frame9.getY()+200);
		}
		else if(choose2==7){
			frame11.setLocation(frame6.getX()+100,frame6.getY()+200);
		}
		else if(choose2==8){
			frame11.setLocation(frame5.getX()+100,frame5.getY()+200);
		}
		else if(choose2==9){
			frame11.setLocation(frame7.getX()+100,frame7.getY()+200);
		}
		frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame11.setSize(180,230);
		frame11.setVisible(true);	
		frame11.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane11.removeAll();
		contentPane11.setLayout(null);
		
		label1.setBounds(0, 0, 160, 65);
		contentPane11.add(label1);
		
		label2.setBounds(0, 65, 160, 65);
		contentPane11.add(label2);
		
		label3.setBounds(0, 130, 160, 65);
		contentPane11.add(label3);
	}
	
//上部相同的界面	
	private void upArea(Container contentPane8){
		
		up.setBounds(10, 100, 260, 40);
		contentPane8.add(up);
		
		down.setBounds(10, 260, 260, 40);
		contentPane8.add(down);
		
		upNum.setBounds(100, 100, 260, 40);
		upNum.setFont(new java.awt.Font("Dialog", 1, 35));
		upNum.setForeground(new Color(236,113,43));
		contentPane8.add(upNum);
		
		downNum.setBounds(100, 260, 260, 40);
		downNum.setFont(new java.awt.Font("Dialog", 1, 35));
		contentPane8.add(downNum);
		
		
		gongNeng.setBounds(5, 5, 45, 45);
		contentPane8.add(gongNeng);
		
		gongNeng2.setBounds(5, 5, 45, 45);
		contentPane8.add(gongNeng2);
		gongNeng2.setVisible(false);
		
		top.setBounds(125, 15, 205, 25);
		contentPane8.add(top);
	}
//	下部相同的界面	
	private void downArea(Container contentPane3) {
		// TODO Auto-generated method stub
		zero1.setBounds(0, 570,192, 85);
		contentPane3.add(zero1);
		
		seven.setBounds(0, 315,96, 85);
		contentPane3.add(seven);

		
		eight.setBounds(96, 315,96, 85);
		contentPane3.add(eight);
				
		nine.setBounds(192, 315,96, 85);
		contentPane3.add(nine);
		
		gC.setBounds(288, 315,96, 170);
		contentPane3.add(gC);
		
		four.setBounds(0, 400,96, 85);
		contentPane3.add(four);
		
		five.setBounds(96, 400,96, 85);
		contentPane3.add(five);
		
		six.setBounds(192, 400,96, 85);
		contentPane3.add(six);
		
		
		one.setBounds(0, 485,96, 85);
		contentPane3.add(one);
		
		two.setBounds(96, 485,96, 85);
		contentPane3.add(two);
		
		three.setBounds(192, 485,96, 85);
		contentPane3.add(three);
		
		gD.setBounds(288, 485,96, 170);
		contentPane3.add(gD);
		
		
		
		point.setBounds(192, 570,96, 85);
		contentPane3.add(point);
		
		pictureBackGround2.setBounds(-6, 0, 400, 317);
		contentPane3.add(pictureBackGround2);
	}


	//接口所需
	@Override
	public void keyPressed(KeyEvent e) {}


	@Override
	public void keyReleased(KeyEvent e) {}
	

}
