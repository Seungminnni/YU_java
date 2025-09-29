import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MyLabel extends JLabel{
	int barSize = 0;
	int maxBarSize;
	
	MyLabel(int maxBarSize) { 
		this.maxBarSize = maxBarSize;
	}

	
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.MAGENTA);
	int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
	if(width==0) return;
	g.fillRect(0, 0, width, this.getHeight());
	}
	
synchronized void fill() {
	if(barSize== maxBarSize) {
		try {
			wait();
		} catch (InterruptedException e) { return; }
		
	}
	barSize++;
	repaint();
	notify();
}

synchronized void consume() {
	if(barSize == 0) {
		try {
			wait();
		} catch (InterruptedException e) { return; }
	}
	barSize--;
	repaint();
	notify();

}

synchronized void reset() {
	barSize = 0;
	repaint();
	notify();
}

synchronized boolean isFull() {
	return barSize >= maxBarSize;
}
}
class ConsumerThread extends Thread {
	MyLabel bar;
	
	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	public void run() {
		while(true) { try {
			sleep(200);
			bar.consume();
			} catch (InterruptedException e) { return; }
		}
	}
}

public class TabAndThreadEx extends JFrame{
	MyLabel bar = new MyLabel(100);
	JButton restartBtn = new JButton("Restart");
	JLabel clearLabel = new JLabel("CLEAR!");
	
	TabAndThreadEx(String title) {
		super(title); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Container c = getContentPane(); 
		c.setLayout(null); 
		bar.setBackground(Color.ORANGE); 
		bar.setOpaque(true); bar.setLocation(20, 50); 
		bar.setSize(300, 20);
		c.add(bar);
		
		clearLabel.setSize(100, 30);
		clearLabel.setLocation(150, 80);
		clearLabel.setForeground(Color.RED);
		clearLabel.setFont(new Font("Arial", Font.BOLD, 20));
		clearLabel.setVisible(false);
		c.add(clearLabel);
		
		restartBtn.setSize(100, 30);
		restartBtn.setLocation(125, 120);
		restartBtn.setVisible(false);
		restartBtn.addActionListener(e -> {
			bar.reset();
			clearLabel.setVisible(false);
			restartBtn.setVisible(false);
			c.requestFocus();
		});
		c.add(restartBtn);
		
		c.addKeyListener(new KeyAdapter() { 
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					bar.fill();
					if (bar.isFull()) {
						clearLabel.setVisible(true);
						restartBtn.setVisible(true);
					}
				}
			} 
			});
		setSize(350,200); 
		setVisible(true);
		c.requestFocus(); 
		ConsumerThread th = new ConsumerThread(bar); 
		th.start(); // 스레드 시작
		}


	public static void main(String[] args) {
		new TabAndThreadEx(
				"스페이스 키 눌러서 바 채우기"); }

	}

