import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;

public class Beruehrungssensor {

	SensorModes einVordersensor = new EV3TouchSensor(SensorPort.S1);
	SensorModes einHintersensor = new EV3TouchSensor(SensorPort.S4);
	
	SampleProvider eineVordersensorBeruehrung = einVordersensor.getMode("Touch");
	SampleProvider eineHintersensorBeruehrung = einHintersensor.getMode("Touch");
	
	float istGedrueckt = 0; 
	float einVorderSample[] = new float[eineVordersensorBeruehrung.sampleSize()];
	float einHinterSample[] = new float[eineHintersensorBeruehrung.sampleSize()];
	
	float erkenneBeruehrungVorne() {
		eineVordersensorBeruehrung.fetchSample(einVorderSample, 0);
		istGedrueckt = einVorderSample[0];
		return istGedrueckt;
	}
	
	float erkenneBeruehrungHinten() {
		eineHintersensorBeruehrung.fetchSample(einHinterSample, 0);
		istGedrueckt = einHinterSample[0];
		return istGedrueckt;
	}
	
	
	
	

	
	
	
}