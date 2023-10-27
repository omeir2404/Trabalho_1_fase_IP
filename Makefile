
SRCS = Ipurdle.java

COMPILE = javac -g


all:
		$(COMPILE) $(SRCS)
run:
	@$(COMPILE) $(SRCS)
	@java Ipurdle

clean:
		rm -rf *.class

pusho: 
		git push
		omeir2404
		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