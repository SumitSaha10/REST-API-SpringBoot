package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Courses;

@Service
public class CourseServiceImpl implements CourseService {
//	List<Courses> list;
	@Autowired
	public CourseDao coursedao;
	public CourseServiceImpl() {
		super();
//		list = new ArrayList<>();
//		list.add(new Courses(12,"Java JDBC","Beginner"));
//		list.add(new Courses(13,"Python OpenCV","Beginner"));
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}

	@Override
	public Courses getCourse(long courseId) {
//		Courses c = null;
//		for(Courses course : list) {
//			if(course.getId()==courseId) {
//				c = course;
//				break;
//			}
//		}
		return coursedao.getReferenceById(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
//		list.add(course);
		coursedao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
//		list.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Courses entity = coursedao.getOne(courseId);
		coursedao.delete(entity);
		
	}

}
