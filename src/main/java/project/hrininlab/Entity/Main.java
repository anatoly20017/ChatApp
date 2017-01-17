package project.hrininlab.Entity;

import project.hrininlab.Entity.DAO.UserDao;

/**
 * Created by mrhri on 06.01.2017.
 */
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        UserDao dao = new UserDao();

        User user = dao.get_user_by_id(3);

        user.set_online();
        dao.update_User(user);

    }

}
