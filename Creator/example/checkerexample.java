package inputpath;

/**************************
 * inputnumber inputname
 * 
 * @author inputauthor
 * @description inputdescription
 * @example <pre>
 * 输入一个违反规则的例子
 * </pre>
 */
@RuleProperties(priority = inputpriority, category = inputcategory, message = inputmessage)
public class inputcheckername extends inputsuperclass{
	
	@Override
	public Object visitNode(TNode node, Object data){
		在此写入checker主体
	}
}