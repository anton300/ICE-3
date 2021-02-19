package test;

import static org.junit.jupiter.api.Assertions.*;

import com.java.BadChangeException;
import com.java.ChangeCounter;

import org.junit.jupiter.api.Test;

class ChangeCounterTest {

	@Test
	void makeChange_SuccessCase() throws BadChangeException {
		int[] expected = {2, 0, 0};
		
		int[] actual = ChangeCounter.makeChange(50);
		
		assertEquals(expected[0], actual[0]);
	}
	
	@Test
	void makeChange_BoundaryCase() throws BadChangeException {
		int[] expected = {4, 0, 0};
		
		int[] actual = ChangeCounter.makeChange(100);
		
		assertEquals(expected[0], actual[0]);
	}
	
	@Test
	void makeChange_FailCase() {
		assertThrows(BadChangeException.class, () -> ChangeCounter.makeChange(200));
	}

}
