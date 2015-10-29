package com.ly.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		// 初始化棋盘权值
		chessboard.initChessBoardWeight();
		chessboard.printBoard();
		// 初始化棋牌权值数组

		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			// isOver = false;(自己注释的觉得没必要有)
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out
					.println("------------------------------------------------------");
			this.printChessBoard();
			System.out
					.println("------------------------------------------------------");
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		// 老师给的随机代码start
		// int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// String[][] board = chessboard.getBoard();
		// while (board[posX][posY] != "十") {
		// posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// }
		// int[] result = { posX, posY };
		// 老师给的随机代码end
		// 循环带权值的棋盘，将棋盘内空着的元素取出来并比较大小，将权值大的坐标记录下来
		// 先随机给一个坐标
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
							// 如果权值更高的话，将posX和posY置成i与j的值
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
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int count = 1;
		String[][] originBoard = this.chessboard.getBoard();
		String[][][] weightBoard = this.chessboard.getWeightBoard();
		// -----------------------------横向看法_start---------------------------------
		// 横向看法
		for (int x = posX, y = posY - 5; y <= posY; y++) {
			// 两层for循环

			System.out.println("X:" + x + ",Y:" + y);
			for (int t = y; t <= y + 5; t++) {
				try {
					// 如果存在这样类型的内容就将count++,否则count置0
					if (ico.equals(originBoard[x][t]) && !ico.equals(null)) {
						String a = originBoard[x][t];
						count++;
						if (count >= 5) {
							return true;
						} else // 黑子连城三个的时候开始防守
						if (count >= 3) {
							// 仅仅考虑防守，黑棋是人，那么黑棋有四个可以连在一起，此时找到为空的位置，白棋权值增强最高级
							if (ico.equals("●")) {
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

					// 测试时到边界时，四个就可以判断我赢，想到可能是抛出异常后count的值没有处理，
					// 直接累计到下一次计算中了
					count = 0;
				}
			}
		}
		// -----------------------------横向看法_start---------------------------------

		// -----------------------------竖向看法_start---------------------------------

		System.out.println("posX:" + posX + "posY:" + posY);
		for (int x = posX - 5, y = posY; x <= posX; x++) {
			// 两层for循环

			for (int t = x; t <= x + 5; t++) {
				try {
					// 如果存在这样类型的内容就将count++,否则count置0
					if (ico.equals(originBoard[t][y]) && !ico.equals(null)) {
						String a = originBoard[t][y];

						count++;
						if (count >= 5) {
							return true;
						} else // 黑子连城三个的时候开始防守
						if (count >= 3) {
							// 仅仅考虑防守，黑棋是人，那么黑棋有四个可以连在一起，此时找到为空的位置，白棋权值增强最高级
							if (ico.equals("●")) {
								weightBoard[t + 1][y][0] = "200";
								weightBoard[t - 4][y][0] = "200";
							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// 测试时到边界时，四个就可以判断我赢，想到可能是抛出异常后count的值没有处理，
					// 直接累计到下一次计算中了
					count = 0;
				}
			}
		}
		// -----------------------------竖向看法_start---------------------------------
		// -----------------------------斜向看法_start（左上到右下）---------------------------------

		for (int x = posX - 5, y = posY - 5; x <= posX; x++, y++) {
			// 两层for循环

			System.out.println("X:" + x + "Y:" + y);
			for (int t = x, p = y; t <= x + 5; t++, p++) {
				try {
					// 如果存在这样类型的内容就将count++,否则count置0
					if (ico.equals(originBoard[t][p]) && !ico.equals(null)) {
						String a = originBoard[t][p];

						count++;
						if (count >= 5) {
							return true;
						} else // 黑子连城三个的时候开始防守
						if (count >= 3) {
							// 仅仅考虑防守，黑棋是人，那么黑棋有四个可以连在一起，此时找到为空的位置，白棋权值增强最高级
							if (ico.equals("●")) {
								// 边界检查，防止下到棋局外面
								if (t + 1 >= this.chessboard.BOARD_SIZE - 1
										|| y + 1 >= this.chessboard.BOARD_SIZE - 1) {
									weightBoard[this.chessboard.BOARD_SIZE - 1][this.chessboard.BOARD_SIZE - 1][0] = "200";
								} else {
									// int aa = Integer
									// .parseInt(weightBoard[t + 1][p + 1][0]);
									// int b = aa + 200;
									weightBoard[t + 1][p + 1][0] = "200";
									weightBoard[t - 4][y - 4][0] = "200";
								}// 边界检查，防止下到棋局外面

							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// 测试时到边界时，四个就可以判断我赢，想到可能是抛出异常后count的值没有处理，
					// 直接累计到下一次计算中了
					count = 0;
				}
			}
		}
		// -----------------------------竖向看法_start（左上到右下）---------------------------------
		// -----------------------------斜向看法_start（右上到左下）---------------------------------

		for (int x = posX + 5, y = posY - 5; x >= posX; x--, y++) {
			// 两层for循环

			for (int t = x, p = y; t >= x - 5; t--, p++) {
				try {
					// 如果存在这样类型的内容就将count++,否则count置0
					if (ico.equals(originBoard[t][p]) && !ico.equals(null)) {
						String a = originBoard[t][p];
						count++;
						if (count >= 5) {
							return true;
						} else // 黑子连城三个的时候开始防守
						if (count >= 3) {
							// 仅仅考虑防守，黑棋是人，那么黑棋有四个可以连在一起，此时找到为空的位置，白棋权值增强最高级
							if (ico.equals("●")) {
								weightBoard[t - 1][p + 1][0] = "200";
								weightBoard[t + 4][y - 4][0] = "200";
							}
						}
					} else {
						count = 0;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

					// 测试时到边界时，四个就可以判断我赢，想到可能是抛出异常后count的值没有处理，
					// 直接累计到下一次计算中了
					count = 0;
				}

			}
		}
		// -----------------------------竖向看法_start（右上到左下）---------------------------------
		return false;

		// 累加，够了五个就返回true
	}

	// 打印权值表，测试使用
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
