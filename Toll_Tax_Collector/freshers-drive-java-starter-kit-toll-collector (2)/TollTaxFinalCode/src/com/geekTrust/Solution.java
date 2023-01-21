package com.geekTrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private Map<String, Integer> balanceMap = new HashMap<>();

	private Map<String, Fastag> colMap = new HashMap<>();

	public void print() {
		int total_fastTagCol = 0;
		int totalDiscount = 0;
		int total_CashColl = 0;
		int total_CashFeeColl = 0;
		Map<String, VhicleCategory> vhicleTypeMap = new HashMap<>();
		List<VhicleCategory> vList = new ArrayList<>();

		for (String key : colMap.keySet()) {
			Fastag fastag = colMap.get(key);
			total_fastTagCol += fastag.getTotalAmtColViaFastag();
			totalDiscount += fastag.getTotaldiscount();
			total_CashColl += fastag.getTotalAmtColViaCash();
			total_CashFeeColl += fastag.getFlatFeeForCashPay();
			String vhicleType = fastag.getVehicle_type();
			// System.out.println(vhicleType);
			if (vhicleTypeMap.containsKey(vhicleType)) {

				VhicleCategory vCat = vhicleTypeMap.get(vhicleType);
				vCat.setTotalTollPaid(vCat.getTotalTollPaid() + fastag.getTotalAmtColViaCash()
						+ fastag.getTotalAmtColViaFastag() + fastag.getFlatFeeForCashPay());
				vCat.setTotalvhicle(vCat.getTotalvhicle() + fastag.getNumberOfTollCharged());
				vhicleTypeMap.put(vhicleType, vCat);
				// System.out.println(vhicleTypeMap);
			} else {
				VhicleCategory vCat = new VhicleCategory();
				// System.out.println(key);
				vCat.setVhicleCategory(vhicleType);
				vCat.setTotalTollPaid(fastag.getTotalAmtColViaCash() + fastag.getTotalAmtColViaFastag()
						+ fastag.getFlatFeeForCashPay());
				vCat.setTotalvhicle(fastag.getNumberOfTollCharged());
				vhicleTypeMap.put(vhicleType, vCat);

			}
		}

		// Collections.sort(vhicleTypeMap);

		System.out.println(
				"TOTAL_COLLECTION " + (total_fastTagCol + total_CashColl + total_CashFeeColl) + " " + totalDiscount);
		System.out.println("PAYMENT_SUMMARY " + total_fastTagCol + " " + (total_CashColl + total_CashFeeColl));
		System.out.println("VEHICLE_TYPE_SUMMARY");
		for (String key : vhicleTypeMap.keySet()) {
			vList.add(vhicleTypeMap.get(key));
		}
		Collections.sort(vList, new VhicleSorting());
		for (VhicleCategory v : vList) {
			// v.getTotalTollPaid();
			System.out.println(v.getVhicleCategory() + " " + v.getTotalvhicle());
		}

	}

	public void registerVhicle(String vhicleNumber, int amount) {
		
			if (balanceMap.containsKey(vhicleNumber)) {
				
				balanceMap.put(vhicleNumber, balanceMap.get(vhicleNumber) + amount);
				
			} else {
				balanceMap.put(vhicleNumber, amount);
			}
			//System.out.println(balanceMap);
	}

	public void collectToll(String vhicleNumber, String vhicleType) throws NoVehicleTypeFound {

		if (colMap.containsKey(vhicleNumber)) {
			Fastag obj = colMap.get(vhicleNumber); 
			obj.collectToll();
			obj.setNumberOfTollCharged(obj.getNumberOfTollCharged() + 1);
			colMap.put(vhicleNumber, obj);
		} else {

			Fastag obj = new Fastag();
			if (balanceMap.containsKey(vhicleNumber)) {
				obj.setFastagBalance(balanceMap.get(vhicleNumber));
			}
			obj.setVehicle_number(vhicleNumber);
			obj.setVehicle_type(vhicleType);
			obj.collectToll();
			obj.setReverseJourney(true);
			obj.setNumberOfTollCharged(1);
			colMap.put(vhicleNumber, obj);

		}
	}

}
