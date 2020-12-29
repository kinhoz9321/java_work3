package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{

	//필드
	JTextField text_name;
	JTextField text_addr;
	
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public MemberFrame(String title) {
		super(title);
		//프레임의 레아아웃 법칙 지정하기
		setLayout(new BorderLayout());
		
		//상단 패널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.PINK);
		
		//패널을 상단에 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		//패널에 UI 객체를 생성해서
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		
		//패널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		
		//추가 버튼에 ActionListener 등록
		btn_add.addActionListener(this);
		//추가 버튼에 ActionCommand 지정
		btn_add.setActionCommand("add");
		
		//회원 목록을 출력할 테이블
		table=new JTable();
		
		//칼럼명을 String[]에 순서대로 준비하기
		String[] colNames= {"번호", "이름", "주소"};
		
		//테이블에 연결할 기본 모델 객체
		model=new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
		
		//모델을 테이블에 연결하기
		table.setModel(model);
		
		//테이블 내용이 scroll 될 수 있도록 스크롤 패널로 감싸기
		JScrollPane scPane=new JScrollPane(table);
		
		//스크롤 패널을 프레임의 중앙에 배치하기
		add(scPane, BorderLayout.CENTER);
		
		//회원 목록을 테이블에 출력하기
		printMember();
		
		/*
		 * 삭제 버튼 - 특정 로우를 선택한 다음에 삭제를 누르면 삭제되게 하기.
		 * (선택한 num을 이용해서 삭제하기. 삭제하고 목록 불러오기.)
		 */
		
		JButton btn_delete=new JButton("삭제");
		topPanel.add(btn_delete);
		
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");
		
		//테이블의 값이 바뀌는지 감시할 리스너 등록하기
		table.addPropertyChangeListener(this);
		
		//회원 목록을 주기적으로 업데이트 해주는 스레드 시작 시키기
		//new UpdateThread().start();
	}

	//main 메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원 정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		if(command.equals("add")) {
			addMember();
		}else if(command.equals("delete")) {
			deleteMember();
		}
	}
	
	//회원 목록을 테이블에 출력하는 메소드 (3가지 방법)
	/* 1 */
	public void printMember() {
		//회원 목록 불러오기
		MemberDao dao=new MemberDao();
		List<MemberDto> list=dao.selectAll();
		//기존에 출력된 내용 초기화
		model.setRowCount(0);//0개의 row로 강제 초기화
		
		for(int i=0; i<list.size(); i++) {
			Vector<Object> row=new Vector<>();
			row.add(list.get(i).getNum());
			row.add(list.get(i).getName());
			row.add(list.get(i).getAddr());
			
			model.addRow(row);
		}
	}
	
	/* 2 */
//	public void printMember() {
//		MemberDao dao=new MemberDao();
//		List<MemberDto> list=dao.selectAll();
//		model.setRowCount(0);
//		
//		for(MemberDto tmp:list) {
//			Vector<Object> row=new Vector<Object>();
//			row.add(tmp.getNum());
//			row.add(tmp.getName());
//			row.add(tmp.getAddr());
//			
//			model.addRow(row);
//		}
//	}
	
	/* 
	 * 3 생각해보기. 
	 * object로 만드는 법 다시 보고 for문 일반for문으로 고쳐보기
	 */
//	public void printMember() {
//		MemberDao dao=new MemberDao();
//		List<MemberDto> list = dao.selectAll();
//		model.setRowCount(0);
//		
//		//model.setRowCount(0); // 0 개의 row 로 강제로 초기화 하고
//		      
//		for (MemberDto tmp : list) {
//			Object[] row ={tmp.getNum(),tmp.getName(),tmp.getAddr() };
//		   model.addRow(row);
//		}
//	}
	
	//회원 정보를 추가하는 메소드 
	public void addMember() {
		
		//1. 입력한 이름과 주소를 읽어와서
		String name=text_name.getText();
		String addr=text_addr.getText();
		//2. MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//3. MemberDao 객체를 이용해서 DB에 저장
		MemberDao dao=new MemberDao();
		//작업의 성공 여부를 isSuccess 에 담기
		boolean isSuccess=dao.insert(dto);
		//실제 저장되었는지 확인
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name+" 의 정보 추가 성공");
			//테이블에 다시 목록 불러오기
			printMember();
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
	}
	
	//table 칼럼이 수정 중인지 여부
	//필드
	boolean isEditing=false;
	
	//PropertyChangeListener 메소드 
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			System.out.println("change");
			System.out.println(e.getPropertyName());
			//만일 table 칼럼에서 발생한 이벤트라면
			if(e.getPropertyName().equals("tableCelloEditor")){
				if(isEditing) {
					//수정된 row를 읽어와서 DB에 반영한다.
					int selectedIndex=table.getSelectedRow();
					
					int num=(int)model.getValueAt(selectedIndex, 0);
					
					String name=(String)model.getValueAt(selectedIndex, 1);
					String addr=(String)model.getValueAt(selectedIndex, 2);
					
					MemberDto dto=new MemberDto(num, name, addr);
					new MemberDao().update(dto);
				}
				//isEditing 의 값을 반대로 바꿔준다. 
				//true => false, false => true
				isEditing=!isEditing;
			}
		}
	
	//화면을 주기적으로 update 해주는 스레드
	class UpdateThread extends Thread{
		@Override
		public void run() {
			//바깥에 싸고 있는 클래스의 멤버 메소드 printMember() 메소드를 5초마다 한번씩 주기적으로 호출하기
			while(true) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//화면 업데이트
				printMember();
			}
		}
	}
	
	//회원 정보를 삭제하는 메소드
	public void deleteMember() {
		//선택된 row의 인덱스를 읽어온다.
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택해주세요.");
			return;//메소드를 여기서 끝내라
		}
		//선택한 row의 0번 칼럼의 값(번호)을 읽어와서 int로 casting 하기
		int num=(int)table.getValueAt(selectedIndex, 0);
		//삭제 하기 전에 한번 확인하기
		int result=JOptionPane.showConfirmDialog(this, num+" 번 회원을 삭제 하시겠습니까?");
		//만일 yes를 눌렀을 때
		if(result==JOptionPane.YES_OPTION) {
			//MemberDao 객체를 이용해서 삭제하기
			new MemberDao().delete(num);
			//UI 업데이트 (목록 다시 출력하기)
			printMember();
		}
	}
}
