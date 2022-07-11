package com.example.leetcode.nowcoder;

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner  =  new Scanner(System.in);
        int len1 = Integer.parseInt(scanner.nextLine());
        List<List<List<String>>> features = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            int len2 = Integer.parseInt(scanner.nextLine());
            List<List<String>> video = new ArrayList<>();
            for (int j = 0; j < len2; j++) {
                String[] s = scanner.nextLine().split(" ");
                List<String> actions = new ArrayList<>(Arrays.asList(s));
                video.add(actions);
            }
            features.add(video);
        }

        System.out.println(MaxFeature(features));
    }



    static int MaxFeature(List<List<List<String>>> features){

        // 拿出视频
        int max = 1;
        for (int i = 0; i < features.size(); i++) {
            // 拿出帧
            List<List<String>> frame = features.get(i);
            HashMap<String,Integer> preHashMap = new HashMap<>();
            HashMap<String,Integer> curHashMap = new HashMap<>();
            for (int j = 0; j < frame.size(); j++) {
                List<String> actions = frame.get(j);
                // 统计具体帧数的连续动作
                int featuresNums = Integer.parseInt(actions.get(0));
                for (int k = 1; k < actions.size(); k++) {
                    String f1 = actions.get(k);
                    String f2 = actions.get(++k);
                    Integer val = preHashMap.getOrDefault(f1+" "+f2,0);
                    ++val;
                    max = Math.max(max,val);
                    curHashMap.put(f1+" "+f2,val);
                }
                preHashMap = curHashMap;
                curHashMap = new HashMap<>();
            }
        }

        return max;
    }
}
