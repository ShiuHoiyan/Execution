package com.example.diong.todo;

/**
 * Created by Diong on 2016/11/29.
 */
public class TodoItem {
    private int important;
    private int finish;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String content;

    public TodoItem(String con, int y, int mo, int d, int h, int mi, int i,int f) {
        content = con;
        important = i;
        year = y;
        month = mo;
        day = d;
        hour = h;
        minute = mi;
        finish = f;
    }

    public void setImportant() {
        important = 1;
    }
    public void setFinish(){finish = 1;}
    public void cancelFinish() {finish = 0;}

    public void cancelImportant() {
        important = 0;
    }

    public void setYear(int y) {
        year = y;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setHour(int h) {
        hour = h;
    }

    public void setMinute(int m) {
        minute = m;
    }

    public void setContent(String c) {
        content = c;
    }

    public int getToDoYear() {
        return year;
    }

    public int getToDoMonth() {
        return month;
    }

    public int getToDoDay() {
        return day;
    }

    public int getToDoHour() {
        return hour;
    }

    public  int getToDoMinute() {
        return minute;
    }

    public String getToDoContent() {
        return content;
    }

    public int getImportant() {
        return important;
    }
    public int getFinish(){return finish;
    }
}
