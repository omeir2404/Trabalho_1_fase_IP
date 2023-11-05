/*
 * @authors: Omeir Haroon, Matilde Brandão
 */

import java.util.Dictionary;
import java.lang.Math;

public class Ipurdle_Azula {
	public static void main(String[] args)
	{
		System.out.println("Boa sorte!");
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
		System.out.println("antes " + minClue);

		for(int i = 1; i < size; i++){
			minClue *= 10 ;
			minClue++;
			System.out.println("after " + minClue);
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
}
