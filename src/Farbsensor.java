import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;

public class Farbsensor {
	
	public String erkenneFarbe()  {
		
		EV3 einEV3 = (EV3) BrickFinder.getLocal();
		TextLCD einLCDPanel = einEV3.getTextLCD();
		
		EV3ColorSensor einFarbsensor = new EV3ColorSensor(SensorPort.S2);
		SensorMode eineFarbe = einFarbsensor.getColorIDMode();
		float[] einFarbSample = new float[eineFarbe.sampleSize()];
		
		//Farbermittlung vorbereiten
		eineFarbe.fetchSample(einFarbSample, 0);
		int eineFarbID = (int)einFarbSample[0];
		String eineFarbeString = "NONE";
		
		//LED einschalten
		einFarbsensor.setFloodlight(true);
		
		//Farben ermitteln und Variable mit Farbe füllen
			if (eineFarbID == Color.NONE) {
				eineFarbeString = "NONE";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.BLACK) {
				eineFarbeString = "BLACK";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.BLUE) {
				eineFarbeString = "BLUE";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.GREEN) {
				eineFarbeString = "GREEN";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.YELLOW) {
				eineFarbeString = "YELLOW";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.RED) {
				eineFarbeString = "RED";
				einFarbsensor.close();
				return eineFarbeString;
			} else if(eineFarbID == Color.WHITE) {
				eineFarbeString = "WHITE";
				einFarbsensor.close();
				return eineFarbeString;
			} else if (eineFarbID == Color.BROWN) {
				eineFarbeString = "BROWN";
				einFarbsensor.close();
				return eineFarbeString;
			}
		einFarbsensor.close();
		return eineFarbeString;
	}	
}

