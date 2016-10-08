package com.lanniuh.api;

import cn.joinhealth.bean.reply.ReplyMsg;
import cn.joinhealth.bean.request.RequestMsg;

/**
 * WeChatService
 * Created by linjian
 * 16/8/18.
 */
public interface WeChatService {
    public ReplyMsg sendQuestionnaire(RequestMsg requestMsg);
    public ReplyMsg sendReferralReminder(RequestMsg requestMsg);
}
