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




--------------------------------------------------------------------------------
3.Output
--------------------------------------------------------------------------------
insertion_result.txt has a total of five columns
(1)：reference sequence name
(2)：the position where the mutation occurred
(3)：Because it is an insertiion variation, the position is the same as the second column
(4)：Sequence information without mutation
(5)：Sequence information with mutation



--------------------------------------------------------------------------------
4.Platform
--------------------------------------------------------------------------------
DIPins runs on a Linux system
