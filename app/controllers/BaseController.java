package controllers;

import play.mvc.*;

/**
 * All controllers should extend from this class (there may be intermediate classes).
 */
abstract public class BaseController extends Controller {
    /**
     * If the request parameters contain a page number, return that, else 1. If the return
     * value is less than 1, it is changed to equal 1. The page number is also added to
     * the render args as the variable "page".
     * @return A number greater than or equal to 1.
     */
    @Util
    protected static int getPageNumber() {
        int page = (params._contains("page") ? params.get("page", Integer.class).intValue() : 1);
        if (page < 1) {
            page = 1;
        }
        renderArgs.put("page", page);
        return page;
    }
}
