//Created by ScienceRavenclaw and Catnaddi

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class StarteInsekt {

	//Sensoren erzeugen
	static Farbsensor einFarbsensor;
	static Ultraschallsensor einUltraschallsensor;
	static Beruehrungssensor einBeruehrungssensor;
	static Jukebox eineJukebox;
	
	public static void begruesseBenutzer() {
		eineJukebox.spieleSounddateiMarvin();
		LCD.drawString("Start! Halte eine", 0, 0);
		LCD.drawString("Farbe vor dem", 0, 1);
		LCD.drawString("Sensor, um zu", 0, 2);
		LCD.drawString("beginnen!", 0, 3);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//Sensorobjekte erzeugen
		einFarbsensor = new Farbsensor();
		einUltraschallsensor = new Ultraschallsensor();
		einBeruehrungssensor = new Beruehrungssensor();
		eineJukebox = new Jukebox();
		
		//Motoren erzeugen
		RegulatedMotor motor1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor motor2 = new EV3LargeRegulatedMotor(MotorPort.D);
		
		begruesseBenutzer();
		Thread.sleep(500);
		
		while(!Button.ENTER.isDown()) {
			
			String eineFarbe = einFarbsensor.erkenneFarbe();
			float distanz = einUltraschallsensor.messeEntfernung();
			float istVorneGedrueckt = einBeruehrungssensor.erkenneBeruehrungVorne();
			float istHintenGedrueckt = einBeruehrungssensor.erkenneBeruehrungHinten();
			
			if(distanz <= 0.1) {
				eineJukebox.spieleSounddateiWaisted();
				System.exit(0);
			} else if(eineFarbe.equals("NONE")) {
				LCD.clear();
				LCD.drawString("Bitte eine Farbe!", 0, 0);
			} else if(eineFarbe.equals("GREEN")) {
				Sound.beepSequenceUp();
				while(istVorneGedrueckt == 0) {
					motor1.forward();
					motor2.forward();
					eineJukebox.spieleSounddateiNochnStueck();
					istVorneGedrueckt = einBeruehrungssensor.erkenneBeruehrungVorne();
				}
				motor1.stop();
				motor2.stop();
				eineJukebox.spieleSounddateiDisapointed();
			} else if(eineFarbe.equals("WHITE")) {
				Sound.beep();
				while(istHintenGedrueckt == 0) {
					motor1.backward();
					motor2.backward();
					eineJukebox.spieleSounddateiNochnStueck();
					istHintenGedrueckt = einBeruehrungssensor.erkenneBeruehrungHinten();
				}
				motor1.stop();
				motor2.stop();
				eineJukebox.spieleSounddateiDisapointed();
			} else if(eineFarbe.equals("YELLOW")) {
				//im Uhrzeigersinn (rechts)
				Sound.beep();
				motor1.stop();
				motor2.stop();
				motor1.forward();
				motor2.backward();
			} else if(eineFarbe.equals("BLUE")) {
				//gegen Uhrzeigersinn (links)
				Sound.beep();
				motor1.stop();
				motor2.stop();
				motor2.forward();
				motor1.backward();
			} else if(eineFarbe.equals("RED")) {
				eineJukebox.spieleSounddateiNazgul();
				motor1.forward();
				motor2.backward(); 
				Delay.msDelay(11200);
				while(istHintenGedrueckt == 0) {
					motor1.backward(); 
					motor2.backward();
					istHintenGedrueckt = einBeruehrungssensor.erkenneBeruehrungHinten();
				}
				motor1.forward();
				motor2.forward();
				Delay.msDelay(10000);
				motor1.stop();
				motor2.stop();
				eineJukebox.spieleSounddateiNazgul();
			} else if(eineFarbe.equals("BLACK")) {
				motor1.stop();
				motor2.stop();
				eineJukebox.spieleSounddateiDisapointed();
			}
		}
	}
}