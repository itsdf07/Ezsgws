package com.sdf.ezsgws.log;

import android.util.Log;

import com.sdf.ezsgws.global.Global;

public class Logger {
	/**
	 * 默认日志的tag
	 */
	private final static String DEFAULT_TAG = Global.TAG;

	/**
	 * 是否是测试版本
	 */
	private final static boolean IS_LOG = Global.isLog;

	/**
	 * 打印debug级别的日志
	 *
	 * @param tag
	 * @param msg
	 *            日期信息，参数采用{?}的形式， 例如 "这是个{?},继续打印其他参数"
	 * @param params
	 *            参数信息，用来替换msg中的{?}
	 */
	public static void d(String tag, String msg, Object... params) {
		if (!IS_LOG) {
			return;
		}

		String s = msgFromParams(msg, params);

		Log.d(tag, s);

	}

	/**
	 * 打印error级别的日志
	 *
	 * @param tag
	 * @param msg
	 *            日期信息，参数采用{?}的形式， 例如 "这是个{?},继续打印其他参数"
	 * @param params
	 *            参数信息，用来替换msg中的{?}
	 */
	public static void e(String tag, String msg, Throwable e, Object... params) {
		if (!IS_LOG) {
			return;
		}
		String s = msgFromParams(msg, params);
		Log.e(tag, s, e);
	}

	/**
	 *
	 * 打印debug级别的日志， 默认tag是@DEFAULT_TAG
	 *
	 * @param tag
	 * @param msg
	 *            日期信息，参数采用{?}的形式， 例如 "这是个{?},继续打印其他参数"
	 * @param params
	 *            参数信息，用来替换msg中的{?}
	 */
	public static void D(String msg, Object... params) {
		d(DEFAULT_TAG, msg, params);
	}

	/**
	 * 打印error级别的日志， 默认tag是@DEFAULT_TAG
	 *
	 * @param tag
	 * @param msg
	 *            日期信息，参数采用{?}的形式， 例如 "这是个{?},继续打印其他参数"
	 * @param params
	 *            参数信息，用来替换msg中的{?}
	 */
	public static void E(String msg, Throwable e, Object... params) {
		e(DEFAULT_TAG, msg, e, params);
	}

	/**
	 * 将消息重新组合格式化处理
	 *
	 * @param msg
	 * @param params
	 * @return
	 */
	private static String msgFromParams(String msg, Object... params) {
		StringBuffer bf = new StringBuffer();
		if (msg == null) {
			return null;
		}
		if (params == null) {
			return msg;
		}
		String msgArray[] = msg.split("\\{\\?\\}");
		int minLen = Math.min(msgArray.length, params.length);
		for (int i = 0; i < minLen; i++) {
			bf.append(msgArray[i]).append(params[i]);
		}
		for (int i = minLen; i < msgArray.length; i++) {
			bf.append(msgArray[i]);
		}
		return bf.toString();
	}

}
