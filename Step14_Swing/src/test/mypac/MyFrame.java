package test.mypac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	//생성자
	public MyFrame() {
		
		//배치 매니저를 사용하지 않겠다.(절대 좌표에 절대 크기로 배치)
		this.setLayout(null);
		
		//버튼 객체 생성
		JButton btn=new JButton("눌러봐");
		
		//버튼의 위치와 크기 지정 (x, y, width, height)
		btn.setBounds(50, 50, 100, 40);
		
		//프레임에 버튼 추가하기
		this.add(btn);
		
		//ActionListener 인터페이스 type의 참조값 얻어내기
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "눌렀냐!");
				
			}
		};
		
		//버튼에 액션 리스너 등록하기
		btn.addActionListener(listener);
		
		
		//전송 버튼 만들고 버튼 누르면 전송합니다 알림창 뜨게 만들기
		
		JButton sendBtn=new JButton("전송");
		sendBtn.setBounds(200, 50, 100, 40);
		this.add(sendBtn);
		
		ActionListener sendListener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다.");
				
			}
		};
		
		sendBtn.addActionListener(sendListener);
	}
}
