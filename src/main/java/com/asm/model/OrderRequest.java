package com.asm.model;

import java.util.List;

public class OrderRequest {

	private List<OrderAssetQuantity> orderAssetQuantity;
	private int userId;

	public List<OrderAssetQuantity> getOrderAssetQuantity() {
		return orderAssetQuantity;
	}

	public void setOrderAssetQuantity(List<OrderAssetQuantity> orderAssetQuantity) {
		this.orderAssetQuantity = orderAssetQuantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
