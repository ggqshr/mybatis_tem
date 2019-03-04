package com.ggq;

import org.apache.ibatis.type.Alias;

@Alias("emp")
public class test_casc {
    private String name;
    private int month;
    private int money;

    public test_casc(String name, int month, int money) {
        this.name = name;
        this.month = month;
        this.money = money;
    }

    public test_casc() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "test_casc{" +
                "name='" + name + '\'' +
                ", month=" + month +
                ", money=" + money +
                '}';
    }
}
