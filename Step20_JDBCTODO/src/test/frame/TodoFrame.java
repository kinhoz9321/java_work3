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

import test.todo.dao.TodoDao;
import test.todo.dto.TodoDto;

public class TodoFrame extends JFrame implements ActionListener, PropertyChangeListener{

	//필드
	JTextField text_content;
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public TodoFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.PINK);
		
		add(topPanel, BorderLayout.NORTH);
		
		JLabel label_content=new JLabel("내용");
		text_content=new JTextField(20);
		JButton btn_add=new JButton("추가");
		JButton btn_delete=new JButton("삭제");
		
		topPanel.add(label_content);
		topPanel.add(text_content);
		topPanel.add(btn_add);
		topPanel.add(btn_delete);
		
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		btn_delete.setActionCommand("delete");
		btn_delete.addActionListener(this);
		
		
		
		table=new JTable();
		String[] colNames= {"번호", "내용", "날짜"};
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
		
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane, BorderLayout.CENTER);
		printTodo();
		
		//할일 목록을 주기적으로 update 해주는 스레드 시작 시키기
		new UpdateThread().start();
		
		//테이블의 값이 바뀌는지 감시할 리스너 등록하기
		table.addPropertyChangeListener(this);
	}//생성자 마무리
	
	//main메소드
	public static void main(String[] args) {
		TodoFrame f=new TodoFrame("할일 목록");
		f.setBounds(500, 500, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}//main 메소드 마무리
	
	//할일 목록을 테이블에 출력하는 메소드
	public void printTodo() {
		
		//할일 목록 불러오기
		TodoDao dao=new TodoDao();
		List<TodoDto> list=dao.selectAll();
		
		model.setRowCount(0);
		
		for(TodoDto tmp:list) {
			Vector<Object> row=new Vector<Object>();
			row.add(tmp.getNum());
			row.add(tmp.getContent());
			row.add(tmp.getRegdate());
			
			model.addRow(row);
		}
	}
		
	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addTodo();
		}else if(command.equals("delete")) {
			deleteTodo();
		}
	}

	//회원정보를 추가하는 메소드
	public void addTodo() {
		String content=text_content.getText();
		
		TodoDto dto=new TodoDto();
		dto.setContent(content);
		
		TodoDao dao=new TodoDao();
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, "추가 성공!");
			printTodo();
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
		
		text_content.setText("");
	}
	
	
	//회원정보를 삭제하는 메소드
	public void deleteTodo() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요.");
			return;
		}
		int num=(int)table.getValueAt(selectedIndex, 0);
		int result=JOptionPane.showConfirmDialog(this, num+"번호를 삭제하시겠습니까?");
		
		if(result==JOptionPane.YES_OPTION) {
			new TodoDao().delete(num);
			printTodo();
		}
	}
	
	//화면을 주기적으로 update 해주는 스레드
	class UpdateThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				printTodo();
			}
		}
	}
	//table 칼럼이 수정중인지 여부 
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change!");
		System.out.println(evt.getPropertyName());
		//만일 table 칼럼에서 발생한 이벤트라면
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				//수정된 row 를 읽어와서 DB 에 반영한다.
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String content=(String)model.getValueAt(selectedIndex, 1);
				String regdate=(String)model.getValueAt(selectedIndex, 2);
				TodoDto dto=new TodoDto(num, content, regdate);
				new TodoDao().update(dto);
			}
			//isEditing 의 값을 반대로 바꿔준다. true => false, false => true
			isEditing=!isEditing;
		}
	}
}
