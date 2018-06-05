package br.com.fsg.gourmetgame;

import static br.com.fsg.jogogourmet.util.Messages.CONFIRM_QUESTION;
import static br.com.fsg.jogogourmet.util.Messages.GAME_NAME;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class GourmetGame implements Game {

	private String key;
	private Game rightAnswer = new NullGame();
	private Game wrongAnswer = new NullGame();

	public GourmetGame(String key) {
		this.key = key;
	}

	public GourmetGame(String key, String rightAnswer, String wrongAnswer) {
		this.key = key;
		this.configure(rightAnswer, wrongAnswer);
	}

	private void configure(String rightAnswer, String wrongAnswer) {
		this.rightAnswer = new GourmetGame(rightAnswer);
		this.wrongAnswer = new GourmetGame(wrongAnswer);
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public void ask() {
		int option = showConfirmDialog(null, String.format(CONFIRM_QUESTION, this.key), GAME_NAME, YES_NO_OPTION);
		switch (option) {
		case OK_OPTION:
			rightAnswer.confirmPositive();
			break;
		case NO_OPTION:
			wrongAnswer.confirmNegative(this);
			break;
		}
	}

	@Override
	public void addOption(String rightAnswer, String wrongAnswer) {
		configure(rightAnswer, this.key);
		this.key = wrongAnswer;
	}

	@Override
	public void confirmPositive() {
		this.ask();
	}

	@Override
	public void confirmNegative(Game game) {
		this.ask();
	}

}
