
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
#        find . -name '*.class' ! -name 'DictionaryIP.class' -exec rm -rf {} +
		@ echo "$(RED)Deleting $(CYAN)Ipurdle.class ✔️"

 

		 
#add animation

 

  
