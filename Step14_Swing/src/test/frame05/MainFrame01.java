package test.frame05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* 
 * 랜덤하게 숫자를 얻어낼 수 있는 버튼을 만들어서
 * 버튼을 누르면 정해진 숫자 범위 안에서
 * 알림창에 랜덤한 숫자가 나오는 프레임 만들어보기
 */

public class MainFrame01 extends JFrame implements ActionListener{

	//생성자
	public MainFrame01(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JButton ranBtn=new JButton("랜덤 숫자 뽑기 시작!");
		JPanel panel=new JPanel();
		panel.setBackground(Color.PINK);
		panel.add(ranBtn);
		
		add(panel, BorderLayout.NORTH);
		
		//implements ActionListener 
		ranBtn.addActionListener(MainFrame01.this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("랜덤 프레임");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		//랜덤한 값을 얻어내기 위한 객체 생성
		Random ran=new Random();
		//랜덤한 정수 설정
		int ranNum=ran.nextInt(10);//(10)0~9사이의 랜덤한 정수 설정
		//랜덤 정수 알림창 띄우기
		JOptionPane.showMessageDialog(this, "발생된 랜덤 정수:"+ranNum);
		
	}
	
}
