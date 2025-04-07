package com.waylau.spring.cloud.weather.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.waylau.spring.cloud.weather.domain.User;

/**
 * 用户资源库.
 *
 * @version 1.0.0 2017年10月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();

	@Override
	public User saveOrUpateUser(User user) {
		Long id = user.getId();
		if (id == null || id <= 0) {
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return this.getUserById(id);
	}

	@Override
	public void deleteUser(Long id) {
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(Long id) {
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUser() {
		return new ArrayList<User>(this.userMap.values());
	}

}
