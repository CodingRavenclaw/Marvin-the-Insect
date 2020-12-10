import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;

public class Ultraschallsensor {

	SensorModes einUltraschallsensor = new EV3UltrasonicSensor(SensorPort.S3);
	SampleProvider eineSchallwelle = einUltraschallsensor.getMode("Distance");
	
	float distanzSample[] = new float[eineSchallwelle.sampleSize()];
	float distanz; //Einheit: cm 
	
	public float messeEntfernung() {
		
		eineSchallwelle.fetchSample(distanzSample, 0);
		distanz = distanzSample[0];
		
		return distanz;
	}
}