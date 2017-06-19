package datediff;

public class DateUtil {

	private DateUtil() {
	}
	
	/**
	 * Expected date format:  D M Y  or DD MM YYYY
	 * @param dateFormat
	 * @param delimiter
	 * @return
	 */
	public static DatePart parseDayMonthYearString(String dateString, String delimiter) {
		if (dateString == null || dateString.trim().length() < 8 || delimiter == null || delimiter.length() == 0) {
			throw new IllegalArgumentException("Invalid date string or invalid delimiter string.  Date format is DD MM YYYY");
		}
		if (! dateString.contains(delimiter)) {
			throw new IllegalArgumentException("Date string "+dateString+" is not delimited by "+delimiter);
		}
		
		String [] dateParts = dateString.split(delimiter);	
		if (dateParts.length != 3) {
			throw new IllegalArgumentException("Date string "+dateString+" did not parse into day month and year using delimiter "+delimiter);
		}
		
		int day = Integer.valueOf(dateParts[0]);
		int month = Integer.valueOf(dateParts[1]);
		int year = Integer.valueOf(dateParts[2]);
		return new DatePart(day, month, year);
	}

	public static int daysFromStartOfYear(int day, int month, int year) {
		if (! isDateValid(day, month, year)) {
			throw new IllegalArgumentException("Invalid day=" + day + " month=" + month + " and year=" + year);
		}
		int totalDaysFromYearStart = 0;
		for (int i = 1; i <= month; i++) {
			if (i == month) {
				totalDaysFromYearStart += day;
			} else {
				Month monthEnum = Month.getMonth(i - 1);
				int daysInMonth = monthEnum.getDays(LeapYear.isLeapYear(year));
				totalDaysFromYearStart += daysInMonth;
			}
		}
		return totalDaysFromYearStart - 1; // exclusive of the given day. So, for example, from jan 1 to jan 1 would be 0 days.
	}

	public static int daysBetweenYears(int year1, int year2) {
		int days = 0;
		if (year1 < year2) {
			for (int year = year1; year < year2; year++) {
				days += daysInYear(year);
			}
		} else {
			for (int year = year2; year < year1; year++) {
				days += daysInYear(year);
			}
		}
		return days;
	}

	public static int daysInYear(int year) {
		return LeapYear.isLeapYear(year) ? 366 : 365;
	}

	public static int daysToEndOfYear(int day, int month, int year) {
		if (! isDateValid(day, month, year)) {
			throw new IllegalArgumentException("Invalid day=" + day + " month=" + month + " and year=" + year);
		}
		int totalDaysToYearEnd = 0;
		for (int i = month; i <= 12; i++) {
			if (i == month) {
				Month monthEnum = Month.getMonth(i - 1);
				int daysInMonth = monthEnum.getDays(LeapYear.isLeapYear(year));
				totalDaysToYearEnd += daysInMonth - day;
			} else {
				Month monthEnum = Month.getMonth(i - 1);
				int daysInMonth = monthEnum.getDays(LeapYear.isLeapYear(year));
				totalDaysToYearEnd += daysInMonth;
			}
		}
		return totalDaysToYearEnd;
	}

	public static int calculateDifferenceInDays(int day1, int month1, int year1, int day2, int month2, int year2) {
		if (! isDateValid(day1, month1, year1)) {
			throw new IllegalArgumentException("Invalid day=" + day1 + " month=" + month1 + " and year=" + year1);	
		}
		if (! isDateValid(day2, month2, year2)) {
			throw new IllegalArgumentException("Invalid day=" + day2 + " month=" + month2 + " and year=" + year2);	
		}
		
		int days = 0;
		if (year1 < year2) {
			days = daysToEndOfYear(day1, month1, year1) + daysBetweenYears(year1 + 1, year2) + daysFromStartOfYear(day2, month2, year2) + 1;
		} else if (year2 < year1) {
			days = daysToEndOfYear(day2, month2, year2) + daysBetweenYears(year2 + 1, year1) + daysFromStartOfYear(day1, month1, year1) + 1;
		} else {
			// year1 and year2 are exactly the same
			if (month1 < month2) {
				days = daysInYear(year1) - daysFromStartOfYear(day1, month1, year1) - daysToEndOfYear(day2, month2, year2) - 1;
			} else if (month2 < month1) {
				days = daysInYear(year1) - daysFromStartOfYear(day2, month2, year2) - daysToEndOfYear(day1, month1, year1) - 1;
			} else {
				// month1 and month2 are exactly the same
				days = Math.abs(day2 - day1);
			}
		}
		return days;
	}
	
	public static boolean isDateValid(int day, int month, int year) {
		if (year < 1583 || year > 2100) {
			System.out.println("Year "+year+" is not in valid range of 1583 to 2100");
			return false;
		}
		if (month < 1 || month > 12) {
			System.out.println("Month "+month+" is not in valid range of 1 to 12");
			return false;
		}
		Month monthType = Month.getMonth(month-1);
		int validDaysForMonth = monthType.getDays(LeapYear.isLeapYear(year));
		if (day < 1 || day > validDaysForMonth) {
			System.out.println("Day "+day+" is not in valid range for month "+monthType+" of 1 to "+validDaysForMonth);
			return false;
		}
		return true;
	}

}
