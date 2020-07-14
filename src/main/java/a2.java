
import org.apache.flume.Context;
import org.apache.flume.interceptor.Interceptor;

//实现Interceptor.Builder接口
public class a2 implements Interceptor.Builder {
    private String ipAddress = null;
    //重写configure(Context context)和build()方法
    public void configure(Context context) {
    }
    public Interceptor build(){     //为了调用a1
        return new a1();
    }
}
