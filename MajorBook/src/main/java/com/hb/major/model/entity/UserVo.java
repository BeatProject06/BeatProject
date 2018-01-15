package com.hb.major.model.entity;

public class UserVo {

	private String kakao_id;
	private String kakao_nick;
	private String profile_img;
	private String thumb_img;
	
	public UserVo() {
	}

	public String getKakao_id() {
		return kakao_id;
	}

	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}

	public String getKakao_nick() {
		return kakao_nick;
	}

	public void setKakao_nick(String kakao_nick) {
		this.kakao_nick = kakao_nick;
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

	@Override
	public String toString() {
		return "UserVo [kakao_id=" + kakao_id + ", kakao_nick=" + kakao_nick + ", profile_img=" + profile_img
				+ ", thumb_img=" + thumb_img + "]";
	}

	public UserVo(String kakao_id, String kakao_nick, String profile_img, String thumb_img) {
		super();
		this.kakao_id = kakao_id;
		this.kakao_nick = kakao_nick;
		this.profile_img = profile_img;
		this.thumb_img = thumb_img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kakao_id == null) ? 0 : kakao_id.hashCode());
		result = prime * result + ((kakao_nick == null) ? 0 : kakao_nick.hashCode());
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
		if (kakao_id == null) {
			if (other.kakao_id != null)
				return false;
		} else if (!kakao_id.equals(other.kakao_id))
			return false;
		if (kakao_nick == null) {
			if (other.kakao_nick != null)
				return false;
		} else if (!kakao_nick.equals(other.kakao_nick))
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