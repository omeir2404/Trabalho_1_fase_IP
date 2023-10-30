public class Ipurdle{
    public static void main(String[] args)
    {
        System.out.println("Ola, Mundo!");
        System.out.println("Melhor projeto B)");
    }
}


/*
 * Mais concretamente, devem implementar uma classe Ipurdle que inclua:  
 * 
o A definição de uma função chamada validClue que, dados dois números inteiros clue e size, e 
assumindo que size é um número maior que zero, verifica se clue representa uma pista para uma 
palavra com o tamanho size. Note que isto corresponde a verificar as seguintes condições:  
        clue é positivo, clue tem size dígitos, clue é composto apenas pelos dígitos 1, 2 e 3 
e a retornar true se todas as condições se verificarem e false caso contrário. 

o A definição de uma função chamada minClue que, dado um número inteiro size, e assumindo que 
size é um número maior que zero, retorna a menor pista para palavras desse tamanho. 

o A definição de uma função chamada isMaxClue que, dados dois números inteiros clue e size, e 
assumindo que size é um número maior que zero e clue representa uma pista para palavras de 
tamanho size, verifica se clue é a maior pista para palavras desse tamanho. 

o A  definição  de  uma  função  chamada  nextClue  que,  dados  dois  números  inteiros  clue  e  size,  e 
assumindo que 
size é um número maior que zero, clue representa uma pista para palavras de tamanho size 
e clue não é a maior pista para palavras de tamanho size 
calcula o número que representa a pista imediatamente a seguir, ou seja, o menor número inteiro 
maior que clue que representa uma pista para palavras de tamanho size. 

o A definição de um procedimento chamado printClue que, dada uma String guess que se assume 
não ser null e um número inteiro clue que se assume representar uma pista para guess, imprime 
guess com as suas letras coloridas de acordo com a clue. Devem ser coloridas a verde as letras 
que na pista têm 3, a amarelo as letras que na pista têm 2 e a preto as letras que na pista têm 1. 

o A definição de uma função chamada clueForGuessAndWord que, dadas duas Strings guess e word, 
que se assumem ter o mesmo  tamanho, retorna o inteiro que representa a pista a dar à jogada 
guess se a palavra a adivinhar for word. 
No  caso  de  uma  letra  de  word,  que  só  ocorre  uma  vez  nesta  palavra,  estar  em  várias  posições 
erradas  de  guess,  apenas  a  letra  na  posição  mais  à  esquerda  é  identificada  como  letra  certa  na 
posição errada. 

o A  definição  de  uma  função  chamada  howManyWordsWithClue  que,  dado  um  objeto  do  tipo 
DictionaryIP que se assume não ser null, um número inteiro clue que se assume representar uma 
pista para palavras desse dicionário e uma String guess que se assume ter o tamanho certo, retorna 
o número de palavras válidas do dicionário que se fossem a palavra a adivinhar, dariam origem à 
pista clue para guess. 

o A definição de uma função chamada betterClueForGuess que, dado um objeto do tipo 
DictionaryIP, que se assume não ser null e uma String guess que se assume ter o tamanho certo, 
retorna  o  inteiro  que  representa  a  pista  para  guess  que  serve  para  mais  palavras  do  dicionário 
dado. No caso de haver pistas empatadas, dentre estas, é escolhida a menor. 
Note que as pistas podem ser percorridas recorrendo às funções minClue e a nextClue descritas 
acima. A pista calculada diz-se que é a melhor porque é a que torna mais difícil o jogador acertar na 
palavra. 

o A definição de um procedimento chamado playGuess que, dado um objeto do tipo Dictionary que 
se assume não ser null, e uma String guess que se assume ter o tamanho certo: 

1. calcula  a  melhor  pista  para  guess  face  ao  dicionário  dado,  recorrendo  à  função  anterior, 
betterClueForGuess 

2. remove do dicionário todas as palavras que não resultariam nessa pista  

3. retorna a pista  
o Um método main que deverá usar os dois procedimentos anteriores e  

1. Declarar e inicializar a variável maxAttempts a 6.  

2. Declarar duas variáveis gameWordsDictionary e puzzlesDictionary do tipo Dictionary e 
inicializá-las com dois novos dicionários de palavras de tamanho 5. O primeiro dicionário tem 
as palavras válidas, i.e., as que podem ser jogadas. O segundo dicionário tem as palavras que 
ainda  podem  ser  a  palavra  a  descobrir,  e  que  vai  mudando  à  medida  que  vão  sendo  feitas 
jogadas e sendo escolhidas as pistas a dar. 

3. Obter uma palavra do utilizador (guess) que, de acordo com gameWordsDictionary, seja válida, 
jogar  essa  palavra  sobre  o  dicionário  puzzlesDictionary  e  imprimir  uma  versão  colorida 
dessa palavra de acordo com a pista obtida; repetir isto enquanto o jogo não terminar.  
 
Podem ainda incluir na vossa classe outros procedimentos ou funções que considerem úteis. É fornecida a 
classe IpurdleTest.java que serve para testarem individualmente os diferentes elementos que constituem 
a  solução  e  que  eventualmente  ajuda  a  clarificar  qual  comportamento  pretendido  de  cada  um  destes 
elementos. Devem colocar esta classe, e os .class fornecidos, na mesma diretoria que o ficheiro Ipurdle.java. 
 */