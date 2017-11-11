package model.tetromino;

import java.util.ArrayList;
import java.util.List;

public class TetrominoGenerator {

	List<Tetromino> tetrominoes;
	Tetromino nextTetromino;
	Tetromino heldTetromino;
	int sizeOfList = 200;

	public TetrominoGenerator() {
		try {
			tetrominoes = generateTetrominoes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		nextTetromino = getRandomTetromino();
		// heldTetromino = getNextTetromino();
	}

	public List<Tetromino> generateTetrominoes() throws Exception {
		List<Tetromino> tetroList = new ArrayList<Tetromino>();
		for (int i = 0; i < sizeOfList; i++) {
			int choice = (int) (Math.random() * 7);
			switch (choice) {
			case 0:
				tetroList.add(new IBlock());
				break;
			case 1:
				tetroList.add(new JBlock());
				break;
			case 2:
				tetroList.add(new LBlock());
				break;
			case 3:
				tetroList.add(new OBlock());
				break;
			case 4:
				tetroList.add(new SBlock());
				break;
			case 5:
				tetroList.add(new TBlock());
				break;
			case 6:
				tetroList.add(new ZBlock());
				break;
			default:
				throw new Exception("Invalid generated block choice");
			}
		}
		return tetroList;
	}

	public Tetromino getRandomTetromino() {
		return tetrominoes.get((int) (Math.random() * tetrominoes.size()));
	}

	public Tetromino holdTetromino() {
		Tetromino tempTetromino = nextTetromino;
		nextTetromino = getRandomTetromino();
		return tempTetromino;
	}

}
