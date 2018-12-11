package com.study.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class Greetings {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public  String greetings()
	{
		return "Hello, Good Morning...!";
	}
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List getUserList()
	{
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		System.out.println(list); 
		return list;
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> listAllUsers() {
        List<Integer> users = new ArrayList<Integer>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);
        users.add(5);
        if(users.isEmpty()){ 
            return new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Integer>>(users, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public ResponseEntity<User> getUserDetails(@RequestParam (value = "id") int id) { 
		UserService userService = new UserService();
		User user = userService.findById(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);	
    }
	
	@RequestMapping(value = "/userDetailsWithDirectId/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> userDetailsWithDirectId(@PathVariable("id") int id) {
		UserService userService = new UserService();
		User user = userService.findById(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);	
    }
	
//	@RequestMapping(value = "/userDetailsWithDirectId/{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> userDetailsWithDirectId(@PathVariable("id") int id) {
//		UserService userService = new UserService();
//		User user = userService.findById(id);
//        if(user == null){
//            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);	
//    }
//	
//	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public ResponseEntity<User> addUser(@RequestBody UserService user) {
//		UserService userService = new UserService();
//		userService.
//		if(user == null){
//            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);	
//    }
	
}
																	