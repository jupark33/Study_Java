class BS {
		public int binarySearch(int a[], int value, int left, int right) {
		    int m = (left + right) / 2;
			
			if (value == a[m]) 
			    return m;
			else if (value < a[m] && left < m)
			    return binarySearch(a, value, left, m - 1);
			else if (value > a[m] && m < right)
			    return binarySearch(a, value, m + 1, right);
			else
				return -1; // Not found
		}
	
	    public static void main(String[] args) {
		    int[] a = {1,2,3,4,5,6,7,8,9,10};
			
			BS bs = new BS();
			int found = bs.binarySearch(a, 9, 0, 9);
			sysout("bs result : " + a[found]);
		}
	}