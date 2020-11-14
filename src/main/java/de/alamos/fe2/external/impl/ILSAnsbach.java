package de.alamos.fe2.external.impl;

import java.util.HashMap;
import java.util.Map;

import de.alamos.fe2.external.enums.EAlarmDataEntries;
import de.alamos.fe2.external.interfaces.IAlarmExtractor;

/**
 * Zerlegung für Alarmfax der ILS Ansbach.
 */
public class ILSAnsbach implements IAlarmExtractor {

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
		 * Beispielzerlegungen
		 */
		
		//BEISPIEL 1

		//Teile übergebenen String an Trennzeichen "&"
		String[] parameters = input.split("&");
		
		//Stichwort steht an erster Stelle, daher [0]
		String keyword = parameters[0];
		data.put("keyword", keyword);
		
		//Straße steht an dritter Stelle, daher [2]
		String street = parameters[2];
		data.put("street", street);

		
		//BEISPIEL 2
		/*
		 * Hier werden die Parameter in der Map mit vordefinierten Enums aus dem Enum-Objekt "EAlarmDataEntries" gesetzt. 
		 * Hier sind nicht alle Parameter hinterlegt. 
		 * Sollte einer fehlen, verwenden Sie bitte den normalen Parametername, z. B. "mitteiler"
		 */
		
		//Stichwort ist immer 6 Stellen lang und immer am Anfang der Nachricht
		String stichwort = input.substring(0, 6);
		data.put(EAlarmDataEntries.KEYWORD.getKey(), stichwort);
		
		//Straße wird extrahiert und anschließend werden alle Kommas
		String strasse = input.substring(6, 30).replace(",", "");
		data.put(EAlarmDataEntries.STREET.getKey(), strasse);
		

		//Diese Zeile muss ganz am Ende stehen, nachdem die eigene Zerlegung durchgefßhrt wurde. Hier wird die Map an FE2 zurßck gegeben
		return data;
	}
}
