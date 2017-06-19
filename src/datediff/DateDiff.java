package datediff;

import java.util.List;

/**
 * Main program which reads the input file and produces the difference in days output.
 * 
 * @author jesimone57
 *
 */
public class DateDiff {

	public static void main(String[] args) throws Exception {
		String fileName = null;
		if (args.length == 0) {
			String cwd = System.getProperty("user.dir");
			System.out.println("Current Working Directory: " + cwd);
			fileName = cwd + "/dates.txt";
			
		} else {
			fileName = args[0];
		}
		System.out.println("Input file: "+fileName);
		
		List<DatePair> datePairs = ReadFile.read(fileName);

		for (DatePair datePair : datePairs) {
			datePair = orderByEarliest(datePair);
			DatePart date1 = datePair.getDate1();
			DatePart date2 = datePair.getDate2();

			int differenceInDays = DateUtil.calculateDifferenceInDays(date1.getDay(), date1.getMonth(), date1.getYear(),
					date2.getDay(), date2.getMonth(), date2.getYear());

			System.out.println(datePair + ", " + differenceInDays);
		}
	}
	
	private static DatePair orderByEarliest(DatePair datePair) {
		DatePair result = datePair;
		if (datePair.getDate1().getYear() > datePair.getDate2().getYear()) {
			result = new DatePair(datePair.getDate2(), datePair.getDate1()); //swap due to year1 being after year2
		} else if (datePair.getDate1().getYear() == datePair.getDate2().getYear() &&
				datePair.getDate1().getMonth() > datePair.getDate2().getMonth()){
			result = new DatePair(datePair.getDate2(), datePair.getDate1()); //swap due to month1 being after month2 (while years are same)
		} else if (datePair.getDate1().getYear() == datePair.getDate2().getYear() &&
				datePair.getDate1().getMonth() == datePair.getDate2().getMonth() &&
				datePair.getDate1().getDay() > datePair.getDate2().getDay()) {
			result = new DatePair(datePair.getDate2(), datePair.getDate1()); //swap due to day1 being after day2 (while years and months are same)
		}
		return result;
	}

}
