
public class test {
    public static int clueForGuessAndWord(String guess, String word)
	{
		int clue = 0;
		for(int count = 0; count < guess.length(); count++)
		{
			if (guess.charAt(count) == word.charAt(count))
				clue = (clue * 10) + 3;//se a letra de indice count da palavra for igual a letra de indice count da palavra secreta adiciona 3 ao clue
			else if (word.contains(String.valueOf(guess.charAt(count))))// verifica se a word contem a letra de indice count do guess
			{
				boolean found = false;
				int whileCount = 0;
				while(whileCount < count && !found)
				{//procura a letra e verifica que se encontra antes da letra de indice count do guess
					if (guess.charAt(whileCount) == guess.charAt(count) && guess.charAt(whileCount) != word.charAt(whileCount))
					{//compara cada letra antes e verifica tambem se a pista da letra foi 3(se estava no sitio certo) 
						clue = (clue * 10) + 1;
						found = true;
					}
					whileCount++;
				}
				if (!found)
					clue = (clue * 10) + 2;
			}
			else
				clue = (clue * 10) + 1;
		}
		return (clue);
	}
    public static void main(String[] args)
    {
        System.out.println(clueForGuessAndWord("abacabi", "abacaxi"));
        // segundo b tem de ser 1??
    }
}
