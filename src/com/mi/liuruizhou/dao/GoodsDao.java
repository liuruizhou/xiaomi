package com.mi.liuruizhou.dao;

import java.util.List;

import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;

public interface GoodsDao {
	/**
	 * ��������id����Ʒ��Ϣ
	 * @return List<Goods>��Ʒ��Ϣ����
	 */
	public List<Goods> getGoodsByTypeId(int typeId);
	/**
	 * ��ȡ�ܼ�¼��
	 */
	public int getTotalCount(String like);
	/**
	 * ��ȡҳ���ȫ����Ϣ
	 */
	public List<Goods> getOnePageInfo(int currentPage,int pageSize,String likesql,String orderBy);
	/**
	 * ��װ��ǰҳ���ȫ����Ϣ��pageBean
	 * @param currentPage��ǰҳ��
	 * @param pageSizeһҹ������
	 */
	public Page<Goods> getPage(int currentPage,int pageSize,String likesql,String orderBy);
	/**
	 * ��ȡ���е���Ʒ�������ظ���
	 * @return
	 */
	public List<String> getGoodsNameList(String term);
}
