package se.se.annotation_proxy.com.annotation_proxy;

public class MthedDaoImpl implements MthedDao {

	@Limit(limit="admin,manager") 
	public void add() {
			System.out.println("add");
	}

	@Limit(limit="admin")
	public void delet() {
			System.out.println("delet  impl");
	}

	@Limit(limit="admin,manager,app")
	public void update() {
			System.out.println("update impl");
	}

}
