package org.crazy.world.uitls;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Create by IntelliJ IDEA
 *
 * @author: jsonor
 * @date-Time: 2018/4/11 15:10
 * @description:
 */
public class JsonRedisSeriaziler {
  public static final String EMPTY_JSON = "{}";

  public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  protected ObjectMapper objectMapper = new ObjectMapper();

  public JsonRedisSeriaziler() {}

  public String seriazileAsString(Object object) {
    if (object == null) {
      return EMPTY_JSON;
    }
    try{
      return this.objectMapper.writeValueAsString(object);
    } catch (Exception e) {
      throw new SerializationException("Could not write JSON:" + e.getMessage(), e);
    }
  }

  public <T> T deserializeAsObject(String string, Class<T> clazz) {
    if (string == null || clazz == null) {
      return null;
    }
    try {
      return this.objectMapper.readValue(string, clazz);
    } catch (Exception e) {
      throw new SerializationException("Could not write JSON:" + e.getMessage(), e);
    }
  }

}
