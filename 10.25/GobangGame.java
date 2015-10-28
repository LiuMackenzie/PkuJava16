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
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
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
		/*计算机随机下棋
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
		*/
		//先判断上一个下的棋子有没有连成三个以上的，如果有，就在两头任选一端堵；没有可堵的话就随机下棋
		int x = chessboard.lastX;
		int y = chessboard.lastY;
		String[][] bd = chessboard.getBoard();
		int[][] wvalue = new int[16][16];
		int[][] bvalue = new int[16][16];
		int a1 = 3;
		int a2 = 3;
		int a3 = 3;
		int a4 = 3;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		while(a1>=-3){
			//左上右下
			if(x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="●"){
				a1--;
				count1++;
				if(count1==3 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="十"){
					int[] res={x-a1,y+a1};
					return res;
				}
				if(count1==3 && x-a1+4>0 && x-a1+4<15 && y+a1-4>0 && y+a1-4<15 && bd[x-a1+4][y+a1-4]=="十"){
					int[] res={x-a1+4, y+a1-4};
					return res;
				}
				if(count1==4 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="十"){
					int[] res={x-a1,y+a1};
					return res;
				}
				if(count1==4 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="○"){
					if(x-a1+5>0 && x-a1+5<15 && y+a1-5>0 && y+a1-5<15 && bd[x-a1+5][y+a1-5]=="十"){
						int[] res={x-a1+5,y+a1-5};
						return res;
					}
				}
			}else{
				a1--;
				count1 = 0;
			}
			//上下
			if(x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="●"){
				a2--;
				count2++;
				if(count2==3 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="十"){
					int[] res = {x,y+a2};
					return res;
				}
				if(count2==3 && x>0 && x<15 && y+a2-4>0 && y+a2-4<15 && bd[x][y+a2-4]=="十"){
					int[] res = {x,y+a2-4};
					return res;
				}
				if(count2==4 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="十"){
					int[] res = {x,y+a2};
					return res;
				}
				if(count2==4 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="○"){
					if(y+a2-5>0 && y+a2-5<15 && bd[x][y+a2-5]=="十"){
						int[] res = {x,y+a2-5};
						return res;
					}
				}
				
			}else{
				a2--;
				count2 = 0;
			}
			//右上左下
			if(x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="●"){
				a3--;
				count3++;
				if(count3==3 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="十"){
					int[] res = {x+a3,y+a3};
					return res;
				}
				if(count3==3 && x+a3-4>0 && x+a3-4<15 && y+a3-4>0 && y+a3-4<15 && bd[x+a3-4][y+a3-4]=="十"){
					int[] res = {x+a3-4,y+a3-4};
					return res;
				}
				if(count3==4 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="十"){
					int[] res = {x+a3,y+a3};
					return res;
				}
				if(count3==4 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="○"){
					if(x+a3-5>0 && x+a3-5<15 && y+a3-5>0 && y+a3-5<15 && bd[x+a3-5][y+a3-5]=="十"){
						int[] res = {x+a3-5,y+a3-5};
						return res;
					}
				}
			}else{
				a3--;
				count3 = 0;
			}
			//左右
			if(x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="●"){
				a4--;
				count4++;
				if(count4==3 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="十"){
					int[] res = {x+a4,y};
					return res;
				}
				if(count4==3 && x+a4-4>0 && x+a4-4<15 && y>0 && y<15 &&bd[x+a4-4][y]=="十"){
					int[] res = {x+a4-4,y};
					return res;
				}
				if(count4==4 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="十"){
					int[] res = {x+a4,y};
					return res;
				}
				if(count4==4 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="○"){
					if(x+a4-5>0 && x+a4-5<15 &&bd[x+a4-5][y]=="十"){
						int[] res = {x+a4-5,y};
						return res;
					}
				}
			}else{
				a4--;
				count4 = 0;
			}
		}
		
		int X = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int Y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[X][Y] != "十") {
			X = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			Y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] res = { X, Y };
		
		return res;
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
		String bd[][] = chessboard.getBoard();
		/*
		int i = 2;
		while(i>0){
			if(bd[posX-i][posY+i]==ico&&bd[posX+i][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//左上右下
			}else if(i==2 && bd[posX-i][posY+i]!=ico && bd[posX+i][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX][posY+i]==ico&&bd[posX][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//上下
			}else if(i==2 && bd[posX][posY+i]!=ico&&bd[posX][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX+i][posY+i]==ico||bd[posX-i][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//右上左下
			}else if(i==2 && bd[posX+i][posY+i]!=ico && bd[posX-i][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX+i][posY]==ico&&bd[posX-i][posY]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//左右
			}else if(i==2 && bd[posX+i][posY]!=ico&&bd[posX-i][posY]!=ico){
				return false;
			}
		}
		*/
		int a1 = WIN_COUNT-1;
		int a2 = WIN_COUNT-1;
		int a3 = WIN_COUNT-1;
		int a4 = WIN_COUNT-1;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		while(a1>=-4){
			//左上右下
			if(posX-a1>0 && posX-a1<15 && posY+a1>0 && posY+a1<15 && bd[posX-a1][posY+a1]==ico){
				a1--;
				count1++;
				if(count1==WIN_COUNT){
					return true;
				}
			}else{
				a1--;
				count1 = 0;
			}
			//上下
			if(posX>0 && posX<15 && posY+a2>0 && posY+a2<15 && bd[posX][posY+a2]==ico){
				a2--;
				count2++;
				if(count2==WIN_COUNT){
					return true;
				}
			}else{
				a2--;
				count2 = 0;
			}
			//右上左下
			if(posX+a3>0 && posX+a3<15 && posY+a3>0 && posY+a3<15 &&bd[posX+a3][posY+a3]==ico){
				a3--;
				count3++;
				if(count3==WIN_COUNT){
					return true;
				}
			}else{
				a3--;
				count3 = 0;
			}
			//左右
			if(posX+a4>0 && posX+a4<15 && posY>0 && posY<15 &&bd[posX+a4][posY]==ico){
				a4--;
				count4++;
				if(count4==WIN_COUNT){
					return true;
				}
			}else{
				a4--;
				count4 = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
