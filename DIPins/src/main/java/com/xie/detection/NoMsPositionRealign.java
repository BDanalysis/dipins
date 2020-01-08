package com.xie.detection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NoMsPositionRealign {
		static String shdir="/home/xie/eclipse-workspace/ins";
		static String temppath="/media/xie/0009A639000F3A82/ins/test1/temp";
		
		ArrayList<SamUnit> nomspositionrealign(String fasta,String unmatchfq1,String unmatchfq2,int pos,int insertsize) throws IOException, InterruptedException {
			File file=mkdir(pos);
			ArrayList<SamUnit> asu=realign(fasta, pos, unmatchfq1, unmatchfq2,insertsize);
			deleteFile(file);
			return asu;
		}
		
		ArrayList<SamUnit> realign(String fastafile,int pos,String unmatchfq1,String unmatchfq2,int insertsize) throws IOException, InterruptedException{
			BufferedReader br1 = new BufferedReader(new FileReader(fastafile));
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(temppath+pos+"/temp.fa"));
			StringBuilder sb=new StringBuilder();
			String line1=null;
			while((line1=br1.readLine())!=null) {
				if(line1.startsWith(">")) {
					bw1.write(line1);
					bw1.newLine();
					continue;
				}
				sb.append(line1);
				if(sb.length()>pos+1000)
					break;
				
			}
			br1.close();
			bw1.write(sb.substring(pos-1000,pos+1000));
			bw1.newLine();
			bw1.flush();
			bw1.close();
			ProcessBuilder builder = new ProcessBuilder("/bin/chmod", "755","./bwa_noPositionRealign.sh");
			Process process = builder.start();
			process.waitFor();
			ProcessBuilder pb = new ProcessBuilder("./bwa_noPositionRealign.sh",temppath+pos+"/temp.fa",unmatchfq1,unmatchfq2);
			pb.directory(new File(shdir));
			int runningStatus = 0;
			String s = null;
			ArrayList<SamUnit> asu=new ArrayList<>();;
	        try {
	            Process p = pb.start();
	            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	            while ((s = stdInput.readLine()) != null) {
	            	if(s.startsWith("@"))
	            		continue;
	            	else {
	            		String[] temp = s.split("\t");
						int flag=Integer.valueOf(temp[1]);
						if(((flag&4)==4)||((flag&8)==8))
							continue;
						else {
							SamUnit samUnit=new SamUnit(s);
							if(samUnit.state!=null && samUnit.state.equals("MS") && samUnit.splitpos>=995 && samUnit.splitpos<=1006 && samUnit.isize<insertsize*2 && samUnit.isize>-insertsize*2)
							{
								int m=samUnit.splitpos-samUnit.pos;
								samUnit.pos=pos-1000+samUnit.pos;
								samUnit.splitpos=samUnit.pos+m;
								samUnit.mpos=pos-1000+samUnit.mpos;
								asu.add(samUnit);
							}
						}
	            	}
	            }
	            while ((s = stdError.readLine()) != null) {
	            }
	            try {
	                runningStatus = p.waitFor();
	            } catch (InterruptedException e) {
	            	System.out.println(e);
	            }

	        } catch (IOException e) {
	        	System.out.println(e);
	        }
	        if (runningStatus != 0) {
	        	System.out.println(this.getClass().getName()+" error status: "+runningStatus);
	        }
	        return asu;
	        
		}
		
		File mkdir(int pos) {
			File file =new File(temppath+pos); 
			if (!file .exists() && !file .isDirectory()) { 
				file .mkdir(); 
			}
			return file;
		}
		
		void deleteFile(File file){
			if (file.exists()) {
				if (file.isFile()) {
				file.delete(); 
				} else if (file.isDirectory()) {
				File[] files = file.listFiles(); 
				for (int i = 0;i < files.length;i ++) {
				this.deleteFile(files[i]);
				} 
				file.delete();
				files=null;
				} 
				} else { 
					System.out.println("��ɾ�����ļ�������");
				} 
			file=null;
		}
		
		public static void main(String[] args) throws IOException, InterruptedException {
			NoMsPositionRealign n=new NoMsPositionRealign();
//			n.realign("/media/xie/0009A639000F3A82/ins/test1/test1.fa", 7935, "/media/xie/0009A639000F3A82/ins/test1/11.fq", "/media/xie/0009A639000F3A82/ins/test1/22.fq");
//			n.findposms(7935,500);
			ArrayList<SamUnit> asu=n.nomspositionrealign("/media/xie/0009A639000F3A82/ins/test1/test1.fa", "/media/xie/0009A639000F3A82/ins/test1/11.fq", "/media/xie/0009A639000F3A82/ins/test1/22.fq", 7935, 500);
			for(SamUnit s:asu) {
				System.out.println(s.toString());
				System.out.println(s.splitpos);
			}
		}
}
