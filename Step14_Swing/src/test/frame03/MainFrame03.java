package test.frame03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 텍스트필드에 문자를 입력하고
 * "엔터키"를 누르면
 * 입력한 문자가 프레임 레이블에 나타나게 만들기
 */

public class MainFrame03 extends JFrame implements ActionListener, KeyListener{

	//필드
	JTextField inputText;
	JLabel label;
	
	//생성자
	public MainFrame03(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		label=new JLabel();
		
		panel.setBackground(Color.YELLOW);
		
		panel.add(inputText);
		panel.add(sendBtn);
		panel.add(label);
		
		add(panel, BorderLayout.NORTH);
		
		/*
		 * 버튼에 ActionListener 등록하기 
		 * 텍스트 필드에 KeyListener 등록하기 
		 */
		sendBtn.addActionListener(this);
		inputText.addActionListener(this);
		//둘다 MainFrame2.this 생략한 것
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("텍스트 프레임3");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 메소드 재정의 하기 
	//버튼을 눌렀을 때 호출되는 메소드 (전송 버튼 누르면 텍스트 라벨에 출력)
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String msg=inputText.getText();
		label.setText(msg);
		inputText.setText("");
		
	}

	//KeyListener 인터페이스 메소드 재정의
	//키를 눌렀을 때 호출되는 메소드 (엔터키를 누르면 텍스트 라벨에 출력)
	@Override
	public void keyPressed(KeyEvent e) {
		
		//눌러진 키의 코드값 읽어오기
		int code=e.getKeyCode();
		
		//만일 엔터키를 누른다면
		if(code==KeyEvent.VK_ENTER) {
			//1.JTextField에 입력한 문자열을 읽어와서
			String msg=inputText.getText();
			//2.레이블에 출력한다
			label.setText(msg);
			//3.입력창 빈공간 만들기
			inputText.setText("");
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
