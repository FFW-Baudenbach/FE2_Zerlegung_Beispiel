package de.alamos.fe2.external.impl;

import java.util.HashMap;
import java.util.Map;

import de.alamos.fe2.external.enums.EAlarmDataEntries;
import de.alamos.fe2.external.interfaces.IAlarmExtractor;

/**
 * Zerlegung für Alarmfax der ILS Ansbach.
 */
public class Beispiel implements IAlarmExtractor {

	/**
	 * Zerlegt den Textinput von der Texterkennung und extrahiert
	 * Werte in Key/Value Paare für die Weiterverarbeitung mit FE2.
	 * 
	 * @param input Input String von Texterkennung.
	 * @return Map von Parametern mit Werten.
	 */
	@Override
	public Map<String, String> extract(String input) {
		
		/*
		 * In dieser Map können alle Parameter gesetzt werden,
		 * die über eine normale Zerlegung auch gesetzt werden können
		 */
		
		Map<String, String> data = new HashMap<>();
		
		/*
		 * Beispielzerlegung
		 */

		String[] parameters = input.split("&");

		String keyword = parameters[0];
		data.put(EAlarmDataEntries.KEYWORD.getKey(), keyword);

		String street = parameters[1];
		data.put(EAlarmDataEntries.STREET.getKey(), street);

		data.put("someKey", "someValue");

		return data;
	}
}
