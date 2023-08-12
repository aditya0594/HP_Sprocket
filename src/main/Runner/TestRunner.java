package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Aditya Pawar\\IdeaProjects\\HP_Sprocket\\src\\main\\Features\\LandingPage.feature", //the path of the feature files
        glue={"testcases"},
        dryRun = false ,//to check the mapping is proper between feature file and step def file//the path of the step definition files
        //to generate different types of reporting
        monochrome = false//display the console output in a proper readable format
        //strict = true //it will check if any step is not defined in step definition file
        //tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    }

    //ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
    //ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest