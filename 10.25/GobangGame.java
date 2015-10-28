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
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
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
		/*������������
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
		*/
		//���ж���һ���µ�������û�������������ϵģ�����У�������ͷ��ѡһ�˶£�û�пɶµĻ����������
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
			//��������
			if(x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="��"){
				a1--;
				count1++;
				if(count1==3 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="ʮ"){
					int[] res={x-a1,y+a1};
					return res;
				}
				if(count1==3 && x-a1+4>0 && x-a1+4<15 && y+a1-4>0 && y+a1-4<15 && bd[x-a1+4][y+a1-4]=="ʮ"){
					int[] res={x-a1+4, y+a1-4};
					return res;
				}
				if(count1==4 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="ʮ"){
					int[] res={x-a1,y+a1};
					return res;
				}
				if(count1==4 && x-a1>0 && x-a1<15 && y+a1>0 && y+a1<15 && bd[x-a1][y+a1]=="��"){
					if(x-a1+5>0 && x-a1+5<15 && y+a1-5>0 && y+a1-5<15 && bd[x-a1+5][y+a1-5]=="ʮ"){
						int[] res={x-a1+5,y+a1-5};
						return res;
					}
				}
			}else{
				a1--;
				count1 = 0;
			}
			//����
			if(x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="��"){
				a2--;
				count2++;
				if(count2==3 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="ʮ"){
					int[] res = {x,y+a2};
					return res;
				}
				if(count2==3 && x>0 && x<15 && y+a2-4>0 && y+a2-4<15 && bd[x][y+a2-4]=="ʮ"){
					int[] res = {x,y+a2-4};
					return res;
				}
				if(count2==4 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="ʮ"){
					int[] res = {x,y+a2};
					return res;
				}
				if(count2==4 && x>0 && x<15 && y+a2>0 && y+a2<15 && bd[x][y+a2]=="��"){
					if(y+a2-5>0 && y+a2-5<15 && bd[x][y+a2-5]=="ʮ"){
						int[] res = {x,y+a2-5};
						return res;
					}
				}
				
			}else{
				a2--;
				count2 = 0;
			}
			//��������
			if(x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="��"){
				a3--;
				count3++;
				if(count3==3 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="ʮ"){
					int[] res = {x+a3,y+a3};
					return res;
				}
				if(count3==3 && x+a3-4>0 && x+a3-4<15 && y+a3-4>0 && y+a3-4<15 && bd[x+a3-4][y+a3-4]=="ʮ"){
					int[] res = {x+a3-4,y+a3-4};
					return res;
				}
				if(count3==4 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="ʮ"){
					int[] res = {x+a3,y+a3};
					return res;
				}
				if(count3==4 && x+a3>0 && x+a3<15 && y+a3>0 && y+a3<15 &&bd[x+a3][y+a3]=="��"){
					if(x+a3-5>0 && x+a3-5<15 && y+a3-5>0 && y+a3-5<15 && bd[x+a3-5][y+a3-5]=="ʮ"){
						int[] res = {x+a3-5,y+a3-5};
						return res;
					}
				}
			}else{
				a3--;
				count3 = 0;
			}
			//����
			if(x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="��"){
				a4--;
				count4++;
				if(count4==3 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="ʮ"){
					int[] res = {x+a4,y};
					return res;
				}
				if(count4==3 && x+a4-4>0 && x+a4-4<15 && y>0 && y<15 &&bd[x+a4-4][y]=="ʮ"){
					int[] res = {x+a4-4,y};
					return res;
				}
				if(count4==4 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="ʮ"){
					int[] res = {x+a4,y};
					return res;
				}
				if(count4==4 && x+a4>0 && x+a4<15 && y>0 && y<15 &&bd[x+a4][y]=="��"){
					if(x+a4-5>0 && x+a4-5<15 &&bd[x+a4-5][y]=="ʮ"){
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
		while (board[X][Y] != "ʮ") {
			X = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			Y = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] res = { X, Y };
		
		return res;
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
		String bd[][] = chessboard.getBoard();
		/*
		int i = 2;
		while(i>0){
			if(bd[posX-i][posY+i]==ico&&bd[posX+i][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//��������
			}else if(i==2 && bd[posX-i][posY+i]!=ico && bd[posX+i][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX][posY+i]==ico&&bd[posX][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//����
			}else if(i==2 && bd[posX][posY+i]!=ico&&bd[posX][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX+i][posY+i]==ico||bd[posX-i][posY-i]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//��������
			}else if(i==2 && bd[posX+i][posY+i]!=ico && bd[posX-i][posY-i]!=ico){
				return false;
			}
			
			if(bd[posX+i][posY]==ico&&bd[posX-i][posY]==ico){
				i--;
				if(i==0){
					return true;
				}
				continue;//����
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
			//��������
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
			//����
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
			//��������
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
			//����
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
