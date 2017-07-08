package inputpath;

/**************************
 * <p>功能：测试规则inputrulename
 * 
 * @author inputauthor
 * @version v1.0
 * @since inputtime
 */
 
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cn.spac.specchecker.test.RuleTestDriverWithAnnotation;

public class inputtestname {
	
	@Test
	public void Test_0(){
		String programName = "testcases/basic/inputrulename.c";
		String className = "basic.inputrulename";
		assertEquals(在此输入预期输出, RuleTestDriverWithAnnotation.runtest(programName, className));
	}
}