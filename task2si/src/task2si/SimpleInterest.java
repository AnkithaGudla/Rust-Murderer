package task2si;

import java.util.Scanner;
import java.lang.Math;
public class SimpleInterest {
	public static void main(String[] args)
	{
		Scanner s =new Scanner(System.in);
		int principal=s.nextInt();
		double rate=s.nextDouble();
		int time=s.nextInt();
		int numofcompounds=s.nextInt();
		double siresult=simpleint(principal,rate,time);
		double ciresult=compoundint(principal,rate,time,numofcompounds);
		System.out.println(siresult);
		System.out.println(ciresult);
	}	
		
public static double simpleint(int p,double r,int t) {
	double si;
	si=p*(1+r*t);
	return si;		}

public static double compoundint(int p,double r,int t, int n) {
	double ci;
	ci=p*Math.pow((1+r/n),n*t) - p;
	return ci;
}
		
	

}
