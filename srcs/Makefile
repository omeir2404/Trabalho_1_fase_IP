
# SRCS = Ipurdle.java

COMPILE = javac -g
FLAGS = -cp
CLASSES = /home/oharoon/Trabalho_1_fase_IP/srcs

CLR_RMV		:= \033[0m
RED		    := \033[1;31m
GREEN		:= \033[1;32m
YELLOW		:= \033[1;33m
BLUE		:= \033[1;34m
CYAN 		:= \033[1;36m

# all:
# 		$(COMPILE) $(SRCS)
# 		@echo "$(YELLOW)$(COMPILE) ${CLR_RMV}of ${RED} Ipurdle ${CLR_RMV}..."
# 		@echo "$(BLUE)Ipurdle created[0m ✔️"

# run: all
# 	@java Ipurdle
	

cnexus:
		$(COMPILE) Ipurdle_Nexus.java
		@echo "$(YELLOW)$(COMPILE) ${CLR_RMV}of ${RED} Ipurdle ${CLR_RMV}..."
		@echo "$(BLUE)Ipurdle created[0m ✔️"

cazula:
		$(COMPILE) Ipurdle_Azula.java
		@echo "$(YELLOW)$(COMPILE) ${CLR_RMV}of ${RED} Ipurdle ${CLR_RMV}..."
		@echo "$(BLUE)Ipurdle created[0m ✔️"

nexus: cnexus
	@java Ipurdle_Nexus

azula: caszula
	@java Ipurdle_Azula
	

clean:
		rm -rf Ipurdle_Nexus.class
		rm -rf Ipurdle_Azula.class
#        find . -name '*.class' ! -name 'DictionaryIP.class' -exec rm -rf {} +
		@ echo "$(RED)Deleting $(CYAN)Ipurdle_Nexus.class ✔️"
		@ echo "$(RED)Deleting $(BLUE)Ipurdle_Azula.class ✔️"
		 
#add animation

 

  
