package kr.or.connect.reservation.reservationInfo;

import java.util.Date;
import java.util.List;

public class ReservationInfo {
	
	private int id;
	private int productId;
	private int cancelFlag;
	private int displayInfoId;
	private int userId;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
	private List<Price> prices;
	
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
	public int getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
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
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	@Override
	public String toString() {
		return "ReservationInfo [id=" + id + ", productId=" + productId + ", cancelFlag=" + cancelFlag
				+ ", displayInfoId=" + displayInfoId + ", userId=" + userId + ", reservationDate=" + reservationDate
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", prices=" + prices + "]";
	}
	
}
