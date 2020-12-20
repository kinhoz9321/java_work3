package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;

/*
 * Runnable 인터페이스 타입을 사용해서 Thread 객체 생성하기1
 * 
 * [눈 여겨 봐야하는 것]
 * Runnable downTask=new DownloadTask();
 * Thread t=new Thread(downTask);
 */

public class MainFrame05 extends JFrame implements ActionListener{
	
	//생성자
	public MainFrame05(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame05 f=new MainFrame05("메인 스레드 10초 작업");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//버튼 눌렀을 때 "알림 입니다." 알림창 띄우기
		JOptionPane.showMessageDialog(this, "알림 입니다.");
		
		//Runnable 인터페이스 type 의 참조값을 얻어내서
		Runnable downTask=new DownloadTask();
		
		//별도의 Thread 객체를 생성 후 Runnable 인터페이스 type의 참조값을 인자로 전달
		Thread t=new Thread(downTask);//3.
		
		//start() 메소드 호출
		t.start();//4.
		
		System.out.println("actionPerformed() 메소드가 리턴 합니다.");
	}
}
