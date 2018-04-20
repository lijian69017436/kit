package expert.expert.regex.regex;

import org.junit.Test;

public class regex_space {

	@Test
	public void space(){
		
		String s="s-en     ADMBatchProc        Online        1             1                 ADM";
		s=s.replaceAll("\\s{2,}", "|");
		System.out.println("所有空格替换成 |");
		System.out.println(s);
	}
	
}
