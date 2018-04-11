package org.crazy.world;

import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.swing.Icon;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.crazy.world.model.Person;
import org.crazy.world.model.User;
import org.crazy.world.uitls.JsonRedisSeriaziler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

  @Resource(name = "redisTemplate")
  private ValueOperations valueOperations;

  @Autowired
  private JsonRedisSeriaziler jsonRedisSeriaziler;

  @Test
  public void insert() {
    valueOperations.set("username", "Kevin");
  }

  @Test
  public void getValue() {
    Object object = valueOperations.get("username");
    System.out.println(jsonRedisSeriaziler.seriazileAsString(object));
  }

  @Test
  public void addUser() {
    User user = new User("jsonor", 21, "wenzhou");
    String json = jsonRedisSeriaziler.seriazileAsString(user);
    valueOperations.set("jsonor", json);
  }

  @Test
  public void addPerson() {
    User user = new User("jsonor", 21, "wenzhou");
    String name = "Kevin";
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add("age:" + i);
    }
    Map<String, User> map = new HashMap<>();
    map.put("jsonor", user);

    Person person = new Person(user, name, list, map);

    String json = jsonRedisSeriaziler.seriazileAsString(person);

    System.out.println(json);

  }

  @Test
  public void add() {
    valueOperations.set("user", "jsonor");
  }

  @Test
  public void get() {
    System.out.println(valueOperations.get("jsonor"));
  }

  @Test
  public void del() {
    template.delete("user");
  }

}
