package com.geekTrust;

import java.util.Objects;

public class TollCharges {

	private String vehicleType;

	private String vehicleCategory;

	private Integer tollCharged;

	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public Integer getTollCharged() {
		return tollCharged;
	}

	public TollCharges() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TollCharges(String vehicleType, String vehicleCategory, Integer tollCharged) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleCategory = vehicleCategory;
		this.tollCharged = tollCharged;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tollCharged, vehicleCategory, vehicleType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TollCharges other = (TollCharges) obj;
		return Objects.equals(tollCharged, other.tollCharged) && Objects.equals(vehicleCategory, other.vehicleCategory)
				&& Objects.equals(vehicleType, other.vehicleType);
	}

}
