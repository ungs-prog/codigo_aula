PANDOC := pandoc --latex-engine=lualatex

tp2.pdf: tp2.md filo.pdf header.tex
	$(PANDOC) -H header.tex --no-highlight -o $@ $<

filo.pdf: filo.tex
	pdflatex $<

