package com.wangxinyuan.dao;

import java.util.List;

import com.wangxinyuan.dao.po.Cart;

public interface CartDao {
	public List<Cart> listAllByUserId(int id);
	public void saveCart(Cart cart);
	public boolean setXiaoJiByCartId(int cartId,int xiaoJi,int shuliang);
	public boolean shanChuByCartId(int cartId);
}
