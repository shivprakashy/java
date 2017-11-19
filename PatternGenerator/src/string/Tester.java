package string;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;

public class Tester {
	public static void main(String[] args) {
		xyz ob1 = new xyz("");
		List<Integer> numbers = Arrays.asList(4, 2, 3, 7, 6, 13, 11, 1, 2);
		int sum = numbers.stream().filter(n -> n % 3 == 1).map(n -> n * n + 2).reduce(0, Integer::sum);
		System.out.print(ob1);
		System.out.print((sum / 2) / 2);
	}
}

 class xyz {
	private String g1;

	public xyz(String ss) {
		g1 = "parts" + ss;
	}

	public String toString() {
		return g1;
	}
}