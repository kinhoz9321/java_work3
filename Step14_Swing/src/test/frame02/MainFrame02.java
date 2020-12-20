package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* 
 * JFrame 상속받아서 
 * 생성자 안에 모든 설정을 마친 후
 * 생성자 안에서 ActionListener 생성 후 버튼 만들기2
 * 
 * 버튼에 바로 ActionListener를 추가해서
 * 익명의 클래스 호출, 메소드 재정의하기
 */

public class MainFrame02 extends JFrame{

	//생성자
	public MainFrame02(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		/*
		 * 버튼에 바로 ActionListener를 추가해서
		 * 익명의 클래스 호출, 메소드 재정의하기
		 */
		
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame02.this, "전송 버튼을 눌렀습니다.");
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame02.this, "수정 버튼을 눌렀습니다.");
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame02.this, "삭제 버튼을 눌렀습니다.");
			}
		});
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame02 f=new MainFrame02("메인 프레임2");
		
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
