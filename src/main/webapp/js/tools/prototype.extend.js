/*
 * @author 
 */
/* 不区分大小写 */
String.prototype.startWithIgnoreCase = function(start){
	try{
		if (this.toLowerCase().indexOf(start.toLowerCase())==0){
			return true;
		}else{
			return false;
		}
	}catch(e){return false;}
}
/* 不区分大小写 */
String.prototype.endWithIgnoreCase = function(end){
	try{
		if (this.toLowerCase().lastIndexOf(end.toLowerCase())==(this.length-end.length)){
			return true;
		}else{
			return false;
		}
	}catch(e){return false;}
}

/* 不区分大小写 */
String.prototype.indexOfIgnoreCase = function(find){
	return this.toLowerCase().indexOf(find.toLowerCase());
}
/**
 * 参考jQuery的$.trim()
 * @return
 */
String.prototype.trim = function(){
	rtrim = /\S/.test("\xA0") ? (/^[\s\xA0]+|[\s\xA0]+$/g) : /^\s+|\s+$/g;
	return this.replace(rtrim, "");
}
/* 
 * @param m ab{0}de{1}g 
 * @param i "c","d"
 * @return abcdefg
 */
String.prototype.fill = function(){
	var args = arguments;
	return this.replace(/\{(\d+)\}/g, function(m,i){
		return args[i];
	});
}
/**
 *
 * @since 2014-05-22
 * @description 从字符串中截取指定字符串的最右，从右边开始查找(lastIndexOf)
 * 例如："abcdefg".right("bcd") 最终返回 "efg"
 */
String.prototype.right = function(find){
	if (this.lastIndexOf(find)==-1) return this;
	return this.substring(this.lastIndexOf(find)+find.length, this.length);
}

window._isWeixin = function(){
	var userAgent = window.navigator.userAgent.toLowerCase();
	var isWeixin = userAgent.match(/MicroMessenger/i)=='micromessenger';
	return isWeixin;
}