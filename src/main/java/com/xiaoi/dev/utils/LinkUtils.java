package com.xiaoi.dev.utils;

public class LinkUtils {
	public static String tagFilter(String answer) {
		if (answer == null)
			return null;
		// 替换link url
		answer = answer.replaceAll("\\[link url=(.*?)](.*?)\\[/link]",
				"<a target=\"_blank\" href=$1>$2</a>");
		// 替换link submit
		// send方法为前端js方法名称
		answer = answer.replaceAll("\\[link submit=(.*?)](.*?)\\[/link]",
				"<a onclick='send($1)' href=\"javascript:void(0);\">$2</a>");
		// 替换link submit简写
		answer = answer.replaceAll("\\[link](.*?)\\[/link]",
						"<a onclick='send(\"$1\")' href=\"javascript:void(0);\">$1</a>");
		return answer;
	}
}
