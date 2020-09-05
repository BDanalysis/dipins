package com.xie.detection;

import java.io.File;
import java.util.ArrayList;

public class GuiRunUnit {
    String fastafile;
    String fastqfile1;
    String fastqfile2;
    String output;
    String cache;
    String chr;

    public void setChr(String chr) {
        this.chr = chr;
    }

    public void setFastafile(String fastafile) {
        this.fastafile = fastafile;
    }

    public void setFastqfile1(String fastqfile1) {
        this.fastqfile1 = fastqfile1;
    }

    public void setFastqfile2(String fastqfile2) {
        this.fastqfile2 = fastqfile2;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }


    public String checkValid(){
        ArrayList<String> al=new ArrayList<>();
        File file=new File(fastafile);
        if(!file.isFile())
            al.add("fasta file");
        file=new File(fastqfile1);
        if(!file.isFile())
            al.add("fastq file 1");
        file=new File(fastqfile2);
        if(!file.isFile())
            al.add("fastq file 2");
        file=new File(output);
        if(!file.isDirectory())
            al.add("output file directory");
        file=new File(cache);
        if(!file.isDirectory())
            al.add("cache file directory");
        if(chr==null||chr.length()==0)
            al.add("chr");
        if(al.size()==0)
            return "true";
        else{
            StringBuilder sb=new StringBuilder();
            for(String temp:al){
                sb.append(temp);
                sb.append(",");
            }
            return sb.substring(0,sb.length()-1)+" is invalid.";
        }
    }

}
