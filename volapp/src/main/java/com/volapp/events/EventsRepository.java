package com.volapp.events;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EventsRepository extends JpaRepository<Events, Long>{
	Events findByEventName(String eventName);
	
	
}
