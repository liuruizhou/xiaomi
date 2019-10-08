package com.wangxinyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangxinyuan.dao.CartDao;
import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.dao.utils.JdbcUtil;

public class CartDaoImpl implements CartDao {
	Connection conn = JdbcUtil.getConnection();
	@Override
	public List<Cart> listAllByUserId(int id) {
		List<Cart> lists=new ArrayList<Cart>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM cart where user_id=?";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart carts = new Cart();
				carts.setId(rs.getInt("id"));
				carts.setGoodsId(rs.getInt("goods_id"));
				carts.setUserId(rs.getInt("user_id"));
				carts.setNumber(rs.getString("number"));
				carts.setSubtotal(rs.getString("subtoatl"));
				lists.add(carts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return lists;
	}

	@Override
	public boolean setXiaoJiByCartId(int cartId, int xiaoJi,int shuliang) {
		boolean flag=false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int number=0;
		String sql = "update cart set subtoatl=?,number=? where id=?";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, xiaoJi);
			ps.setInt(2, shuliang);
			ps.setInt(3, cartId);
			number = ps.executeUpdate();
			if(number>0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public boolean shanChuByCartId(int cartId) {
		boolean flag=false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int number=0;
		String sql = "delete from cart where id=?";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			number = ps.executeUpdate();
			if(number>0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public void saveCart(Cart cart) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "insert into cart(id,goods_id,user_id,number,subtoatl) values(null,?,?,1,?)";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, cart.getGoodsId());
			ps.setInt(2, cart.getUserId());
			ps.setString(3, cart.getSubtotal());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		
	}

}
