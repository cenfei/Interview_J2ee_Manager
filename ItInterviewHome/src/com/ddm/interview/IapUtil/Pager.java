
package com.ddm.interview.IapUtil;

public class Pager implements java.io.Serializable {

	/**
	 * @author Administrator
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1060125092198748183L;

	private String offset;

	private String pageSize;

	public String getOffset() {

		return offset;
	}

	public void setOffset(String offset) {

		this.offset = offset;
	}

	public String getPageSize() {

		return pageSize;
	}

	public void setPageSize(String pageSize) {

		this.pageSize = pageSize;
	}

	public int getFirstindex() {

		offset = offset == null ? "0" : offset;
		return Integer.parseInt(offset);
	}

	public int getMaxresult() {

		pageSize = pageSize == null ? "10" : pageSize;
		return Integer.parseInt(pageSize);
	}

}
