package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
/*
 * 텍스트 편집기 액션 리스너 작성 전
 */
public class TextEditor extends JFrame implements ActionListener{

	/*
	 * 클래스 멤버 변수를 final로 지정하는 의도의 확인
	 * - 클래스에서 사용할 해당 멤버 변수의 데이터와 그 의미, 
	 * 용도를 고정시키겠다는 뜻
	 * 
	 * 예시)
	 * 기독교 클래스에서 멤버 변수 신의 이름을 만들어 사용한다면 
	 * 해당 클래스를 언제 어디서 어떻게 쓰든 변함없이 하나님이겠죠?
	 * public static final String NAME_OF_GOD = "하나님";
	 */
	
	//필드
	public static final String COMMAND_NEW="new";
	public static final String COMMAND_OPEN="open";
	public static final String COMMANE_SAVE="save";
	
	JTextArea area;
	
	//생성자
	public TextEditor(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		//JMenu 객체 생성
		JMenu menu1=new JMenu("File");
		JMenu menu2=new JMenu("Help");
		
		//JMenuBar 객체 생성
		JMenuBar mb=new JMenuBar();
		
		//JMenuBar 컬러 추가
		mb.setBackground(Color.ORANGE);
		
		//JMenuBar에 JMenu 추가
		mb.add(menu1);
		mb.add(menu2);
		
		//JFrame에 JMenuBar 추가
		this.setJMenuBar(mb);
		
		//JMenuItem 객체 생성
		JMenuItem item1=new JMenuItem("New");
		JMenuItem item2=new JMenuItem("Open");
		JMenuItem item3=new JMenuItem("Save");
		
		//menu1=JMenu("File"); 에 item1,2,3 추가
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		//JTextArea 객체 생성
		area=new JTextArea();
		//JTextArea 위치 가운데 지정
		add(area, BorderLayout.CENTER);
		//JTextArea 컬러 추가
		area.setBackground(Color.YELLOW);
		
		//JTextArea 보이지 않게 설정 (new 했을 때 보일 예정)
		area.setVisible(false);
	}
	
	
	//main 메소드
	public static void main(String[] args) {
		TextEditor te=new TextEditor("텍스트 편집기1");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}

	//ActionListener 메소드 재정의
	
	/*
	 * 할 일
	 * save-new 파일에 텍스트 입력해서 저장하기
	 * open-저장된 txt 파일 불러오기
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		//문자열을 비교할 때엔 == 연산자가 아닌 equals() 메소드를 사용한다.
		//문자열이 COMMAND_NEW 라면 (new)
		if(command.equals(COMMAND_NEW)) {
			
			//JTextArea 를 보이게 한다.
			area.setVisible(true);
			//JTextArea에 focus를 준다.
			area.grabFocus();
		
		//문자열이 COMMAND_OPEN 이라면 (open)
		}else if(command.equals(COMMAND_OPEN)) {
			
			//c:/myFolder 에서 시작되는 JFileChooser 객체 생성
			JFileChooser fc=new JFileChooser("c:/myFolder");
			//파일을 선택해서 열 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showOpenDialog(this);
		
		//문자열이 COMMAND_SAVE 라면 (save)
		}else if(command.equals(COMMANE_SAVE)) {
			
			//c:/myFolder 에서 시작되는 JFileChooser 객체 생성
			JFileChooser fc=new JFileChooser("c:/myFolder");
			//파일을 선택해서 열 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showOpenDialog(this);
			
		}
	}
}
/*
JFileChooser 클래스를 사용하는경우, 
윈도우의 파일열기, 저장 등 과 같은 형태의 Dialog 를 사용할수 있다.
*/