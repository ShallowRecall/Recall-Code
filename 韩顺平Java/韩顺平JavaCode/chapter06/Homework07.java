public class Homework07{
	public static void main(String[] args) {
		int[] arr={23,12,45,67,98,78};
		int temp = 0;
		for (int i = 0;i < arr.length-1;i++) {
			for (int j = 0; j < arr.length-1-i ;j++ ) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int i = 1;i < arr.length ;i++ ) {
			System.out.print(arr[i]+"\t");
		}
	}
}