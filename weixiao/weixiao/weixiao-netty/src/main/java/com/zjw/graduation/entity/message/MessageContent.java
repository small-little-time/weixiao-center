package com.zjw.graduation.entity.message;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 聊天消息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-13 15:28:37
 */
@Entity
@Table(name = "z_message_content")
@DynamicInsert
@DynamicUpdate
public class MessageContent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	private Long id;
		/**
	 * 发送者主键
	 */
		@Column(name = "sender_id", nullable = false)
	private Long senderId;
    	/**
	 * 接收者主键
	 */
		@Column(name = "receiver_id", nullable = false)
	private Long receiverId;
    	/**
	 * 内容
	 */
		@Column(name = "content", nullable = false)
	private String content;
    	/**
	 * 
	 */
		@Column(name = "sender_avatar", nullable = false)
	private String senderAvatar;
    	/**
	 * 
	 */
		@Column(name = "sender_nickname", nullable = false)
	private String senderNickname;
    	/**
	 * 是否已读 0-是 1-否
	 */
		@Column(name = "is_sign", nullable = false)
	private Integer isSign;
    	/**
	 * 消息类型 1-文字 2-图片 3-视频 ...
	 */
		@Column(name = "type", nullable = false)
	private Integer type;
    	/**
	 * 发送时间
	 */
		@Column(name = "send_time", nullable = false)
	private LocalDateTime sendTime;
    	/**
	 * 接收时间
	 */
		@Column(name = "receiver_time", nullable = false)
	private LocalDateTime receiverTime;
    	/**
	 * 逻辑删除 0-是 1-否
	 */
		@Column(name = "logic_flag", nullable = false)
	private Integer logicFlag;
    

	    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}
		    public Long getSenderId() {
        return senderId;
    }

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
		    public Long getReceiverId() {
        return receiverId;
    }

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
		    public String getContent() {
        return content;
    }

	public void setContent(String content) {
		this.content = content;
	}
		    public String getSenderAvatar() {
        return senderAvatar;
    }

	public void setSenderAvatar(String senderAvatar) {
		this.senderAvatar = senderAvatar;
	}
		    public String getSenderNickname() {
        return senderNickname;
    }

	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}
		    public Integer getIsSign() {
        return isSign;
    }

	public void setIsSign(Integer isSign) {
		this.isSign = isSign;
	}
		    public Integer getType() {
        return type;
    }

	public void setType(Integer type) {
		this.type = type;
	}
		    public LocalDateTime getSendTime() {
        return sendTime;
    }

	public void setSendTime(LocalDateTime sendTime) {
		this.sendTime = sendTime;
	}
		    public LocalDateTime getReceiverTime() {
        return receiverTime;
    }

	public void setReceiverTime(LocalDateTime receiverTime) {
		this.receiverTime = receiverTime;
	}
		    public Integer getLogicFlag() {
        return logicFlag;
    }

	public void setLogicFlag(Integer logicFlag) {
		this.logicFlag = logicFlag;
	}
	
    public Object copy() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
