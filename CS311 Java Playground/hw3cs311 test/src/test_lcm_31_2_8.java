import java.math.BigInteger;
import java.util.Arrays;


public class test_lcm_31_2_8 {

	public static void main(String[] args) {
		System.out.println("lcm : " + lcm(new int[]{330, 65, 15, 11, 12}));

	}
	private static int gcdThing(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	static int lcm(int A[]){
		int acc = A[0];
		for (int i = 1; i < A.length; i++)
			acc = lcm_help(acc, A[i]);
		return acc;
	}
	
	static int lcm_help(int a, int b){
			return (a * b) / gcdThing(a,b);
		}
	/*
	public static int lcm(int a[]){
		int test = (int)Math.floor(((double)(a.length))/2);
		int l[] = Arrays.copyOfRange(a, 0, (int)Math.floor(((double)(a.length))/2));
		int r[] = Arrays.copyOfRange(a, (int)Math.ceil(((double)(a.length-1))/2), a.length);
		return lcm_help(l,r);
	}
	
	public static int lcm_help(int l[], int r[]){
		if(l.length == 1 && r.length == 1)
				return (l[0] * r[0]) / gcdThing(l[0],r[0]);
		else if (l.length == 1 && r.length == 0)
				return r[0];
		else if (r.length == 1 && l.length == 0)
			return r[0];
		else
		{
				int left_half_lcm = lcm_help(Arrays.copyOfRange(l, 0, (int)Math.floor(((double)(l.length))/2)), Arrays.copyOfRange(l, (int)Math.ceil(((double)(l.length-1))/2), l.length));
				int right_half_lcm = lcm_help(Arrays.copyOfRange(r, 0, (int)Math.floor(((double)(r.length))/2)), Arrays.copyOfRange(r, (int)Math.ceil(((double)(r.length-1))/2), r.length));

				return (left_half_lcm * right_half_lcm) / gcdThing(left_half_lcm, right_half_lcm);
		}
	}
	*/
}
