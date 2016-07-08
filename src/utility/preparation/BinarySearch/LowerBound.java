package utility.preparation.BinarySearch;

import java.util.ArrayList;

public class LowerBound {

	int lower_bound(int a[], int key) {
		int l = 0, r = a.length - 1;
		int mid;

		while (l <= r) {
			if ((r - l) <= 1) {
				if (a[l] == key) return l;
				else if (a[r] == key) return r;
					return -1;
			}
			mid = l + (r - l) / 2;
			if (key > a[mid])
				l = mid + 1;
			else
				r = mid;
		}
		return -1;
	}

	int upper_bound(int a[], int key) {
		int l = 0, r = a.length - 1;
		int mid = 0;
		while (l <= r) {
			if ((r - l) <= 1) {
				if (a[r] == key) return r;
				else if (a[l] == key) return l;
					return -1;
			}
			mid = l + (r - l) / 2;
			if (key < a[mid]) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		return -1;
	}

	ArrayList<Integer> rangeSearch(int a[], int key) {
		int s = -1, e = -1;
		s = lower_bound(a, key);
		if (s != -1) {
			e = upper_bound(a, key);
		}
		ArrayList<Integer> list = new ArrayList<>(2);
		list.add(s);
		list.add(e);
		return list;
	}

	public static void main(String[] args) {
		LowerBound lb = new LowerBound();
		int a[] = { 1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6, 6, 6, 6, 9, 9, 9 };
		System.out.println(lb.lower_bound(a, 7));
		System.out.println(lb.lower_bound(a, 2));
		System.out.println(lb.lower_bound(a, 1));
		System.out.println(lb.lower_bound(a, 4));
		System.out.println(lb.lower_bound(a, 6));
	}

}
