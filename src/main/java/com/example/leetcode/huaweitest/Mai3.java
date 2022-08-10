package com.example.leetcode.huaweitest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Mai3 {


    public static int findMinDifference(List<String> timePoints) {
        //新建一个date数组，用于存储转换后的date
        Date[] dates=new Date[timePoints.size()];
        //循环实现timePoints的所有值经过转换后赋值给dates数组
        for (int i = 0; i < timePoints.size(); i++) {
            try {
                //将字符串转换成日期格式
                Date date = new SimpleDateFormat("HH:mm").parse(timePoints.get(i));
                dates[i]=date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //给dates数组排序
        Arrays.sort(dates);
        //差值数组
        long[] differences=new long[dates.length];
        //循环获取差值
        for (int i = 0; i < dates.length; i++) {
            if(i==dates.length-1){
                differences[i]=Math.abs((dates[i].getTime()-dates[0].getTime())/60000L);
            }else{
                differences[i]=Math.abs((dates[i+1].getTime()-dates[i].getTime())/60000L);
            }
            differences[i]=differences[i]>720L?(1440L-differences[i]):differences[i];//因为时间是循环制，所以有时候补数"更小"
        }
        //给difference数组排序
        Arrays.sort(differences);
        //获取最小值
        Long mindiffer=differences[0];
        return Integer.valueOf(mindiffer.toString());
    }


}
