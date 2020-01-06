package cn.itcast.abhs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
		System.out.println(sdf.format(calendar.getTime()));
		calendar.add(Calendar.DATE, 1);
		System.out.println(sdf.format(calendar.getTime()));

	}
}