package cherry.pra.arr;

public class Main {

	public static void main(String[] args) {
		int[] arr = Tools.create(5);

		System.out.println("数组中的各个随机数是:");
		Tools.print(arr);

		arr = Tools.reverse(arr);
		System.out.println("反转后数组中的各个随机数是:");
		Tools.print(arr);

		int min = Tools.findMin(arr);
		System.out.println("数组中最小的一个数是" + min);
	}

}

class Tools {
//	建立一个随机数组，参数值为数组长度
	public static int[] create(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		return arr;
	}

//	反转数组
	public static int[] reverse(int[] arr) {
		int len = arr.length;
		int bilen = (len % 2 == 0) ? len / 2 : (len + 1) / 2;
//		System.out.println(bilen);
		if (len % 2 == 0) {
			for (int i = 0; i <= bilen - 1; i++) {
				int temp = arr[i];
				arr[i] = arr[len - i - 1];
				arr[len - i - 1] = temp;
			}
		} else {
			for (int i = 0; i < bilen - 1; i++) {
				int temp = arr[i];
				arr[i] = arr[len - i - 1];
				arr[len - i - 1] = temp;
			}
		}
		return arr;
	}

//	打印一个数组
	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

//	找出数组中的最小值
	public static int findMin(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (temp > arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	}
}
