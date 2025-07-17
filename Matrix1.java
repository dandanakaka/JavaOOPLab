import java.util.Scanner;

class matrix{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int[][] matrix = new int[3][3];
	for(int I; I<3; i++){
		for(int j; j<3; j++){
			matrix[i][j] = sc.nextInt();
		}
		}

	for(int I; I<3; i++){
		for(int j; j<3; j++){
			System.out.println(matrix[i][j]);
		}
		System.out.println();
		}
}

}
