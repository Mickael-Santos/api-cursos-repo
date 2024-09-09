package br.com.mickaelsantos.api_cursos.modules.course.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mickaelsantos.api_cursos.exceptions.CourseNotFoundException;
import br.com.mickaelsantos.api_cursos.modules.course.models.Course;
import br.com.mickaelsantos.api_cursos.modules.course.repositories.CourseRepository;

@Service
public class ListCourseUseCase 
{
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> execute()
    {
        var coursesFound = courseRepository.findAllCourses()
        .orElseThrow(() ->{
            throw new CourseNotFoundException();
        });

        return coursesFound;
    }
}
