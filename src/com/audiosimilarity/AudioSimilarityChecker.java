package com.audiosimilarity;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

public class AudioSimilarityChecker {
	public static void main(String[] args) {
		String recording = args[0];
		String beep = args[1];
		
		float epsilon = 0.9f;
		if (args.length > 2) {
			epsilon = Float.parseFloat(args[2]);
		}

		Wave waveRecording = new Wave(recording);
		Wave waveBeep = new Wave(beep);

		FingerprintSimilarity similarity = waveRecording.getFingerprintSimilarity(waveBeep);
		
		boolean isSimilar = similarity.getSimilarity() >= epsilon;
		
		System.out.println(
				"clip is found at "+ similarity.getsetMostSimilarTimePosition() + 
				", score: " + similarity.getScore() + 
				", similarity: " + similarity.getSimilarity() +
				", is similar: " + isSimilar);
		
		if (isSimilar) {
			System.exit(0);
		} else {
			System.exit(1);
		}
	}
}
