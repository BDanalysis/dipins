--------------------------------------------------------------------------------
Table of Contents
--------------------------------------------------------------------------------

  1. Folder information

  2. Usage of DIPins

  3. Output
  
  4. Platform
  
  
--------------------------------------------------------------------------------
depend tools
--------------------------------------------------------------------------------

  1. BWA
  
  2. Seqtk
  
  Both provided inside the DIPINS software package under Software folder.
  
  
--------------------------------------------------------------------------------
1.Folder information
--------------------------------------------------------------------------------
When you download the DIPins software package, you will see that there are four directories.

1.DIPins

This directory contains the DIPins program.

2.example

This directory contains example files, including two pair of fastq files and a reference sequence file.

3.run

This directory contains the running script and jar. 
If you want to do the insertion detection in Gui,you can run runGui.sh or java -jar DIPinsGui.jar in run directory to Start the Gui.
If you want to do the insertion detection in Terminal, you can run runTerminal.sh.

4.software

This directory contains two software that depends on it.



--------------------------------------------------------------------------------
2.Usage of DIPins
--------------------------------------------------------------------------------

2.1 How to run Gui

  You can directly run it by java -jar DIPinsGui.jar or run runGui.sh in run directory.

  In Gui：

  (1)FASTA File：the input fast file（eg:*.fa or *.fasta）

  (2)FASTQ File1：the input fastq file 1(eg:*.fq or *.fastq)

  (3)FASTQ File2：the input fastq file 2(eg:*.fq or *.fastq)

  (4)Output Directory：the output directory.The resulting files will be placed in this folder(insert_result.txt).

  (5)Cache Directory：temp directory for DIPins running

  (6)Chr：the detection chr name（eg：chr21）
  
2.1 How to run terminal

  You can directly run it by run runTerminal.sh args1 args2 args3 args4 args5 args6 in run directory.
  
  args1：args1 is the reference sequence (eg:*.fa or *.fasta.
  
  args2: first fastq file (eg:*.fq or *.fastq).
  
  args3: second fastq file (eg:*.fq or *.fastq).
  
  args4: the output directory.The resulting files will be placed in this folder(insert_result.txt).
  
  args5: DIPins.properties is located inside the run where the path of temp directory for DIPins running is stored.
  
  args6: is the name of your reference sequence (ie the string behind the character '>' in the fasta file) 
  
  For example, when running the test sample, you can do this: 
  bash runTerminal.sh ../example/genome.fa ../example/example2_1.fq ../example/example2_2.fq ../output DIPins.properties chr21

  
  
--------------------------------------------------------------------------------
3.Output
--------------------------------------------------------------------------------

insertion_result.txt has a total of five columns

(1) Reference sequence name

(2) The position where the mutation occurred

(3) Length of mutation

(4) Sequence information without mutation

(5) Sequence information with mutation.


--------------------------------------------------------------------------------
4.Platform
--------------------------------------------------------------------------------
DIPins runs on Linux and Unix system.
