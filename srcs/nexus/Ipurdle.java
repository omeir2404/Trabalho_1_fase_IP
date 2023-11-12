 /**
 * @version: 1.0
 * @author: Omeir Haroon 61810
 * @author Matilde Brandão 61814
 * easy compile: make 
 * easy compile and run: make run (uses default size, maxAttempts and dificulty)
 * custom run: java Ipurdle.java <size> <maxAttempts> <dificulty>
 * Guess the secret word in the least number of attempts
 * You have a maximum of maxAttempts attempts and will be given a clue after each attempt
 */

import java.util.Scanner;

public class Ipurdle
{
	/**
	 * @param dictionary
	 * @requires {@code dictionary != NULL}
	 * @ensures {@code dictionary} is printed to the screen
	 * 
	 */
	public static void showDict(DictionaryIP dictionary)
	{
		System.out.println();
		for (int i = 0; i < dictionary.lenght(); i++)
			System.out.println(dictionary.getWord(i));//busca a palavra de indice i do dicionario e imprime-a
	}

	/**
	 * 
	 * @param clue 
	 * @param size
	 * @requires {@code clue} > 0
	 * @requires {@code size} > 0
	 * @ensures {@code clue} is a valid clue for words of size {@code size}
	 * @return boolean 
	 */
	public static boolean validClue (int clue, int size)
	{
		int count = 1;
		while((clue / 10) > 0) {
			if (clue %  10 != 1 && clue % 10 != 2 && clue % 10 != 3)//verifica se o ultimo digito é 1, 2 ou 3
				return false;
			clue /= 10;// remove o ultimo digito
			count++;
		}
		if(count != size) 
			return false;
		return true;
	}

	/**
	 * @param size
	 * @requires {@code size > 0}
	 * @ensures {@code minClue} is the smallest clue for words of size {@code size}
	 * @return the minimum clue for words of size {@code size}
	 */
	public static int minClue(int size) {
		int minClue = 1;

		for(int i = 1; i < size; i++)
			minClue = (minClue * 10) + 1;//adiciona um digito um no final do minClue (ex minclue = 111, 111 x 10 = 1110 + 1 = 1111) size vezes
		return minClue;
	}

		/**
	 * @param size
	 * @requires {@code size > 0}
	 * @ensures {@code maxClue} is the biggest clue for words of size {@code size}
	 * @return the maximum clue for words of size {@code size}
	 */
	public static int maxClue(int size) {
		return (minClue(size) * 3);// o maximo clue é o minimo clue vezes 3(ex minClue = 111, maxClue = 111 x 3 = 333)
	}

    /**
     * 
     * @param clue
	 * @param size
     * @requires {@code clue} is a valid clue for words of size {@code size}
     * @requires {@code size > 0}
	 * @ensures {@code isMaxClue} is true if {@code clue} is the maximum clue for words of size {@code size}
     * @return boolean
     */
    public static boolean isMaxClue(int clue, int size) {
		return (clue == maxClue(size));// se o clue for igual ao maxClue retorna true senao retorna false
    }

	/**
	 * @param clue
	 * @param size
	 * @requires {@code clue} is a valid clue for words of size {@code size}
	 * @requires {@code size > 0}
	 * @requires {@code clue} is not the maximum clue for words of size {@code size}
	 * @ensures {@code nextClue} is the next clue for words of size {@code size}
	 * @return the next valid clue for words of size {@code size}
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
                if (i == 0)// se o carry for falso e i for 0, o utlimo digito do clue é 1 ou 2 entao so precisamos de adicionar 1
                    return ((clue + 1));
                else
                    return (((clue + 1) * (int)Math.pow(10,i) + minClue(i))); // se o carry for falso e i for diferente de 0, foram cortados digitos 3 do clue, entao adicionamos 1 ao clue e adicionamos o minClue(i) para adicionar os digitos 1 que foram cortados
            }
            clue/=10;// remove o ultimo digito por ser 3
            i++;
        }
		return -1;// nunca vai chegar aqui se o codigo acima estiver certo
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
		StringBuilder colouredGuess = new StringBuilder();// cria um StringBuilder para guardar a palavra com as cores
		String color = StringColouring.RED;// guarda a cor da letra(foi colocado como default red para nao dar erro na compilacao)
		for(int i = 0; i < guess.length(); i++)
		{
			int totalDigits = (int)Math.log10(clue);// guarda o numero de digitos do clue
			int digit = (int)(clue / Math.pow(10, totalDigits - i)) % 10;// guarda o digito do clue que corresponde a letra de indice i da palavra
			if (digit == 1)
				color = StringColouring.RED;
			if (digit == 2)
				color = StringColouring.YELLOW;
			if (digit == 3)
				color = StringColouring.GREEN;
			colouredGuess.append(StringColouring.toColoredString(String.valueOf(guess.charAt(i)), color));//coloca 	a letra de indice i da palavra com a cor correspondente no StringBuilder
		}
		System.out.println(colouredGuess);
	}

	/**
	 * 
	 * @param letter
	 * @param word
	 * @param stop
	 * @requires {@code word != NULL}
	 * @requires {@code stop} <= {@code word.length()}
	 * @requires {@code letter != NULL}
	 * @ensures {@code countOccurrences} is the number of occurrences of {@code letter} in {@code word} up to the position {@code stop} of word
	 * @return
	 */
	public static int countOccurrences(char letter, String word, int stop)
	{
		int count = 0;
		for(int i = 0; i < stop; i++)
		{
			if (word.charAt(i) == letter)// sempre que a letra do word de indice i for igual a letra adiciona 1 ao count
				count++;
		}
		return (count);
	}

	/**
	 * @param {@code guess}
	 * @param {@code word}
	 * @requires {@code guess} and {@code word} have the same length
	 * @ensures {@code clue} is a valid clue for {@code guess} when comparing to {@code word}
	 * @return the clue for {@code guess} when comparing to {@code word}
	 */
    public static int clueForGuessAndWord(String guess, String word)
	{
		int clue = 0;
		for(int count = 0; count < guess.length(); count++)
		{
			clue *= 10;//como o clue é um inteiro, para adicionar um digito no final do clue temos de multiplicar por 10
			if (guess.charAt(count) == word.charAt(count))
				clue += 3;//se a letra de indice count do guess for igual a letra de indice count do word adiciona 3 ao clue
			else if (countOccurrences(guess.charAt(count), word, word.length()) > 0)// se a letra de indice count da palavra esta no word
			{
				if (countOccurrences(guess.charAt(count), word, word.length()) == 1) // se a letra de indice count da palavra so aparece uma vez no word
				{
					if (countOccurrences(guess.charAt(count), guess, count) > 0)
						clue += 1; // se foi encontrado antes (na posicao certa ou nao) adiciona 1 ao clue
					else
						clue += 2; //se for a primeira vez que ocorre adiciona 2 ao clue
				}
				else
					clue += 2;// se houver mais do que uma letra igual no word adiciona 2 ao clue
			}
			else
				clue += 1;// ultimo caso adiciona 1 ao clue
		}
		return (clue);
	}
	/**
	 * @param {@code dictionary}
	 * @param {@code clue}
	 * @requires {@code dictionary != NULL}
	 * @requires {@code clue} contains a valid clue for all words in {@code dictionary}
	 * @requires {@gcode guess} has the correct length
	 * @ensures {@code howManyWordsWithClue} is the number of words in {@code dictionary} that have {@code clue} as a clue for {@code guess}
	 * @return the number of words in {@code dictionary} that have {@code clue} as a clue
	 */
	public static int howManyWordsWithClue(DictionaryIP dictionary, int clue, String guess)
	{
		int count = 0;
		for(int i = 0; i < dictionary.lenght(); i++)
		{
			if (clueForGuessAndWord(guess, dictionary.getWord(i)) == clue)//sempre que a pista dada pela funcao clueForGuessAndWord for igual ao clue adiciona 1 ao count
				count++;
		}
		return count;
	}

	/**
	 * @param {@code dictionary}
	 * @param {@code guess}
	 * @requires {@code dictionary != NULL}
	 * @requires {@code guess} has the correct length
	 * @ensures {@code betterClueForGuess} is the best clue for {@code guess} in {@code dictionary}(i.e. the clue that corresponds the most words in {@code dictionary})
	 * @return the best clue for {@code guess} in {@code dictionary}
	 */
	public static int betterClueForGuess(DictionaryIP dictionary, String guess)
	{
		int bestClue = -1;//a pista que corresponde ao maior numero de palavras
		int bestCount = -1;//o maior numero de palavras com a pista bestClue
		int clue ;
		int count = 0;

		if (dictionary.lenght() == 1 && dictionary.isValid(guess))// se houver uma palavra no dicionario(neste caso o puzzlesDictionary) e esse palavra é o guess retorna maxClue
			return (maxClue(guess.length()));
		for (clue = minClue(guess.length()); clue < maxClue(guess.length()); clue = nextClue(clue, guess.length()))// percoree todas as pistas validas possiveis
		{
			count = howManyWordsWithClue(dictionary, clue, guess);
			if (count > bestCount)// se o count for maior que o bestCount atualiza o bestCount e o bestClue
			{
				bestCount = count;
				bestClue = clue;
			}
		}
		return bestClue;
	}

	/**
	 * @param {@code dictionary}
	 * @param {@code guess}
	 * @requires {@code dictionary != NULL}
	 * @requires {@code guess} has the correct length
	 * @ensures {@code playGuess} removes all words from {@code dictionary} that do not have {@code clue}(the best clue accordong to betterClueForGuess) as a clue for {@code guess}
	 * @return the best clue for {@code guess} in {@code dictionary}
	 */
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

	/**
	 * @param size
	 * @param maxAttempts
	 * @ensures the rules of the game are printed to the screen
	 */
	public static void printRules(int size, int maxAttempts, int dificulty)
	{
		System.out.println("Bem vindo ao jogo Ipurdle!");
		System.out.print("letras que não estão na palavra ");
		printClue("red", 111);
		System.out.print("letras no sitio errado ");
		printClue("yellow", 222222);
		System.out.print("letras no sitio certo ");
		printClue("green", 33333);
		System.out.println("Neste jogo as palavras têm tamanho "  + size +". O dicionário tem apenas palavras em inglês relacionadas com IP.");
		System.out.println("Tens "+ maxAttempts + " tentavias para advinhar a palavra. O nivel da dificuldade do jogo é: " + dificulty +"Boa sorte!");
	}
	/**
	 * @param args
	 * @requires {@code args.length} <= 3
	 * @ensures the game is played with the correct size, maxAttempts and dificulty
	 * 
	 */
	public static void main(String[] args)
    {
		int maxAttempts = 6;
		int size = 5;
		int i = 0;
		int dificulty = 3;
		int clue = minClue(size);
		if (args.length > 0)//verifica se foi dado um tamanho diferente do default
		size = Integer.parseInt(args[0]);
		if (args.length > 1)//verifica se foi dado um numero de tentativas diferente do default
		maxAttempts = Integer.parseInt(args[1]);
		if (args.length > 2)// verifica se foi dado uma dificuldade diferente do default
			dificulty = Integer.parseInt(args[2]);
		printRules(size, maxAttempts, dificulty);//imprime as informacoes do jogo
		DictionaryIP gameWordsDictionary = new DictionaryIP(size);
		DictionaryIP puzzlesDictionary = new DictionaryIP(size);
		Scanner guessInput = new Scanner(System.in);
		if (dificulty == 2)
			showDict(puzzlesDictionary);// dificuldade 2 mostra o dicionario so uma vez no inicio do jogo
        while (i < maxAttempts && !isMaxClue(clue, size))
        {
			if (dificulty == 1)// dificuldade 1 mostra o dicionario a cada tentativa com as alteracoes feitas ao longo dad tentativas anteriores
				showDict(puzzlesDictionary);
            System.out.print("Palavra a jogar? ");// pede a palavra
            String guess = guessInput.nextLine();
			guess = guess.toUpperCase();// coloca a palavra em maiusculas
            if (guess.length() == size)//verifica se a palavra tem o tamanho certo
			{
				if (!gameWordsDictionary.isValid(guess))// verifica se a palavra esta no dicionario inicial (o que a torna válida)
				{
					i--;// diminuir para depois aumentar e nao contar como tentativa
					System.out.println("Palavra Invalida. Nao existe no dicionario.");
				}
				else
				{
					clue = playGuess(puzzlesDictionary, guess);//faz a jogada e guarda a melhor pista (que corresponde a todas as palavras restantes)
					System.out.print("Palavra com a pista > ");
					printClue(guess, clue);
					if (isMaxClue(clue, size))// verifica se a pista é maxima e se sim acaba o jogo com sucesso
					{
						System.out.println("Parabens, encontraste a palavra secreta!");
						guessInput.close();
						return ;
					}
				}
			}
			else
			{
				i--;// diminuir para depois aumentar e nao contar como tentativa
				System.out.println("Palavra Invalida. Tamanho errado.");
			}
			i++;
		}
		System.out.println("Perdeste! :( boa sorte para a proxima :)");
		guessInput.close();
    }
}
