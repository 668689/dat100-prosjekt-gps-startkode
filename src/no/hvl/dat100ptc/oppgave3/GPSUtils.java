package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d :da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] breddegrader = new double[gpspoints.length]; 
		for ( int i = 0; i < gpspoints.length; i++) {
			breddegrader[i]= gpspoints[i].getLatitude();
		}
				
		
		return breddegrader;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] lengdegrader = new double[gpspoints.length];
		for ( int i = 0; i < gpspoints.length; i++) {
			lengdegrader[i] = gpspoints[i].getLongitude();
		}
		return lengdegrader;
		

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		latitude1 = Math.toRadians(latitude1);
		
		latitude2 = gpspoint2.getLatitude();
		latitude2 = Math.toRadians(latitude2);
		
		double deltaLat = latitude2 - latitude1;
		
		longitude1 = gpspoint1.getLongitude();
		longitude1 = Math.toRadians(longitude1);
		
		longitude2 = gpspoint2.getLongitude();
		longitude2 = Math.toRadians(longitude2);
		
		double deltaLongi = longitude2 - longitude1;
		
		double a = Math.pow(Math.sin(deltaLat/2), 2) + (Math.cos(latitude1) * Math.cos(latitude2)) * Math.pow(Math.sin(deltaLongi/2), 2);
		
		double c = 2 * Math.atan2((Math.sqrt(a)), (Math.sqrt((1-a))));
		
		d = R * c;
		
		return d;
		
		
	}

		

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		double d = distance(gpspoint1, gpspoint2);
		
		int tid1 = gpspoint1.getTime();
		
		int tid2  = gpspoint2.getTime();
		
		int sumtid = tid2 - tid1;
		
		double ms = d/sumtid;
		
		speed = ms * 3.6;
		
		return speed;

	}

	public static String formatTime(int secs) {

		int timer = secs / 60 / 60;

		int min = (secs - (timer * 60 * 60)) / 60;

		int sekund = (secs - (timer * 60 * 60) - (min * 60));

		String timestr = "  ";
		String TIMESEP = ":";
		String minstr = "";
		String sekstr = "";
		timer = secs / 60 / 60;

		String strtimer;

		if (timer < 10) {
			timestr += "0" + Integer.toString(timer);
		} else
			timestr += Integer.toString(timer);

		if (min < 10) {
			minstr += "0" + Integer.toString(min);
		} else
			minstr = Integer.toString(min);

		if (sekund < 10) {
			sekstr += "0" + Integer.toString(sekund);
		} else
			sekstr = Integer.toString(sekund);

		strtimer = timestr + TIMESEP + minstr + TIMESEP + sekstr;

		return strtimer;
	}

	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str ="      ";

		String desimal = String.format("%.2f",d);
		
		str += desimal;
		String replaceString = str.replace(",",".");
		return replaceString;
		
	}
}
