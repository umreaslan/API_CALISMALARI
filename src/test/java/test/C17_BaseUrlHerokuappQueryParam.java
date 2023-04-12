package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {

// Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */
     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public  void  get01(){

       /* 1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 17 id'ye sahip bir booking oldugunu test edin
                */
        // 1- url hazirla
        specHerokuApp.pathParam("pp1","booking");

        //2- Expexted data hazirla

        //3- response'i kaydet

        Response response= given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        //Assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(17));

        response.prettyPrint();

    }

    @Test
    public  void  get02(){
        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin


    */

        // 1- URL hazirla
        specHerokuApp.pathParam("pp1","booking");
        specHerokuApp.queryParam("firstname","Eric");

        // 2- Expected  data hazirla

        //3-Response'i kaaydet

        Response response= given().spec(specHerokuApp).get("/{pp1}");
        response.prettyPrint();

        //Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",Matchers.hasSize(1));
        response.prettyPrint();




    }

    @Test
    public  void  get03(){
        /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

        specHerokuApp.pathParam("pp1","booking");
        specHerokuApp.queryParams("firstname","Jim","lastname","Jackson");

        // 3- Response'i kaydet

        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(3));


    }


}
