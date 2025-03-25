package com.example.palacs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseSpringDataJpaRepository repository;

    // Show all courses from the database
    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", repository.findAll());
        return "courses"; // Renders courses.html
    }

    // Show form to add a new course
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "course-form"; // Renders course-form.html
    }

    // Handle form submission for adding/updating a course
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course) {
        repository.save(course);
        return "redirect:/courses"; // Redirects to updated course list
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Course ID: " + id));
        model.addAttribute("course", course);
        return "course-form"; // Renders course-form.html
    }

    // Handle delete request and ensure database reflects changes
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/courses"; // Redirect ensures page refreshes
    }
}
