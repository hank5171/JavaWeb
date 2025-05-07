package case05;

import java.util.List;
//import java.util.stream.Collector;
import static java.util.stream.Collectors.partitioningBy;

public class Partitioning {
	public static void main(String[] args) {
		List<Integer> scores = List.of(100, 50, 40, 90, 80);
		/*
		 * 及格:{100,90,80}
		 * 不及格: {50,40}
		 * */
	//	System.out.print(
	//	scores.stream().collect(Collectors.partitioningBy(score -> score >= 60))
	//	);
		
		System.out.print(
		scores.stream().collect(partitioningBy(score -> score >= 60))
		);
	}
}
