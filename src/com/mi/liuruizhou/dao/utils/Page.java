package com.mi.liuruizhou.dao.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * 通用分页类
 * 泛型可以实现任何项目通用的类
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> {
	private int currentPage ;//当前页码，客户端传入，手工赋值
	private int totalPage;//总页数，10条，每页3条 = 4页
	private int count;//总记录条数，从数据库中得到
	private int pageSize;//每页显示的条数，客户端传入，手工赋值
	private String likesql;
	private String orderBy;
	private List<T> lists = new ArrayList<T>();//每页显示的记录详细信息，从数据库中得到
	
	public String getLikesql() {
		return likesql;
	}
	public void setLikesql(String likesql) {
		this.likesql = likesql;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Page() {
		super();
	}
	public Page(int currentPage,  int count, int pageSize,
			List<T> lists) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		this.pageSize = pageSize;
		this.lists = lists;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		//count/pageSize整除： count/pageSize 总页数，10条，每页3条 = 4页
		if (count%pageSize==0) {
			 totalPage =count/pageSize;
		}else {
			 totalPage = count/pageSize + 1;
		}
		return totalPage;
		
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	};
	
	
}
