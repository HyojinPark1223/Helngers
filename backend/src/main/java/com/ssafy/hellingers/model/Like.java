package com.ssafy.hellingers.model;

import java.util.Date;

import lombok.Data;

@Data
public class Like {
	private int likeNo;
	private int likeType;
	private int typeNo;
	private int userNo;
	private Date regDate;	
}
