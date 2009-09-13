/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.util;
	/*
Calendar cal = Calendar.getInstance();
ou si l'on veut preciser une zone horaire (ici Europe Central Time)
Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("ECT"));

Ensuite sur cet objet on peut récupérer l'heure, les minutes ...

cal.get(Calendar.HOUR);
cal.get(Calendar.MINUTES);
cal.get(Calendar.DAY_OF_YEAR); //... voir java.util.Calendar

Ou afficher un résultat formaté :

System.out.println(DateFormat.getDateInstance(DateFormat.LONG).
      format(cal.getTime());
     */
import java.text.DateFormat;
import java.util.Date;
public class DateUtils {
	//public static String formatDateWithOptionalTime(Date date) {
		
	public static String getDateString(Date date) {
		//if (date.getHours() == 0 && date.getMinutes() == 0 && date.getSeconds() == 0)
		//	return DateFormat.getDateInstance(DateFormat.LONG).format(date);
		return DateFormat.getDateInstance(DateFormat.LONG).format(date);
	}
}     