package com.example.palacs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;  // ✅ No need to import

    @Override
    public void run(String... args) throws Exception {
//       repository.save(new Course("Learn Spring Boot", "Jane Doe"));
//       repository.save(new Course("Learn Hibernate", "John Doe"));
 //      repository.save(new Course("Learn Spring", "John Doer"));
//        repository.save(new Course("Learn Java", "James Gosling"));
 //       repository.save(new Course("Learn AWS", "Jeff Bezos"));

        System.out.println("✅ Courses in Database:");
        repository.findAll().forEach(System.out::println);
    }
}
