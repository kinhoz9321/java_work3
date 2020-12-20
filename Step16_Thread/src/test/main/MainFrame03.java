package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * "알림 띄우기" 버튼을 누르면 
 * 10초간 sleep 작업이 진행됨.
 * 
 * 익명의 local inner class를 이용해서 
 * Thread 객체를 생성하고 run 메소드를 오버라이드 한다.

 * 바로 "알림 띄우기" 버튼을 재사용할 수 있음.
 * 
 * [눈 여겨 봐야하는 것]
 * Thread t=new Thread(){};
 */

public class MainFrame03 extends JFrame implements ActionListener{
	
	//생성자
	public MainFrame03(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("메인 스레드 10초 작업");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//버튼 눌렀을 때 "알림 입니다." 알림창 띄우기
		JOptionPane.showMessageDialog(this, "알림 입니다.");
		
		/*
		 * 익명의 local inner class를 이용해서 
		 * Thread 객체를 생성하고 run 메소드를 오버라이드 한다.
		 */
		
		Thread t=new Thread() {
			
			@Override
			public void run() {
				
				try {
					
					System.out.println("무언가 오랜 시간(10초)이 걸리는 작업을 합니다.");
					Thread.sleep(10000);
					System.out.println("시간이 오래 걸리는 작업이 끝났습니다.");
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
			}
		};
		
		//start() 메소드를 호출해서 스레드를 시작 시킨다.
		t.start();
		System.out.println("actionPerformed() 메소드가 리턴 합니다.");
	}
}
