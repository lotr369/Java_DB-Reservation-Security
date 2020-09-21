package kr.or.connect.reservation.reservationInfo;

public class Price {
	
	private int id;
	private int count;
	private int productPriceId;
	private Long reservationInfoId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}
	public Long getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Long reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	@Override
	public String toString() {
		return "Price [id=" + id + ", count=" + count + ", productPriceId=" + productPriceId + ", reservationInfoId="
				+ reservationInfoId + "]";
	}

}
