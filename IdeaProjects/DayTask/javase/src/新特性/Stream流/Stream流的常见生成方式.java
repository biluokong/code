package 新特性.Stream流;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 1、Collection体系的集合可以用默认方法 stream() 生成流
 *
 * 2、Map体系的集合可以用间接方式生成流
 *
 * 3、数组可以通过Stream流接口的静态方法 of(T... values)、of(T t) 生成流
 */
public class Stream流的常见生成方式 {
    public static void main(String[] args) {
        //map体系间接获得流
        Map map = new HashMap();
        Stream stream1 = map.keySet().stream();
        Stream stream2 = map.entrySet().stream();

        int[] nums = {1, 2, 4};
        Stream<int[]> stream = Stream.of(nums);
    }
}
