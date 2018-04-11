package org.crazy.world.model;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/10
 * Time : 12:00
 * To change this template use File | Setting | File Template.
 * Description :
 */
public class User {
  private String name;
  private Integer age;
  private String addr;

  public User(String name, Integer age, String addr) {
    this.name = name;
    this.age = age;
    this.addr = addr;
  }

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", addr='" + addr + '\'' +
        '}';
  }
}
