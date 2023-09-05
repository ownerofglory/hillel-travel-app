package ua.ithillel.travelapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.travelapp.exception.EntityNotFoundException;
import ua.ithillel.travelapp.model.dto.UserDTO;
import ua.ithillel.travelapp.service.UserService;

public class App {
    public static void main( String[] args )
    {
//        SessionFactory sessionFactory = null;
//        UserRepo userRepo = new UserMySqlJpaRepo(sessionFactory);
//        UserService userService = new UserServiceDefault(userRepo);

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel.travelapp");
//
////        UserService userService = (UserService) applicationContext.getBean("userService");
////        List<User> allUser = userService.getAllUser();
//
        UserService userService = applicationContext.getBean(UserService.class);
        try {
            UserDTO userById = userService.getUserById(6L);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
//

        System.out.println();
    }
}
