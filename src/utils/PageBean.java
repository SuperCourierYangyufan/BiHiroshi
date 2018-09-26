package utils;

import java.util.List;

import domain.Dynamic;

public class PageBean {
	//当前页
	private Integer currentPage;
	//总页
	private Integer countPage;
	//每页条数
	private Integer currentRecord;
	//总条数
	private Integer countRecord;
	//每页信息
	private List<Dynamic> listDynamic;
	
	
	
	
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	public Integer getCurrentRecord() {
		return currentRecord;
	}
	public void setCurrentRecord(Integer currentRecord) {
		this.currentRecord = currentRecord;
	}
	public Integer getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}
	public List<Dynamic> getListDynamic() {
		return listDynamic;
	}
	public void setListDynamic(List<Dynamic> listDynamic) {
		this.listDynamic = listDynamic;
	}
	
	
	
	
	
}
