package com.oil.framework.common.page;

/**
 * DataTables 分页属性
 * 
 * @Version: 1.0
 * @Author: hejunsong 何俊松
 * @Email: hjsactivity@gmail.com
 * @Date: 2016年7月6日
 */
public class DataTablePage {
  /** 绘制次数 */
  protected int draw   = 1;
  /** 起始记录index */
  protected int start  = 0;
  /** 每页记录数 */
  protected int length = 10;

  /**
   * 绘制次数
   * 
   * @return
   */
  public int getDraw() {
    return draw;
  }

  /**
   * 绘制次数
   * 
   * @param draw
   */
  public void setDraw(int draw) {
    this.draw = draw;
  }

  /**
   * 起始记录index
   * 
   * @return
   */
  public int getStart() {
    return start;
  }

  /**
   * 起始记录index
   * 
   * @param start
   */
  public void setStart(int start) {
    this.start = start;
  }

  /**
   * 每页记录数
   * 
   * @return
   */
  public int getLength() {
    return length;
  }

  /**
   * 每页记录数
   * 
   * @param length
   */
  public void setLength(int length) {
    this.length = length;
  }
}
