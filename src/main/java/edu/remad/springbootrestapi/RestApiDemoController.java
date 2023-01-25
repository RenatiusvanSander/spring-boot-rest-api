package edu.remad.springbootrestapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-Controller concerning delete, put, get, post {@link Coffee}
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

  /**
   * Gets coffee by its id
   *
   * @param id coffee identifier to identify coffee to return
   * @return identified coffee
   */
  @GetMapping("/coffees/{id}")
  public Optional<Coffee> getCoffeeById(@PathVariable String id) {
    return coffees.stream().filter(coffey -> coffey.getId().equals(id))
        .findFirst();
  }

  /**
   * Puts a coffee.
   *
   * @param id identifier of coffee to update
   * @param coffee coffee data to update
   * @return updated coffee
   */
  @PutMapping("/coffees")
  ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
    int coffeeIndex = -1;

    for (Coffee c : coffees) {
      if (c.getId().equals(id)) {
        coffeeIndex = coffees.indexOf(c);
        coffees.set(coffeeIndex, coffee);
      }
    }

    return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED)
        : new ResponseEntity<>(coffee, HttpStatus.OK);
  }

  /**
   * Posts coffee.
   *
   * @param coffee JSON-encoded coffee converted to coffee
   * @return created coffee
   */
  @PostMapping("/coffees")
  Coffee postCoffee(@RequestBody Coffee coffee) {
    coffees.add(coffee);

    return coffee;
  }

  /**
   * Deletes coffee.
   *
   * @param id coffee identifier to delete
   */
  @DeleteMapping("/coffees/{id}")
  void deleteCoffee(@PathVariable String id) {
    coffees.removeIf(c -> c.getId().equals(id));
  }
}
