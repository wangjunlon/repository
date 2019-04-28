package com.unicomcity.common.controller;

import lombok.Data;
@Data
public class MessageObject {
	private String code; //错误编号
	private Object content;//obj主体
	private long pages;//数据总条数
	private long pagesize;//当前条页数
	private long current;//每页多少条
}
