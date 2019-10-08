package com.wangxinyuan.service;

import java.util.List;

import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.dao.po.Goods;


public interface GouWuCheService {
	public List<Cart> listGouWuCheByUserId(int id);
	public Goods GouWuCheByGoodsId(int id);
	public boolean updateXiaoJiByGoodsId(int cartId,int xiaoji,int number);
	public boolean shanChuByCartId(int cartId);
}
