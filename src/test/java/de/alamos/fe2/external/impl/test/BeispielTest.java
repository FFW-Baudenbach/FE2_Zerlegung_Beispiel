package de.alamos.fe2.external.impl.test;

import de.alamos.fe2.external.enums.EAlarmDataEntries;
import de.alamos.fe2.external.impl.Beispiel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BeispielTest {

	@Test
	public void extract_keywordIsExtracted() {
		Beispiel impl = new Beispiel();
		String msg = "B3&Teststraße";
		Map<String, String> map = impl.extract(msg);
		Assertions.assertEquals("B3", map.get(EAlarmDataEntries.KEYWORD.getKey()));
	}

	@Test
	public void extract_streetIsExtracted() {
		Beispiel impl = new Beispiel();

		String msg = "B3&Teststraße";
		Map<String, String> map = impl.extract(msg);
		Assertions.assertEquals("Teststraße", map.get(EAlarmDataEntries.STREET.getKey()));
	}
}
