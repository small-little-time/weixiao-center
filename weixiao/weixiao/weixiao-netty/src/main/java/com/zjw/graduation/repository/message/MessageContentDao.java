package com.zjw.graduation.repository.message;

import com.zjw.graduation.entity.message.MessageContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 聊天消息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-13 15:28:37
 */

@Repository("MessageContentDao")
public interface MessageContentDao extends JpaRepository<MessageContent, Long>, JpaSpecificationExecutor<MessageContent> {

    List<MessageContent> findAllByReceiverIdAndIsSignIsAndLogicFlagIs(Long id,int is, int i);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE " +
                    "z_message_content " +
                    "SET " +
                    "is_sign = 0 " +
                    "WHERE " +
                    "id IN :ids")
    void batchSign(@Param("ids") List<Long> ids);
}

