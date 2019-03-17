package ua.azbest.servlets;

import ua.azbest.dao.UserDAO;
import ua.azbest.dao.UserDAOImplementation;
import ua.azbest.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static ua.azbest.model.User.ROLE.ADMIN;
import static ua.azbest.model.User.ROLE.USER;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAOImplementation());

        dao.get().add(new User(1, "azbest", "1", ADMIN));
        dao.get().add(new User(2, "user", "2", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
