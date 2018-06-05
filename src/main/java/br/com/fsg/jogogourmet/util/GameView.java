package br.com.fsg.jogogourmet.util;

import static br.com.fsg.jogogourmet.util.Messages.BOLO_CHOCOLATE;
import static br.com.fsg.jogogourmet.util.Messages.MASSA;
import static br.com.fsg.jogogourmet.util.Messages.GAME_NAME;
import static br.com.fsg.jogogourmet.util.Messages.LASANHA;
import static br.com.fsg.jogogourmet.util.Messages.OK;
import static br.com.fsg.jogogourmet.util.Messages.WELCOME_MESSAGE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.fsg.gourmetgame.Game;
import br.com.fsg.gourmetgame.GourmetGame;

/**
 * 
 * @author Fernando-Godoy
 *
 */
public class GameView {

	private Game game;

	private void gameInstance() {
		game = new GourmetGame(MASSA, LASANHA, BOLO_CHOCOLATE);
	}

	public void open() {
		this.gameInstance();
		createView();
	}

	private void createView() {
		JFrame screen = new JFrame(GAME_NAME);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(null);
		screen.setSize(300, 120);
		screen.setLocationRelativeTo(null);
		JLabel label = createLabel();
		JButton button = createButton(game);
		screen.add(label);
		screen.add(button);
	}

	private JLabel createLabel() {
		JLabel label = new JLabel(WELCOME_MESSAGE);
		label.setBounds(55, 0, 260, 50);
		return label;
	}

	private JButton createButton(Game game) {
		JButton button = new JButton(OK);
		button.setBounds(85, 40, 90, 20);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.ask();
			}
		});
		return button;
	}
}
