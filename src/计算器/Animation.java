package 计算器;
/** 
*
*
**/
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Animation {
	public void animationUp(JLabel answer,JLabel answerMiddle,JLabel answerMiddle2,JLabel answerMiddle3,JLabel answerMiddle4,JLabel answerUp){
		String s=answer.getText();
		answerMiddle.setText(s);
		answerMiddle2.setText(s);
		answerMiddle3.setText(s);
		answerMiddle4.setText(s);
		answerUp.setText(s);
		Timer timer = new Timer();  
        
        timer.schedule(new TimerTask() {  
  
            @Override  
            public void run() {  
            	
//            	answer.setVisible(false); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                if (true) {  
                    //throw new RuntimeException("error");   // 解除注释 程序运行到此处将结束Timer线程，并抛出异常  
                }  
                
            }  
              
        }, 0);  
        
        timer.schedule(new TimerTask() {  
	      	  
            @Override  
            public void run() {  
            	
            	answerMiddle4.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle4.setVisible(false); 
                
            }  
              
        }, 25);  
        
        timer.schedule(new TimerTask() {  
      	  
            @Override  
            public void run() {  
            	
            	answerMiddle3.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle3.setVisible(false); 
                
            }  
              
        }, 50);  
        
        timer.schedule(new TimerTask() {  
      	  
            @Override  
            public void run() {  
            	
            	answerMiddle2.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle2.setVisible(false); 
                
            }  
              
        }, 75);  
        
        timer.schedule(new TimerTask() {  
        	  
            @Override  
            public void run() {  
            	answerMiddle.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle.setVisible(false);  
            }  
              
        }, 100); 
        
        timer.schedule(new TimerTask() {  
        	  
            @Override  
            public void run() {  
            	answerUp.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                
            }  
              
        }, 125); 
        

		}
	public void animationDown(JLabel answer,JLabel answerMiddle,JLabel answerMiddle2,JLabel answerMiddle3,JLabel answerMiddle4,JLabel answerUp){
		answerMiddle.setText(answerUp.getText());
		answerMiddle2.setText(answerUp.getText());
		answerMiddle3.setText(answerUp.getText());
		answerMiddle4.setText(answerUp.getText());
		answer.setText(answerUp.getText());
		Timer timer = new Timer();  
        
        timer.schedule(new TimerTask() {  
  
            @Override  
            public void run() {  
            	
            	answer.setVisible(false); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                if (true) {  
                    //throw new RuntimeException("error");   // 解除注释 程序运行到此处将结束Timer线程，并抛出异常  
                }  
                
            }  
              
        }, 0);  
        
        timer.schedule(new TimerTask() {  
	      	  
            @Override  
            public void run() {  
            	
            	answerMiddle.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle.setVisible(false); 
                
            }  
              
        }, 25);  
        
        timer.schedule(new TimerTask() {  
      	  
            @Override  
            public void run() {  
            	
            	answerMiddle2.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle2.setVisible(false); 
                
            }  
              
        }, 50);  
        
        timer.schedule(new TimerTask() {  
      	  
            @Override  
            public void run() {  
            	
            	answerMiddle3.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle3.setVisible(false); 
                
            }  
              
        }, 75);  
        
        timer.schedule(new TimerTask() {  
        	  
            @Override  
            public void run() {  
            	answerMiddle4.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                answerMiddle4.setVisible(false);  
            }  
              
        }, 100); 
        
        timer.schedule(new TimerTask() {  
        	  
            @Override  
            public void run() {  
            	answer.setVisible(true); 
                try {  
                    Thread.sleep(25);  
                } catch(Exception e) {  
                    e.printStackTrace();  
                }  
                
            }  
              
        }, 125); 
        

		}
}
