package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * JFrame을 상속받아서
 * * 필드에 ActionListener 생성 * 
 * 익명의 클래스로 메소드 재정의 하기.
 * 
 * 생성자에서 버튼에 ActionListener 등록하기 4
 */

public class MainFrame04 extends JFrame{
	
	//필드
	//ActionListener 생성 익명의 클래스로 메소드 재정의 하기
	
	ActionListener send=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame04.this, "전송 버튼을 눌렀습니다.");
			
		}
	};

	ActionListener update=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame04.this, "수정 버튼을 눌렀습니다.");
			
		}
	};
	
	ActionListener delete=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame04.this, "삭제 버튼을 눌렀습니다.");
			
		}
	};
	
	//생성자
	public MainFrame04(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		sendBtn.addActionListener(send);
		updateBtn.addActionListener(update);
		deleteBtn.addActionListener(delete);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame04 f=new MainFrame04("메인 프레임4");
		
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
