package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooseFrame extends JFrame implements ActionListener{

	//생성자
	public FileChooseFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton selectBtn=new JButton("파일 선택하기");
		add(selectBtn, BorderLayout.NORTH);
		
		//버튼에 액션 리스너 등록
		selectBtn.addActionListener(this);
	}
	
	//main
	public static void main(String[] args) {
		FileChooseFrame f=new FileChooseFrame("파일 선택하는 프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//c://myFolder에서 시작되는 JFileChooser 객체 생성
		JFileChooser fc=new JFileChooser("c:/myFolder");//폴더 시작 위치 결정
		
		//파일을 선택해서 열 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
		int result=fc.showOpenDialog(this);
		
	}
	
}
