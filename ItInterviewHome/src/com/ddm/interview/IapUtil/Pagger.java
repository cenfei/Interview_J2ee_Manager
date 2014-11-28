package com.ddm.interview.IapUtil;



import java.util.ArrayList;
import java.util.List;

/**
 * 实现分页显示的页标
 */
public class Pagger
{
	private List<String> paggerList;// 当前页面的所有页标值
	private int maxPageIndexCount;// 页标总数最大值
	private int pageIndexCenterSize;// 页标过多时，中间显示的页标数
	private int pageSize;//页面的数据量

	public void setPageIndexCenterSize(int pageIndexCenterSize)
	{
		this.pageIndexCenterSize = pageIndexCenterSize;
	}

	public void setMaxPageIndexCount(int maxPageIndexCount)
	{
		this.maxPageIndexCount = maxPageIndexCount;
	}

	public List<String> getPaggerList(int pageIndex,int dataCount)
	{
		setPagger(pageIndex,dataCount);
		return paggerList;
	}
	
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	/**
	 * 获得当前页面的所有页标值
	 */
	private void setPagger(int pageIndex,int dataCount)
	{
		int pageCount = 0;
		if (dataCount%pageSize==0)//如果当前页面是页面数据量的整数倍
		{
			pageCount = dataCount/pageSize;
		}else {//否则，总页数等于
			pageCount = dataCount/pageSize+1;
		}
		if (pageCount <= maxPageIndexCount)// 如果页标总数少于规定的最大值
		{
			paggerList = minPageIndex(pageCount);
		} else
		{
			paggerList = maxPageIndex(pageIndex,pageCount);
		}
	}

	/**
	 * 页标总数少于规定的最大值
	 * 
	 * @param pageCount
	 *            页标总数
	 * @return 页标总数少于最大值时的页标值，页标形式为“1 2 3 4 5 6”
	 */
	private List<String> minPageIndex(int pageCount)
	{
		List<String> minPageList = new ArrayList<String>();
		for (int i = 1; i <= pageCount; i++)
		{
			minPageList.add(String.valueOf(i));
		}
		return minPageList;
	}

	/**
	 * 页标总数大于规定的最大值
	 * 
	 * @param pageCount
	 *            页标总数
	 * @return 页标总数大于最大值时的页标值
	 */
	private List<String> maxPageIndex(int pageIndex,int pageCount)
	{
		List<String> maxPageList = new ArrayList<String>();
		if (pageIndex < pageIndexCenterSize)// 当前页标小于中间页标数，即实现“1 2 3 4 5 ... 10”
		{
			for (int i = 1; i <= pageIndexCenterSize + 1; i++)
			{
				maxPageList.add(String.valueOf(i));
			}
			maxPageList.add("...");
			maxPageList.add(String.valueOf(pageCount));
		} else if (pageIndex >= pageIndexCenterSize
				&& pageIndex <= pageCount - pageIndexCenterSize +2)
		{// 当前页标大于页标总数，小于页标总数减去中间页标数，即实现“1 ... 4 5 6 7 8 ... 10”
			maxPageList.add("1");
			maxPageList.add("...");
			int max = pageIndexCenterSize / 2;
			for (int i = pageIndex - max; i <= pageIndex + max; i++)
			{
				maxPageList.add(String.valueOf(i));
			}
			if (pageIndex-pageIndexCenterSize/2 < pageCount - pageIndexCenterSize)//当页面出现“1 ... 6 7 8 9 10 11”时，没有后省略号
			{
				maxPageList.add("...");
			}
			maxPageList.add(String.valueOf(pageCount));
		} else
		// 当前页标大于页标总数减去中间页标数,即实现“1 ... 6 7 8 9 10”
		{
			maxPageList.add("1");
			maxPageList.add("...");
			for (int i = pageCount - pageIndexCenterSize+1; i <= pageCount; i++)
			{
				maxPageList.add(String.valueOf(i));
			}
		}
		return maxPageList;
	}

//	public static void main(String[] args)
//	{
//		Pagger pagger = new Pagger();
//		pagger.setPageCount(11);
//		pagger.setPageIndex(7);
//		pagger.setPageIndexCenterSize(5);
//		pagger.setMaxPageIndexCount(10);
//		List<String> paggerList = pagger.getPaggerList();
//		for (String s : paggerList)
//		{
//			System.out.print(s + " ");
//		}
//	}
}
