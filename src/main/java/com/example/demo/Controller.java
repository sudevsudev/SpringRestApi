package com.example.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping("/")
	public String call() {
		return "home";
	}
	@Autowired
	StudentDAO st;
	
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		ModelAndView mv=new ModelAndView();
		st.save(student);
		mv.addObject("student", student);
		mv.setViewName("display");
		return mv;
	}
	@RequestMapping("getStudent")
	public ModelAndView getStudent(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		Student student=st.findById(id).orElse(new Student());
		mv.addObject("student", student);
		return mv;	
	}
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		//int i=Integer.parseInt(id);
		st.deleteById(id);
		mv.setViewName("display");
		System.out.println("after display");
		mv.addObject("student", "delete succesful");
		return mv;
	}
	
	
   //	Spring with rest API
	
	@GetMapping("allStudent")
	@ResponseBody
	public List<Student> sendStudents(){
		List<Student> l=(List<Student>)st.findAll();
		
		return l;
	}
	
	@GetMapping("Student/{id}")
	@ResponseBody
	public Student sendStudents(@PathVariable("id") int id){
		Student s=(Student)st.findById(id).orElse(new Student());
		return s;
		//return st.findById(id).toString();
	}
	
	@PostMapping("postStudent")
	public Student postStudent(@RequestBody Student student) {
		st.save(student);
		return student;
	}
	
	@DeleteMapping("deleteStudent/{id}")
	public String putStudent(@PathVariable("id") int id) {
		
		st.deleteById(id);
		return "delete successsful";
		
	}
	
}

