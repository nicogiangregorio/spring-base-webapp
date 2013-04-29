package it.nicogiangregorio.home.service.impl;

import it.nicogiangregorio.home.domain.UserBean;
import it.nicogiangregorio.home.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class JdbcUserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {

		UserBean userBean = userRepository.getUserByEmail(username);
	    
	    if (userBean == null)
	      throw new UsernameNotFoundException("user not found");
	    
	    String usernameBean = userBean.getName();
	    String password = userBean.getPassword();
	    boolean enabled = userBean.isActive();
	    boolean accountNonExpired = userBean.isActive();
	    boolean credentialsNonExpired = userBean.isActive();
	    boolean accountNonLocked = userBean.isActive();

	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (String role : userBean.getRoles()) {
	      authorities.add(new SimpleGrantedAuthority(role));
	    }
	    
	    User user = new User(usernameBean, password, enabled,
	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    
	    return user;
	}
}
