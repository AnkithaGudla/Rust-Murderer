import java.util.Scanner;

public class House {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("select\n1.Standard materials\n2.Above standard materials\n3.High standard materials\n4.High standard materials and fully automated house")
	;
		int standard=s.nextInt();
		System.out.println("Area of the house");
		double area =s.nextDouble();
		double estimation= houseconstest(standard,area);
		
			System.out.println(estimation)	;
	}
	
	public static double houseconstest(int st, double a)
	{
		switch(st) {
		case 1:return 1200*a;
		case 2:return 1500*a;
		case 3:return 1800*a;
		case 4:return 2500*a;
				
		}
		return 0.0;
	
	}

}
