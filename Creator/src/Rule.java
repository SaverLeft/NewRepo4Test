//����һ���������
public class Rule {
	public String number;//�������,�ֶ�����
	public String name;//���������ֶ�����
	public String message;//��������,�ֶ�����
	public String description;//��������,�ֶ�����
	public String category;//��������,����ѡ��
	public String priority;//�������ȼ�,����ѡ��
	
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
