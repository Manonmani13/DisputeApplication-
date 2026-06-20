package com.webflex.app.s3storage;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotificationRepository  extends ReactiveCrudRepository<Notification, Long>{

}
