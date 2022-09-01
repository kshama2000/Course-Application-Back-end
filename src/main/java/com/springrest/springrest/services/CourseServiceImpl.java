package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	//List<Course> list;
	
//	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(123,"Java Core Course","This course contains basics of Java.."));
//		list.add(new Course(456,"Python Course","This course contains basics of Python.."));
//	}

	@Override
	public List<Course> getCourses() {
		//return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for (Course course: list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c ;
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
		Course entity = courseDao.getReferenceById(parseLong);
		courseDao.delete(entity);
	}
	

}
