package test.main;

import test.member.dao.MemberDao;

public class MainClass09 {
	public static void main(String[] args) {
		//850번 회원의 정보를 삭제 하고자 한다.
		
		MemberDao dao=new MemberDao();
		boolean isSuccess=dao.delete(102);
		
		if(isSuccess) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패!");
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
