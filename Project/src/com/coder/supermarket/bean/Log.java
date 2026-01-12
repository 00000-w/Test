package com.coder.supermarket.bean;

import java.util.StringJoiner;

public class Log {
    private static int count = 0;

    private Long id;
    private String title;
    private String description;
    private String dateTime;
    private boolean isSuccess;
    private LogType logType;
    private String remark;

    public Log() {
        this.id = (long) ++count;
    }

    public Log(Long id, String title, String description, String dateTime, boolean isSuccess, LogType logType, String remark) {
        this.id = (long) ++count;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.isSuccess = isSuccess;
        this.logType = logType;
        this.remark = remark;
    }

    public Log(String title, String description, boolean isSuccess, LogType logType, String remark) {
        this.title = title;
        this.description = description;
        this.isSuccess = isSuccess;
        this.logType = logType;
        this.remark = remark;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Log.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t", id + "\t", "")
                .add(dateTime)
                .add("" + logType)
                .add((isSuccess ? "成功" : "失败"))
                .add("\t" + title)
                .add(":" + description)
                .add("\t\t备注:" + remark)
                .toString();
    }
    public enum LogType {
        收银员管理模块日志,
        商品模块日志,
        订单模块日志,
        收银员登录日志,
        日志管理模块日志,
    }
}
