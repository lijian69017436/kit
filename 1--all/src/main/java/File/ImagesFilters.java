package File;

import java.io.File;
import java.io.FilenameFilter;

public class ImagesFilters implements FilenameFilter {
	//������ ���õ���Ҫ������ �� jpg ��ʽ��β��
	public boolean accept(File dir, String name) {
		if(name.toLowerCase().endsWith(".jpg")){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("e://");
		String [] images=file.list(new ImagesFilters());//����list
		//����һ���ַ����飬��Щ�ַ�ָ���˳���·�����ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼��
		
		System.out.println(images.length);//�õ����鳤��
		
		for(int i=0;i<images.length; i++){//����
			
			System.out.println(images[i]);
		}
		
	}
}
