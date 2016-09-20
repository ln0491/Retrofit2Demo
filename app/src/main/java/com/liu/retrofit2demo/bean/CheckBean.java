package com.liu.retrofit2demo.bean;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 14:36
 */
public class CheckBean {


    /**
     * reason : 成功的返回
     * result : {"code":100000,"text":"eee"}
     * error_code : 0
     */

    public String       reason;
    /**
     * code : 100000
     * text : eee
     */

    public ResultEntity result;
    public int error_code;

    public static class ResultEntity {
        public int    code;
        public String text;

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "code=" + code +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CheckBean{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
