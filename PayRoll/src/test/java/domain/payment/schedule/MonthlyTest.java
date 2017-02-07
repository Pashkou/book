package domain.payment.schedule;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MonthlyTest {

	@Test
	public void isNotPayDateFebruar() {
		Monthly monthly = new Monthly();
		assertFalse(monthly.isPayDate(LocalDate.of(2017,2,7)));
	}

	@Test
	public void isNotPayDateDezember() {
		Monthly monthly = new Monthly();
		assertFalse(monthly.isPayDate(LocalDate.of(2016,12,30)));
	}
	
	@Test
	public void isPayDateFebruar() {
		Monthly monthly = new Monthly();
		assertTrue(monthly.isPayDate(LocalDate.of(2017,2,28)));
	}

	@Test
	public void isPayDateDezember() {
		Monthly monthly = new Monthly();
		assertTrue(monthly.isPayDate(LocalDate.of(2016,12,31)));
	}

}
