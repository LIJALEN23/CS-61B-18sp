package demo2;

import java.util.Set;
import java.util.HashSet;
public class TwoSum {
    //数组中是否有两个元素的和等于k
    public static boolean hasPairWithSum(int[] arr, int k) {
        Set<Integer> seenNumbers = new HashSet<>();     //建立一个集合来储存遍历过的元素
        for (int i : arr) {
            if (seenNumbers.contains(k - i)) {          //如果集合中存在一个数满足 = K - i，则返回true
                return true;
            }
            seenNumbers.add(i);                         //如果不满足则将元素储存在结合中
        }
        return false;                                   //所有元素都遍历完了，不存在满足条件的元素则返回false
    }
}
