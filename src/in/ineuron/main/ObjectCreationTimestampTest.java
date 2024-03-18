package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectCreationTimestampTest {
	public static void main(String[] args) {
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Long idValue = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				BankAccount bank = new BankAccount();
				bank.setHolderName("Kalpana");
				bank.setBalance(3312.90);
				bank.setType("Primary");
				idValue = (Long)session.save(bank);
				System.out.println(session.save(bank).getClass().getName());
				System.out.println("Generated id value is " + idValue);
				System.out.println("Generated versionCount is "+ bank.getVersion());
     			flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(flag ==true) {
				transaction.commit(); // stored in DB through ORM
			}
			else transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
	}

}
