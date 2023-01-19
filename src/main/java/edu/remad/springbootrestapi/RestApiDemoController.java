package edu.remad.springbootrestapi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-Controller as demonstration
 */
@RestController
@RequestMapping("/")
public class RestApiDemoController {

  /**
   * all sorts of coffees
   */
  private List<Coffee> coffees = new ArrayList<>();

  /**
   * RestApiDemoController Constructor
   */
  public RestApiDemoController() {
    coffees.addAll(
        List.of(new Coffee("Cafe Cereza"),
            new Coffee("Cafe Ganador"),
            new Coffee("Cafe Loredo"),
            new Coffee("Cafe Tres Pontas")));
  }

  /**
   * Gets coffees
   *
   * @return coffees
   */
  @RequestMapping("/coffees")
  public Iterable<Coffee> getCoffees() {
    return coffees;
  }
}
