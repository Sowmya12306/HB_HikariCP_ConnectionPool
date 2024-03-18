package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstCacheModifyDemo {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		InsurancePolicy policy = null;
		Long id = 1L;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				if(transaction!=null) {
					policy = session.get(InsurancePolicy.class, id);
					if(policy!=null) {
						policy.setCompany("LIC");
						policy.setPolicyName("Bhim Barosa");
						policy.setPolicyType("Health");
						session.update(policy);
						flag = true;
					}
					else {
						System.out.println("Record not found !..");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag)
				transaction.commit();
			else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}

	}

}
