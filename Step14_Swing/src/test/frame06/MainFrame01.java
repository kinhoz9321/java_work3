package test.frame06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * <내가 만든 가위바위보 게임!>
 * 랜덤 박스 이용해서 가위바위보 게임 만들기
 * 나 : 컴퓨터
 * 
 * 랜덤버튼1 : 가위,바위,보
 * 라벨 나 : 결과  east 컴퓨터 : 결과 west
 * 알림창 누구 승리!
 * 
 * 나중에 버튼 3개 (가위, 바위, 보) 짜리 게임도 만들어보기!
 */

public class MainFrame01 extends JFrame implements ActionListener{
	
	//필드
	//random 객체에 대입할 가위,바위,보 배열 list 생성
	String[] list= {"가위", "바위", "보"};
	
	//다른 메소드에서도 사용하기 위해 JLabel 필드에 빼내기
	JLabel label_me_result;
	JLabel label_com_result;
	
	//생성자
	public MainFrame01(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		//가위바위보 랜덤 버튼 만들기
		JButton gameBtn=new JButton("가위 바위 보!");
		
		//나의 결과를 보여줄 레이블 만들기
		JLabel label_me=new JLabel("나:");
		label_me_result=new JLabel();
		
		//컴퓨터의 결과를 보여줄 레이블 만들기
		JLabel label_com=new JLabel("컴퓨터:");
		label_com_result=new JLabel();
		
		JPanel btn_panel=new JPanel();
		btn_panel.setBackground(Color.PINK);
		btn_panel.add(gameBtn);
		
		JPanel panel_me=new JPanel();
		panel_me.add(label_me);
		panel_me.add(label_me_result);
		
		JPanel panel_com=new JPanel();
		panel_com.add(label_com);
		panel_com.add(label_com_result);
		
		add(btn_panel, BorderLayout.NORTH);
		add(panel_me, BorderLayout.WEST);
		add(panel_com, BorderLayout.EAST);
		
		//액션 리스너 추가
		gameBtn.addActionListener(this);
		
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("가위바위보 게임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//랜덤한 값을 얻어내기 위한 객체 생성
		Random ran=new Random();
		
		//랜덤한 정수 설정 (나, 컴퓨터)
		int ranGame_m=ran.nextInt(3);//가위, 바위, 보
		int ranGame_c=ran.nextInt(3);
		
		//list 에 정수 대입? 핵심!
		String game_m=list[ranGame_m];
		label_me_result.setText(game_m);
		
		String game_c=list[ranGame_c];
		label_com_result.setText(game_c);
		
		//결과를 저장할 result 지역변수를 미리 만든다.
		String result=null;
		
		//이긴 경우의 수, 비긴 경우, 나머지는 진 경우
		if(game_c.equals("가위") && game_m.equals("바위")) {//플레이어가 이긴경우
			result="이겼습니다.";
		}else if(game_c.equals("바위") && game_m.equals("보")) {//플레이어가 이긴경우
			result="이겼습니다.";
		}else if(game_c.equals("보") && game_m.equals("가위")) {//플레이어가 이긴경우
			result="이겼습니다.";
		}else if(game_c.equals(game_m)) {//비긴경우
			result="비겼습니다.";
		}else {//나머지는 진경우
			result="졌습니다.";
		}
		
		JOptionPane.showMessageDialog(this, result);
	}
}
