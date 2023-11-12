# Trabalho_1_fase_IP
O primeiro projeto de IP (Ipurdle, uma variação do jogo Wordle)

comandos essenciais

make (compila tudo)

make run(compila e executa)

make clean (limpar os .classes extra)

make test (testar com os testes fornecidos)

java {tamanho}(opcional) {size}(opcional) {dificuldade}(opcional) (correr o jogo com defenicoes custom, nao se esqueca de compilar)

javac Ipurdle.java (alternativa para compilar)

git clone https://github.com/omeir2404/Trabalho_1_fase_IP.git <nome com que queres guardar>(opcional)

git add * (adicionar todos os ficheiros para staging antes de um commit (colocar no palco))

git commit -m 'mensagem personalizada a explicar as mudancas' (gurdar as alteracoes no local {tirar uma foto})

git push (enviar commit ao cloud)

git status


O objetivo do jogo é para advinhar uma palavra secreta com um certo tamanho.
O jogo tem um maximo de tentativas e uma dificuldade.
Por default, o tamanho é 5, o numero maximo de tentativas é 6 e a dificuldade (que vai de 1 a 3) é 3.
Apos cada tentativa e dado uma pista.
A pista dada consiste na palavra introduzida pelo jogador com cada letra numa cor que indica se a letra foi bem ou mal jogado.
Uma letra na cor VERDE esta no lugar certo.
Uma letra na cor AMARELO esta nao posicao errada.
Uma letra na cor VERMELHO não esta na palavra final.
Boa sorte!
