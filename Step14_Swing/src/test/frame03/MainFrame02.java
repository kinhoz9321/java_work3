package test.frame03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 텍스트필드에 문자를 입력하고
 * "전송버튼"을 누르면
 * 입력한 문자가 프레임 레이블에 나타나게 만들기
 */

public class MainFrame02 extends JFrame implements ActionListener{

	//필드 (여러 메소드에서 재사용할 객체는 필드에 따로 빼둔다.)
	TextField inputText;
	JLabel label;
	
	//생성자
	public MainFrame02(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		inputText=new TextField(10);
		JButton sendBtn=new JButton("전송");
		
		//JLabel, JPanel 생성
		label=new JLabel();
		JPanel panel=new JPanel();
		
		panel.setBackground(Color.PINK);
		
		panel.add(inputText);
		panel.add(sendBtn);
		panel.add(label);
		
		add(panel, BorderLayout.NORTH);
		
		sendBtn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame02 f=new MainFrame02("텍스트 프레임2");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=inputText.getText();
		//2. label에 출력한다.
		label.setText(msg);
		//3. JTextField 를 빈칸으로 만든다.
		inputText.setText("");
	}
	
	
}
