
SRCS = Ipurdle.java

COMPILE = javac -g


CLR_RMV		:= \033[0m
RED		    := \033[1;31m
GREEN		:= \033[1;32m
YELLOW		:= \033[1;33m
BLUE		:= \033[1;34m
CYAN 		:= \033[1;36m

all:
		$(COMPILE) $(SRCS)
		@echo "$(YELLOW)$(COMPILE) ${CLR_RMV}of ${RED} Ipurdle ${CLR_RMV}..."
		@echo "$(BLUE)Ipurdle created[0m ✔️"
run: all
	@java Ipurdle
	

clean:
		rm -rf *.class
		@ echo "$(RED)Deleting $(CYAN)Ipurdle.class ✔️"

pusho:
		git add *
		git commit -m 'quick push by Omeir'
		expect -c 'spawn git push; expect "Username for 'https://github.com': "; send "omeir2404\n";expect "Password for 'https://omeir2404@github.com': " ;send "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\n";expect eof'

		 
#add animation

pushm:
		git add *
		git commit -m 'quick commit by Matilde'
		expect -c 'spawn git push; expect "Username for 'https://github.com': "; send "MissMati1234\n";expect "Password for 'https://MissMati1234@github.com': ";send "<coloca aqui a tua chave github>\n";expect eof'

#para instalar: sudo apt-get install expect
