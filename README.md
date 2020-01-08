--------------------------------------------------------------------------------
Table of Contents
--------------------------------------------------------------------------------

  1. Folder information

  2. Usage of DIPins

  3. Output
  
  4. Platform
  
  
--------------------------------------------------------------------------------
1.Folder information
--------------------------------------------------------------------------------
When you download the ERINS software package, you will see that there are three directories.

1.DIPins

This directory contains the DIPins program.

2.example

This directory contains example files, including two pair of fastq files and a reference sequence file.

3.run

This directory contains the running script. If you want to do the insertion detection, run runGui.sh to Start a Gui

4.software

This directory contains two software that depends on it.



--------------------------------------------------------------------------------
2.Usage of DIPins
--------------------------------------------------------------------------------
In Gui：

(1)FASTA File：the input fast file（eg:*.fa or *.fasta）

(2)FASTQ File1：the input fastq  file 1(eg:*.fq or *.fastq)

(3)FASTQ File2：the input fastq  file 2(eg:*.fq or *.fastq)

(4)Output Directory：the output directory.The resulting files will be placed in this folder(insert_result.txt).

(5)Cache Directory：temp directory for DIPins running

(6)BWA Directory：Third-party software bwa folder

(7)Seqtk Directory：Third-party software seqtk folder

(8)Chr：the detection chr name（eg：chr21）



--------------------------------------------------------------------------------
3.Output
--------------------------------------------------------------------------------
insertion_result.txt has a total of five columns

(1)：reference sequence name

(2)：the position where the mutation occurred

(3)：the length of mutation

(4)：Sequence information without mutation

(5)：Sequence information with mutation



--------------------------------------------------------------------------------
4.Platform
--------------------------------------------------------------------------------
DIPins runs on a Linux system
