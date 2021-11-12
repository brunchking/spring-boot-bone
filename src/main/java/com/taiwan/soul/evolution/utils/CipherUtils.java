package com.taiwan.soul.evolution.utils;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CipherUtils {
	private static final Logger logger = LoggerFactory.getLogger(CipherUtils.class);

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	public static String encodeMD5(String str) {
		String encodeStr = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] bytes = str.getBytes("UTF-8");
			messageDigest.update(bytes);
			encodeStr = getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			logger.error("String [" + str + "] Encode MD5 failed.");
			logger.error(e.getMessage(), e);
		}
		return encodeStr;
	}

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}

		return buf.toString();
	}

}
