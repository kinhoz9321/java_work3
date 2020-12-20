package test.frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* 
 * JFrame 상속받아서 
 * 생성자 안에 모든 설정을 마친 후
 * 생성자 안에서 ActionListener 생성 후 버튼 만들기3
 * 
 * 버튼에 ActionListener 추가해서 람다식 사용하기
 */

public class MainFrame03 extends JFrame{
	
	//생성자
	public MainFrame03(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//버튼에 ActionListener 추가해서 람다식 사용하기
		//Btn.addActionListener((e)->{});
		//람다식을 사용하기 위해선 한개의 추상메소드만 가지고 있어야 한다.
		
		sendBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame03.this, "전송 버튼을 눌렀습니다.");
		});
		
		updateBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame03.this, "수정 버튼을 눌렀습니다.");
		});
		
		deleteBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame03.this, "삭제 버튼을 눌렀습니다.");
		});
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("메인 프레임3");
		
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
