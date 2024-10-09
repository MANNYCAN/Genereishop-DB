package com.genereishop.proyecto.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.genereishop.proyecto.dto.ChangePassword;
import com.genereishop.proyecto.modelo.User;

@Service
public class UserService {
	private static final ArrayList<User> lista = new ArrayList<User>();
	
	public UserService() {
		lista.add(new User("Manuel",Long.valueOf(5515333341L),"sonic@gmail.com","T0stadit4s"));
		lista.add(new User("Efren",Long.valueOf(5636196599L),"efren@gmail.com","Tost4dot4S"));
		
	}//Constructor 

	public List<User> getAllUsers() {
		return lista;
	}//getAllUsers

	public User getUser(Long usId) {
		User usua = null;
		for (User user : lista) {
			if(user.getUserId()==usId) {
				usua = user;
				break;
			}//if
		}//foreach
		return usua;
	}//Getuser

	public User addUser(User user) {
		User usua = null;
		boolean flag = false;
		//Agregar la validacion, cuando intente agregar el mismpo usaurio me regresara null
		for(User u : lista){
		 if(u.getUserEmail().equals(user.getUserEmail())){
		     flag=true;
		    break;
		} //if
		}//forEach
		if(!flag){
		lista.add(user);
		usua = user;
		 }//!flag
		return usua;
	}//Postuser

	public User deleteUser(Long usId) {
		User usua = null;
		for (User user : lista) {
			if(user.getUserId()==usId) {
				usua = lista.remove(lista.indexOf(user));
				break;
			}//if
		}//foreach
		return usua;
	}//Deleteuser

	public User updateUser(Long usId, ChangePassword changepassword, String userName, Long userPhone) {
		User usua = null;
		for (User user : lista) {
			if(user.getUserId()==usId) {
				if(user.getUserPassword().equals(changepassword.getPassword() )) {
					if(changepassword.getNpassword() != null) {
						user.setUserPassword(changepassword.getNpassword());
						usua = user;
					}else {
						if(userName != null)user.setUserName(userName);
						if(userPhone != null)user.setUserPhone(userPhone);
						if(changepassword.getPassword() != null)user.setUserPassword(changepassword.getPassword());
						usua = user;
					}
					
				}//if
				break;
			}//if
		}//foreach
		return usua;
	}//UpdateUser
	
	
}//userservice
