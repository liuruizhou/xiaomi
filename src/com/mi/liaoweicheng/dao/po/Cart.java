package com.mi.liaoweicheng.dao.po;

public class Cart
{
	private int id;
	private int goodsId;
	private int userId;
	private int number;
	private String subtotal;
	public Cart()
	{
		super();
	}
	public Cart(int id, int goodsId, int userId, int number, String subtotal)
	{
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.number = number;
		this.subtotal = subtotal;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getSubtotal()
	{
		return subtotal;
	}
	public void setSubtotal(String subtotal)
	{
		this.subtotal = subtotal;
	}
	@Override
	public String toString()
	{
		return "Cart [id=" + id + ", goodsId=" + goodsId + ", userId=" + userId + ", number=" + number + ", subtotal="
				+ subtotal + "]";
	}
}
