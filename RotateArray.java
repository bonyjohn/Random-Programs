package test;

/* 
This is the implementation of reveresal algorithm to rotate the array 
*/
public class RotateArray {

	private static int a[] = {1,2,3,4,5,6};

	private static void arrayReverse(int start,int end){
		for(int i= start;i<end;i++){
			int temp = a[i];
			a[i] = a[end-i];
			a[end-i] = temp;
		}
	}

	private static void  printArray(){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i] + "," );
	}

	public static void main(String[] args) {

		arrayReverse(0,3);
		arrayReverse(3,a.length);
		printArray();


	}

}
