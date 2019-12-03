package cn.net.immortal.common.response;

public class ResponseWrapper<T> {

    private Boolean flag;

    private T body;


    private ResponseWrapper(Boolean flag, T body){
        this.flag = flag;
        this.body = body;
    }

    public static <T> ResponseWrapper<T> success(T body){
        return new ResponseWrapper<>(Boolean.TRUE, body);
    }

    public static ResponseWrapper<String> failure(String msg){
        return new ResponseWrapper<>(Boolean.FALSE,msg);
    }

    public Boolean getFlag() {
        return flag;
    }

    public T getBody() {
        return body;
    }
}
