package com.espressoshock.drinkle.appState;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppStatePersistence {

  public static String userFilename = "user";

  public static void saveObject(Object myGame, String withName) {
    File file = new File(System.getProperty("user.dir") + "/saved/" + withName + ".data");
    try (ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(file))) {
      oOut.writeObject(myGame);
    } catch (Exception ex) {
//        ex.printStackTrace();
    }
  }

  public static Object retrieveObject(String withName) {
    Object objectFromFile = null;
    File file = new File(System.getProperty("user.dir") + "/saved/" + withName + ".data");
    try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(file))) {
      objectFromFile = oIn.readObject();
    } catch (Exception ex) {
//        ex.printStackTrace();
    }
    return objectFromFile;
  }
}
