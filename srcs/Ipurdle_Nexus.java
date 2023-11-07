/*
 * @authors: Omeir Haroon, Matilde Brandão
 */

import java.util.Scanner;

public class Ipurdle_Nexus
{
	/**
	 * @param dictionary
	 * @requires {@code dictionary != NULL}
	 * 
	 */
	public static void SHOWDICT(DictionaryIP dictionary)
	{
		System.out.println();
		for (int i = 0; i < dictionary.lenght(); i++)
			System.out.println(dictionary.getWord(i));
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
	public static boolean validClue (int clue, int size)
	{
		int count = 1;
		int clueHolder = clue;
		while((clue / 10) > 0) {
			clue /= 10; 
			count++;
		}
		clue = clueHolder;
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
	 * @param size
	 * @requires {@code size > 0}
	 * Vai receber um tamanho e vai devolver a pista màxima para aquela palavra
	 * @return int
	 */
	public static int maxClue(int size) {
		int minClue = 3;

		for(int i = 1; i < size; i++){
			minClue *= 10 ;
			minClue += 3;
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
	 * size é um número maior que zero, clue representa uma pista para palavras de tamanho size 
	 * e clue não é a maior pista para palavras de tamanho size.
	 */
	public static int nextClue(int clue , int size)
	{
		int i = 0;
		boolean carry = true;
		while (carry)
        {
            carry = (clue % 10) % 3 == 0;
            if (!carry)
            {
                if (i == 0)
                    return ((clue + 1));
                else
                    return (((clue + 1) * (int)Math.pow(10,i) + minClue(i)));
            }
            clue/=10;
            i++;
        }
		return -1;
	}

	/**
	 * @param {@code guess}
	 * @param {@code clue}
	 * @requires {@code guess != NULL}
	 * @requires {@code clue} contains a valid clue for {@code guess}
	 * print the {@code guess} with the the correct colours according to {@code clue}
	 */
	public static void printClue(String guess, int clue)
	{
		StringBuilder colouredGuess = new StringBuilder();
		for(int i = 0; i < guess.length(); i++)
		{
			int totalDigits = (int)Math.log10(clue);
			int digit = (int)(clue / Math.pow(10, totalDigits - i)) % 10;
			if (digit == 1)
			{
				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.RED));
			}
			if (digit == 2)
			{
				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.YELLOW));
			}
			if (digit == 3)
			{
				colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), StringColouring.GREEN));
			}
		}
		System.out.println(colouredGuess);
	}

		/**
		 * assumes {@code guess} and {@code word} have the same length
		 */
	public static int clueForGuessAndWord(String guess, String word)
	{
		int clue = 0;
		for(int i = 0; i < guess.length(); i++)
		{
			if (guess.charAt(i) == word.charAt(i))
			{
				clue += Math.pow(10, guess.length() - i - 1) * 3;
			}
			else if (word.contains(String.valueOf(guess.charAt(i))))
			{
				boolean found = false;
				int j = 0;
				while(j < i && !found)
				{
					if (guess.charAt(j) == guess.charAt(i) && guess.charAt(j) != word.charAt(j))
					{
						clue += Math.pow(10, guess.length() - i - 1) * 1;
						found = true;
					}
					j++;
				}
				if (!found)
					clue += Math.pow(10, guess.length() - i - 1) * 2;
			}
			else
				clue += Math.pow(10,  guess.length() - i - 1) * 1;
		}
		return (clue);
	}

	/**
	 * @param {@code dictionary}
	 * @param {@code clue}
	 * @requires {@code dictionary != NULL}
	 * @requires {@code clue} contains a valid clue for all words in {@code dictionary}
	 * @requires {@gcode guess} has the correct length
	 * print the number of words in {@code dictionary} that have {@code clue} as a clue
	 * @return the number of words in {@code dictionary} that have {@code clue} as a clue
	 */
	public static int howManyWordsWithClue(DictionaryIP dictionary, int clue, String guess)
	{
		int count = 0;
		for(int i = 0; i < dictionary.lenght(); i++)
		{
			if (clueForGuessAndWord(guess, dictionary.getWord(i)) == clue)
				count++;
		}
		return count;
	}

	/**
	 * @param {@code dictionary}
	 * @param {@code guess}~
	 * @requires {@code dictionary != NULL}
	 * @requires {@code guess} has the correct length
	 */
	public static int betterClueForGuess(DictionaryIP dictionary, String guess)
	{
		int bestClue = -1;
		int bestCount = -1;
		int clue = minClue(guess.length());
		int count = 0;

		while (!isMaxClue(clue, Integer.toString(clue).length()))
		{
			count = howManyWordsWithClue(dictionary, clue, guess);
			if (count > bestCount)
			{
				bestCount = count;
				bestClue = clue;
			}
			clue = nextClue(clue, guess.length());
		}
		if (dictionary.lenght() == 1 && dictionary.isValid(guess))
			return (maxClue(guess.length()));
		return bestClue;
	}

    public static int playGuess(DictionaryIP dictionary, String guess){
        int clue =  betterClueForGuess(dictionary, guess);
		for(int i = 0; i < dictionary.lenght(); i++)
		{
			if (clueForGuessAndWord(guess, dictionary.getWord(i)) != clue)
				dictionary.selectForRemove(i);
		}
        dictionary.removeSelected();
        return clue;
    }

	public static void main(String[] args)
    {
		System.out.println("Bem vindo ao jogo Ipurdle!");
		System.out.print("letras que não estão na palavra ");
		printClue("red", 111);
		System.out.print("letras no sitio errado ");
		printClue("yellow", 222222);
		System.out.print("letras no sitio certo ");
		printClue("green", 33333);
		int maxAttempts = 6;
		int size;
		if (args[0] == null)
		{
			size = 5;
		}
		else
			size = Integer.parseInt(args[0]);
		// if (args[1] != null)
		// maxAttempts = Integer.parseInt(args[1]);
			
		System.out.println("Neste jogo as palavras têm tamanho "  + size +". O dicionário tem apenas palavras em inglês relacionadas com IP.");
		System.out.println("Tens "+ maxAttempts + " tentavias para advinhar a palavra. Boa sorte!");
		DictionaryIP gameWordsDictionary = new DictionaryIP(size);
        DictionaryIP puzzlesDictionary = new DictionaryIP(size);
		Scanner guessInput = new Scanner(System.in);
		SHOWDICT(puzzlesDictionary);// para retirar!!|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        for (int i = 1; i <= maxAttempts; i++)
        {
            System.out.print("Palavra a jogar? ");
            String guess = guessInput.nextLine();
			guess = guess.toUpperCase();
            if (guess.length() == size)
			{
				if (!gameWordsDictionary.isValid(guess))
					System.out.println("Palavra Invalida. Nao existe no dicionario.");
				else
				{
					int clue = playGuess(puzzlesDictionary, guess);
					System.out.print("Palavra com a pista > ");
					printClue(guess, clue);
					if (isMaxClue(clue, size))
					{
						System.out.println("Parabens, encontraste a palavra secreta!");
						return ;
					}
				}
			}
			else
				System.out.println("Palavra Invalida. Tamanho errado.");
		}
		guessInput.close();
    }
}
