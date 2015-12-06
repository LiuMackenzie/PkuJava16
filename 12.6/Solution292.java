package solution;

public class Solution292 {
    public boolean canWinNim(int n) {
    	//假设A和B在玩游戏
    	//通过分析得知，当还剩4个石头，且轮到A拿的时候，B一定会赢
    	//以此类推，如果石头范围在5--7时，A都可以控制拿石头的个数，使石头剩四个，可以让自己赢
    	//但是如果剩8个且轮到A拿的时候，则会出现B控制拿石头的个数，使石头剩4个的情况
    	//所以当石头个数为四的倍数的时候，是肯定会输的
    	//所以代码相对于分析过程就简单很多了
    	if(n%4==0){
            return false;
        }
        else{
            return true;
        }
    }
}
