package org.crazy.world.model;

import java.util.Map;
import java.util.List;

/**
 * Create by IntelliJ IDEA
 *
 * @author: jsonor
 * @date-Time: 2018/4/11 16:43
 * @description:
 */
public class Person {

  private User user;
  private String name;
  private List<String> ages;
  private Map<String, User> maps;

  public Person(User user, String name, List<String> ages,
      Map<String, User> maps) {
    this.user = user;
    this.name = name;
    this.ages = ages;
    this.maps = maps;
  }

  public Person() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getAges() {
    return ages;
  }

  public void setAges(List<String> ages) {
    this.ages = ages;
  }

  public Map<String, User> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, User> maps) {
    this.maps = maps;
  }

  @Override
  public String toString() {
    return "Person{" +
        "user=" + user +
        ", name='" + name + '\'' +
        ", ages=" + ages +
        ", maps=" + maps +
        '}';
  }
}

