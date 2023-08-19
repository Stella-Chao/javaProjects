import java.io.*;
import java.util.ArrayList;

public class TypeTest {
    // 1. JavaType内置有八种 *基本类型* ，在java.lang中，分别有Character，Bool，四种整形与两种浮点型
    // *引用类型*，
    // final声明固定常量 与 #define类似
    // 字符串类型 String ，'\'用于字符串中转义
    //
    public static void main(String[] args) { // 类似 python if __name__ == "__main__":
        // 本包为主程序时执行,由JVM调用，依次以下代码
        System.out.println("1. 基本数据类型");
        System.out.println("byte.SIZE: " + Byte.SIZE);
        System.out.println("char.SIZE: " + Character.SIZE);
        System.out.println("float.SIZE: " + Float.SIZE);
        System.out.println("double.SIZE: " + Double.SIZE);
        System.out.println("int.SIZE: " + Integer.SIZE);
        System.out.println("long.SIZE: " + Long.SIZE + '\n');
        final double PI = 3.14;
        System.out.println("2. 使用final 定义常量");
        System.out.println("PI  : " + PI);
        System.out.println();
        // 在程序堆区实例化一个TypeTest对象, 线程共享
        // 自选java的GC方法，或手动释放该内存
        System.out.println("采用ClassName tmp = new ClassName() 在堆区创建类");
        TypeTest tmpTypeName = new TypeTest("Byte");
        tmpTypeName.printName();
        // 直接用类名去访问静态变量
        System.out.println("3.  应直接用类名访问static声明的静态变量: TypeTest.typeNumber\n");
        System.out.println("Type number:" + TypeTest.typeNumber);
        System.out.println("\n4. 测试数组，StringBuffer的append以及ArrayList数组add操作");
        tmpTypeName.testArray();
        System.out.println(
                "\n5. 测试io操作，使用BufferedReader，以及new InputStreamReader(System.io)获取控制台信息，以及try{}catch{} IO异常处理");
        tmpTypeName.testIO();
    }

    public void pupAge() {
        // 2. 局部变量 age 仅在作用域有效，初始化后才可使用
        int age = 0;
        age = age + 7;
        System.out.println("age = " + age);
    }

    // 实例变量，对象实例化时创建
    String name;

    // 静态变量，使用static声名，一般用作常量，处于静态存储区, 程序只有一份
    public static final int typeNumber = 6;

    // 类的构造函数
    public TypeTest(String tName) {
        name = tName;
    }

    // 定义一个方法，方法和局部变量在程序内存中，都在栈中，调用时创建，结束释放
    // 栈中数据仅线程自己访问
    public void printName() {
        System.out.print("Type is " + name);
    }

    // 修饰符，一般放在最前端，public所有类可见，
    // protected 同一个包中类可见，private 仅同一类可见
    // 3. 循环结构，while与for， switch(){ default} 和 c++用法一样
    public void testLoop(int flag) {
        while (0 <= flag && flag <= 10) {
            System.out.println("Flag == " + flag);
            flag++;
        }
        // new [类型][初始化数据]
        int[] tmpData = new int[] { 1, 2, 3, 4 };
        // 遍历可迭代的数组，可使用for(Type items:List )
        for (int iFlag = 0; iFlag < 4; iFlag++) {
            System.out.println("iFlag = " + tmpData[iFlag]);
        }
        for (int i : tmpData) {
            System.out.println("i = " + i);
        }

    }

    // 4. 数组类型, ArrayList
    private void testArray() {
        // 不像python，java的String类型定义后无法修改
        StringBuffer bufferString = new StringBuffer("It's buffer");
        System.out.println("BufferString" + bufferString.append("append massage"));
        // array 数组
        ArrayList<String> tmpList = new ArrayList<String>();
        tmpList.add("my tmpList ");
        tmpList.add("add ");
        tmpList.add("String");
        System.out.println(tmpList);
    }

    // 5. IO流与异常处理,使用BufferedReader创建读取流，java.io
    private void testIO() {
        // 读取控制台输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // new FileInputStream("filename")
        char c;
        System.out.println("输入q结束");
        do {
            // 输入异常处理，java通过catch捕获各类异常，有异常抛出时，会去catch匹配
            try {
                c = (char) br.read();
                System.out.println(c);
            } catch (IOException e) {
                c = 'q';
                System.out.println(e);
            }
        } while (c != 'q');
    }

}
