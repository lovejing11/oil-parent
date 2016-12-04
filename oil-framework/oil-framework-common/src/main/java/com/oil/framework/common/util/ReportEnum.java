package com.oil.framework.common.util;

/**
 * 枚举
 * @Version: TODO
 * @ProjectName:com.aikxian.framework.common.uitl
 * @Filename:  ReportEnum.java
 * @PackageName: com.aikxian.av.web.admin.controller
 * @Author: 蔡相伟
 * @Email: caixiangwei@aikxian.com
 * @Date:2016年7月20日下午2:19:50
 */
public interface ReportEnum {

	/**
	 * 房间状态枚举
	 * @Version: TODO 房间状态 enum:test,测试;living,直播;wait,等待;pause,暂停;over,结束;
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月20日下午2:19:46
	 */
	public enum RoomState implements ReportEnum {
		 TEST("测试","TEST"),
		 LIVING("<p style=\"font-weight:bold;color:red\">正在直播中...</p>","LIVING"),
		 WAIT("等待","WAIT"),
		 PAUSE("暂停","PAUSE"),
		 OVER("<p style=\"font-weight:bold;\">已结束</p>","OVER");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String status; 
 
	    private RoomState(String Tname, String status) {  
	        this.Tname = Tname;  
	        this.status = status;  
	    }   
	   // 获取值
	    public static String getName(String Aname) {  
	        for (RoomState r : RoomState.values()) {  
	        	System.out.println(r.getTname());
	            if (r.getStatus().equals(Aname)) {  
	                return r.getTname(); 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	}
	
	
	/**
	 * 充值方式
	 * @Version: TODO '充值方式:enum:alipay,支付宝;weixinpay,微信支付;weixinnativepay,微信公众号支付;applepay,苹果支付;applepurchase,苹果内购;admin,运营系统充值;',
	 * @ProjectName:com.aikxian.framework.common.uitl'充值方式:enum:alipay,支付宝;weixinpay,微信支付;weixinnativepay,微信公众号支付;applepay,苹果支付;applepurchase,苹果内购;admin,运营系统充值;
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月22日下午2:30:23
	 */
	public enum payMode implements ReportEnum {
		 ALIPAY("支付宝","ALIPAY"),
		 WEIXINPAY("微信支付","WEIXINPAY"),
		 WEIXINNATIVEPAY("微信公众号支付","WEIXINNATIVEPAY"),
		 APPLEPAY("苹果支付","APPLEPAY"),
		 APPLEPURCHASE("苹果内购","APPLEPURCHASE"),
		 ADMIN("运营系统充值","ADMIN");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String Ename; 
 
	    private payMode(String Tname, String Ename) {  
	        this.Tname = Tname;  
	        this.Ename = Ename;  
	    }   
	   // 获取值
	    public static String getName(String Ename) {  
	        for (payMode m : payMode.values()) {  
	            if (m.getEname().equals(Ename)) {  
	                return m.Tname; 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
		
	}
	
	/**
	 * 充值方式  带颜色
	 * @Version: TODO '充值方式:enum:alipay,支付宝;weixinpay,微信支付;weixinnativepay,微信公众号支付;applepay,苹果支付;applepurchase,苹果内购;admin,运营系统充值;',
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月28日下午3:55:38
	 */
	public enum payModeColor implements ReportEnum {
		 ALIPAY("<p style=\"font-weight:bold;color:#3c8dbc\">支付宝</p>","ALIPAY"),
		 WEIXINPAY("<p style=\"font-weight:bold;color:#00a65a\">微信支付</p>","WEIXINPAY"),
		 WEIXINNATIVEPAY("<p style=\"font-weight:bold;color:#00a65a\">微信公众号支付</p>","WEIXINNATIVEPAY"),
		 APPLEPAY("<p style=\"font-weight:bold;color:#dd4b39\">苹果支付</p>","APPLEPAY"),
		 APPLEPURCHASE("<p style=\"font-weight:bold;color:#00c0ef\">苹果内购</p>","APPLEPURCHASE"),
		 ADMIN("<p style=\"font-weight:bold;color:#605ca8\">运营系统充值</p>","ADMIN");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String Ename; 

	    private payModeColor(String Tname, String Ename) {  
	        this.Tname = Tname;  
	        this.Ename = Ename;  
	    }   
	   // 获取值
	    public static String getName(String Ename) {  
	        for (payModeColor m : payModeColor.values()) {  
	            if (m.getEname().equals(Ename)) {  
	                return m.Tname; 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
		
	}
	
	/**
	 * 终端类型 ANDROID IOS
	 * @Version: TODO 
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月22日下午6:14:31
	 */
	public enum terminalType implements ReportEnum {
		 IOS("苹果设备","IOS"),
		 ANDROID("安卓设备","ANDROID"),
		 ANDROID2("安卓设备","android");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String Ename; 

	    private terminalType(String Tname, String Ename) {  
	        this.Tname = Tname;  
	        this.Ename = Ename;  
	    }   
	   // 获取值
	    public static String getName(String Ename) {  
	        for (terminalType m : terminalType.values()) {  
	            if (m.getEname().equals(Ename)) {  
	                return m.Tname; 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
		
	}
	
	/**
	 * 终端类型 ANDROID IOS
	 * @Version: TODO 
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月22日下午6:14:31
	 */
	public enum terminalTypeColor implements ReportEnum {
		 IOS("<p style=\"font-weight:bold;color:#dd4b39\">苹果设备</p>","IOS"),
		 ANDROID("<p style=\"font-weight:bold;color:#00a65a\">安卓设备</p>","ANDROID"),
		 ANDROID2("<p style=\"font-weight:bold;color:#00a65a\">安卓设备</p>","android");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String Ename; 

	    private terminalTypeColor(String Tname, String Ename) {  
	        this.Tname = Tname;  
	        this.Ename = Ename;  
	    }   
	   // 获取值
	    public static String getName(String Ename) {  
	        for (terminalTypeColor m : terminalTypeColor.values()) {  
	            if (m.getEname().equals(Ename)) {  
	                return m.Tname; 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
		
	}
	/**
	 * 充值状态
	 * 充值状态:enum:success,成功;fail,失败;waitting,等待返回;nopay,未支付;
	 * @Version: TODO
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月28日上午10:55:24
	 */
	public enum payStatus implements ReportEnum {
		 SUCCESS("<p style=\"font-weight:bold;color:#00a65a\">充值成功</p>","SUCCESS"),
		 FAIL("<p style=\"font-weight:bold;color:#000\">充值失败</p>","FAIL"),
		 NOPAY("<p style=\"font-weight:bold;color:#ff851b\">等待返回</p>","NOPAY"),
		 WAITTING("<p style=\"font-weight:bold;color:#dd4b39\">未支付</p>","WAITTING");
		// 返回状态  
	    private String Tname;  
	    //获取到的状态
	    private String Ename; 

	    private payStatus(String Tname, String Ename) {  
	        this.Tname = Tname;  
	        this.Ename = Ename;  
	    }   
	   // 获取值
	    public static String getName(String Ename) {  
	        for (payStatus m : payStatus.values()) {  
	            if (m.getEname().equals(Ename)) {  
	                return m.Tname; 
	            }  
	        }  
	        return null;  
	    }
		public String getTname() {
			return Tname;
		}
		public void setTname(String tname) {
			Tname = tname;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
	}
	
	
	/**
	 * 充值方式
	 * @Version: TODO
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月28日下午1:33:02
	 */
	public enum FinancePayModeEnum implements ReportEnum{
	    APPLEPURCHASE("苹果内购"),
	    ALIPAY("支付宝"),
	    WEIXINPAY("微信支付"),
	    ADMIN("运营系统充值"),
	    WEIXINNATIVEPAY("微信公众号支付"),
	    APPLEPAY("苹果支付");
	 	private String label;
	 	private FinancePayModeEnum(String label){
	 		this.label = label;
	 	}
	 	public static String getName(String label) {
	        for (FinancePayModeEnum c : FinancePayModeEnum.values()) {
	            if (c.label.equals(label)) {
	                return c.name();
	            }
	        }
	        return null;
	    }

	    // 覆盖方法
	    @Override
	    public String toString() {
	       return this.label;
	    }  
	 
	    public String getLabel() {
	        return this.label;
	    }
	    public void setLabel(String label) {
	          this.label=label;
	    }
	}
	
	/**
	 * 充值状态
	 * @Version: TODO
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月28日下午1:37:38
	 */
	public enum FinancePayStateEnum implements ReportEnum{
	    SUCCESS("成功"),
	    WAITTING("等待返回"),
	    NOPAY("未支付"),
	    FAIL("失败");
	 	private String label;
	 	private FinancePayStateEnum(String label){
	 		this.label = label;
	 	}
	 	
	 	public static String getName(String label) {
	        for (FinancePayStateEnum c : FinancePayStateEnum.values()) {
	            if (c.label.equals(label)) {
	                return c.name();
	            }
	        }
	        return null;
	    }

	    // 覆盖方法
	    @Override
	    public String toString() {
	       return this.label;
	    }  
	 
	    public String getLabel() {
	        return this.label;
	    }
	    public void setLabel(String label) {
	          this.label=label;
	    }
	}
	

	/**
	 * 充值设备
	 * @Version: TODO
	 * @ProjectName:com.aikxian.framework.common.uitl
	 * @Filename:  ReportEnum.java
	 * @PackageName: com.aikxian.av.web.admin.controller
	 * @Author: 蔡相伟
	 * @Email: caixiangwei@aikxian.com
	 * @Date:2016年7月28日下午1:37:38
	 */
	public enum FinancePayDeviceEnum implements ReportEnum{
		ANDROID("安卓设备"),
		IOS("苹果设备");
	 	private String label;
	 	private FinancePayDeviceEnum(String label){
	 		this.label = label;
	 	}
	 	public static String getName(String label) {
	        for (FinancePayDeviceEnum c : FinancePayDeviceEnum.values()) {
	            if (c.label.equals(label)) {
	                return c.name();
	            }
	        }
	        return null;
	    }

	    // 覆盖方法
	    @Override
	    public String toString() {
	       return this.label;
	    }  
	 
	    public String getLabel() {
	        return this.label;
	    }
	    public void setLabel(String label) {
	          this.label=label;
	    }
	}
	
	public enum LiveCountEnum implements ReportEnum{
	    COIN("K币数量"), GIFT("礼物统计"), VIEW("观看次数"), ASK("提问数量"), ASKMEMBER("提问人数"), ONLINE("在线人数"), VIEWMEMBER("观看人数"), CHAT("聊天统计"), ASSISTANT("助理人数"), MAKONLINE("最高在线人数"), ASKSURPLUS("剩余问题统计"), KBAO("K宝统计");
	    private String label;

	    private LiveCountEnum(String label) {
	        this.label = label;
	    }

	    public static String getName(String label) {
	        for (LiveCountEnum c : LiveCountEnum.values()) {
	            if (c.label.equals(label)) {
	                return c.name();
	            }
	        }
	        return null;
	    }

	    // 覆盖方法
	    @Override
	    public String toString() {
	        return this.label;
	    }

	    public String getLabel() {
	        return this.label;
	    }

	    public void setLabel(String label) {
	        this.label = label;
	    }
	}	
	
}
