import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
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
	int biggest = 9999999;
	int oneFour = 8888888;
	int twoThrees = 7777777;
	double[] lineN={0, 20, 17, 15.4, 14, 10};
	
	private int resNum(int i,int j, String chess){
		String[][] board =chessboard.getBoard(); 
		int bef = 0, bet = 0;
		int L,mid,m1,m2;
		//��������
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
		boolean first = j+m1<15 && board[i][j+m1]=="ʮ";
		boolean second = j-m2>=0 && board[i][j-m2]=="ʮ";
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
		
		//��������
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
		first = i+m1<15 && board[i+m1][j]=="ʮ";
		second = i-m2>=0 && board[i-m2][j]=="ʮ";
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
		//������������
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
		first = j+m1<15 && i+m1<15 && board[i+m1][j+m1]=="ʮ";
		second = j-m2>=0 && i-m2>=0 && board[i-m2][j-m2]=="ʮ";
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
		
		//������������
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
		first = i+m1<15 && j-m1>=0 && board[i+m1][j-m1]=="ʮ";
		second = i-m2>=0 && j+m2<15 && board[i-m2][j+m2]=="ʮ";
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
		//���������ĸ���������ʱ���������ı���
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
		//"��"Ϊ�û�,1��"��"Ϊ�����,-1��
		//���ҷ���
		nPos[1] = 1;
		A1 = 0;
		mid = 1;
		while (j+mid<maxN && (board[i][j+mid] == chess || board[i][j+mid]=="ʮ")) {
			nPos[1]++;
			if(board[i][j+mid]=="��"){
				A1 += lineN[mid];
			}
			if(board[i][j+mid]=="��"){
				A1 += lineN[mid]*(-1);
			}
			mid++;
		}
		//���������һ���ڵ��ǶԷ����ӣ���ô�������λ�õ���һ��Ҳû�������ˣ�������Ҫ��СȨֵ
		if (j+mid>=15 ||( board[i][j+mid] != chess && board[i][j+mid] != "ʮ")) {
			if(board[i][j+mid-1] == chess){
				if(chess=="��"){
					A1 -= lineN[5];
				}
				if(chess=="��"){
					A1 -= lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (j-mid>=minN && (board[i][j-mid] == chess || board[i][j-mid]=="ʮ")) {
			nPos[1]++;
			if(board[i][j-mid]=="��"){
				A1 += lineN[mid];
			}
			if(board[i][j-mid]=="��"){
				A1 += lineN[mid]*(-1);
			}
			mid++;
		}
		if (j-mid<0 || ( board[i][j-mid] != chess && board[i][j-mid] != "ʮ")) {
			if(board[i][j-mid+1] == chess){
				if(chess=="��"){
					A1 -= lineN[5];
				}
				if(chess=="��"){
					A1 -= lineN[5]*(-1);
				}
			}
		}
		//���·���
		nPos[2] = 1;
		A2 = 0;
		mid = 1;
		while (i+mid<maxM &&( board[i+mid][j] == chess || board[i+mid][j]=="ʮ")) {
			nPos[2]++;
			if(board[i+mid][j]=="��"){
				A2 += lineN[mid];
			}
			if(board[i+mid][j]=="��"){
				A2 +=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || board[i+mid][j] != chess && board[i+mid][j] !="ʮ") {
			if (board[i+mid-1][j] == chess){
				if(chess=="��"){
					A2 -= lineN[5];
				}
				if(chess=="��"){
					A2 -= lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && ( board[i-mid][j] == chess || board[i-mid][j]=="ʮ")) {
			nPos[2]++;
			if(board[i-mid][j]=="��"){
				A2 += lineN[mid];
			}
			if(board[i-mid][j]=="��"){
				A2 +=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || board[i-mid][j] != chess && board[i-mid][j] !="ʮ") {
			if (board[i-mid+1][j] == chess){
				if(chess=="��"){
					A2 -= lineN[5];
				}
				if(chess=="��"){
					A2 -= lineN[5]*(-1);
				}
			}
		}
		//��������
		nPos[3] = 1;
		A3 = 0;
		mid = 1;
		while (i+mid<maxM && j+mid<maxN && (board[i+mid][j+mid] == chess || board[i+mid][j+mid] == "ʮ")) {
			nPos[3]++;
			if(board[i+mid][j+mid]=="��"){
				A3+=lineN[mid];
			}
			if(board[i+mid][j+mid]=="��"){
				A3+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || j+mid>=15 || board[i+mid][j+mid] != chess && board[i+mid][j+mid] != "ʮ") {
			if(board[i+mid-1][j+mid-1] == chess){
				if(chess=="��"){
					A3-=lineN[5];
				}
				if(chess=="��"){
					A3-=lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && j-mid>=minN && (board[i-mid][j-mid] == chess || board[i-mid][j-mid] == "ʮ")) {
			nPos[3]++;
			if(board[i-mid][j-mid]=="��"){
				A3+=lineN[mid];
			}
			if(board[i-mid][j-mid]=="��"){
				A3+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || j-mid<0 || board[i-mid][j-mid] != chess && board[i-mid][j-mid] != "ʮ") {
			if(board[i-mid+1][j-mid+1] == chess){
				if(chess=="��"){
					A3-=lineN[5];
				}
				if(chess=="��"){
					A3-=lineN[5]*(-1);
				}
			}
		}
		//��������
		nPos[4] = 1;
		A4 = 0;
		mid = 1;
		while (i+mid<maxM && j-mid>=minN && (board[i+mid][j-mid] == chess || board[i+mid][j-mid] == "ʮ")) {
			nPos[4]++;
			if(board[i+mid][j-mid]=="��"){
				A4+=lineN[mid];
			}
			if(board[i+mid][j-mid]=="��"){
				A4+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i+mid>=15 || j-mid<0 || board[i+mid][j-mid] != chess && board[i+mid][j-mid] != "ʮ") {
			if(board[i+mid-1][j-mid+1]==chess){
				if(chess=="��"){
					A4-=lineN[5];
				}
				if(chess=="��"){
					A4-=lineN[5]*(-1);
				}
			}
		}
		mid = 1;
		while (i-mid>=minM && j+mid<maxN && (board[i-mid][j+mid] == chess || board[i-mid][j+mid] == "ʮ")) {
			nPos[4]++;
			if(board[i-mid][j+mid]=="��"){
				A4+=lineN[mid];
			}
			if(board[i-mid][j+mid]=="��"){
				A4+=lineN[mid]*(-1);
			}
			mid++;
		}
		if (i-mid<0 || j+mid>=15 || board[i-mid][j+mid] != chess && board[i-mid][j+mid] != "ʮ") {
			if(board[i-mid+1][j+mid-1]==chess){
				if(chess=="��"){
					A4-=lineN[5];
				}
				if(chess=="��"){
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
	 * ���������
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
		//����ÿ��λ�õ�Ȩֵ
		for(int i = 0; i<15;i++){
			for(int j=0;j<15;j++){
				//�������Ӳ�Ϊ�գ��Ͳ��ü������λ�õ�Ȩֵ��
				if(board[i][j]!="ʮ"){
					CScore[i][j]=-1;
					continue;
				}
				//������λ����Χ�˸�λ�ö��ǿգ�˵������������������Χ���壬����Ҳ������Ȩֵ
				if (i>0 && j>0 && j+1<15 && i+1<15){
					if(board[i][j+1]=="ʮ"&&board[i+1][j+1]=="ʮ"&&board[i+1][j]=="ʮ"
							&&board[i+1][j-1]=="ʮ"&&board[i][j-1]=="ʮ"&&board[i-1][j-1]=="ʮ"
							&&board[i-1][j]=="ʮ"&&board[i-1][j+1]=="ʮ"){
						CScore[i][j]=-1;
						continue;
					}
				}
				cV=this.resNum(i, j, "��");
				hV=this.resNum(i, j, "��");
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
