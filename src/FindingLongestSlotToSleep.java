
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingLongestSlotToSleep {
	public static void main(String[] args) {
		new FindingLongestSlotToSleep();
	}
	
	public FindingLongestSlotToSleep() {
		String[] dataArr = getData();
		Map<Integer, List<String>> dataMapping = gatherData(dataArr);
		System.out.println(dataMapping);
		findFreeSlot(dataMapping);
		
	}
	
	private void findFreeSlot(Map<Integer, List<String>> dataMapping) {
		Calendar startFreeCal = Calendar.getInstance();
		Calendar endFreeCal = Calendar.getInstance();
		int fixYear = 2000;
		int fixMonth = 1;
		int fixDate = 1;
		Map<Integer, List<Long>> result = new HashMap<Integer, List<Long>>();
		for (Integer key : dataMapping.keySet()) {
			List<String> meetingList = dataMapping.get(key);
			List<Integer> resultList = new ArrayList<Integer>();
			startFreeCal.set(fixYear, fixMonth, fixDate, 0, 0);
			for (String meetingPeriod : meetingList) {
				String start = meetingPeriod.split("-")[0];
				int startMin = Integer.parseInt(start.split(":")[0]);
				int startSec = Integer.parseInt(start.split(":")[1]);
				String end = meetingPeriod.split("-")[1];
				int endMin = Integer.parseInt(end.split(":")[0]);
				int endSec = Integer.parseInt(end.split(":")[1]);
				endFreeCal.set(fixYear, fixMonth, fixDate, startMin, startSec);
				int minDiff = (int) ((endFreeCal.getTimeInMillis() - startFreeCal.getTimeInMillis()) / 60000);
				resultList.add(minDiff);
				startFreeCal.set(fixYear, fixMonth, fixDate, endMin, endSec);
			}
			
			break;
		}		
	}
	
	private Map<Integer, List<String>> gatherData(String[] dataArr) {
		Map<Integer, List<String>> dataMapping = new HashMap<Integer, List<String>>();
		String del = " ";
		for (int i=0; i<dataArr.length; i++) {
			String data = dataArr[i];
			int delIndex = data.indexOf(del);
			String dateStr = data.substring(0, delIndex);
			int key = DateIndex(dateStr);
			String periodOfTime = data.substring(delIndex + del.length(), data.length());
			if (!dataMapping.containsKey(key)) {
				List<String> timeList = new ArrayList<String>();
				timeList.add(periodOfTime);
				dataMapping.put(key, timeList);
			}
			else {
				List<String> timeList = dataMapping.get(key);
				timeList.add(periodOfTime);
				dataMapping.put(key, timeList);
			}
		}
		
		for (Integer key : dataMapping.keySet()) {
			List<String> list = dataMapping.get(key);
			Collections.sort(list);
		}
		
		return dataMapping;
	}
	
	private int DateIndex(String date) {
		if (date.equals("Mon")) {
			return 1;
		}
		else if (date.equals("Tue")) {
			return 2;
		}
		else if (date.equals("Wed")) {
			return 3;
		}
		else if (date.equals("Thu")) {
			return 4;
		}
		else if (date.equals("Fri")) {
			return 5;
		}
		else if (date.equals("Sat")) {
			return 6;
		}
		else if (date.equals("Sun")) {
			return 7;
		}
		
		return 0;
	}
	
	private String[] getData() {
		String del = "\n";
		String value = "Sun 10:00-20:00\n"
				+ "Fri 05:00-10:00\n"
				+ "Fri 16:30-23:50\n"
				+ "Sat 10:00-24:00\n"
				+ "Sun 01:00-04:00\n"
				+ "Sat 02:00-06:00\n"
				+ "Tue 03:30-18:15\n"
				+ "Tue 19:00-20:00\n"
				+ "Wed 04:25-15:14\n"
				+ "Wed 15:14-22:40\n"
				+ "Thu 00:00-23:59\n"
				+ "Mon 05:00-13:00\n"
				+ "Mon 15:00-21:00";
		return value.split(del);
	}
}
