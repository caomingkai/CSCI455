# csci455Proj

 1. 构造的Class里，注意两点：
  	 + 不要有mutator，改变了别人的变量（而应new(param) ,拷贝一下）
  	 + 不要穿出reference，让别人改变了自己的成员变量！（而应return new 	         object／value）
 2. 回调函数callback
	   + 回调函数是供系统调用，但需要程序员给出具体函数体‘
	   + 系统只给出（或者没有）参数；程序员决定如何操作这些参数
 3. MVC system designing :ex.
  	 + control: - read in data, deliver to model
  			- get result data from model
  			- deliver result data to view
  			- get user data from view
  	 + model :  
        - read data from control, compute, give result to control	view
        - read result from control, display, give user data to control
  	 + MazeViewer: read data and sets up the graphics window with the MazeFrame. It depends on the MazeFrame.
     + MazeFrame : contains MazeComponent for displaying , and the listener to get keyboard input from the user. It creates the Maze, MazeKeyListener , and MazeComponent objects. (So it depends on those three other classes.) We wrote this class for you
  	 + MazeComponent class. This JComponent subclass displays the maze and the maze path. (It should look like the maze shown in the screenshots earlier in this document.) It gets all the information about what to display from the Maze object. Depends on Maze and MazeCoord
  	 + Maze class. This class has the data about a maze, and knows how to do a maze search. It doesn't do any I/O. Depends on MazeCoord.
  	 + MazeKeyListener class. It has the code that responds to a user's keystrokes. It's created in the MazeFrame constructor. It's an inner class of MazeFrame, so it depends on MazeFrame. We wrote this class for you. Listeners are described in a little more detail below. 
  	 + MazeCoord class. Tiny immutable class for storing coordinates for a maze location. (The code is completed for you.) This way we can store a maze path as a single LinkedList object, where each element is a MazeCoord. In addition to accessors, and toString, it also supplies an equals method. Doesn't depend on any other classes.


 1. ‘==‘ 比较的是：value与address. 如果是比较object的value，用 equals()!

 2. next() vs. nextLine()《Big Java》P524

     + next() will only return what comes before a space.
     + nextLine() automatically moves the scanner down after returning the current line.

     + "What I have noticed apart from next() scans only up to space whereas nextLine() scans the entire line is that next waits till it gets a complete token where as nextLine() does not wait for complete token, whenever '\n' is obtained(i.e when you press enter key) the scanner cursor moves to the next line and returns the previous line skipped. It does not check for the whether you have given complete input or not, even it will take an empty string where as next() does not take empty string"

 2. whenever cast mechanism is used, the parentheses is a part of cast!!!   (int)(16.8)

 3. Whenever one of the arguments of the + operator is a string, the other argument is converted to a string.
 4. Never implement a method inside another method! Especially don’t write a method inside the main() method! Java DO NOT allow nested method!
     + Solution1: write a STATIC method outside main() method, but within the same class(before or after main() is both OK). Because main() is static, which cannot call a non-static method. So the method to be implement has to be STATIC!
     + Solution2: write a local Class inside the main(). Inside the local class, implement the desired method.

 2. Scanner. in. close()??? When to use this?

 3. inherit适用的情况：subclass不能直接access到superclass中定义为private的instance variable以及method。
    - why? 或许这是java的机制问题，首先要符合标准一：private；然后标准二：extend。
    - 即便感觉这不是inherit的意思，但是总的来说，只要superclass中定义的access其private instance variable的public method，那么subclass就可以使用，这样就达到了代码reuse的目的。
    - 不要被inherit字面意思迷惑，private的instance variable以及 method并不会直接到subclass的内部；但是public的method，subclass可以直接使用

 3. superclass constructor：must be the first statement of the subclass constructor。
   ```java
    public ChoiceQuestion(String questionText)
    {
    	super(questionText);
    	choices = new ArrayList<String>;  ／／只要保证super constructor时第一个，可以跟subclass的成员变量声明
    }
   ```
 3.  polymorphism：［Dynamic method lookup］ allows us to treat objects of different classes in a uniform way.
   + all variable and method, actually are called on an object. if there is no explicit object preceding them, then it is the implicit object this abstract class/method: forces the implementors of subclasses to specify concrete implementations of this method.
	 + if there is no “abstract”, the programmer might forget, and thus get nothing to be implemented. You cannot construct objects of classes with abstract methods, you have to implement the abstract method. And you cannot construct an object of an abstract class.
	 + When you declare a method as abstract, you force programmers to provide implementations in subclasses. This is better than coming up with a default that might be inherited accidentally

 3. final  class/method: prevent other programmers from creating classes or from overriding certain methods.
	public final class String { . . . }
	  - That means that nobody can extend the String class. When you have a reference of type String, it must contain a String object, never an object of a subclass.

 3. protected variable in an object can be accessed by the methods of the object’s class and all its subclasses. For example, ChoiceQuestion inherits from Question, so its methods can access the protected instance variables of the Question superclass.
    - drawback: it is not easily to be modified, since it is shared by super and sub class
	  - [“absolute protection ”] (making instance variables private)
  	- [“no protection at all ”] (making instance variables public).
 3. Object: The Cosmic Superclass
  	- toString(), which yields a string describing the object (Section 9.5.1).
  	- equals(),  which compares objects with each other (Section 9.5.2).
  	- hashCode() , which yields a numerical code for storing the object in a set
 3. superclass  cast to subclass : instanceof => avoid dangerous cast
    ```java
      if (anObject instanceof Question)
    	{
    		Question q = (Question) anObject;
    		. . .
    	}
    ```
 3. this.getClass().getName()获得当前class的名字

 3. exception:   ” Throw Early, Catch L ate”
	 + throw : 由method 抛出 给调用者caller method（public void readData(String filename) throws FileNotFoundException）
	 + try ： 执行某一几行语句
	 + catch： 处理handle 异常exception 发生时，该做什么
		    checked exception(文件异常等非人为错误) 必须被handle
	 + finally： if an exception occurs, the finally clause is also executed before the exception is passed to its handler.意思是 exception依然会被handle，只不过被handle之前，要先执行final中的句子
	 + design a new exception：  将新的exception归类到(extend)已有的exception
     ```java
    	public class InsufficientFundsException  extends 	IllegalArgumentException
    	{
    		public InsufficientFundsException() {}
    		public InsufficientFundsException(String message)
    		{
    			super(message);
    		}
    	}
     ```
	 + assert： assert amount >= 0; 如果条件不满足，那么抛出AssertionError Exception, try catch finally;   /  java -enableassertions MainClass 只有这样的话，才能enable assert


 3. Scanner(庞大) > BufferedReader(小巧)
	   + new Scanner(BufferedReader(FileReader("xanadu.txt”)));
	   + new Scanner(new File("myNumbers"));



 3. a code snippet
    ```java
      public class MyComponent extends JComponent{
      @Override
          public void paintComponent(Graphics g)
          {
            Graphics2D g2 = (Graphics2D) g;
          }
      }

      JFrame frame = new JFrame();
      frame.setSize(300, 400);
      frame.setTitle("Two rectangles");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      RectangleComponent component = new RectangleComponent();
      frame.add(component);//加了这句之后，Frame自动调用component的paintComponent()函数而且是只要用户resize( )窗口的大小，就会重新调用paintComponent( )函数
      frame.setVisible(true);
    ```

 3. 通过return的位置，来提高效率！！如果找到值马上返回！！！
对比Fig1 比Fig2要好！！
		+ Fig1:
      ```java
        public static int linearSearch( int[] a, int x ){
            for( int i = 0; i < a.length; i++ ){
              if( a[i] == x ){
                return i;
              }
            }
            return -1;
          }
      ```
		+ Fig2:
    ```java
           public static int linearSearch( int[] a, int x ){
             int index = -1;
             for( int i = 0; i < a.length; i++ ){
                if(a[i] == x) {
                  index = i;
                }
              }
              return index;
            }
    ```
￼


 3. class VS interface
  	- class：attribute and behaviour reuse
  	- interface: algorithm reuse by other objects
  	可重用算法<－>接口<－>不同class实现该接口（才可以使用算法）
  	interface不能有instance variable，但是可以有constant variable
  	- comparable interface ： 排序接口（常用，同类排序）
  	- comparator interface ： 比较接口（不常用，异类怎么比较大小）

 21. 复制对象，而非仅仅拷贝reference
BankAccount clonedAccount = (BankAccount) account.clone();
 22. iterator object想象成 ‘光标’，就很容易理解了。
     - Iterator 是 interface,一般已经在set／map／arraylist／linkedlist中implement了
     - Iterator<String> myIter = mySet.iterator();
 23. 想要对一种DataType应用 HashSet、HashMap，来使用set／map特性时候，
必须对这种DataType(API对象: String， 或者自定义对象: Student )提供两个函数，以供hash使用：
  	 - hashcode( )
  	 - equals( )
	如果是Integer/String,不必提供； 但如果是自己构造的class，一定要现在class中implement equals( )之后，才能使用hashset<class>
 24. 想用TreeSet、TreeMap必须：
  	 - implement comparable的compareTo() method)
  	 - 生成时候就会按照comparable的方式排好序
 3. 回溯法 backtrack < —> stack Data Structure 堆栈（P700/ P730）

 25. inner class 与 its outer class
	   - structure:
       ```java
    		  public outerName{
    			  …
      			class innerName{
      				public var;
      				public method1(){}
      				public method2(){}
      			}
     	 	 }
       ```
  	 - outer class can use public var and method of inner class
  	 - inner class can use private var / method/ even inner class’s public var/ method, which belongs to outer class
