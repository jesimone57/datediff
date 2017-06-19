package datediff;

/**
 * 
 * There is a leap year every year whose number is perfectly divisible by four -
 * except for years which are both divisible by 100 and not divisible by 400.
 * 
 * The second part of the rule effects century years. For example; the century
 * years 1600 and 2000 are leap years, but the century years 1700, 1800, and
 * 1900 are not.
 * 
 * @author jsimone
 *
 */
public class LeapYear {

	public static boolean isLeapYear(int year) {
		boolean divBy4 = year % 4 == 0;
		boolean divBy100 = year % 100 == 0;
		boolean divBy400 = year % 400 == 0;
		return divBy4 && !(divBy100 && !divBy400);
	}

}
