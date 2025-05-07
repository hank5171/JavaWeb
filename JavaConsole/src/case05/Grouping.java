package case05;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping {
	public static void main(String[] args) {
		List<String> fruits = List.of("apple","banana","apple","orange","banana","papaya","apple");
		// 請問每一種水果有幾個
		System.out.println(
		//fruits.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()))
		fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        );
		
		
		Map<String, Long> result = fruits.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(result);
		
	}
}
