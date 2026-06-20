package com.webflex.app.s3storage;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class NotificationService {

	private final NotificationRepository repo;
	
	public NotificationService(NotificationRepository repo) {
		this.repo=repo;
	}
	
	public Mono<Notification> send(Notification req){
		req.setStatus("PENDING");
		return repo.save(req)
		.flatMap(save->sendToFirebase(save).map(res->{
			save.setStatus("SUCCESS");
			return save;
		}).onErrorResume(e->{
			save.setStatus("FAILED");
			return Mono.just(save);
		})).flatMap(repo::save);
	}
	
	private Mono<String> sendToFirebase(Notification n){
		return Mono.fromCallable(()->{
			Message m=Message.builder()
					.setToken(n.getToken())
					.setNotification(com.google.firebase.messaging.Notification.builder()
							.setTitle(n.getTitle()).setBody(n.getBody()).build()).build();
							return FirebaseMessaging.getInstance().send(m);
		}).subscribeOn(Schedulers.boundedElastic());
	}
}
