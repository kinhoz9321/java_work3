package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* 
 * JFrame 상속받고
 * 필드에 ActionListener 만들어서 변수명 listener로 통일.
 * getActionCommand를 이용해서 객체의 문자열을 참조, 
 * if문과 .equals() 메소드를 사용해 문자열을 비교한다.
 * 생성자에서 setActionCommand를 이용해서 
 * 문자열로 버튼의 ActionListener를 구분해준다.
 * 
 * ActionListener 등록 6 (MainFrame 7과 비교해보기)
 */

public class MainFrame06 extends JFrame{
	
	//필드
	//ActionListener 하나로 통일하기 (listener)
	ActionListener listener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			/* 
			 * getActionCommand() 
			 * - 이벤트를 발생시킨 객체(JButton)의 문자열을 가져온다.
			 */
			
			String command=e.getActionCommand();
			
			/*
			 * 문자열 (String)의 내용을 비교할 때는 == 을 사용하지 말고
			 * ***.equals()*** 메소드를 사용해야한다.
			 * 자바에서는 내용이 같다고 참조값이 같은 게 아니기 때문에
			 * 문자열을 비교할 때는 반드시 메소드를 사용한다.
			 */
			
			if(command.equals("send")) {
				
				JOptionPane.showMessageDialog(MainFrame06.this, "전송 버튼을 눌렀습니다.");
				
			}else if(command.equals("update")) {
				
				JOptionPane.showMessageDialog(MainFrame06.this, "수정 버튼을 눌렀습니다.");
				
			}else if(command.equals("delete")) {
				
				JOptionPane.showMessageDialog(MainFrame06.this, "삭제 버튼을 눌렀습니다.");
				
			}
		}
	};
	
	//생성자
	public MainFrame06(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//버튼에 리스너 등록하기 this. 생략
		sendBtn.addActionListener(this.listener);
		updateBtn.addActionListener(listener);
		deleteBtn.addActionListener(listener);
		
		/*
		 * 버튼에 ActionCommand를 원하는대로 지정할 수 있다.
		 * ActionListener를 같은 이름 (listener)로 공유하기로 했으니
		 * 구분이 필요해서 setActionCommand를 만들어주었다.
		 */
		
		sendBtn.setActionCommand("send");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");
	}
	//main 메소드
	public static void main(String[] args) {
		MainFrame06 f=new MainFrame06("메인 프레임6");
		
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
