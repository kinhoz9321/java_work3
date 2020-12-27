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
 * 텍스트 편집기 액션 리스너 날씬이 버전
 */
public class TextEditor3 extends JFrame implements ActionListener{

	//필드
	JTextArea area;
	public static final String COMMAND_NEW="new";
	public static final String COMMAND_OPEN="open";
	public static final String COMMAND_SAVE="save";
	
	//생성자
	public TextEditor3(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JMenuBar mb=new JMenuBar();
				
		JMenu menu1=new JMenu("File");
		JMenu munu2=new JMenu("Help");
		
		mb.add(menu1);
		mb.add(munu2);
		
		this.setJMenuBar(mb);
		
		JMenuItem item1=new JMenuItem("New");
		JMenuItem item2=new JMenuItem("Open");
		JMenuItem item3=new JMenuItem("Save");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.PINK);
		area.setVisible(false);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		item1.setActionCommand(TextEditor3.COMMAND_NEW);
		item2.setActionCommand(TextEditor3.COMMAND_OPEN);
		item3.setActionCommand(TextEditor3.COMMAND_SAVE);
	}
	
	//main
	public static void main(String[] args) {
		TextEditor3 te=new TextEditor3("텍스트 편집기3");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}
	
	//선택된 파일에 저장된 문자열에 있는 내용을 TextArea에 출력하는 메소드
	public void loadFromFile(File f) {
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			while(true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				area.append(line+"\r\n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//TextArea에 작성된 문자열을 파일에 저장된 메소드
	public void saveToFile(File f) {
		//1. TextArea 에 작성된 문자열을 읽어와서
		//textArea.getText() 하면 TextArea에 있는 모든 스트링을 얻는다. 개행기호도 포함. (while문, 개행기호가 필요없는 이유)
		String content=area.getText();
		//2. 저장하기로 선택된 File 객체의 참조값을 얻어와서 텍스트를 저장하다.
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(f);
			fw.write(content);
			JOptionPane.showMessageDialog(this, "파일에 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "파일에 저장 실패!");
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//ActionListener, ActionCommand 설정
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		if(command.equals(COMMAND_NEW)) {
			
			area.setVisible(true);
			
		}else if(command.equals(COMMAND_OPEN)) {
			
			area.setVisible(true);
			JFileChooser fc=new JFileChooser("c:/myFolder");
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			fc.setFileFilter(filter);
			int result=fc.showOpenDialog(this);
			
			if(result==JFileChooser.APPROVE_OPTION) {
				File selectedFile=fc.getSelectedFile();
				//미리 만들어둔 메소드 사용
				loadFromFile(selectedFile);
				
			}
		
		}else if(command.equals(COMMAND_SAVE)) {
			
			JFileChooser fc=new JFileChooser("c:myFolder");
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			fc.setFileFilter(filter);
			int result=fc.showSaveDialog(this);
			
			if(result==JFileChooser.APPROVE_OPTION) {
				File selectedFile=fc.getSelectedFile();
				//미리 만들어둔 메소드 사용
				saveToFile(selectedFile);
			}
		}
	}
}
