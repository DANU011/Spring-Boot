package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@lombok.Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="BoardJPA")
public class Board1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String writer;
	@Column(nullable = false)
	private String content;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createDate;
	private Long cnt;

	private Board1(Builder builder) {
		this.seq = builder.seq;
		this.title = builder.title;
		this.writer = builder.writer;
		this.content = builder.content;
		this.createDate = builder.createDate;

	}

	@Override
	public String toString() {
		return "Board1 [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

	public static Builder builder() {
		return new Builder();
	}
	
	

	public Board1() {
		
	}



	public static class Builder {
		private Long seq;
		private String title;
		private String writer;
		private String content;
		private Date createDate;
		private Builder() {
		};

		private Builder(Long seq, String title, String writer, String content, Date createDate) {
			this.seq = seq;
			this.title = title;
			this.writer = writer;
			this.content = content;
			this.createDate = createDate;
		}

		public Builder seq(Long seq) {
			this.seq = seq;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder writer(String writer) {
			this.writer = writer;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder createDate(Date createDate) {
			this.createDate = createDate;
			return this;
		}

		public Board1 build() {
			return new Board1(this);
		}
	}
}