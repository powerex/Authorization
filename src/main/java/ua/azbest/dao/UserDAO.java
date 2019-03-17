package ua.azbest.dao;

import ua.azbest.model.User;

public interface UserDAO {

    User getById(int id);
    User getUserByLoginPassword(final String login, final String password);
    boolean add(final User user);
    User.ROLE getRoleByLoginPassword(final String login, final String password);
    boolean userIsExist(final String login, final String password);

}
