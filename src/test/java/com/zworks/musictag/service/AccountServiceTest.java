package com.zworks.musictag.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import static org.assertj.core.api.Assertions.*;

import com.zworks.musictag.data.UserData;
import com.zworks.musictag.entity.User;

@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AccountServiceTest extends SpringTransactionalTestCase{
	@Autowired
	private AccountService service;
	
	@Test
	public void registerUser(){		
		User user = UserData.randomNewUser();
		service.registerUser(user);
		assertThat(user.getRegisterDate()).isNotNull();
		assertThat(user.getPassword()).isNotNull();
		assertThat(user.getSalt()).isNotNull();
		
	}
}

