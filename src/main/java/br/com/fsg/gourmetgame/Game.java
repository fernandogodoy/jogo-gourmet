package br.com.fsg.gourmetgame;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public interface Game {

	void confirmPositive();

	void confirmNegative(Game game);

	void ask();

	void addOption(String rightAnswer, String wrongAnswer);

	String getKey();

}
