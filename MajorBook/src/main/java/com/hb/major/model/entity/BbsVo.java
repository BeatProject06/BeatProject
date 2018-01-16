package com.hb.major.model.entity;

import java.sql.Date;

public class BbsVo {
	private int no;
	private String nickName;
	private String university;
	private String dept;
	private String bookName;
	private String publisher;
	private String author;
	private String ISBN;
	private int costPrice;
	private int salePrice;
	private int view;
	private String status;
	private Date day;
	
	public BbsVo() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "BbsVo [no=" + no + ", nickName=" + nickName + ", university=" + university + ", dept=" + dept
				+ ", bookName=" + bookName + ", publisher=" + publisher + ", author=" + author + ", ISBN=" + ISBN
				+ ", costPrice=" + costPrice + ", salePrice=" + salePrice + ", view=" + view + ", status=" + status
				+ ", day=" + day + "]";
	}

	public BbsVo(int no, String nickName, String university, String dept, String bookName, String publisher,
			String author, String iSBN, int costPrice, int salePrice, int view, String status, Date day) {
		super();
		this.no = no;
		this.nickName = nickName;
		this.university = university;
		this.dept = dept;
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
		ISBN = iSBN;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.view = view;
		this.status = status;
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + costPrice;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + no;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + salePrice;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((university == null) ? 0 : university.hashCode());
		result = prime * result + view;
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
		BbsVo other = (BbsVo) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (costPrice != other.costPrice)
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (no != other.no)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (salePrice != other.salePrice)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		if (view != other.view)
			return false;
		return true;
	}
	
}
