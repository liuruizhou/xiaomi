package com.wangxinyuan.dao.po;

public class Edition
{
	private int editionId;
	private String editionName;
	public Edition()
	{
		super();
	}
	public Edition(int editionId, String editionName)
	{
		super();
		this.editionId = editionId;
		this.editionName = editionName;
	}
	public int getEditionId()
	{
		return editionId;
	}
	public void setEditionId(int editionId)
	{
		this.editionId = editionId;
	}
	public String getEditionName()
	{
		return editionName;
	}
	public void setEditionName(String editionName)
	{
		this.editionName = editionName;
	}
	@Override
	public String toString()
	{
		return "Edition [editionId=" + editionId + ", editionName=" + editionName + "]";
	}
}
