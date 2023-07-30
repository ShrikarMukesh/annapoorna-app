package com.annapoorna.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Referral {

	private String id;

	private String referrerId;
	private String referredId;
	private boolean rewardGiven;
}

