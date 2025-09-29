import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag=false;
	private ThreadFinishFlagEx parent;
	public RandomThread(Container contentPane, ThreadFinishFlagEx parent) {
		this.contentPane = contentPane;
		this.parent = parent;
	}
	void finish() {
	flag = true;
	
	}
	public void run() {
		while(true) {
			int x= (int)(Math.random()*(contentPane.getWidth()-80));
			int y= (int)(Math.random()*(contentPane.getHeight()-30));
			String[] texts = {"김형준", "히히힛", "멍충이", "바보"};
			String randomText = texts[(int)(Math.random() * texts.length)];
			JLabel label = new JLabel(randomText);
			label.setSize(200, 100);
			label.setLocation(x, y);
			label.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					parent.finishThread();
				}
			});
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(300);
				if(flag==true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(200, 100);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return;
					
				}
			}
			catch(InterruptedException e) {
				return; 
				}
		}
		
	}
}
public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th; 
	
	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlagEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		// 마우스 리스너 제거 - 이제 라벨을 클릭해야 끝남
		setSize(300,200); 
		setVisible(true);
		
		th = new RandomThread(c, this);
		th.start();
	}
	
	public void finishThread() {
		th.finish();
	}
		public static void main(String[] args) { 
			new ThreadFinishFlagEx();
		}
	}
	


