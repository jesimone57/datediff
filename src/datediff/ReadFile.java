package datediff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read a input file of comma separated dates into a list of DatePair objects for computing the difference in days.
 * 
 * File input format:
 * 
 *    D M Y, D M Y
 *    
 * where D, M may be either single digit or have a leading zero
 * NOTE: input lines beginning with a # or empty/null lines are ignored
 * 
 * @author jesimone57
 *
 */
public class ReadFile {

	public static List<DatePair> read(String fileName) throws Exception {
		List<DatePair> datePairs = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = reader.readLine();
			while (line != null) {
				line = line.trim();
				if (line.length() > 0 && !line.startsWith("#")) {
					String[] dates = line.split(",");
					if (dates.length != 2) {
						throw new RuntimeException("Input file " + fileName + " contains invalid comma separated dates: " + line);
					}
					DatePart date1 = DateUtil.parseDayMonthYearString(dates[0].trim(), " ");
					DatePart date2 = DateUtil.parseDayMonthYearString(dates[1].trim(), " ");
					datePairs.add(new DatePair(date1, date2));
				}
				line = reader.readLine();
			}
		}
		return datePairs;
	}

}
