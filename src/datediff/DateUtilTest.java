package datediff;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * Verified using wolfram alpha
 *   Reference see https://www.wolframalpha.com
 *   
 * @author jsimone
 *
 */
public class DateUtilTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString1() {
		DateUtil.parseDayMonthYearString(null, ",");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString2() {
		DateUtil.parseDayMonthYearString("1 1 200", ",");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString3() {
		DateUtil.parseDayMonthYearString("1 1 2001", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString4() {
		DateUtil.parseDayMonthYearString("1 1 2001", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString5() {
		DateUtil.parseDayMonthYearString("1 1 2001", "-");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString6() {
		DateUtil.parseDayMonthYearString("1 1 1 2001", " ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString7() {
		DateUtil.parseDayMonthYearString("A 1 2001", " ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString8() {
		DateUtil.parseDayMonthYearString("1 JAN 2001", " ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseDayMonthYearString9() {
		DateUtil.parseDayMonthYearString("1 1 Z", " ");
	}

	@Test
	public void parseDayMonthYearString10() {
		DatePart datePart = DateUtil.parseDayMonthYearString("10 1 2001", " ");
		assertEquals(10, datePart.getDay());
		assertEquals(1, datePart.getMonth());
		assertEquals(2001, datePart.getYear());
	}


	@Test
	public void daysFromStartOfNonLeapYear() {
		assertEquals(0,   DateUtil.daysFromStartOfYear(1, 1, 2001)); // jan 1st
		assertEquals(1,   DateUtil.daysFromStartOfYear(2, 1, 2001)); // jan 2nd
		
		assertEquals(59,  DateUtil.daysFromStartOfYear(1, 3, 2001)); // march 1st 
		assertEquals(218, DateUtil.daysFromStartOfYear(7, 8, 2001)); // aug 7th
		assertEquals(364, DateUtil.daysFromStartOfYear(31, 12, 2001)); // dec 31st
	}
	
	@Test
	public void daysFromStartOfLeapYear() {
		assertEquals(0,   DateUtil.daysFromStartOfYear(1, 1, 2000)); // jan 1st
		assertEquals(1,   DateUtil.daysFromStartOfYear(2, 1, 2000)); // jan 2nd
		
		assertEquals(60,  DateUtil.daysFromStartOfYear(1, 3, 2000)); // march 1st 
		assertEquals(219, DateUtil.daysFromStartOfYear(7, 8, 2000)); // aug 7th
		assertEquals(365, DateUtil.daysFromStartOfYear(31, 12, 2000)); // dec 31st
	}
	
	@Test
	public void daysToEndOfNonLeapYear() {
		assertEquals(30,  DateUtil.daysToEndOfYear(1, 12, 2001)); // dec 1st
		assertEquals(0,   DateUtil.daysToEndOfYear(31, 12, 2001)); // dec 31st
		
		assertEquals(364, DateUtil.daysToEndOfYear(1, 1, 2001)); // jan 1st
		assertEquals(363, DateUtil.daysToEndOfYear(2, 1, 2001)); // jan 2nd
		
		assertEquals(305, DateUtil.daysToEndOfYear(1, 3, 2001)); // march 1st 
		assertEquals(146, DateUtil.daysToEndOfYear(7, 8, 2001)); // aug 7th
		
		assertEquals(350, DateUtil.daysToEndOfYear(15, 1, 2001)); // jan 15th 
		assertEquals(314, DateUtil.daysToEndOfYear(20, 2, 2001)); // feb 20th
	}
	
	@Test
	public void daysToEndOfLeapYear() {
		assertEquals(30, DateUtil.daysToEndOfYear(1, 12, 2000)); // dec 1st
		assertEquals(0, DateUtil.daysToEndOfYear(31, 12, 2000)); // dec 31st
		
		assertEquals(365, DateUtil.daysToEndOfYear(1, 1, 2000)); // jan 1st
		assertEquals(364, DateUtil.daysToEndOfYear(2, 1, 2000)); // jan 2nd
		
		assertEquals(305, DateUtil.daysToEndOfYear(1, 3, 2000)); // march 1st 
		assertEquals(146, DateUtil.daysToEndOfYear(7, 8, 2000)); // aug 7th
		
		assertEquals(351, DateUtil.daysToEndOfYear(15, 1, 2000)); // jan 15th 
		assertEquals(315, DateUtil.daysToEndOfYear(20, 2, 2000)); // feb 20th
	}
	
	@Test
	public void daysBetweenYears() {
		assertEquals(0,   DateUtil.daysBetweenYears(1996, 1996));  
		assertEquals(365, DateUtil.daysBetweenYears(1995, 1996));  
		assertEquals(366, DateUtil.daysBetweenYears(1996, 1997));  
		assertEquals(731, DateUtil.daysBetweenYears(1996, 1998));
		
		assertEquals(1827, DateUtil.daysBetweenYears(1996, 2001));  
		assertEquals(14244, DateUtil.daysBetweenYears(1945, 1984)); 
		
		assertEquals(0,   DateUtil.daysBetweenYears(1996, 1996));  
		assertEquals(365, DateUtil.daysBetweenYears(1996, 1995));  
		assertEquals(366, DateUtil.daysBetweenYears(1997, 1996));  
		assertEquals(731, DateUtil.daysBetweenYears(1998, 1996));  
		
		assertEquals(1827, DateUtil.daysBetweenYears(2001, 1996));  
		assertEquals(14244, DateUtil.daysBetweenYears(1984, 1945));  
	}
	
	@Test
	public void daysInYear() {
		assertEquals(365, DateUtil.daysInYear(1995));
		
		assertEquals(366, DateUtil.daysInYear(1996));	
		assertEquals(365, DateUtil.daysInYear(1997));  
		assertEquals(365, DateUtil.daysInYear(1998));  
		assertEquals(365, DateUtil.daysInYear(1999));
		
		assertEquals(366, DateUtil.daysInYear(2000));  
		assertEquals(365, DateUtil.daysInYear(2001));  
		assertEquals(365, DateUtil.daysInYear(2002));  
		assertEquals(365, DateUtil.daysInYear(2003));
		
		assertEquals(366, DateUtil.daysInYear(2004));  
		assertEquals(365, DateUtil.daysInYear(2005));  
		assertEquals(365, DateUtil.daysInYear(2006));  
		assertEquals(365, DateUtil.daysInYear(2007));
		
		assertEquals(366, DateUtil.daysInYear(2008));
		assertEquals(365, DateUtil.daysInYear(2009));
		assertEquals(365, DateUtil.daysInYear(2010));
		assertEquals(365, DateUtil.daysInYear(2011));
		
		assertEquals(366, DateUtil.daysInYear(2012));
	}
	
	/**
	 * Validated against wolfram alpha as correct.
	 * 
	 *   https://www.wolframalpha.com/input/?i=days+from+jan+1+2000+to+march+7+2001
	 *   https://www.wolframalpha.com/input/?i=days+from+april+2,++1975+to+sept+4+1987
	 *   https://www.wolframalpha.com/input/?i=days+from+june+5,++1929+to+may+17,+1944
	 */
	@Test
	public void calculateDifferenceInDaysDifferentYears() {
		// Earlier date first, then later date
		assertEquals(431,    DateUtil.calculateDifferenceInDays(1,1,2000, 7,3,2001));
		assertEquals(4538,   DateUtil.calculateDifferenceInDays(2,4,1975, 4,9,1987));
		assertEquals(5460,   DateUtil.calculateDifferenceInDays(5,6,1929, 17,5,1944));
		
		assertEquals(3653,   DateUtil.calculateDifferenceInDays(1,1,2000, 1,1,2010)); // 10 * 365 = 3650 + 3 leap years = 3653
		assertEquals(1657,   DateUtil.calculateDifferenceInDays(22, 11, 1963, 05, 06, 1968));  // JFK and Bobby Kennedy assassination dates
		assertEquals(2193,   DateUtil.calculateDifferenceInDays(1, 9, 1939, 2, 9, 1945));  // WWII start and end dates
		assertEquals(1567,   DateUtil.calculateDifferenceInDays(28, 7, 1914, 11, 11, 1918));  // WWI start and end dates
		assertEquals(3059,   DateUtil.calculateDifferenceInDays(19, 4, 1775, 3, 9, 1783));  // American war of independence start and end dates
		assertEquals(1488,   DateUtil.calculateDifferenceInDays(12, 4, 1861, 9, 5, 1865));  // American civil war start and end dates
		assertEquals(23226,  DateUtil.calculateDifferenceInDays(20, 6, 1837, 22, 1, 1901));  // Queen Victoria reign start and end dates
		assertEquals(18263,  DateUtil.calculateDifferenceInDays(1, 6, 1967, 1, 6, 2017));  // 50th anniversary of Beatles Sgt. Pepper album release date
		assertEquals(2922,   DateUtil.calculateDifferenceInDays(20, 1, 2009, 20, 1, 2017));  // Barack Obama duration of presidential term in days
		
		// Same dates as above, but reversed order: Later date first, then earler date
		assertEquals(431,    DateUtil.calculateDifferenceInDays(7,3,2001,  1,1,2000));
		assertEquals(4538,   DateUtil.calculateDifferenceInDays(4,9,1987, 2,4,1975));
		assertEquals(5460,   DateUtil.calculateDifferenceInDays(17,5,1944, 5,6,1929));
		
		assertEquals(3653,   DateUtil.calculateDifferenceInDays(1,1,2010, 1,1,2000)); // 10 * 365 = 3650 + 3 leap years = 3653
		assertEquals(1657,   DateUtil.calculateDifferenceInDays( 05, 06, 1968, 22, 11, 1963)); // Bobby Kennedy and JFK assassination dates
		assertEquals(2193,   DateUtil.calculateDifferenceInDays(2, 9, 1945, 1, 9, 1939));  // WWII end and start dates
		assertEquals(1567,   DateUtil.calculateDifferenceInDays(11, 11, 1918, 28, 7, 1914));  // WWI end and start dates
		assertEquals(3059,   DateUtil.calculateDifferenceInDays(3, 9, 1783, 19, 4, 1775));  // American war of independence end and start dates
		assertEquals(1488,   DateUtil.calculateDifferenceInDays(9, 5, 1865, 12, 4, 1861));  // American civil war end and start dates
		assertEquals(23226,  DateUtil.calculateDifferenceInDays(22, 1, 1901, 20, 6, 1837));  // Queen Victoria reign end and start dates
		assertEquals(18263,  DateUtil.calculateDifferenceInDays( 1, 6, 2017, 1, 6, 1967));  // 50th anniversary of Beatles Sgt. Pepper album release date
		assertEquals(2922,   DateUtil.calculateDifferenceInDays( 20, 1, 2017, 20, 1, 2009));  // Barack Obama duration of presidential term in days
	}
	
	@Test
	public void calculateDifferenceInDaysSameYear() {
		// Earlier date first, then later date
		assertEquals(66,   DateUtil.calculateDifferenceInDays(1,1,2000, 7,3,2000)); // leap year
		assertEquals(65,   DateUtil.calculateDifferenceInDays(1,1,2001, 7,3,2001));
		assertEquals(182,  DateUtil.calculateDifferenceInDays(1, 6, 2017, 30, 11, 2017)); // Atlantic hurricane season 2017 start and end dates
		
		// Same dates as above, but reversed order: Later date first, then earler date
		assertEquals(66,   DateUtil.calculateDifferenceInDays(7,3,2000, 1,1,2000)); // leap year
		assertEquals(65,   DateUtil.calculateDifferenceInDays(7,3,2001, 1,1,2001));
		assertEquals(182,  DateUtil.calculateDifferenceInDays(30, 11, 2017, 1, 6, 2017)); // Atlantic hurricane season 2017 end and start dates
	}
	
	@Test
	public void calculateDifferenceInDaysSameYearAndMonth() {
		assertEquals(30, DateUtil.calculateDifferenceInDays(1,1,2000, 31,1,2000));
		assertEquals(7,  DateUtil.calculateDifferenceInDays(7,3,2000, 14,3,2000));
		assertEquals(28, DateUtil.calculateDifferenceInDays(1,2,2000, 29,2,2000));
		assertEquals(8,  DateUtil.calculateDifferenceInDays(16, 7, 1969, 24, 7, 1969)); // Apollo 11 moon landing mission start and end dates
		
		assertEquals(30, DateUtil.calculateDifferenceInDays(31,1,2000, 1,1,2000));
		assertEquals(7,  DateUtil.calculateDifferenceInDays(14,3,2000, 7,3,2000));
		assertEquals(28, DateUtil.calculateDifferenceInDays(29,2,2000, 1,2,2000));
		assertEquals(8,  DateUtil.calculateDifferenceInDays(24, 7, 1969, 16, 7, 1969)); // Apollo 11 moon landing mission end and start dates
	}
	
	@Test
	public void isDateValidForDay() {
		assertTrue(DateUtil.isDateValid(1, 1, 2000));
		assertTrue(DateUtil.isDateValid(31, 1, 2000));
		assertTrue(DateUtil.isDateValid(28, 2, 2000));
		assertTrue(DateUtil.isDateValid(29, 2, 2000));
		
		assertFalse(DateUtil.isDateValid(0, 1, 2000));
		assertFalse(DateUtil.isDateValid(-1, 1, 2000));
		assertFalse(DateUtil.isDateValid(32, 1, 2000));
		assertFalse(DateUtil.isDateValid(30, 2, 2000)); // no Feb 30th ever
		assertFalse(DateUtil.isDateValid(29, 2, 2001)); // no Feb 29th on a non-leap year
	}
	
	@Test
	public void isDateValidForMonth() {		
		assertFalse(DateUtil.isDateValid(1, -1, 2000));
		assertFalse(DateUtil.isDateValid(1, 0, 2000));
		assertFalse(DateUtil.isDateValid(1, 13, 2000));
	}
	
	@Test
	public void isDateValidForYear() {		
		assertFalse(DateUtil.isDateValid(1, 1, -1));
		assertFalse(DateUtil.isDateValid(1, 1, 0));
		assertFalse(DateUtil.isDateValid(1, 1, 1582));
		assertFalse(DateUtil.isDateValid(1, 2, 2101));
	}

}
