package com.zworks.musictag.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.zworks.musictag.entity.User;
import com.zworks.musictag.repository.UserDao;
import com.zworks.musictag.utils.Constants;
import com.zworks.musictag.utils.DataUtils;
import com.zworks.musictag.utils.JsonResponse;

@Service
public class AccountService {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private UserDao userDao;

	public void registerUser(User user) {
		entryptPassword(user);
		user.setRegisterDate(DataUtils.getCurrectTime());
		userDao.save(user);
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	public void checkUnique(User user, JsonResponse json) {
		long count = 0;
		count = userDao.getCountByLoginName(user.getLoginName());
		if (count > 0) {
			json.put(Constants.ERRORPREFIX + User.LOGINNAME, "用户名已经存在");
			json.failed();
		}
	}

	public User findUserByLoginName(String username) {
		return userDao.findByLoginName(username);
	}
}
