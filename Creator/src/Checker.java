import java.io.File;

public class Checker {
	
	//检查所有创建文件数据
	public static void CheckAll(Creator createdata)
	{
		
	}
	
	//检查输入文件或文件夹名是否正确,仅输入路径最后的文件夹名和不带后缀的文件名
	public static boolean ValidFileCheck(String inputstr)
	{
		if(inputstr == null) return false;
		
		//去除首尾空格
		while(inputstr.substring(0,1).equals(" ")) inputstr=inputstr.substring(1,inputstr.length());
		while(inputstr.substring(inputstr.length()-1,inputstr.length()).equals(" ")) inputstr=inputstr.substring(0,inputstr.length()-1);
		
		if(inputstr.length()==0) return false;
		
		if(inputstr.indexOf("/")!=-1) return false;
		if(inputstr.indexOf("\\")!=-1) return false;
		if(inputstr.indexOf(":")!=-1) return false;
		if(inputstr.indexOf("?")!=-1) return false;
		if(inputstr.indexOf("\"")!=-1) return false;
		if(inputstr.indexOf("<")!=-1) return false;
		if(inputstr.indexOf(">")!=-1) return false;
		if(inputstr.indexOf("|")!=-1) return false;
		if(inputstr.equalsIgnoreCase("nul")) return false;
		if(inputstr.equalsIgnoreCase("aux")) return false;
		if(inputstr.equalsIgnoreCase("con")) return false;
		if(inputstr.equalsIgnoreCase("com1")) return false;
		if(inputstr.equalsIgnoreCase("lpt1")) return false;
		return true;
	}
	/*
	//检查输入文件全路径是否过长
	public static boolean FilePathTooLongCheck(String fullpath)
	{
		
	}
	*/
	//检查文件是否存在,type=1意为文件是checker文件，2为脚本文件，3为用例文件,其中用例文件只检测_0后缀，默认_0不存在时_0到_9都不存在
	public static boolean FileExistCheck(String folderpath,String filename,int type)
	{
		File file;
		switch(type)
		{
			case 1:file=new File(folderpath+filename+".java");break;
			case 2:file=new File("Test"+folderpath+filename+".java");break;
			case 3:file=new File(folderpath+filename+"_0.c");break;
			default: return false;
		}
		if(!file.exists()) return false;
		else return true;
	}
	
	//检查输入的规则号是否符合格式
	public static boolean RuleNumberCheck(String number)
	{
		String[] figures=number.split(".");
		for (int i = 0;i < figures.length; i++)
		{
			if (figures[i].length()==0) return false;
			for (int j = 0; i < figures[i].length(); j++)
				if (!Character.isDigit(figures[i].charAt(j))) return false;
		}
		return true;
	}
}
