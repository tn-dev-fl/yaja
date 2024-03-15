package upload;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class t implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) 
    {
    	System.out.println("Server is starting UP");

    }

}
