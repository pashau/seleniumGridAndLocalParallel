package suites;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@Execution(ExecutionMode.CONCURRENT)
@SelectPackages("tests")
@ExcludeClassNamePatterns({"^.*BaseTest?$"})
public class AllTestsSuite {

}