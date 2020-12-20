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

/* 
 * 계산기 2
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
 * 필드에 ActionListener 객체 생성
 * implements ActionListener 하지않고
 * 4가지 따로 만들어보기
 * 
 * ActionListener 를 통합하지 않았기 때문에 
 * ActionCommand로 구분해주지 않아도 된다.
 */

public class MainFrame02 extends JFrame{
	
	//필드
	JTextField inputNum1, inputNum2;
	JLabel label_result;
	
	//생성자
	public MainFrame02(String title) {
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
		
		plusBtn.addActionListener(plus);
		minusBtn.addActionListener(minus);
		multiBtn.addActionListener(multiple);
		diviBtn.addActionListener(division);
	}
	
	//pulsBtn 에 추가할 ActionListener 객체 생성
	ActionListener plus=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			double result=0;
			
			result=num1+num2;
			
			String strNum=Double.toString(result);
			
			label_result.setText(strNum);
		}
	};
	
	//minusBtn 에 추가할 ActionListener 객체 생성
	ActionListener minus=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			double result=0;
			
			result=num1-num2;
			
			String strNum=Double.toString(result);
			
			label_result.setText(strNum);
		}
	};
	
	//multiBtn 에 추가할 ActionListener 객체 생성
	ActionListener multiple=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			double result=0;
			
			result=num1*num2;
			
			String strNum=Double.toString(result);
			
			label_result.setText(strNum);
		}
	};
	
	//diviBtn 에 추가할 ActionListener 객체 생성
	ActionListener division=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			double result=0;
			
			result=num1/num2;
			
			String strNum=Double.toString(result);
			
			label_result.setText(strNum);
		}
	};
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame02 f=new MainFrame02("계산기 프레임2");
		f.setBounds(100, 100, 600, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
