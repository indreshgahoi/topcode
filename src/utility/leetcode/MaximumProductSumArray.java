package utility.leetcode;

public class MaximumProductSumArray {

	public int maxProduct(int[] A) {
		int max_product = Integer.MIN_VALUE;
		int max_pos_prod, max_neg_prod;
		max_pos_prod = max_neg_prod = 0;
		for (int i = 0; i < A.length; ++i) {

			if (A[i] > 0) {
				if (max_pos_prod == 0) {
					max_pos_prod = A[i];
				} else {
					max_pos_prod *= A[i];
				}
				max_neg_prod = max_neg_prod * A[i];

				max_product = Math.max(max_product, max_pos_prod);
			} else if (A[i] < 0) {
				int t = max_pos_prod;
				max_pos_prod = max_neg_prod * A[i];
				max_neg_prod = Math.min(t * A[i], A[i]);
				if (max_pos_prod == 0) {
					max_product = Math.max(max_product, max_neg_prod);
				} else {
					max_product = Math.max(max_product, max_pos_prod);
				}
			} else {
				max_pos_prod = 0;
				max_neg_prod = 0;
				max_product = Math.max(max_product, A[i]);
			}

		}
		return max_product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
