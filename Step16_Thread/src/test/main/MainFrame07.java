package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;

/*
 * Runnable 인터페이스 타입을 사용해서 Thread 객체 생성하기3
 * 
 * [눈 여겨 봐야하는 것]
 * new Thread(()->{}).start();
 * Runnable 메소드 람다식 사용
 * 
 * Runnable 인터페이스는 구현할 메소드가 run() 하나 뿐인 함수형 인터페이스
 * (메소드가 run 하나 뿐이기 때문에 람다식 사용 가능)
 */

public class MainFrame07 extends JFrame implements ActionListener{
	
	//생성자
	public MainFrame07(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame07 f=new MainFrame07("메인 스레드 10초 작업");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//버튼 눌렀을 때 "알림 입니다." 알림창 띄우기
		JOptionPane.showMessageDialog(this, "알림 입니다.");
		
		//Thread 객체 생성.start 메소드 호출, 인자 Runnable 객체 람다식 생성
		new Thread(()->{
			
			System.out.println("다운로드를 시작 합니다...");
			
			try {
				
				for(int i=1; i<=100; i++) {
					System.out.println(i+" % ");
					Thread.sleep(100);
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("다운로드를 완료 했습니다...");
			
		}).start();
		
		System.out.println("actionPerformed() 메소드가 리턴 합니다.");
	}
}
