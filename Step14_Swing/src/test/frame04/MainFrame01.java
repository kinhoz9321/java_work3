package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 계산기 1
 * 
 * 사칙연산이 가능한 계산기를 만들어보세요.
 * TextField (10) 2개
 * 사칙연산 버튼 4개
 * =,result 레이블 2개
 * 
 * 사칙연산의 버튼을 누르면 result 레이블에 결과값 출력되게 만들기
 * 
 * hint double num1=Double.parseDouble(inputNum1.getText());
 * 
 * implements ActionListener 해서
 * 필드에 ActionListener 통합 객체 생성
 * ActionCommand 로 구분자 설정하기
 */

public class MainFrame01 extends JFrame implements ActionListener{
	
	//필드 (여러 메소드에서 재사용할 것들은 필드로 따로 빼둔다.)
	JTextField inputNum1;
	JTextField inputNum2;
	JLabel label_result;
	
		//ActionListener 메소드 재정의
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//ActionListener 를 하나로 통일했으니 구분자로 ActionCommand(String type) 얻어내기
			String command=e.getActionCommand();
			
			/* 
			 * 텍스트 필드(String Type)의 값 얻어내서 Double type 의 참조값 얻어내기
			 * 
			 * 문자열에서 Double형 으로 바꾸는 방법 
			 * - Double 클래스 parseDouble 메소드 사용
			 * parseDouble();
			 */
			
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			double result=0;
			
			//ActionCommand가 plus 라면
			if(command=="plus") {
				result=num1+num2;
				
			//ActionCommand가 minus 라면
			}else if(command=="minus") {
				result=num1-num2;
				
			//ActionCommand가 multiple 라면
			}else if(command=="multiple") {
				result=num1*num2;
			
			//ActionCommand가 division 라면
			}else if(command=="division") {
				result=num1/num2;
				
			}
			
			//Double type의 result를 다시 String type으로 바꿔준다.
			String strNum=Double.toString(result);
			//label_result에 String type 으로 바뀐 strNum을 출력되게 만든다.
			label_result.setText(strNum);
		}
	
	//생성자
	public MainFrame01(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multiBtn=new JButton("*");
		JButton diviBtn=new JButton("/");
		JLabel label_eq=new JLabel("=");
		label_result=new JLabel();
		
		JPanel panel=new JPanel();
		
		panel.add(inputNum1);
		panel.add(plusBtn);
		panel.add(minusBtn);
		panel.add(multiBtn);
		panel.add(diviBtn);
		panel.add(inputNum2);
		panel.add(label_eq);
		panel.add(label_result);
		
		panel.setBackground(Color.PINK);
		
		add(panel, BorderLayout.NORTH);
		
		//버튼에 ActionListener 등록하기. 
		//implements ActionListener 를 했기 때문에 this로 받는 게 가능하다. 부모타입 역할 가능.
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		diviBtn.addActionListener(this);
		
		//버튼에 ActionCommand 세팅하기
		plusBtn.setActionCommand("plus");
		minusBtn.setActionCommand("minus");
		multiBtn.setActionCommand("multiple");
		diviBtn.setActionCommand("division");
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("계산기 프레임1");
		f.setBounds(100, 100, 600, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
/*
 * ActionCommand는 해당 Action에 대해 간단한 String형태의 명령 문장을 달아놓는 것으로 
 * 액션이 일어난 소스에 대해서 처리를 하지 않고 해당 액션의 이름별로 처리를 하게 되어 
 * 액션을 통합관리할 수 있게 해준다.
 */
