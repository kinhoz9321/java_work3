package test.main;

/* 
 * [눈 여겨 봐야할 점!]
 * 
 * 1. 배열은 어떻게 만드는지?
 * - 배열은 중괄호 { }를 열고 닫고 해서 만든다.
 * - 데이터 타입 [ ] 변수명={값1, 값2, 값3 ...};
 * 
 * 2. 배열의 데이터 타입은 어떻게 선언하는지?
 * - 배열 안에 저장된 type+[ ] 기호를 조합해서 선언한다.
 * - 배열 안에 들어갈 내용에 맞춰서 [ ]앞에 선언한다.
 * - 배열은 여러 개의 타입을 섞을 수 없다. 한가지 타입만 담아야 한다.
 * 
 * 3. nums, nums2, truth, names에 저장된 값은 참조값인지 아닌지?
 * (배열이 참조 데이터 타입인지, 기본 데이터 타입인지?)
 * - 배열은 참조 데이터 타입이다.
 */

public class MainClass01 {
	public static void main(String[] args) {
		
		/*
		 * int type 5개를 저장하고 있는 고정 배열
		 * (고정 배열에는 기본 데이터 타입이 들어갈 수 있다.)
		 */
		int[] nums= {10,20,30,40,50};
		
		//double type 5개를 저장하고 있는 고정 배열
		double[] nums2= {10.1,10.2,10.3,10.4,10.5};
		
		//boolean type 3개를 저장하고 있는 고정 배열
		boolean[] truth= {true, false, true};
		
		//String type 3개를 저장하고 있는 배열
		String[] names= {"김구라", "해골", "원숭이"};
		
		//.length; - 필드. 배열의 방의 갯수가 참조된다.
		
		//nums 배열의 방의 갯수 = 5
		int size=nums.length;
		
		//names 배열의 방의 갯수 = 3
		int size2=names.length;
		
		//배열의 각각의 방에 저장된 아이템을 참조하는 방법
		//데이터타입 변수명=배열변수명[index];
		
		int num1=nums[0];//10
		int num2=nums[1];//20
		int num3=nums[2];//30
		
		String name1=names[0];//"김구라"
		String name2=names[1];//"해골"
		String name3=names[2];//"원숭이"
	}
}
/* 
 * [알아두기]
 * 
 * 고정 배열에 저장된 값에는 기본 데이터 타입이 들어갈 수 있다.
 * 가변 배열에는 참조 데이터 타입만 들어갈 수 있다.
 */ 
