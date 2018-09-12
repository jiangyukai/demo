package com.zzj.util;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class DateUtils {
    /**
     * 转换日期，非英文
     */
    public static Date stringToDate(String sDate) throws ParseException
    {
   	 if(sDate == null)
   	 {
   		 return null;
   	 }    	       
        Date date = java.sql.Date.valueOf(sDate) ;
   	 return date;  	    	 	
    }
    /**
     * 转换日期，非英文
     */
    public static Timestamp stringToTimestamp(String sDate) throws ParseException
    {
   	 if(sDate == null)
   	 {
   		 return null;
   	 }    	       
   	Timestamp date = Timestamp.valueOf(sDate) ;
   	 return date;  	    	 	
    }
    /**
     * 
     * @名称 stringToTimestamp
     * @描述 string转换为Timestamp
     * @参数 @param sDate
     * @参数 @param temp 模板
     * @参数 @return
     * @参数 @throws ParseException
     * @返回值 Timestamp
     * @作者 hanlei
     * @时间 2017-4-17 上午10:25:33
     */
    public static Timestamp stringToTimestamp(String sDate,String temp) throws ParseException
    {
    	if(sDate == null)
    	{
    		return null;
    	}    	       
    	if(temp.isEmpty()){
    		temp = "yyyy-MM-dd HH:mm:ss";
    	}
		SimpleDateFormat format = new SimpleDateFormat(temp);
   	 	String str = format.format(java.sql.Date.valueOf(sDate));
    	Timestamp date = Timestamp.valueOf(str);
    	return date;  	    	 	
    }

    /**
     * 日期转字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString(Date date) 
    {
   	 String str="";
   	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	 str = format.format(date);
   	 return str;  	    	 	
    }
    /**
     * 日期转字符串 yyyy-MM-dd
     */
    public static String dateToString2(Date date) throws ParseException
    {
    	String str="";
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	str = format.format(date);
    	return str;  	    	 	
    }
    
    /**
     * 根据格式化字符串输出
    * @param  date               
    * @param  fmtString                
    * @return             
    * @Exception
     */
    public static String dateFmt(Date date,String fmtString)
    {
    	if(null==date) return "";
    	try{
	   	 String str="";
	   	 SimpleDateFormat format = new SimpleDateFormat(fmtString);
	   	 str = format.format(date);
	   	 return str;  	    	 	
    	}catch (Exception e) {
			return date.toString();
		}
    }
    
    
    /**
	 * 功能描述 转换字符型日期为Date型日期
	 * 
	 * @param strDate  
	 *            字符型日期
	 *            template  日期模版
	 * @return Date 
	 */
	public static Date strToDate(String strDate,String template) {
		SimpleDateFormat formatter = new SimpleDateFormat(template);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
    /**
     * 
    * @【方法名称】     dateToStringByTemplate
    * @【方法描述】     把一个日期转化为给定模版的字符串形式       
    * @【适用条件】              
    * @【执行流程】               
    * @【注意事项】       
    * @param          date Date型数据，  timeTemplate 日期模版  比如 "yyyy-MM-dd" "yyyy-M-d"      
    * @return             
    * @Exception
     */
    public static String dateToStringByTemplate(Date date,String timeTemplate) throws ParseException
    {
   	 String str="";
   	 SimpleDateFormat format = new SimpleDateFormat(timeTemplate);
   	 str = format.format(date);
   	 return str;  	    	 	
    }
    /**
     * 把数字带上千分位
     */

    public static String toString3num(Double num)
    {
   	 NumberFormat numfmt = NumberFormat.getInstance();
   	 String str=numfmt.format(num);
		return str;
   	 
    }
    //把2010-10-20T00:00:00格式的截取为2010-10-20
    public static String parseTimeMap(String time){
    	//2010-10-20
    	System.out.println(time.substring(0, 10));
    	time=time==null?"":time.substring(0, 10);
    	return time;
    }
    /**
     * 
    * @【方法名称】     dateUtil
    * @【方法描述】     第一个参数是开始的日期yyyy-MM-dd,第二个是开始日期推迟的天数,第三个是结束日期
    *        			第一个参数不添默认为1970-01-01,第二个默认1,第三个默认1970-01-01
    *        	
    * @【适用条件】     这个方法有两个用法：                
                       ①第三个参数为“”此方法返回的是当前日期推迟i天后的日期
	                   ②第三个参数为日期格式时此方法返回的是间隔天数         
    * @【执行流程】               
    * @【注意事项】       
    * @param                 
    * @return             
    * @Exception
     */
    public static String dateUtil(String dateStr,int i,String date) throws ParseException{
    	Date beforeDate = dateStr==null || dateStr.trim().equals("")?  stringToDate("1970-01-01")  : stringToDate(dateStr);
    	Date afterDate = date==null || date.trim().equals("")?  stringToDate("1970-01-01")  : stringToDate(date);
    	beforeDate = beforeDate==null ? stringToDate("1970-01-01") : beforeDate;
    	i = i <= 0 ? 1 : i ;
    	if(date!=null && !date.trim().equals("")){
    		 Calendar fromCalendar = Calendar.getInstance();   
    		 fromCalendar.setTime(beforeDate);   
    		 fromCalendar.set(Calendar.HOUR_OF_DAY, 0);   
    		 fromCalendar.set(Calendar.MINUTE, 0);   
    		 fromCalendar.set(Calendar.SECOND, 0);   
    		 fromCalendar.set(Calendar.MILLISECOND, 0);   

    		 Calendar toCalendar = Calendar.getInstance();   
    		 toCalendar.setTime(afterDate);   
    		 toCalendar.set(Calendar.HOUR_OF_DAY, 0);   
    		 toCalendar.set(Calendar.MINUTE, 0);   
    		 toCalendar.set(Calendar.SECOND, 0);   
    		 toCalendar.set(Calendar.MILLISECOND, 0);   
    		 return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24)+"";   

    	}
    	Long l1 = beforeDate.getTime();
    	Long l2 =(long) i*24*60*60*1000 ;
    	Long l = l1 + l2 ;
    	Date date2 = new Date(l);
    	
    	return dateToString2(date2);
    }
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	
	
	//日期转化为大写各式
	
	 // 日期转化为大小写
	public static String dataToUpper(Date date) {
	        Calendar ca = Calendar.getInstance();   
	        ca.setTime(date);   
	        int year = ca.get(Calendar.YEAR);   
	        int month = ca.get(Calendar.MONTH) + 1;   
	        int day = ca.get(Calendar.DAY_OF_MONTH);
	        return numToUpper(year) + "年" + monthToUppder(month) + "月" + dayToUppder(day) + "日";
	}
	 
	 // 将数字转化为大写
	 public static String numToUpper(int num) {
	        //String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	        String u[] = {"0","一","二","三","四","五","六","七","八","九"};
	        char[] str = String.valueOf(num).toCharArray();
	        String rstr = "";
	        for (int i = 0; i < str.length; i++) {
	                rstr = rstr + u[Integer.parseInt(str[i] + "")];
	         }
	        return rstr;
	 }
	 
	 // 月转化为大写
	 public static String monthToUppder(int month) {
	          if(month < 10) {
	                  return numToUpper(month);        
	          } else if(month == 10){
	                  return "十";
	          } else {
	                  return "十" + numToUpper(month - 10);
	          }
	 }
	 
	 // 日转化为大写
	 public static String dayToUppder(int day) {
	          if(day < 20) {
	                   return monthToUppder(day);
	          } else {
	                   char[] str = String.valueOf(day).toCharArray();
	                   if(str[1] == '0') {
	                            return numToUpper(Integer.parseInt(str[0] + "")) + "十";
	                   }else {
	                            return numToUpper(Integer.parseInt(str[0] + "")) + "十" + numToUpper(Integer.parseInt(str[1] + ""));
	                   }
	        }
	}
	//---------------------------------------- 
	 
	/**
	 * 得到一个日期前多少天的那天的日期
	 * 
	 * @param date
	 *            日期
	 * @param day 天数
	 * @return 返回相减后的日期
	 */
	public static Date diffDays(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}
//    public static void main(String[] args) throws ParseException {
//		System.out.println(dateUtil("2010-06-20",105,"2010-06-21"));
//		//打印60天前的那天的日期
//		System.out.println(dateToStringByTemplate(diffDays(new Date(),30),"yyyy年M月d日"));
//		System.out.println(dataToUpper(new Date()));
//	}
    /**
     * 
     * @名称 getNowTimestamp
     * @描述	获取当前时间的时间戳 yyyy-MM-dd HH:mm:ss:SSS
     * @参数 @return
     * @返回值 Timestamp
     * @作者 hanlei
     * @时间 2016-11-30 上午9:52:09
     */
	public static Timestamp getNowTimestamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return Timestamp.valueOf(str);
	}
    
	
    /**
	 * 
	 * @名称 getDate
	 * @描述 根据预设的格式获得日期---年月日
	 * @参数
	 * @param ptn
	 *            日期格式
	 * @参数
	 * @return 年月日
	 * @返回值 String
	 * @作者 wdfang
	 * @时间 2013-2-19 下午1:05:11
	 */
	public static String getDate(String ptn) {
		Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
		SimpleDateFormat format = new SimpleDateFormat(ptn);
		Date date = calendar.getTime();
		return format.format(date);
	}
	
	/**
	 * 
	 * @名称 getNextSpecialDate
	 * @描述 取得专场下一个交易日的时间
	 * @参数 @param str 星期一,星期二,星期三  逗号分隔 主要处理 tb_wsjj_specialProcess.tradeDate 字段
	 * @参数 @return
	 * @返回值 String
	 * @作者 hanlei
	 * @时间 2015-8-20 下午12:05:06
	 */
	public static String getNextSpecialDate(String str) {
		Date date=new Date();
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前星期几
        int nowWeekDay = cal.get(Calendar.DAY_OF_WEEK);
        //如果是1 表示星期日 换算
        if(nowWeekDay==1){
        	nowWeekDay = 7;
        }else{
        	nowWeekDay -= 1;
        }
        List<Integer> strList =  getWeekdayListInt(str.split(","));
        DateFormat format=new SimpleDateFormat("M月d日");
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(date); 
        //判断是否包含 该星期数
        if(strList.contains(nowWeekDay)){
			return time;
		}
        //下星期几
        int nextWeekDay = 0;
        //获取当前时间
		for (int i = 0; i < strList.size(); i++) {
			if(strList.get(i)>nowWeekDay){
				nextWeekDay = strList.get(i);
				break;
			}
		}
		//如果都不大于 nowWeekDay 取第一个
		if(nextWeekDay==0){
			nextWeekDay = strList.get(0);
		}
		//取下一个  （星期nextWeekDay）
		int cha = nextWeekDay - nowWeekDay;
		String now =  format2.format(new Date());
		try {
			if (cha > 0) {
				Date temp = format2.parse(dateUtil(now, cha,""));
				return format.format(temp);
			} else {
				cha = 7 + cha;
				Date temp = format2.parse(dateUtil(now, cha,""));
				return format.format(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "";
		
	}

	/**
	 * 
	 * @名称 getWeekdayListInt
	 * @描述 星期转换为整型
	 * @参数 @param weekStr
	 * @参数 @return
	 * @返回值 List<Integer>
	 * @作者 hanlei
	 * @时间 2015-8-20 下午1:06:36
	 */
	private static List<Integer> getWeekdayListInt(String[] weekStr) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < weekStr.length; i++) {
			if (weekStr[i].equals("星期一")) {
				temp.add(1);
			} else if (weekStr[i].equals("星期二")) {
				temp.add(2);
			} else if (weekStr[i].equals("星期三")) {
				temp.add(3);
			} else if (weekStr[i].equals("星期四")) {
				temp.add(4);
			} else if (weekStr[i].equals("星期五")) {
				temp.add(5);
			} else if (weekStr[i].equals("星期六")) {
				temp.add(6);
			} else {
				temp.add(7);
			}
		}
		return temp;
	}
	
	/**
	 * @名称 getWeekOfDate
	 * @描述 得到今天是星期几
	 * @参数 @param dt
	 * @参数 @return
	 * @返回值 String "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"
	 * @作者 xdpang
	 * @时间 2016年12月10日 下午5:36:23
	 */
	public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
	
	
	public static String getNextSpecialDate(String str,Date date) {
	
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前星期几
        int nowWeekDay = cal.get(Calendar.DAY_OF_WEEK);
        //如果是1 表示星期日 换算
        if(nowWeekDay==1){
        	nowWeekDay = 7;
        }else{
        	nowWeekDay -= 1;
        }
        List<Integer> strList =  getWeekdayListInt(str.split(","));
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(date); 
        //判断是否包含 该星期数
        if(strList.contains(nowWeekDay)){
			return time;
		}
        //下星期几
        int nextWeekDay = 0;
        //获取当前时间
		for (int i = 0; i < strList.size(); i++) {
			if(strList.get(i)>nowWeekDay){
				nextWeekDay = strList.get(i);
				break;
			}
		}
		//如果都不大于 nowWeekDay 取第一个
		if(nextWeekDay==0){
			nextWeekDay = strList.get(0);
		}
		//取下一个  （星期nextWeekDay）
		int cha = nextWeekDay - nowWeekDay;
		String now =  format2.format(date);
		try {
			if (cha > 0) {
				Date temp = format2.parse(dateUtil(now, cha,""));
				return format.format(temp);
			} else {
				cha = 7 + cha;
				Date temp = format2.parse(dateUtil(now, cha,""));
				return format.format(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "";
		
	}
	
}
