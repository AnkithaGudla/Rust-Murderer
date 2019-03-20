import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		char c=s.next().charAt(0);
		int result=calci(a,b,c);
		System.out.println(result);
	}
public static int calci(int a,int b,char c)
{
	
switch(c)
{
case '+':return a+b;
case '*':return a*b;
case '/':return a/b;
}
return 0;
}
}
