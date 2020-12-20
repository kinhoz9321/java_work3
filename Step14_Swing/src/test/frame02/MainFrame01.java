package test.frame02;

/* 
 * JFrame 상속받아서 
 * 생성자 안에 모든 설정을 마친 후
 * ActionListener 생성자 안에서 객체 생성 후 
 * 버튼에 ActionListener 추가하기
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame01 extends JFrame{
	//생성자
	public MainFrame01(String title) {
		super(title);
		
		//FlowLayout 물 흐르듯 배치되는 레이아웃
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		/* 
		 * ActionListener interface type의 참조값 얻어내기
		 * ActionListener interface를 익명의 클래스를 이용하여 메소드 재정의하기
		 * 
		 * 3단계
		 * 1. ActionListener interface 생성 후 
		 * 2. 익명의 클래스로 actionPerformed 메소드 완성.
		 * 3. 버튼에 ActionListener 등록하기
		 */
		
		ActionListener send=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(MainFrame01.this, "전송 버튼을 눌렀습니다.");
				
			}
		};
		
		sendBtn.addActionListener(send);
		
		ActionListener update=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(MainFrame01.this, "수정 버튼을 눌렀습니다.");
				
			}
		};
		
		updateBtn.addActionListener(update);
		
		ActionListener delete=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(MainFrame01.this, "삭제 버튼을 눌렀습니다.");
				
			}
		};
		
		deleteBtn.addActionListener(delete);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("메인 프레임");
		
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
