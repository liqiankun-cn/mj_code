/**
 * 
 */
package testClass;

/**
 * @author qiankun.li
 *
 */
public class Jnc extends Wine {
	int i=1;
	static{
		System.out.println("static Jnc");
	}

	public Jnc() {
		System.out.println("init Jnc");
	}
	/*public void fun1(){
		System.out.println("jnc fun1 ");
	}*/
	public void fun1(String a){
		System.out.println("jnc fun1 param :"+a);
		fun2();
	}
	
	public void fun2(){
		System.out.println("jnc fun2");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
}
