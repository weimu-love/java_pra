package cherry.pra.var;

public class Main {

	public static void main(String[] args) {

		double pi = 3.14;
		double a = 2.769343;
		int b = 365;
		int c = 12;
		char d = '吃';
		boolean e = false;
		String limit = "不可描述";
		String offset = "诡异";

		Object[] rs = new Object[] { limit, offset };
		System.out.println(rs[0]);
	}

	public void method1(final int j) {
//		j = 5;
	}
}
