package com.lanniuh.mq;

public class MQManage {
//	private static QueueManage qm = null;
//	private static MQQueueManager qmr = null;
//
//	private MQManage() {
//	}
//
//	private static final MQManage MQ_MANAGE = new MQManage();
//
//	public static MQManage getInstance() {
//		return MQ_MANAGE;
//	}
//
//	static {
//		try {
//			QueueTools queueTools = new QueueTools();
//			qmr = queueTools.connect("QMGR.S41");
////			qm = new QueueManage();
////			qmr = qm.connectionMQ();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public MQQueueManager getMQQueueManager() {
//		if (qmr == null || !qmr.isConnected()) {
//			try {
//				qm = new QueueManage();
//				qmr = qm.connectionMQ();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return qmr;
//	}
//
//	public QueueManage getQueueManage(){
//		if (qm==null) {
//			qm = new QueueManage();
//		}
//		return qm;
//	}
}
