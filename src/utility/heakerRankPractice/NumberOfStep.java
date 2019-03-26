package utility.heakerRankPractice;

import java.util.Arrays;

public class NumberOfStep {

	private static final long MOD = 1000000007;

	public static int stepPerms(int maxHeight) {

		long[] count = new long[maxHeight + 3];
		count[0] = 0;
		count[1] = count[2] = count[3] = 1;
		int height = 0;
		while (height < maxHeight) {
			long currentCount = count[height];
			count[height + 1] = (currentCount + count[height + 1]);
			count[height + 2] = (currentCount + count[height + 2]);
			count[height + 3] = (currentCount + count[height + 3]);
			height++;
		}
		System.out.println(Arrays.toString(count));
		return (int)count[maxHeight];

	}

	public static void main(String[] args) {
		// 5
		System.out.println(stepPerms(35));
		
		System.out.println((((181997601 + 334745777) % MOD) + 615693474) %MOD );
		//System.out.println(stepPerms(30));
		//System.out.println(stepPerms(33));
		//System.out.println(stepPerms(36));
		//System.out.println(stepPerms(20));
	}

}
