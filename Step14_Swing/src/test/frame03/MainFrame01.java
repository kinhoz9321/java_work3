package test.frame03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* 
 * 텍스트 필드에 입력한 텍스트를 알림창으로 출력하기
 */

public class MainFrame01 extends JFrame implements ActionListener{
	//필드 - 텍스트 필드의 참조값을 필드에 저장
	TextField inputText;
	
	//생성자
	public MainFrame01(String title) {
		super(title);
		
		/*
		 * BorderLayout()
		 * - 컨테이너를 North, South, East, West, Center 
		 * 모두 5개의 영역으로 나누고, 
		 * 각 영역에 하나의 컴포넌트만을 배치할 수 있도록 한다.
		 * 
		 * BorderLayout()을 하지 않으면 프레임에 배경색이 꽉 차지 않는다.
		 */
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		//텍스트 필드와 버튼 객체 만들기
		this.inputText=new TextField(10);//this는 생략 가능
		JButton sendBtn=new JButton("전송");
		
		//패널 객체 생성하기
		JPanel topPanel=new JPanel();
		
		//패널에 텍스트 필드와 버튼 추가하기
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		
		//패널에 배경색 지정하기
		topPanel.setBackground(Color.PINK);
		
		//패널 째로 프레임의 북쪽에 배치하기
		this.add(topPanel, BorderLayout.NORTH);
		
		//버튼에 리스너 등록하기
		sendBtn.addActionListener(MainFrame01.this);
		
		/*
		 * MainFrame01 생략 가능
		 * 이 때 리스너에 this를 입력하는 이유는
		 * ActionListener를 MainFrame01이 implements 받았기 때문.
		 * 
		 * 인터페이스도 다형성에 참여를 한다.
		 * 클래스는 아니지만 부모타입의 역할을 할 수 있다.
		 */
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("텍스트 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 재정의 - actionPerformed (버튼 클릭시에 발동되는 메소드)
	/* MainFrame.this = this */ 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=inputText.getText();
		
		//2. 알림창에 출력한다.
		JOptionPane.showMessageDialog(this, msg);
		
	}
}
/*
 * UI로 사용하는 것들의 부모에는 모두 Component 가 있다.
 * ex) JFrame, JTextField, JButton, JPanel ...
 *
 * [중요했던 과정 정리!]
 * 
 * 1. 필드 생성
 * JTextField inputText;
 * 
 * 2. 버튼에 리스너 등록하기 - this
 * sendBtn.addActionListener(this);
 * 
 * 3. 오버라이드 채워넣기
 * @Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=this.inputText.getText();
		
		//2. 알림창에 출력한다
		JOptionPane.showMessageDialog(this, msg);
	}
 */
