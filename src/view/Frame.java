package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.tetris.Tetris;
import view.panels.TetrisGraphics;
import view.panels.TitlePanel;

public class Frame extends JFrame implements Observer {
	private static final long serialVersionUID = -4625604749828860822L;
	private TetrisGraphics mainPanel;
	private Tetris model;

	public Frame(Tetris model) {

		super("Tetris");
		this.model = model;
		this.addKeyListener(new Controller(model));
		JPanel titlePanel = new TitlePanel(this);
		mainPanel = new TetrisGraphics(this);
		add(titlePanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setFrameProperties();
	}

	private void setFrameProperties() {

		addWindowListener(new TetrisWindowListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Deal with updates to the Tetris model
	 */
	@Override
	public void update(Observable o, Object arg) {

		mainPanel.repaint();
	}

	public Tetris getModel() {
		return model;
	}

}
