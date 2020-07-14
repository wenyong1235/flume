import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import java.util.List;

//实现Interceptor接口
public class a1 implements Interceptor {
    public void initialize(){
        // TODO自动生成的方法存根
    }
    //重写intercept(Event event)方法:拦截器的核心
    public Event intercept(Event event){
        //获得body的内容
        String eventBody = new String(event.getBody(), Charsets.UTF_8);

        JSONObject object = JSON.parseObject(eventBody);        //把body由字符串转换成json对象，这样就可以使用json函数自动生成格式
        object.put("flumeTime",System.currentTimeMillis());     //接着json对象往上加
        String objStr = JSON.toJSONString(object);              //再把json对象转化为字符串，用来输出
        event.setBody(objStr.getBytes());

//        String fmt = "flumeTime: " + System.currentTimeMillis();
//        event.setBody((eventBody+fmt).getBytes());            //将fmt加到尾部
        return event;
    }
    public List<Event> intercept(List<Event> events) {
        for (Event event : events){
            intercept(event);
        }
        return events;
    }
    public void close() {
        //TODO自动生成的方法存根
    }
}
