package it.nicogiangregorio.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import it.nicogiangregorio.home.repositories.MenuRepository;
import it.nicogiangregorio.home.repositories.pojo.MenuItemPojo;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractMenuJdbcTests {
	@Autowired
	MenuRepository menuRepository;
	
	@Test
	@Transactional
	public void getMenu(){
		Map<BigDecimal, MenuItemPojo> menu = menuRepository.getMenu();
		assertNotNull(menu);
		assertTrue(menu.size() > 0);
	}
}
