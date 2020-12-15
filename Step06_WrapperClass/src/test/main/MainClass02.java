package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		double num1=10.1;
		Double num2=10.2;
		
		double result1=num2+10;
		double result2=num1+num2;
		Double result3=num1+num2;
		
		//10.2 => "10.2"
		String result4=num2.toString();
		//"99.9" => 99.9
		double result5=Double.parseDouble("99.9");
		
	}
}
/*
Integer.parseInt();
Double.parseDouble();

가변배열 - 값을 넣었다 뺐다 하며 방을 크게, 작게 할 수 있는 배열. 
자바에서는 가변배열에 참조값만 담을 수 있다. 
그래서 기본 데이터 타입은 담을 수 없기 때문에, 기본 데이터 타입을 참조 데이터 타입으로 바꿔주어야 한다. 

고정 배열 - 방의 갯수가 정해지면 바꿀 수 없다. 
고정 배열에는 기본 데이터 타입을 담을 수 있다.
*/