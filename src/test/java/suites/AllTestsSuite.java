package suites;

import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("tests")
@ExcludeClassNamePatterns({"^.*BaseTest?"})
public class AllTestsSuite {

}

