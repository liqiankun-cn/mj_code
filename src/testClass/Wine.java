/**
 * 
 */
package testClass;

/**
 * @author qiankun.li
 * 
 */
public class Wine {
	int i=0;
	static {
		System.out.println("Wine static");
	}
	public Wine() {
		System.out.println("init Wine");
	}
	public void fun1() {
		System.out.println("wine fun1...");
		fun2();
	}

	public void fun2() {
		System.out.println("wine fun2");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
}
