package de.alamos.fe2.external.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import de.alamos.fe2.external.impl.ILSAnsbach;
import org.junit.Ignore;
import org.junit.Test;

import de.alamos.fe2.external.enums.EAlarmDataEntries;

public class ILSAnsbachTest {

	@Test
	@Ignore("Failing at the moment")
	public void test() {
		ILSAnsbach impl = new ILSAnsbach();

		//BEISPIELDATEN
		
		String msg = "B 3 PERSON&Brand Zimmer&Teststrasse 12&Augsburg&EPN123&Anrufer meldet schwarzen Rauch aus Fenster";
		Map<String, String> map = impl.extract(msg);
		assertEquals("B 3 PERSON", map.get("keyword"));
		assertEquals("Brand Zimmer", map.get("keyword_description"));
		assertEquals("Teststraße 12", map.get(EAlarmDataEntries.STREET.getKey()));
		assertEquals("Augsburg", map.get(EAlarmDataEntries.CITY.getKey()));
		assertEquals("EPN123", map.get("epn"));
		assertEquals("Anrufer meldet schwarzen Rauch aus Fenster", map.get("text"));

		msg = "B BMA&Brandmeldeanlage (Feuermeldung)&Musterstrasse 12-14&Augsburg&EPN456";
		map = impl.extract(msg);
		assertEquals("B BMA", map.get("keyword"));
		assertEquals("Brandmeldeanlage (Feuermeldung)", map.get(EAlarmDataEntries.KEYWORD_DESCRIPTION.getKey()));
		assertEquals("Musterstrasse 12-14", map.get("street"));
		assertEquals("Augsburg", map.get(EAlarmDataEntries.CITY.getKey()));
		assertEquals("EPN456", map.get("epn"));
	}
}
