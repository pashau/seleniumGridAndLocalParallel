package suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({tests.Login1_Test.class, tests.Login2_Test.class})
@SelectPackages("tests")
@ExcludeClassNamePatterns({"^.*BaseTest?$"})
public class AllTestsSuite {

}

