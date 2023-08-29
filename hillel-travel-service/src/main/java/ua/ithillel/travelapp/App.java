package ua.ithillel.travelapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.travelapp.service.UserService;

public class App {
    public static void main( String[] args )
    {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel.travelapp");

//        UserService userService = (UserService) applicationContext.getBean("userService");
//        List<User> allUser = userService.getAllUser();

        UserService userService1 = applicationContext.getBean(UserService.class);


        System.out.println();
    }
}
