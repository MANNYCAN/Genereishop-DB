package com.genereishop.proyecto.service;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.genereishop.proyecto.dto.ChangePassword;
import com.genereishop.proyecto.modelo.User;
import com.genereishop.proyecto.repository.UserRepository;

@Service
public class UserService {
	//private static final ArrayList<User> lista = new ArrayList<User>();
	
	public final UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}//getAllUsers

	public User getUser(Long usId) {
		
		return userRepository.findById(usId).orElseThrow( ()-> new IllegalArgumentException("El usuario con el id [" + usId
				+ "] no existe"));
		
	}//Getuser

	public User addUser(User user) {
		Optional<User> use= userRepository.findByUserEmail(user.getUserEmail());
		if(use.isEmpty()) {
			user.setUserPassword(encoder.encode(user.getUserPassword()));
			return userRepository.save(user);
		}else {
			System.out.println("El usuario [" + user.getUserEmail()
					+ "] ya se encuentra registrado");
			return null;
		}//if else isEmpity
		
	}//addUser

	public User deleteUser(Long usId) {
		User user=null;
		if (userRepository.existsById(usId)) {
			user = userRepository.findById(usId).get();
			userRepository.deleteById(usId);
		}//ifExists
		return user;
		
	}//deleteUser

	public User updateUser(Long usId, ChangePassword changepassword, String userName, Long userPhone) {
		User user = null;
		if(userRepository.existsById(usId)) {
			User usuario = userRepository.findById(usId).get();
			if(encoder.matches(changepassword.getPassword(), usuario.getUserPassword())) {
					if(changepassword.getNpassword()!=null) {
						usuario.setUserPassword(encoder.encode(changepassword.getNpassword()));
						userRepository.save(usuario);
						user=usuario;
					}else {
							if(userName != null)usuario.setUserName(userName);
							if(userPhone != null)usuario.setUserPhone(userPhone);
							if(changepassword.getPassword() != null)usuario.setUserPassword(encoder.encode(changepassword.getPassword()));
							userRepository.save(usuario);
							user = usuario;
					}//if
				}//if
		}//exists
		return user;
	}//UpdateUser

	public boolean validateUser(User user) {
		Optional<User> us= userRepository.findByUserEmail(user.getUserEmail());
		if(us.isPresent()) { //para saber que esta ahi el usuario
			User tmpUser=us.get(); //lo saco de la bolsa
			if(encoder.matches(user.getUserPassword(), tmpUser.getUserPassword())) {
				return true;
			}//if matches
		}//ifPresent
		return false;
	}//validateUser
	
	
}//userservice
