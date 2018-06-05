package br.com.fsg.gourmetgame;

import br.com.fsg.jogogourmet.util.GameView;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class GameApp {

	public static void main(String[] args) {
		GameApp game = new GameApp();
		game.start();
	}

	private void start() {
		GameView view = new GameView();
		view.open();
	}

}
