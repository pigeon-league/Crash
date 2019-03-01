package com.baymax.crash.yong.invalidclassexception;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.baymax.crash.R;

import java.io.InvalidClassException;

/**
 * Created by cugyong on 2019/2/28.
 */

public class InvalidClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        TextView describe = findViewById(R.id.tv_describe);
        describe.setText("序列化就是将一个对象转换为一个字节序列（目的是能存储和传输对象）。而上面的InvalidClassException恰好就是在反序列化（将一个字节序列转换回一个对象）时会产生的。这个InvalidClassException的原因是这样的：在一个对象（比如继承自Rule类）与字节序列的相互转换中，必然需要一个标记来证明它是Rule类的对象，否则谁知道你是Rule类还是String类还是什么，那没法反序列化了。因此，Java规定了一个属性serialVersionUID来区分它们，这个属性是可以在你需要序列化的类里申明的，比如这样：\n" +
                "\n" +
                "private static final long serialVersionUID=10086L;\n" +
                "\n" +
                "设定为private是为了不被子类继承。当然了，大部分人会说我以前没写过serialVersionUID啊，都是继承了Serializable接口就没了啊，是的，当没有申明serialVersionUID的时候，JVM会自动地根据包名、类名、继承关系、非私有的方法和属性，以及参数、返回值等诸多因子计算出一个值。比如我的Exlink在2.0版本之前，它给我计算的这个值为86222585354990243L，而在2.1版本中我对Rule类做了一些修改，导致该serialVersionUID变成了-4642583507468338732L。因此虽然我做的改动并不会真的影响到反序列化，但是JVM依旧会认为这有问题，因此抛出了InvalidClassException。");

    }
}
