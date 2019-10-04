package com.mayi.base;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseRedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void setString(String key, Object data) {
		setString(key, data, null);
	}

	public void setString(String key, Object data, Long timeout) {
		if (data instanceof String) {
			String value = (String) data;
			stringRedisTemplate.opsForValue().set(key, value);
		}
		if (timeout != null) {
			stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		}
	}

	public String getString(String key) {
		return (String) stringRedisTemplate.opsForValue().get(key);
	}

	public void delKey(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 获取所有的keys
	 * @param keyPrefix
	 * @return
	 */
	public Set<String> getAllRedisKeys(String keyPrefix){
		return stringRedisTemplate.keys(keyPrefix);
	}

	/**
	 * 获取key值所对应的所有value
	 * @param keys
	 * @return
	 */
	public List getAllValues(Set<String> keys){
		return stringRedisTemplate.opsForValue().multiGet(keys);
	}

}
