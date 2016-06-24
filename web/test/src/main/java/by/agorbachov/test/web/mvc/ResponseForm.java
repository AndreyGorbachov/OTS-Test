package by.agorbachov.test.web.mvc;

public class ResponseForm {

	private Object data;

	private Integer resultCode = ControllerConstants.RESULT_SUCCESS;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

}
