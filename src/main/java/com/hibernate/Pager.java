/*
 * Power by www.xiaoi.com
 */
package com.hibernate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Sep 13, 2015 8:27:05 AM
 * @version 1.0
 */
public class Pager<T> {

	private List<T> datas = new ArrayList<T>();
	private int offset = 0; // 起始条目
	private int size = 10; // 每页显示条目数
	private int total = 0; // 总条目数

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// //////////////////////////////////////////

	private int curpage; // 当前页
	private int prepage; // 上一页
	private int nextpage; // 下一页
	private int totalpage; // 总页数
	
	public int getCurpage() {
		if (this.curpage > this.getTotalpage()) {
			this.curpage = this.getTotalpage();
		}
		if (this.curpage <= 1) {
			this.curpage = 1;
		}
		return curpage;
	}
	
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPrepage() {
		this.prepage = this.curpage - 1;
		if (this.prepage < 1) {
			this.prepage = 1;
		}
		return prepage;
	}

	public int getNextpage() {
		if(this.curpage == this.getTotalpage()){
			this.nextpage = this.getTotalpage();
		}else{
			this.nextpage = this.curpage + 1;
		}
		
		return nextpage;
	}

	

	public int getTotalpage() {
		if (this.total == 0) {
			totalpage = 1;
		} else {
			if (this.total % this.size == 0) {
				totalpage = this.total / this.size;
			} else {
				totalpage = this.total / this.size + 1;
			}
		}
		
		return totalpage;
	}
	
	private int[] midpage;//分页条上一页下一页中间的部分

	public int[] getMidpage() {
		int num = 5;//容器总量
		int curpagebefore = 3;//当前页前面固定条数
		int[] pv = new int[num];
		
		int min = 1;
		int max = 1;
		
		if(this.curpage - curpagebefore < 1){
			max = this.getTotalpage() < num ? this.getTotalpage() : num;
			for(int i = 0; i < max; i++){
				pv[i] = i+1;
			}
		}else{
			
			if(this.curpage + (num - curpagebefore) > this.getTotalpage()){
				max = this.getTotalpage();
				min = this.getTotalpage() - num + 1;
			}else{
				min = this.curpage - curpagebefore+1;
				max = this.curpage - curpagebefore + num;
			}
			
			for(int i = 0; i < num; i++){
				if(min > max){
					break;
				}
				pv[i] = min++;
			}
			
		}
		
		this.midpage = pv;
		return midpage;
	}
	

}