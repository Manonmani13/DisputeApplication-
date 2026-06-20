package com.webflex.app.s3storage;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table("notifications")

public class Notification {
	 @Id
	    private Long id;

	    private String token;
	    private String title;
	    private String body;
	    private String status;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Notification(Long id, String token, String title, String body, String status) {
			super();
			this.id = id;
			this.token = token;
			this.title = title;
			this.body = body;
			this.status = status;
		}
	    
	    
}
