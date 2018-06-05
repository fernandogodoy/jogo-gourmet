package br.com.fsg.gourmetgame;

import static br.com.fsg.jogogourmet.util.Messages.END_MESSAGE;
import static br.com.fsg.jogogourmet.util.Messages.GAME_NAME;
import static br.com.fsg.jogogourmet.util.Messages.UNKNOWN_VALUE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import br.com.fsg.jogogourmet.util.Messages;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class NullGame implements Game {

	@Override
	public void ask() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addOption(String rightAnswer, String wrongAnswer) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getKey() {
		return UNKNOWN_VALUE;
	}

	@Override
	public void confirmPositive() {
		showMessageDialog(null, END_MESSAGE, GAME_NAME, QUESTION_MESSAGE);
	}

	@Override
	public void confirmNegative(Game game) {
		String dish = showInputDialog(Messages.NEW_QUESTION);
		String sentence = String.format(Messages.COMPLETE_SENTENCE, dish, game.getKey());
		String clue = showInputDialog(sentence);
		game.addOption(dish, clue);
	}

}
