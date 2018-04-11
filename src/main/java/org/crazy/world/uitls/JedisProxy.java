package org.crazy.world.uitls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;


/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/10
 * Time : 18:51
 * To change this template use File | Setting | File Template.
 * Description :
 * @author kevin
 */

public class JedisProxy implements InvocationHandler {

  private JedisCommands target;
  private JedisPool pool;

  public Object getInstance(JedisPool pool){
    this.pool = pool;
    this.target = pool.getResource();
    Class clazz = target.getClass();
    System.out.println(Arrays.toString(clazz.getInterfaces()));
    Object obj = Proxy.newProxyInstance(clazz.getClassLoader(),
        clazz.getInterfaces(),
        this);
    return obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
      return method.invoke(this.target, args);
    } finally {
      if (this.target instanceof Jedis) {
        pool.returnResource((Jedis) target);
        System.out.println("release the jedis connection");
      }
    }
  }
}
