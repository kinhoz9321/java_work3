package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
 * 텍스트 편집기 액션 리스너 뚱뚱이 메소드 버전
 */
public class TextEditor2 extends JFrame implements ActionListener{

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
	public TextEditor2(String title) {
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
		
		//JMenuItem ActionListener 추가하기
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		//JMenuItem ActionCommand 추가하기
		item1.setActionCommand(TextEditor2.COMMAND_NEW);
		item2.setActionCommand(TextEditor2.COMMAND_OPEN);
		item3.setActionCommand(TextEditor2.COMMANE_SAVE);
	}
	
	
	//main 메소드
	public static void main(String[] args) {
		TextEditor2 te=new TextEditor2("텍스트 편집기2");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}

	//ActionListener 메소드 재정의 (뚱뚱이 버전)
	
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
			
			//파일 확장자가 .txt 인 파일만 선택할 수 있도록 필터 설정
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			
			//fc="c:/myFolder" 필터 설정
			fc.setFileFilter(filter);
			
			//파일을 선택해서 열 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showOpenDialog(this);
			
			//파일을 선택하고 확인을 눌렀을 때
			if(result==JFileChooser.APPROVE_OPTION) {
				
				//선택한 파일을 Access 할 수 있는 File 객체의 참조값 얻어오기
				File selectedFile=fc.getSelectedFile();
				
				try {
					//File 객체를 이용해서 문자열을 읽어들일 수 있는 FileReader 객체 생성하기 (선택한 파일 Access)
					FileReader fr=new FileReader(selectedFile);
					
					//FileReader를 BufferedReader로 기능을 업 시킨다. (문자열 한 줄 읽기 가능)
					BufferedReader br=new BufferedReader(fr);
					
					//무한 반복문 돌기
					while(true) {
						
						//문자열을 한줄씩 읽어들인다
						String line=br.readLine();
						
						//만약 읽어들일 게 없다면
						if(line==null) {
							break;//반복문 탈출
						}
						//append() 기존 문자열의 뒤쪽에 문자열을 추가하는 기능 (개행기호 추가)
						area.append(line+"\r\n");
						
						//JTextArea 보이게 하기
						area.setVisible(true);
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		
		//문자열이 COMMAND_SAVE 라면 (save)
		}else if(command.equals(COMMANE_SAVE)) {
			
			//c:/myFolder 에서 시작되는 JFileChooser 객체 생성
			JFileChooser fc=new JFileChooser("c:/myFolder");
			
			//파일 확장자가 .txt 인 파일만 선택할 수 있도록 필터 설정
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			
			//fc="c:/myFolder" .txt 필터 설정
			fc.setFileFilter(filter);
			
			//파일을 저장할 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showSaveDialog(this);
			
			//파일을 선택하고 확인을 눌렀을 때
			if(result==JFileChooser.APPROVE_OPTION) {
				
				//선택한 파일을 Access 할 수 있는 File 객체의 참조값 얻어오기
				File selectedFile=fc.getSelectedFile();
				
				//JTextArea 에 적힌 글자 얻어와서 참조값에 담기
				String content=area.getText();
				
				//FileWriter 빈 공간 생성 (출력 스트림)
				FileWriter fw=null;
				
				try {
					//선택한 파일 Access 및 출력 객체 생성
					fw=new FileWriter(selectedFile);
					
					//JTextArea 텍스트 참조값 얻어와서 출력하기
					fw.write(content);//개행기호 포함? 이걸 지우면 출력이 안됨.
					
					//파일 저장했습니다 알림창 띄우기
					JOptionPane.showMessageDialog(this, "파일에 저장했습니다.");
					
				}catch (Exception e2) {
					
					e2.printStackTrace();
					
					//저장 실패 알림창 띄우기
					JOptionPane.showMessageDialog(this, "저장 실패");
				}finally {//마무리 작업
					try {
						
						//FileWriter 객체 닫아주기
						fw.close();
						
					}catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		}
	}
}
/*
JFileChooser 클래스를 사용하는경우, 
윈도우의 파일열기, 저장 등 과 같은 형태의 Dialog 를 사용할수 있다.
*/