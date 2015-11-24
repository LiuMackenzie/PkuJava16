import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
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
	int biggest = 9999999;
	int oneFour = 8888888;
	int twoThrees = 7777777;
	double[] lineN={0, 20, 17, 15.4, 14, 10};
	
	private int resNum(int i,int j, String chess){
		String[][] board =chessboard.getBoard(); 
		int bef = 0, bet = 0;
		int L,mid,m1,m2;
		//遍历左右
		L = 1;
		mid = 1;
		while(j+mid<15 && board[i][j+mid] == chess){
			L++;
			mid++;
		}
		m1 = mid;
		mid = 1;
		while(j-mid>=0 && board[i][j-mid] == chess){
			L++;
			mid++;
		}
		m2 = mid;
		if(L>4){
			return biggest;
		}
		boolean first = j+m1<15 && board[i][j+m1]=="十";
		boolean second = j-m2>=0 && board[i][j-m2]=="十";
		if(L==4 &&  (first || second)){
			bet++;
		}
		if(first && second){
			if(L==4){
				bef = 1;
			}
			if(L==3){
				bet++;
			}
		}
		
		//遍历上下
		L = 1;
		mid = 1;
		while(i+mid<15 && board[i+mid][j] == chess){
			L++;
			mid++;
		}
		m1 = mid;
		mid = 1;
		while(i-mid>=0 && board[i-mid][j] == chess){
			L++;
			mid++;
		}
		m2 = mid;
		if(L>4){
			return biggest;
		}
		first = i+m1<15 && board[i+m1][j]=="十";
		second = i-m2>=0 && board[i-m2][j]=="十";
		if(L==4 && (first ||second)){
			bet++;
		}
		if(first && second){
			if(L==4){
				bef = 1;
			}
			if(L==3){
				bet++;
			}
		}
		//遍历左上右下
		L = 1;
		mid = 1;
		while(i+mid<15 && j+mid<15 && board[i+mid][j+mid] == chess){
			L++;
			mid++;
		}
		m1 = mid;
		mid = 1;
		while(j-mid>=0 && i-mid>=0 && board[i-mid][j-mid] == chess){
			L++;
			mid++;
		}
		m2 = mid;
		if(L>4){
			return biggest;
		}
		first = j+m1<15 && i+m1<15 && board[i+m1][j+m1]=="十";
		second = j-m2>=0 && i-m2>=0 && board[i-m2][j-m2]=="十";
		if(L==4 && (first || second)){
			bet++;
		}
		if(first && second){
			if(L==4){
				bef = 1;
			}
			if(L==3){
				bet++;
			}
		}
		
		//遍历右上左下
		L = 1;
		mid = 1;
		while(i+mid<15 && j-mid>=0 && board[i+mid][j-mid] == chess){
			L++;
			mid++;
		}
		m1 = mid;
		mid = 1;
		while(i-mid>=0 && j+mid<15 && board[i-mid][j+mid] == chess){
			L++;
			mid++;
		}
		m2 = mid;
		if(L>4){
			return biggest;
		}
		first = i+m1<15 && j-m1>=0 && board[i+m1][j-m1]=="十";
		second = i-m2>=0 && j+m2<15 && board[i-m2][j+m2]=="十";
		if(L==4 && (first || second)){
			bet++;
		}
		if(first && second){
			if(L==4){
				bef = 1;
			}
			if(L==3){
				bet++;
			}
		}
		if(bef==1){
			return oneFour;
		}
		
		if(bet>=2){
			return twoThrees;
		}
		//当不是三四个子相连的时候进行下面的遍历
		int minM = i-4;
		if(minM<0){
			minM = 0;
		}
		int minN = j-4;
		if (minN<0) {
			minN = 0;
		}
		int maxM = i+5;
		if (maxM>15) {
			maxM = 15;
		}
		int maxN = j+5;
		if (maxN>15) {
			maxN = 15;
		}
		int maxA = -1;
		int nPos[] = new int[5];
		int dirA[] = new int[5];
		int A1, A2, A3, A4;
		int a[][] = new int[15][15];
		for(int p = 0;p<15;p++){
			for (int q = 0 ;q<15;q++){
				a[p][q]=-1;
			}
		}
		//"●"为用户,1，"○"为计算机,-1。
		//左右方向
		nPos[1] = 1;
		A1 = 0;
		mid = 1;
		while (j+mid<maxN && (board[i][j+mid] == chess || board[i][j+mid]=="十")) {
			nPos[1]++;
			if(board[i][j+mid]=="●"){
				A1 += lineN[mid];
			}
			if(board[i][j+mid]=="○"){
				A1 += lineN[mid]*(-1);
			}
			mid++;
		}
		//如果最外面一个节点是对方的子，那么下在这个位置的上一个也没有意义了，所以需要减小权值
		if (j+mid>=15 ||( board[i][j+mid] != chess && board[i][j+mid] != "十")) {
			if(board[i][j+mid-1] == chess){
				if(chess=="●"){
					A1 -= lineN[5];
				}
				if(chess=="○"){
					A1 -= lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (j-mid>=minN && (board[i][j-mid] == chess || board[i][j-mid]=="十")) {
			nPos[1]++;
			if(board[i][j-mid]=="●"){
				A1 += lineN[mid];
			}
			if(board[i][j-mid]=="○"){
				A1 += lineN[mid]*(-1);
			}
			mid++;
		}
		if (j-mid<0 || ( board[i][j-mid] != chess && board[i][j-mid] != "十")) {
			if(board[i][j-mid+1] == chess){
				if(chess=="●"){
					A1 -= lineN[5];
				}
				if(chess=="○"){
					A1 -= lineN[5]*(-1);
				}
			}
		}
		//上下方向
		nPos[2] = 1;
		A2 = 0;
		mid = 1;
		while (i+mid<maxM &&( board[i+mid][j] == chess || board[i+mid][j]=="十")) {
			nPos[2]++;
			if(board[i+mid][j]=="●"){
				A2 += lineN[mid];
			}
			if(board[i+mid][j]=="○"){
				A2 +=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || board[i+mid][j] != chess && board[i+mid][j] !="十") {
			if (board[i+mid-1][j] == chess){
				if(chess=="●"){
					A2 -= lineN[5];
				}
				if(chess=="○"){
					A2 -= lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && ( board[i-mid][j] == chess || board[i-mid][j]=="十")) {
			nPos[2]++;
			if(board[i-mid][j]=="●"){
				A2 += lineN[mid];
			}
			if(board[i-mid][j]=="○"){
				A2 +=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || board[i-mid][j] != chess && board[i-mid][j] !="十") {
			if (board[i-mid+1][j] == chess){
				if(chess=="●"){
					A2 -= lineN[5];
				}
				if(chess=="○"){
					A2 -= lineN[5]*(-1);
				}
			}
		}
		//左上右下
		nPos[3] = 1;
		A3 = 0;
		mid = 1;
		while (i+mid<maxM && j+mid<maxN && (board[i+mid][j+mid] == chess || board[i+mid][j+mid] == "十")) {
			nPos[3]++;
			if(board[i+mid][j+mid]=="●"){
				A3+=lineN[mid];
			}
			if(board[i+mid][j+mid]=="○"){
				A3+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || j+mid>=15 || board[i+mid][j+mid] != chess && board[i+mid][j+mid] != "十") {
			if(board[i+mid-1][j+mid-1] == chess){
				if(chess=="●"){
					A3-=lineN[5];
				}
				if(chess=="○"){
					A3-=lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && j-mid>=minN && (board[i-mid][j-mid] == chess || board[i-mid][j-mid] == "十")) {
			nPos[3]++;
			if(board[i-mid][j-mid]=="●"){
				A3+=lineN[mid];
			}
			if(board[i-mid][j-mid]=="○"){
				A3+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || j-mid<0 || board[i-mid][j-mid] != chess && board[i-mid][j-mid] != "十") {
			if(board[i-mid+1][j-mid+1] == chess){
				if(chess=="●"){
					A3-=lineN[5];
				}
				if(chess=="○"){
					A3-=lineN[5]*(-1);
				}
			}
		}
		//右上左下
		nPos[4] = 1;
		A4 = 0;
		mid = 1;
		while (i+mid<maxM && j-mid>=minN && (board[i+mid][j-mid] == chess || board[i+mid][j-mid] == "十")) {
			nPos[4]++;
			if(board[i+mid][j-mid]=="●"){
				A4+=lineN[mid];
			}
			if(board[i+mid][j-mid]=="○"){
				A4+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || j-mid<0 || board[i+mid][j-mid] != chess && board[i+mid][j-mid] != "十") {
			if(board[i+mid-1][j-mid+1]==chess){
				if(chess=="●"){
					A4-=lineN[5];
				}
				if(chess=="○"){
					A4-=lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && j+mid<maxN && (board[i-mid][j+mid] == chess || board[i-mid][j+mid] == "十")) {
			nPos[4]++;
			if(board[i-mid][j+mid]=="●"){
				A4+=lineN[mid];
			}
			if(board[i-mid][j+mid]=="○"){
				A4+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || j+mid>=15 || board[i-mid][j+mid] != chess && board[i-mid][j+mid] != "十") {
			if(board[i-mid+1][j+mid-1]==chess){
				if(chess=="●"){
					A4-=lineN[5];
				}
				if(chess=="○"){
					A4-=lineN[5]*(-1);
				}
			}
		}
		dirA[1]=(nPos[1]>4)? A1*A1 :0;
		dirA[2]=(nPos[2]>4)? A2*A2 :0;
		dirA[3]=(nPos[3]>4)? A3*A3 :0;
		dirA[4]=(nPos[4]>4)? A4*A4 :0;
		A1 = 0;
		A2 = 0;
		for(int k = 1;k<5;k++){
			if(dirA[k]>=A1){
				A2=A1;
				A1=dirA[k];
			}
		}
		a[i][j]=A1+A2;
		if(a[i][j]>maxA){
			maxA=a[i][j];
		}
		return maxA;
	}
	
	/**
	 * 计算机下棋
	 */
	public int[] computerDo() {

		String[][] board = chessboard.getBoard();
		int[][] CScore = new int[15][15];
		CScore[7][7]=1;
		int maxV = -1;
		int maxN = 0;
		List<Integer> maxI = new ArrayList<Integer>();
		List<Integer> maxJ = new ArrayList<Integer>();
		int cV;
		int hV;
		//计算每个位置的权值
		for(int i = 0; i<15;i++){
			for(int j=0;j<15;j++){
				//如果这个子不为空，就不用计算这个位置的权值了
				if(board[i][j]!="十"){
					CScore[i][j]=-1;
					continue;
				}
				//如果这个位置周围八个位置都是空，说明几乎不可能在其周围下棋，所以也不用算权值
				if (i>0 && j>0 && j+1<15 && i+1<15){
					if(board[i][j+1]=="十"&&board[i+1][j+1]=="十"&&board[i+1][j]=="十"
							&&board[i+1][j-1]=="十"&&board[i][j-1]=="十"&&board[i-1][j-1]=="十"
							&&board[i-1][j]=="十"&&board[i-1][j+1]=="十"){
						CScore[i][j]=-1;
						continue;
					}
				}
				cV=this.resNum(i, j, "○");
				hV=this.resNum(i, j, "●");
				if(cV>=biggest){
					CScore[i][j]=5*cV;
				}else if(cV>=twoThrees){
					CScore[i][j] = (cV>=hV)?cV:hV;
				}else{
					CScore[i][j] = CScore[i][j]+cV+hV;
				}
			}
		}
		for (int i=0; i<15; i++) {
			for (int j=0; j<15; j++) {
				if (CScore[i][j]>maxV) {
					maxV = CScore[i][j];
					maxN = 0;
				}
				if (CScore[i][j] == maxV) {
					maxI.add(maxN, i);
					maxJ.add(maxN, j);
					maxN++;
				}
			}
		}
		int rndN = (int) Math.floor(maxN*Math.random());

		int[] result = { maxI.indexOf(rndN), maxJ.indexOf(rndN) };
		
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
