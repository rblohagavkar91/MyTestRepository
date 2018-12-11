package com.study.spring;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private static List<User> users;
    
    static{
        users= populateDummyUsers();
    }
 
    public List<User> findAllUsers() {
        return users;
    }
     
    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1,"Sam",30, 70000));
		users.add(new User(2,"Tom",40, 50000));
		users.add(new User(3,"Jerome",45, 30000));
		users.add(new User(4,"Silvia",50, 40000));
		return users;
	}
    
    private List<User> addUserData(User user){
    	
    	return users;
    }
}
