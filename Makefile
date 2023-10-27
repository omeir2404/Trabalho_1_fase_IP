
SRCS = Ipurdle.java

COMPILE = javac -g


all:
		$(COMPILE) $(SRCS)
run:
	@$(COMPILE) $(SRCS)
	@java Ipurdle

clean:
		rm -rf *.class

fclean: clean
		rm -rf 