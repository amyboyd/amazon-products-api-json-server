package controllers;

import play.Play;
import play.Logger;
import play.mvc.*;
import java.util.*;
import com.alienmegacorp.amazonproducts.AmazonProductsAPI;
import com.alienmegacorp.amazonproducts.Endpoint;
import com.alienmegacorp.amazonproducts.internals.Item;

public class Application extends BaseController {
    public static void getItems(final String country, final String query) {
        final Endpoint endpoint = Endpoint.valueOf(country.toUpperCase());

        final AmazonProductsAPI amazon = AmazonProductsAPI.getInstance(
            endpoint,
            (String) Play.configuration.get("aws.accessKey"),
            (String) Play.configuration.get("aws.secretKey"),
            (String) Play.configuration.get("aws.trackingId")
        );

        final List<Item> amazonItems = amazon.itemSearch(
            query,
            // Response groups.
            // http://docs.amazonwebservices.com/AWSECommerceService/2010-09-01/DG/index.html?ItemSearch.html
            (String) Play.configuration.get("aws.responseGroups"),
            // Search index.
            // http://docs.aws.amazon.com/AWSECommerceService/latest/DG/APPNDX_SearchIndexValues.html
            (String) Play.configuration.get("aws.searchIndex")
        );

        renderJSON(amazonItems);
    }

    public static void getCountries() {
        renderJSON(Endpoint.values());
    }
}
