package lambdasinaction.chap4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.toList;

public class ZBStreamPractice {

	public static void main(String... args) {

		System.out.println("下面是 过滤：filter 结果");

		List<Dish> list = Dish.menu.stream().filter(d -> d.getCalories() < 600).collect(toList());
		list.forEach(System.out::println);

		System.out.println("-------------------------");

		System.out.println("下面是 提取：map 结果");

		List<String> list1 = Dish.menu.stream().map(Dish::getName).collect(toList());
		list1.forEach(System.out::println);

		System.out.println("-------------------------");

		System.out.println("下面是 截断：limit 结果");

		List<Dish> list2 = Dish.menu.stream().limit(4).collect(toList());
		list2.forEach(System.out::println);

		System.out.println("-------------------------");

		System.out.println("下面是 排序：sort 结果 采用sort直接排序输出");

		Dish.menu.sort(Comparator.comparing(Dish::getName));

		Dish.menu.forEach(System.out::println);

		System.out.println("下面是 排序：sort 结果 采用sorted，重新生成一个list");

		List<Dish> list3 = Dish.menu.stream().sorted(Comparator.comparing(Dish::getName)).collect(toList());
		list3.forEach(System.out::println);

		System.out.println("-------------------------");

		System.out.println("下面是 合并：reduce 结果 将所有卡路里加总");

		Optional<Integer> list4 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum);
		System.out.println(list4);

	}
}
