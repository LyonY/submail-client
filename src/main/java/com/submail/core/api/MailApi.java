package com.submail.core.api;

import java.util.Map;

import com.submail.Response;
import com.submail.config.AppConfig;

/**
 * A Sender class define the mail mode to send HTTP request.
 * 
 * @see Api
 * @see AbstractApi
 * @version 1.0 at 2014/10/28
 */
public class MailApi extends AbstractApi {

    private static final String API_SEND = "/mail/send.json";
    private static final String API_XSEND = "/mail/xsend.json";
    private static final String API_SUBSCRIBE = "/addressbook/mail/subscribe.json";
    private static final String API_UNSUBSCRIBE = "/addressbook/mail/unsubscribe.json";

    public MailApi(AppConfig config) {
        this.config = config;
    }

    /**
     * Send request data to server.The data consists of two parts. One of them is original data,and
     * another is signature.For example,the original data is
     * <p>
     * address=jam@submail.cn?name=jam
     * </p>
     * .Then,the final request data is
     * <p>
     * address=jam@submail.cn?name=jam?appid=xxx?appkey=xxx?timestamp=xxx?signature=xxx?
     * <p>
     * 
     * @see RequestSigner#getSignature()
     * @param data
     *            is the original data only contains content.
     */
    @Override
    public Response send(Map<String, Object> data) {
        return request(config.getApiDomain() + API_SEND, data);
    }

    @Override
    public Response xsend(Map<String, Object> data) {
        return request(config.getApiDomain() + API_XSEND, data);
    }

    @Override
    public Response subscribe(Map<String, Object> data) {
        return request(config.getApiDomain() + API_SUBSCRIBE, data);
    }

    @Override
    public Response unsubscribe(Map<String, Object> data) {
        return request(API_UNSUBSCRIBE, data);
    }
}
