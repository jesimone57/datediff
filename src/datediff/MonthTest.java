package datediff;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonthTest {

	@Test
	public void validMonth() {
		assertEquals(Month.JAN, Month.getMonth(0));
		assertEquals(Month.FEB, Month.getMonth(1));
		assertEquals(Month.MAR, Month.getMonth(2));
		assertEquals(Month.APR, Month.getMonth(3));
		assertEquals(Month.MAY, Month.getMonth(4));

		assertEquals(Month.OCT, Month.getMonth(9));
		assertEquals(Month.NOV, Month.getMonth(10));
		assertEquals(Month.DEC, Month.getMonth(11));
	}

	@Test
	public void getDays() {
		assertEquals(29, Month.FEB.getDays(true));
		assertEquals(28, Month.FEB.getDays(false));
	}

}
