package kr.co.jboard2.service;

import java.util.List;

import kr.co.jboard2.dao.FileDAO;
import kr.co.jboard2.dto.FileDTO;

public enum FileService {
	INSTANCE;
	
	private FileDAO dao = new FileDAO();

	public void insertFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	public FileDTO selectFile(String fno) {
		return dao.selectFile(fno);
	}
	
	public List<FileDTO> selectFiles() {
		return dao.selectFiles();
	}
	
	public void updateFile(FileDTO dto) {
		dao.updateFile(dto);
	}
	
	public List<String> deleteFile(String ano) {
		return dao.deleteFile(ano);
	}
}