package it.nicogiangregorio.model;

import static org.junit.Assert.assertEquals;
import it.nicogiangregorio.home.model.UserRole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilsTests {
	@Test
	public void getRoles() {
		assertEquals(1, UserRole.ADMIN.getValue());
		assertEquals(2, UserRole.BASIC.getValue());
	}
}
