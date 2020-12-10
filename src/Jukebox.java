import java.io.File;

import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;

public class Jukebox {

	private static Audio audio;
	private static final File ichHeisseMarvin = new File("./marvin.wav");
	private static final File nochnStueck = new File("./nochnstueck.wav");
	private static final File nazgul = new File("./nazgul.wav");
	private static final File disapointed = new File("./disapointed.wav");
	private static final File waisted = new File("./waisted.wav");
	
	public void spieleSounddateiMarvin() {
		audio = BrickFinder.getDefault().getAudio();
		audio.setVolume(250);
		audio.playSample(ichHeisseMarvin, 250);
	}
	
	public void spieleSounddateiNochnStueck() {
		audio = BrickFinder.getDefault().getAudio();
		audio.setVolume(250);
		audio.playSample(nochnStueck, 250);
	}
	
	public void spieleSounddateiNazgul() {
		audio = BrickFinder.getDefault().getAudio();
		audio.setVolume(250);
		audio.playSample(nazgul, 250);
	}
	
	public void spieleSounddateiDisapointed() {
		audio = BrickFinder.getDefault().getAudio();
		audio.setVolume(250);
		audio.playSample(disapointed, 250);
	}
	
	public void spieleSounddateiWaisted() {
		audio = BrickFinder.getDefault().getAudio();
		audio.setVolume(250);
		audio.playSample(waisted, 250);
	}
}