package datediff;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A year is a leap year if it is divisible by 4, but century years are not leap years unless they are divisible by 400. 
 * So, the years 1700, 1800, and 1900 were not leap years, but the year 2000 was.
 * 
 * @author jesimone57
 *
 */
public class LeapYearTest {

	@Test
	public void validLeapYears() {
		assertTrue(LeapYear.isLeapYear(1600));
		
		assertTrue(LeapYear.isLeapYear(1988));
		assertTrue(LeapYear.isLeapYear(1992));
		assertTrue(LeapYear.isLeapYear(1996));
		assertTrue(LeapYear.isLeapYear(2000));
		assertTrue(LeapYear.isLeapYear(2004));
		assertTrue(LeapYear.isLeapYear(2008));
		assertTrue(LeapYear.isLeapYear(2012));
		assertTrue(LeapYear.isLeapYear(2016));
		assertTrue(LeapYear.isLeapYear(2020));
	}
	
	@Test
	public void notLeapYears() {
		assertFalse(LeapYear.isLeapYear(1500));
		assertFalse(LeapYear.isLeapYear(1700));
		assertFalse(LeapYear.isLeapYear(1800));
		assertFalse(LeapYear.isLeapYear(1900));
		assertFalse(LeapYear.isLeapYear(2100));
		
		assertFalse(LeapYear.isLeapYear(1989));
		assertFalse(LeapYear.isLeapYear(1990));
		assertFalse(LeapYear.isLeapYear(1991));
		assertFalse(LeapYear.isLeapYear(1993));
		assertFalse(LeapYear.isLeapYear(1994));
		assertFalse(LeapYear.isLeapYear(1995));
		assertFalse(LeapYear.isLeapYear(1997));
		assertFalse(LeapYear.isLeapYear(1998));
		assertFalse(LeapYear.isLeapYear(1999));
		assertFalse(LeapYear.isLeapYear(2001));
		assertFalse(LeapYear.isLeapYear(2002));
		assertFalse(LeapYear.isLeapYear(2003));
		assertFalse(LeapYear.isLeapYear(2005));
		assertFalse(LeapYear.isLeapYear(2006));
		assertFalse(LeapYear.isLeapYear(2007));
		assertFalse(LeapYear.isLeapYear(2009));
		assertFalse(LeapYear.isLeapYear(2010));
		assertFalse(LeapYear.isLeapYear(2011));
		assertFalse(LeapYear.isLeapYear(2015));
	}

}
