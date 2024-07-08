package com.aftermidnight.speleohub.core.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EndpointsListener {

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
			log.info("Executando runAfterStartup() ");
	
	}
}