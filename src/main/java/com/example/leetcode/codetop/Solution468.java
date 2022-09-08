package com.example.leetcode.codetop;

public class Solution468 {

    public String validIPAddress(String queryIP) {

        if (isIPv4(queryIP)){
            return  "IPv4";
        }

        if (isIPv6(queryIP)){
            return  "IPv6";
        }



        return "Neither";
    }

    private boolean isIPv6(String queryIP) {
        if (queryIP.startsWith(":")||queryIP.endsWith(":")){
            return false;
        }

        String[] split = queryIP.split(":");
        if (split.length !=7 ){
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            String page = split[i];
            // 前导0 或者空错误
            if (page.isEmpty()  || (page.length()> 4)){
                return false;
            }
            for (int i1 = 0; i1 < page.length(); i1++) {
                char c = page.charAt(i1);
                if (!Character.isDigit(c) && !('a' <= Character.toLowerCase(c) && Character.toLowerCase(c) <= 'f')) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isIPv4(String queryIP) {
        if (queryIP.startsWith(".")||queryIP.endsWith(".")){
            return false;
        }
        String[] split = queryIP.split("\\.");
        if (split.length !=4 ){
            return false;
        }
        // 每一部分数组要求无前导0,且为数字
        for (int i = 0; i < split.length; i++) {
            String page = split[i];
            // 前导0 或者空错误
            if (page.isEmpty()  || (page.length()>1 && page.charAt(0)== '0')){
                return false;
            }
            for (int i1 = 0; i1 < page.length(); i1++) {
                char c = page.charAt(i1);
                if (!(Character.isDigit(c))){
                    return false;
                }
            }
            if (Integer.parseInt(page) > 255){
                return false;
            }
        }

        return true;
    }

    public String validIPAddressOF(String IP) {
        if (IP == null) {
            return "Neither";
        }

        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (IP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (IP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }
    public String validIPAddress1(String queryIP) {

        if (queryIP.indexOf('.') >= 0) {
            // IPv4
            int last = -1;
            for (int i = 0; i < 4; ++i) {
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                    return "Neither";
                }
                int addr = 0;
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j))) {
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }
                if (addr > 255) {
                    return "Neither";
                }
                if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                    return "Neither";
                }
                if (addr == 0 && cur - last - 1 > 1) {
                    return "Neither";
                }
                last = cur;
            }
            return "IPv4";
        } else {
            // IPv6
            int last = -1;
            for (int i = 0; i < 8; ++i) {
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                    return "Neither";
                }
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                        return "Neither";
                    }
                }
                last = cur;
            }
            return "IPv6";
        }
    }



    public static void main(String[] args) {
        Solution468 solution468 = new Solution468();
        System.out.println(solution468.validIPAddress1("20EE:Fb8:85a3:0:0:8A2E:0370:7334:12"));

    }

}
