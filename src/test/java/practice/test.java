package practice;

public class test {

	String para1;
	StringBuffer para2;
	public test(){
	System.out.println("temp");
	}
	public void method1(String param){
	para1=param.replace("a","b");
	}
	public void method2(StringBuffer param){
	para2=param.replace(1,3,"c");
	}
	}
	 class Test2 extends test{
	public Test2(){
	System.out.println("Test");
	}
	public static void main(String[] args){
	Test2 obj=new Test2();
	obj.method1(new String("javaTest"));
	obj.method2(new StringBuffer("javaTest"));
	System.out.println(obj.para1);
	System.out.println(obj.para2.toString());
}
}