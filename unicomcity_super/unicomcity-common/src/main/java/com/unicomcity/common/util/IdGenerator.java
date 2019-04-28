package com.unicomcity.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 生成数字型ID,年月日时分秒毫秒(yyMMddHHmmssSSS)+后缀(IP作节点ID,sequence序号)
 * 与snowflake算法区别,返回字符串id,占用更多字节,但直观从id中看出生成时间
 *
 * @author liujia
 * 日期：2018-04-26
 */
public enum IdGenerator {

	INSTANCE;

	private long workerId;   //用ip地址最后几个字节标示
    private long sequence = 0L;
    private long sequenceBits = 12L; //序列号12位
    private long sequenceMask = -1L ^ (-1L << sequenceBits); //4095
    private long lastTimestamp = -1L;

	IdGenerator() {
		workerId = 0x000000FF & getLastIP();
	}

	public synchronized String nextId() {
		long timestamp = timeGen(); // 获取当前毫秒数
		// 如果服务器时间有问题(时钟后退) 报错。
		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
		// 如果上次生成时间和当前时间相同,在同一毫秒内
		if (lastTimestamp == timestamp) {
			// sequence自增，因为sequence只有12bit，所以和sequenceMask相与一下，去掉高位
			sequence = (sequence + 1) & sequenceMask;
			// 判断是否溢出,也就是每毫秒内超过4095，当为4096时，与sequenceMask相与，sequence就等于0
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp); // 自旋等待到下一毫秒
			}
		} else {
			sequence = 0L; // 如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加
		}
		lastTimestamp = timestamp;
		//long suffix = sequence;
		String workerIp = String.format("%03d", workerId);
		String suffixs = String.format("%02d", sequence);
		String datePrefix = DateFormatUtils.format(timestamp, "yyMMddHHmmssSSS");
		return datePrefix + workerIp + suffixs;
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return System.currentTimeMillis();
	}

	private byte getLastIP() {
		byte lastip = 0;
		try {
			InetAddress ip = InetAddress.getLocalHost();
			byte[] ipByte = ip.getAddress();
			lastip = ipByte[ipByte.length - 1];
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return lastip;
	}
	public static void main(String[] args) {
    	final IdGenerator idg = IdGenerator.INSTANCE;
        ExecutorService es = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        System.out.println("***** start generate id ******");
        for (int i = 0; i < 10; i++)
            es.execute(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        String id= idg.nextId();
                        System.out.println(id);
                    }
                }
            });
        es.shutdown();
        
        long end = System.currentTimeMillis();
        System.out.println("***** end generate id *****");
        System.out.println("***** cost " + (end-start) + " ms!");
        
	}
}