package annotation_proxy.com.annotation_proxy;

public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setRole("admin");
		MthedDao  m=MethdDaoProxy.proxy(u);
		m.add();
		m.delet();
		m.update();
	}

	
}
