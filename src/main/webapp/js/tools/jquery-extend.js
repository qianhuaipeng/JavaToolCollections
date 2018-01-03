(function ($) { //$.getUrlParam('param');
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

(function($){
	'use strict';
	$.userDefined = $.userDefined || {};
	$.extend($.userDefined, {
		version : '1.0.1',
		contextPath: '',
		method: function(){
		
		}
	});
})(jQuery);

