package com.hb.major.model.entity;

import java.sql.Date;

public class CommentVo {
	int comment_num; 
	int comment_board; 
	String comment_id;
	String comment_nick;
	Date comment_date;
	int comment_parent; 
	String comment_content; 
	
	
	public CommentVo() {
		// TODO Auto-generated constructor stub
	}


	public CommentVo(int comment_num, int comment_board, String comment_id, String comment_nick, Date comment_date,
			int comment_parent, String comment_content) {
		super();
		this.comment_num = comment_num;
		this.comment_board = comment_board;
		this.comment_id = comment_id;
		this.comment_nick = comment_nick;
		this.comment_date = comment_date;
		this.comment_parent = comment_parent;
		this.comment_content = comment_content;
	}


	public int getComment_num() {
		return comment_num;
	}


	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}


	public int getComment_board() {
		return comment_board;
	}


	public void setComment_board(int comment_board) {
		this.comment_board = comment_board;
	}


	public String getComment_id() {
		return comment_id;
	}


	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}


	public String getComment_nick() {
		return comment_nick;
	}


	public void setComment_nick(String comment_nick) {
		this.comment_nick = comment_nick;
	}


	public Date getComment_date() {
		return comment_date;
	}


	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}


	public int getComment_parent() {
		return comment_parent;
	}


	public void setComment_parent(int comment_parent) {
		this.comment_parent = comment_parent;
	}


	public String getComment_content() {
		return comment_content;
	}


	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}


	@Override
	public String toString() {
		return "CommentVo [comment_num=" + comment_num + ", comment_board=" + comment_board + ", comment_id="
				+ comment_id + ", comment_nick=" + comment_nick + ", comment_date=" + comment_date + ", comment_parent="
				+ comment_parent + ", comment_content=" + comment_content + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comment_board;
		result = prime * result + ((comment_content == null) ? 0 : comment_content.hashCode());
		result = prime * result + ((comment_id == null) ? 0 : comment_id.hashCode());
		result = prime * result + ((comment_nick == null) ? 0 : comment_nick.hashCode());
		result = prime * result + comment_num;
		result = prime * result + comment_parent;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentVo other = (CommentVo) obj;
		if (comment_board != other.comment_board)
			return false;
		if (comment_content == null) {
			if (other.comment_content != null)
				return false;
		} else if (!comment_content.equals(other.comment_content))
			return false;
		if (comment_id == null) {
			if (other.comment_id != null)
				return false;
		} else if (!comment_id.equals(other.comment_id))
			return false;
		if (comment_nick == null) {
			if (other.comment_nick != null)
				return false;
		} else if (!comment_nick.equals(other.comment_nick))
			return false;
		if (comment_num != other.comment_num)
			return false;
		if (comment_parent != other.comment_parent)
			return false;
		return true;
	}
	
	
	
	
}
