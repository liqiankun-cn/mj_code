/**
 * 
 */
package com.for22.mjcp.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽奖模拟  TODO 准确率待优化
 * 
 * @author liqiankun
 *
 */
public class TestGetScore {

	/**
	 * 分数和比例值
	 */
	static List<Integer> bl = new ArrayList<>();
	static List<Integer[]> score = new ArrayList<>();

	static {
		//比例之和100，按顺序存放
		bl.add(10);
		bl.add(20);
		bl.add(60);
		bl.add(10);
		
		score.add(new Integer[] { -5, 0 });
		score.add(new Integer[] { 1, 2 });
		score.add(new Integer[] { 3, 7 });
		score.add(new Integer[] { 8, 10 });
		
		// -5,0占比10
		// 1, 2占比20
		// 3, 7占比60
		// 8, 10占比10
	}
	static List<Integer[]> rescore = new ArrayList<>();
	
	static{
		int sumbl = 0;
		for(int i=0;i<bl.size();i++){
			int blnum = bl.get(i);
			if(i==0)
				rescore.add(i,new Integer[]{0,blnum});
			else
				rescore.add(i,new Integer[]{sumbl,sumbl+blnum});
			sumbl += blnum;
		}
		
		//进行区间大小排序,区间值最大拍最前面
		
		
	}
	
	/**
	 * 抽奖方法
	 * 
	 * @return
	 */
	static int getScore() {
		
		int sc = 0;
		Random r = new Random();
		//0-100之间的证书
		int dr = (int)(r.nextDouble()*100);
		// 查找随机数dr在比例数据集合中满足的最大区间
		// 如：占比0.7 则随机数需要为 大于1-0.7=0.3以上的数字
		Integer[] nums = null;
		int index = 0;
		Integer[] match = null;
		for (Integer[] ina:rescore) {
			if (ina[1]>=dr && ina[0]<=dr) {
				match = ina;
				break;
			}
			index++;
		}
		System.out.println("random num is "+dr+",match from "+match[0]+" to "+match[1]+",match index is "+index);
		// 计算分数值
		nums = score.get(index);
		System.out.println("the random num is "+ dr);
		int max = nums[1];
		int min = nums[0];
		sc = (int)Math. random() * max % (max - min + 1) + min;
		return sc;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("------------");
		for(Integer[] it :rescore){
			System.out.println(it[0]+","+it[1]);
		}
		System.out.println("------------");
		
		int i0=0;
		int i1=0;
		int i2=0;
		int i3=0;
		for(int i=0;i<1000;i++){
			System.out.print("第"+i+"次抽奖:");
			int s = getScore();
			System.out.println(s+"分");
			if(s <=0)
				i0++;
			else if(s >=1 && s<=2)
				i1++;
			else if(s >=3 && s<=7)
				i2++;
			else if(s >=8 && s<=10)
				i3++;
		}
		
		System.out.println("比例为:");
		System.out.println("-5, 0 >>> "+i0+"次");
		System.out.println("1, 2 >>> "+i1+"次");
		System.out.println("3, 7 >>> "+i2+"次");
		System.out.println("8, 10 >>> "+i3+"次");
		
	}

}
