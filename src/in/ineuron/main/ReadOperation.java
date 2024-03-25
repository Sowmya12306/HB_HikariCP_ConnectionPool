package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class ReadOperation {

	public static void main(String[] args) {
		Session session = null;
		boolean flag = false;
		Long id = 2L;
		InsurancePolicy policy = null;
		session = HibernateUtil.getSession();
		
		try {
			if(session!=null) {
				policy = session.get(InsurancePolicy.class, id);  
				
				if(policy!=null) 
				System.out.println("1 :: "+ policy);
				
				else
					System.err.println("Record doesn't exists!....");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
