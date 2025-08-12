import java.util.Scanner;
import java.util.Random;

public class Tic {
	static Scanner input=new Scanner(System.in);
	static void board(char[] a) {
		System.out.println();
		System.out.print("     |     |     \n");
		System.out.print("  "+a[0]+"  |  "+a[1]+"  |  "+a[2]+"  \n");
		System.out.print("_____|_____|_____\n");
		System.out.print("     |     |     \n");
		System.out.print("  "+a[3]+"  |  "+a[4]+"  |  "+a[5]+"  \n");
		System.out.print("_____|_____|_____\n");
		System.out.print("     |     |     \n");
		System.out.print("  "+a[6]+"  |  "+a[7]+"  |  "+a[8]+"  \n");
		System.out.print("     |     |     \n");
	}
	
	static void playerMove(char[] a,char player) {
		int n;
		do {
			System.out.println("Enter number from (1-9): ");
			n=input.nextInt();
			n--;
			if(a[n]=='O') {
				playerMove(a,player);
			}
			if(a[n]==' ') {
				a[n]=player;
				break;
			}
		}while(!(n>0)||!(n<8));
	}
	
	static void computerMove(char[] a,char computer) {
		Random random=new Random();
		int n;
		do {
			n=(random.nextInt())%9;
			if((n>=0)&&(n<=8)&&(a[n]==' ')) {
				a[n]=computer;
				break;
			}
		}while(true);
	}
	
	public static boolean winner(char[] a,char player,char computer) {
		if((a[0]!=' ')&&(a[0]==a[1])&&(a[0]==a[2])) {
			System.out.print((a[0]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[3]!=' ')&&(a[3]==a[4])&&(a[3]==a[5])) {
			System.out.print((a[3]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[6]!=' ')&&(a[6]==a[7])&&(a[6]==a[8])) {
			System.out.print((a[6]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[1]!=' ')&&(a[1]==a[4])&&(a[1]==a[7])) {
			System.out.print((a[1]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[0]!=' ')&&(a[0]==a[3])&&(a[0]==a[6])) {
			System.out.print((a[0]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[2]!=' ')&&(a[2]==a[5])&&(a[2]==a[8])) {
			System.out.print((a[2]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[0]!=' ')&&(a[0]==a[4])&&(a[0]==a[8])) {
			System.out.print((a[0]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[2]!=' ')&&(a[2]==a[4])&&(a[2]==a[6])) {
			System.out.print((a[2]==player)?("You Won!"):("You Loose!"));
			return true;
		}
		else if((a[0]!=' ')&&(a[1]!=' ')&&(a[2]!=' ')&&(a[3]!=' ')&&(a[4]!=' ')&&(a[5]!=' ')&&(a[6]!=' ')&&(a[7]!=' ')&&(a[8]!=' ')) {
			System.out.print("It's a Tie!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		char player='X',computer='O';
		char a[]= {' ',' ',' ',' ',' ',' ',' ',' ',' '};
		int l=a.length;
		boolean running=true;
		board(a);
		while(running!=false) {
			playerMove(a,player);
			board(a);
			if(winner(a,player,computer)) {
				running=false;
				return;
			}
			
			computerMove(a,computer);
			board(a);
			if(winner(a,player,computer)) {
				running=false;
				return;
			}
		}
	}
}
