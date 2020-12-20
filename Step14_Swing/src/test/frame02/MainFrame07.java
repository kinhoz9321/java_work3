package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * JFrame 상속 받고
 * ActionListener 구현.
 * 강제 오버라이드 된 actionPerformed 메소드에서
 * getActionCommand()를 사용해 객체의 문자열을 참조한다. 
 * 
 * ActionListener 사용 7 (6과 비교해보기)
 * 
 * 6과 다른 점.
 * implements 를 했기 때문에 new ActionListener()를 하지 않았다.
 */

public class MainFrame07 extends JFrame implements ActionListener{

	//생성자
	public MainFrame07(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
	}
	
	/* ActionListener interface를 익명의 클래스를 이용하여 
	 * actionPerformed 메소드 재정의하기
	 * 
	 * if문 사용해서 문자열 구분
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		if(command.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송 버튼을 눌렀습니다.");
		}else if(command.equals("update")) {
			JOptionPane.showMessageDialog(this, "수정 버튼을 눌렀습니다.");
		}else if(command.equals("delete")) {
			JOptionPane.showMessageDialog(this, "삭제 버튼을 눌렀습니다.");
		}
	}

	//main 메소드
	public static void main(String[] args) {
		MainFrame07 f=new MainFrame07("메인 프레임7");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
