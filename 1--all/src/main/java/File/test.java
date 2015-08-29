package File;

import java.io.File;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("e://");
		String [] images=file.list(new ImagesFilters());
		System.out.println(images.length);
		for(int i=0;i<images.length; i++){
			
			System.out.println(images[i]);
		}
		
	}
}
