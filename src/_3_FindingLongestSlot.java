
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3_FindingLongestSlot {
	public static void main(String[] args) {
		new _3_FindingLongestSlot();
	}
	
	public _3_FindingLongestSlot() {
		String data = getData();
		System.out.println(solution(data));
		
	}

	public int solution(String A) {
		if (A == null || A.isEmpty()) return 7*24*60;
		
		String[] dataArr = A.split("\n");
		Map<Integer, List<String>> dataMapping = gatherData(dataArr);
		List<Integer> result = findFreeSlot(dataMapping);
		// Manual Checking
		System.out.println(dataMapping);
		System.out.println(result);
		return findMaxSlot(result);
	}

	private int findMaxSlot(List<Integer> timeSlotList) {
		int max = 0;
		for (Integer key : timeSlotList) {
			max = Integer.max(max, key);
		}
		
		return max;
	}
	
	private List<Integer> findFreeSlot(Map<Integer, List<String>> dataMapping) {
		int fixYear = 2000;
		int fixMonth = 1;
		int fixDate = 1;
		Calendar startFreeCal = Calendar.getInstance();
		Calendar endFreeCal = Calendar.getInstance();
		startFreeCal.set(fixYear, fixMonth, fixDate, 0, 0);
		endFreeCal.set(fixYear, fixMonth, fixDate, 0, 0);
		List<Integer> resultList = new ArrayList<Integer>();
		for (Integer key : dataMapping.keySet()) {
			List<String> meetingList = dataMapping.get(key);
			for (String meetingPeriod : meetingList) {
				String start = meetingPeriod.split("-")[0];
				int startMin = Integer.parseInt(start.split(":")[0]);
				int startSec = Integer.parseInt(start.split(":")[1]);
				String end = meetingPeriod.split("-")[1];
				int endMin = Integer.parseInt(end.split(":")[0]);
				int endSec = Integer.parseInt(end.split(":")[1]);
				endFreeCal.set(fixYear, fixMonth, key, startMin, startSec);
				int minDiff = (int) ((endFreeCal.getTimeInMillis() - startFreeCal.getTimeInMillis()) / 60000);
				resultList.add(minDiff);
				startFreeCal.set(fixYear, fixMonth, key, endMin, endSec);
			}
		}
		
		return resultList;
	}
	
	private Map<Integer, List<String>> gatherData(String[] dataArr) {
		Map<Integer, List<String>> dataMapping = new HashMap<Integer, List<String>>();
		String del = " ";
		for (int i=0; i<dataArr.length; i++) {
			String data = dataArr[i];
			int delIndex = data.indexOf(del);
			String dateStr = data.substring(0, delIndex);
			int key = getDateIndex(dateStr);
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
	
	private int getDateIndex(String date) {
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
	
	private String getData() {
//		String value = "Sun 10:00-20:00\n"
//				+ "Fri 05:00-10:00\n"
//				+ "Fri 16:30-23:50\n"
//				+ "Sat 10:00-24:00\n"
//				+ "Sun 01:00-04:00\n"
//				+ "Sat 02:00-06:00\n"
//				+ "Tue 03:30-18:15\n"
//				+ "Tue 19:00-20:00\n"
//				+ "Wed 04:25-15:14\n"
//				+ "Wed 15:14-22:40\n"
//				+ "Thu 00:00-23:59\n"
//				+ "Mon 05:00-13:00\n"
//				+ "Mon 15:00-21:00";

//		String value = "Mon 01:00-22:00\n"
//				+ "Tue 01:00-22:00\n"
//				+ "Wed 01:00-22:00\n"
//				+ "Thu 01:00-22:00\n"
//				+ "Fri 01:00-22:00\n"
//				+ "Sat 01:00-21:59\n"
//				+ "Sun 01:00-22:00\n";
//		String value = "Mon 00:00-01:00\n"
//				+ "Tue 00:00-01:00\n"
//				+ "Sun 23:00-23:59";
		String value = "Mon 00:00-01:00\nTue 00:00-00:01\nThu 00:00-00:01\nSun 23:00-23:59";

		return value;
	}
}
