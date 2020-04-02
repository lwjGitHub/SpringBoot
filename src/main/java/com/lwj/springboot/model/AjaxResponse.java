package com.lwj.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author K_MAX
 */
@Data
@NoArgsConstructor
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse resultBean  = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setIsok(true);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data){
        AjaxResponse resultBean  = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setIsok(true);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
