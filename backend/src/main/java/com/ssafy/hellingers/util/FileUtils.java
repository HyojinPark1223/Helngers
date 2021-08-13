package com.ssafy.hellingers.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hellingers.model.BoardAttach;

public class FileUtils {

private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
	
	/**
	 * (다중) 파일 업로드
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<BoardAttach> uploadFiles(MultipartFile[] files, String uploadPath) throws Exception {
		
		ArrayList<BoardAttach> attachList = new ArrayList<BoardAttach>();
		
		// 업로드 경로에 파일 복사
		for (MultipartFile file : files) {
			// 파일 존재여부 확인
			if( file.isEmpty() ) {
				continue;
			}
			
			// 파일명 중복 방지를 위한 고유 ID 생성
			UUID uid = UUID.randomUUID();
			
			// 실제 원본 파이 이름
			String originalFileName = file.getOriginalFilename();
			
			// UID_강아지.png
			String uploadFileName = uid.toString() + "_" + originalFileName;
			
			// 업로드 폴더에 업로드할 파일 복사 (upload)
			byte[] fileData = file.getBytes();
			File target = new File(uploadPath, uploadFileName);
			FileCopyUtils.copy(fileData, target);
			
			BoardAttach attach = new BoardAttach();
			attach.setFullName(uploadPath + "/" + uploadFileName);
			attach.setFileName(originalFileName);
			attachList.add(attach);
		}
		
		return attachList;
		
	}
		
		
	/**
	 * 실제 파일 삭제 - 해당 게시글 전체파일 삭제
	 * @param deleteFileList
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteFiles(List<BoardAttach> deleteFileList) throws Exception {
		
		// 해당 게시글의 첨부파일 전체 삭제
		for (BoardAttach deleteFile : deleteFileList) {
			String fullName = deleteFile.getFullName();
			
			File file = new File(fullName);
			// 실제로 파일이 존재하는지 확인
			if(file.exists()) {
				// 파일 삭제
				if(file.delete()) {
					log.info("삭제한 파일 : " + fullName);
					log.info("파일삭제 성공");
					
					// 파일 삭제 성공 
					return true;
				} else {	
					log.info("파일삭제 실패");
					
				}
			} else {
				log.info("삭제(실패) : " + fullName);
				log.info("파일이 존재하지 않습니다.");
				
			}
		}
		return false;
	}
	
	
}
