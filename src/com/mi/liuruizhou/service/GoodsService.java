package com.mi.liuruizhou.service;

import java.util.List;

import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;

public interface GoodsService {
	/**
	 * ��������id����Ʒ��Ϣ
	 * @return List<Goods>��Ʒ��Ϣ����
	 */
	public List<Goods> getGoodsByTypeId(int typeId);
	/**
	 * ��ȡ��ҳ��Ϣ
	 * @param currentPage��ǰҳ��
	 * @param pageSizeһҳ��������¼
	 * @return
	 * @throws Exception
	 */
	public Page<Goods> getPage(int currentPage, int pageSize,String likesql,String orderBy) throws Exception;
	/**
	 * ��ȡ���е���Ʒ�������ظ���
	 * @return
	 */
	public List<String> getGoodsNameList(String term);
}
