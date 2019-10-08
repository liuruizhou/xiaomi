package com.mi.liuruizhou.dao.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * ͨ�÷�ҳ��
 * ���Ϳ���ʵ���κ���Ŀͨ�õ���
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> {
	private int currentPage ;//��ǰҳ�룬�ͻ��˴��룬�ֹ���ֵ
	private int totalPage;//��ҳ����10����ÿҳ3�� = 4ҳ
	private int count;//�ܼ�¼�����������ݿ��еõ�
	private int pageSize;//ÿҳ��ʾ���������ͻ��˴��룬�ֹ���ֵ
	private String likesql;
	private String orderBy;
	private List<T> lists = new ArrayList<T>();//ÿҳ��ʾ�ļ�¼��ϸ��Ϣ�������ݿ��еõ�
	
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
		//count/pageSize������ count/pageSize ��ҳ����10����ÿҳ3�� = 4ҳ
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
