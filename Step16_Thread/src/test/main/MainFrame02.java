package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.SubThread;

/*
 * "알림 띄우기" 버튼을 누르면 
 * 10초간 sleep 작업이 진행됨.
 * 
 * 하지만 작업은 SubThread에서 진행되는 것이기 때문에
 * actionPerformed 메소드가 바로 리턴됨.
 * 
 * 바로 "알림 띄우기" 버튼을 재사용할 수 있음.
 * 
 * [눈 여겨 봐야하는 것]
 * extends Thread
 * Thread t=new SubThread();
 * t.start();
 * 
 * actionPerformed 메소드가 언제 리턴하는가
 */

public class MainFrame02 extends JFrame implements ActionListener{
	
	//생성자
	public MainFrame02(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame02 f=new MainFrame02("메인 스레드 10초 작업");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//버튼 눌렀을 때 "알림 입니다." 알림창 띄우기
		JOptionPane.showMessageDialog(this, "알림 입니다.");
		
		//3. Thread 클래스를 상속받은 SubThread 클래스로 객체 생성
		Thread t=new SubThread();
		
		//4. start() 메소드를 호출하면 새로운 작업 단위가 시작된다.
		t.start();
		
		System.out.println("actionPerformed() 메소드가 리턴 합니다.");
	}
}
