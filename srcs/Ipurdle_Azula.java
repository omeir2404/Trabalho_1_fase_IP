/*
 * @authors: Omeir Haroon, Matilde Brandão
 */

import java.util.Dictionary;
import java.lang.Math;

public class Ipurdle_Azula {
	public static void main(String[] args)
	{
		System.out.println("Boa sorte!");
		// testNextClue();
		printClue("HELLO", 32131);
	}

	/**
	 * 
	 * @param clue 
	 * @requires {@code clue} > 0
	 * @param size
	 * @requires {@code size} > 0
	 * Vai verificar se a pista é válida
	 * @return boolean 
	 */
	public static boolean validClue (int clue, int size) {
		int count = 1;
		int clueHolder = clue;
		while((clue / 10) > 0) {
			clue /= 10; 
			count++;
		}
		clue = clueHolder;
		System.out.println(count+ " " + size);
		if(count == size) {
			for (int i = 0; i < size; i++){
				if (clue %  10 == 1 || clue % 10 == 2 || clue % 10 == 3 )
					clue /= 10; 
				else
					return false;

			}

			return true;
		}

		return false;
	}


	/**
	 * @param size
	 * @requires {@code size > 0}
	 * Vai receber um tamanho e vai devolver a pista mínima para aquela palavra
	 * @return int
	 */
	public static int minClue(int size) {
		int minClue = 1;
	
		for(int i = 1; i < size; i++){
			minClue *= 10 ;
			minClue++;

		}
		return minClue;
	}

	/**
	 * 
	 * @param clue
	 * @requires clue representa uma pista para palavras de tamanho size 
	 * @param size
	 * @requires {@code size > 0}
	 * @return boolean
	 */
	public static boolean isMaxClue(int clue, int size) {
		for(int i = 0; i < size; i++){
			if (clue % 10 == 3 ){
				clue /= 10; 
			}	
			else
				return false;
			
		}
		return true;
}

	/**
	 * @param clue
	 * @requires representa uma pista para palavras de tamanho size e clue não é a maior pista para palavras de tamanho size
	 * @param size
	 * @requires {@code size > 0}
	 * @return
	 */
	public static int nextClue(int clue, int size) {
		if( clue % 10 == 1 || clue % 10 == 2) {
			clue++;
			return clue;
		}
		else {
			int counter = 0;
			while(clue % 10 == 3){
			counter++;
			clue /= 10;

			}
			return((clue + 1)*(int)Math.pow(10,counter)+minClue(counter));
			
		}

	}

	/**
	 * @param guess
	 * @requieres != 0
	 * @param clue
	 * @requieres número inteiro clue que se assume representar uma pista para guess
	 *  imprime guess com as suas letras coloridas de acordo com a clue. Devem ser coloridas a verde as letras 
		que na pista têm 3, a amarelo as letras que na pista têm 2 e a preto as letras que na pista têm 1.
	 * @return
	 */
	 public static void printClue (String guess, int clue) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < guess.length(); i++){
			if(Character.getNumericValue(Integer.toString(clue).charAt(i)) == 3){
				sb.append(StringColouring.toColoredString((Character.toString(guess.charAt(i))), StringColouring.GREEN));
			}
			if(Character.getNumericValue(Integer.toString(clue).charAt(i)) == 2){
				sb.append(StringColouring.toColoredString((Character.toString(guess.charAt(i))), StringColouring.YELLOW));
			}
			if(Character.getNumericValue(Integer.toString(clue).charAt(i)) == 1){
				sb.append(StringColouring.toColoredString((Character.toString(guess.charAt(i))), StringColouring.RED));
			}
		}
		System.out.println(sb);
		return ;
	}
}
