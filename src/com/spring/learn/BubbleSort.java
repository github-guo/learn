package com.spring.learn;

public class BubbleSort {
	/**
	 * 冒泡算法
	 * 相邻位置交换
	 * 两次循环 第一次将最大数放置在末尾
	 * 第二次控制剩余需要比较次数
	 * @param args
	 */
	
	public  void  traditionalBubbleSort(){
		int a[] = { 10, 5, 14, 2, 6, 7, 11, 3 };
		System.out.println("original array:");
		for (int test : a) {
			System.out.print(test + ",");
		}
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++)
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
		}
		System.out.println("\nafter sorted:");
		for (int test : a) {
			System.out.print(test + ",");
		}
	}
	
	
	public  void updatedBubbleSort(){
		int a[] = { 10, 5, 14, 2, 6, 7, 11, 3 };
		boolean isSorted=false;
		int count =0;
		for(int i=0;i<a.length-1&&isSorted==false;i++){
			count++;
			isSorted = true;
			for(int j=0;j<a.length-1-i;j++){
				if (a[j] > a[j + 1]) {
					isSorted=false;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}	
			}
		}
		System.out.println("\ntimes:"+count);
		for (int test : a) {
			System.out.print(test + ",");
		}
	}
}
