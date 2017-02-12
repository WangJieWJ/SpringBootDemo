package com.springBootBasic.redisCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: redisCache工具类
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/4 0004
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的Value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取字符串缓存
     *
     * @param key
     * @return
     */
    public String get_Str(final String key) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            return operations.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 读取List缓存
     *
     * @param key
     * @param start 开始位置
     * @param end   结束位置
     * @return
     */
    public List<String> get_List(final String key, long start, long end) {
        try {
            ListOperations<String, String> operations = redisTemplate.opsForList();
            return operations.range(key, start, end);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取List总条数
     *
     * @param key
     * @return
     */
    public long get_ListSize(final String key) {
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            return operations.size(key);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 读取Set缓存
     *
     * @param key
     * @return
     */
    public Set<String> get_Set(final String key) {
        try {
            SetOperations<String, String> operations = redisTemplate.opsForSet();
            return operations.members(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 写入字符串缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set_Str(final String key, String value) {
        return set_Str(key, value, -1);
    }

    /**
     * 写入List缓存
     *
     * @param key
     * @param list
     * @return
     */
    public boolean set_List(final String key, List<String> list) {
        return set_List(key, list, -1);
    }

    /**
     * 写入Set缓存
     *
     * @param key
     * @param set
     * @return
     */
    public boolean set_Set(final String key, Set<String> set) {
        return set_Set(key, set, -1);
    }

    /**
     * 写入字符串缓存，带存活时间的
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set_Str(final String key, Object value, long expireTime) {

        boolean result = false;
        try {

            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            if (expireTime > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入List缓存，带存活是时间的
     *
     * @param key
     * @param list
     * @param expireTime
     * @return
     */
    public boolean set_List(final String key, List<String> list, long expireTime) {
        try {
            ListOperations<String, String> operations = redisTemplate.opsForList();
            for (int i = 0; i < list.size(); i++) {
                operations.rightPush(key, list.get(i));
            }
            if (expireTime > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 写入Set缓存，带存活时间的
     *
     * @param key
     * @param set
     * @param expireTime
     * @return
     */
    public boolean set_Set(final String key, Set<String> set, long expireTime) {
        try {
            SetOperations<String, String> operations = redisTemplate.opsForSet();
            operations.add(key, set.toArray(new String[set.size()]));
            if (expireTime > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
