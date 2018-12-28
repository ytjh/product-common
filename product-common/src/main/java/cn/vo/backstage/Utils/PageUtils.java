package cn.vo.backstage.Utils;

import java.util.Map;

public class PageUtils {
	
	public static Integer getPageIndex(Integer page,Integer size){
		int pageindex=page-1;
    	if(pageindex>0){
    		pageindex=pageindex*10;
    	}
    	int pageSize=page*10;
    	return pageindex;
		
	}
	public static Integer getPageSize(Integer page,Integer size){
		int pageSize=page*size;
		return pageSize;
	}
	

}
