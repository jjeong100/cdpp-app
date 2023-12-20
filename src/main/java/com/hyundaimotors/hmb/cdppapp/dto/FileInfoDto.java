package com.hyundaimotors.hmb.cdppapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfoDto {

	private String fileName;
	private byte[] attachFile;
	private String url;
}
