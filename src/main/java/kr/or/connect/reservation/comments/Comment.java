package kr.or.connect.reservation.comments;

import java.util.Date;
import java.util.List;

public class Comment {
	
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String reservationEmail;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	private List<CommentImages> reservationUserCommentImages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmai) {
		this.reservationEmail = reservationEmai;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public List<CommentImages> getCommentImagesList() {
		return reservationUserCommentImages;
	}
	public void setCommentImagesList(List<CommentImages> commentImagesList) {
		this.reservationUserCommentImages = commentImagesList;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", reservationEmai=" + reservationEmail + ", comment=" + comment + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", commentImagesList=" + reservationUserCommentImages + "]";
	}
	
}
