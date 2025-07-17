import java.util.Scanner;



class HelloWorld{
	public static void main(String[] args){
		System.out.println("Enter the 1st number:");
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		System.out.println("Enter the 2nd number:");
		
		int b = sc.nextInt();
		
		System.out.println("Enter the operation:");
		char op = sc.next().charAt(0);
		
		if (op == '+') {
		int out = a + b;
		System.out.println(out);
		
		}
		
		
		else if (op == '-') {
		int out = a-b;
		System.out.println(out);
		 
		 }
		 
		 else if(op == '*') {
		 int out = a*b;
		 System.out.println(out);
		 
		 }
		 
		 else if(op == '/') {
		 int out = a/b;
		 System.out.println(out);
		 
		 }
		 
		


		
}

}
