package edu.pht.strings;

public class Task11_add {//с цифрами - чтоб понять, что как должно располагаться

	public static void main(String[] args) {
		int n = 4;
		/*int k = 1;
		int[][] ch = new int[n][n];
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				ch[i][j] = k++;
			}
		}*/
		char[][] ch = { {'I','l','o','v'}, {'e', 'l', 'i', 'f', }, {'e', 'a', 'n', 'd'}, {'r', 'e', 's', 't'}};
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------поворот на 90 град по час");
		char tmp;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				tmp = ch[i][j];
				ch[i][j] = ch[n - j - 1][i];
				ch[n - j - 1][i] = ch[n - i - 1][n - j - 1];
				ch[n - i - 1][n - j - 1] = ch[j][n - i - 1];
				ch[j][n - i - 1] = tmp;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------замена 1 строки с посл, 2 с предпосл и тд");
		char box;
		for (int i = 0; i < ch.length / 2; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				box = ch[i][j];
				ch[i][j] = ch[n - i - 1][j];
				ch[n - i - 1][j] = box;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------замена 1 столбца со 2, 3 с 4 и тд");
		char temp;
		for (int j = 0; j < ch.length - 1; j += 2) {
			for (int i = 0; i < ch[j].length; i++) {
				temp = ch[i][j];
				ch[i][j] = ch[i][j + 1];
				ch[i][j + 1] = temp;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------вывод по спирали");
		for (int j = 0, d = n; j <= d; j++, d--)
		{
			for (int i = j; i < d; i++) { System.out.printf("%c ", ch[j][i] ); }
			for (int i = j + 1; i < d; i++) { System.out.printf("%c ", ch[i][n-j-1]); }
			for (int i = j + 1; i < d; i++) { System.out.printf("%c ", ch[n-j-1][n-i-1]); }
			for (int i = j + 1; i < d-1; i++) { System.out.printf("%c ", ch[n - i - 1][j]); }
					
		}
	}
}
