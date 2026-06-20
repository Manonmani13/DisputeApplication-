package com.webflex.app.s3storage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notify")
public class NotificationController {
	 private final NotificationService service;

	    public NotificationController(NotificationService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public Mono<Notification> send(@RequestBody Notification request) {
	        return service.send(request);
	    }
}
