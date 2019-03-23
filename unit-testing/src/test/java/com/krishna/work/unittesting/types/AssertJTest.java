package com.krishna.work.unittesting.types;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void assertJexamples() {
		List<Integer> numberList = Arrays.asList(15, 20, 25, 30);
		assertThat(numberList).hasSize(4).contains(20, 25)
				.allMatch(x -> x > 10).noneMatch(x -> x < 10);

		// For String
		assertThat("KRISHNACHAVHAN").isNotEmpty().startsWith("KRI")
				.endsWith("HAN").contains("NACHA");
	}

}
