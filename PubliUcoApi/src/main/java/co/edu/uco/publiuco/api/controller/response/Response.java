package co.edu.uco.publiuco.api.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;

public final class Response<T> {
	private List<T> dataList;
	private List<String> messageStrings;

	public Response(List<T> dataList, List<String> messageStrings) {
		super();
		setDataList(dataList);
		setMessageStrings(messageStrings);
	}

	public Response(){
		setDataList(new ArrayList<>());
		setMessageStrings(new ArrayList<>());
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = UtilObject.getDefault(dataList, new ArrayList<>());
	}

	public List<String> getMessageStrings() {
		return messageStrings;
	}

	public void setMessageStrings(List<String> messageStrings) {
		this.messageStrings = UtilObject.getDefault(messageStrings, new ArrayList<>());;
	}
	
	
}
