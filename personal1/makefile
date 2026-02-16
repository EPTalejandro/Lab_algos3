KC = kotlinc
KFLAGS = -include-runtime
PROG = DegreesOfSeparation.jar
SRC = ListaAdyacenciaGrafo.kt Grafo.kt DegreesOfSeparation.kt
SC = runMain.sh

all:
	$(KC) $(SRC) $(KFLAGS) -d $(PROG)
	@echo "#!/usr/bin/bash\njava -jar $(PROG) \$$*" > $(SC)
	@chmod 755 $(SC)

.PHONY : clean 

clean : 
	rm -rf $(PROG)
	rm -rf $(SC)
