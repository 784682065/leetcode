package com.example.leetcode.codetop;

import java.io.Serializable;

class IP implements Serializable {

    private static final long serialVersionUID = -8903000680469719698L;
    private String ip = "";
    private int count;

    public IP(String ip2, Integer integer) {
        this.ip = ip2;
        this.count = integer;
    }

    public int getCount() {
        return count;
    }

    public String getIp() {
        return ip;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
