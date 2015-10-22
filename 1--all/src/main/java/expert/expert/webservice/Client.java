package expert.expert.webservice;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;
/**
 * web service  客户端
 * @author Administrator
 *
 */
public class Client {

  private static final String HELLO_SERVICE_ENDPOINT = "http://lijian:8080/bjgold/service/BankService?wsdl";
  // "http://localhsot:8080/ods_ws/services/ReceiveTaxDataServices?wsdl";
  @Test
  public void callSayHelloToPerson() {
    try {
      // 创建服务
      Service service = new Service();
      // 创建调用
      Call call = (Call) service.createCall();
      // 设置 webservice 地址
      call.setTargetEndpointAddress(new java.net.URL(HELLO_SERVICE_ENDPOINT));
      // 设置 操作方法名
      call.setOperationName(new QName("http://webservice.com/", "PU0002_Service"));
      // 设置 方法参数
      call.addParameter("PU0002Request", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
      // call.addParameter("TaxNo", org.apache.axis.encoding.XMLType.XSD_STRING,
      // javax.xml.rpc.ParameterMode.IN);
      // call.addParameter("XMLData",
      // org.apache.axis.encoding.XMLType.XSD_STRING,
      // javax.xml.rpc.ParameterMode.IN);
      // 设置返回结果
      call.setReturnType(org.apache.axis.Constants.XSD_STRING);
      try {
        // 调用 穿入 参数
        String ret = (String) call.invoke(new Object[]{"ETCkey201507"});
        System.out.println("The return value is:" + ret);
        return;
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
