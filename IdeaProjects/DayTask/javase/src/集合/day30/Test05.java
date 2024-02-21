package 集合.day30;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
如{黑龙江省=哈尔滨, 浙江省=杭州, …}*/
public class Test05 {
    public static void main(String[] args) {
        String[] str1 = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
        String[] str2 = {"哈尔滨", "杭州", "南昌", "广州", "福州"};
        Map<String, String> map = new HashMap();
        for (int i = 0; i < str1.length; i++) {
            map.put(str1[i], str2[i]);
        }
        Set<String> set =  map.keySet();
        for (String s : set) {
            System.out.println(s + "=" + map.get(s));
        }
        System.out.println("==========================================");
        Set<Map.Entry<String, String>> set1 = map.entrySet();
        for (Map.Entry<String, String> entry : set1) {
            System.out.println(entry);
        }
    }
}
