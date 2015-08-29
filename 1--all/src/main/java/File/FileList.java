package File;

import java.io.File;

public class FileList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("d://work/jre");//file ����ϵͳ�ļ�
		FileList.listchilds(file,0);
	}
	
	public static void listchilds(File f,int leve1){//�鿴 ·���µ�����Ŀ¼���õݹ� �õ��ļ�����ߵ�Ŀ¼
		StringBuilder sb= new StringBuilder("|--");//�ֲ㷽�� 
		for(int i=0;i<leve1; i++){
			sb.insert(0, "|  ");
		}
		
		//�ݹ�
		File[] child=f.listFiles();// ����һ������·�������飬��Щ·�����ʾ�˳���·�����ʾ��Ŀ¼�е��ļ���
		int len=child==null?0:child.length;//��ľ����  �������Ϊ�� len=0 ��Ϊ��len= length
		for(int i=0;i<len;i++){
			System.out.println(sb.toString()+child[i].getName());//ѭ��һ�εõ�һ�� ����
			if(child[i].isDirectory()){//��� �����i��ֵ��Ŀ¼  ���� ������  �ݹ�
				listchilds(child[i],leve1+1);
			}
		}
		
	}
	
	
}
