package com.lanniuh.webservice;

import com._100wit.www.HisServiceStub;
import com.lanniuh.util.PropertiesUtil;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

/**
 * Created by linjian
 * 16/9/19.
 */
public class WeChatWebservice {

    public static String invokeWeChatWebservice(String reqXml){
        try {
            String targetEndpoint = PropertiesUtil.getInstanse().getUrl();
            HisServiceStub stub = new HisServiceStub(targetEndpoint);
            ServiceClient client = stub._getServiceClient();
            Options options = stub._getServiceClient().getOptions();
            options.setManageSession(true);
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
            options.setTimeOutInMilliSeconds(1000 * 20);

            HisServiceStub.HisForHzfwhService hisForHzfwhService = new HisServiceStub.HisForHzfwhService();
            hisForHzfwhService.setInputXml(reqXml);
            HisServiceStub.HisForHzfwhServiceE hisForHzfwhServiceE = new HisServiceStub.HisForHzfwhServiceE();
            hisForHzfwhServiceE.setHisForHzfwhService(hisForHzfwhService);
            String result = stub.hisForHzfwhService(hisForHzfwhServiceE).getHisForHzfwhServiceResponse().get_return();
            client.cleanupTransport();
            client.cleanup();
            stub.cleanup();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
