package cn.tao.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

//������:��һ�ִ�����ʽ
//��������������:����Ŀ������������,����Ŀ�رն�����
public class MyInterceptor implements Interceptor {
	@Override
	//��ʼ������
	public void init() {
		
	}

	@Override
	//���ط���
	public String intercept(ActionInvocation arg0) throws Exception {
		return null;
	}

	
	@Override
	//���ٷ���
	public void destroy() {
		
	}
}