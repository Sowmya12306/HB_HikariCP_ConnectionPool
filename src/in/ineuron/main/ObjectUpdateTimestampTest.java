package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectUpdateTimestampTest {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		BankAccount bank = null;
		Long id = 3L;
		
		try {
			session= HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				bank = session.get(BankAccount.class, id);
				if(bank!=null) {
					bank.setBalance(bank.getBalance()+12909);
					flag = true;
					System.err.println("old versionCount is "+ bank.getVersion());
				}
				else {
					System.out.println("BankAccount details not found for the given id "+ id);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object is modified for ::" + bank.getVersion() + " times");
				System.out.println("Account modified on :: "+ bank.getLastUpdateTime());
				System.out.println("Account opened on :: "+ bank.getOpeningDate());
			}
			else {
				transaction.rollback();
			System.out.println("Object not modified");
			HibernateUtil.closeSession(session);

			}
		}
	}

}
