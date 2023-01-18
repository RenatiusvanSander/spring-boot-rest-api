package edu.remad.springbootrestapi;

import java.util.UUID;

public class Coffee {

  /**
   * identifier
   */
  private final String id;

  /**
   * name
   */
  private String name;

  /**
   * Constructor Coffee
   *
   * @param id string-encoded identifier to initialize
   * @param name name to initialize
   */
  public Coffee(String id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Constructor Coffee
   *
   * @param name name to initialize
   */
  public Coffee(String name) {
    this(UUID.randomUUID().toString(), name);
  }

  /**
   * @return string-encoded identifier
   */
  public String getId() {
    return id;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name
   *
   * @param name name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}
