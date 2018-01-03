package com.util.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CNNumberFormat {
	private static final char[] cnNumbers = { '零', '壹', '贰', '叁', '肆', '伍',
			'陆', '柒', '捌', '玖' };
	private static final char[] stdNumbers = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9' };
	/**
	 * 货币单位
	 */
	private static final char[] units = { '厘', '分', '角', '元', '拾', '佰', '仟',
			'万', '拾', '佰', '仟', '亿', '拾', '佰', '仟' };
	/**
	 * 是否输出货币的单位的圆角分的完整格式
	 */
	private boolean fullFormat = true;

	public CNNumberFormat() {
	}

	private CNNumberFormat(boolean fullFormat) {
		this.fullFormat = fullFormat;
	}

	/**
	 * 取得大写形式的装换
	 * 
	 * @param d
	 * @return
	 */
	public String format(double d) {
		NumberFormat nf = new DecimalFormat("#.###");
		return this.transform(nf.format(d));
	}

	public String format(long ln) {
		return this.transform(String.valueOf(ln));
	}

	private String transform(String original) {
		String integerPart = "";
		String floatPart = "";
		if (original.indexOf(".") > -1) {
			int dotIndex = original.indexOf(".");
			integerPart = original.substring(0, dotIndex);
			floatPart = original.substring(dotIndex + 1);
		} else {
			integerPart = original;
		}
		StringBuffer sb = new StringBuffer();
		// 整数部分部处理
		for (int i = 0; i < integerPart.length(); i++) {
			int number = Integer
					.parseInt(String.valueOf(integerPart.charAt(i)));
			sb.append(cnNumbers[number]);
			if (fullFormat) {
				sb.append(units[integerPart.length() + 2 - i]);
			}
		}
		// 小数部分处理
		if (floatPart.length() >= 1) {
			for (int i = 0; i < floatPart.length(); i++) {
				int number = Integer.parseInt(String.valueOf(floatPart
						.charAt(i)));
				sb.append(cnNumbers[number]);
				if (fullFormat && i <= 3) {
					sb.append(units[2 - i]);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将中文大写数字字符串转换成对应的数字类型
	 * 
	 * @param cnNumber
	 * @return
	 */
	public Number parse(String cnNumStr) {
		if (cnNumStr == null || "".equals(cnNumStr.trim())) {
			return null;
		}
		cnNumStr = cnNumStr.replaceAll("整", "");
		if (!cnNumStr.endsWith("元")) {
			cnNumStr = cnNumStr.replaceAll("元", ".");
		}
		for (int k = 0; k < cnNumStr.length(); k++) {
			for (int i = 0; i < cnNumbers.length; i++) {
				cnNumStr = cnNumStr.replace(cnNumbers[i], stdNumbers[i]);
			}
		}

		for (int j = 0; j < units.length; j++) {
			cnNumStr = cnNumStr.replace(units[j] + "", "");
		}
		BigDecimal b = new BigDecimal(cnNumStr);

		return b;
	}
	
	public static void main(String[] args) {
		CNNumberFormat format = new CNNumberFormat();
		Number result = format.parse("壹贰叁");
		System.out.println(result);
		
	}
}
