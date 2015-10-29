package com.ly.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		// ��ʼ������Ȩֵ
		chessboard.initChessBoardWeight();
		chessboard.printBoard();
		// ��ʼ������Ȩֵ����

		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			// isOver = false;(�Լ�ע�͵ľ���û��Ҫ��)
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out
					.println("------------------------------------------------------");
			this.printChessBoard();
			System.out
					.println("------------------------------------------------------");
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		// ��ʦ�����������start
		// int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// String[][] board = chessboard.getBoard();
		// while (board[posX][posY] != "ʮ") {
		// posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// }
		// int[] result = { posX, posY };
		// ��ʦ�����������end
		// ѭ����Ȩֵ�����̣��������ڿ��ŵ�Ԫ��ȡ�������Ƚϴ�С����Ȩֵ��������¼����
		// �������һ������
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][][] chessBoardWeight = chessboard.getWeightBoard();
		int BOARD_SIZE = chessboard.BOARD_SIZE;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (chessBoardWeight[i][j][1].equals("0")) {
					try {
						if (Integer.parseInt(chessBoardWeight[i][j][0]) >= Integer
								.parseInt(chessBoardWeight[posX][posY][0])) {
							// ���Ȩֵ���ߵĻ�����posX��posY�ó�i��j��ֵ
							posX = i;
							posY = j;
						}
					} catch (NumberFormatException e) {
					}
				}
			}
		}
		int[] result = { posX, posY };
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int count = 1;
		String[][] originBoard = this.chessboard.getBoard();
		String[][][] weightBoard = this.chessboard.getWeightBoard();
		// -----------------------------���򿴷�_start---------------------------------
		// ���򿴷�
		for (int x = posX, y = posY - 5; y <= posY; y++) {
			// ����forѭ��

			System.out.println("X:" + x + ",Y:" + y);
			for (int t = y; t <= y + 5; t++) {
				try {
					// ��������������͵����ݾͽ�count++,����count��0
					if (ico.equals(originBoard[x][t]) && !ico.equals(null)) {
						String a = originBoard[x][t];
						count++;
						if (count >= 5) {
							return true;
						} else // ��������������ʱ��ʼ����
						if (count >= 3) {
							// �������Ƿ��أ��������ˣ���ô�������ĸ���������һ�𣬴�ʱ�ҵ�Ϊ�յ�λ�ã�����Ȩֵ��ǿ��߼�
							if (ico.equals("��")) {
								// int temp1=Integer.parseInt(weightBoard[x][t +
								// 1][0])+200;
								// int temp2=Integer.parseInt(weightBoard[x][t -
								// 4][0])+200;
								weightBoard[x][t + 1][0] = "200";
								weightBoard[x][t - 4][0] = "200";
							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// ����ʱ���߽�ʱ���ĸ��Ϳ����ж���Ӯ���뵽�������׳��쳣��count��ֵû�д���
					// ֱ���ۼƵ���һ�μ�������
					count = 0;
				}
			}
		}
		// -----------------------------���򿴷�_start---------------------------------

		// -----------------------------���򿴷�_start---------------------------------

		System.out.println("posX:" + posX + "posY:" + posY);
		for (int x = posX - 5, y = posY; x <= posX; x++) {
			// ����forѭ��

			for (int t = x; t <= x + 5; t++) {
				try {
					// ��������������͵����ݾͽ�count++,����count��0
					if (ico.equals(originBoard[t][y]) && !ico.equals(null)) {
						String a = originBoard[t][y];

						count++;
						if (count >= 5) {
							return true;
						} else // ��������������ʱ��ʼ����
						if (count >= 3) {
							// �������Ƿ��أ��������ˣ���ô�������ĸ���������һ�𣬴�ʱ�ҵ�Ϊ�յ�λ�ã�����Ȩֵ��ǿ��߼�
							if (ico.equals("��")) {
								weightBoard[t + 1][y][0] = "200";
								weightBoard[t - 4][y][0] = "200";
							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// ����ʱ���߽�ʱ���ĸ��Ϳ����ж���Ӯ���뵽�������׳��쳣��count��ֵû�д���
					// ֱ���ۼƵ���һ�μ�������
					count = 0;
				}
			}
		}
		// -----------------------------���򿴷�_start---------------------------------
		// -----------------------------б�򿴷�_start�����ϵ����£�---------------------------------

		for (int x = posX - 5, y = posY - 5; x <= posX; x++, y++) {
			// ����forѭ��

			System.out.println("X:" + x + "Y:" + y);
			for (int t = x, p = y; t <= x + 5; t++, p++) {
				try {
					// ��������������͵����ݾͽ�count++,����count��0
					if (ico.equals(originBoard[t][p]) && !ico.equals(null)) {
						String a = originBoard[t][p];

						count++;
						if (count >= 5) {
							return true;
						} else // ��������������ʱ��ʼ����
						if (count >= 3) {
							// �������Ƿ��أ��������ˣ���ô�������ĸ���������һ�𣬴�ʱ�ҵ�Ϊ�յ�λ�ã�����Ȩֵ��ǿ��߼�
							if (ico.equals("��")) {
								// �߽��飬��ֹ�µ��������
								if (t + 1 >= this.chessboard.BOARD_SIZE - 1
										|| y + 1 >= this.chessboard.BOARD_SIZE - 1) {
									weightBoard[this.chessboard.BOARD_SIZE - 1][this.chessboard.BOARD_SIZE - 1][0] = "200";
								} else {
									// int aa = Integer
									// .parseInt(weightBoard[t + 1][p + 1][0]);
									// int b = aa + 200;
									weightBoard[t + 1][p + 1][0] = "200";
									weightBoard[t - 4][y - 4][0] = "200";
								}// �߽��飬��ֹ�µ��������

							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// ����ʱ���߽�ʱ���ĸ��Ϳ����ж���Ӯ���뵽�������׳��쳣��count��ֵû�д���
					// ֱ���ۼƵ���һ�μ�������
					count = 0;
				}
			}
		}
		// -----------------------------���򿴷�_start�����ϵ����£�---------------------------------
		// -----------------------------б�򿴷�_start�����ϵ����£�---------------------------------

		for (int x = posX + 5, y = posY - 5; x >= posX; x--, y++) {
			// ����forѭ��

			for (int t = x, p = y; t >= x - 5; t--, p++) {
				try {
					// ��������������͵����ݾͽ�count++,����count��0
					if (ico.equals(originBoard[t][p]) && !ico.equals(null)) {
						String a = originBoard[t][p];
						count++;
						if (count >= 5) {
							return true;
						} else // ��������������ʱ��ʼ����
						if (count >= 3) {
							// �������Ƿ��أ��������ˣ���ô�������ĸ���������һ�𣬴�ʱ�ҵ�Ϊ�յ�λ�ã�����Ȩֵ��ǿ��߼�
							if (ico.equals("��")) {
								weightBoard[t - 1][p + 1][0] = "200";
								weightBoard[t + 4][y - 4][0] = "200";
							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// ����ʱ���߽�ʱ���ĸ��Ϳ����ж���Ӯ���뵽�������׳��쳣��count��ֵû�д���
					// ֱ���ۼƵ���һ�μ�������
					count = 0;
				}

			}
		}
		// -----------------------------���򿴷�_start�����ϵ����£�---------------------------------
		return false;

		// �ۼӣ���������ͷ���true
	}

	// ��ӡȨֵ������ʹ��
	public void printChessBoard() {
		String[][][] res = this.chessboard.getWeightBoard();
		int BOARD_SIZE = this.chessboard.BOARD_SIZE;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(res[i][j][0] + "&");
				// chessBoardWeight[i][j][0] = "0";
				// chessBoardWeight[i][j][1] = "0";
			}
			System.out.println("-----------------------------------");
		}
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();

	}
}
