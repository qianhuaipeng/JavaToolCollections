package com.util.html.htmlparser;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

/**
 * 解析HTML里面内容，修改和替换某个属性
 * @author alan
 *
 * 2017-3-30 上午11:47:10
 */
public class Htmlparser {
	public static void main(String[] args) {
	try {
		Parser parser = new Parser("http://cluster.xiaoi.com/robot/app/jdswyfw/p4data/99338e74b2664448bd4878456c15a4e5");
		parser.setEncoding("utf-8");
		NodeFilter frameFilter = new NodeFilter() {
            public boolean accept(Node node) {
                if (node.getText().startsWith("img src=")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        
		NodeList list = parser.parse (new TagNameFilter("body"));
		Node body = list.elementAt(0); 
	    body.accept(new NodeVisitor() {
	    	String src = "";
	    	
	        public void visitTag(Tag tag) { 
	            if (tag.getClass() != ImageTag.class) 
	            	return; 
	            // replace attribute here,i ignore the code 
	            System.out.println(tag.getAttribute("src"));
	            src = "http://cluster.xiaoi.com/robot/app/jdswyfw/p4data" +  tag.getAttribute("src").replace("..", "");;
	            tag.setAttribute("src", src);
	        } 
	    }); 
	   // System.out.println(body.toHtml());
		Node node = list.elementAt (0);
		NodeList sublist = node.getChildren ();
		//System.out.println (sublist.asString());

	} catch (ParserException e) {
		e.printStackTrace();
	}
}
}
