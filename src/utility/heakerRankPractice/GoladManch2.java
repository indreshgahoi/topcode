package utility.heakerRankPractice;

public class GoladManch2 {

	static int[] usedNumber = new int[10];
	static Integer result = Integer.MAX_VALUE;

	static void solve(String number, int lastDigit, int currentIndex, int targetLength, int currentNumber) {

		if ((currentIndex + 1) == targetLength) {
			result = Math.min(result, currentNumber);
			return;
		}
		char currentChar = number.charAt(currentIndex);

		if (currentChar == 'M') {
			for (int i = 1; i < lastDigit; ++i) {
				if (usedNumber[i] == 0) {
					usedNumber[i] = 1;
					solve(number, i, currentIndex + 1, targetLength, (currentNumber * 10 + i));
					usedNumber[i] = 0;
				}
			}
		} else {
			for (int i = lastDigit + 1; i < 10; i++) {
				if (usedNumber[i] == 0) {
					usedNumber[i] = 1;
					solve(number, i, currentIndex + 1, targetLength, (currentNumber * 10 + i));
					usedNumber[i] = 0;
				}

			}
		}

	}

	static void reset() {
		for (int i = 1; i < 10; i++) {
			usedNumber[i] = 0;
		}
	}

	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		reset();
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < 10; ++i) {
			usedNumber[i] = 1;
			solve(pattern, i, 0, pattern.length() + 1, i);
			usedNumber[i] = 0;
			ans = Math.min(ans, result);
		}
		if (result == Integer.MAX_VALUE) {
			return -1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findPossibleSmallestNumberMatchingPattern("MNMNMNMN"));
	}
}
