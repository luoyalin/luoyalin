package luoyalin;


import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendVerificationCode {
	
    public SendVerificationCode(){
    	//
    }
    //����֤�뷢�͵��û����ֻ�
    public void sendVerificationCode(String shoujihao,String yanzhengma) throws ApiException{
    	String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23532491";
		String secret = "f2d9f014bc4f40d4f00d666cdd835ae8";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    	AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
    	req.setExtend("");
    	req.setSmsType("normal");
    	req.setSmsFreeSignName("��֤��");
    	req.setSmsParamString("{number:'"+yanzhengma+"'}");
    	
    	req.setRecNum(shoujihao);      //Ŀ��绰
    	req.setSmsTemplateCode("SMS_26010247");
    	AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
    	System.out.println(rsp.getBody());
    }
    
    public static void main(String []args){
    	String yanzhengma="";
    	//������֤��
    	for (int i = 0;i < 6;i++){
			int number=(int)(Math.random()*10);
			yanzhengma = yanzhengma+number;
		}
    	
    	//�����ֻ���
    	String shoujihao=null;
    	shoujihao = "18224890834";
    	
    	//���ö��ŷ��ͺ���������֤�뷢�͵�ָ���û����ֻ���
    	SendVerificationCode send = new SendVerificationCode();
    	try {
			send.sendVerificationCode(shoujihao, yanzhengma);
		} catch (ApiException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    }
}



