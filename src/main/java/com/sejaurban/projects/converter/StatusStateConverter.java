package com.sejaurban.projects.converter;

import java.util.ArrayList;
import java.util.List;

import com.sejaurban.projects.dto.StatusStateDTO;
import com.sejaurban.projects.state.StateFactory;
import com.sejaurban.projects.state.StatusState;

public class StatusStateConverter {

	public static StatusStateDTO getStatusStateAsDTO(StatusState statusState) {
		StatusStateDTO statusStateDTO = new StatusStateDTO();
		statusStateDTO.setId(statusState.getId());
		statusStateDTO.setProjects(statusState.getProjects() != null ? ProjectConverter.getListAsDTO(statusState.getProjects()) : null);
		statusStateDTO.setStatusName(statusState.getStatusName());
		return statusStateDTO;
	}
	
	public static StatusState getStatusStateAsModel(StatusStateDTO statusStateDTO) {
		if(statusStateDTO.getId() == null) {
			
		}
		StatusState statusState = StateFactory.create(statusStateDTO.getStatusName());
		statusState.setId(statusStateDTO.getId());
		statusState.setProjects(statusStateDTO.getProjects() != null ? ProjectConverter.getListAsModel(statusStateDTO.getProjects()) : null);
		return statusState;
	}
	
	
	public static List<StatusState> getListAsModel(List<StatusStateDTO> listOfStatusStateDTO) {
		List<StatusState> listOfStatusState = new ArrayList<>();
		listOfStatusStateDTO.forEach(statusStateDTO -> {
			listOfStatusState.add(getStatusStateAsModel(statusStateDTO));
		});
		return listOfStatusState;
	}
	
	public static List<StatusStateDTO> getListAsDTO(List<StatusState> listOfStatusState) {
		List<StatusStateDTO> listOfStatusStateDTO = new ArrayList<>();
		listOfStatusState.forEach(statusState -> {
			listOfStatusStateDTO.add(getStatusStateAsDTO(statusState));
		});
		return listOfStatusStateDTO;
	}
}
