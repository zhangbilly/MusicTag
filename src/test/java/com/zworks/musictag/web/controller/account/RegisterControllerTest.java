package com.zworks.musictag.web.controller.account;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.zworks.musictag.data.UserData;
import com.zworks.musictag.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "file:src/main/webapp/WEB-INF/spring-mvc.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
@ActiveProfiles(profiles = "test")
public class RegisterControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testRegisterUser() throws Exception {
		User user = UserData.randomNewUser();
		mockMvc.perform(MockMvcRequestBuilders.post("/musictag/register").param(User.LOGINNAME, user.getLoginName())
				.param(User.USERNAME, user.getUserName()).param(User.PLAINPASSWORD, user.getPlainPassword()))
				.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		// .andExpect(view().name("redirect:/musictag/account/login"))
		// .andExpect(flash().attribute(User.LOGINNAME,
		// user.getLoginName())).andExpect(status().isOk())
		// .andExpect(flash().attributeCount(1));
	}

	@Test
	public void testGetRegisterPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/musictag/register")).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
		// .andExpect(view().name("redirect:/musictag/account/login"))
		// .andExpect(flash().attribute(User.LOGINNAME,
		// user.getLoginName())).andExpect(status().isOk())
		// .andExpect(flash().attributeCount(1));
	}
}
