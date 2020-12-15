package test.mypac;

public class Member {
	public int num;
	public String name;
	public String addr;
	
	public void showInfo() {
		System.out.println("---- 정보 ----");
		System.out.println("번호:"+this.num);
		System.out.println("이름:"+this.name);
		System.out.println("주소:"+this.addr);
		System.out.println("-------------");
	}
}
/* 
 * class 설계 단계에서는 참조값을 알 수가 없다.
 * 
 * 객체를 만들었을 때 생기는 참조값 = this (객체 자신의 참조값을 가리키는 예약어)
 * this는 그때그때 다르다. 새로운 객체를 만들 때 마다 참조값이 달라지기 때문에.
 * 
 * <알아두기!>
 * this = 예약어 (*** 자주 사용! ***)
 * 
 * ex)
 * public void showinfo(){
 * 		this.num;
 * };
 */

