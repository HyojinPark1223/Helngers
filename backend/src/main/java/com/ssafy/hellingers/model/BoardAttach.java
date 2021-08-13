package com.ssafy.hellingers.model;

import java.util.Date;

import lombok.Data;


@Data
public class BoardAttach {
	private int fileNo;

	private String fileName;
	private String fullName;
	private Date regDate;
	private int boardNo;
	
}
