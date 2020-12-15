package test.mypac;
/*
 *  static 자원을 포함하는 용도로 사용해 보기
 */
public class MyUtil {
	
	//non static field. 필드를 선언하면서 값을 넣을 수 있다.
	public int version=1;
	
	public static String owner;
	
	public static void playMusic() {
		System.out.println("음악을 틀어요!");
	}
}
/*
 * <알아두기!>
 * static method 안에서 non static 자원은 참조할 수 없다.
 * static method 안에서는 static 자원만 참조할 수 있다.
 */
