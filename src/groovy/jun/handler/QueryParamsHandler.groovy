package jun.handler;

import java.nio.charset.Charset;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.NameValuePair;
import groovy.transform.InheritConstructors;

import jun.core.Request;
import jun.core.Response;
import jun.handler.AbstractMiddlewareHandler;


@InheritConstructors
public class QueryParamsHandler extends AbstractMiddlewareHandler {
    public Response handle(final Request request) {

        if (request.queryString) {
            def rawParams = URLEncodedUtils.parse(request.queryString, Charset.forName("UTF-8"));
            def params = rawParams.collectEntries { [(it.getName()):(it.getValue())]}
            request.queryParams = params;
        } else {
            request.queryParams = [:];
        }

        return this.handler.handle(request);
    }
}