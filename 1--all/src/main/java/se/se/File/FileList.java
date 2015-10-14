package se.se.File;

import java.io.File;

public class FileList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("d://work/jre");//
		FileList.listchilds(file,0);
	}
	
	public static void listchilds(File f,int leve1){//
		StringBuilder sb= new StringBuilder("|--");//
		for(int i=0;i<leve1; i++){
			sb.insert(0, "|  ");
		}
		
		//�ݹ�
		File[] child=f.listFiles();// 
		int len=child==null?0:child.length;//
		for(int i=0;i<len;i++){
			System.out.println(sb.toString()+child[i].getName());//
			if(child[i].isDirectory()){//
				listchilds(child[i],leve1+1);
			}
		}
		
	}
	
	
}
