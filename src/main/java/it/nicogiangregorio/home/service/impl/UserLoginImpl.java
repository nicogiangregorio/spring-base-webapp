package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.model.CustomUser;
import it.nicogiangregorio.home.model.UserRole;
import it.nicogiangregorio.home.repositories.UserRepository;
import it.nicogiangregorio.home.repositories.pojo.UserPojo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserLoginImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	
	@Override
	public CustomUser loadUserByUsername(String username)throws UsernameNotFoundException {

		UserPojo userBean = userRepository.login(username);
	    
	    if (userBean == null)
	      throw new UsernameNotFoundException("user not found");
	    
	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (UserRole role : userBean.getRoles()) {
	      authorities.add(new SimpleGrantedAuthority(role.name()));
	    }
	    
	    CustomUser user = new CustomUser(userBean, authorities);
	    
	    return user;
	}
}
