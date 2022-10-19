package no.hvl.dat100ptc.oppgave2;

import static java.lang.Integer.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		hr = parseInt(timestr.substring(11,13));
		min = parseInt(timestr.substring(14,16));
		sec = parseInt(timestr.substring(17,19));
		
		int hrsecs = hr * 3600;
		int minsecs = min * 60;
		int secsecs = sec;
		
		secs = hrsecs + minsecs + secsecs;
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		
		double lat, longi, elev;
		
	   int time = toSeconds(timeStr);
		lat = Double.parseDouble(latitudeStr);
		longi = Double.parseDouble(longitudeStr);
		elev = Double.parseDouble(elevationStr);
	
		gpspoint = new GPSPoint(time, lat, longi, elev);
			
			return gpspoint;
		
	
		
	    
	}
	
}
