package cn.com.bookstore.db.common;

import java.io.Closeable;
import java.io.IOException;

public class Release {
  public static void free(Closeable... streams) {
    for(Closeable c : streams) {
      if(c != null) {
        try {
          c.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
