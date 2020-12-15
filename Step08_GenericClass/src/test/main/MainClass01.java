package test.main;

import test.mypac.Apple;
import test.mypac.FruitBox;

public class MainClass01 {
	public static void main(String[] args) {
		
		FruitBox<Apple> box1=new FruitBox<Apple>();
		
		box1.setItem(new Apple());
		
		box1.getItem();
	}
}
/* 
 * Generic Class 확실히 공부가 더 필요함!
 */
