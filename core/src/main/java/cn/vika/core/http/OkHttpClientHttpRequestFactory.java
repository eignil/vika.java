/*
 * Copyright (c) 2021 vikadata, https://vika.cn <support@vikadata.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cn.vika.core.http;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import cn.vika.core.utils.AssertUtil;
import cn.vika.core.utils.StringUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * implementation base Request Factory
 *
 * @author Shawn Deng
 * @date 2020-10-27 12:08:00
 */
public class OkHttpClientHttpRequestFactory implements ClientHttpRequestFactory {

    private OkHttpClient client;

    public OkHttpClientHttpRequestFactory() {
        this.client = new OkHttpClient();
    }

    public OkHttpClientHttpRequestFactory(OkHttpClient client) {
        AssertUtil.notNull(client, "OkHttpClient must not be null");
        this.client = client;
    }

    /**
     * Set read timeout in milliseconds.
     * @param readTimeout read timeout
     */
    public void setReadTimeout(int readTimeout) {
        this.client = this.client.newBuilder()
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build();
    }

    /**
     * Set connect timeout in milliseconds.
     * @param connectTimeout connect timeout
     */
    public void setConnectTimeout(int connectTimeout) {
        this.client = this.client.newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .build();
    }

    /**
     * Set call timeout in milliseconds.
     * @param callTimeout call timeout
     */
    public void setCallTimeout(int callTimeout){
        this.client = this.client.newBuilder()
            .callTimeout(callTimeout, TimeUnit.MILLISECONDS)
            .build();
    }

    /**
     * Set write timeout in milliseconds.
     * @param writeTimeout write timeout
     */
    public void setWriteTimeout(int writeTimeout){
        this.client = this.client.newBuilder()
            .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
            .build();
    }

    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) {
        return new OkHttpClientRequest(this.client, uri, httpMethod);
    }

    /**
     * build request instance by necessary input param
     *
     * @param uri        connect url
     * @param httpMethod request method way
     * @param headers    request header
     * @param content    request content
     * @return Okhttp Request instance
     * @throws MalformedURLException throw if uri error
     */
    static Request buildRequest(URI uri, HttpMethod httpMethod, HttpHeader headers, byte[] content) throws MalformedURLException {
        // get request content type
        MediaType contentType = getContentType(headers);
        // create Request Body by OkHttp
        RequestBody body = content.length > 0 ||
            okhttp3.internal.http.HttpMethod.requiresRequestBody(httpMethod.name()) ?
            RequestBody.create(contentType, content) : null;
        // Create Okhttp Request
        Request.Builder builder = new Request.Builder().url(uri.toURL()).method(httpMethod.name(), body);
        // Add Header
        headers.forEach((headerName, headerValues) -> {
            for (String headerValue : headerValues) {
                builder.addHeader(headerName, headerValue);
            }
        });
        return builder.build();
    }

    private static MediaType getContentType(HttpHeader header) {
        String rawContentType = header.getFirstValue(HttpHeader.CONTENT_TYPE);
        return StringUtil.hasText(rawContentType) ? okhttp3.MediaType.parse(rawContentType) : null;
    }
}
