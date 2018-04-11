package org.crazy.world;

import jdk.nashorn.internal.runtime.options.KeyValueOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/11
 * Time : 09:23
 * To change this template use File | Setting | File Template.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:redis-context.xml"})
public class SpringRedisTest {

  @Autowired
  private RedisTemplate<String, String> template;

  @Test
  public void add() {

  }

}
