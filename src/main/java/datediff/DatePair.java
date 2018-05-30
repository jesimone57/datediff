package datediff;

/**
 * A container class to hold a pair of dates in DatePart format.  This allows for easy passing of a pair of dates.
 * 
 * @author jesimone57
 *
 */
public class DatePair {
	private DatePart date1;
	private DatePart date2;

	public DatePair(DatePart date1, DatePart date2) {
		this.date1 = date1;
		this.date2 = date2;
	}
		
	public DatePart getDate1() {
		return date1;
	}

	public void setDate1(DatePart date1) {
		this.date1 = date1;
	}

	public DatePart getDate2() {
		return date2;
	}

	public void setDate2(DatePart date2) {
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return date1+", "+date2;
	}

}
