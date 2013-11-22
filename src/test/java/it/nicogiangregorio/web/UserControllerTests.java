package it.nicogiangregorio.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("VisitsViewTest-config.xml")
public class UserControllerTests {
	@Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    
//    @Test
//    public void getVisitsXml() throws Exception {
//        ResultActions actions = this.mockMvc.perform(get("/vets.xml").accept(MediaType.APPLICATION_XML));
//        actions.andDo(print()); // action is logged into the console
//        actions.andExpect(status().isOk());
//        actions.andExpect(content().contentType("application/xml"));
//        actions.andExpect(xpath("/vets/vetList[id=1]/firstName").string(containsString("James")));

//    }
}
