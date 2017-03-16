package com.hcl.jpa.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Srinivas
 *
 */
@Transactional
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	/**
	   * This method will find an Boooking instance in the database by its departure.
	   * Note that this method is not implemented and its working code will be
	   * automatically generated from its signature by Spring Data JPA.
	   */
	  public Booking findByDeparture(String departure);
}
