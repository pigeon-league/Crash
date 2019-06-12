# APP Crash 研究报告

## 1、DataFormatException

继承于java.lang.Exception

### case 1

- 堆栈关键字：

java.util.zip.DataFormatException: incorrect header check

- 发生原因：

在压缩字符串时，使用Inflater.inflate(), 当压缩的数据的内容不为Base64编码或者数据内容为空，抛出此异常。

- 原因分析：

使用Inflater.inflate()压缩数据到指定的缓冲区时, 压缩的数据的内容需要为合法的Base64编码并且数据内容不可以为空。

- 预防措施：

检查需要压缩的数据内容

### case 2

- 堆栈关键字：

java.util.zip.DataFormatException: stream error

- 发生原因：

在Android 4.4.4 使用GZipUtils工具类，进行GZip压缩时报错

- 原因分析：

由于同时使用gos.finish()  gos.flush()，导致crash，关闭了流后，继续清空缓冲区不能都同时执行。在高版本上，系统优化了相关代码。

- 预防措施： 

去掉其中一个gos.finish()  gos.flush()

## 2、FileNotFoundException

继承于java.io.IOException

### case 1

- 堆栈关键字：

java.io.FileNotFoundException: xxx.text (Read-only file system)

- 发生场景：

操作文件时，没有配置文件读写权限

- 发生原因：

没有打开文件读写权限

- 原因分析：

没有打开文件读写权限，系统读取不到相关文件

- 预防措施：

需要在mainnifest打开文件允许读写权限

### case 2

- 堆栈关键字：

java.io.FileNotFoundException: .\xx\xx.text (系统找不到指定的路径)

- 发生场景：

读取某个路径下面的文件时，出错

- 发生原因：

当前指定的文件不存在或者目录不存在

- 原因分析：

当前指定的文件不存在或者目录不存在

- 预防措施： 

进行文件读写之前，首先检查文件和目录是否存在，如果存在，则继续。

### case 3

- 堆栈关键字：

java.io.FileNotFoundException: .\xx\xx(拒绝访问)

- 发生场景：

读取某个路径下面的文件时，出错

- 发生原因：

由于访问了文件目录并没有访问文件

- 原因分析：

因为访问了文件目录并没有访问文件

- 预防措施： 

进行文件读写之前，首先检查文件填写的路径，一定要到具体的文件

## 3、CloneNotSupportedException

继承于java.lang.Exception

- 堆栈关键字：

java.lang.CloneNotSupportedException

- 发生场景：

使用Object类中的clone方法

- 发生原因：

没有实现Cloneable接口的实例

- 原因分析：

在没有实现Cloneable接口的实例上，调用Object的clone方法

- 预防措施： 

使用Object的clone方法时，需要实现Cloneable接口的实例，并且无论目标类是否实现了Cloneable接口，只要调用到了Object.clone()，比如通过super.clone()，那么就必须处理或者抛出CloneNotSupportedException，因为Object.clone()有throws这个异常。

**补充说明：**

Object.clone()按照如下步骤执行：

- (1) 检查执行此方法的当前类有没有应用Clonable接口，如果没有，抛出CloneNotSupportedException异常。
- (2) 如果当前类有应用Clonable接口，则为当前类创建一个新对象，并将原对象中的所有字段进行一次浅层拷贝（通过赋值进行）。所以如果一个目标类应用了Clonable接口但并未重写clone()方法，它“看起来”仍然可以克隆。为什么是“看起来”下面会解释。
- (3) 为什么应用了Cloneable接口的类通常还必须重写一个public的clone()方法？这里有两个原因：

- 1) 如果不重写，由于Object.clone()是proteced属性，所以这个clone()方法将无法在外部被调用，更精确地说，无法在目标类之外的任何地方调用。这样就使得克隆失去了用武之地。
- 2) Object.clone()毕竟只是提供了浅层拷贝，对于基本类型的字段，可以说它成功克隆了。但对于对象型字段，它并没有实现克隆的功能，仅仅做了一个赋值。

## 4、BufferOverflowException

继承于java.lang.RuntimeException

- 堆栈关键字：

java.nio.BufferOverflowException

- 发生场景：

使用ByteBuffer.allocate(n)分配n字节长度，但是写入数据时ByteBuffer.put(str)，数据长度超过了n长度。

- 发生原因：

由于写入长度超过了允许的长度，溢出了

- 原因分析：

使用ByteBuffer.allocate(n)分配n字节长度，但是写入数据时ByteBuffer.put(str)，数据长度超过了n长度，写入长度超过了允许的长度。

- 预防措施： 

进行写入之前，先判断写入的长度和允许的长度进行比较，保证写入的长度在允许的长度范围之内，如果不在合法范围之内，可以修改允许的长度，这样保证写入的长度合法。

## 5、NoSuchMethodException

继承于java.lang.ReflectiveOperationException

- 堆栈关键字：

java.lang.NoSuchMethodException

- 发生场景：

反射时使用getMethod获取某个方法

- 发生原因：

反射时getMethod只能调用public声明的方法

- 原因分析：

**错误原因：**

- 1、	错写方法名
- 2、	方法定义为private或者protect类型
- 3、	参数传递错误，参数传递顺序错误
- 4、	配置文件或者JAR包问题
- 预防措施： 
- 1、	检查代码中是否有此方法
- 2、	检查该方法是否为public
- 3、	检查此方法是否传递了参数，确认是否有问题
- 4、	检查JAR包

## 6、InflateException

继承于java.lang.RuntimeException

- 堆栈关键字：

android.view.InflateException

- 发生场景：

自定义布局View使用，文件名写错误，导致类名找不到，引起布局文件找不到导致异常。发生原因：
xml中使用的View组件名字和代码中的名字不一致导致

- 原因分析：

自定义布局View使用，文件名写错误或者引用的名字，不是全路径的名字，导致类名找不到，引起布局文件找不到导致异常。

- 预防措施： 

- 1)	自定义组件需要注意构造函数，默认都需要带有Context和 AttributeSet构造函数。
- 2)	如果有自定义属性，需要引入工程包名，否则自定义属性会报错。
- 3)	检查XML语法错误。
- 4)	检查布局中自定义的路径名是否正确。
- 5)	检查布局中background的样式是否引用了不兼容API Level的样式，通常在4.4系统容易遇到一些只兼容21不兼容19的样式问题。
- 6)	使用ImageView时，注意图片不要放错文件夹，就是对应分辨率的文件夹。

## 7、EnumConstantNotPresentException

继承于java.lang.RuntimeException

- 堆栈关键字：

java.lang.EnumConstantNotPresentException

- 发生场景：

当应用程序尝试按名称访问枚举常量并且枚举类型不包含具有指定名称的常量时抛出。

- 发生原因：

如果注释中的枚举常量不再出现在枚举类型中，则尝试读取枚举值成员将导致EnumConstantNotPresentException。

- 原因分析：

当应用程序尝试按名称访问枚举常量并且枚举类型不包含具有指定名称的常量时抛出。类似地，如果注释中的枚举常量不再出现在枚举类型中，则尝试读取枚举值成员将导致EnumConstantNotPresentException。

- 预防措施： 

使用时需要注意枚举常量需要在枚举类型中。

## 8、FileUriExposedException

继承于java.lang.RuntimeException

- 堆栈关键字：

android.os.FileUriExposedException

- 发生场景：

- 1) targetSdkVersion 高于等于24时，使用相机拍照保存时出现异常。
- 2) targetSdkVersion 高于等于24时，使用系统自带图库打开APP中的图片时出现异常。

- 发生原因：

从android7.0开始，谷歌收回了访问文件权限，即应用需要提供文件给其他APP使用时，需要授予访问权限。

- 原因分析：

如果当API为24或者更高版本时，需要使用FileProvider类授予对特定文件或文件夹的访问权限，使得应用程序可以访问这些文件或者文件夹。

- 预防措施： 

- 1)	在Manifest中声明FileProvider。
- 2)	在res下的xml文件夹中，新建xml文件，配置好路径。
- 3)	在代码中调用FileProvider，进行操作。

## 9、ArrayStoreException

继承于java.lang.RuntimeException

- 堆栈关键字：

java.lang.ArrayStoreException

- 发生场景：

向一个对象数组存放一错误类型的对象时的异常。例如，下面代码将产生 ArrayStoreException 异常：

```
Object x[] = new String[3];
x[0] = new Integer(0);
```

- 发生原因：

数组存储异常，当试图将类型不兼容类型的对象存入一个Object[]数组时将引发异常。

- 原因分析：

附 ArrayList中一段源码：

```
/**
 * Constructs a list containing the elements of the specified
 * collection, in the order they are returned by the collection's
 * iterator.
 *
 * @param c the collection whose elements are to be placed into this list
 * @throws NullPointerException if the specified collection is null
 */
public ArrayList(Collection<? extends E> c) {
    elementData = c.toArray();
    if ((size = elementData.length) != 0) {
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    } else {
        // replace with empty array.
        this.elementData = EMPTY_ELEMENTDATA;
    }
}
```

// c.toArray might (incorrectly) not return Object[] (see 6260652)这句注释的意义，查了一下官方的bug文档，Bug ID:JDK-6260652

注：toArray(new Object[0])函数和toArray()是相同的。但是，Arrays.asList的实现并不遵循这一点：如果用子类创建了一个数组，比方说String[]数组，它的toArray()方法将返回一个相同类型的数组（因为使用了clone()方法）而不是一个Object[]数组。
如果后来试图存储一个非String类型（或者其他类型）的数据到这个数组中，就会抛出ArrayStoreException 。

- 预防措施： 

对象数组中不能放入错误的类型对象。

## 10、TimeoutException

继承于java.lang.Exception

- 堆栈关键字：

java.util.concurrent.TimeoutException

- 发生场景：

在finalize方法中进行耗时操作。

- 发生原因：

Java对象的finalize()方法处理超时。 Java的Object对象中，有一个finalize()方法，默认实现为空。

- 原因分析：

比方说String[]数组，它的toArray()方法将返回一个相同类型的数组（因为使用了clone()方法）而不是一个Object[]数组。
当垃圾回收器确定没有对该对象的更多引用时，由垃圾回收器调用。子类重写finalize()方法以处置系统资源或执行其他清理工作。如果该方法中存在耗时操作，超过系统定义的超时时间（默认10秒，厂商也可能修改），就会抛出TimeoutException异常。

- 预防措施： 

根据实际情况分析，是否因为操作不当，在finalize()中执行了耗时操作。在应用中可以结合减少耗时操作和这种抑制finalize()超时异常的方式。另外，减少内存占用，避免不必要的对象创建，消除内存泄漏问题，减少GC压力。
