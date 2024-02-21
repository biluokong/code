package 新特性.Stream流;

import java.util.stream.Stream;

/**
 * 1、Stream<T> filter(Predicate p)：对流中的数据进行过滤
 *
 * 2、Stream<T> limit(long maxSize)：返回此流中从前面截取指定元素个数组成的流
 *
 * 3、Stream<T> skip(long n)：跳过指定的元素个数, 返回剩下元素组成的流
 *
 * 4、static <T> Stream<T> concat(Stream a, Stream b)：返回合并的两个流所组成的流
 *
 * 5、Stream<T> distinct()：返回由该流的不同元素组成的流（即去掉重复元素）
 *
 * 6、Stream<T> sorted(Comparator c)：返回排序后的流，由提供的比较器进行排序。（没有比较器，默认自然顺序排序）
 *
 * 7、<R> Stream<R> map(Function mapper)：返回由给定函数应用于此流后的结果组成的流
 *
 * 8、IntStream mapToInt(ToIntFunction mapper)：返回有给定函数应用于此流后的结果组成的IntStream流
 */
public class Stream流的常见中间操作 {
    public static void main(String[] args) {
        String str1 = "张三，王五，李四，张无忌，张三丰，李四";
        Stream<String> stream1 = Stream.of(str1.split("，"));
        Stream<String> stream2 = Stream.of("李小龙");

        //合并两个流
        //Stream.concat(stream1, stream2).forEach(System.out::print);

        //合并两个流并去掉重复元素，这里不能出现两个forEach，因为用到的流已进行了终结操作
        Stream.concat(stream1, stream2).distinct().forEach(System.out::print);

        Stream<String> stream3 = Stream.of("10", "30", "60");

        //获得流中整型数据的和
        System.out.println(stream3.mapToInt(Integer::parseInt).sum());
    }
}
