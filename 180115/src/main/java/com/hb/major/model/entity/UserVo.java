package com.hb.major.model.entity;

import java.sql.Date;

public class UserVo {

	private int num;
	private int id;
	private String nickname;
	private String profile_img;
	private String thumb_img;
	private Date register;
	
	public UserVo() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getThumb_img() {
		return thumb_img;
	}

	public void setThumb_img(String thumb_img) {
		this.thumb_img = thumb_img;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}

	public UserVo(int num, int id, String nickname, String profile_img, String thumb_img, Date register) {
		super();
		this.num = num;
		this.id = id;
		this.nickname = nickname;
		this.profile_img = profile_img;
		this.thumb_img = thumb_img;
		this.register = register;
	}

	@Override
	public String toString() {
		return "UserVo [num=" + num + ", id=" + id + ", nickname=" + nickname + ", profile_img=" + profile_img
				+ ", thumb_img=" + thumb_img + ", register=" + register + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + num;
		result = prime * result + ((profile_img == null) ? 0 : profile_img.hashCode());
		result = prime * result + ((thumb_img == null) ? 0 : thumb_img.hashCode());
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
		UserVo other = (UserVo) obj;
		if (id != other.id)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (num != other.num)
			return false;
		if (profile_img == null) {
			if (other.profile_img != null)
				return false;
		} else if (!profile_img.equals(other.profile_img))
			return false;
		if (thumb_img == null) {
			if (other.thumb_img != null)
				return false;
		} else if (!thumb_img.equals(other.thumb_img))
			return false;
		return true;
	}
	
}
