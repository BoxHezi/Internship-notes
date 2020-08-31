package week1;

import java.util.HashMap;
import java.util.Map;

public class Week1HashMap {

    public static void main(String[] args) {

        // 创建map时，不创建数组
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 首次put时，初始化数组
        map.put(1, 1);
        map.put(1, 2);
        map.put(17, 3);

    }

}