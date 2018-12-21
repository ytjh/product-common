package cn.vo.backstage.Utils;

import java.util.List;

import org.springframework.data.domain.Page;

public class ListResult<T> {
	
	 private String code;

    private String msg;

    private Long count;

    private List<T> data;

    public ListResult() {
        this("0", "", 0L, null);
    }

    public ListResult(Page<T> page) {
        this("0", "", page == null ? 0 : page.getTotalElements(), page == null ? null : page.getContent());
    }

    public ListResult(String code, String msg, Long count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

    
	
}
