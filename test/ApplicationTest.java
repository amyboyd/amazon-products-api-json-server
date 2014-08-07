import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testGetItems_countryCodeLowerCase() {
        Response response = GET("/items?query=boots&country=us");
        assertStatus(200, response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testGetItems_countryCodeUpperCase() {
        Response response = GET("/items?query=boots&country=US");
        assertStatus(200, response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testGetCountries() {
        Response response = GET("/countries");
        assertStatus(200, response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

}
