package com.geekTrust;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fastag {

	private String vehicle_number;

	private int fastagBalance;

	private String vehicle_type;

	private int totalAmtColViaFastag;

	private int totalAmtColViaCash;

	private int flatFeeForCashPay;

	private int totaldiscount;

	private boolean reverseJourney;

	private int numberOfTollCharged;

	public Fastag() {

	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Integer getFastagBalance() {
		return fastagBalance;
	}

	public void setFastagBalance(Integer fastagBalance) {
		this.fastagBalance = fastagBalance;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Integer getTotalAmtColViaFastag() {
		return totalAmtColViaFastag;
	}

	public void setTotalAmtColViaFastag(Integer totalAmtColViaFastag) {
		this.totalAmtColViaFastag = totalAmtColViaFastag;
	}

	public Integer getTotalAmtColViaCash() {
		return totalAmtColViaCash;
	}

	public void setTotalAmtColViaCash(Integer totalAmtColViaCash) {
		this.totalAmtColViaCash = totalAmtColViaCash;
	}

	public Integer getFlatFeeForCashPay() {
		return flatFeeForCashPay;
	}

	public void setFlatFeeForCashPay(Integer flatFeeForCashPay) {
		this.flatFeeForCashPay = flatFeeForCashPay;
	}

	public Integer getTotaldiscount() {
		return totaldiscount;
	}

	public void setTotaldiscount(Integer totaldiscount) {
		this.totaldiscount = totaldiscount;
	}

	public Boolean getReverseJourney() {
		return reverseJourney;
	}

	public void setReverseJourney(Boolean reverseJourney) {
		this.reverseJourney = reverseJourney;
	}

	public int getNumberOfTollCharged() {
		return numberOfTollCharged;
	}

	public void setNumberOfTollCharged(int numberOfTollCharged) {
		this.numberOfTollCharged = numberOfTollCharged;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fastagBalance, flatFeeForCashPay, reverseJourney, totalAmtColViaCash, totalAmtColViaFastag,
				totaldiscount, vehicle_number, vehicle_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fastag other = (Fastag) obj;
		return Objects.equals(fastagBalance, other.fastagBalance)
				&& Objects.equals(flatFeeForCashPay, other.flatFeeForCashPay)
				&& Objects.equals(reverseJourney, other.reverseJourney)
				&& Objects.equals(totalAmtColViaCash, other.totalAmtColViaCash)
				&& Objects.equals(totalAmtColViaFastag, other.totalAmtColViaFastag)
				&& Objects.equals(totaldiscount, other.totaldiscount)
				&& Objects.equals(vehicle_number, other.vehicle_number)
				&& Objects.equals(vehicle_type, other.vehicle_type);
	}

	public void collectToll() throws NoVehicleTypeFound {
		
		TollCharges charges = getTollCharges(vehicle_type);
		
		if (reverseJourney) {

			Integer chargeAmt = charges.getTollCharged() / 2;
			if (fastagBalance < chargeAmt) {
				flatFeeForCashPay += 40;
				totalAmtColViaCash += chargeAmt - fastagBalance;
				totalAmtColViaFastag += fastagBalance;
				fastagBalance = 0;
				totaldiscount = chargeAmt;

			} else {
				totalAmtColViaFastag += chargeAmt;
				fastagBalance -= chargeAmt;
				totaldiscount = chargeAmt;
			}

			reverseJourney = false;

		} else {

			Integer chargeAmt = charges.getTollCharged();

			if (fastagBalance < chargeAmt) {
				flatFeeForCashPay += 40;
				totalAmtColViaCash += chargeAmt - fastagBalance;
				totalAmtColViaFastag += fastagBalance;
				fastagBalance = 0;
			} else {
				totalAmtColViaFastag += chargeAmt;

				fastagBalance -= chargeAmt;
			}

			reverseJourney = true;

		}

	}

	public TollCharges getTollCharges(String vehicleType) throws NoVehicleTypeFound {
		// System.out.println(vehicleType);
		Map<String, TollCharges> chargesMap = new HashMap<>();
		
		chargesMap.put("TRUCK",new TollCharges("Truck", "Heavy vehicle", 200));
		chargesMap.put("BUS",new TollCharges("Bus", "Heavy vehicle", 200));
		chargesMap.put("VAN",new TollCharges("VAN", "Light vehicle ", 100));
		chargesMap.put("CAR",new TollCharges("Truck", "Light vehicle", 100));
		chargesMap.put("RICKSHAW",new TollCharges("Truck", "Light vehicle", 100));
		chargesMap.put("SCOOTER",new TollCharges("Scooter", "Two wheeler", 50));
		chargesMap.put("MOTORBIKE",new TollCharges("Moterbike", "Two wheeler", 50));
		
		if(chargesMap.containsKey(vehicleType)) {
			return chargesMap.get(vehicleType);
		}else {
			throw new NoVehicleTypeFound("No vhicle Registered with this vhicle type ");
		}
	}

}
