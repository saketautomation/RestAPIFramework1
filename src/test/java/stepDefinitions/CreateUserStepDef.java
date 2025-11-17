package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateUserStepDef {
    Response response;
    @Given("API endpoint is available")
    public void api_endpoint_is_available() {
        RestAssured.baseURI="https://reqres.in/api/users";

    }
    @When("I hit the POST request")
    public void i_hit_the_post_request() {
        response = given().contentType(ContentType.JSON).header("x-api-key", "reqres-free-v1")
                .body("{\n" +
                        "\"name\": \"Sri Lankan Airways\",\n" +
                        "\"job\": \"Airline\"\n" +
                        "}")
                .log().all()
                .when().post().then().log().all().extract().response();

    }
    @Then("status code is")
    public void status_code_is(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertEquals(response.statusCode(),Integer.parseInt(dataTable.asList().get(0)));
    }

//    @Given("the following user details")
//    public void the_following_user_details(io.cucumber.datatable.DataTable dataTable) {
//        List<Map<String, String>> list = dataTable.asMaps();
//        list.forEach(m->{
//            System.out.println(m.get("Username")+" - "+m.get("Password")+" -"+m.get("Role"));
//        });
//    }
//@Given("the following user details")
//public void the_following_user_details(io.cucumber.datatable.DataTable dataTable) {
//    dataTable.asMaps(String.class,String.class).forEach(row->
//    {
//        String username = row.get("Username");
//        String password = row.get("Password");
//        String role = row.get("Role");
//
//        System.out.printf("Username: %s, Password: %s, Role: %s%n",
//                username, password, role);
//    });
//}

    @Given("the following user details")
    public void the_following_user_details(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMaps(String.class,String.class).stream()
                .map(row->String.format("Username: %s, Password: %s, Role: %s",
                        row.get("Username"), row.get("Password"), row.get("Role"))).forEach(System.out::println);
    }

    @Given("below are the users")
    public void below_are_the_users(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asLists().
                forEach(data-> System.out.printf("Firstname is - %s, Lastname is - %s and email is - %s%n"
                ,data.get(0),data.get(1),data.get(2)));
//        dataTable.asLists().forEach(this::printDatatable);
    }

    private void printDatatable(List<String> data){
        System.out.printf("Firstname is - %s, Lastname is - %s and email is - %s%n"
                ,data.get(0),data.get(1),data.get(2));
    }


    @Given("below are the users list {string} and {string} and {int}")
    public void belowAreTheUsersList(String arg0, String arg1, int arg2) {
        System.out.println(arg0+" - "+arg1+" "+arg2);
    }

    @Given("Launch the browser")
    public void launchTheBrowser() {
        System.out.println("this is background setup");
    }
}
