
public class test {

	public static int countOccurrences(char letter, String word, int stop)
	{
		int count = 0;
		for(int i = 0; i < stop; i++)
		{
			if (word.charAt(i) == letter)
				count++;
		}
		return (count);
	}

    public static int clueForGuessAndWord(String guess, String word)
	{
		int clue = 0;
		for(int count = 0; count < guess.length(); count++)
		{
			clue *= 10;
			if (guess.charAt(count) == word.charAt(count))
				clue += 3;//se a letra de indice count da palavra for igual a letra de indice count da palavra secreta adiciona 3 ao clue
			else if (countOccurrences(guess.charAt(count), word, word.length()) > 0)
			{
				if (countOccurrences(guess.charAt(count), word, word.length()) == 1)
				{
					if (countOccurrences(guess.charAt(count), guess, count) > 0)
						clue += 1; // if the letter only occurs once in both word and guess, add 2 to clue
					else
						clue += 2; // if the letter only occurs once in both word and guess, add 2 to clue
				}
				else
					clue += 2;
			}
			else
				clue += 1;
		}
		return (clue);
	}
	public static void testClueForGuessAndWord() {
		System.out.println(clueForGuessAndWord("aaaab", "aaaaa"));
		assert clueForGuessAndWord("abcde", "abcde") == 33333 : "Test case 2 failed";
		assert clueForGuessAndWord("abcde", "edbca") == 22222 : "Test case 3 failed";
		assert clueForGuessAndWord("abcde", "fghij") == 11111 : "Test case 4 failed";
		assert clueForGuessAndWord("aaaab", "aaaaa") == 33331 : "Test case 5 failed";
		assert clueForGuessAndWord("vmaam", "bamaa") == 12231 : "Test case 6 failed";
		assert clueForGuessAndWord("abhda", "dcbae") == 22121 : "Test case 7 failed";
		assert clueForGuessAndWord("abmcm", "emcda") == 21221 : "Test case 8 failed";
		assert clueForGuessAndWord("mbcde", "eabcd") == 12222 : "Test case 9 failed";
		System.out.println("All test cases passed");
	}
	
	public static void main(String[] args) {
		testClueForGuessAndWord();
		System.out.println(clueForGuessAndWord("abacabi", "abacaxi"));
        // segundo b tem de ser 1?? || logo a pista tem de ser 3333313
	}
}
