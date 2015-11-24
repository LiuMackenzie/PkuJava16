package fiveChesses;
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

		
		int a = 2;
		int count = 0;
		while(a>=-2){
			//��������
			if(x-a>0 && x-a<15 && y+a>0 && y+a<15 && bd[x-a][y+a]=="��"){
				a--;
				count++;
				if(count==3 && x-a>0 && x-a<15 && y+a>0 && y+a<15 && bd[x-a][y+a]=="ʮ"){
					int[] res={x-a,y+a};
					return res;
				}
				if(count==3 && x-a>0 && x-a<15 && y+a>0 && y+a<15 && bd[x-a+4][y+a-4]=="ʮ"){
					int[] res={x-a+4, y+a-4};
					return res;
				}
			}else{
				a--;
				count = 0;
			}
			//����
			if(x>0 && x<15 && y+a>0 && y+a<15 && bd[x][y+a]=="��"){
				a--;
				count++;
				if(count==3 && x-a>0 && x-a<15 && y+a>0 && y+a<15 && bd[x][y+a]=="ʮ"){
					int[] res = {x,y+a};
					return res;
				}
				if(count==3 && x-a>0 && x-a<15 && y+a>0 && y+a<15 && bd[x][y+a-4]=="ʮ"){
					int[] res = {x,y+a-4};
					return res;
				}
				
			}else{
				a--;
				count = 0;
			}
			//��������
			if(x+a>0 && x+a<15 && y+a>0 && y+a<15 &&bd[x+a][y+a]=="��"){
				a--;
				count++;
				if(count==3 && x+a>0 && x+a<15 && y+a>0 && y+a<15 &&bd[x+a][y+a]=="ʮ"){
					int[] res = {x+a,y+a};
					return res;
				}
				if(count==3 && x+a>0 && x+a<15 && y+a>0 && y+a<15 &&bd[x+a-4][y+a-4]=="ʮ"){
					int[] res = {x+a-4,y+a-4};
					return res;
				}
			}else{
				a--;
				count = 0;
			}
			//����
			if(x+a>0 && x+a<15 && y>0 && y<15 &&bd[x+a][y]=="��"){
				a--;
				count++;
				if(count==3 && x+a>0 && x+a<15 && y>0 && y<15 &&bd[x+a][y]=="ʮ"){
					int[] res = {x+a,y};
					return res;
				}
				if(count==3 && x+a>0 && x+a<15 && y>0 && y<15 &&bd[x+a-4][y]=="ʮ"){
					int[] res = {x+a-4,y};
					return res;
				}
			}else{
				a--;
				count = 0;
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
		int a = WIN_COUNT-1;
		int count = 0;
		while(a>=-4){
			//��������
			if(posX-a>0 && posX-a<15 && posY+a>0 && posY+a<15 && bd[posX-a][posY+a]==ico){
				a--;
				count++;
				if(count==WIN_COUNT){
					return true;
				}
			}else{
				a--;
				count = 0;
			}
			//����
			if(posX>0 && posX<15 && posY+a>0 && posY+a<15 && bd[posX][posY+a]==ico){
				a--;
				count++;
				if(count==WIN_COUNT){
					return true;
				}
			}else{
				a--;
				count = 0;
			}
			//��������
			if(posX+a>0 && posX+a<15 && posY+a>0 && posY+a<15 &&bd[posX+a][posY+a]==ico){
				a--;
				count++;
				if(count==WIN_COUNT){
					return true;
				}
			}else{
				a--;
				count = 0;
			}
			//����
			if(posX+a>0 && posX+a<15 && posY>0 && posY<15 &&bd[posX+a][posY]==ico){
				a--;
				count++;
				if(count==WIN_COUNT){
					return true;
				}
			}else{
				a--;
				count = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}