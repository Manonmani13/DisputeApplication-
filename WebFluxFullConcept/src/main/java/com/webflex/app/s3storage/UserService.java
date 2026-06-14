package com.webflex.app.s3storage;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	private final UserRepository repo;
	
	private final WebClient webClient;
	
	public UserService(UserRepository repo,WebClient.Builder builder) {
		this.repo=repo;
        this.webClient = builder.baseUrl("http://localhost:8081") .build();
	}
	
	public Mono<User> createUser(User user){
		return repo.save(user).doOnNext(u->System.out.println("saved "+u.getName()))
				.onErrorResume(e->Mono.empty());
	}
	
	public Flux<User> getUsersAboveAge(int age){
		return repo.findAll().filter(u->u.getAge()>age)
				.map(u->{
					u.setName(u.getName().toUpperCase());
					return u;
				});
	}
	
	public Mono<Void> deleteUser(Long id){
		return repo.deleteById(id);
	}
	
	public Mono<byte[]> externalCall(){
		return webClient.get().
				uri("/reports/students")
				.retrieve()
				.onStatus(status->status.is4xxClientError(),
						response->Mono.error(new  RuntimeException("Api not found")))
				.bodyToMono(byte[].class);
	}
	 public Mono<User> updateUser(Long id, User updated) {
	        return repo.findById(id)
	                .flatMap(user -> {
	                    user.setName(updated.getName());
	                    user.setAge(updated.getAge());
	                    return repo.save(user);
	                })
	                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
	    }
	 
	 
}
