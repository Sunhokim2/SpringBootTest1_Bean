package demo.demo;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


@Component
public class ShowMeTheContext implements CommandLineRunner {
 @Autowired
 private ApplicationContext context;

 @Override
 public void run(String... args) {
   System.out.println("❗❗❗=== 빈 목록 ===❗❗❗");
   for (String name : context.getBeanDefinitionNames()) {
     System.out.println(name);
   }
 }
}
