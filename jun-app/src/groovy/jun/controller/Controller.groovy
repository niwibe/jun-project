package jun.controller;

import jun.handler.AbstractHandler
import jun.core.Response;

abstract class Controller {
    def resolveTo = null;
    def contentType = "text/html"

    // def handle(request) {
    //     def responseCandidate = this."$resolveTo"(request);
    //     if (responseCandidate instanceof String) {
    //         return new Response(responseCandidate, 200, contentType);
    //     } else if (responseCandidate instanceof Response) {
    //         return responseCandidate;
    //     } else {
    //         throw RuntimeException("Temporary not supported response");
    //     }
    // }
}