package com.oil.framework.common.page;

import java.io.Serializable;

/**
 * 分页数据封装类
 * 
 * @Version: 1.0
 * @ProjectName:aikxian-framework-common
 * @Filename: SimplePage.java
 * @PackageName: com.aikxian.framework.common.page
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午12:18:17
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class SimplePage extends DataTablePage implements Serializable {

  /**
   * Comment for <code>serialVersionUID</code>
   */
  private static final long serialVersionUID = -1083390664693258231L;
  /**
   * 分页查询的行数
   */
  protected int             pageSize         = 20;
  /**
   * 分页查询的起始行数
   */
  protected int             startIndex       = 0;

  /**
   * 绘制次数
   */
  protected int             draw             = 1;

  /**
   * 记录总数
   */
  protected int             recordsTotal     = 0;

  /**
   * 筛选过滤总数
   */
  protected int             recordsFiltered  = 0;

  /**
   * 取得分页数
   */
  protected int             pageNumber       = 0;

  /**
   * 取得分页总数
   */
  protected int             pageTotalNum     = 0;
  
  protected Long coinTotal=0l;

  /**
   * @return pageNumber
   */
  public int getPageNumber() {
    return pageNumber;
  }

  /**
   * @param pageNumber
   */
  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  /**
   * 
   */
  public SimplePage() {
    super();
  }

  /**
   * @param pageSize
   * @param startIndex
   * @param draw
   * @param recordsTotal
   */
  public SimplePage(int pageSize,
                    int startIndex,
                    int draw,
                    int recordsTotal) {
    super();
    this.pageSize = pageSize;
    if (startIndex < 0)
      this.startIndex = 0;
    else
      this.startIndex = startIndex;
    this.draw = draw;
  }

  /**
   * @return pageSize
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * @param pageSize
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * @return startIndex
   */
  public int getStartIndex() {
    return startIndex;
  }

  /**
   * @param startIndex
   */
  public void setStartIndex(int startIndex) {
    if (startIndex < 0)
      this.startIndex = 0;
    else
      this.startIndex = startIndex;
  }

  /**
   * @return draw
   */
  public int getDraw() {
    return draw;
  }

  /**
   * @param draw
   */
  public void setDraw(int draw) {
    this.draw = draw;
  }

  /**
   * @return recordsTotal
   */
  public int getRecordsTotal() {
    return recordsTotal;
  }

  /**
   * @param recordsTotal
   */
  public void setRecordsTotal(int recordsTotal) {
    this.recordsTotal = recordsTotal;
    this.setRecordsFiltered(recordsTotal);
  }

  /**
   * @return recordsFiltered
   */
  public int getRecordsFiltered() {
    return recordsFiltered;
  }

  /**
   * @param recordsFiltered
   */
  public void setRecordsFiltered(int recordsFiltered) {
    this.recordsFiltered = recordsFiltered;
  }

  /**
   * @return pageTotalNum
   */
  public int getPageTotalNum() {
    return pageTotalNum;
  }

  /**
 * @return Returns the coinTotal
 */
public Long getCoinTotal() {
    return coinTotal;
}

/**
 * @param coinTotal
 * The coinTotal to set.
 */
public void setCoinTotal(Long coinTotal) {
    this.coinTotal = coinTotal;
}

/**
   * @param pageTotalNum
   */
  public void setPageTotalNum(int pageTotalNum) {
    this.pageTotalNum = pageTotalNum;
  }

  @Override
  public void setStart(int start) {
    this.setStartIndex(start);
    super.setStart(start);
  }

  @Override
  public void setLength(int length) {
    this.setPageSize(length);
    super.setLength(length);
  }
}
