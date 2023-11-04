/*
 * @authors: Omeir Haroon, Matilde Brandão
 */

import java.util.Dictionary;
import java.lang.Math;

public class Ipurdle {
	public static void main(String[] args)
	{
		System.out.println("Boa sorte!");
		// System.out.println(validClue(12, 3));
	




		// System.out.println(minClue(4));
		// System.out.println(isMaxClue(333, 3));
		// System.out.println(nextClue(1323, 4));
		// printClue("whats up", 12322323);
		// clueForGuessAndWord("hellao", "hrelpz");
		// testBetterClueForGuess();
		
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


// 	 /* 
// 	public static boolean ValidClue(int clue, int size) {
// 		String clueString = String.valueOf(clue); 
// 		if (clueString.length() != size) {
// 			return false;
// 		}
// 		for (int i = 0; i < clueString.length(); i++) {
// 			char digit = clueString.charAt(i);
// 			if (digit != '1' && digit != '2' && digit != '3') {
// 				return false;
// 			}
// 		}
// 		return true;
// 	}
//
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



// 	public static int minClue(int size) {
// 		String clue = "";
// 		for (int i = 0; i < size; i++) {
// 			clue += "1";
// 		}
// 		return Integer.parseInt(clue);
// 	}

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


// 	public static boolean isMaxClue(int clue, int size) {
// 		String clueString = String.valueOf(clue);
// 		if (!ValidClue(clue, size))
// 			return false;

// 		for (int i = 0; i < clueString.length(); i++) {
// 			char digit = clueString.charAt(i);
// 			if (digit != '3') {
// 				return false;
// 			}
// 		}
// 		System.out.println("is Max clue: " + clueString);
// 		return true;
// 	}

// 	/*public static int nextClue(int clue, int size) {
// 		if (isMaxClue(clue, size))
// 		{
// 			System.out.println("is Max clue: " + clue);
// 			return -1;
// 		}
// 		int nextClue = clue + 1;
// 		System.out.println("next clue start: " + nextClue + "clue start: " + clue);
// 		while (!ValidClue(nextClue, size)) {
// 			nextClue++;
// 		}
	
// 		return nextClue;*/
// 		/**
// 		 * size é um número maior que zero, clue representa uma pista para palavras de tamanho size 
// 		 * e clue não é a maior pista para palavras de tamanho size.
// 		 */
// 	public static int nextClue(int clue , int size)
// 	{
// 		if (isMaxClue(clue, size))
// 		{
// 			System.out.println("is Max clue: " + clue);
// 			return -1;
// 		}
// 		int i =0;
// 		boolean carry;
// 		do
// 			{
// 		carry = (clue%10)%3==0;
		
// 		if (!carry)
// 			return (clue+1) * (int)Math.pow(10,i) + minClue(i);
// 		 clue/=10;
// 		i++;} while (carry);
// 		return -1;
		
// 	}
// 	/**
// 	 * @param {@code guess}
// 	 * @param {@code clue}
// 	 * @requires {@code guess != NULL}
// 	 * @requires {@code clue} contains a valid clue for {@code guess}
// 	 * print the {@code guess} with the the correct colours according to {@code clue}
// 	 */
// 	public static void printClue(String guess, int clue)
// 	{
// 		int clueLength = Integer.toString(clue).length();
// 		StringBuilder colouredGuess = new StringBuilder();
// 		for(int i = 0; i < clueLength; i++)
// 		{
// 			int totalDigits = (int)Math.log10(clue) + 1;
// 			int digit = (int)(clue / Math.pow(10, totalDigits - i - 1)) % 10;
// 			System.out.println("digit: " + digit + " | i: " + i);
// 			if (digit == 1)
// 			{
// 				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.RED));
// 			}
// 			if (digit == 2)
// 			{
// 				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.YELLOW));
// 			}
// 			if (digit == 3)
// 			{
// 				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.GREEN));
// 			}
// 		}
// 		System.out.println(colouredGuess);
// 	}

// 		/**
// 		 * assumes {@code guess} and {@code word} have the same length
// 		 */
// 	public static int clueForGuessAndWord(String guess, String word)// testar Mais!!!!!
// 	{
// 		int clue = 0;
// 		for(int i = 0; i < guess.length(); i++)
// 		{
// 			if (guess.charAt(i) == word.charAt(i))
// 			{
// 				clue += Math.pow(10, guess.length() - i - 1) * 3;
// 			}
// 			else if (word.contains(String.valueOf(guess.charAt(i))))
// 			{
// 				boolean found = false;
// 				for(int j = 0; j < i; j++)
// 				{
// 					if (guess.charAt(j) == guess.charAt(i) && guess.charAt(j) != word.charAt(j))
// 					{
// 						clue += Math.pow(10, guess.length() - i - 1) * 1;
// 						found = true;
// 						break;
// 					}
// 				}
// 				if (!found)
// 					clue += Math.pow(10, guess.length() - i - 1) * 2;
// 			}
// 			else
// 				clue += Math.pow(10,  guess.length() - i - 1) * 1;
// 		}
// 		System.out.println("clue: " + clue + " | word: " + word + " | guess: " + guess);
// 		return (clue);
// 	}

// 	/**
// 	 * @param {@code dictionary}
// 	 * @param {@code clue}
// 	 * @requires {@code dictionary != NULL}
// 	 * @requires {@code clue} contains a valid clue for all words in {@code dictionary}
// 	 * @requires {@gcode guess} has the correct length
// 	 * print the number of words in {@code dictionary} that have {@code clue} as a clue
// 	 * @return the number of words in {@code dictionary} that have {@code clue} as a clue
// 	 */
// 	/*	 
// 	 * 
// 	 public static int howManyWordsWithClue(DictionaryIP dictionary, int clue, String guess)
// 	 {
// 		 int count = 0;
// 		 int i = 0;
// 		 while(dictionary.getWord(i) != null)
// 		 {
// 			 if (clueForGuessAndWord(guess, dictionary.getWord(i)) == clue)
// 				 count++;
// 			 i++;
// 		 }
// 		 System.out.println("count: " + count);
// 		 return count;
// 	 }
// 	*/
// 	public static int howManyWordsWithClue(DictionaryIP dictionary, int clue, String guess)
// 	{
// 		int count = 0;
// 		for(int i = 0; i < dictionary.lenght(); i++)
// 		{
// 			if (clueForGuessAndWord(guess, dictionary.getWord(i)) == clue)
// 				count++;
// 		}
// 		System.out.println("count: " + count);
// 		return count;
// 	}


// 	/**
// 	 * @param {@code dictionary}
// 	 * @param {@code guess}~
// 	 * @requires {@code dictionary != NULL}
// 	 * @requires {@code guess} has the correct length
// 	 */
	
// 	public static int betterClueForGuess(DictionaryIP dictionary, String guess)
// 	{
// 		int bestClue = -1;
// 		int bestCount = -1;
// 		int clue = minClue(guess.length());
// 		int count = 0;

// 		while (!isMaxClue(clue, Integer.toString(clue).length()))
// 		{
// 			count = howManyWordsWithClue(dictionary, clue, guess);
// 			if (count > bestCount)
// 			{
// 				bestCount = count;
// 				bestClue = clue;
// 			}
// 			clue = nextClue(clue, guess.length());
// 		}
// 		return bestClue;
// 	}




// 	private static void testBetterClueForGuess() {
// 		System.out.println ("Testing betterClueForGuess ():");
// 		boolean error = false;

// 		String guess = "TERNS";						 		
// 		String[] words = 										// clue
// 			{"CIGAR", "DWARF", "MAJOR", "RUDDY",				// 11211
// 					"REBUT", "REACT", "RETCH", 			 		// 23211
// 					"SISSY", "BLUSH", "BASIC",			 		// 11112
// 					"HUMPH","FOCAL","CLUCK","CLOCK","CLICK",	// 11111
// 					"TERNS"};							 		// 33333
// 		DictionaryIP dictionary = new DictionaryIP (5, words);

// 		int expectedNum = 11111;
// 		int obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
// 		if (obtainedNum != expectedNum) {
// 			System.out.printf (">>> failed on dictionary1 %n");
// 			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
// 			error = true;
// 		}

// 		String[] words2 = 										// clue
// 			{"CIGAR", "DWARF", "MAJOR", "RUDDY",				// 11211
// 					"REBUT", "REACT", "RETCH", 			 		// 23211
// 					"SISSY", "BLUSH",					 		// 11112
// 					"HUMPH","FOCAL",							// 11111
// 					"TERNS"};							 		// 33333
// 		dictionary = new DictionaryIP (5, words2);

// 		expectedNum = 11211;
// 		obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
// 		if (obtainedNum != expectedNum) {
// 			System.out.printf (">>> failed on dictionary2 %n");
// 			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
// 			error = true;
// 		}
		
// 		String[] words3 = 										// clue
// 			{"CIGAR", "DWARF", 									// 11211
// 					"REBUT", "REACT", 					 		// 23211
// 					"SISSY", "BLUSH",					 		// 11112
// 					"HUMPH","FOCAL",							// 11111
// 					"TERNS"};							 		// 33333
// 		dictionary = new DictionaryIP (5, words3);

// 		expectedNum = 11111;
// 		obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
// 		if (obtainedNum != expectedNum) {
// 			System.out.printf (">>> failed on dictionary2 %n");
// 			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
// 			error = true;
// 		}

// 		System.out.println (error ? "FAIL" : "PASS");	
// 	}
}
