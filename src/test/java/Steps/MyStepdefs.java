package Steps;

import Hooks.MyHooks;
import cucumber.api.HookTestStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class MyStepdefs  {

    @Given("today is Sunday")
    public void todayIsSunday() throws Exception {
        Assert.assertEquals("TEST","TEST");
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        Assert.assertEquals("TEST","TEST");
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String arg0) {
        Assert.assertEquals("TEST","TEST");
    }
}
