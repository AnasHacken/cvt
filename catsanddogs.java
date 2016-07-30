// cats and dog solution 

import java.util.*;

public class catsanddogs {
 public static boolean bol = true;
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = 0;
		while(s.hasNext()){
			String z = s.next();
			z.trim();
			if(z != null){
				t = Integer.parseInt(z) +1;
				break;
			}
		}
		
		for(int r=0;r<t -1;r++){
			long m =s.nextLong();
			long n =s.nextLong();
			bol = true;
			Map<ArrayList<Long>,Long> memo = new HashMap<ArrayList<Long>,Long>();
			
		    
			long ans = dp(m,n,memo);
			if(bol == true){
			System.out.println(ans);
			}else{
				System.out.println(-1);	
			}
		   
		}
		
		
		s.close();
	}
	
	public static long dp(long m,long n,Map<ArrayList<Long>,Long> memo){
		long w=0;
		if(m == n){
			w =1;
		}else if(n == (m-1) || m == (n-1)){
			w =1;
		}else if((n == 1 && m > 2) || (n > 2 && m == 1)){
			w =0;
			bol = false;
            return 0;
		}else {
			long m1=0;
			long n1=0;
			long m2=0;
			long n2=0;
			if(m%2 == 0) {
				m1 = m/2;
				m2 = m/2;
			}else{
				m1 = m/2;
				m2 = m/2 +1;
			}
			if(n%2 == 0) {
				n1 = n/2;
				n2 = n/2;
			}else{
				n1 = n/2;
				n2 = n/2 +1;
			}
			ArrayList<Long> temp1 = new ArrayList<Long>();
			temp1.add(m1);
			temp1.add(n1);
			ArrayList<Long> temp2 = new ArrayList<Long>();
			temp2.add(m2);
			temp2.add(n2);
			long d1 =0;
			long d2 =0;
			if(memo.containsKey(temp1)){
				d1 = memo.get(temp1);
			}else{
				d1 = dp(m1,n1,memo);
			}
			if(memo.containsKey(temp2)){
				d2 = memo.get(temp2);
			}else{
				d2 = dp(m2,n2,memo);
			}
			w = d1 + d2;
		}
		
		return w;
	}
}
