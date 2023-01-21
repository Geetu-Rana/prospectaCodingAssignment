package com.geekTrust;

import java.util.Comparator;

public class VhicleSorting implements Comparator<VhicleCategory> {

	@Override
	public int compare(VhicleCategory o1, VhicleCategory o2) {
		if (o1.getTotalTollPaid() == o2.getTotalTollPaid()) {
			return o1.getVhicleCategory().compareTo(o2.getVhicleCategory());
		} else {
			return o2.getTotalTollPaid() - o1.getTotalTollPaid();
		}

	}

}
