package domain.payment.schedule;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class WeeklyTest {
	private Weekly weekly;
	
	@Before
	public void initiate(){
		weekly = new Weekly();
	}
	
	@Test
	public void returnTrueForLastDayOfweek() {
		assertTrue(weekly.isPayDate(LocalDate.of(2017, 2, 3)));
	}
	
	@Test
	public void returnFalseForNotLastDayOfweek() {
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 4)));
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 5)));
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 6)));
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 7)));
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 8)));
		assertFalse(weekly.isPayDate(LocalDate.of(2017, 2, 9)));
	}

}
