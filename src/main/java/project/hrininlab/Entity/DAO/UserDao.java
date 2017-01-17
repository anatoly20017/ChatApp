package project.hrininlab.Entity.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.hrininlab.Entity.ContactList;
import project.hrininlab.Entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrhri on 10.01.2017.
 */
public class UserDao {

    public void add_User(User user){

        Transaction transaction = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void delete_User(int user_id) {
        Transaction transaction = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User) session.load(User.class, user_id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void update_User(User user){

        Transaction transaction = null;
        Session session = HibernateDAO.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch (RuntimeException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
    }

    public void add_contact_to_User(int user_id, User contact){

        Transaction transaction = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            //ВЫТЯГИВАЕМ ЮЗЕРА
            User user = (User) session.load(User.class, user_id);
            session.save(contact);
            ContactList contactList = new ContactList();
            contactList.setUser_id(contact);
            user.getContactList().add(contactList);
            session.update(user);
            session.beginTransaction().commit();
        }catch (RuntimeException ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
    }

    public User get_user_by_id(int userid) {

        User user = null;
        Transaction trns = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from User where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public User get_user_by_login(String login) {

        User user = null;
        Transaction trns = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from User where login = :login";
            Query query = session.createQuery(queryString);
            query.setString("login", login);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Transaction trns = null;
        Session session = HibernateDAO.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from User").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
}
