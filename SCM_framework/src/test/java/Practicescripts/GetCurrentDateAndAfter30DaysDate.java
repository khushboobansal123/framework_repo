package Practicescripts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetCurrentDateAndAfter30DaysDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateobj = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actdate=sim.format(dateobj);
		System.out.println(actdate);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String requireddate=sim.format(cal.getTime());
		System.out.println(requireddate);
		
		

	}

}
