package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		
		//1. Car type 을 담을 수 있는 방 3개짜리 배열객체를 생성한 다음 참조값을 cars라는 지역변수에 담아보세요.
		Car[] cars=new Car[3];
		
		//2. cars 배열에 Car 객체를 생성해서 순서대로 담아보세요.
		Car c1=new Car();
		Car c2=new Car();
		Car c3=new Car();
		
		cars[0]=c1;
		cars[1]=c2;
		cars[2]=c3;
		
//		* 강사님 풀이 *
//		cars[0]=new Car();
//		cars[1]=new Car();
//		cars[2]=new Car();
		
		//3. cars 배열에 저장된 Car 객체의 참조값을 순서대로 참조해서 .drive()메소드를 호출해보세요.
		for(int i=0; i<cars.length; i++) {
			/* 1 */
			cars[i].drive();
			
			/* 2 */
//			Car tmp=cars[i];
//			tmp.drive();
		}
	}
}
