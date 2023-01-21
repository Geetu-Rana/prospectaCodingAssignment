package com.geekTrust;

public class VhicleCategory {

	private String vhicleCategory;

	private int TotalTollPaid;

	private int totalvhicle;

	public String getVhicleCategory() {
		return vhicleCategory;
	}

	public int getTotalTollPaid() {
		return TotalTollPaid;
	}

	public int getTotalvhicle() {
		return totalvhicle;
	}

	public VhicleCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setVhicleCategory(String vhicleCategory) {
		this.vhicleCategory = vhicleCategory;
	}

	public void setTotalTollPaid(int totalTollPaid) {
		TotalTollPaid = totalTollPaid;
	}

	public void setTotalvhicle(int totalvhicle) {
		this.totalvhicle = totalvhicle;
	}

	@Override
	public String toString() {
		return "VhicleCategory [vhicleCategory=" + vhicleCategory + ", TotalTollPaid=" + TotalTollPaid
				+ ", totalvhicle=" + totalvhicle + "]";
	}

}
