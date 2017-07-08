//描述一个规则的类
public class Rule {
	public String number;//规则序号,手动输入
	public String name;//规则名，手动输入
	public String message;//规则内容,手动输入
	public String description;//规则描述,手动输入
	public String category;//规则种类,下拉选择
	public String priority;//规则优先级,下拉选择
	
	public Rule(String[] input)
	{
		this.number=input[0];
		this.name=input[1];
		this.message=input[2];
		this.description=input[3];
		this.category=input[4];
		this.priority=input[5];
	}
}
