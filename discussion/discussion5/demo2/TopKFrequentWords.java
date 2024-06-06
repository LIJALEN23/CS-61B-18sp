//package demo2;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Map.Entry;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class TopKFrequentWords {
//    public static List<String> topKFrequent(String[] words, int k) {
//        // 第一步：统计每个单词的出现频率
//        Map<String, Integer> frequencyMap = new HashMap<>();
//        for (String word : words) {
//            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
//        }
//
//        // 第二步：使用最小堆维护前 k 个最频繁的单词
//        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
//                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
//        );
//
//        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
//            minHeap.offer(entry);
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//
//        // 第三步：从堆中提取单词并返回
//        List<String> result = new ArrayList<>();
//        while (!minHeap.isEmpty()) {
//            result.add(minHeap.poll().getKey());
//        }
//
//        // 因为我们想要按频率降序排列，所以需要反转列表
//        Collections.reverse(result);
//        return result;
//    }
//}
