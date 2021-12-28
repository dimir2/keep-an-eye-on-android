package edu.keepaneye.app2;

public class FactoryGenerator {
  public static AbstractFactory getFactory(String factory) {
      if (factory == null) {
          return null;
      } else if (factory == "BRE") {
          return new BreadFactory();
      } else if(factory == "FIL") {
          return new FillingFactory();
      }
      return null;
  }
}
